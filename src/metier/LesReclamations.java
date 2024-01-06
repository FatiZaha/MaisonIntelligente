package metier;
import java.util.*;

public class LesReclamations {
	private ArrayList<Reclamation> r;

	public ArrayList<Reclamation> ListeReclam(){
		return r;
	}
	public LesReclamations() {
		
		this.r = new ArrayList<Reclamation>();
	}

	public void Ajouter_reclam(String Message) {
	       Reclamation r= new Reclamation(Message);
	       this.r.add(r);
	       
	    }
	public void Afficher_reclam(String Message) {
		for (Reclamation reclam : r) {
			if (reclam.getMessage().equals(Message)) {
				System.out.println("Réclamation : " + reclam.getMessage());

			}
		}
	}
	public void Repondre_reclam(String Message, String reponse) {
		for (Reclamation reclam : r) {
			if (reclam.getMessage().equals(Message)) {
				System.out.println("Réclamation : " + reclam.getMessage());
				System.out.println("Réponse : " + reponse);
			}
		}
}}
