import java.sql.*;
import metier.*;
import metier.LesExceptions.*;
import java.util.Date;
import java.util.Objects;

import metier.Abonnement;
import DAO.*;
import GUI.*;
public class Main {
    public static void main(String[] args) {

        new InterConnexion("Connection");
        // new InterInscription(title);
        //String title2 ="Abonnement";
        // new GUI.Abonnement(title);
        // new InterAjoutPiece(title);
        // new InterInfoAppareil(title);
        //new InterEditMaison(title);
        //new InterAppareils(title);
        // new InterMaisons(title);

        AuthentificationManager test = new AuthentificationManager();
        Connection conx=test.verifyCredentials("root","123456");

         if(conx != null) {
                    //Connection conx = DriverManager.getConnection("jdbc:mysql://localhost:3306/smart_home","root","123456");
                System.out.println(conx);
                    // Exemple d'exécution d'une requête
                    String sql = "Select * FROM utilisateur;";
             PreparedStatement statement = null;
             try {
                 statement = conx.prepareStatement(sql);


             ResultSet resultSet = statement.executeQuery();

                    while (resultSet.next()) {
                        String Nom = resultSet.getString("nom");
                        String Prenom = resultSet.getString("prenom");
                        // Traitez les données récupérées selon vos besoins
                        System.out.println("Username: " + Nom + ", Prenom: " + Prenom);
                    }
                    DatabaseMetaData metaData = conx.getMetaData();

     //Obtenez les noms des tables dans la base de données

                conx.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

                   /* // Fermez les ressources
                    resultSet.close();
                    statement.close();
                    conx.close();
                } catch (SQLException e) {
                  // e.printStackTrace();
                }




        String title ="Maison Intelligente";
    */

   /*  LesClients c = new LesClients();
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
*/       }
    }
}

