/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package tampilan;

import java.sql.*;
import database.Koneksi;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import table.TableCustom;


/**
 *
 * @author Lenovo
 */
public class MLayanan extends javax.swing.JPanel {
//    public static final String TABLE_NAME = "layanan";
    private final Connection connenction = new Koneksi().connect();
    private DefaultTableModel tabmode;
    int id = 0;
    String path2 = "src/asset/produk.png";
    List<Blob> imgPreview = new ArrayList<>();

    /**
     * Creates new form MLayanan
     */
    public MLayanan() {
        initComponents();
        datatable();
        initComboBox();
        btnHapus.setVisible(false);
        btnHapus.setEnabled(false);
        TableCustom.apply(jScrollPane1, TableCustom.TableType.DEFAULT);
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if (column == 0 || column == 1) {
                    setBackground(new Color(45,105,141));
                    setForeground(Color.WHITE);
                } else {
                    setBackground(table.getBackground());
                    setForeground(table.getForeground());
                }
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                return this;
            }
        };
        header();
        renderer();
    }
    
    public final void header() {
        jTable1.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        jTable1.getTableHeader().setBackground(new Color(45, 105, 141));
        jTable1.getTableHeader().setForeground(Color.WHITE);
    }

    public final void renderer() {
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) jTable1.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        headerRenderer.setBackground(new Color(45, 105, 141));
        headerRenderer.setForeground(Color.WHITE);
    }
    
    public void datatable(){
        initComboBox();
        Object[] Baris = {"No ID", "Nama Layanan", "Harga Layanan", "Harga Point", "Kategori"};
        tabmode = new DefaultTableModel(null, Baris);
        jTable1.setModel(tabmode);
        String sql = "select "+database.Layanan.TABLE_NAME+".*, "+database.Kategori.TABLE_NAME+"."+database.Kategori.NAMA+" as kategori "
                +" from "+database.Layanan.TABLE_NAME
                +" join "+database.Kategori.TABLE_NAME+" on "+database.Kategori.TABLE_NAME+"."+database.Kategori.ID+" = "+database.Layanan.TABLE_NAME+"."+database.Layanan.ID_KATEGORI
                +" where "+database.Layanan.TABLE_NAME+"."+database.Layanan.DELETED+" = '0';";
        imgPreview = new ArrayList<>();
        try {
            java.sql.Statement stat = connenction.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            int idx = 0;
            while(hasil.next()){
                
                String a = hasil.getString("id");
                String b = hasil.getString("nama");
                String c = hasil.getString("harga");
                String d = hasil.getString("point_price");
                String e = hasil.getString("kategori");
                Blob img = hasil.getBlob("gambar");
                
                if (img == null) {
                    img = new SerialBlob(new byte[0]);
                }else{
                    img = img;
                }
                
                imgPreview.add(img);
                
                
                Object[] data = {a,b,c,d,e};
                tabmode.addRow(data);
                idx++;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR DATA TABLE :  "+e);
        }
    }
    
    public void initComboBox(){
        cb_kategori.removeAll();
        String sql = "select nama from "+database.Kategori.TABLE_NAME+" where "+database.Kategori.DELETED+" = '0';";
        try {
            java.sql.Statement stat = connenction.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
            while (hasil.next()) {
                model.addElement(hasil.getString("nama"));
            }
            cb_kategori.setModel(model);
            
        } catch (Exception e) {
        }
    }
    
    public void reset(){
        id = 0;
        txtNama.setText("");
        txtHarga.setText("");
        txtPoint.setText("");
        btnSimpan4.setText("SIMPAN");
        path2 = null;
//        imgPreview = null;
        label_gambar.setIcon(null);
        btnHapus.setVisible(false);
        btnHapus.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        jPanel6 = new javax.swing.JPanel();
        btnSimpan4 = new com.k33ptoo.components.KButton();
        btnBatal4 = new com.k33ptoo.components.KButton();
        btnHapus = new com.k33ptoo.components.KButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        txtHarga = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtPoint = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        label_gambar = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cb_kategori = new component.ComboBoxCustome();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 204));
        setMaximumSize(new java.awt.Dimension(1280, 920));
        setMinimumSize(new java.awt.Dimension(1280, 920));
        setPreferredSize(new java.awt.Dimension(1280, 920));

        kGradientPanel1.setBackground(new java.awt.Color(54, 83, 179));
        kGradientPanel1.setkBorderRadius(0);
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setMaximumSize(new java.awt.Dimension(1280, 920));
        kGradientPanel1.setMinimumSize(new java.awt.Dimension(1280, 920));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(1280, 920));

        jPanel6.setOpaque(false);

        btnSimpan4.setText("SIMPAN");
        btnSimpan4.setAlignmentY(0.0F);
        btnSimpan4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSimpan4.setkEndColor(new java.awt.Color(255, 248, 200));
        btnSimpan4.setkHoverEndColor(new java.awt.Color(255, 160, 0));
        btnSimpan4.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnSimpan4.setkHoverStartColor(new java.awt.Color(255, 248, 200));
        btnSimpan4.setkSelectedColor(new java.awt.Color(255, 255, 255));
        btnSimpan4.setkStartColor(new java.awt.Color(255, 160, 0));
        btnSimpan4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpan4btnSimpanActionPerformed(evt);
            }
        });

        btnBatal4.setText("BATAL");
        btnBatal4.setAlignmentY(0.0F);
        btnBatal4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBatal4.setkEndColor(new java.awt.Color(255, 248, 200));
        btnBatal4.setkHoverEndColor(new java.awt.Color(255, 160, 0));
        btnBatal4.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnBatal4.setkHoverStartColor(new java.awt.Color(255, 248, 200));
        btnBatal4.setkSelectedColor(new java.awt.Color(255, 255, 255));
        btnBatal4.setkStartColor(new java.awt.Color(255, 160, 0));
        btnBatal4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatal4btnBatalActionPerformed(evt);
            }
        });

        btnHapus.setText("HAPUS");
        btnHapus.setAlignmentY(0.0F);
        btnHapus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHapus.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHapus.setkEndColor(new java.awt.Color(255, 248, 200));
        btnHapus.setkHoverEndColor(new java.awt.Color(255, 51, 51));
        btnHapus.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnHapus.setkHoverStartColor(new java.awt.Color(255, 248, 200));
        btnHapus.setkSelectedColor(new java.awt.Color(255, 255, 255));
        btnHapus.setkStartColor(new java.awt.Color(255, 51, 51));
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusbtnSimpanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(512, Short.MAX_VALUE)
                .addComponent(btnSimpan4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBatal4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(360, 360, 360))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSimpan4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBatal4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/service.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("FORM LAYANAN");

        jPanel1.setOpaque(false);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nama");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Harga");

        txtNama.setBackground(new java.awt.Color(0,0,0,0));
        txtNama.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtNama.setForeground(new java.awt.Color(255, 255, 255));
        txtNama.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));

        txtHarga.setBackground(new java.awt.Color(0,0,0,0));
        txtHarga.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtHarga.setForeground(new java.awt.Color(255, 255, 255));
        txtHarga.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Harga Point");

        txtPoint.setBackground(new java.awt.Color(0,0,0,0));
        txtPoint.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtPoint.setForeground(new java.awt.Color(255, 255, 255));
        txtPoint.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Gambar Produk");

        label_gambar.setText("+ Tambahkan Gambar");
        label_gambar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        label_gambar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        label_gambar.setMaximumSize(new java.awt.Dimension(150, 120));
        label_gambar.setMinimumSize(new java.awt.Dimension(150, 120));
        label_gambar.setPreferredSize(new java.awt.Dimension(150, 120));
        label_gambar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_gambarMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Kategori");

        cb_kategori.setLightWeightPopupEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(287, 287, 287)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNama, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                    .addComponent(txtHarga)
                    .addComponent(txtPoint)
                    .addComponent(label_gambar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_kategori, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(443, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cb_kategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(label_gambar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtPoint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))))
                .addContainerGap())
            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(kGradientPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(kGradientPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1271, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpan4btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpan4btnSimpanActionPerformed
        // TODO add your handling code here:
        String sqlQuery = "INSERT INTO "+ database.Layanan.TABLE_NAME +" values(?,?,?,?,?,?,?)";
        if (id != 0) {
            sqlQuery = "UPDATE "+ database.Layanan.TABLE_NAME +" SET nama=?, harga=?, point_price=?, gambar=?, id_kategori=? WHERE id="+id;
        }
        PreparedStatement stat = null;
        String sql = "select id from "+database.Kategori.TABLE_NAME+" where "+database.Kategori.NAMA+" = '"+cb_kategori.getSelectedItem().toString()+"' AND "+database.Kategori.DELETED+" = '0';";
        int id_kat = 0;
        try {
            java.sql.Statement stat2 = connenction.createStatement();
            ResultSet hasil = stat2.executeQuery(sql);
            hasil.next();
            id_kat = hasil.getInt("id");
            JOptionPane.showMessageDialog(null, "ID KATEGORI : "+id_kat);

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "GAGAl AMBIL ID KATEGORI"+e);

        }
        try {
            stat = connenction.prepareStatement(sqlQuery);
            InputStream file = new FileInputStream(new File(path2));


            if (id != 0) {
                stat.setString(1, txtNama.getText());
                stat.setString(2, txtHarga.getText());
                stat.setString(3, txtPoint.getText());
                stat.setBlob(4, file);
                stat.setInt(5, id_kat);

            }else{
                stat.setString(1, Integer.toString(id));
                stat.setString(2, txtNama.getText());
                stat.setString(3, txtHarga.getText());
                stat.setString(4, txtPoint.getText());
                stat.setInt(5, id_kat);
                stat.setBlob(6, file);
                stat.setInt(7, 0);


            }
            stat.executeUpdate();
            datatable();
            if (id != 0) {
                JOptionPane.showMessageDialog(null, "Layanan update : "+txtNama.getText()+", Berhasil diedit");
            }else{
                JOptionPane.showMessageDialog(null, "Layanan baru : "+txtNama.getText()+", Berhasil ditambahkan");
            }

            reset();
        } catch (HeadlessException | SQLException e) {
            if (id != 0) {
                id = 0;
                JOptionPane.showMessageDialog(null, "Member update : "+txtNama.getText()+", Gagal diedit, Error : "+e);
            }else{
                JOptionPane.showMessageDialog(null, "Member baru : "+txtNama.getText()+", Gagal ditambahkan, Error : "+e);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MLayanan.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(stat != null){
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MLayanan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnSimpan4btnSimpanActionPerformed

    private void btnBatal4btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatal4btnBatalActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_btnBatal4btnBatalActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int baris = jTable1.getSelectedRow();
        id = Integer.parseInt(tabmode.getValueAt(baris, 0).toString());
        String nama = tabmode.getValueAt(baris, 1).toString();
        String harga = tabmode.getValueAt(baris, 2).toString();
        String hargaPoint = tabmode.getValueAt(baris, 3).toString();
        
        
        String srcPath = "src";
        Path basePath = Paths.get(srcPath);
        
        String relativePath = "asset/gambar1.png";
        Path absolutePath = basePath.resolve(relativePath);
        
        
        
        try {
            if ((int)imgPreview.get(baris).length() > 0) {
                byte [] bytes = imgPreview.get(baris).getBytes(1, (int)imgPreview.get(baris).length());
                FileOutputStream fos = new FileOutputStream(absolutePath.toString());
                fos.write(bytes);
                ImageIcon icon = new ImageIcon(bytes);
                File fp = new File(absolutePath.toString());
                path2 = fp.getAbsolutePath();
                label_gambar.setIcon(icon);
            }else{
                label_gambar.setIcon(null);
                path2 = absolutePath.toString();
            }

        } catch (SQLException ex) {
            Logger.getLogger(MLayanan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MLayanan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MLayanan.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        txtNama.setText(nama);
        txtHarga.setText(harga);
        txtPoint.setText(hargaPoint);
        btnHapus.setVisible(true);
        btnHapus.setEnabled(true);
        btnSimpan4.setText("UPDATE");
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnHapusbtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusbtnSimpanActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null, "Hapus "+txtNama.getText(), "Konfirmasi Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
        
        if (ok == 0){
            String sqlQuery = "UPDATE "+ database.Layanan.TABLE_NAME +" SET deleted = 1 WHERE id = "+id;
            PreparedStatement stat = null;
            try {
                stat = connenction.prepareStatement(sqlQuery);
                stat.executeUpdate();
                datatable();

                JOptionPane.showMessageDialog(null, "Member DELETE : "+txtNama.getText()+", Berhasil dihapus!");
                reset();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Member DELETE : "+txtNama.getText()+", Gagal dihapus, Error : "+e);
            } finally{
                if(stat != null){
                    try {
                        stat.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(FormMember.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }//GEN-LAST:event_btnHapusbtnSimpanActionPerformed

    private void label_gambarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_gambarMouseClicked
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        
        String path;
        
        if (f != null) {
            path = f.getAbsolutePath();
        }else{
            path = "";
        }
        
        try {
            BufferedImage bl = ImageIO.read(new File(path));
            Image img = bl.getScaledInstance(150, 120, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(img);
            label_gambar.setIcon(icon);
            path2 = path;
        } catch (Exception e) {
            Logger.getLogger(this.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_label_gambarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btnBatal4;
    private com.k33ptoo.components.KButton btnHapus;
    private com.k33ptoo.components.KButton btnSimpan4;
    private component.ComboBoxCustome cb_kategori;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel label_gambar;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtPoint;
    // End of variables declaration//GEN-END:variables
}
