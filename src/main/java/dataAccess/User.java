/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess;

//import com.mysql.jdbc.Driver;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author niloufar
 */
public class User {

    public int addRelationUser(int clientUserId, int relatUserId) {

        try {
            // create a mysql database connection
            String myUrl = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            Connection conn = DriverManager.getConnection(myUrl, "root", "212121");
            // the mysql insert message
            String query = " insert into messengerdb.userrelations (userId, relatUserId)"
                    + " values (?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, clientUserId);
            preparedStmt.setInt(2, relatUserId);

            // execute the preparedstatement
            preparedStmt.execute();

            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        return 0;

    }

    public boolean findRelateUserByUserName(String reqUserName, String comUserName) {
        try {
            // create a mysql database connection
            String myUrl = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            Connection conn = DriverManager.getConnection(myUrl, "root", "212121");
            // the mysql find relateUser
            String query = "SELECT  u.Username FROM  messengerdb.userrelations AS r INNER JOIN "
                    + "messengerdb.users AS u ON r.RelatUserId = u.userId "
                    + "WHERE "
                    + "r.Username = ? AND u.Username = ?";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, reqUserName);
            preparedStmt.setString(2, comUserName);

            // execute the preparedstatement, and get result
            ResultSet rs = preparedStmt.executeQuery();
            //check rs has data or not
            if (!rs.isBeforeFirst()) {
                conn.close();
                return false;
            } else {
                conn.close();
                return true;
            }
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());

        }
        return false;
    }

    public ResultSet getAllRelatinalUser(int clientUserId) {
        ResultSet rs = null;
        try {
            // create a mysql database connection
            String myUrl = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            Connection conn = DriverManager.getConnection(myUrl, "root", "212121");
            // the mysql find relateUser
            String query = "SELECT \n"
                    + "    u.*"
                    + " FROM"
                    + " messengerdb.userrelations AS r"
                    + " INNER JOIN\n"
                    + " messengerdb.users AS u ON r.RelatUserId = u.userId"
                    + " WHERE"
                    + " r.userid = ? ";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, clientUserId);

            // execute the preparedstatement, and get result
            rs = preparedStmt.executeQuery();

        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());

        }

        return rs;
    }

    public String getUserIpByUserId(int UserId) {
        try {
            // create a mysql database connection
            String myUrl = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            Connection conn = DriverManager.getConnection(myUrl, "root", "212121");
            // the mysql find relateUser
            String query = "SELECT \n"
                    + "u.IP\n"
                    + "FROM\n"
                    + "messengerdb.users AS u\n"
                    + "WHERE\n"
                    + "u.userid = ? ";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, UserId);

            // execute the preparedstatement, and get result
            ResultSet rs = preparedStmt.executeQuery();
            //check rs has data or not
            if (!rs.isBeforeFirst()) {
                conn.close();
                return "";
            } else {
                rs.next();
                String IP = rs.getString("IP");
                conn.close();
                return IP;
            }

        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());

        }

        return null;
    }

    public String getUserIpByUserName(String UserName) {
        try {
            // create a mysql database connection
            String myUrl = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            Connection conn = DriverManager.getConnection(myUrl, "root", "212121");
            // the mysql find relateUser
            String query = "SELECT \n"
                    + "u.IP\n"
                    + "FROM\n"
                    + "messengerdb.users AS u\n"
                    + "WHERE\n"
                    + "u.username = ? ";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, UserName);

            // execute the preparedstatement, and get result
            ResultSet rs = preparedStmt.executeQuery();
            //check rs has data or not
            if (!rs.isBeforeFirst()) {
                conn.close();
                return "";
            } else {
                rs.next();
                String IP = rs.getString("IP");
                conn.close();
                return IP;
            }

        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());

        }

        return null;
    }

}
