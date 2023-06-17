/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chitchat.component;

import chitchat.event.PublicEvent;
import chitchat.models.MessageSendingModel;
import chitchat.models.UserAccountModel;
import chitchat.services.Service;
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
    
    private MigLayout mig;
    private MoreOptions moreOptions;
    
    public UserAccountModel getUser() {
        return user;
    }

    public void setUser(UserAccountModel user) {
        this.user = user;
    }

    private UserAccountModel user;

    public ChatFooter() {
        initComponents();
        init();
    }

    private void init() {
        mig = new MigLayout("fillx, filly", "0[fill]0[]0[]2", "2[fill]2[]0");
        setLayout(mig);
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
         panel.setLayout(new MigLayout("filly", "0[]3[]0", "0[bottom]0"));
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
                    MessageSendingModel message = new MessageSendingModel(Service.getInstance().getUser().getUserId(), user.getUserId(), Service.getInstance().getUser().getAge(), user.getAge(), text);
//                    System.out.println(getClass() + " Line 87: age = " + user.getAge());
                    send(message);
//                    System.out.println(getClass() + " Line 89: age = " + user.getAge() + message.getText());
//                    System.out.println(getClass() + "Line 90: sender id = " + Service.getInstance().getUser().getUserId() + "  receiver id = " + user.getUserId() + " age = " + Service.getInstance().getUser().getAge() + " text = " + text + " name = " + Service.getInstance().getUser().getUserName() + " age = " + user.getAge());
                    PublicEvent.getInstance().getEventChat().sendMessage(message);
//                    System.out.println(getClass() + "Line 92");
                    txt.setText("");
                    txt.grabFocus();
                    refresh();
                } else {
                    txt.grabFocus();
                }
            }
        });
        JButton cmdMore = new JButton();
        cmdMore.setBorder(null);
        cmdMore.setContentAreaFilled(false);
        cmdMore.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmdMore.setIcon(new ImageIcon(getClass().getResource("/chitchat/icons/more_disable.png")));
        cmdMore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(moreOptions.isVisible()) {
                    cmdMore.setIcon(new ImageIcon(getClass().getResource("/chitchat/icons/more_disable.png")));
                    moreOptions.setVisible(false);
                    mig.setComponentConstraints(moreOptions, "dock south,h 0!");
                    revalidate();
                }
                else {
                    cmdMore.setIcon(new ImageIcon(getClass().getResource("/chitchat/icons/more.png")));
                    moreOptions.setVisible(true);
                    mig.setComponentConstraints(moreOptions, "dock south,h 170!");
                    revalidate();
                }
            }
        });
        panel.add(cmdMore);
        panel.add(cmd);
        add(panel,"wrap");
        moreOptions = new MoreOptions();
        moreOptions.setVisible(false);
        add(moreOptions,"dock south,h 0!");
    }

    private void send(MessageSendingModel data) {
        Service.getInstance().getClient().emit("send_to_user", data.toJsonObject());
    }

    private void refresh() {
//        repaint();
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
