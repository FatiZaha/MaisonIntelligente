package DAO;
import metier.Maison;
import metier.Piece;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

public class LesPieces {

	DataManager dm= new DataManager();
	public ArrayList<Piece> p;

	public LesPieces(int idMaison) {
		this.p = new ArrayList<Piece>();
		GetPieces(idMaison);
	}
	public void GetPieces(int idMaison){
		this.p.clear();
		String pieces = "Select numero,nom,id,image,code FROM piece p join theme_piece th on p.theme=th.id where numero=?;";
		PreparedStatement statement = null;

		try {
			statement = dm.conx.prepareStatement(pieces);
			statement.setInt(1,idMaison);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Piece piece = new Piece();
				piece.setIdMaison(resultSet.getInt("numero"));
				piece.setNom(resultSet.getString("nom"));
				piece.theme.id=resultSet.getInt("id");
				piece.theme.image=resultSet.getString("image");
				piece.setCode(resultSet.getInt("code"));
				this.p.add(piece);
				// Traitez les données récupérées selon vos besoins

			}

			//conx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public boolean Ajouter_piece(Piece piece) {
		if (this.p.stream().anyMatch(e -> e.getNom().equals(piece.getNom()) && e.getIdMaison()==piece.getIdMaison())) return false;

		String pieces = "insert into piece (nom,numero,theme) values (?,?,?);";

		PreparedStatement statement = null;

		try {
			statement = dm.conx.prepareStatement(pieces);

			statement.setString(1, piece.getNom());
			statement.setInt(2, piece.getIdMaison());
			statement.setInt(3, piece.theme.id);
			int resultSet = statement.executeUpdate();
			GetPieces(piece.getIdMaison());
			return true;

			//conx.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}


	}


	public boolean Supprimer_piece(Piece piece) {

		String pieces = "DELETE FROM piece WHERE code = ?";

		PreparedStatement statement = null;

		try {
			statement = dm.conx.prepareStatement(pieces);

			statement.setInt(1, piece.getCode());
			int resultSet = statement.executeUpdate();
			GetPieces(piece.getIdMaison());
			return true;

			//conx.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}


	public ArrayList<Piece> Rechercher_piece(String nom) {

		return p.stream()
				.filter(piece -> nom.equals(piece.getNom()))
				.collect(Collectors.toCollection(ArrayList::new));
	}

	public void Modifier_piece(Piece piece) {

		String pieces = "UPDATE piece SET nom = ?, theme = ? WHERE code = ?";

		PreparedStatement statement = null;

		try {
			statement = dm.conx.prepareStatement(pieces);
			statement.setString(1,piece.getNom());
			statement.setInt(2,piece.theme.id);
			statement.setInt(3, piece.getCode());
			int resultSet = statement.executeUpdate();
			GetPieces(piece.getIdMaison());


			//conx.close();
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}
}
	    

