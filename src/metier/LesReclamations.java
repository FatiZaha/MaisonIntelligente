package metier;
import java.util.*;

public class LesReclamations {
	private ArrayList<Reclamation> r;
	
	 public LesReclamations() {
		
		this.r = new ArrayList<Reclamation>();
	}

	public void Ajouter_reclam(String Message) {
	       Reclamation r= new Reclamation(Message);
	       this.r.add(r);
	       
	    }
	public ArrayList<Reclamation> ListeReclam(){
		return r;
	}
}
