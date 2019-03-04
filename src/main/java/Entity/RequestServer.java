/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author niloufar
 */
public class RequestServer {
     int action;
     String communicateUserName;
     String requestUserName;
     String message;
    
    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public String getCommunicateUserName() {
        return communicateUserName;
    }

    public void setCommunicateUserName(String communicateUserName) {
        this.communicateUserName = communicateUserName;
    }

    public String getRequestUserName() {
        return requestUserName;
    }

    public void setRequestUserName(String requestUserName) {
        this.requestUserName = requestUserName;
    }

   
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
   
    
}
