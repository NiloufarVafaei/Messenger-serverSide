/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author niloufar
 */
public class AddMessages {

    public int insertMessage(String text,int SenderId, int RecieverId) {
        try {
            // create a mysql database connection
            String myUrl = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            Connection conn = DriverManager.getConnection(myUrl, "root", "212121");
            // the mysql insert statement
            String query = " insert into messengerdb.messages (Text, SenderId, ReceiverId)"
                    + " values (?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, text);
            preparedStmt.setInt(2, SenderId);
            preparedStmt.setInt(3, RecieverId);
//            preparedStmt.setDate(4, date);
        
            // execute the preparedstatement, and get result
            preparedStmt.execute();

            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        return 0;
    }

}
