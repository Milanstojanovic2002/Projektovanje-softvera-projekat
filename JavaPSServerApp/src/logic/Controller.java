/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import domain.Admin;
import domain.Delegat;
import domain.Panel;
import domain.Predavac;
import domain.Rezervacija;
import domain.Sala;
import java.util.List;
import so.DodajNovogDelegata;
import so.DodajNovogPredavaca;
import so.DodajRezervacije;
import so.VratiSveDelegate;
import so.IzmeniDelegata;
import so.IzmeniPredavaca;
import so.IzmeniRezervacije;
import so.LoginAdmin;
import so.NadjiRezervacijuPremaDatumu;
import so.ObrisiDelegata;
import so.ObrisiPredavaca;
import so.PretraziDelegata;
import so.PretraziPredavaca;
import so.VratiSvePanele;
import so.VratiSvePredavace;
import so.VratiSveSale;

public class Controller {

    public Admin login(Admin admin) throws Exception {
        
        LoginAdmin loginAdmin = new LoginAdmin();
        loginAdmin.execute(admin);
        return loginAdmin.getAdmin();
    }

    public Object vratiDelegate() throws Exception {
        VratiSveDelegate vratiSveDelegate = new VratiSveDelegate();
        vratiSveDelegate.execute(new Delegat());
        return vratiSveDelegate.getDelegati();
    }

    public Object vratiPanele() throws Exception {
        VratiSvePanele vratiSvePanele = new VratiSvePanele();
        vratiSvePanele.execute(new Panel());
        return vratiSvePanele.getPaneli();
    }

    public void dodajDelegat(Delegat delegat) throws Exception {
        DodajNovogDelegata dodajNovogDelegata = new DodajNovogDelegata();
        dodajNovogDelegata.execute(delegat);
    }

    public void obrisiDelegata(Delegat izabraniDelegat) throws Exception {
        ObrisiDelegata obrisiDelegata = new ObrisiDelegata();
        obrisiDelegata.execute(izabraniDelegat);
    }

    public void izmeniDelegata(Delegat izmenjenDelegat) throws Exception {
        IzmeniDelegata izmeniDelegata = new IzmeniDelegata();
        izmeniDelegata.execute(izmenjenDelegat);
    }

    public Object vratiPredavace() throws Exception {
        VratiSvePredavace vratiSvePredavace = new VratiSvePredavace();
        vratiSvePredavace.execute(new Predavac());
        return vratiSvePredavace.getPredavaci();
    }

    public void dodajPredavaca(Predavac predavac) throws Exception {

        DodajNovogPredavaca dodajNovogPredavaca = new DodajNovogPredavaca();
        dodajNovogPredavaca.execute(predavac);
    }

    public void obrisiPredavaca(Predavac izabraniPredavac) throws Exception {

        ObrisiPredavaca obrisiPredavaca = new ObrisiPredavaca();
        obrisiPredavaca.execute(izabraniPredavac);
    }

    public void izmeniPredavaca(Predavac izmenjenPredavac) throws Exception {

        IzmeniPredavaca izmeniPredavaca = new IzmeniPredavaca();
        izmeniPredavaca.execute(izmenjenPredavac);
    }
    
    public Object nadjiRezervacijuPremaDatumu(Rezervacija rezervacija) throws Exception {
        NadjiRezervacijuPremaDatumu nadji = new NadjiRezervacijuPremaDatumu();
        nadji.execute(rezervacija);
        return nadji.getRezerevacije();
    }

    public Object vratiSale() throws Exception {

        VratiSveSale sveSale = new VratiSveSale();
        sveSale.execute(new Sala());
        return sveSale.getSale();
    }

    public void dodajRezervacije(List<Rezervacija> rezervacije) throws Exception {

        try {
            DodajRezervacije rez = new DodajRezervacije();
            rez.execute(rezervacije);
        } catch (Exception e) {
            throw e;
        }
    }

    public void izmeniRezervacije(List<Rezervacija> rez) throws Exception {
        try {
            IzmeniRezervacije izmeniRezervacije = new IzmeniRezervacije();
            izmeniRezervacije.execute(rez);
        } catch (Exception e) {
            throw e;
        }
    }

    public Object pretraziDelegata(Delegat d) throws Exception{
        PretraziDelegata pretraziDelegata=new PretraziDelegata();
        pretraziDelegata.execute(d);
        return pretraziDelegata.getDelegati();
        
    }

    public Object pretraziPredavaca(Predavac p) throws Exception{
        PretraziPredavaca pretraziPredavaca=new PretraziPredavaca();
        pretraziPredavaca.execute(p);
        return pretraziPredavaca.getPredavaci();
    }
}
