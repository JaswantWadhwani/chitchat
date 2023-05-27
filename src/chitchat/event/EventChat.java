/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chitchat.event;

import chitchat.models.MessageReceivingModel;
import chitchat.models.MessageSendingModel;

/**
 *
 * @author Jatin Wadhwani
 */
public interface EventChat {

    public void sendMessage(MessageSendingModel data);

    public void receiveMessage(MessageReceivingModel data);
}