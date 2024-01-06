package metier;

//import java.util.*;

public class Appareil {
	
	  private String Id;
	  private String Nom;
	  private boolean Etat;
  
   
    public Appareil(String nom) {
		Etat=false;
		Nom = nom;
	}



	public String getNom() {
		return Nom;
	}



	public void setNom(String nom) {
		Nom = nom;
	}



	public boolean isEtat() {
		return Etat;
	}



	public void setEtat(boolean etat) {
		Etat = etat;
	}



	public String ToString() {
       return "Appareil[Nom=" +Nom+ ",Etat=" +Etat+ "]";
    }
}