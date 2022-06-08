/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pharma.future;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author salvatore spezia
 */
public class SchermataPrincipaleFarmacista extends javax.swing.JFrame {
    
    Farmacia farmacia;
    //Farmacista farmacista;
    String username_farmacista = null;

    /**
     * Creates new form SchermataPrincipaleFarmacista
     */
    public SchermataPrincipaleFarmacista(String username) {
        initComponents();
        this.username_farmacista = username;
        //System.out.println("costruttore");
        this.creaSessione(username);
        new ProduzioneControl().produzioneAutomatica();
        new OrdineControl().ordiniPeriodici();
        new Thread(){
            public void run(){
                while(true){
                    Calendar cal = new GregorianCalendar();
                    int hour = cal.get(Calendar.HOUR_OF_DAY);
                    int minute = cal.get(Calendar.MINUTE);
                    //int second = cal.get(Calendar.SECOND);
                    if(hour == 20 & minute==2){
                        new SchermataCaricoOre20(farmacia).setVisible(true);
                        break;
                    }
                    try{
                        Thread.sleep(50000); // dorme 50 secondi
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
    
    private void creaSessione(String username){
        //System.out.println("creaSessione");
        AutenticazioneControl ac = new AutenticazioneControl();
        this.farmacia = ac.creaSessioneFarmacia(username);
        //System.out.println(farmacia.id);
        //System.out.println(farmacia.nome); //errore
        //System.out.println(farmacia.indirizzo);
        //System.out.println(farmacia.codice_consegna);
    }
    
    public void printFarmacia(){
        System.out.println(farmacia.id + " " + farmacia.nome + " " + farmacia.indirizzo + " " + farmacia.codice_consegna);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        DisconnettiBtn = new javax.swing.JButton();
        ordineSingoloBtn = new javax.swing.JLabel();
        ordineSingoloBtnText = new javax.swing.JLabel();
        VenditaLabel = new javax.swing.JLabel();
        VenditaIcon = new javax.swing.JLabel();
        ModificaOrdineLabel = new javax.swing.JLabel();
        ModificaOrdineIcon = new javax.swing.JLabel();
        CaricoLabel = new javax.swing.JLabel();
        CaricoIcon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 128, 0));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pharma-Future Management System");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Home Farmacista");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(411, 411, 411)
                        .addComponent(jLabel3)))
                .addContainerGap(734, Short.MAX_VALUE))
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

        jPanel3.setBackground(new java.awt.Color(0, 128, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1196, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        DisconnettiBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        DisconnettiBtn.setText("Disconnetti");
        DisconnettiBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DisconnettiBtnMouseClicked(evt);
            }
        });
        DisconnettiBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DisconnettiBtnActionPerformed(evt);
            }
        });

        ordineSingoloBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\salvatore spezia\\Documents\\NetBeansProjects\\Pharma-Future\\media\\ordine_singolo.png")); // NOI18N
        ordineSingoloBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ordineSingoloBtnMouseClicked(evt);
            }
        });

        ordineSingoloBtnText.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        ordineSingoloBtnText.setForeground(new java.awt.Color(0, 128, 0));
        ordineSingoloBtnText.setText("Ordine singolo");
        ordineSingoloBtnText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ordineSingoloBtnTextMouseClicked(evt);
            }
        });

        VenditaLabel.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        VenditaLabel.setForeground(new java.awt.Color(0, 128, 0));
        VenditaLabel.setText("Vendita");
        VenditaLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VenditaLabelMouseClicked(evt);
            }
        });

        VenditaIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\salvatore spezia\\Documents\\NetBeansProjects\\Pharma-Future\\media\\vendere.png")); // NOI18N
        VenditaIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VenditaIconMouseClicked(evt);
            }
        });

        ModificaOrdineLabel.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        ModificaOrdineLabel.setForeground(new java.awt.Color(0, 128, 0));
        ModificaOrdineLabel.setText("Rimuovi ordine");
        ModificaOrdineLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ModificaOrdineLabelMouseClicked(evt);
            }
        });

        ModificaOrdineIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\salvatore spezia\\Documents\\NetBeansProjects\\Pharma-Future\\media\\modifica_ordine.png")); // NOI18N
        ModificaOrdineIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ModificaOrdineIconMouseClicked(evt);
            }
        });

        CaricoLabel.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        CaricoLabel.setForeground(new java.awt.Color(0, 128, 0));
        CaricoLabel.setText("Carico");
        CaricoLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CaricoLabelMouseClicked(evt);
            }
        });

        CaricoIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\salvatore spezia\\Documents\\NetBeansProjects\\Pharma-Future\\media\\carico.png")); // NOI18N
        CaricoIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CaricoIconMouseClicked(evt);
            }
        });

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
                        .addGap(141, 141, 141)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(ordineSingoloBtnText)
                                .addGap(107, 107, 107)
                                .addComponent(VenditaLabel))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(ordineSingoloBtn)
                                .addGap(169, 169, 169)
                                .addComponent(VenditaIcon)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(172, 172, 172)
                                .addComponent(ModificaOrdineIcon))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(126, 126, 126)
                                .addComponent(ModificaOrdineLabel)))
                        .addGap(118, 118, 118)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(CaricoLabel)
                            .addComponent(CaricoIcon)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(467, 467, 467)
                        .addComponent(DisconnettiBtn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(ordineSingoloBtnText)
                                .addComponent(VenditaLabel))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(ordineSingoloBtn))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(VenditaIcon))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(CaricoLabel)
                            .addGap(18, 18, 18)
                            .addComponent(CaricoIcon)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ModificaOrdineLabel)
                        .addGap(18, 18, 18)
                        .addComponent(ModificaOrdineIcon)))
                .addGap(125, 125, 125)
                .addComponent(DisconnettiBtn)
                .addGap(56, 56, 56)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1112, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void DisconnettiBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DisconnettiBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DisconnettiBtnActionPerformed

    private void ordineSingoloBtnTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ordineSingoloBtnTextMouseClicked
        new SchermataOrdineSingolo(farmacia).setVisible(true);
        //this.setVisible(false);
        //this.dispose();
    }//GEN-LAST:event_ordineSingoloBtnTextMouseClicked

    private void ordineSingoloBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ordineSingoloBtnMouseClicked
        new SchermataOrdineSingolo(farmacia).setVisible(true);
    }//GEN-LAST:event_ordineSingoloBtnMouseClicked

    private void DisconnettiBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DisconnettiBtnMouseClicked
        new SchermataAccedi().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_DisconnettiBtnMouseClicked

    private void ModificaOrdineLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ModificaOrdineLabelMouseClicked
        new SchermataModificaOrdine(farmacia).setVisible(true);
    }//GEN-LAST:event_ModificaOrdineLabelMouseClicked

    private void ModificaOrdineIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ModificaOrdineIconMouseClicked
        new SchermataModificaOrdine(farmacia).setVisible(true);
    }//GEN-LAST:event_ModificaOrdineIconMouseClicked

    private void VenditaIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VenditaIconMouseClicked
        new SchermataVendita(farmacia).setVisible(true);
    }//GEN-LAST:event_VenditaIconMouseClicked

    private void VenditaLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VenditaLabelMouseClicked
        new SchermataVendita(farmacia).setVisible(true);
    }//GEN-LAST:event_VenditaLabelMouseClicked

    private void CaricoLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CaricoLabelMouseClicked
        new SchermataCarico(farmacia).setVisible(true);
    }//GEN-LAST:event_CaricoLabelMouseClicked

    private void CaricoIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CaricoIconMouseClicked
        new SchermataCarico(farmacia).setVisible(true);
    }//GEN-LAST:event_CaricoIconMouseClicked

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
            java.util.logging.Logger.getLogger(SchermataPrincipaleFarmacista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SchermataPrincipaleFarmacista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SchermataPrincipaleFarmacista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SchermataPrincipaleFarmacista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new SchermataPrincipaleFarmacista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CaricoIcon;
    private javax.swing.JLabel CaricoLabel;
    private javax.swing.JButton DisconnettiBtn;
    private javax.swing.JLabel ModificaOrdineIcon;
    private javax.swing.JLabel ModificaOrdineLabel;
    private javax.swing.JLabel VenditaIcon;
    private javax.swing.JLabel VenditaLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel ordineSingoloBtn;
    private javax.swing.JLabel ordineSingoloBtnText;
    // End of variables declaration//GEN-END:variables
}
