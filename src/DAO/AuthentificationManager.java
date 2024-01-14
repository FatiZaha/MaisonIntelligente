package DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AuthentificationManager {

    public Connection verifyCredentials(String username, String password) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/smart_home", username, password);

             return connection;
        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


}



