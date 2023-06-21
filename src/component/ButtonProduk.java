package component;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import model.LayananEntity;

/**
 *
 * @author FARHAN
 */
public class ButtonProduk extends javax.swing.JPanel {
    private LayananEntity lyn;

    public ButtonProduk(Icon icon, LayananEntity lyn) {
        initComponents();
        this.lyn = lyn;
        if (icon != null) {
            lblGambar.setIcon(icon);
        }
        if (this.lyn != null) {
            lblNama.setText(this.lyn.getNama());
        }
    }

    public LayananEntity getLyn() {
        return lyn;
    }
    
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblGambar = new javax.swing.JLabel();
        lblNama = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0,0,0,80)
        );
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        setForeground(new java.awt.Color(51, 51, 51));
        setAlignmentX(0.0F);
        setAlignmentY(0.0F);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setMaximumSize(new java.awt.Dimension(150, 150));
        setMinimumSize(new java.awt.Dimension(150, 150));

        lblGambar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/produk.png"))); // NOI18N
        lblGambar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblNama.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNama.setForeground(new java.awt.Color(255, 255, 255));
        lblNama.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNama.setText("Nama Layanan");
        lblNama.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblGambar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblGambar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblGambar;
    private javax.swing.JLabel lblNama;
    // End of variables declaration//GEN-END:variables
}
