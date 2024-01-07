package metier;
import java.util.*;

public class LesMaisons{

	private ArrayList<Maison> m;
	
	    public LesMaisons() {
		
		this.m = new ArrayList<Maison>();
	}


		public void Ajouter_maison(String Nom) {
		       
			Maison m= new Maison(Nom);
			this.m.add(m);
	    }
		
	    
	    public void Supprimer_maison(List<String> Nom) {

	    	m.removeIf(maison -> Nom.contains(maison.getNom()));
	      
	    }

	   
		public Maison Rechercher_maison(String Nom) {

			return m.stream()
		            .filter(maison -> Nom.equals(maison.getNom()))
		            .findFirst() //récupère le premier élément correspondant trouvé
		            .orElse(null);
		    }

	    public void Modifier_maison(String Nom, int nbrPieces) {
		Maison m = Rechercher_maison(Nom);
		if (m != null) {
			m.setNom(Nom);
		}
	}

}
