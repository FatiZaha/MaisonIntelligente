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
	    	
	    	/*for (Appareil app : a) {
				if(Nom.contains(app.getNom())) a.remove(app);
				}*/
	    	a.removeIf(app -> Nom.contains(app.getNom()));
	      
	    }

	   
		public Appareil Rechercher_appareil(String Nom) {
			/*for (Appareil app : a) {
				if(Nom==app.getNom()) return app;
				}*/
			return a.stream()
		            .filter(app -> Nom.equals(app.getNom()))
		            .findFirst()
		            .orElse(null);
		    }
		
}
