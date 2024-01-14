package DAO;

import metier.*;

import java.sql.*;
import java.util.ArrayList;

/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;*/
public class DataManager {
    public Connection conx;

    public DataManager() {
        AuthentificationManager test = new AuthentificationManager();
        conx = test.verifyCredentials("root", "123456");

        if (conx != null) {
            //Connection conx = DriverManager.getConnection("jdbc:mysql://localhost:3306/smart_home","root","123456");
            System.out.println(conx);
            // Exemple d'exécution d'une requête

        }
    }



}
