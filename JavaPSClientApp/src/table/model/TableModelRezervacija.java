/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table.model;

import domain.Rezervacija;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Milan
 */
public class TableModelRezervacija extends AbstractTableModel{

    private List<Rezervacija> rezervacije=new ArrayList<>();
    private String[] kolone={"panel","sala","datum","vreme od","vreme do"};
    public TableModelRezervacija(List<Rezervacija> rezervacije){
        this.rezervacije=rezervacije;
    }
    
    @Override
    public int getRowCount() {
        return rezervacije.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Rezervacija r=rezervacije.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return r.getPanelid();
            case 1:
                return r.getSalaid();
            case 2:
                return r.getDatum();
            case 3: 
                return r.getVremeOd();
            case 4:
                return r.getVremeDo();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    
    
}
