/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Delegat;
import domain.DomainObject;
import domain.Predavac;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Milan
 */
public class PretraziPredavaca extends AbstractSO{
    private List<Predavac> predavaci;
    
    public PretraziPredavaca() throws Exception {
        super();
    }

    public List<Predavac> getPredavaci() {
        return predavaci;
    }


    @Override
    protected void executeOperation(Object object) throws Exception {

        List<DomainObject> domainObjects = databaseBroker.pretrazi((DomainObject) object);

        // Prilagodi listu DomainObject u listu klijenata
        predavaci = new ArrayList<>();
        for (DomainObject domainObject : domainObjects) {
            if (domainObject instanceof Predavac) {
                predavaci.add((Predavac) domainObject);
            }
        }

        if (predavaci.isEmpty()) {
            throw new Exception("Predavaci ne postoje.");
        }
    }
    
    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Predavac)) {
            throw new Exception("Object is not valid");
        }
    }
}
