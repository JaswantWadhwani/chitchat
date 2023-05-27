/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chitchat.event;

import chitchat.models.UserAccountModel;

/**
 *
 * @author Jatin Wadhwani
 */

public interface EventMain {

    public void showLoading(boolean show);

    public void initChat();
    
    public void selectUser(UserAccountModel user);
    
    public void updateUser(UserAccountModel user);
}