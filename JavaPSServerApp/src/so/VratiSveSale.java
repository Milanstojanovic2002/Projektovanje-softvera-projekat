/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Delegat;
import domain.DomainObject;
import domain.Panel;
import domain.Sala;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Milan
 */
public class VratiSveSale extends AbstractSO {

    private List<Sala> sale;

    public VratiSveSale() throws Exception {
        super();
    }

    public List<Sala> getSale() {
        return sale;
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
//        sale = databaseBroker.vratiSale();
//        if (sale == null) {
//            throw new Exception("Sale ne postoje.");
//        }
        List<DomainObject> domainObjects = databaseBroker.getAll((DomainObject) object);
        sale = new ArrayList<>();
        for (DomainObject domainObject : domainObjects) {
            if (domainObject instanceof Sala) {
                sale.add((Sala) domainObject);
            }
        }

        if (sale.isEmpty()) {
            throw new Exception("Sale ne postoje.");
        }
    }

    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Sala)) {
            throw new Exception("Object is not valid");
        }
    }
}
