package metier;

import metier.LesExceptions.AbonnementException;
import metier.LesExceptions.PaiementException;

import java.util.*;

public class Abonnement {
	
	private int Numero;
	private float Prix;
	private Date Date_debut;
	private Date Date_fin;
	private Type Type_abonnement;
	
	private int idClient;

    public Abonnement() {

    }


	public int getNumero() {
		return Numero;
	}

	public void setNumero(int numero) {
		Numero = numero;
	}

	public float getPrix() {
		return Prix;
	}

	public void setPrix(float prix) {
		Prix = prix;
	}

	public Date getDate_debut() {
		return Date_debut;
	}

	public void setDate_debut(Date date_debut) {
		Date_debut = date_debut;
	}

	public Date getDate_fin() {
		return Date_fin;
	}

	public void setDate_fin(Date date_fin) {
		Date_fin = date_fin;
	}

	public Type getType_abonnement() {
		return Type_abonnement;
	}

	public void setType_abonnement(Type type_abonnement) {
		Type_abonnement = type_abonnement;
	}



	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
}