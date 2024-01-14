package metier;

/*import java.util.*;*/


public class Piece {
	
	 private int Code;
	 private String Nom;

	public theme theme;
	private int idMaison;
   
    public Piece() {
		theme=new theme();
	}

	public int getCode() {
		return Code;
	}

	public void setCode(int code) {
		Code = code;
	}

	public String getNom() {
		return Nom;
	}



	public void setNom(String nom) {
		Nom = nom;
	}

	public int getIdMaison() {
		return idMaison;
	}

	public void setIdMaison(int idMaison) {
		this.idMaison = idMaison;
	}

	public String ToString() {
        
        return "Piece [Code=" + Code + ", Nom=" + Nom + "]";
    }
    

}