/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketPackage;

import dataAccess.User;
import java.sql.Date;
import java.sql.ResultSet;

/**
 *
 * @author niloufar
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     ServerListener test =new ServerListener();
     test.run();
//        test.addRelationUser(1, 2);
//        test.addRelationUser(1, 3);
//        System.out.println("add"); 
//        AddMessage testM =new AddMessage();
//        Date d;
//        testM.insertMessage("salam", 1,2);
//        System.out.println("add message");
        
//        String rs= test.getUserIpByUserId(1);
//        System.out.println("add message "+rs);
     
    }
    
}
