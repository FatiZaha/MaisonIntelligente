package DAO;

import metier.Abonnement;
import metier.Type;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class LesTypes {
    DataManager dm= new DataManager();
    public HashMap<Type,Float> types;
    public LesTypes(){
        this.types=new HashMap<Type,Float>();
        GetTypes();
    }
    private void GetTypes(){
        String type = "Select prix FROM type;";
        PreparedStatement statement = null;

        try {
            statement = dm.conx.prepareStatement(type);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                types.put(Type.Mensuel, resultSet.getFloat("prix"));
            }

            if (resultSet.next()) {
                types.put(Type.Semestriel, resultSet.getFloat("prix"));
            }

            if (resultSet.next()) {
                types.put(Type.Annuel, resultSet.getFloat("prix"));
            }
            //conx.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
