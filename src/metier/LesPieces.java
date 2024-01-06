package metier;
import java.util.*;

public class LesPieces {
	
	private ArrayList<Piece> p;
	
	public LesPieces() {
		p= new ArrayList<Piece>();
	}
	
	
	public void Ajouter_piece(String Nom) {
		 Piece p= new Piece(Nom);
	       this.p.add(p);
	    }

	public void Supprimer_piece(List<String> Nom) {

	    	p.removeIf(piece -> Nom.contains(piece.getNom()));
	    }
	    
	public Piece Rechercher_piece(String Nom) {
	    	return p.stream()
	                .filter(app -> Nom.equals(app.getNom()))
	                .findFirst()
	                .orElse(null);
	    }

	public void Modifier_piece(String Nom, String nouveauNom) {
		Piece p = Rechercher_piece(Nom);
		if (p != null) {
			p.setNom(nouveauNom);
		}
	}
	}
	    

