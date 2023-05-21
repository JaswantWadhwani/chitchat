/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chitchat.models;

/**
 *
 * @author Jatin Wadhwani
 */
public class MessageModel {
    private boolean action;
    private String message;
    
    public MessageModel(boolean action, String message) {
        this.action = action;
        this.message = message;
    }
    
    public MessageModel() {
        
    }
    
    public boolean isAction() {
        return action;
    }

    public void setAction(boolean action) {
        this.action = action;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
