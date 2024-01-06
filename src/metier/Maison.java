package metier;

//import java.util.*;

public class Maison {

    private int Numero;
    private String Nom;
    private int Nombre_pieces;
    
    
    public Maison(String Nom) {
		this.Nom=Nom;
		this.Nombre_pieces=0;
		
	}


    public int getNombre_pieces() {
		return Nombre_pieces;
	}

	public void setNombre_pieces(int nombre_pieces) {
		Nombre_pieces = nombre_pieces;
	}



	public String getNom() {
		return Nom;
	}



	public void setNom(String nom) {
		Nom = nom;
	}



	public String ToString() {
       
        return "Maison [Numero=" + Numero + ", Nom=" + Nom + ", Nombre_pieces=" + Nombre_pieces + "]";
    }

}