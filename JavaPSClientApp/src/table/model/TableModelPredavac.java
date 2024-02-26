/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table.model;

import domain.Predavac;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelPredavac extends AbstractTableModel{

    private List<Predavac> predavaci=new ArrayList<>();
    private String[] kolone={"ime","prezime","jmbg","naziv panela","datum"};
    
    public TableModelPredavac(List<Predavac> predavaci){
        this.predavaci=predavaci;
    }
    
    @Override
    public int getRowCount() {
        return predavaci.size();
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
        Predavac p=predavaci.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getIme();
            case 1:
                return p.getPrezime();
            case 2:
                return p.getJmbg();
            case 3: 
                return p.getPanelid().getNaziv();
            case 4:
                return p.getPanelid().getDatum();
            default: return "n/a";
        }
    }
    
}
