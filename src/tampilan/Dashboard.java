package tampilan;

import component.sidebar.Drawer;
import component.sidebar.DrawerController;
import component.sidebar.DrawerItem;
import component.sidebar.EventDrawer;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import model.KaryawanEntity;

/**
 *
 * @author Farhan
 */
public class Dashboard extends javax.swing.JFrame {

    private DrawerController drawer;
    private Font font = new Font("Segoe UI", Font.BOLD, 16);
    private JLabel lblFooter = new JLabel("@Copyright Kelompok4");
    private KaryawanEntity karyawan;
    
//    private void selectMenu(class c){
//        Object menus[] = {member1, formTransaksi1, mKategori1, mLayanan1, karyawan1, null, null}; //null pertama report, null kedua exit.
//        
//            
//    }
    
    public Dashboard(KaryawanEntity karyawan) {
        this.karyawan = karyawan;
        initComponents();
        member1.setVisible(false);
        member1.setEnabled(false);
        karyawan1.setVisible(false);
        karyawan1.setEnabled(false);
        formPromo1.setVisible(false);
        formPromo1.setEnabled(false);
        mKategori1.setVisible(false);
        mKategori1.setEnabled(false);
//        formTransaksi1.setVisible(false);
//        formTransaksi1.setEnabled(false);
        lblNamaAdmin.setText(karyawan.getNama());
        lblFooter.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        lblFooter.setForeground(Color.white);
        lblFooter.setHorizontalAlignment(SwingConstants.CENTER);
        
//        List<Object> menus = new ArrayList<>();

//        Object menuMember[] = {"Member", "/asset/group.png", member1};
//        Object menuTransaksi[] = {"Transaksi", "/asset/transaction-history.png", formTransaksi1};
//        Object menuKategori[] = {"Kategori Layanan", "/asset/self-service.png", mKategori1};
//        Object menuLayanan[] = {"Layanan", "/asset/self-service.png", mLayanan1};
//        Object menuKaryawan[] = {"Karyawan", "/asset/employees.png", karyawan1};
//        Object menuReport[] = {"Report", "/asset/report.png", null}; //report masih null
//        Object menuExit[] = {"Exit", "/asset/switch.png", null};


//        menus.add(menuMember);
//        menus.add(menuTransaksi);
//        menus.add(menuKategori);
//        menus.add(menuLayanan);
//        menus.add(menuKaryawan);
//        menus.add(menuReport);
//        menus.add(menuExit);
        
        
        
        drawer = Drawer.newDrawer(this)
                .header(new Header())
                .separator(2, new Color(173,173,173))
                .background(new Color(54, 83, 179))
                .duration(100)
                .enableScroll(true)
                .space(30)
                .itemHeight(50)
                .drawerBackground(new Color(54, 83, 179))
                .backgroundTransparent(0.2f)
                .addChild(new DrawerItem("Member")
                        .foreGround(Color.white)
                        .font(font)
                        .icon(new ImageIcon(getClass().getResource("/asset/group.png")))
                        .build())
                .addChild(new DrawerItem("Transaksi")
                        .foreGround(Color.white)
                        .font(font)
                        .icon(new ImageIcon(getClass().getResource("/asset/transaction-history.png")))
                        .build())
                .addChild(new DrawerItem("Kategori Layanan")
                        .foreGround(Color.white)
                        .font(font)
                        .icon(new ImageIcon(getClass().getResource("/asset/self-service.png")))
                        .build())
                .addChild(new DrawerItem("Layanan")
                        .foreGround(Color.white)
                        .font(font)
                        .icon(new ImageIcon(getClass().getResource("/asset/self-service.png")))
                        .build())
                .addChild(new DrawerItem("Karyawan")
                        .foreGround(Color.white)
                        .font(font)
                        .icon(new ImageIcon(getClass().getResource("/asset/employees.png")))
                        .build())
                .addChild(new DrawerItem("Report")
                        .foreGround(Color.white)
                        .font(font)
                        .icon(new ImageIcon(getClass().getResource("/asset/report.png")))
                        .build())
                .addChild(new DrawerItem("Promo")
                        .foreGround(Color.white)
                        .font(font)
                        .icon(new ImageIcon(getClass().getResource("/asset/coupon.png")))
                        .build())
                .addFooter(new DrawerItem("Exit")
                        .foreGround(Color.white)
                        .font(font)
                        .icon(new ImageIcon(getClass().getResource("/asset/switch.png")))
                        .build())
                .addFooter(lblFooter)
                .addFooter(new JLabel(" "))
                .addFooter(new JLabel(" "))
                .event(new EventDrawer(){
                    @Override
                    public void selected(int index, DrawerItem item) {
                        System.out.println(index);
                        switch (index) {
                            case 0:
                                karyawan1.setVisible(false);
                                karyawan1.setEnabled(false);
                                member1.setVisible(true);
                                member1.setEnabled(true);
                                formTransaksi1.setVisible(false);
                                formTransaksi1.setEnabled(false);
                                mLayanan1.setVisible(false);
                                mLayanan1.setEnabled(false);
                                formPromo1.setVisible(false);
                                formPromo1.setEnabled(false);
                                mKategori1.setVisible(false);
                                mKategori1.setEnabled(false);
                                break;
                            case 1:
                                karyawan1.setVisible(false);
                                karyawan1.setEnabled(false);
                                member1.setVisible(false);
                                member1.setEnabled(false);
                                formTransaksi1.setVisible(true);
                                formTransaksi1.setEnabled(true);
                                formTransaksi1.refreshList();
                                mLayanan1.setVisible(false);
                                mLayanan1.setEnabled(false);
                                formPromo1.setVisible(false);
                                formPromo1.setEnabled(false);
                                mKategori1.setVisible(false);
                                mKategori1.setEnabled(false);
                                break;
                            case 2:
                                karyawan1.setVisible(false);
                                karyawan1.setEnabled(false);
                                member1.setVisible(false);
                                member1.setEnabled(false);
                                formTransaksi1.setVisible(false);
                                formTransaksi1.setEnabled(false);
                                mLayanan1.setVisible(false);
                                mLayanan1.setEnabled(false);
                                mKategori1.setVisible(true);
                                mKategori1.setEnabled(true);
                                break;
                            case 3:
                                karyawan1.setVisible(false);
                                karyawan1.setEnabled(false);
                                member1.setVisible(false);
                                member1.setEnabled(false);
                                formTransaksi1.setVisible(false);
                                formTransaksi1.setEnabled(false);
                                mLayanan1.setVisible(true);
                                mLayanan1.setEnabled(true);
                                formPromo1.setVisible(false);
                                formPromo1.setEnabled(false);
                                mKategori1.setVisible(false);
                                mKategori1.setEnabled(false);
                                
                                mLayanan1.initComboBox();
                                break;
                            case 4:
                                member1.setVisible(false);
                                member1.setEnabled(false);
                                karyawan1.setVisible(true);
                                karyawan1.setEnabled(true);
                                formTransaksi1.setVisible(false);
                                formTransaksi1.setEnabled(false);
                                mLayanan1.setVisible(false);
                                mLayanan1.setEnabled(false);
                                formPromo1.setVisible(false);
                                formPromo1.setEnabled(false);
                                mKategori1.setVisible(false);
                                mKategori1.setEnabled(false);
                                break;
                            case 5:
                                karyawan1.setVisible(false);
                                karyawan1.setEnabled(false);
                                member1.setVisible(false);
                                member1.setEnabled(false);
                                formTransaksi1.setVisible(false);
                                formTransaksi1.setEnabled(false);
                                mLayanan1.setVisible(false);
                                mLayanan1.setEnabled(false);
                                formPromo1.setVisible(false);
                                formPromo1.setEnabled(false);
                                break;
                            case 6:
                                karyawan1.setVisible(false);
                                karyawan1.setEnabled(false);
                                member1.setVisible(false);
                                member1.setEnabled(false);
                                formTransaksi1.setVisible(false);
                                formTransaksi1.setEnabled(false);
                                mLayanan1.setVisible(false);
                                mLayanan1.setEnabled(false);
                                formPromo1.setVisible(true);
                                formPromo1.setEnabled(true);
                                mKategori1.setVisible(false);
                                mKategori1.setEnabled(false);
                                break;
                            case 7:
                                dispose();
                                new Login().setVisible(true);
                                break;
                            default:
                                throw new AssertionError();
                        }
//                        if (index == 0) {
//                            karyawan1.setVisible(false);
//                            karyawan1.setEnabled(false);
//                            member1.setVisible(true);
//                            member1.setEnabled(true);
//                        }
//                        if (index == 3) {
//                            member1.setVisible(false);
//                            member1.setEnabled(false);
//                            karyawan1.setVisible(true);
//                            karyawan1.setEnabled(true);
//                        }
                    }
                })
                .build();
        formTransaksi1.setKaryawan(karyawan);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        sideBar = new javax.swing.JLabel();
        lblNamaAdmin = new javax.swing.JLabel();
        formTransaksi1 = new tampilan.FormTransaksi();
        member1 = new tampilan.Member();
        karyawan1 = new tampilan.Karyawan();
        mLayanan1 = new tampilan.MLayanan();
        formPromo1 = new tampilan.FormPromo();
        mKategori1 = new tampilan.MKategori();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 1000));
        setPreferredSize(new java.awt.Dimension(1280, 1000));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0,0,0,100)
        );
        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);

        sideBar.setBackground(new java.awt.Color(0,0,0,0));
        sideBar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sideBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/side-bar.png"))); // NOI18N
        sideBar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sideBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sideBarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sideBarMouseEntered(evt);
            }
        });

        lblNamaAdmin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNamaAdmin.setForeground(new java.awt.Color(255, 255, 255));
        lblNamaAdmin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNamaAdmin.setText("NAMA ADMIN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sideBar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1018, Short.MAX_VALUE)
                .addComponent(lblNamaAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblNamaAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(sideBar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 40));
        getContentPane().add(formTransaksi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        member1.setBackground(new java.awt.Color(102, 102, 255));
        getContentPane().add(member1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        karyawan1.setBackground(new java.awt.Color(102, 102, 255));
        getContentPane().add(karyawan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        getContentPane().add(mLayanan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        getContentPane().add(formPromo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        getContentPane().add(mKategori1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void sideBarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sideBarMouseClicked
        if (drawer.isShow()) {
            drawer.hide();
        }else{
            drawer.show();
        }
    }//GEN-LAST:event_sideBarMouseClicked

    private void sideBarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sideBarMouseEntered
        sideBar.setBackground(new java.awt.Color(0,0,0,50));
    }//GEN-LAST:event_sideBarMouseEntered
    private int xMouse, yMouse;
    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        setLocation(x-xMouse, y-yMouse);
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_formMousePressed

//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        KaryawanEntity kr = new KaryawanEntity();
//        Dashboard db = new Dashboard(kr);
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                db.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private tampilan.FormPromo formPromo1;
    private tampilan.FormTransaksi formTransaksi1;
    private javax.swing.JPanel jPanel1;
    private tampilan.Karyawan karyawan1;
    private javax.swing.JLabel lblNamaAdmin;
    private tampilan.MKategori mKategori1;
    private tampilan.MLayanan mLayanan1;
    private tampilan.Member member1;
    private javax.swing.JLabel sideBar;
    // End of variables declaration//GEN-END:variables
}
