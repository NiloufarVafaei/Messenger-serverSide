package socketPackage;

import Entity.RequestServer;
import Entity.ResponseServer;
import dataAccess.User;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author niloufar
 */
public class ServerListener implements Runnable {

    @Override
    public void run() {
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(5000);
        } catch (IOException ex) {
            Logger.getLogger(ServerListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (true) {
            try {
                Socket s = ss.accept();
                String senderIp = s.getRemoteSocketAddress().toString();
                ObjectInputStream object = new ObjectInputStream(s.getInputStream());

                //  contact =(Contact) object.readObject();
                // Thread t = new Sender(); 
                // t.start();
                // System.out.println("Sender:"+contact.getName());
                RequestServer rq = (RequestServer) object.readObject();
                ServerSender serversender = new ServerSender();
                ResponseServer resser = new ResponseServer();
                RequestServer reqser = new RequestServer();
                User fn = new User();
                switch (rq.getAction()) {
                    case 1:
                        //recive message

                        boolean boa = fn.findRelateUserByUserName(rq.getRequestUserName(), rq.getCommunicateUserName());
                        //sende to clint
                        resser.setResAction(1);
                        resser.setHasData(boa);
                        resser.setCommunicateUserName(rq.getCommunicateUserName());
                        serversender.sendResponseToClient(resser, senderIp);

                    case 2:
                        //send message;
                        reqser.setAction(3);
                        reqser.setRequestUserName(rq.getRequestUserName());
                        reqser.setMessage(rq.getMessage());
                        reqser.setCommunicateUserName(rq.getCommunicateUserName());
                        //find sender Ip
                        String comUserNameIp = fn.getUserIpByUserName(rq.getCommunicateUserName());
                        serversender.sendRequestToClient(reqser, comUserNameIp);

                        //resser.setIPSender(String.valueOf(rq.getRequestUserName()));
                    //search quary in DB for find comunicateUserIp
//                        AddMessages addM =new AddMessages();
//                        addM.insertMessage(resser.getMessage(), resser.getIPSender(),rq.getRequestUserName());
                    case 0:
                        System.exit(0);
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
