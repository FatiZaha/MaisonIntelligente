package DAO;

import metier.Appareil;
import metier.Piece;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

public class LesAppareils {

	DataManager dm= new DataManager();
	public ArrayList<Appareil> a;

	public LesAppareils(int idPiece) {
		this.a = new ArrayList<Appareil>();
		GetAppareils(idPiece);
	}
	public void GetAppareils(int idPiece){
		this.a.clear();
		String appareils = "Select a.id as idAppareil,nom,th.id,image,etat,code FROM appareil a join theme_appareil th on a.theme=th.id where code=?;";
		PreparedStatement statement = null;

		try {
			statement = dm.conx.prepareStatement(appareils);
			statement.setInt(1,idPiece);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Appareil appareil = new Appareil();
				appareil.setId(resultSet.getInt("idAppareil"));
				appareil.setNom(resultSet.getString("nom"));
				appareil.theme.id=resultSet.getInt("id");
				appareil.theme.image=resultSet.getString("image");
				appareil.setEtat(resultSet.getBoolean("etat"));
				appareil.setIdPiece(resultSet.getInt("code"));
				this.a.add(appareil);
				// Traitez les données récupérées selon vos besoins

			}

			//conx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public boolean Ajouter_appareil(Appareil appareil) {
		if (this.a.stream().anyMatch(e -> e.getNom().equals(appareil.getNom()))) return false;

		String appareils = "insert into appareil (nom,etat,code,theme) values (?,?,?,?);";

		PreparedStatement statement = null;

		try {
			statement = dm.conx.prepareStatement(appareils);

			statement.setString(1, appareil.getNom());
			statement.setBoolean(2, appareil.isEtat());
			statement.setInt(3, appareil.getIdPiece());
			statement.setInt(4, appareil.theme.id);
			int resultSet = statement.executeUpdate();
			GetAppareils(appareil.getIdPiece());
			return true;

			//conx.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}


	}


	public boolean Supprimer_appareil(Appareil appareil) {

		String appareils = "DELETE FROM appareil WHERE id = ?";

		PreparedStatement statement = null;

		try {
			statement = dm.conx.prepareStatement(appareils);

			statement.setInt(1, appareil.getId());
			int resultSet = statement.executeUpdate();
			GetAppareils(appareil.getIdPiece());
			return true;

			//conx.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}


	public ArrayList<Appareil> Rechercher_appareil(String nom) {

		return a.stream()
				.filter(appareil -> nom.equals(appareil.getNom()))
				.collect(Collectors.toCollection(ArrayList::new));
	}

	public void Modifier_appareil(Appareil appareil) {

		String appareils = "UPDATE appareil SET nom = ? WHERE (id = ?)";

		PreparedStatement statement = null;

		try {
			statement = dm.conx.prepareStatement(appareils);
			statement.setString(1,appareil.getNom());
			statement.setInt(2, appareil.getId());
			int resultSet = statement.executeUpdate();
			GetAppareils(appareil.getIdPiece());


			//conx.close();
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}
	public void changeEtat_appareil(Appareil appareil) {

		String appareils;
		if (appareil.isEtat()) appareils = "UPDATE appareil SET etat=1 WHERE id = ?";
		else appareils = "UPDATE appareil SET etat=0 WHERE id = ?";

		PreparedStatement statement = null;

		try {
			statement = dm.conx.prepareStatement(appareils);
			statement.setInt(1, appareil.getId());
			int resultSet = statement.executeUpdate();
			GetAppareils(appareil.getIdPiece());


			//conx.close();
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}
		
}
