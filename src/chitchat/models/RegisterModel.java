/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chitchat.models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Jatin Wadhwani
 */
public class RegisterModel {
    private String userName;
    private String password;
    private int age;
    
    public RegisterModel() {
//    System.out.println(getClass() + " Line 21(Inside Constructor)");
        
    }
    
    public RegisterModel(String userName, String password, int age) {
        this.userName = userName;
        this.password = password;
        this.age = age;
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public int getAge() {
        return age;
    }
    
    public JSONObject toJsonObject() {
        try {
//            System.out.println(getClass() + " Inside jsonObject()");
            JSONObject json = new JSONObject();
            json.put("userName", userName);
            json.put("password", password);
            json.put("age", age);
            return json;
        } 
        catch (JSONException ex) {
            return null;
        }
    }
}
