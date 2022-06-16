/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import Koneksi.Koneksi;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/*
 *
 * @author Ervinanurul
 */
public class pengguna extends javax.swing.JFrame {
 
    Connection conngui = new Koneksi().getKoneksi();
    
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize(); 
    DefaultTableModel model;
    
    public pengguna() {
        initComponents();
        
        setLocation(d.width / 2 - getWidth() / 2, d.height / 2 - getHeight() / 2);
        
        String [] judul = {"Username","Nama Depan","Nama Belakang","Alamat"  };
        model = new DefaultTableModel(judul, 0);
        tabel_pengguna.setModel(model);
        tampilkeunn();
    }
        
     private void tampilkeunn() {
      int row = tabel_pengguna.getRowCount();
        for (int a = 0; a < row; a++) {
        model.removeRow(0);
        }
        
        try {
            conngui = Koneksi.getKoneksi();
            ResultSet rs = conngui.createStatement().executeQuery("SELECT * FROM register");
            
            while(rs.next()) {
                String data[] = {rs.getString(3), rs.getString(1), rs.getString(2), rs.getString(6)};
                model.addRow(data);
            }
                
        } catch (Exception e) {
            
        }
    }
     
      private void cariData(String key){
        try{

            String [] judul = {"Username","Nama Depan","Nama Belakang", "Alamat"  };
            model = new DefaultTableModel(null, judul);
            tabel_pengguna.setModel(model);
            
            conngui = Koneksi.getKoneksi();
            Statement stt=conngui.createStatement();
            model.getDataVector().removeAllElements();
            
            ResultSet RsProduk = stt.executeQuery("SELECT * from register WHERE namadepan LIKE '%"+key+"%' OR username LIKE '%"+key+"%'");  
            while(RsProduk.next()){
                Object[] data={
                    RsProduk.getString("username"),
                    RsProduk.getString("namadepan"),
                    RsProduk.getString("namabelakang"),
                    RsProduk.getString("alamat")
                };
               model.addRow(data);
            }                
        } catch (Exception ex) {
        System.err.println(ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_pengguna = new javax.swing.JTable();
        cari_pengguna = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        home = new javax.swing.JMenu();
        camera = new javax.swing.JMenu();
        proyektor = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        logout = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(1500, 600));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 0, 36)); // NOI18N
        jLabel1.setText("DAFTAR PENGGUNA");

        tabel_pengguna.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel_pengguna.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_penggunaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_pengguna);

        cari_pengguna.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cari_penggunaKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel4.setText("Cari");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cari_pengguna, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cari_pengguna, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(263, 263, 263))
        );

        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        home.setText("Home     ");
        home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeMouseClicked(evt);
            }
        });
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });
        jMenuBar1.add(home);

        camera.setText("Camera     ");
        camera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cameraMouseClicked(evt);
            }
        });
        jMenuBar1.add(camera);

        proyektor.setText("Proyektor     ");
        proyektor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                proyektorMouseClicked(evt);
            }
        });
        jMenuBar1.add(proyektor);

        jMenu1.setText("Pengguna    ");
        jMenuBar1.add(jMenu1);

        logout.setText("Logout");
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
        });
        jMenuBar1.add(logout);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1101, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void proyektorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_proyektorMouseClicked
        proyektor p = new proyektor();
        p.setVisible(true);
        this.dispose();
    
    }//GEN-LAST:event_proyektorMouseClicked

    private void cameraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cameraMouseClicked
        camera c = new camera();
        c.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cameraMouseClicked

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed

    }//GEN-LAST:event_homeActionPerformed

    private void homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseClicked
        home h = new home();
        h.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeMouseClicked

    private void tabel_penggunaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_penggunaMouseClicked
        
    }//GEN-LAST:event_tabel_penggunaMouseClicked

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        // TODO add your handling code here:
        login.admin_login ad_log = new login.admin_login();
        ad_log.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutMouseClicked

    private void cari_penggunaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cari_penggunaKeyReleased
        // TODO add your handling code here:
        String key=cari_pengguna.getText();
        System.out.println(key);

        if(key!=""){
            cariData(key);
        }else{
            tampilkeunn();
        }
    }//GEN-LAST:event_cari_penggunaKeyReleased

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
            java.util.logging.Logger.getLogger(pengguna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pengguna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pengguna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pengguna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pengguna().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu camera;
    private javax.swing.JTextField cari_pengguna;
    private javax.swing.JMenu home;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu logout;
    private javax.swing.JMenu proyektor;
    private javax.swing.JTable tabel_pengguna;
    // End of variables declaration//GEN-END:variables
}
