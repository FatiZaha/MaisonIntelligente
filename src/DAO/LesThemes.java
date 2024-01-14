package DAO;

import metier.Abonnement;
import metier.Type;
import metier.theme;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class LesThemes {
    public ArrayList<theme> theme_maison;
    public ArrayList<theme> theme_piece;
    public ArrayList<theme> theme_appareil;
    DataManager dm= new DataManager();
    public LesThemes(){
        theme_maison = new ArrayList<theme>();
        theme_piece = new ArrayList<theme>();
        theme_appareil = new ArrayList<theme>();

    }

    private void GetThemesMaison(){
        String themes = "Select * FROM theme_maison;";
        PreparedStatement statement = null;

        theme th = new theme();
        try {
            statement = dm.conx.prepareStatement(themes);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                th.setId(resultSet.getInt("id"));
                th.setImage(resultSet.getString("image"));
                theme_maison.add(th);

            }

            //conx.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void GetThemesPieces(){
        String themes = "Select * FROM theme_piece;";
        PreparedStatement statement = null;

        theme th = new theme();
        try {
            statement = dm.conx.prepareStatement(themes);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                th.setId(resultSet.getInt("id"));
                th.setImage(resultSet.getString("image"));
                theme_piece.add(th);

            }

            //conx.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void GetThemesAppareil(){
        String themes = "Select * FROM theme_appareil;";
        PreparedStatement statement = null;

        theme th = new theme();
        try {
            statement = dm.conx.prepareStatement(themes);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                th.setId(resultSet.getInt("id"));
                th.setImage(resultSet.getString("image"));
                theme_appareil.add(th);

            }

            //conx.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
