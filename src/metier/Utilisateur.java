package metier;


public class Utilisateur {
	
	protected int id;
	protected String Nom;
	protected String Prenom;
	protected String Tel;
	protected String Email;
	protected String Adresse;
	protected String Nom_utilisateur;
	protected String Mot_de_passe;
	
	
	public Utilisateur(String nom, String prenom, String tel, String email, String adresse,
			String nom_utilisateur, String mot_de_passe) {
		
		
		this.Nom = nom;
		this.Prenom = prenom;
		this.Tel = tel;
		this.Email = email;
		this.Adresse = adresse;
		this.Nom_utilisateur = nom_utilisateur;
		this.Mot_de_passe = mot_de_passe;
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


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		//Ajouter condition sur l'unicité du gmail
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
    

}