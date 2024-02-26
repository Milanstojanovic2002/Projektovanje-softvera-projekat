/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uicontroller;

import communication.Operation;
import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.Sender;
import domain.Admin;
import domain.Delegat;
import domain.Panel;
import domain.Predavac;
import domain.Rezervacija;
import domain.Sala;
import java.net.Socket;
import java.util.List;

public class Controller {

    Socket socket;
    Sender sender;
    Receiver receiver;
    private static Controller instance;

    private Controller() throws Exception {
        socket = new Socket("127.0.0.1", 9000);
        sender = new Sender(socket);
        receiver = new Receiver(socket);
    }

    public static Controller getInstance() throws Exception {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public Admin login(Admin a) throws Exception {
        Request request = new Request(Operation.LOGIN, a);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (Admin) response.getResult();
        } else {
            throw response.getException();
        }
    }

//    public List<Delegat> procitajDelegate() throws Exception {
//        Request request = new Request(Operation.VRATI_SVE_DELEGATE, null);
//        sender.send(request);
//        Response response = (Response) receiver.receive();
//        if (response.getException() == null) {
//            return (List<Delegat>) response.getResult();
//        } else {
//            throw response.getException();
//        }
//    }
    public List<Delegat> vratiSveDelegate() throws Exception {
        Request request = new Request(Operation.VRATI_SVE_DELEGATE, null);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Delegat>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public void kreirajDelegata(Delegat delegat) throws Exception {
        Request request = new Request(Operation.DODAJ_DELEGATA, delegat);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            delegat.setId(((Delegat) response.getResult()).getId());
        } else {
            throw response.getException();
        }
    }

    public List<Panel> vratiPanele() throws Exception {
        Request request = new Request(Operation.VRATI_SVE_PANELE, null);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Panel>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public void obrisiDelegat(Delegat izabraniDelegat) throws Exception {
        Request request = new Request(Operation.OBRISI_DELEGATA, izabraniDelegat);
        sender.send(request);
        Response response = (Response) receiver.receive();
    }

    public void preomeniDelegat(Delegat izabraniDelegat) throws Exception {
        Request request = new Request(Operation.IZMENI_DELEGATA, izabraniDelegat);
        sender.send(request);
        Response response = (Response) receiver.receive();
    }

    public List<Predavac> procitajPredavace() throws Exception {
        Request request = new Request(Operation.VRATI_SVE_PREDAVACE, null);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Predavac>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public void kreirajPredavaca(Predavac predavac) throws Exception {
        Request request = new Request(Operation.DODAJ_PREDAVACA, predavac);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            predavac.setId(((Predavac) response.getResult()).getId());
        } else {
            throw response.getException();
        }
    }

    public void obrisiPredavac(Predavac izabraniPredavac) throws Exception {
        Request request = new Request(Operation.OBRISI_PREDAVAC, izabraniPredavac);
        sender.send(request);
        Response response = (Response) receiver.receive();
    }

    public void promeniPredavac(Predavac izabraniPredavac) throws Exception {
        Request request = new Request(Operation.IZMENI_PREDAVAC, izabraniPredavac);
        sender.send(request);
        Response response = (Response) receiver.receive();
    }

    public List<Rezervacija> nadjiRezervacijuPoDatumu(Rezervacija rezervacija) throws Exception {
        Request request = new Request(Operation.NADJI_REZERVACIJE_PREMA_DATUMU, rezervacija);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Rezervacija>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<Sala> vratiSale() throws Exception {
        Request request = new Request(Operation.VRATI_SVE_SALE, null);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Sala>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public void dodajRezervacije(List<Rezervacija> rezervacijeZaUbacivanje) throws Exception {
        Request request = new Request(Operation.DODAJ_REZERVACIJE, rezervacijeZaUbacivanje);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            int i = 0;
            for (Rezervacija r : rezervacijeZaUbacivanje) {
                List<Rezervacija> rezervacije = (List<Rezervacija>) response.getResult();
                r.setId(rezervacije.get(i).getId());
                i++;
            }
        } else {
            throw response.getException();
        }
    }

    public void promeniRezervacije(List<Rezervacija> rezervacijeZaPromenu) throws Exception {
        Request request = new Request(Operation.IZMENI_REZERVACIJE, rezervacijeZaPromenu);
        sender.send(request);
        Response response = (Response) receiver.receive();

        if (response.getException() == null) {

        } else {
            throw response.getException();
        }
    }

    public void logout() throws Exception {
        Request request = new Request(Operation.LOGOUT, null);
        sender.send(request);
    }

    public List<Delegat> pretraziDelegata(Delegat d) throws Exception {
        Request request = new Request(Operation.PRETRAZI_DELEGATA, d);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Delegat>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<Predavac> pretraziPredavaca(Predavac p) throws Exception{
        Request request = new Request(Operation.PRETRAZI_PREDAVACA, p);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Predavac>) response.getResult();
        } else {
            throw response.getException();
        }
    }

}
