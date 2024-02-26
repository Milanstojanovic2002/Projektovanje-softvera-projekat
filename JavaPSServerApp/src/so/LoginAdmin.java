/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Admin;
import domain.DomainObject;



public class LoginAdmin extends AbstractSO{

    private Admin admin;

    public LoginAdmin() throws Exception {
        super();
    }
    
    @Override
    protected void executeOperation(Object object) throws Exception {
        
        
        DomainObject domainObject=databaseBroker.getAdmin((DomainObject)object);
        if (domainObject instanceof Admin) {
            admin=(Admin)domainObject;
        }
        
        /*admin = (Admin) databaseBroker.getAdmin((Admin) object);
        if (admin == null) {
            throw new Exception("Korisnik ne postoji.");
        }*/
    }

    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Admin)) {
            throw new Exception("Object is not valid");
        }
    }

    public Admin getAdmin() {
        return admin;
    }

    
}
