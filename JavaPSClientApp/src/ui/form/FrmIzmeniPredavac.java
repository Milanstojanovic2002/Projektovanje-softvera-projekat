/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui.form;

import domain.Panel;
import domain.Predavac;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import uicontroller.Controller;

/**
 *
 * @author Milan
 */
public class FrmIzmeniPredavac extends javax.swing.JFrame {

    /**
     * Creates new form FrmIzmeniPredavac
     */
    private FrmPredavac frmPredavac;
    private Predavac izabraniPredavac;

    public FrmIzmeniPredavac(FrmPredavac frmPredavac) {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        this.frmPredavac = frmPredavac;
        izabraniPredavac = frmPredavac.getIzabraniPredavac();
        popuniCmb();
        popuniFormu();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIme = new javax.swing.JTextField();
        txtPrezime = new javax.swing.JTextField();
        txtJmbg = new javax.swing.JTextField();
        cmbPaneli = new javax.swing.JComboBox();
        btnIzmeni = new javax.swing.JButton();
        btnOdustani = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ime");

        jLabel2.setText("prezime");

        jLabel3.setText("jmbg");

        jLabel4.setText("panel");

        btnIzmeni.setText("izmeni");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        btnOdustani.setText("izadji");
        btnOdustani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdustaniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPrezime)
                                    .addComponent(txtJmbg)
                                    .addComponent(cmbPaneli, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(btnIzmeni)
                        .addGap(49, 49, 49)
                        .addComponent(btnOdustani)))
                .addContainerGap(140, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtJmbg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbPaneli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIzmeni)
                    .addComponent(btnOdustani))
                .addContainerGap(91, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdustaniActionPerformed
        dispose();
    }//GEN-LAST:event_btnOdustaniActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
        String ime = txtIme.getText();
        String prezime = txtPrezime.getText();
        String jmbg = txtJmbg.getText();
        int indeks = cmbPaneli.getSelectedIndex();
        if (validirajFormu(ime, prezime, jmbg, indeks)) {
            try {
                izabraniPredavac.setIme(txtIme.getText());
                izabraniPredavac.setPrezime(txtPrezime.getText());
                izabraniPredavac.setJmbg(Long.valueOf(txtJmbg.getText()));
                izabraniPredavac.setPanelid((Panel) cmbPaneli.getSelectedItem());
                Controller.getInstance().promeniPredavac(izabraniPredavac);
                JOptionPane.showMessageDialog(this, "Predavac changed!\nGenerated ID: [" + izabraniPredavac.getId() + "]", "Change Predavac", JOptionPane.INFORMATION_MESSAGE);
                frmPredavac.popuniTabelu();
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Predavac not changed!\n" + ex.getMessage(), "Change Predavac", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnIzmeniActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnOdustani;
    private javax.swing.JComboBox cmbPaneli;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtJmbg;
    private javax.swing.JTextField txtPrezime;
    // End of variables declaration//GEN-END:variables

    private void popuniCmb() {
        try {
            List<Panel> paneli = Controller.getInstance().vratiPanele();

            for (Panel panel : paneli) {
                cmbPaneli.addItem(panel);
            }
        } catch (Exception ex) {
            Logger.getLogger(FrmIzmeniPredavac.class.getName()).log(Level.SEVERE, null, ex);
        }
        cmbPaneli.setSelectedIndex(-1);
    }

    private void popuniFormu() {
        txtIme.setText(izabraniPredavac.getIme());
        txtPrezime.setText(izabraniPredavac.getPrezime());
        txtJmbg.setText(String.valueOf(izabraniPredavac.getJmbg()));
        if (izabraniPredavac.getPanelid().getId() != 0) {
            cmbPaneli.setSelectedIndex(izabraniPredavac.getPanelid().getId() - 1);
        }
        //cmbPaneli.setSelectedItem(izabraniDelegat.getPanelid());
//        System.out.println(izabraniDelegat.getPanelid());
    }

    private boolean validirajFormu(String ime, String prezime, String jmbg, int indeks) {
        boolean signal = true;
        if (ime.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Polje ime je prazno");
            signal = false;
        }
        if (prezime.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Polje prezime je prazno");
            signal = false;
        }
        if (jmbg.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Polje jmbg je prazno");
            signal = false;
        }

        if (indeks == -1) {
            JOptionPane.showMessageDialog(this, "Niste izabrali panel");
            signal = false;
        }

        if (!ime.isEmpty()) {
            if (ime.length() > 20) {
                JOptionPane.showMessageDialog(this, "Ime moze da sadrzi najvise 20 karkatera");
                signal = false;
            }
        }

        if (!ime.isEmpty()) {
            if (ime.length() < 4) {
                JOptionPane.showMessageDialog(this, "Ime mora da sadrzi najmanje 4 karaktera");
                signal = false;
            }
        }

        if (!prezime.isEmpty()) {
            if (prezime.length() > 20) {
                JOptionPane.showMessageDialog(this, "Prezime moze da sadrzi najvise 20 karkatera");
                signal = false;
            }
        }

        if (!prezime.isEmpty()) {
            if (prezime.length() < 4) {
                JOptionPane.showMessageDialog(this, "Prezime mora da sadrzi najmanje 4 karaktera");
                signal = false;
            }
        }

        if (!jmbg.isEmpty()) {
            if (jmbg.length() != 13) {
                JOptionPane.showMessageDialog(this, "Jmbg mora da sadrzi tacno 13 karkatera");
                signal = false;
            }
        }
        if (!jmbg.isEmpty()) {
            if (jmbg.length() == 13) {
                if (!jmbg.matches("\\d+")) {
                    JOptionPane.showMessageDialog(this, "Jmbg mora da sadrzi samo cifre");
                    signal = false;
                }
            }
        }

        if (!ime.isEmpty()) {
            if (ime.length() >= 4 && ime.length() <= 20) {
                if (!ime.matches("[a-zA-Z]+")) {
                    JOptionPane.showMessageDialog(this, "Ime mora da sadrzi samo slova");
                    signal = false;
                }
            }
        }

        if (!prezime.isEmpty()) {
            if (prezime.length() >= 4 && prezime.length() <= 20) {
                if (!prezime.matches("[a-zA-Z]+")) {
                    JOptionPane.showMessageDialog(this, "Prezime mora da sadrzi samo slova");
                    signal = false;
                }
            }
        }

        return signal;
    }
}