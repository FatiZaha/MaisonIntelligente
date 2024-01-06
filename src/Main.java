
import metier.*;
import metier.LesExceptions.*;
import java.util.Date;

//import GUI.*;
public class Main {
    public static void main(String[] args) {

        String title ="Maison Intelligente";
        //new InterfaceConnexion(title);
        //new InterInscription(title);
        //String title2 ="Abonnement";
        //new Abonnement(title);
       // new InterAppareils(title);
       // new InterMaisons(title);
        LesClients c = new LesClients();
                try {
                    boolean estConnecte = c.Se_connecter("nom_utilisateur", "mot_de_passe");
                    if (estConnecte) {
                        System.out.println("Connexion réussie !");
                    } else {
                        System.out.println("Identifiants incorrects.");
                    }
                    } catch (ConnexionException e) {
                    System.out.println("Erreur de connexion : " + e.getMessage());
                    }

                try {
                     c.Sinscrire("guelbaoui", "hajar", "123456789", "guelbaoui.hajar@example.com", "123 Main Street", "guelbaouihajar", "123");
                     System.out.println("Inscription réussie !");
                     } catch (InscriptionException e) {
                    System.out.println("Erreur d'inscription : " + e.getMessage());
                   }
        Abonnement ab = new Abonnement(100.0f, new Date(), new Date(), Type.Mensuel, false);

                try {
                    ab.Afficher_abonnement();
                    } catch (AbonnementException e) {
                    System.out.println("Erreur d'abonnement : " + e.getMessage());
                   }


                try {
                    ab.Payer(true);
                    System.out.println("Paiement effectué avec succès !");
                    } catch (PaiementException e) {
                    System.out.println("Erreur de paiement : " + e.getMessage());
                    }

    }
}

