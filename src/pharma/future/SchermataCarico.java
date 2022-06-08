/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pharma.future;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author salvatore spezia
 */
public class SchermataCarico extends javax.swing.JFrame {
    
    Farmacia farmacia;

    /**
     * Creates new form SchermataCarico
     */
    public SchermataCarico(Farmacia farmacia) {
        initComponents();
        this.farmacia = farmacia;
        this.riempiTabellaOrdini();
    }
    
    Connection Con = null;
    Statement St = null;
    ResultSet Rs = null;

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
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabellaOrdini = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabellaLotti = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        IDOrdineText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        IDLottoText = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        ScadenzaText = new javax.swing.JTextField();
        HomeBtn = new javax.swing.JButton();
        SegnalaMancanzeBtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        QtyText = new javax.swing.JTextField();
        CaricaBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 128, 0));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pharma-Future Management System");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Carico");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(480, 480, 480)
                        .addComponent(jLabel3)))
                .addContainerGap(267, Short.MAX_VALUE))
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

        TabellaOrdini.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TabellaOrdini.setForeground(new java.awt.Color(0, 128, 0));
        TabellaOrdini.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID ordine", "ID farmaco", "Quantità"
            }
        ));
        TabellaOrdini.setIntercellSpacing(new java.awt.Dimension(5, 5));
        TabellaOrdini.setRowHeight(35);
        TabellaOrdini.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabellaOrdiniMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabellaOrdini);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 128, 0));
        jLabel5.setText("Seleziona i lotti da caricare");

        jPanel3.setBackground(new java.awt.Color(0, 128, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        TabellaLotti.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TabellaLotti.setForeground(new java.awt.Color(0, 128, 0));
        TabellaLotti.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID lotto", "Scadenza", "Quantità"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabellaLotti.setIntercellSpacing(new java.awt.Dimension(5, 5));
        TabellaLotti.setRowHeight(35);
        TabellaLotti.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabellaLottiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TabellaLotti);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 128, 0));
        jLabel6.setText("Seleziona l'ordine da caricare");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 128, 0));
        jLabel2.setText("ID ordine");

        IDOrdineText.setEditable(false);
        IDOrdineText.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 128, 0));
        jLabel4.setText("ID lotto");

        IDLottoText.setEditable(false);
        IDLottoText.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 128, 0));
        jLabel7.setText("Scadenza");

        ScadenzaText.setEditable(false);
        ScadenzaText.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N

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

        SegnalaMancanzeBtn.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        SegnalaMancanzeBtn.setForeground(new java.awt.Color(0, 128, 0));
        SegnalaMancanzeBtn.setText("Segnala mancanza");
        SegnalaMancanzeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SegnalaMancanzeBtnMouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 128, 0));
        jLabel8.setText("Quantità");

        QtyText.setEditable(false);
        QtyText.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N

        CaricaBtn.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        CaricaBtn.setForeground(new java.awt.Color(0, 128, 0));
        CaricaBtn.setText("Carica");
        CaricaBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CaricaBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(137, 137, 137))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(HomeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(83, 83, 83)
                                .addComponent(SegnalaMancanzeBtn)
                                .addGap(83, 83, 83)
                                .addComponent(CaricaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(IDOrdineText, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(IDLottoText, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ScadenzaText, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(QtyText, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IDOrdineText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(IDLottoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(ScadenzaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(QtyText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HomeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SegnalaMancanzeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CaricaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TabellaOrdiniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabellaOrdiniMouseClicked
        DefaultTableModel model = (DefaultTableModel) TabellaOrdini.getModel();
        int Myindex = TabellaOrdini.getSelectedRow();
        IDOrdineText.setText(model.getValueAt(Myindex, 0).toString());
        int id_ordine = Integer.valueOf(IDOrdineText.getText());
        this.riempiTabellaLotti(id_ordine);
    }//GEN-LAST:event_TabellaOrdiniMouseClicked

    private void HomeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeBtnMouseClicked
        this.dispose();
    }//GEN-LAST:event_HomeBtnMouseClicked

    private void HomeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HomeBtnActionPerformed

    private void SegnalaMancanzeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SegnalaMancanzeBtnMouseClicked
        if(!IDLottoText.getText().equals("")){
            int input = JOptionPane.showConfirmDialog(this, "Sei sicuro di segnalare la mancanza del lotto selezionato? Se clicchi Si verrà comunicata la mancanza della merce all'azienda e verrà annullato l'ordine.");
                if(input == 0){
                    int id_lotto_ordinato = Integer.valueOf(IDLottoText.getText());
                    CaricoControl cc = new CaricoControl();
                    cc.segnalaMancanze(id_lotto_ordinato, farmacia);
                    JOptionPane.showMessageDialog(this, "E' stata comunicata la mancanza all'azienda.");
                    this.riempiTabellaOrdini();
                    this.riempiTabellaLotti(Integer.valueOf(IDOrdineText.getText()));
                    IDLottoText.setText("");
                    ScadenzaText.setText("");
                    QtyText.setText("");
                }else if(input == 1){
                    int input2 = JOptionPane.showConfirmDialog(this, "Vuoi rimuovere lo stesso l'ordine senza segnalazione?");
                    if(input2 == 0){
                        int id_lotto_ordinato = Integer.valueOf(IDLottoText.getText());
                        CaricoControl cc = new CaricoControl();
                        cc.segnalaMancanze(id_lotto_ordinato, farmacia);
                        this.riempiTabellaLotti(Integer.valueOf(IDOrdineText.getText()));
                        IDLottoText.setText("");
                        ScadenzaText.setText("");
                        QtyText.setText("");
                    }
                }
        }else{
            JOptionPane.showMessageDialog(this, "Seleziona un lotto");
        }
    }//GEN-LAST:event_SegnalaMancanzeBtnMouseClicked

    private void CaricaBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CaricaBtnMouseClicked
        if(!IDLottoText.getText().equals("")){
            int id_lotto = Integer.valueOf(IDLottoText.getText());
            CaricoControl cc = new CaricoControl();
            cc.effettuaCarico(id_lotto, farmacia);
            JOptionPane.showMessageDialog(this, "Carico effettuato");
            this.riempiTabellaOrdini();
            this.riempiTabellaLotti(Integer.valueOf(IDOrdineText.getText()));
            IDLottoText.setText("");
            ScadenzaText.setText("");
            QtyText.setText("");
        }else{
            JOptionPane.showMessageDialog(this, "Seleziona un lotto");
        }
        
        
    }//GEN-LAST:event_CaricaBtnMouseClicked

    private void TabellaLottiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabellaLottiMouseClicked
        DefaultTableModel model = (DefaultTableModel) TabellaLotti.getModel();
        int Myindex = TabellaLotti.getSelectedRow();
        IDLottoText.setText(model.getValueAt(Myindex, 0).toString());
        ScadenzaText.setText(model.getValueAt(Myindex, 1).toString());
        QtyText.setText(model.getValueAt(Myindex, 2).toString());
    }//GEN-LAST:event_TabellaLottiMouseClicked
    
    public void riempiTabellaOrdini(){
        LocalDateTime oggi = LocalDateTime.now();  
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
        String formatDateTime = oggi.format(format); 
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3308/pharma_future", "salvo", "root");
            St = Con.createStatement();
            // DECOMMENTARE LA QUERY CORRETTA
            Rs = St.executeQuery("select id_ordine, ref_farmaco, quantita from ordine where ref_farmacia="+farmacia.id+";");
            //Rs = St.executeQuery("select ordine.id_ordine, ordine.ref_farmaco, ordine.quantita from ordine, consegna where ordine.id_ordine=consegna.ref_ordine and consegna.data_consegna="+ formatDateTime +" and ordine.ref_farmacia="+farmacia.id+";");
            if(Rs.next()){
                TabellaOrdini.setModel(DbUtils.resultSetToTableModel(Rs));
            }
            
            
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
    }
    
    public void riempiTabellaLotti(int id_ordine){
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3308/pharma_future", "salvo", "root");
            St = Con.createStatement();
            Rs = St.executeQuery("select id_lotto_ordinato, data_scadenza, quantita from lotto_ordinato where ref_ordine=" + id_ordine + ";");
            TabellaLotti.setModel(DbUtils.resultSetToTableModel(Rs));
            
            
            
            
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
            java.util.logging.Logger.getLogger(SchermataCarico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SchermataCarico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SchermataCarico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SchermataCarico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new SchermataCarico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CaricaBtn;
    private javax.swing.JButton HomeBtn;
    private javax.swing.JTextField IDLottoText;
    private javax.swing.JTextField IDOrdineText;
    private javax.swing.JTextField QtyText;
    private javax.swing.JTextField ScadenzaText;
    private javax.swing.JButton SegnalaMancanzeBtn;
    private javax.swing.JTable TabellaLotti;
    private javax.swing.JTable TabellaOrdini;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
