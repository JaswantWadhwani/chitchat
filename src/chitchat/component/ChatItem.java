/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chitchat.component;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Jatin Wadhwani
 */
public class ChatItem extends javax.swing.JLayeredPane {

    /**
     * Creates new form ChatItem
     */
    private JLabel lblTime;
    public ChatItem() {
        initComponents();
        jtmSendTextPane.setEditable(false);
        jtmSendTextPane.setBackground(new Color(0,0,0,0));
        jtmSendTextPane.setOpaque(false);
    }

    public void setText(String text) {
        jtmSendTextPane.setText(text);
    }
    
    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D)graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setColor(getBackground());
        graphics2D.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        super.paintComponent(graphics);
    }
    
    public void setTime(String time) {
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setLayout(new FlowLayout(FlowLayout.RIGHT , 0 , 0));
        layeredPane.setBorder(new EmptyBorder(0,5,10,5));
        lblTime = new JLabel(time);
        lblTime.setForeground(new Color(110,110,110));
        lblTime.setHorizontalTextPosition(JLabel.LEFT);
        layeredPane.add(lblTime);
        add(layeredPane);
    }
    
    public void setImage(boolean right , Icon... image) {
        if(image.length > 0) {
            JLayeredPane layer = new JLayeredPane();
            layer.setLayout(new FlowLayout(right?FlowLayout.RIGHT : FlowLayout.LEFT));
            layer.setBorder(new EmptyBorder(0,5,0,5));
            ChatImage chatImage = new ChatImage(right);
            chatImage.addImage(image);
            layer.add(chatImage);
            add(layer);
        }
    }
    
    public void setImage(boolean right , String... image) {
        JLayeredPane layer = new JLayeredPane();
        layer.setLayout(new FlowLayout(right?FlowLayout.RIGHT : FlowLayout.LEFT));
        layer.setBorder(new EmptyBorder(0,5,0,5));
        ChatImage chatImage = new ChatImage(right);
        chatImage.addImage(image);
        layer.add(chatImage);
        add(layer);
    }
    
    public void setFile(String fileName , String fileSize) {
        JLayeredPane layer = new JLayeredPane();
        layer.setLayout(new FlowLayout(FlowLayout.LEFT));
        layer.setBorder(new EmptyBorder(0,5,0,5));
        ChatFile chatFile = new ChatFile();
        chatFile.setFile(fileName, fileSize);
        layer.add(chatFile);
        add(layer);
    }
    
    public void setUserProfile(String userProfile) {
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setLayout(new FlowLayout(FlowLayout.LEFT , 0 , 0));
        layeredPane.setBorder(new EmptyBorder(10,10,0,10));
        JButton btnUserProfile = new JButton(userProfile);
        btnUserProfile.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnUserProfile.setBorder(null);
        btnUserProfile.setContentAreaFilled(false);
        btnUserProfile.setFocusable(false);
        btnUserProfile.setForeground(new Color(30,121,213));
        btnUserProfile.setFont(new java.awt.Font("SansSerif", 1, 15));
        jtmSendTextPane.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        layeredPane.add(btnUserProfile);
        add(layeredPane , 0);
    }
            
    public void sendSuccess() {
        if(lblTime != null) {
            lblTime.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chitchat/icons/tick.png")));
        }
    }
    
    public void seen() {
        if(lblTime != null) {
            lblTime.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chitchat/icons/double_tick.png")));
        }
    }
    
    public void hideText() {
        jtmSendTextPane.setVisible(false);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtmSendTextPane = new chitchat.swing.utilities.JIMSendTextPane();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.PAGE_AXIS));

        jtmSendTextPane.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 5, 10));
        jtmSendTextPane.setSelectionColor(new java.awt.Color(92, 188, 255));
        add(jtmSendTextPane);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private chitchat.swing.utilities.JIMSendTextPane jtmSendTextPane;
    // End of variables declaration//GEN-END:variables
}