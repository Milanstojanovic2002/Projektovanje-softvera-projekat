/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table.model;

import domain.Delegat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelDelegat extends AbstractTableModel {

    private List<Delegat> delegati = new ArrayList<>();
    private String[] kolone={"ime","prezime","jmbg","naziv panela","datum"};

    public TableModelDelegat(List<Delegat> delegati) {
        this.delegati = delegati;
    }

    @Override
    public int getRowCount() {
        return delegati.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Delegat d=delegati.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return d.getIme();
            case 1:
                return d.getPrezime();
            case 2:
                return d.getJmbg();
            case 3: 
                return d.getPanelid().getNaziv();
            case 4:
                return d.getPanelid().getDatum();
            default: return "n/a";
        }
    }

}
