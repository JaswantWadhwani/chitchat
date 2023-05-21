/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chitchat.component;

import java.awt.Color;

/**
 *
 * @author Jatin Wadhwani
 */
public class ChatTitle extends javax.swing.JPanel {

    /**
     * Creates new form ChatTitle
     */
    public ChatTitle() {
        initComponents();
    }

    public void setUserName(String userName) {
        lblName.setText(userName);
    }
    
    public void statusActive() {
        lblStatus.setText("Active now");
        lblStatus.setForeground(new Color(40,147,59));
    }
    
    public void setStatusText(String text) {
        lblStatus.setText(text);
        lblStatus.setForeground(new Color(160,160,160));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        layer = new javax.swing.JLayeredPane();
        lblName = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();

        setBackground(new java.awt.Color(229, 229, 229));
        setPreferredSize(new java.awt.Dimension(400, 40));

        layer.setLayout(new java.awt.GridLayout(0, 1));

        lblName.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblName.setForeground(new java.awt.Color(66, 66, 66));
        lblName.setText("Name");
        layer.add(lblName);

        lblStatus.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblStatus.setForeground(new java.awt.Color(40, 145, 60));
        lblStatus.setText("Active now");
        layer.add(lblStatus);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(layer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 387, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layer, javax.swing.GroupLayout.Alignment.TRAILING)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane layer;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblStatus;
    // End of variables declaration//GEN-END:variables
}
