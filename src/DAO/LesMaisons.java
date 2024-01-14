package DAO;
import metier.Maison;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

public class LesMaisons{

	DataManager dm= new DataManager();
	public ArrayList<Maison> m;
	
	    public LesMaisons(int idClient) {
			this.m = new ArrayList<Maison>();
			GetMaisons(idClient);
		}
		public void GetMaisons(int idClient){
			this.m.clear();
			String maisons = "Select numero,nom,id,image,idClient FROM maison m join theme_maison th on m.theme=th.id where idClient=?;";
			PreparedStatement statement = null;

			try {
				statement = dm.conx.prepareStatement(maisons);
				statement.setInt(1,idClient);
				ResultSet resultSet = statement.executeQuery();

				while (resultSet.next()) {
					Maison maison = new Maison();
					maison.setIdMaison(resultSet.getInt("numero"));
					maison.setNom(resultSet.getString("nom"));
					maison.theme.id=resultSet.getInt("id");
					maison.theme.image=resultSet.getString("image");
					maison.setIdClient(resultSet.getInt("idClient"));
					this.m.add(maison);
					// Traitez les données récupérées selon vos besoins

				}

				//conx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}


		public boolean Ajouter_maison(Maison maison) {
		    if (this.m.stream().anyMatch(e -> e.getNom().equals(maison.getNom()) && e.getIdClient()==maison.getIdClient())) return false;

			String maisons = "insert into maison values (?,?,?);";

			PreparedStatement statement = null;

			try {
				statement = dm.conx.prepareStatement(maisons);

				statement.setString(1, maison.getNom());
				statement.setInt(2, maison.theme.id);
				statement.setInt(3, maison.getIdClient());
				int resultSet = statement.executeUpdate();
				GetMaisons(maison.getIdClient());
				return true;

				//conx.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}


	    }
		
	    
	    public boolean Supprimer_maison(Maison maison) {

			String maisons = "DELETE FROM maison WHERE numero = ?";

			PreparedStatement statement = null;

			try {
				statement = dm.conx.prepareStatement(maisons);

				statement.setInt(1, maison.getIdMaison());
				int resultSet = statement.executeUpdate();
				GetMaisons(maison.getIdClient());
				return true;

				//conx.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
	      
	    }

	   
		public ArrayList<Maison> Rechercher_maison(String nom) {

			return m.stream()
					.filter(maison -> nom.equals(maison.getNom()))
					.collect(Collectors.toCollection(ArrayList::new));
		    }

	    public void Modifier_maison(Maison maison) {

			String maisons = "UPDATE maison SET nom = ?, theme = ? WHERE numero = ?";

			PreparedStatement statement = null;

			try {
				statement = dm.conx.prepareStatement(maisons);
				statement.setString(1,maison.getNom());
				statement.setInt(2,maison.theme.id);
				statement.setInt(3, maison.getIdMaison());
				int resultSet = statement.executeUpdate();
				GetMaisons(maison.getIdClient());


				//conx.close();
			} catch (SQLException e) {
				e.printStackTrace();

			}
		}

}
