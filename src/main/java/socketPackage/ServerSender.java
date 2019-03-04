/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketPackage;

import Entity.RequestServer;
import Entity.ResponseServer;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author niloufar
 */
public class ServerSender extends Thread {
public void sendResponseToClient(ResponseServer rs,String IP){
    try {
            Socket s = new Socket(IP, 5000);

            ObjectOutputStream dos = new ObjectOutputStream((s.getOutputStream()));
            dos.writeObject(rs);
            
           // dos.writeUTF(contact);

        } catch (IOException ie) {
            ie.printStackTrace();
        }
}
public void sendRequestToClient(RequestServer rs,String IP){
try {
            Socket s = new Socket(IP, 5000);

            ObjectOutputStream dos = new ObjectOutputStream((s.getOutputStream()));
            dos.writeObject(rs);
            
           // dos.writeUTF(contact);

        } catch (IOException ie) {
            ie.printStackTrace();
        }}

//    public void sendResponseToUser(String message, String IP) {
////        Contact contact = new Contact();
////        contact.setName("niloooooo");
////        contact.setIP("909898");
////        contact.setMobile((long)91217666);
////        contact.setHomeNumber((long)912176);
////        
//        try {
//            Socket s = new Socket(IP, 1999);
//
//            ObjectOutputStream dos = new ObjectOutputStream((s.getOutputStream()));
//           // dos.writeObject(contact);
//            
//           // dos.writeUTF(contact);
//
//        } catch (IOException ie) {
//            ie.printStackTrace();
//        }
//    }
}
