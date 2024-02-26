/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui.form;

import domain.Delegat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import table.model.TableModelDelegat;
import uicontroller.Controller;


public class FrmDelegat extends javax.swing.JFrame {

    /**
     * Creates new form FrmDelegat
     */
    List<Delegat> delegati=new ArrayList<>();
    List<Delegat> delegatiFilter = new ArrayList<>();
    Delegat izabraniDelegat;
    public FrmDelegat() {
        initComponents();
        btnFind.setVisible(false);
        try {
            delegati=Controller.getInstance().vratiSveDelegate();
        } catch (Exception ex) {
            Logger.getLogger(FrmDelegat.class.getName()).log(Level.SEVERE, null, ex);
        }
        popuniTabelu();
        delegatiFilter=delegati;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtFind = new javax.swing.JTextField();
        btnFind = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDelegat = new javax.swing.JTable();
        btnNew = new javax.swing.JButton();
        btnChange = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnOdustani = new javax.swing.JButton();
        btnNadji = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnFind.setText("nadji");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        tblDelegat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblDelegat);

        btnNew.setText("new");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnChange.setText("change");
        btnChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeActionPerformed(evt);
            }
        });

        btnDelete.setText("delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnOdustani.setText("izadji");
        btnOdustani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdustaniActionPerformed(evt);
            }
        });

        btnNadji.setText("find");
        btnNadji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNadjiActionPerformed(evt);
            }
        });

        btnReset.setText("reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnNadji)
                        .addGap(18, 18, 18)
                        .addComponent(btnReset)
                        .addGap(37, 37, 37)
                        .addComponent(btnFind)))
                .addContainerGap(86, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(btnNew)
                .addGap(66, 66, 66)
                .addComponent(btnChange)
                .addGap(63, 63, 63)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOdustani)
                .addGap(97, 97, 97))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFind)
                    .addComponent(btnNadji)
                    .addComponent(btnReset))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNew)
                    .addComponent(btnChange)
                    .addComponent(btnDelete)
                    .addComponent(btnOdustani))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        try {
            new FrmNewDelegat(this).setVisible(true);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Can not initialize view!\n" + ex.getMessage(), "New Delegat", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int row=tblDelegat.getSelectedRow();
        /*try {
            delegati = Controller.getInstance().vratiSveDelegate();
        } catch (Exception ex) {
            Logger.getLogger(FrmDelegat.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        delegati=delegatiFilter;
        if (row!=-1) {
            izabraniDelegat=delegati.get(row);
            try {
                Controller.getInstance().obrisiDelegat(izabraniDelegat);
                JOptionPane.showMessageDialog(this, "Delegat deleted!\nGenerated ID: [" + izabraniDelegat.getId()+ "]", "Delete Delegat", JOptionPane.INFORMATION_MESSAGE);
                delegati=Controller.getInstance().vratiSveDelegate();
                delegatiFilter=delegati;
                popuniTabelu();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Delegat not deleted!\n" + ex.getMessage(), "Delete Delegat", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Prvo izaberite red tabele", "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeActionPerformed
        /*try {
            delegati=Controller.getInstance().vratiSveDelegate();
        } catch (Exception ex) {
            Logger.getLogger(FrmDelegat.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        delegati=delegatiFilter;
        int row=tblDelegat.getSelectedRow();
        if (row!=-1) {
            izabraniDelegat=delegati.get(row);
            new FrmIzmeniDelegat(this).setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(this, "Prvo izaberite red tabele", "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnChangeActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        if (txtFind.getText().isEmpty()) {
            popuniTabelu();
            return;
        }
        String filter=txtFind.getText();
        for (Delegat delegat : delegati) {
            if (delegat.getIme().equals(filter)) {
                delegatiFilter.add(delegat);
            }
        }
        try {
            TableModelDelegat model=new TableModelDelegat(delegatiFilter);
            tblDelegat.setModel(model);
        } catch (Exception ex) {
            Logger.getLogger(FrmDelegat.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       delegatiFilter=new ArrayList<>();
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdustaniActionPerformed
        dispose();
    }//GEN-LAST:event_btnOdustaniActionPerformed

    private void btnNadjiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNadjiActionPerformed
        
        String filter=txtFind.getText();
        Delegat d=new Delegat();
        if (filter.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Unesite parametar");
            return;
        }
        d.setIme(filter);
        try {
            delegatiFilter=Controller.getInstance().pretraziDelegata(d);
        } catch (Exception ex) {
            //Logger.getLogger(FrmDelegat.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Delegati ne postoje");
        }
        delegati=delegatiFilter;
        popuniTabelu(delegati);
        
    }//GEN-LAST:event_btnNadjiActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        
        try {
            popuniTabelu();
            delegati=Controller.getInstance().vratiSveDelegate();
            delegatiFilter=delegati;
        } catch (Exception ex) {
            Logger.getLogger(FrmDelegat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnResetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChange;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnNadji;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnOdustani;
    private javax.swing.JButton btnReset;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDelegat;
    private javax.swing.JTextField txtFind;
    // End of variables declaration//GEN-END:variables

    public void popuniTabelu() {
        try {
            delegati=Controller.getInstance().vratiSveDelegate();
            TableModelDelegat model=new TableModelDelegat(Controller.getInstance().vratiSveDelegate());
            tblDelegat.setModel(model);
            delegatiFilter=delegati;
        } catch (Exception ex) {
            Logger.getLogger(FrmDelegat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void popuniTabelu(List<Delegat> delegati){
        try {
            try {
                TableModelDelegat modeldelegat = new TableModelDelegat(delegati);
                tblDelegat.setModel(modeldelegat);
            } catch (Exception ex) {
                System.out.println("Tabela nije uspesno popunjena");
                ex.printStackTrace();
            }

        } catch(Exception e){
            
        }

    }

    public Delegat getIzabraniDelegat() {
        return izabraniDelegat;
    }
}
