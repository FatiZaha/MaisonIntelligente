package metier;

//import java.util.*;

public class Appareil {
	
	  private int Id;
	  private String Nom;
	  private boolean Etat;
	  private int idPiece;
	  public theme theme;
  
   
    public Appareil() {

		theme=new theme();
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getIdPiece() {
		return idPiece;
	}

	public void setIdPiece(int idPiece) {
		this.idPiece = idPiece;
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