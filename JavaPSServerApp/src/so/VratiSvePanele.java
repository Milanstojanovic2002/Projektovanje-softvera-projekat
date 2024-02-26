/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Delegat;
import domain.DomainObject;
import domain.Panel;
import java.util.ArrayList;
import java.util.List;

public class VratiSvePanele extends AbstractSO{

    private List<Panel> paneli;

    public VratiSvePanele() throws Exception {
        super();
    }

    public List<Panel> getPaneli() {
        return paneli;
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
//        paneli = databaseBroker.vratiPanele();
//        if (paneli == null) {
//            throw new Exception("Paneli ne postoje.");
//        }
List<DomainObject> domainObjects = databaseBroker.getAll((DomainObject) object);

        // Prilagodi listu DomainObject u listu klijenata
        paneli = new ArrayList<>();
        for (DomainObject domainObject : domainObjects) {
            if (domainObject instanceof Panel) {
                paneli.add((Panel) domainObject);
            }
        }

        if (paneli.isEmpty()) {
            throw new Exception("Paneli ne postoje.");
        }
    }

    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Panel)) {
            throw new Exception("Object is not valid");
        }
    }
    
    
}
