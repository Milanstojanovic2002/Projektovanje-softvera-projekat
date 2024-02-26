/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread;

import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.Sender;
import domain.Admin;
import domain.Delegat;
import domain.Predavac;
import domain.Rezervacija;
import java.net.Socket;
import java.util.List;
import logic.Controller;
import server.Server;


public class ClientThread extends Thread {

    private final Socket clientSocket;
    private Sender sender;
    private Receiver receiver;
    private Controller controller;
    //private Employee employee;
    private Server server;

    private boolean kraj=false;
    private Admin admin;

    public ClientThread(Socket clientSocket, Server server) {
        this.clientSocket = clientSocket;
        sender = new Sender(clientSocket);
        receiver = new Receiver(clientSocket);
        controller = new Controller();
        this.server = server;
    }

    @Override
    public void run() {

        while (!kraj) {
            try {
                Request request = (Request) receiver.receive();
                Response response = new Response();

                try {
                    switch (request.getOperation()) {
                        case LOGIN:
                            Admin admin = (Admin) request.getArgument();
                            //Proveri da li employee vec ne postoji u listi
                            if (server.notLogin(admin)) {
                                response.setResult(controller.login(admin));
                                this.admin = admin;
                            } else {
                                throw new Exception("User je vec prijavljen.");
                                //to do
                            }
                            break;

                        case VRATI_SVE_DELEGATE:
                            response.setResult(controller.vratiDelegate());
                            break;
                        case VRATI_SVE_PANELE:
                            response.setResult(controller.vratiPanele());
                            break;
                        case DODAJ_DELEGATA:
                            Delegat delegat = (Delegat) request.getArgument();
                            controller.dodajDelegat(delegat);
                            response.setResult(delegat);
                            break;
                        case OBRISI_DELEGATA:
                            Delegat izabraniDelegat = (Delegat) request.getArgument();
                            controller.obrisiDelegata(izabraniDelegat);
                            response.setResult(izabraniDelegat);
                            break;
                        case IZMENI_DELEGATA:
                            Delegat izmenjenDelegat = (Delegat) request.getArgument();
                            controller.izmeniDelegata(izmenjenDelegat);
                            response.setResult(izmenjenDelegat);
                            break;
                        case VRATI_SVE_PREDAVACE:
                            response.setResult(controller.vratiPredavace());
                            break;
                        case DODAJ_PREDAVACA:
                            Predavac predavac = (Predavac) request.getArgument();
                            controller.dodajPredavaca(predavac);
                            response.setResult(predavac);
                            break;
                        case OBRISI_PREDAVAC:
                            Predavac izabraniPredavac = (Predavac) request.getArgument();
                            controller.obrisiPredavaca(izabraniPredavac);
                            response.setResult(izabraniPredavac);
                            break;
                        case IZMENI_PREDAVAC:
                            Predavac izmenjenPredavac = (Predavac) request.getArgument();
                            controller.izmeniPredavaca(izmenjenPredavac);
                            response.setResult(izmenjenPredavac);
                            break;
                            
                        case NADJI_REZERVACIJE_PREMA_DATUMU:
                            Rezervacija rezervacija = (Rezervacija) request.getArgument();
                            response.setResult(controller.nadjiRezervacijuPremaDatumu(rezervacija));
                            break;
                        case VRATI_SVE_SALE:
                            response.setResult(controller.vratiSale());
                            break;
                        case DODAJ_REZERVACIJE:
                            List<Rezervacija> rezervacije = (List<Rezervacija>) request.getArgument();
                            controller.dodajRezervacije(rezervacije);
                            response.setResult(rezervacije);
                            break;
                        case IZMENI_REZERVACIJE:
                            List<Rezervacija> rez = (List<Rezervacija>) request.getArgument();
                            controller.izmeniRezervacije(rez);
                            response.setResult(rez);
                            break;
                        case PRETRAZI_DELEGATA:
                            Delegat d=(Delegat) request.getArgument();
                            response.setResult(controller.pretraziDelegata(d));
                            break;
                        case PRETRAZI_PREDAVACA:
                            Predavac p=(Predavac) request.getArgument();
                            response.setResult(controller.pretraziPredavaca(p));
                            break;
                        case LOGOUT:
                            setAdmin(null);
                            kraj=true;
                            break;

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    response.setException(e);
                }
                sender.send(response);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
    
    
    /*public void kraj(boolean kraj){
        this.kraj=kraj;
    }*/
    
    public void setKraj(boolean kraj) {
        this.kraj = kraj;
    }
}
