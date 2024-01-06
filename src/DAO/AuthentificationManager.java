/*package DAO;
import java.sql.*;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthentificationManager {

    public static boolean verifyCredentials(String username, String password) {
        String query = "SELECT * FROM client WHERE nom_utilisateur = ? AND mot_de_passe = ?";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/smart_home", "root", "Fbs123@@");
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
*/





