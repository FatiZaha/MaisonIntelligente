package metier;

import java.util.*;


public class Maison {


	private int idMaison;
	private String Nom;

	public theme theme;

	private int idClient;



	public Maison() {

		theme=new theme();
	}

	public int getIdMaison() {
		return idMaison;
	}

	public void setIdMaison(int idMaison) {
		this.idMaison = idMaison;
	}

	public String getNom() {
		return Nom;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public void setNom(String nom) {
		Nom = nom;
	}



	public String ToString() {

		return "";
	}

}