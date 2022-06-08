/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package pharma.future;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author salvatore spezia
 */
public class SchermataElencoConsegne extends javax.swing.JFrame {

    /** Creates new form SchermataElencoConsegne */
    public SchermataElencoConsegne() {
        initComponents();
        this.riempiTabella();
    }
    
    Connection Con = null;
    Statement St = null;
    ResultSet Rs = null;

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabellaConsegne = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        IDConsegnaText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        IDOrdineText = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        NomeFarmaciaText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        IndirizzoText = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        ConfermaBtn = new javax.swing.JButton();
        HomeBtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        CodiceFirmaText = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 128, 0));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pharma-Future Management System");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Elenco consegne");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(389, 389, 389)
                        .addComponent(jLabel3)))
                .addContainerGap(750, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        TabellaConsegne.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TabellaConsegne.setForeground(new java.awt.Color(0, 128, 0));
        TabellaConsegne.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID consegna", "ID ordine", "Farmacia", "Indirizzo"
            }
        ));
        TabellaConsegne.setIntercellSpacing(new java.awt.Dimension(5, 5));
        TabellaConsegne.setRowHeight(35);
        TabellaConsegne.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabellaConsegneMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabellaConsegne);

        jPanel3.setBackground(new java.awt.Color(0, 128, 0));
        jPanel3.setForeground(new java.awt.Color(0, 128, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1104, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jLabel7.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 128, 0));
        jLabel7.setText("ID consegna");

        IDConsegnaText.setEditable(false);
        IDConsegnaText.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 128, 0));
        jLabel2.setText("ID ordine");

        IDOrdineText.setEditable(false);
        IDOrdineText.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 128, 0));
        jLabel6.setText("Nome farmacia");

        NomeFarmaciaText.setEditable(false);
        NomeFarmaciaText.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 128, 0));
        jLabel4.setText("Indirizzo");

        IndirizzoText.setEditable(false);
        IndirizzoText.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 128, 0));
        jLabel5.setText("Seleziona la consegna");

        ConfermaBtn.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        ConfermaBtn.setForeground(new java.awt.Color(0, 128, 0));
        ConfermaBtn.setText("Conferma");
        ConfermaBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ConfermaBtnMouseClicked(evt);
            }
        });
        ConfermaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfermaBtnActionPerformed(evt);
            }
        });

        HomeBtn.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        HomeBtn.setForeground(new java.awt.Color(0, 128, 0));
        HomeBtn.setText("Home");
        HomeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeBtnMouseClicked(evt);
            }
        });
        HomeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeBtnActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 128, 0));
        jLabel8.setText("Inserisci codice firma");

        CodiceFirmaText.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 128, 0));
        jLabel9.setText("Firma");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(HomeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(ConfermaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(IDOrdineText)
                                        .addComponent(IndirizzoText)
                                        .addComponent(NomeFarmaciaText)
                                        .addComponent(IDConsegnaText, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(CodiceFirmaText)))))
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(673, 673, 673)
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(IDConsegnaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(IDOrdineText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NomeFarmaciaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(IndirizzoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CodiceFirmaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(HomeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ConfermaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1101, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ConfermaBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConfermaBtnMouseClicked
        int id_consegna = Integer.valueOf(IDConsegnaText.getText());
        int id_ordine = Integer.valueOf(IDOrdineText.getText());
        String nome_farmacia = NomeFarmaciaText.getText();
        String codice = CodiceFirmaText.getText();
        
        ConsegnaControl cc = new ConsegnaControl();
        if(cc.controlloFirma(codice, nome_farmacia)){
            cc.effettuaConsegna(id_ordine);
            JOptionPane.showMessageDialog(this, "Consegna effettuata");
            IDConsegnaText.setText("");
            IDOrdineText.setText("");
            NomeFarmaciaText.setText("");
            IndirizzoText.setText("");
            CodiceFirmaText.setText("");
            this.riempiTabella();
        }else{
            JOptionPane.showMessageDialog(this, "Codice firma errato");
            CodiceFirmaText.setText("");
        }
    }//GEN-LAST:event_ConfermaBtnMouseClicked

    private void HomeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeBtnMouseClicked
        new SchermataPrincipaleCorriere().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_HomeBtnMouseClicked

    private void HomeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HomeBtnActionPerformed

    private void ConfermaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfermaBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ConfermaBtnActionPerformed

    private void TabellaConsegneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabellaConsegneMouseClicked
        DefaultTableModel model = (DefaultTableModel) TabellaConsegne.getModel();
        int Myindex = TabellaConsegne.getSelectedRow();
        IDConsegnaText.setText(model.getValueAt(Myindex, 0).toString());
        IDOrdineText.setText(model.getValueAt(Myindex, 1).toString());
        NomeFarmaciaText.setText(model.getValueAt(Myindex, 2).toString());
        IndirizzoText.setText(model.getValueAt(Myindex, 3).toString());
    }//GEN-LAST:event_TabellaConsegneMouseClicked
    
    public void riempiTabella(){
        LocalDateTime oggi = LocalDateTime.now();  
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
        String formatDateTime = oggi.format(format); 
        int i = 0;
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3308/pharma_future", "salvo", "root");
            St = Con.createStatement();
            // LA RIGA SOTTO COMMENTATA E' QUELLA CORRETTA -> CONSEGNE GIORNALIERE (DA DECOMMENTARE)
            //Rs = St.executeQuery("select consegna.id_consegna, consegna.ref_ordine, farmacia.nome, farmacia.indirizzo from consegna, farmacia where consegna.ref_farmacia = farmacia.id_farmacia and and consegna.consegnata=0 and consegna.data_consegna=" + formatDateTime);
            Rs = St.executeQuery("select consegna.id_consegna, consegna.ref_ordine, farmacia.nome, farmacia.indirizzo from consegna, farmacia where consegna.ref_farmacia = farmacia.id_farmacia and consegna.consegnata=0");
            TabellaConsegne.setModel(DbUtils.resultSetToTableModel(Rs));
        }catch(SQLException e){
            e.printStackTrace();
        }
        
    }    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SchermataElencoConsegne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SchermataElencoConsegne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SchermataElencoConsegne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SchermataElencoConsegne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SchermataElencoConsegne().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CodiceFirmaText;
    private javax.swing.JButton ConfermaBtn;
    private javax.swing.JButton HomeBtn;
    private javax.swing.JTextField IDConsegnaText;
    private javax.swing.JTextField IDOrdineText;
    private javax.swing.JTextField IndirizzoText;
    private javax.swing.JTextField NomeFarmaciaText;
    private javax.swing.JTable TabellaConsegne;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
