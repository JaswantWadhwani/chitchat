/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chitchat.event;

import chitchat.models.LoginModel;
import chitchat.models.RegisterModel;

/**
 *
 * @author Jatin Wadhwani
 */
public interface EventLogin {

    public void login(LoginModel login);

    public void register(RegisterModel data, EventMessage message);

    public void goRegister();

    public void goLogin();
}
