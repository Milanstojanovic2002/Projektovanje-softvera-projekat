/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Delegat;
import domain.DomainObject;
import java.util.ArrayList;
import java.util.List;

public class VratiSveDelegate extends AbstractSO {

    private List<Delegat> delegati;

    public VratiSveDelegate() throws Exception {
        super();
    }

    public List<Delegat> getDelegati() {
        return delegati;
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        //delegati = databaseBroker.vratiDelegate();
//        if (delegati == null) {
//            throw new Exception("Delegati ne postoje.");
//        }

        List<DomainObject> domainObjects = databaseBroker.getAllWithInnerJoin((DomainObject) object);

        // Prilagodi listu DomainObject u listu klijenata
        delegati = new ArrayList<>();
        for (DomainObject domainObject : domainObjects) {
            if (domainObject instanceof Delegat) {
                delegati.add((Delegat) domainObject);
            }
        }

        if (delegati.isEmpty()) {
            throw new Exception("Delegati ne postoje.");
        }
    }

    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Delegat)) {
            throw new Exception("Object is not valid");
        }
    }

}
