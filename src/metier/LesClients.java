package metier;
import java.util.*;
import metier.LesExceptions.ConnexionException;
import metier.LesExceptions.InscriptionException;

public class LesClients{

	private ArrayList<Client> c;
	
	
	public LesClients() {
		this.c = new ArrayList<Client>();
	}
	


	public void Sinscrire(String nom, String prenom, String tel, String email, String adresse,
			String nom_utilisateur, String mot_de_passe) throws InscriptionException {
		Client c=new Client(nom, prenom, tel, email, adresse, nom_utilisateur, mot_de_passe); 
		this.c.add(c);
        
    }

   
    public boolean Se_connecter(String login,String pwd) throws ConnexionException {
    	
    	for (Client client : c) {
			if(client.getNom_utilisateur()!=login || client.getMot_de_passe()!=pwd) throw new ConnexionException("Donnees incoreectes"); {

			}
		}
    	return false;
        
    }
    
}
