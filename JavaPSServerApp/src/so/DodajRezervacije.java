/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Rezervacija;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Milan
 */
public class DodajRezervacije extends AbstractSO{

    public DodajRezervacije() throws Exception{
        super();
    }
    
    @Override
    protected void executeOperation(Object object) throws Exception {
        List<Rezervacija> rezervacije = (List<Rezervacija>) object;

        try {
            for (Rezervacija rez : rezervacije) {
                // Ako ne uspe azuriranje jedne rezervacije, izbaci izuzetak
                if (!databaseBroker.add(rez)) {
                    throw new Exception("Neuspešno azuriranje rezervacije u bazi!");
                }
            }

            // Ako sve rezervacije prođu, commituj transakciju
            commit();
        } catch (Exception ex) {
            // Ako dođe do izuzetka, rollbackuj transakciju
            rollback();
            throw ex;
        }
    }

    @Override
    protected void validate(Object object) throws Exception {
        List<Rezervacija> rezervacije = (List<Rezervacija>) object;

        for (Rezervacija r : rezervacije) {
            if (!(r instanceof Rezervacija)) {
                throw new Exception("Object is not valid");
            }
        }
    }
    
    private void commit() throws SQLException{
        databaseBroker.getConnection().commit();
    }
    
    public void rollback() throws SQLException{
        databaseBroker.getConnection().rollback();
    }
    
}
