/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chitchat.component;

import app.MessageType;
import chitchat.bannedwords.WordChecker;
import chitchat.emojis.Emoji;
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
        body.setLayout(new MigLayout("fillx", "", "5[bottom]5"));
        sp.setVerticalScrollBar(new ScrollBar());
        sp.getVerticalScrollBar().setBackground(Color.white);
    }

    public void addItemOnLeftSide(MessageReceivingModel data) {
        if (data.getMessageType() == MessageType.TEXT) {
            ChatLeftPart item = new ChatLeftPart();
//        System.out.println(getClass() + " Line 41: " + data.toJsonObject());
            if (data.getReceiverAge() < 10) {
                String msg = WordChecker.isABannedWord(data.getText());
                if (msg != null) {
                    System.out.println("These words are banned as they contain profanity");
                    data.setText(msg);
                }
//            data.setText(msg);
            }

//         String [] msg = data.getText().split(",. ?");
//         for(int i = 0 ; i < msg.length ; i++) {
//             if(WordChecker.isABannedWord(msg[i]) == null) {
//                 System.out.println("Line 52: " + msg[i]);
//             }
//         }
//         System.out.println("Line 55");
//         for(String s : msg) {
//             System.out.print(s);
//         }
//         System.out.println("Line 58");
//        String temp = null;
//        data.getText().trim();
//        for(int i = 0 ; i < data.getText().length() ; i++) {
//            if(i != 0 && data.getText().charAt(i) == ' ' || data.getText().charAt(i) == ',') {
//                
//            }
//            temp = temp + data.getText().charAt(i);
//        }
//        for(int i = 0 ; i < msg.length ; i++) {
//            if(WordChecker.isABannedWord(msg[i]) != null) {
//                if(age < 10) {
//                    System.out.println("Uh hoo... You are too young to use these words...");
//                    
//                }
//            }
//        }
//        System.out.println(getClass() + " Line 46: age = " + age);
            item.setText(data.getText());
            item.setTime();
            body.add(item, "wrap, w 100::80%");
        } else if (data.getMessageType() == MessageType.EMOJI) {
            ChatLeftPart item = new ChatLeftPart();
            item.setEmoji(Emoji.getInstance().getEmoji(Integer.valueOf(data.getText())).getIcon());
            item.setTime();
            body.add(item, "wrap, w 100::80%");
        }
        repaint();
        revalidate();
    }

    public void addItemOnLeftSide(String text, String userProfile, String[] iamge, int age) {
        ChatLeftPartWithProfile item = new ChatLeftPartWithProfile();
//        if(age < 10) {
//            text = WordChecker.isABannedWord(text);
//            if(text != null) {
//                System.out.println("Uh hoo... You are too young to use these words...");
//            }
//        }

        if (age < 10) {
            String msg = WordChecker.isABannedWord(text);
            if (msg != null) {
                System.out.println("Uh hoo... You are too young to use these words...");
                text = msg;
            }
        }

        item.setText(text);
        item.setImage(iamge);
        item.setTime();
        item.setUserProfile(userProfile);
        body.add(item, "wrap, w 100::80%");
        body.repaint();
        body.revalidate();
    }

    public void addItemOnRightSide(MessageSendingModel data) {
        if (data.getMessageType() == MessageType.TEXT) {
            ChatRightPart item = new ChatRightPart();
//        System.out.println(getClass() + " Line 115: " + data.toJsonObject());

            if (data.getSenderAge() < 10) {
                String msg = WordChecker.isABannedWord(data.getText());
                if (msg != null) {
                    System.out.println("Uh hoo... You are too young to use these words...");
                    data.setText(msg);
                }
//            System.out.println(getClass() + " Line 111: " + data.toJsonObject());
//            data.setText(msg);
//            System.out.println(getClass() + " Line 113: message = " + msg + " json = " + data.toJsonObject());
            } else if (data.getReceiverAge() < 10) {
                String msg = WordChecker.isABannedWord(data.getText());
                if (msg != null) {
                    System.out.println("You are chatting with a person whose age is less than 10 year old so you are not allowed to use words containing profanity");
                    data.setText(msg);
                }
//            System.out.println(getClass() + " Line 111: " + data.toJsonObject());
//            data.setText(msg);
//            System.out.println(getClass() + " Line 113: message = " + msg + " json = " + data.toJsonObject());
            }
//        System.out.println(getClass() + " Line 112: " + data.toJsonObject());
//        System.out.println(getClass() + " Line 113: age = " + data.getAge() + "text = " + data.getText());
//        System.out.println(getClass() + " Line 114: " + data);
//        System.out.println(getClass() + " Line 115: " + item);
//        if(data == null || item == null) {
//            System.out.println(getClass() + "Line 117");
//        }
            item.setText(data.getText());
            body.add(item, "wrap, al right, w 100::80%");
            item.setTime();
        } else if (data.getMessageType() == MessageType.EMOJI) {
            ChatRightPart item = new ChatRightPart();
            item.setEmoji(Emoji.getInstance().getEmoji(Integer.valueOf(data.getText())).getIcon());
            body.add(item, "wrap, al right, w 100::80%");
            item.setTime();
        }
        repaint();
        revalidate();
        scrollToBottom();
    }

    public void addFileOnLeftSide(String text, String userProfile, String fileName, String fileSize, int age) {
        ChatLeftPartWithProfile item = new ChatLeftPartWithProfile();

        if (age < 10) {
            String msg = WordChecker.isABannedWord(text);
            if (msg != null) {
                System.out.println("You are chatting with a person whose age is less than 10 year old so you are not allowed to use words containing profanity");
                text = msg;
            }
        }

        item.setText(text);
        item.setFile(fileName, fileSize);
        item.setTime();
        item.setUserProfile(userProfile);
        body.add(item, "wrap, w 100::80%");
        body.repaint();
        body.revalidate();
    }

    public void addFileOnRightSide(String text, String fileName, String fileSize, int age) {
        ChatRightPart item = new ChatRightPart();
        if (age < 10) {
            text = WordChecker.isABannedWord(text);
            if (text != null) {
                System.out.println("You are chatting with a person whose age is less than 10 year old so you are not allowed to use words containing profanity");
            }
        }

        item.setText(text);
        item.setFile(fileName, fileSize);
        body.add(item, "wrap, al right, w 100::80%");
        body.repaint();
        body.revalidate();
    }

    public void addDate(String date) {
        ChatDate item = new ChatDate();
        item.setDate(date);
        body.add(item, "wrap, al center");
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
            .addGap(0, 826, Short.MAX_VALUE)
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 555, Short.MAX_VALUE)
        );

        sp.setViewportView(body);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
