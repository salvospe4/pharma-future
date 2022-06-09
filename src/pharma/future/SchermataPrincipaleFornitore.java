/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pharma.future;

/**
 *
 * @author salvatore spezia
 */
public class SchermataPrincipaleFornitore extends javax.swing.JFrame {

    /**
     * Creates new form SchermataPrincipaleFornitore
     */
    public SchermataPrincipaleFornitore() {
        initComponents();
        new ProduzioneControl().produzioneAutomatica();
        new OrdineControl().ordiniPeriodici();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        InserisciFarmacoTextBtn = new javax.swing.JLabel();
        InserisciFarmacoIconBtn = new javax.swing.JLabel();
        RitardiProduzioneLabel = new javax.swing.JLabel();
        RitardiProduzioneIcon = new javax.swing.JLabel();
        DisconnettiBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 128, 0));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pharma-Future Management System");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addComponent(jLabel1)
                .addContainerGap(746, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel1)
                .addContainerGap(51, Short.MAX_VALUE))
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

        InserisciFarmacoTextBtn.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        InserisciFarmacoTextBtn.setForeground(new java.awt.Color(0, 128, 0));
        InserisciFarmacoTextBtn.setText("Inserisci farmaco");
        InserisciFarmacoTextBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InserisciFarmacoTextBtnMouseClicked(evt);
            }
        });

        InserisciFarmacoIconBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pharma/future/media/add_farmaco.png"))); // NOI18N
        InserisciFarmacoIconBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InserisciFarmacoIconBtnMouseClicked(evt);
            }
        });

        RitardiProduzioneLabel.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        RitardiProduzioneLabel.setForeground(new java.awt.Color(0, 128, 0));
        RitardiProduzioneLabel.setText("Ritardi di produzione");
        RitardiProduzioneLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RitardiProduzioneLabelMouseClicked(evt);
            }
        });

        RitardiProduzioneIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pharma/future/media/ritardo_produzione.png"))); // NOI18N
        RitardiProduzioneIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RitardiProduzioneIconMouseClicked(evt);
            }
        });

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

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pharma/future/media/home.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 128, 0));
        jLabel4.setText("Home Fornitore");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(269, 269, 269)
                .addComponent(InserisciFarmacoTextBtn)
                .addGap(185, 185, 185)
                .addComponent(RitardiProduzioneLabel))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(326, 326, 326)
                .addComponent(InserisciFarmacoIconBtn)
                .addGap(326, 326, 326)
                .addComponent(RitardiProduzioneIcon))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(348, 348, 348)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addComponent(jLabel4))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(459, 459, 459)
                .addComponent(DisconnettiBtn))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel4))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InserisciFarmacoTextBtn)
                    .addComponent(RitardiProduzioneLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(InserisciFarmacoIconBtn)
                    .addComponent(RitardiProduzioneIcon))
                .addGap(74, 74, 74)
                .addComponent(DisconnettiBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1065, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void DisconnettiBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DisconnettiBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DisconnettiBtnActionPerformed

    private void DisconnettiBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DisconnettiBtnMouseClicked
        new SchermataAccedi().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_DisconnettiBtnMouseClicked

    private void InserisciFarmacoTextBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InserisciFarmacoTextBtnMouseClicked
        new SchermataInserisciFarmaco().setVisible(true);
    }//GEN-LAST:event_InserisciFarmacoTextBtnMouseClicked

    private void RitardiProduzioneLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RitardiProduzioneLabelMouseClicked
        new RitardiProduzione().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_RitardiProduzioneLabelMouseClicked

    private void RitardiProduzioneIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RitardiProduzioneIconMouseClicked
        new RitardiProduzione().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_RitardiProduzioneIconMouseClicked

    private void InserisciFarmacoIconBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InserisciFarmacoIconBtnMouseClicked
        new SchermataInserisciFarmaco().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_InserisciFarmacoIconBtnMouseClicked

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
            java.util.logging.Logger.getLogger(SchermataPrincipaleFornitore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SchermataPrincipaleFornitore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SchermataPrincipaleFornitore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SchermataPrincipaleFornitore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SchermataPrincipaleFornitore().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DisconnettiBtn;
    private javax.swing.JLabel InserisciFarmacoIconBtn;
    private javax.swing.JLabel InserisciFarmacoTextBtn;
    private javax.swing.JLabel RitardiProduzioneIcon;
    private javax.swing.JLabel RitardiProduzioneLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
