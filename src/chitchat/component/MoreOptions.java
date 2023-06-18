/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chitchat.component;

import app.MessageType;
import chitchat.emojis.Emoji;
import chitchat.emojis.EmojiModel;
import chitchat.event.PublicEvent;
import chitchat.gui.HomeScreen;
import chitchat.models.MessageSendingModel;
import chitchat.models.UserAccountModel;
import chitchat.services.Service;
import chitchat.swing.utilities.ScrollBar;
import chitchat.swing.utilities.WrapLayout;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Jatin Wadhwani
 */
public class MoreOptions extends javax.swing.JPanel {

    /**
     * Creates new form MoreOptions
     */

    private UserAccountModel user;
    
    public UserAccountModel getUser() {
        return user;
    }

    public void setUser(UserAccountModel user) {
        this.user = user;
    }

    public MoreOptions() {
        initComponents();
        init();
    }

    private void init() {
        setLayout(new MigLayout("fillx"));
        panelHeader = new JPanel();
        panelHeader.setLayout(new BoxLayout(panelHeader, BoxLayout.LINE_AXIS));
        panelHeader.add(getButtonFile());
        panelHeader.add(getEmojiStyle1());
        panelHeader.add(getEmojiStyle2());
        add(panelHeader, "w 100%, h 30!, wrap");
        panelDetail = new JPanel();

        panelDetail.setLayout(new WrapLayout(WrapLayout.LEFT));

        JScrollPane scroll = new JScrollPane(panelDetail);
        scroll.setBorder(null);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBar(new ScrollBar());
        add(scroll, "w 100%, h 100%");

    }

    private JButton getButtonFile() {
        OptionButton cmd = new OptionButton();
        cmd.setIcon(new ImageIcon(getClass().getResource("/chitchat/icons/link.png")));
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JFileChooser ch = new JFileChooser();
                ch.showOpenDialog(HomeScreen.getFrames()[0]);
            }
        });
        return cmd;
    }

    private JButton getEmojiStyle1() {
        OptionButton cmd = new OptionButton();
        cmd.setIcon(Emoji.getInstance().getEmoji(1).toSize(25, 25).getIcon());
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                clearSelected();
                cmd.setSelected(true);
                panelDetail.removeAll();
                for (EmojiModel d : Emoji.getInstance().getStyle1()) {
                    panelDetail.add(getButton(d));
                }
                panelDetail.repaint();
                panelDetail.revalidate();
            }
        });
        return cmd;
    }

    private JButton getEmojiStyle2() {
        OptionButton cmd = new OptionButton();
        cmd.setIcon(Emoji.getInstance().getEmoji(21).toSize(25, 25).getIcon());
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                clearSelected();
                cmd.setSelected(true);
                panelDetail.removeAll();
                for (EmojiModel d : Emoji.getInstance().getStyle2()) {
                    panelDetail.add(getButton(d));
                }
                panelDetail.repaint();
                panelDetail.revalidate();
            }
        });
        return cmd;
    }

    private JButton getButton(EmojiModel emoji) {
        JButton cmd = new JButton(emoji.getIcon());
        cmd.setName(emoji.getId() + "");
        cmd.setBorder(new EmptyBorder(3, 3, 3, 3));
        cmd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmd.setContentAreaFilled(false);
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                MessageSendingModel message = new MessageSendingModel(Service.getInstance().getUser().getUserId(), user.getUserId(), Service.getInstance().getUser().getAge(), user.getAge(), emoji.getId() + "", MessageType.EMOJI);
                sendMessage(message);
                PublicEvent.getInstance().getEventChat().sendMessage(message);
            }
        });
        return cmd;
    }

    private void sendMessage(MessageSendingModel data) {
        Service.getInstance().getClient().emit("send_to_user", data.toJsonObject());
    }
    
    private void clearSelected() {
        for (Component c : panelHeader.getComponents()) {
            if (c instanceof OptionButton) {
                ((OptionButton) c).setSelected(false);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private JPanel panelHeader;
    private JPanel panelDetail;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
