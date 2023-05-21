/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chitchat.event;

import chitchat.models.MessageModel;

/**
 *
 * @author Jatin Wadhwani
 */
public interface EventMessage {
    public void callMessage(MessageModel message);
}
