/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.JProgressBar;
import javax.swing.plaf.basic.BasicProgressBarUI;

/**
 *
 * @author Farha
 */
public class ProgressBarCostume extends JProgressBar{
    private Color colorString = new Color(200, 200, 200);

    public Color getColorString() {
        return colorString;
    }

    public void setColorString(Color colorString) {
        this.colorString = colorString;
    }

    public ProgressBarCostume() {
        setStringPainted(true);
        setPreferredSize(new Dimension(100, 15));
        setBackground(new Color(255,255,255,10));
        setForeground(new Color(0, 0, 0, 120));
        setUI(new BasicProgressBarUI(){
            @Override
            protected void paintString(Graphics g, int x, int y, int width, int height, int amountFull, Insets b) {
                super.paintString(g, x, y, width, height, amountFull, b); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getForeground());
        g2.setBackground(getBackground());
        int width = getWidth();
        int height = getHeight();
        int arc = height;
        int progressWidth = (int) (getPercentComplete() * width);
        if (progressWidth > 0) {
            g2.fillRoundRect(0, 0, progressWidth - 1, height - 1, arc, arc);
        }
    }
}
