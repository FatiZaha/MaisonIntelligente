package metier;

//import java.util.*;


public class Admin extends Utilisateur {

   
    public Admin(String nom, String prenom, String tel, String email, String adresse,
			String nom_utilisateur, String mot_de_passe) {
    	super(nom, prenom, tel, email, adresse, nom_utilisateur, mot_de_passe);
    }

   
    public boolean Sauthentifier(String login,String pwd) {
       
    	return this.Mot_de_passe==pwd && this.Nom_utilisateur==login;
    	
    }

}