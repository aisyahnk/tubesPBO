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
public class proyektor extends javax.swing.JFrame {
 
    Connection conngui = new Koneksi().getKoneksi();
    
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize(); 
    DefaultTableModel model;
    
    public proyektor() {
        initComponents();
        
        setLocation(d.width / 2 - getWidth() / 2, d.height / 2 - getHeight() / 2);
        
        String [] judul = {"id","Nama", "Harga", "Keterangan"  };
        model = new DefaultTableModel(judul, 0);
        tabel_proyektor.setModel(model);
        tampilkeunn();
    }
    
    private void reset() {
    id.setText("");
    nama.setText("");
    harga.setText("");
    keterangan.setText("");
    }
    
     private void tampilkeunn() {
      int row = tabel_proyektor.getRowCount();
        for (int a = 0; a < row; a++) {
        model.removeRow(0);
        }
        
        try {
            conngui = Koneksi.getKoneksi();
            ResultSet rs = conngui.createStatement().executeQuery("SELECT * FROM proyektor");
            
            while(rs.next()) {
                String data[] = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
                model.addRow(data);
            }
                
        } catch (Exception e) {
            
        }
    }
     
      private void cariData(String key){
        try{

            String [] judul = {"No","Nama", "Harga", "Keterangan"  };
            model = new DefaultTableModel(null, judul);
            tabel_proyektor.setModel(model);
            
            conngui = Koneksi.getKoneksi();
            Statement stt=conngui.createStatement();
            model.getDataVector().removeAllElements();
            
            ResultSet RsProduk = stt.executeQuery("SELECT * from proyektor WHERE id LIKE '%"+key+"%' OR nama LIKE '%"+key+"%'");  
            while(RsProduk.next()){
                Object[] data={
                    RsProduk.getString("id"),
                    RsProduk.getString("Nama"),
                    RsProduk.getString("Harga"),
                    RsProduk.getString("Keterangan")
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
        jLabel2 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        txtjenis = new javax.swing.JLabel();
        harga = new javax.swing.JTextField();
        jenis1 = new javax.swing.JLabel();
        keterangan = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_proyektor = new javax.swing.JTable();
        simpan = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        batal = new javax.swing.JButton();
        cari_proyektor_admin = new javax.swing.JTextField();
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
        jLabel1.setText("DAFTAR PENYEWAAN PROYEKTOR");

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel2.setText("kode barang");

        id.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel3.setText("Nama");

        nama.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N

        txtjenis.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        txtjenis.setText("harga");

        harga.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N

        jenis1.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jenis1.setText("Keterangan");

        keterangan.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N

        tabel_proyektor.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel_proyektor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_proyektorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_proyektor);

        simpan.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        simpan.setText("SIMPAN");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        edit.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        edit.setText("EDIT");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        delete.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        batal.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        batal.setText("BATAL");
        batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalActionPerformed(evt);
            }
        });

        cari_proyektor_admin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cari_proyektor_adminKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel4.setText("Cari");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(279, 279, 279))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cari_proyektor_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(86, 86, 86))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtjenis)
                                    .addComponent(jLabel2)
                                    .addComponent(jenis1))
                                .addGap(35, 35, 35)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nama)
                            .addComponent(id)
                            .addComponent(harga)
                            .addComponent(keterangan, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(126, 126, 126)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(simpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(batal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(423, 423, 423)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jenis1)
                        .addGap(105, 105, 105))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtjenis)
                            .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(keterangan, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(batal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cari_proyektor_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

        jMenu1.setText("Pengguna     ");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
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

    }//GEN-LAST:event_proyektorMouseClicked

    private void cameraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cameraMouseClicked
        camera c = new camera();
        c.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cameraMouseClicked

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed

    }//GEN-LAST:event_homeActionPerformed

    private void homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseClicked
        // TODO add your handling code here:
        home c = new home();
        c.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeMouseClicked

    private void tabel_proyektorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_proyektorMouseClicked
        // TODO add your handling code here:

        int i = tabel_proyektor.getSelectedRow();

        if(i > - 1) {
            id.setText(model.getValueAt(i, 0).toString());

            nama.setText(model.getValueAt(i, 1).toString());

            harga.setText(model.getValueAt(i, 2).toString());

            keterangan.setText(model.getValueAt(i, 3).toString());

        }
    }//GEN-LAST:event_tabel_proyektorMouseClicked

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        // TODO add your handling code here:
        conngui = Koneksi.getKoneksi();
        try{
            
            String sql = "INSERT INTO proyektor VALUES " + "(" + "'"+id.getText()+ "'," + "'"+nama.getText()+  "'," +"'"+harga.getText()+"',"+ "'"+keterangan.getText()+"'"+ ")";

            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            java.sql.PreparedStatement pst=conngui.prepareStatement(sql);
            pst.execute();
            tampilkeunn();
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
    }//GEN-LAST:event_simpanActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        
        conngui = Koneksi.getKoneksi();
        
        int ok = JOptionPane.showConfirmDialog(null,"Anda Yakin Ingin Menghapus Data "+nama.getText()+"",".:: Konfirmasi ::.", JOptionPane.YES_NO_OPTION);
        if (ok==0) {
            try {
                String sql = "DELETE FROM proyektor WHERE id = '" + id.getText() + "'";            

                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
                java.sql.PreparedStatement pst=conngui.prepareStatement(sql);
                pst.execute();
                tampilkeunn();
                reset();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Data Tidak Bisa Dihapus");
            }
            
        }
        
    }//GEN-LAST:event_deleteActionPerformed

    private void batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalActionPerformed
        // TODO add your handling code here:
         reset();
    }//GEN-LAST:event_batalActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
        conngui = Koneksi.getKoneksi();

        try {
            
           String sql = "UPDATE proyektor SET id= '" + id.getText() +"',nama = '" +nama.getText() + "', harga = '"+harga.getText()+ "', keterangan = '" + keterangan.getText() + "'" + "WHERE id = "+id.getText();
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
            java.sql.PreparedStatement pst=conngui.prepareStatement(sql);
            pst.executeUpdate(sql);
            tampilkeunn();
            reset();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }//GEN-LAST:event_editActionPerformed

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        // TODO add your handling code here:
        login.admin_login ad_log = new login.admin_login();
        ad_log.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutMouseClicked

    private void cari_proyektor_adminKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cari_proyektor_adminKeyReleased
        // TODO add your handling code here:
        String key=cari_proyektor_admin.getText();
        System.out.println(key);

        if(key!=""){
            cariData(key);
        }else{
            tampilkeunn();
        }
    }//GEN-LAST:event_cari_proyektor_adminKeyReleased

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
        pengguna p = new pengguna();
        p.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu1MouseClicked

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
            java.util.logging.Logger.getLogger(proyektor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(proyektor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(proyektor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(proyektor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new proyektor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton batal;
    private javax.swing.JMenu camera;
    private javax.swing.JTextField cari_proyektor_admin;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JTextField harga;
    private javax.swing.JMenu home;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jenis1;
    private javax.swing.JTextField keterangan;
    private javax.swing.JMenu logout;
    private javax.swing.JTextField nama;
    private javax.swing.JMenu proyektor;
    private javax.swing.JButton simpan;
    private javax.swing.JTable tabel_proyektor;
    private javax.swing.JLabel txtjenis;
    // End of variables declaration//GEN-END:variables
}
