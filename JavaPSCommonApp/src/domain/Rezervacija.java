/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Milan
 */
public class Rezervacija extends DomainObject implements Serializable {

    private int id;
    private Panel panelid;
    private Sala salaid;
    private LocalDate datum;
    private LocalTime vremeOd;
    private LocalTime vremeDo;

    public Rezervacija() {
    }

    public Rezervacija(int id, Panel panelid, Sala salaid, LocalDate datum, LocalTime vremeOd, LocalTime vremeDo) {
        this.id = id;
        this.panelid = panelid;
        this.salaid = salaid;
        this.datum = datum;
        this.vremeOd = vremeOd;
        this.vremeDo = vremeDo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Panel getPanelid() {
        return panelid;
    }

    public void setPanelid(Panel panelid) {
        this.panelid = panelid;
    }

    public Sala getSalaid() {
        return salaid;
    }

    public void setSalaid(Sala salaid) {
        this.salaid = salaid;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public LocalTime getVremeOd() {
        return vremeOd;
    }

    public void setVremeOd(LocalTime vremeOd) {
        this.vremeOd = vremeOd;
    }

    public LocalTime getVremeDo() {
        return vremeDo;
    }

    public void setVremeDo(LocalTime vremeDo) {
        this.vremeDo = vremeDo;
    }

    @Override
    public String toString() {
        return "Rezervacija{" + "id=" + id + ", panelid=" + panelid + ", salaid=" + salaid + ", datum=" + datum + ", vremeOd=" + vremeOd + ", vremeDo=" + vremeDo + '}';
    }

    @Override
    public String getTableName() {
        return "rezervacija";
    }

    @Override
    public String getColumnsForInsert() {
        return "panelid,salaid,datum,vremeOd,vremeDo";
    }

    @Override
    public String getParamsForInsert() {
        return "(?,?,?,?,?)";
    }

    @Override
    public String getParamsForUpdate() {
        return "panelid = ?, salaid = ?, datum = ?, vremeOd = ?, vremeDo = ? WHERE id=?";
    }

    @Override
    public void setParamsForInsert(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        if (domainObject instanceof Rezervacija) {
            Rezervacija r = (Rezervacija) domainObject;
            statement.setDate(3, java.sql.Date.valueOf(r.getDatum()));
            statement.setTime(4, Time.valueOf(r.getVremeOd()));
            statement.setTime(5, Time.valueOf(r.getVremeDo()));
            statement.setInt(2, r.getSalaid().getId());
            statement.setInt(1, r.getPanelid().getId());
        } else {
            throw new IllegalArgumentException("Ocekivan objekat tipa Rezervacija");
        }

    }

    @Override
    public void setParamsForUpdate(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        if (domainObject instanceof Rezervacija) {
            Rezervacija r = (Rezervacija) domainObject;
            statement.setInt(1, r.getPanelid().getId());
            statement.setInt(2, r.getSalaid().getId());
            statement.setDate(3, java.sql.Date.valueOf(r.getDatum()));
            statement.setTime(4, Time.valueOf(r.getVremeOd()));
            statement.setTime(5, Time.valueOf(r.getVremeDo()));
            statement.setInt(6, r.getId());
        } else {
            throw new IllegalArgumentException("Očekivan objekat tipa Rezervacija.");
        }
    }

    @Override
    public void setParamsForDelete(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setAutoIncrementPrimaryKey(int primaryKey) {
        setId(primaryKey);
    }

    @Override
    public String getParamsForDelete() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getColumnsForSelect() throws SQLException {
        return "*";
    }

    @Override
    public List<DomainObject> getParamsForSelect(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }

    @Override
    public String getInnerJoin() throws SQLException {
        return "panel p ON r.panelid = p.id INNER JOIN sala s ON r.salaid=s.id WHERE r.datum = ?  ORDER BY r.vremeOd";
    }

    @Override
    public String getTableName2() {
        return "rezervacija r";
    }

    @Override
    public String getWhere() {
        return "id=?";
    }

    @Override
    public String getParamsForSelect1() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setParamsForSelect(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        if (domainObject instanceof Rezervacija) {
            Rezervacija r = (Rezervacija) domainObject;
            statement.setDate(1, java.sql.Date.valueOf(r.getDatum()));
        } else {
            throw new IllegalArgumentException("Očekivan objekat tipa Rezervacija.");
        }
    }

    @Override
    public DomainObject getParamsForSelect2(ResultSet rs, DomainObject domainObject) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<DomainObject> getParamsForSelect3(ResultSet rs, DomainObject domainObject) throws SQLException {
        List<DomainObject> domainObjects = new ArrayList<>();
        Rezervacija rezervacija = new Rezervacija();
        if (domainObject instanceof Rezervacija) {
            rezervacija = (Rezervacija) domainObject;
        }
        while (rs.next()) {
            Rezervacija r = new Rezervacija();

            r.setId(rs.getInt("r.id"));
            r.setDatum(rezervacija.getDatum());
            Panel p = new Panel();
            p.setId(rs.getInt("p.id"));
            p.setNaziv(rs.getString("p.naziv"));
            r.setPanelid(p);
            Sala s = new Sala();
            s.setId(rs.getInt("s.id"));
            s.setNaziv(rs.getString("s.naziv"));
            s.setKapacitet(rs.getInt("s.kapacitet"));
            s.setTipSale(TipSale.valueOf(rs.getString("s.tipSale")));
            r.setSalaid(s);
            r.setVremeOd(rs.getTime("r.vremeOd").toLocalTime());
            r.setVremeDo(rs.getTime("r.vremeDo").toLocalTime());
            domainObjects.add(r);
        }
        return domainObjects;
    }

    @Override
    public String getReqForSearch() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setParamsForSearch(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
