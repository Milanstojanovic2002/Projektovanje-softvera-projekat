/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Delegat;
import domain.Predavac;


public class IzmeniPredavaca extends AbstractSO{
    public IzmeniPredavaca() throws Exception {
        super();
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        databaseBroker.update((Predavac) object);

    }

    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Predavac)) {
            throw new Exception("Object is not valid");
        }
        //dodatno izvrsi validaciju na vrednosti
        Predavac predavac = (Predavac) object;
        if (predavac.getIme().isEmpty()) {
            throw new Exception("Name is empty");
        }
    }
}
