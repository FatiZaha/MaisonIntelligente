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
	private boolean Etat;
	
	

    public Abonnement(float Prix,Date date_d, Date date_f, Type t, boolean Etat) {
    	this.Prix=Prix;
    	this.Date_debut=date_d;
    	this.Date_fin=date_f;
    	this.Type_abonnement=t;
    	this.Etat=Etat;
    }

   
   
    public void Payer(boolean etat) throws PaiementException {
       Etat=true;
	   System.out.println("L'abonnement a été payé avec succès.");
    }

    public void Afficher_abonnement()throws AbonnementException {
		System.out.println("Numéro d'abonnement : " + Numero);
		System.out.println("Prix : " + Prix);
		System.out.println("Date de début : " + Date_debut);
		System.out.println("Date de fin : " + Date_fin);
		System.out.println("Type d'abonnement : " + Type_abonnement);
		System.out.println("État : " + (Etat ? "Payé" : "Non payé"));
    }

}