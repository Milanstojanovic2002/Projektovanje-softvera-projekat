/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Delegat;
import domain.DomainObject;
import domain.Panel;
import domain.Predavac;
import java.util.ArrayList;
import java.util.List;

public class VratiSvePredavace extends AbstractSO {

    private List<Predavac> predavaci;

    public VratiSvePredavace() throws Exception {
        super();
    }

    public List<Predavac> getPredavaci() {
        return predavaci;
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
//        predavaci = databaseBroker.vratiPredavace();
//        if (predavaci == null) {
//            throw new Exception("Predavaci ne postoje.");
//        }

        List<DomainObject> domainObjects = databaseBroker.getAllWithInnerJoin((DomainObject) object);

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

