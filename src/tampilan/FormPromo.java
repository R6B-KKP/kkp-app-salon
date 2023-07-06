package tampilan;
import java.sql.*;
import database.Koneksi;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.awt.HeadlessException;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;  
import java.util.Random;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import table.TableCustom;


public class FormPromo extends javax.swing.JPanel {
    private final Connection connenction = new Koneksi().connect();
    private DefaultTableModel tabmode;

    
    private String kPromo = "0";
    public FormPromo() {
        initComponents();
        datatable();
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
        tablePromo.setVisible(true);
    }
    
    public final void header() {
        tablePromo.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        tablePromo.getTableHeader().setBackground(new Color(45, 105, 141));
        tablePromo.getTableHeader().setForeground(Color.WHITE);
    }

    public final void renderer() {
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) tablePromo.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        headerRenderer.setBackground(new Color(45, 105, 141));
        headerRenderer.setForeground(Color.WHITE);
    }
    
    public java.util.Date parseDate(String date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(date);
        } catch (Exception e) {
            System.out.print("EROR DATE : Format tidak valid!");
            return null;
        }
    }
    
    public void datatable(){
        Object[] Baris = {"Kode Promo", "Nama Promo", "Diskon", "Max Diskon", "Tanggal Mulai", "Tanggal Berakhir"};
        tabmode = new DefaultTableModel(null, Baris);
        tablePromo.setModel(tabmode);
        String sql = "SELECT * FROM "+database.Promo.TABLE_NAME;
        try {
            java.sql.Statement stat = connenction.createStatement();
            ResultSet hasil = stat.executeQuery(sql);            
            while(hasil.next()){
                
                String a = hasil.getString(database.Promo.KODE_PROMO);
                String b = hasil.getString(database.Promo.NAMA);
                String c = hasil.getString(database.Promo.DISKON);
                String d = hasil.getString(database.Promo.MAX_DISKON);
                String e = hasil.getString(database.Promo.TGL_MULAI);
                String f = hasil.getString(database.Promo.TGL_AKHIR);
                
                String[] data = {a,b,c,d,e,f};
                tabmode.addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR DATA TABLE :  "+e);
        }
    }
    
    public void reset(){
        kPromo = "0";
        txtNama.setText("");
        txtDiskon.setText("");
        txtMaxDiskon.setText("");
        txtJumlahVoucher.setText("");
        dateTglMulai.setDate(null);
        dateTglBerakhir.setDate(null);
        lblJmlVoucher.setText("Jumlah Voucher");
        btnSimpan.setText("SIMPAN");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        jPanel6 = new javax.swing.JPanel();
        btnSimpan = new com.k33ptoo.components.KButton();
        btnBatal = new com.k33ptoo.components.KButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePromo = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        txtDiskon = new javax.swing.JTextField();
        dateTglMulai = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        txtMaxDiskon = new javax.swing.JTextField();
        dateTglBerakhir = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        lblJmlVoucher = new javax.swing.JLabel();
        txtJumlahVoucher = new javax.swing.JTextField();

        setBackground(new java.awt.Color(204, 255, 204));
        setMaximumSize(new java.awt.Dimension(1280, 920));
        setMinimumSize(new java.awt.Dimension(1280, 920));
        setPreferredSize(new java.awt.Dimension(1280, 920));

        kGradientPanel1.setBackground(new java.awt.Color(54, 83, 179));
        kGradientPanel1.setkBorderRadius(0);
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 255, 255));

        jPanel6.setOpaque(false);

        btnSimpan.setText("SIMPAN");
        btnSimpan.setAlignmentY(0.0F);
        btnSimpan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSimpan.setkEndColor(new java.awt.Color(255, 248, 200));
        btnSimpan.setkHoverEndColor(new java.awt.Color(255, 160, 0));
        btnSimpan.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnSimpan.setkHoverStartColor(new java.awt.Color(255, 248, 200));
        btnSimpan.setkSelectedColor(new java.awt.Color(255, 255, 255));
        btnSimpan.setkStartColor(new java.awt.Color(255, 160, 0));
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnBatal.setText("BATAL");
        btnBatal.setAlignmentY(0.0F);
        btnBatal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBatal.setkEndColor(new java.awt.Color(255, 248, 200));
        btnBatal.setkHoverEndColor(new java.awt.Color(255, 160, 0));
        btnBatal.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnBatal.setkHoverStartColor(new java.awt.Color(255, 248, 200));
        btnBatal.setkSelectedColor(new java.awt.Color(255, 255, 255));
        btnBatal.setkStartColor(new java.awt.Color(255, 160, 0));
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        tablePromo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tablePromo.setModel(new javax.swing.table.DefaultTableModel(
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
        tablePromo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePromoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePromo);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(518, Short.MAX_VALUE)
                .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(492, 492, 492))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1268, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/hot-sale.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("FORM PROMO");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("*pastikan data yang di imput sudah benar!");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jPanel1.setOpaque(false);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nama");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Diskon");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Tanggal Mulai");

        txtNama.setBackground(new java.awt.Color(0,0,0,0));
        txtNama.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtNama.setForeground(new java.awt.Color(255, 255, 255));
        txtNama.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));

        txtDiskon.setBackground(new java.awt.Color(0,0,0,0));
        txtDiskon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtDiskon.setForeground(new java.awt.Color(255, 255, 255));
        txtDiskon.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));

        dateTglMulai.setForeground(new java.awt.Color(255, 255, 255));
        dateTglMulai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Max Diskon");

        txtMaxDiskon.setBackground(new java.awt.Color(0,0,0,0));
        txtMaxDiskon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtMaxDiskon.setForeground(new java.awt.Color(255, 255, 255));
        txtMaxDiskon.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));

        dateTglBerakhir.setForeground(new java.awt.Color(255, 255, 255));
        dateTglBerakhir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Tanggal Berakhir");

        lblJmlVoucher.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblJmlVoucher.setForeground(new java.awt.Color(255, 255, 255));
        lblJmlVoucher.setText("Jumlah Voucher");

        txtJumlahVoucher.setBackground(new java.awt.Color(0,0,0,0));
        txtJumlahVoucher.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtJumlahVoucher.setForeground(new java.awt.Color(255, 255, 255));
        txtJumlahVoucher.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNama, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                    .addComponent(txtDiskon)
                    .addComponent(txtMaxDiskon, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblJmlVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(dateTglMulai, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                        .addComponent(dateTglBerakhir, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE))
                    .addComponent(txtJumlahVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblJmlVoucher)
                            .addComponent(txtJumlahVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(dateTglMulai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(dateTglBerakhir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtDiskon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtMaxDiskon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(162, 162, 162)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(kGradientPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(774, Short.MAX_VALUE)))
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
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        reset();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        Random random = new Random();
        int randomNumber = random.nextInt(9000) + 1000;
        String kodePromo = "P"+randomNumber;
        String sqlQuery = "INSERT INTO "+ database.Promo.TABLE_NAME +" values(?,?,?,?,?,?)";
        String voucherQuery = "INSERT INTO "+ database.Voucher.TABLE_NAME+" values(?,?,?)";
        if (!kPromo.equals("0")) {
            sqlQuery = "UPDATE "+ database.Promo.TABLE_NAME +" SET "+database.Promo.NAMA+" = ?, "+database.Promo.TGL_AKHIR+" = ?  WHERE "+database.Promo.KODE_PROMO+"='"+kPromo+"'";
        }
        PreparedStatement stat = null;
        Date sqDateMulai = new java.sql.Date(dateTglMulai.getDate().getTime());
        Date sqDateAkhir = new java.sql.Date(dateTglBerakhir.getDate().getTime());
        System.out.println(dateTglMulai.getDate());
        System.out.println(sqDateMulai);
        try {
            stat = connenction.prepareStatement(sqlQuery);
            
            if (!kPromo.equals("0")) {
                stat.setString(1, txtNama.getText());
                stat.setDate(2, sqDateAkhir);
            }else{
                stat.setString(1, kodePromo.toString());
                stat.setString(2, txtNama.getText());
                stat.setString(3, txtDiskon.getText());
                stat.setString(4, txtMaxDiskon.getText());
                stat.setDate(5, sqDateMulai);
                stat.setDate(6, sqDateAkhir);
            }
            stat.executeUpdate();
            datatable();
            if (!kPromo.equals("0")) {
                stat = connenction.prepareStatement(voucherQuery);
                if (createVoucher(stat, kPromo)) {
                    JOptionPane.showMessageDialog(null, "Voucher baru, Berhasil ditambahkan");
                }else {
                    JOptionPane.showMessageDialog(null, "Voucher baru, Gagal ditambahkan");
                }
                JOptionPane.showMessageDialog(null, "Promo update : "+txtNama.getText()+", Berhasil diedit");
            }else{
                stat = connenction.prepareStatement(voucherQuery);
                if (createVoucher(stat, kodePromo)) {
                    JOptionPane.showMessageDialog(null, "Voucher baru, Berhasil ditambahkan");
                }else {
                    JOptionPane.showMessageDialog(null, "Voucher baru, Gagal ditambahkan");
                }
                JOptionPane.showMessageDialog(null, "Promo baru : "+txtNama.getText()+", Berhasil ditambahkan");
            }   
            
            reset();
        } catch (HeadlessException | SQLException e) {
            if (!kPromo.equals("0")) {
                kodePromo = "0";
                JOptionPane.showMessageDialog(null, "Promo update : "+txtNama.getText()+", Gagal diedit, Error : "+e);
                e.printStackTrace();
            }else{
                JOptionPane.showMessageDialog(null, "Promo baru : "+txtNama.getText()+", Gagal ditambahkan, Error : "+e);
            }
        } finally {
            if(stat != null){
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FormMember.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void tablePromoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePromoMouseClicked
        // TODO add your handling code here:
        int baris = tablePromo.getSelectedRow();
        kPromo = tabmode.getValueAt(baris, 0).toString();
        String nama = tabmode.getValueAt(baris, 1).toString();
        String diskon = tabmode.getValueAt(baris, 2).toString();
        String maxDiskon = tabmode.getValueAt(baris, 3).toString();
        String tglMulai = tabmode.getValueAt(baris, 4).toString();
        String tglAkhir = tabmode.getValueAt(baris, 5).toString();
       
        dateTglMulai.setEnabled(false);
        txtDiskon.setEditable(false);
        txtMaxDiskon.setEditable(false);
        txtJumlahVoucher.setText("");
        lblJmlVoucher.setText("Tambah Voucher");
        txtNama.setText(nama);
        txtDiskon.setText(diskon);
        txtMaxDiskon.setText(maxDiskon);
        dateTglMulai.setDate(parseDate(tglMulai));
        dateTglBerakhir.setDate(parseDate(tglAkhir));
        btnSimpan.setText("UPDATE");
    }//GEN-LAST:event_tablePromoMouseClicked
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btnBatal;
    private com.k33ptoo.components.KButton btnSimpan;
    private com.toedter.calendar.JDateChooser dateTglBerakhir;
    private com.toedter.calendar.JDateChooser dateTglMulai;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lblJmlVoucher;
    private javax.swing.JTable tablePromo;
    private javax.swing.JTextField txtDiskon;
    private javax.swing.JTextField txtJumlahVoucher;
    private javax.swing.JTextField txtMaxDiskon;
    private javax.swing.JTextField txtNama;
    // End of variables declaration//GEN-END:variables

    private String generateKodeVoucher(){
        Random random = new Random();
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
        StringBuilder sb = new StringBuilder(7);
        for (int i = 0; i < 7; i++) {
            char randomChar = chars[random.nextInt(chars.length)];
            sb.append(randomChar);
        }
        String randomString = sb.toString();
        String voucherCode = "VCR" + randomString;
        
        return voucherCode;
    }
    
    private boolean createVoucher(PreparedStatement stat, String kodePromo) throws SQLException{
        if (!txtJumlahVoucher.getText().equals("0") && !txtJumlahVoucher.getText().equals("")) {
            for (int i = 1; i <= Integer.parseInt(txtJumlahVoucher.getText()) ; i++) {
                stat.setString(1, generateKodeVoucher());
                stat.setString(2, "0");
                stat.setString(3, kodePromo);
                int rs = stat.executeUpdate();
                if (rs <= 0) {
                    JOptionPane.showMessageDialog(this, "ERROR SAAT CREATE VOUCHER");
                }
            }
        return true;
        }else {
            return false;
        }
    }
}
