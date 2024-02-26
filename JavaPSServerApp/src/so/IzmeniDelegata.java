/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Delegat;


public class IzmeniDelegata extends AbstractSO{
    public IzmeniDelegata() throws Exception {
        super();
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        databaseBroker.update((Delegat) object);

    }

    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Delegat)) {
            throw new Exception("Object is not valid");
        }
        //dodatno izvrsi validaciju na vrednosti
        Delegat delegat = (Delegat) object;
        if (delegat.getIme().isEmpty()) {
            throw new Exception("Name is empty");
        }
    }
}
