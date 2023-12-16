package metier;

import java.util.*;

/**
 * 
 */
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

   
   
    public void Payer(boolean etat) {
       Etat=true;
    }

   
    public void Afficher_abonnement() {
       
    }

}