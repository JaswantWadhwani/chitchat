/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chitchat.component;

import chitchat.event.PublicEvent;
import chitchat.swing.utilities.JIMSendTextPane;
import chitchat.swing.utilities.ScrollBar;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Jatin Wadhwani
 */
public class ChatFooter extends javax.swing.JPanel {

    /**
     * Creates new form ChatTitle
     */
    public ChatFooter() {
        initComponents();
        init();
    }

    private void init() {
        setLayout(new MigLayout("fillx, filly", "0[fill]0[]0[]2", "2[fill]2"));
        JScrollPane scroll = new JScrollPane();
        scroll.setBorder(null);
        JIMSendTextPane txt = new JIMSendTextPane();
        txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ke) {
                refresh();
            }
        });
        txt.setBorder(new EmptyBorder(5, 5, 5, 5));
        txt.setHintText("Write Message Here ...");
        scroll.setViewportView(txt);
        ScrollBar sb = new ScrollBar();
        sb.setBackground(new Color(229, 229, 229));
        sb.setPreferredSize(new Dimension(2, 10));
        scroll.setVerticalScrollBar(sb);
        add(sb);
        add(scroll, "w 100%");
        JPanel panel = new JPanel();
        panel.setLayout(new MigLayout("filly", "0[]0", "0[bottom]0"));
        panel.setPreferredSize(new Dimension(30, 28));
        panel.setBackground(Color.WHITE);
        JButton cmd = new JButton();
        cmd.setBorder(null);
        cmd.setContentAreaFilled(false);
        cmd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmd.setIcon(new ImageIcon(getClass().getResource("/chitchat/icons/send.png")));
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String text = txt.getText().trim();
                if (!text.equals("")) {
                    PublicEvent.getInstance().getEventChat().sendMessage(text);
                    txt.setText("");
                    txt.grabFocus();
                    refresh();
                } else {
                    txt.grabFocus();
                }
            }
        });
        panel.add(cmd);
        add(panel);
    }

    private void refresh() {
        repaint();
        revalidate();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(229, 229, 229));
        setMinimumSize(new java.awt.Dimension(400, 40));
        setPreferredSize(new java.awt.Dimension(400, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
