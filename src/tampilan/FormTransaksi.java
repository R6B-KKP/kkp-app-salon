package tampilan;
import component.ButtonProduk;
import java.sql.*;
import database.Koneksi;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JOptionPane;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;  
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Destination;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import model.KaryawanEntity;
import model.LayananEntity;
import model.TransaksiEntity;
/**
 *
 * @author Farhan
 */
public class FormTransaksi extends javax.swing.JPanel {
    private KaryawanEntity karyawan;
    private ArrayList<LayananEntity> dataLayanan;
    private DefaultTableModel modelCart;
    private final Object[] HEADER_MODEL_TABEL_CART = {"Id", "Layanan", "Price", "Qty", "Sub Total"};
    ImageIcon icon = new ImageIcon(getClass().getResource("/asset/produk.png"));
//    Font font = new Font("Segoe UI", Font.BOLD, 12);
    private ArrayList<TransaksiEntity> transaksi;
    private TransaksiEntity tempDelete; 
    private int totalHarga = 0;
    private int jumlah = 0;
    private final double pajak = 0.1;
    private int bayar = 0;
    private int kembali = 0;
    public static final String TABLE_NAME = "member";
    private final Connection connenction = new Koneksi().connect();
    private DefaultTableModel tabmode;

    public FormTransaksi() {
        initComponents();
         dataLayanan = new ArrayList<>();
//        dataLayanan.add(new LayananEntity(1, "Cukur", 200000));
//        dataLayanan.add(new LayananEntity(2, "Krimbat", 100000));
//        dataLayanan.add(new LayananEntity(3, "Cat Rambut", 250000));
//        dataLayanan.add(new LayananEntity(4, "Maskeran", 120000));
//        dataLayanan.add(new LayananEntity(5, "Rias Wajah", 170000));
//        dataLayanan.add(new LayananEntity(6, "Bikin Konde", 50000));
//        dataLayanan.add(new LayananEntity(7, "clear Komedo", 120000));
//        dataLayanan.add(new LayananEntity(8, "clear jerawat", 120000));
        initComponents();
        txtCetakTransaksi.setText("");
        txtCetakTransaksi.setEditable(false);
        txtCetakTransaksi.setBackground(new Color(255,255,255));
        txtCetakTransaksi.setForeground(new Color(0,0,0));
        txtTotalHarga.setEditable(false);
        txtDikembalikan.setEditable(false);
        btnCetakStuk.setEnabled(false);
        btnUlangi.setAlignmentY(0.0F);
        txtBayar.requestFocus();
        txtBayar.setText("0");
        refreshList();
        transaksi = new ArrayList<>(Collections.nCopies(dataLayanan.size(), null));
        dataCart();
    }
    
    public void refreshList(){
        dataLayanan = new ArrayList<>();
        initLayanan(dataLayanan);
        panelProduk.removeAll();
        try {
            createProduk(dataLayanan);
            for (LayananEntity layananEntity : dataLayanan) {
                System.out.println(layananEntity);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void initLayanan(ArrayList<LayananEntity> arrLT){
        String sql = "select "+database.Layanan.TABLE_NAME+".*, "+database.Kategori.TABLE_NAME+"."+database.Kategori.NAMA+" as kategori "
                +" from "+database.Layanan.TABLE_NAME
                +" join "+database.Kategori.TABLE_NAME+" on "+database.Kategori.TABLE_NAME+"."+database.Kategori.ID+" = "+database.Layanan.TABLE_NAME+"."+database.Layanan.ID_KATEGORI
                +" where "+database.Layanan.TABLE_NAME+"."+database.Layanan.DELETED+" = '0';";
        try {
            java.sql.Statement stat = connenction.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            int idx = 0;
            while(hasil.next()){
                
                int id = hasil.getInt("id");
                String nama = hasil.getString("nama");
                int harga = hasil.getInt("harga");
                Blob file = hasil.getBlob("gambar");

                if (file == null) {
                    file = new SerialBlob(new byte[0]);
                }else{
                    file = file;
                }
                
                arrLT.add(new LayananEntity(id, nama, harga, (java.sql.Blob) file));
                idx++;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR DATA TABLE :  "+e);
        }
    }
    
    public java.util.Date parseDate(String date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        try {
            return dateFormat.parse(date);
        } catch (Exception e) {
            System.out.print("EROR DATE : Format tidak valid!");
            return null;
        }
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        jPanel2 = new javax.swing.JPanel();
        panelProduk = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        panelCetak = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblWaktu = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtCetakTransaksi = new javax.swing.JTextPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCart = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtTotalHarga = new javax.swing.JTextField();
        txtBayar = new javax.swing.JTextField();
        txtDikembalikan = new javax.swing.JTextField();
        btnHapusSemua = new com.k33ptoo.components.KButton();
        btnHapus = new com.k33ptoo.components.KButton();
        btnHitung = new com.k33ptoo.components.KButton();
        btnBatalTransaksi = new com.k33ptoo.components.KButton();
        jLabel11 = new javax.swing.JLabel();
        txtTotalHarga1 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        btnCetakStuk = new com.k33ptoo.components.KButton();
        btnUlangi = new com.k33ptoo.components.KButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1280, 1080));
        setMinimumSize(new java.awt.Dimension(1280, 1080));
        setPreferredSize(new java.awt.Dimension(1280, 1080));

        kGradientPanel1.setBackground(new java.awt.Color(54, 83, 179));
        kGradientPanel1.setkBorderRadius(0);
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setMaximumSize(new java.awt.Dimension(1280, 1040));
        kGradientPanel1.setMinimumSize(new java.awt.Dimension(1280, 1040));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(1280, 1040));

        jPanel2.setBackground(new java.awt.Color(0,0,0,0)
        );
        jPanel2.setOpaque(false);

        panelProduk.setOpaque(false);
        panelProduk.setLayout(new java.awt.GridLayout(4, 3, 5, 5));

        jPanel5.setBackground(new java.awt.Color(0,0,0,125)
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Produk Layanan");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelProduk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelProduk, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(0,0,0,0)
        );
        jPanel3.setOpaque(false);

        panelCetak.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(0, 51, 255));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/logo-salon.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("SALON ABC");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Struk Transaksi Pelayanan");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Alamat Salon");

        lblWaktu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblWaktu.setForeground(new java.awt.Color(0, 0, 0));
        lblWaktu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWaktu.setText("TGL/Waktu Transaksi");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("*Terima Kasih Telah Menggunanakan Pelayanan Kami");

        txtCetakTransaksi.setBackground(new java.awt.Color(255, 255, 255));
        txtCetakTransaksi.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        txtCetakTransaksi.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane3.setViewportView(txtCetakTransaksi);

        javax.swing.GroupLayout panelCetakLayout = new javax.swing.GroupLayout(panelCetak);
        panelCetak.setLayout(panelCetakLayout);
        panelCetakLayout.setHorizontalGroup(
            panelCetakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelCetakLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCetakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblWaktu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        panelCetakLayout.setVerticalGroup(
            panelCetakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCetakLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblWaktu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tableCart.setModel(new javax.swing.table.DefaultTableModel(
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
        tableCart.setFocusable(false);
        tableCart.setRowHeight(25);
        tableCart.setShowHorizontalLines(true);
        tableCart.getTableHeader().setReorderingAllowed(false);
        tableCart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCartMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableCart);

        jPanel1.setBackground(new java.awt.Color(0,0,0,0)
        );
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        jPanel1.setOpaque(false);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Detail Transaksi");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Total Harga *(Pajak)");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Di Bayarkan");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Di Kembalikan");

        txtTotalHarga.setBackground(new java.awt.Color(0,0,0,20)
        );
        txtTotalHarga.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtTotalHarga.setForeground(new java.awt.Color(255, 255, 255));
        txtTotalHarga.setText("0");
        txtTotalHarga.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));

        txtBayar.setBackground(new java.awt.Color(0,0,0,50)
        );
        txtBayar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtBayar.setForeground(new java.awt.Color(255, 255, 255));
        txtBayar.setText("0");
        txtBayar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));

        txtDikembalikan.setBackground(new java.awt.Color(0,0,0,20)
        );
        txtDikembalikan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtDikembalikan.setForeground(new java.awt.Color(255, 255, 255));
        txtDikembalikan.setText("0");
        txtDikembalikan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));

        btnHapusSemua.setText("HAPUS SEMUA");
        btnHapusSemua.setAlignmentY(0.0F);
        btnHapusSemua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHapusSemua.setkEndColor(new java.awt.Color(255, 248, 200));
        btnHapusSemua.setkHoverEndColor(new java.awt.Color(255, 160, 0));
        btnHapusSemua.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnHapusSemua.setkHoverStartColor(new java.awt.Color(255, 248, 200));
        btnHapusSemua.setkSelectedColor(new java.awt.Color(255, 255, 255));
        btnHapusSemua.setkStartColor(new java.awt.Color(255, 160, 0));
        btnHapusSemua.setMargin(new java.awt.Insets(1, 8, 1, 8));
        btnHapusSemua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusSemuabtnSimpanActionPerformed(evt);
            }
        });

        btnHapus.setText("HAPUS");
        btnHapus.setAlignmentY(0.0F);
        btnHapus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHapus.setkEndColor(new java.awt.Color(255, 248, 200));
        btnHapus.setkHoverEndColor(new java.awt.Color(255, 160, 0));
        btnHapus.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnHapus.setkHoverStartColor(new java.awt.Color(255, 248, 200));
        btnHapus.setkSelectedColor(new java.awt.Color(255, 255, 255));
        btnHapus.setkStartColor(new java.awt.Color(255, 160, 0));
        btnHapus.setMargin(new java.awt.Insets(1, 8, 1, 8));
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusbtnSimpanActionPerformed(evt);
            }
        });

        btnHitung.setText("HITUNG TRANSAKSI");
        btnHitung.setAlignmentY(0.0F);
        btnHitung.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHitung.setkEndColor(new java.awt.Color(255, 248, 200));
        btnHitung.setkHoverEndColor(new java.awt.Color(255, 160, 0));
        btnHitung.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnHitung.setkHoverStartColor(new java.awt.Color(255, 248, 200));
        btnHitung.setkSelectedColor(new java.awt.Color(255, 255, 255));
        btnHitung.setkStartColor(new java.awt.Color(255, 160, 0));
        btnHitung.setMargin(new java.awt.Insets(1, 8, 1, 8));
        btnHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHitungbtnSimpanActionPerformed(evt);
            }
        });

        btnBatalTransaksi.setText("BATAL TRANSAKSI");
        btnBatalTransaksi.setAlignmentY(0.0F);
        btnBatalTransaksi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBatalTransaksi.setkEndColor(new java.awt.Color(255, 248, 200));
        btnBatalTransaksi.setkHoverEndColor(new java.awt.Color(255, 160, 0));
        btnBatalTransaksi.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnBatalTransaksi.setkHoverStartColor(new java.awt.Color(255, 248, 200));
        btnBatalTransaksi.setkSelectedColor(new java.awt.Color(255, 255, 255));
        btnBatalTransaksi.setkStartColor(new java.awt.Color(255, 160, 0));
        btnBatalTransaksi.setMargin(new java.awt.Insets(1, 8, 1, 8));
        btnBatalTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalTransaksibtnSimpanActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("ID Member");

        txtTotalHarga1.setBackground(new java.awt.Color(0,0,0,20)
        );
        txtTotalHarga1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        txtTotalHarga1.setForeground(new java.awt.Color(255, 255, 255));
        txtTotalHarga1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnHitung, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBatalTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBayar, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtTotalHarga, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnHapusSemua, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                    .addComponent(txtDikembalikan)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTotalHarga1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalHarga1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(btnHapusSemua, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDikembalikan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBatalTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHitung, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(0,0,0,0)
        );
        jPanel6.setOpaque(false);

        btnCetakStuk.setText("CETAK");
        btnCetakStuk.setAlignmentY(0.0F);
        btnCetakStuk.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCetakStuk.setkEndColor(new java.awt.Color(255, 248, 200));
        btnCetakStuk.setkHoverEndColor(new java.awt.Color(255, 160, 0));
        btnCetakStuk.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnCetakStuk.setkHoverStartColor(new java.awt.Color(255, 248, 200));
        btnCetakStuk.setkSelectedColor(new java.awt.Color(255, 255, 255));
        btnCetakStuk.setkStartColor(new java.awt.Color(255, 160, 0));
        btnCetakStuk.setMargin(new java.awt.Insets(1, 8, 1, 8));
        btnCetakStuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakStukbtnSimpanActionPerformed(evt);
            }
        });

        btnUlangi.setText("ULANGI");
        btnUlangi.setAlignmentY(0.0F);
        btnUlangi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUlangi.setkEndColor(new java.awt.Color(255, 248, 200));
        btnUlangi.setkHoverEndColor(new java.awt.Color(255, 160, 0));
        btnUlangi.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnUlangi.setkHoverStartColor(new java.awt.Color(255, 248, 200));
        btnUlangi.setkSelectedColor(new java.awt.Color(255, 255, 255));
        btnUlangi.setkStartColor(new java.awt.Color(255, 160, 0));
        btnUlangi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUlangibtnSimpanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCetakStuk, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUlangi, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCetakStuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUlangi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelCetak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(panelCetak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(311, 311, 311))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(311, 311, 311))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 40, Short.MAX_VALUE)
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents
    int baris;
    private void tableCartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCartMouseClicked
        // TODO add your handling code here:
        baris = tableCart.getSelectedRow();
        int id = Integer.parseInt(modelCart.getValueAt(baris, 0).toString());

        for (TransaksiEntity trx : transaksi) {
            if (trx != null && trx.getId() == id) {
                tempDelete = trx;
            }
        }
    }//GEN-LAST:event_tableCartMouseClicked

    private void btnCetakStukbtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakStukbtnSimpanActionPerformed
        printRecord(panelCetak);
        btnCetakStuk.setEnabled(false);
    }//GEN-LAST:event_btnCetakStukbtnSimpanActionPerformed

    private void btnUlangibtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUlangibtnSimpanActionPerformed
        txtDikembalikan.setText("0");
        txtBayar.setText("0");
        txtCetakTransaksi.setText("");
        txtBayar.requestFocus();
        btnCetakStuk.setEnabled(false);
        lblWaktu.setText("TGL/Waktu Transaksi");
        clearTransaksi();
    }//GEN-LAST:event_btnUlangibtnSimpanActionPerformed

    private void btnHapusSemuabtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusSemuabtnSimpanActionPerformed
         clearTransaksi();
    }//GEN-LAST:event_btnHapusSemuabtnSimpanActionPerformed

    private void btnHapusbtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusbtnSimpanActionPerformed
        
        if (tempDelete != null && tempDelete.getQty() >= 1) {
            System.out.println("Temp"+tempDelete.toString());
            int index = transaksi.indexOf(tempDelete);
            tempDelete.setQty(tempDelete.getQty()-1);
            transaksi.set(index, tempDelete);
            tempDelete = transaksi.get(index);
            System.out.println("Ubah Temp"+tempDelete.toString());
            if (tempDelete.getQty() == 1) {
                tempDelete = null;
                transaksi.set(index, null);
            }
        }
        dataCart();
        tableCart.setRowSelectionInterval(baris, baris);
    }//GEN-LAST:event_btnHapusbtnSimpanActionPerformed

    private void btnHitungbtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHitungbtnSimpanActionPerformed
       bayar =  Integer.parseInt(txtBayar.getText());
        if (bayar >= totalHarga) {
            kembali =  bayar-totalHarga;
            LocalDateTime waktu = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("'Tanggal : 'EEEE, dd MMMM yyyy', Jam : 'HH:mm:ss");
            String waktuString = waktu.format(formatter);
            lblWaktu.setText(waktuString);
            txtDikembalikan.setText(String.format("%,d", kembali));
            txtCetakTransaksi.setText( recordStruk());
            btnCetakStuk.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(this, "Nilai Pembayaran Tidak Boleh Kurang Dari Total",  "Transaksi", JOptionPane.WARNING_MESSAGE);
            txtBayar.requestFocus();
        }
    }//GEN-LAST:event_btnHitungbtnSimpanActionPerformed

    private void btnBatalTransaksibtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalTransaksibtnSimpanActionPerformed
        txtDikembalikan.setText("0");
        txtBayar.setText("0");
        txtBayar.requestFocus();
    }//GEN-LAST:event_btnBatalTransaksibtnSimpanActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btnBatalTransaksi;
    private com.k33ptoo.components.KButton btnCetakStuk;
    private com.k33ptoo.components.KButton btnHapus;
    private com.k33ptoo.components.KButton btnHapusSemua;
    private com.k33ptoo.components.KButton btnHitung;
    private com.k33ptoo.components.KButton btnUlangi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lblWaktu;
    private javax.swing.JPanel panelCetak;
    private javax.swing.JPanel panelProduk;
    private javax.swing.JTable tableCart;
    private javax.swing.JTextField txtBayar;
    private javax.swing.JTextPane txtCetakTransaksi;
    private javax.swing.JTextField txtDikembalikan;
    private javax.swing.JTextField txtTotalHarga;
    private javax.swing.JTextField txtTotalHarga1;
    // End of variables declaration//GEN-END:variables

    private void dataCart(){
        modelCart =  new DefaultTableModel(null, HEADER_MODEL_TABEL_CART);
        tableCart.setModel(modelCart);
        int tempTotal = 0;
        int tempJumlah = 0;
        for (TransaksiEntity trs : transaksi) {
            if (trs != null  && trs.getQty() != 0) {
                tempJumlah = tempJumlah + (trs.getPrice()*trs.getQty());
                tempTotal = tempTotal + (trs.getPrice()*trs.getQty());
                tempTotal = (int) (tempTotal + (tempTotal*pajak));
                
                String col1 = String.valueOf(trs.getId());
                String col2 = trs.getNamaLayanan();
                String col3 = String.valueOf(trs.getPrice());
                String col4 = String.valueOf(trs.getQty());
                
                int subTotal = trs.getPrice()*trs.getQty();
                String col5 = String.valueOf(subTotal);
                
                String[] data = {col1, col2, col3, col4, col5};
                modelCart.addRow(data);
            }
        }
        jumlah = tempJumlah;
        totalHarga = tempTotal;
        txtTotalHarga.setText(String.format("%,d",totalHarga));
        txtBayar.requestFocus();
    }
    
    private void createProduk(ArrayList<LayananEntity> dataLayanan) throws SQLException{
        for (LayananEntity lyn : dataLayanan) {
            byte [] bytes = null;

            bytes = lyn.getGambar().getBytes(1, (int) lyn.getGambar().length());
            ImageIcon ic = new ImageIcon(bytes);
            ButtonProduk btnProduk = new ButtonProduk(ic, lyn);
            btnProduk.addMouseListener(new MouseListener() {
                public void mouseClicked(MouseEvent e) {
                    ButtonProduk btn = (ButtonProduk) e.getSource();
                    
                    int dataIndex = dataLayanan.indexOf(btn.getLyn());
            
                    if (transaksi.get(dataIndex) == null) {
                        TransaksiEntity t  = new TransaksiEntity(btn.getLyn().getId(), btn.getLyn().getNama(), btn.getLyn().getPrice(), 1);
                        transaksi.set(dataIndex, t);
                    } else {
                        int qty = transaksi.get(dataIndex).getQty()+1;
                        transaksi.get(dataIndex).setQty(qty);
                    }
                    dataCart();
                    
                }
                public void mousePressed(MouseEvent e) {}
                public void mouseReleased(MouseEvent e) {}
                public void mouseEntered(MouseEvent e) {}
                public void mouseExited(MouseEvent e) {}
            });
            
            panelProduk.add(btnProduk);
        }
    }
    
    private void clearTransaksi(){
         for (TransaksiEntity trx : transaksi) {
            if (trx != null) {
                int index = transaksi.indexOf(trx);
                transaksi.set(index, null);
            }
        }
        dataCart();
    }
    
    private String recordStruk(){
        String record = "";
        String pemisah = "---------------------------------------------------------------------------------------------------------\n\n";
        String namaAdmin = "    Kasir :"+karyawan.getNama()+"\n";
        record = record+namaAdmin;
        record = record+pemisah;
        for (TransaksiEntity trx : transaksi) {
            if (trx != null) {
                String produk = String.format("     %15.30s \t %,d * %d \t\t : %,d  \n", trx.getNamaLayanan(), trx.getPrice(), trx.getQty(), trx.getPrice()*trx.getQty());
                record = record+produk;
            }
        }
        record = record+"\n"+pemisah;
        String transaksi = String.format(" \t\t\t\tJumlah       : %,d\n"
                                                       + " \t\t\t\tPpn             : %s\n"
                                                       + " \t\t\t\tTotal           : %,d\n"
                                                       + " \t\t\t\tBayar          : %,d\n"
                                                       + " \t\t\t\tKembali      : %,d\n"
                                                        , jumlah, "10%", totalHarga, bayar, kembali);
        record = record+transaksi;
        return record;
    }
    
    private void printRecord(JPanel panel) {
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setJobName("Print Record");

        printerJob.setPrintable(new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                if (pageIndex > 0) {
                    return Printable.NO_SUCH_PAGE;
                }
                
//                // Ukuran kertas baru (misalnya, Letter)
//                pageFormat.setPaper(new Paper());
//                pageFormat.getPaper().setSize(612.0, 792.0); // Mengatur ukuran kertas sesuai kebutuhan (misalnya, Letter)

                Graphics2D gd = (Graphics2D) graphics;
//                gd.translate(pageFormat.getImageableX() * 0.1, pageFormat.getImageableY() * 0.1);
//                gd.scale(0.8, 0.8);

                // Mengatur skala gambar agar sesuai dengan ukuran kertas
                double scaleX = pageFormat.getImageableWidth() / panel.getWidth();
                double scaleY = pageFormat.getImageableHeight() / panel.getHeight();
                gd.scale(scaleX, scaleY);

                // Mengatur posisi gambar agar dimulai dari kiri atas kertas
                gd.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

                panel.paint(gd);

                return Printable.PAGE_EXISTS;
            }
        });

        boolean returningResult = printerJob.printDialog();
        if (returningResult) {
            try {
                java.util.Date currentDate = new java.util.Date();

                // Buat format tanggal dan waktu yang diinginkan (misalnya: "yyyyMMdd_HHmmss")
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");

                // Format tanggal dan waktu saat ini menjadi string
                String dateTimeString = dateFormat.format(currentDate);

                // Buat nama file dengan menggunakan tanggal dan waktu
                String fileName = dateTimeString + ".pdf";

                PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();

                printRequestAttributeSet.add(new Destination(new File("C:\\trx\\"+fileName).toURI()));

                printerJob.print(printRequestAttributeSet);
                printerJob.print();
            } catch (PrinterException e) {
                JOptionPane.showMessageDialog(this, "Print Error: " + e.getMessage());
            }
        }
    }

    public void setKaryawan(KaryawanEntity karyawan) {
        this.karyawan = karyawan;
    }

    
}
