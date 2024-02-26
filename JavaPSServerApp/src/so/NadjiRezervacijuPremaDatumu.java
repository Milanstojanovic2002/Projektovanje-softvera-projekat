/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Delegat;
import domain.DomainObject;
import domain.Rezervacija;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Milan
 */
public class NadjiRezervacijuPremaDatumu extends AbstractSO{

    
    private List<Rezervacija> rezerevacije;

    public NadjiRezervacijuPremaDatumu() throws Exception {
        super();
    }

    public List<Rezervacija> getRezerevacije() {
        return rezerevacije;
    }
    
    @Override
    protected void executeOperation(Object object) throws Exception {
        
        List<DomainObject> domainObjects = databaseBroker.getAllFilter((DomainObject) object);

        // Prilagodi listu DomainObject u listu klijenata
        rezerevacije = new ArrayList<>();
        for (DomainObject domainObject : domainObjects) {
            if (domainObject instanceof Rezervacija) {
                rezerevacije.add((Rezervacija) domainObject);
            }
        }

        if (rezerevacije.isEmpty()) {
            //throw new Exception("Rezervacije ne postoje.");
            System.out.println("Ne postoje rezervacije za taj datum");
        }
        
        /*rezerevacije = databaseBroker.nadjiRezervacijePremaDatumu((Rezervacija) object);
        if (rezerevacije == null) {
            throw new Exception("Rezervacije ne postoje.");
        }*/
    }

    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Rezervacija)) {
            throw new Exception("Object is not valid");
        }
    }
    
}
