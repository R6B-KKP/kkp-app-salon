package tampilan;
import java.sql.*;
import database.Koneksi;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.awt.HeadlessException;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;  
import java.util.HashMap;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.*;
import net.sf.jasperreports.view.*;
/**
 *
 * @author Farhan
 */
public class Member extends javax.swing.JPanel {
    public static final String TABLE_NAME = "member";
    private final Connection connenction = new Koneksi().connect();
    private DefaultTableModel tabmode;

    
    int id = 0;
    public Member() {
        initComponents();
//        jLabel1.setText(""+x);
        datatable();

        jTable1.setVisible(true);
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
    
    
    
    public void datatable(){
        Object[] Baris = {"No ID", "Nama Member", "Alamat", "No Telpon", "Tanggal Lahir"};
        tabmode = new DefaultTableModel(null, Baris);
        jTable1.setModel(tabmode);
        String sql = "select * from "+database.Member.TABLE_NAME;
        try {
            java.sql.Statement stat = connenction.createStatement();
            ResultSet hasil = stat.executeQuery(sql);            
            while(hasil.next()){
                
                String a = hasil.getString("id");
                String b = hasil.getString("nama");
                String c = hasil.getString("alamat");
                String d = hasil.getString("notelp");
                String e = hasil.getString("tgl_lahir");
                
                String[] data = {a,b,c,d,e};
                tabmode.addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR DATA TABLE :  "+e);
        }
    }
    
    public void reset(){
        id = 0;
        txtNama.setText("");
        txtAlamat.setText("");
        txtNotelp.setText("");
        dateTglLahir.setDate(null);
        btnSimpan4.setText("SIMPAN");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        jPanel6 = new javax.swing.JPanel();
        btnSimpan4 = new com.k33ptoo.components.KButton();
        btnBatal4 = new com.k33ptoo.components.KButton();
        btnSimpan5 = new com.k33ptoo.components.KButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        txtAlamat = new javax.swing.JTextField();
        dateTglLahir = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        txtNotelp = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1280, 1080));
        setPreferredSize(new java.awt.Dimension(1280, 1080));

        kGradientPanel1.setBackground(new java.awt.Color(54, 83, 179));
        kGradientPanel1.setkBorderRadius(0);
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 255, 255));

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
                btnSimpanActionPerformed(evt);
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
                btnBatalActionPerformed(evt);
            }
        });

        btnSimpan5.setText("CETAK");
        btnSimpan5.setAlignmentY(0.0F);
        btnSimpan5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSimpan5.setkEndColor(new java.awt.Color(255, 248, 200));
        btnSimpan5.setkHoverEndColor(new java.awt.Color(255, 160, 0));
        btnSimpan5.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnSimpan5.setkHoverStartColor(new java.awt.Color(255, 248, 200));
        btnSimpan5.setkSelectedColor(new java.awt.Color(255, 255, 255));
        btnSimpan5.setkStartColor(new java.awt.Color(255, 160, 0));
        btnSimpan5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpan5btnSimpanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(510, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(btnSimpan4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBatal4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(492, 492, 492))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(btnSimpan5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(556, 556, 556))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSimpan4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBatal4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(btnSimpan5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/member-card.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("FORM MEMBER");

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
        jLabel5.setText("Alamat");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Tanggal Lahir");

        txtNama.setBackground(new java.awt.Color(0,0,0,0));
        txtNama.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtNama.setForeground(new java.awt.Color(255, 255, 255));
        txtNama.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));

        txtAlamat.setBackground(new java.awt.Color(0,0,0,0));
        txtAlamat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtAlamat.setForeground(new java.awt.Color(255, 255, 255));
        txtAlamat.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));

        dateTglLahir.setForeground(new java.awt.Color(255, 255, 255));
        dateTglLahir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("No Telp");

        txtNotelp.setBackground(new java.awt.Color(0,0,0,0));
        txtNotelp.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtNotelp.setForeground(new java.awt.Color(255, 255, 255));
        txtNotelp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(287, 287, 287)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNama)
                    .addComponent(txtAlamat)
                    .addComponent(dateTglLahir, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                    .addComponent(txtNotelp))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtNotelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(dateTglLahir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addComponent(jScrollPane1)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(kGradientPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap()))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(501, 501, 501)
                .addComponent(jLabel6)
                .addGap(55, 55, 55)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(408, Short.MAX_VALUE))
            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(kGradientPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1074, Short.MAX_VALUE)))
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

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        reset();

    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        String sqlQuery = "INSERT INTO "+ database.Member.TABLE_NAME +" values(?,?,?,?,?,?)";
        if (id != 0) {
            sqlQuery = "UPDATE "+ database.Member.TABLE_NAME +" SET nama=?, alamat=?, notelp=?, tgl_lahir=? WHERE id="+id;
        }
        PreparedStatement stat = null;
        Date sqlDate = new java.sql.Date(dateTglLahir.getDate().getTime());
        try {
            stat = connenction.prepareStatement(sqlQuery);
            
            if (id != 0) {
                stat.setString(1, txtNama.getText());
                stat.setString(2, txtAlamat.getText());
                stat.setString(3, txtNotelp.getText());
                stat.setDate(4, sqlDate);

            }else{
                stat.setString(1, Integer.toString(id));
                stat.setString(2, txtNama.getText());
                stat.setString(3, txtAlamat.getText());
                stat.setDate(4, sqlDate);
                stat.setString(5, "0");
                stat.setString(6, txtNotelp.getText());
            }
            stat.executeUpdate();
            datatable();
            if (id != 0) {
                JOptionPane.showMessageDialog(null, "Member update : "+txtNama.getText()+", Berhasil diedit");
            }else{
                JOptionPane.showMessageDialog(null, "Member baru : "+txtNama.getText()+", Berhasil ditambahkan");
            }   
            
            reset();
        } catch (HeadlessException | SQLException e) {
            if (id != 0) {
                id = 0;
                JOptionPane.showMessageDialog(null, "Member update : "+txtNama.getText()+", Gagal diedit, Error : "+e);
            }else{
                JOptionPane.showMessageDialog(null, "Member baru : "+txtNama.getText()+", Gagal ditambahkan, Error : "+e);
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

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int baris = jTable1.getSelectedRow();
        id = Integer.parseInt(tabmode.getValueAt(baris, 0).toString());
        String nama = tabmode.getValueAt(baris, 1).toString();
        String alamat = tabmode.getValueAt(baris, 2).toString();
        String tglLahir = tabmode.getValueAt(baris, 4).toString();
        String noTelp = tabmode.getValueAt(baris, 3).toString();
       
        
        txtNama.setText(nama);
        txtAlamat.setText(alamat);
        txtNotelp.setText(noTelp);
        dateTglLahir.setDate(parseDate(tglLahir));
        btnSimpan4.setText("UPDATE");
//        try {
//            dateTglLahir.setDate(new SimpleDateFormat("MM d, yyyy").parse(tglLahir));
//        } catch (ParseException ex) {
//            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnSimpan5btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpan5btnSimpanActionPerformed
        // TODO add your handling code here:
        try{
        
        String namaFile = "src/report/kartumember.jasper";
        HashMap parameter = new HashMap();
        parameter.put ("id" ,id);
        File report_file = new File(namaFile);
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(report_file.getPath());
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameter, connenction);
        JasperViewer. viewReport (jasperPrint, false);//coba
        JasperViewer.setDefaultLookAndFeelDecorated(true);
    }catch (Exception e){
       Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, e);
    
        }
    }//GEN-LAST:event_btnSimpan5btnSimpanActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btnBatal4;
    private com.k33ptoo.components.KButton btnSimpan4;
    private com.k33ptoo.components.KButton btnSimpan5;
    private com.toedter.calendar.JDateChooser dateTglLahir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNotelp;
    // End of variables declaration//GEN-END:variables
}
