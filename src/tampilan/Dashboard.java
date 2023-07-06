package tampilan;

import component.sidebar.Drawer;
import component.sidebar.DrawerController;
import component.sidebar.DrawerItem;
import component.sidebar.EventDrawer;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import model.KaryawanEntity;

public class Dashboard extends javax.swing.JFrame {

    private DrawerController drawer;
    private Font font = new Font("Segoe UI", Font.BOLD, 16);
    private JLabel lblFooter = new JLabel("@Copyright Kelompok4");
    private KaryawanEntity karyawan;
    
    public Dashboard(KaryawanEntity karyawan) {
        this.karyawan = karyawan;
        initComponents();
        refreshFrom(new MWelcome());
        lblNamaAdmin.setText(karyawan.getNama());
        lblFooter.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        lblFooter.setForeground(Color.white);
        lblFooter.setHorizontalAlignment(SwingConstants.CENTER);
        
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
                                refreshFrom(new Member());
                                break;
                            case 1:
                                refreshFrom(new FormTransaksi(karyawan));
                                break;
                            case 2:
                                refreshFrom(new MKategori());
                                break;
                            case 3:
                                refreshFrom(new MLayanan());
                                break;
                            case 4:
                                refreshFrom(new Karyawan());
                                break;
                            case 5:
                                refreshFrom(new MReport(karyawan));
                                break;
                            case 6:
                                refreshFrom(new FormPromo());
                                break;
                            case 7:
                                dispose();
                                new Login().setVisible(true);
                                break;
                            default:
                                throw new AssertionError();
                        }
                    }
                }
            )
        .build();
    }
    
    public static void refreshFrom(JComponent component){
        panelForm.removeAll();
        panelForm.add(component);
        panelForm.repaint();
        panelForm.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        sideBar = new javax.swing.JLabel();
        lblNamaAdmin = new javax.swing.JLabel();
        panelForm = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 920));
        setMinimumSize(new java.awt.Dimension(1280, 920));
        setPreferredSize(new java.awt.Dimension(1280, 920));
        setResizable(false);
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

        panelForm.setBackground(new java.awt.Color(0,0,0,0)
        );
        panelForm.setOpaque(false);
        panelForm.setLayout(new java.awt.BorderLayout());
        getContentPane().add(panelForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 1080));

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblNamaAdmin;
    public static javax.swing.JPanel panelForm;
    private javax.swing.JLabel sideBar;
    // End of variables declaration//GEN-END:variables
}
