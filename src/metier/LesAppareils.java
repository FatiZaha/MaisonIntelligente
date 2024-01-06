package metier;

import java.util.*;

public class LesAppareils {

	private ArrayList<Appareil> a;
	
	 public LesAppareils() {
		
		this.a = new ArrayList<Appareil>();
	}

		public void Ajouter_appareil(String nom) {
		       
			Appareil a= new Appareil(nom);
			this.a.add(a);
	    }


	    public void Supprimer_appareil(List<String> Nom) {

	    	a.removeIf(app -> Nom.contains(app.getNom()));
	      
	    }

	   
		public Appareil Rechercher_appareil(String Nom) {

			return a.stream()
		            .filter(app -> Nom.equals(app.getNom()))
		            .findFirst()
		            .orElse(null);
		    }

	public void Modifier_nom(String nom, String nouveauNom) {
		Appareil a = Rechercher_appareil(nom);
		if (a != null) {
			a.setNom(nouveauNom);
		}
	}

	public void Modifier_etat(String nom, boolean nouvelEtat) {
		Appareil a = Rechercher_appareil(nom);
		if (a != null) {
			a.setEtat(nouvelEtat);
		}
	}
		
}
