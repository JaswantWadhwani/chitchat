/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chitchat.event;

/**
 *
 * @author Jatin Wadhwani
 */
import chitchat.models.UserAccountModel;
import java.util.List;

public interface EventLeftMenu {

    public void newUser(List<UserAccountModel> users);
}