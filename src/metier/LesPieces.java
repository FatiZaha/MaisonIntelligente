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
	    	/*for (Piece piece : p) {
			if(Nom.contains(piece.getNom())) p.remove(piece);
			}*/
	    	p.removeIf(piece -> Nom.contains(piece.getNom()));
	    }
	    
	public Piece Rechercher_piece(String Nom) {
	    	return p.stream()
	                .filter(app -> Nom.equals(app.getNom()))
	                .findFirst()
	                .orElse(null);
	    }
	    
}
