package metier;

//import java.util.*;


public class Client {


    protected int id;
    protected String Nom;
    protected String Prenom;
    protected String Tel;
    protected String Email;
    protected String Adresse;
    protected String Nom_utilisateur;
    protected String Mot_de_passe;


    public Client() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }

    public String getNom_utilisateur() {
        return Nom_utilisateur;
    }

    public void setNom_utilisateur(String nom_utilisateur) {
        Nom_utilisateur = nom_utilisateur;
    }

    public String getMot_de_passe() {
        return Mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        Mot_de_passe = mot_de_passe;
    }

    public String getNom() {
        return Nom;
    }


    public void setNom(String nom) {
        Nom = nom;
    }


    public String getPrenom() {
        return Prenom;
    }


    public void setPrenom(String prenom) {
        Prenom = prenom;
    }


    public String getTel() {
        return Tel;
    }


    public void setTel(String tel) {
        // Ajouter condition sur l'unicité du tel
        Tel = tel;
    }

    
    
    

}