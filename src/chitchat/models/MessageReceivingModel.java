/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chitchat.models;

import app.MessageType;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Jatin Wadhwani
 */
public class MessageReceivingModel {
    private int fromUserID;
    private String text;
    private int senderAge;
    private int receiverAge;
    private MessageType messageType;

    public MessageReceivingModel(int fromUserID, String text, int senderAge, int receiverAge, MessageType messageType) {
        this.fromUserID = fromUserID;
        this.text = text;
        this.senderAge = senderAge;
        this.receiverAge = receiverAge;
        this.messageType = messageType;
    }

    public int getFromUserID() {
        return fromUserID;
    }

    public void setFromUserID(int fromUserID) {
        this.fromUserID = fromUserID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getSenderAge() {
        return senderAge;
    }

    public void setSenderAge(int senderAge) {
        this.senderAge = senderAge;
    }

    public int getReceiverAge() {
        return receiverAge;
    }

    public void setReceiverAge(int receiverAge) {
        this.receiverAge = receiverAge;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }
    
    

    public MessageReceivingModel(Object json) {
        JSONObject obj = (JSONObject) json;
        try {
            fromUserID = obj.getInt("fromUserID");
            text = obj.getString("text");
            senderAge = obj.getInt("senderAge");
            receiverAge = obj.getInt("receiverAge");
            messageType = MessageType.toMessageType(obj.getInt("messageType"));
        } catch (JSONException e) {
            System.err.println(e);
        }
    }

    public JSONObject toJsonObject() {
        try {
            JSONObject json = new JSONObject();
            json.put("fromUserID", fromUserID);
            json.put("text", text);
            json.put("senderAge", senderAge);
            json.put("receiverAge", receiverAge);
            json.put("messageType", messageType.getValue());
            return json;
        } catch (JSONException e) {
            return null;
        }
    }
}
