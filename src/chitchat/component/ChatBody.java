/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chitchat.component;

import chitchat.models.MessageReceivingModel;
import chitchat.models.MessageSendingModel;
import chitchat.swing.utilities.ScrollBar;
import java.awt.Adjustable;
import java.awt.Color;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.JScrollBar;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Jatin Wadhwani
 */
public class ChatBody extends javax.swing.JPanel {

    /**
     * Creates new form ChatBody
     */
    public ChatBody() {
        initComponents();
        init();
    }

    private void init() {
        body.setLayout(new MigLayout("fillx" , "" , "5[]5"));
        sp.setVerticalScrollBar(new ScrollBar());
        sp.getVerticalScrollBar().setBackground(Color.white);
    }
    
    public void addItemOnLeftSide(MessageReceivingModel data) {
        ChatLeftPart item = new ChatLeftPart();
        item.setText(data.getText());
        item.setTime();
        body.add(item , "wrap , w 100::80%");
        repaint();
        revalidate();
    }
    
    public void addItemOnLeftSide(String text , String userProfile , String [] iamge) {
        ChatLeftPartWithProfile item = new ChatLeftPartWithProfile();
        item.setText(text);
        item.setImage(iamge);
        item.setTime();
        item.setUserProfile(userProfile);
        body.add(item , "wrap , w 100::80%");
        body.repaint();
        body.revalidate();
    }
    
    public void addItemOnRightSide(MessageSendingModel data) {
        ChatRightPart item = new ChatRightPart();
        item.setText(data.getText());
        body.add(item , "wrap , al right , w 100::80%");
        repaint();
        revalidate();
        item.setTime();
        scrollToBottom();
    }
    
    public void addFileOnLeftSide(String text , String userProfile , String fileName , String fileSize) {
        ChatLeftPartWithProfile item = new ChatLeftPartWithProfile();
        item.setText(text);
        item.setFile(fileName, fileSize);
        item.setTime();
        item.setUserProfile(userProfile);
        body.add(item , "wrap , w 100::80%");
        body.repaint();
        body.revalidate();
    }
    
    public void addFileOnRightSide(String text , String fileName , String fileSize) {
        ChatRightPart item = new ChatRightPart();
        item.setText(text);
        item.setFile(fileName, fileSize);
        body.add(item , "wrap , al right , w 100::80%");
        body.repaint();
        body.revalidate();
    }
    
    public void addDate(String date) {
        ChatDate item = new ChatDate();
        item.setDate(date);
        body.add(item , "wrap , al center");
        body.repaint();
        body.revalidate();
    }
    
    public void clearChat() {
        body.removeAll();
        repaint();
        revalidate();
    }
    
    private void scrollToBottom() {
        JScrollBar verticalBar = sp.getVerticalScrollBar();
        AdjustmentListener downScroller = new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                Adjustable adjustable = e.getAdjustable();
                adjustable.setValue(adjustable.getMaximum());
                verticalBar.removeAdjustmentListener(this);
            }
        };
        verticalBar.addAdjustmentListener(downScroller);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp = new javax.swing.JScrollPane();
        body = new javax.swing.JPanel();

        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        body.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout bodyLayout = new javax.swing.GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 694, Short.MAX_VALUE)
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 519, Short.MAX_VALUE)
        );

        sp.setViewportView(body);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
