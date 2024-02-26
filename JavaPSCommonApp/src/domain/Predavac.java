/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Predavac extends DomainObject implements Serializable {

    private int id;
    private String ime;
    private String prezime;
    private Long jmbg;
    private Panel panelid;

    public Predavac() {
    }

    public Predavac(int id, String ime, String prezime, Long jmbg, Panel panelid) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.panelid = panelid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Long getJmbg() {
        return jmbg;
    }

    public void setJmbg(Long jmbg) {
        this.jmbg = jmbg;
    }

    public Panel getPanelid() {
        return panelid;
    }

    public void setPanelid(Panel panelid) {
        this.panelid = panelid;
    }

    @Override
    public String getTableName() {
        return "predavac";
    }

    @Override
    public String getColumnsForInsert() {
        return "ime,prezime,jmbg,panelid";
    }

    @Override
    public String getParamsForInsert() {
        return "(?,?,?,?)";
    }

    @Override
    public String getParamsForUpdate() {
        return "ime=?, prezime=?, jmbg=?,panelid=? WHERE id=?";
    }

    @Override
    public void setParamsForInsert(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        if (domainObject instanceof Predavac) {
            Predavac predavac = (Predavac) domainObject;
            statement.setString(1, predavac.getIme());
            statement.setString(2, predavac.getPrezime());
            statement.setLong(3, predavac.getJmbg());
            statement.setInt(4, predavac.getPanelid().getId());
        } else {
            throw new IllegalArgumentException("Očekivan objekat tipa Predavac.");
        }
    }

    @Override
    public void setParamsForUpdate(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        if (domainObject instanceof Predavac) {
            Predavac predavac = (Predavac) domainObject;
            statement.setString(1, predavac.getIme());
            statement.setString(2, predavac.getPrezime());
            statement.setLong(3, predavac.getJmbg());
            statement.setInt(4, predavac.getPanelid().getId());
            statement.setInt(5, predavac.getId());
        } else {
            throw new IllegalArgumentException("Očekivan objekat tipa Predavac.");
        }
    }

    @Override
    public void setParamsForDelete(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        if (domainObject instanceof Predavac) {
            Predavac predavac = (Predavac) domainObject;
            statement.setInt(1, predavac.getId());
        } else {
            throw new IllegalArgumentException("Očekivan objekat tipa Predavac.");
        }
    }

    @Override
    public void setAutoIncrementPrimaryKey(int primaryKey) {
        setId(primaryKey);
    }

    @Override
    public String getParamsForDelete() {
        return " WHERE id = ?";
    }

    // proba za select
    @Override
    public String getColumnsForSelect() throws SQLException {
        return "*";
    }

    @Override
    public List<DomainObject> getParamsForSelect(ResultSet rs) throws SQLException {
        List<DomainObject> predavaci = new ArrayList<>();
        while (rs.next()) {
            Predavac predavac = new Predavac();
            predavac.setId(rs.getInt("pr.id"));
            predavac.setIme(rs.getString("ime"));
            predavac.setPrezime(rs.getString("prezime"));
            predavac.setJmbg(rs.getLong("jmbg"));
            Panel p = new Panel();
            p.setId(rs.getInt("p.id"));
            p.setNaziv(rs.getString("naziv"));
            p.setDatum(rs.getDate("datum").toLocalDate());
            predavac.setPanelid(p);

            predavaci.add(predavac);
        }
        return (List<DomainObject>) predavaci;
    }

    @Override
    public String getInnerJoin() throws SQLException {
        return "panel p ON pr.panelid=p.id";
    }

    @Override
    public String getTableName2() {
        return "predavac pr";
    }

    @Override
    public String getWhere() {
        return "id = ?";
    }

    @Override
    public String getParamsForSelect1() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setParamsForSelect(PreparedStatement statement, DomainObject domainObject) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DomainObject getParamsForSelect2(ResultSet rs, DomainObject domainObject) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<DomainObject> getParamsForSelect3(ResultSet rs, DomainObject domainObject) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getReqForSearch() {
        return "pr.ime=?";
    }

    @Override
    public void setParamsForSearch(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        if (domainObject instanceof Predavac) {
            Predavac predavac = (Predavac) domainObject;
            statement.setString(1, predavac.getIme());
        } 
        else{
            throw new IllegalArgumentException("Ocekivan objekat tipa Predavac");
        }
    }

}
