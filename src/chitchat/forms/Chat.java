package chitchat.forms;

import chitchat.component.ChatBody;
import chitchat.component.ChatFooter;
import chitchat.component.ChatTitle;
import chitchat.event.EventChat;
import chitchat.event.PublicEvent;
import chitchat.models.MessageReceivingModel;
import chitchat.models.MessageSendingModel;
import chitchat.models.UserAccountModel;
import net.miginfocom.swing.MigLayout;

public class Chat extends javax.swing.JPanel {

    private ChatTitle chatTitle;
    private ChatBody chatBody;
    private ChatFooter chatFooter;

    public Chat() {
        initComponents();
        init();
    }

    private void init() {
        setLayout(new MigLayout("fillx", "0[fill]0", "0[]0[100%, fill]0[shrink 0]0"));
        chatTitle = new ChatTitle();
        chatBody = new ChatBody();
        chatFooter = new ChatFooter();
        PublicEvent.getInstance().addEventChat(new EventChat() {
            @Override
            public void sendMessage(MessageSendingModel data) {
//                System.out.println("Line 44:  Sender's id: "+data.getFromUserID()+"Sender's age: "+data.getAge());
//                System.out.println(getClass()+" Line 45: " + data.toJsonObject() + " age = " + data.getAge());
//                if(data != null) {
//                    System.out.println(getClass() + "Line 47: "+data);
//                }
//                System.out.println(getClass()+" Line 49: " + data + " " + data.toJsonObject() + " age = " + data.getAge());                
                chatBody.addItemOnRightSide(data);
            }

            @Override
            public void receiveMessage(MessageReceivingModel data) {
                if (chatTitle.getUser().getUserId() == data.getFromUserID()) {
//                    System.out.println(getClass()+" Line 53: "+data.toJsonObject() + " receiver's age = " + data.getSenderAge());
//                    System.out.println("Line 52: Receiver's name:"+chatTitle.getUser().getUserName()+" Receiver's age: "+chatTitle.getUser().getAge());
//                    System.out.println(getClass() + "Line 50: "+data.toJsonObject());
//                    System.out.println(getClass() + "Line 51: "+data.getText());
//                    System.out.println(getClass() + "Line 52: "+data.getFromUserID());
//                    System.out.println(getClass() + "Line 53: "+ chatTitle.getUser().getUserName());
//                    System.out.println(getClass() + "Line 54: "+ chatTitle.getUser().getAge());
//                    System.out.println(getClass() + "Line 55: "+ chatTitle.getUser().getUserId());
                    chatBody.addItemOnLeftSide(data);
//                    System.out.println(getClass()+" Line 62: "+data.toJsonObject() + " sender's age = " + data.getSenderAge());
                }
            }
        });
        add(chatTitle, "wrap");
        add(chatBody, "wrap");
        add(chatFooter, "h ::50%");
    }

    public void setUser(UserAccountModel user) {
        chatTitle.setUserName(user);
        chatFooter.setUser(user);
        chatBody.clearChat();
    }

    public void updateUser(UserAccountModel user) {
        chatTitle.updateUser(user);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 727, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 681, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
