package DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

import metier.Appareil;
import metier.Client;
import metier.LesExceptions.ConnexionException;
import metier.LesExceptions.InscriptionException;

public class LesClients{

	DataManager dm= new DataManager();
	public ArrayList<Client> c;

	public LesClients() {
		this.c = new ArrayList<Client>();
		GetClients();
	}
	public void GetClients(){
		this.c.clear();
		String clients = "Select * FROM client;";
		PreparedStatement statement = null;

		try {
			statement = dm.conx.prepareStatement(clients);

			ResultSet resultSet = statement.executeQuery();
			Client client = new Client();
			while (resultSet.next()) {
				client.setId(resultSet.getInt("idclient"));
				client.setNom(resultSet.getString("Nom"));
				client.setPrenom(resultSet.getString("Prenom"));
				client.setTel(resultSet.getString("Tel"));
				client.setEmail(resultSet.getString("Email"));
				client.setAdresse(resultSet.getString("Adresse"));
				client.setNom_utilisateur(resultSet.getString("Nom_utilisateur"));
				client.setMot_de_passe(resultSet.getString("Mot_de_passe"));
				this.c.add(client);
				// Traitez les données récupérées selon vos besoins

			}

			//conx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public boolean Inscription(Client client) {
		if (this.c.stream().anyMatch(e -> e.getEmail().equals(client.getEmail()) && e.getNom_utilisateur().equals(client.getNom_utilisateur()))) return false;

		String clients = "insert into client (Nom,Prenom,Tel,Email,Adresse,Nom_utilisateur,Mot_de_passe) values (?,?,?,?,?,?,?);";

		PreparedStatement statement = null;

		try {
			statement = dm.conx.prepareStatement(clients);

			statement.setString(1, client.getNom());
			statement.setString(2, client.getPrenom());
			statement.setString(3, client.getTel());
			statement.setString(4, client.getEmail());
			statement.setString(5, client.getAdresse());
			statement.setString(6, client.getNom_utilisateur());
			statement.setString(7, client.getMot_de_passe());
			int resultSet = statement.executeUpdate();
			GetClients();
			return true;

			//conx.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public Client Connexion(String login,String password) {

		return c.stream()
				.filter(cl -> cl.getNom_utilisateur().equals(login) && cl.getMot_de_passe().equals(password))
				.findFirst()
				.orElse(null);
	}



    
}
