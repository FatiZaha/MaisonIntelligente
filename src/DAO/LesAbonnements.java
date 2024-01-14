package DAO;

import metier.Abonnement;
import metier.Appareil;
import metier.Client;
import metier.Type;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;

public class LesAbonnements {
    DataManager dm= new DataManager();
    public ArrayList<Abonnement> ab;

    public LesAbonnements(int idclient) {
        this.ab = new ArrayList<Abonnement>();
        GetAbonnements(idclient);
    }
    public void GetAbonnements(int idclient){
        this.ab.clear();
        String abbonements = "Select * FROM abonnement where idclient=?;";
        PreparedStatement statement = null;

        try {
            statement = dm.conx.prepareStatement(abbonements);
            statement.setInt(1, idclient);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Abonnement abonnement = new Abonnement();
                abonnement.setNumero(resultSet.getInt("numero"));
                abonnement.setPrix(resultSet.getFloat("prix"));
                abonnement.setDate_debut(resultSet.getDate("date_debut"));
                abonnement.setDate_fin(resultSet.getDate("date_fin"));
                if (resultSet.getInt("type_abonnement")==1) abonnement.setType_abonnement(Type.Mensuel);
                if (resultSet.getInt("type_abonnement")==2) abonnement.setType_abonnement(Type.Semestriel);
                if (resultSet.getInt("type_abonnement")==3) abonnement.setType_abonnement(Type.Annuel);

                abonnement.setIdClient(resultSet.getInt("idclient"));
                this.ab.add(abonnement);
                // Traitez les données récupérées selon vos besoins

            }

            //conx.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean Ajouter_abonnement(Abonnement abonnement) {
        LesTypes t=new LesTypes();
        String abonnements = "insert into abonnement(prix,date_debut,date_fin,type_abonnement,idclient) values (?,?,?,?,?);";

        PreparedStatement statement = null;

        try {
            statement = dm.conx.prepareStatement(abonnements);

            if (abonnement.getType_abonnement()==Type.Annuel){
                statement.setFloat(1,t.types.get(Type.Annuel));
                statement.setInt(4,3);
            }
            if (abonnement.getType_abonnement()==Type.Semestriel){
                statement.setFloat(1,t.types.get(Type.Semestriel));
                statement.setInt(4,2);
            }
            if (abonnement.getType_abonnement()==Type.Mensuel){
                statement.setFloat(1,t.types.get(Type.Mensuel));
                statement.setInt(4,1);
            }
            statement.setDate(2,new java.sql.Date(abonnement.getDate_debut().getTime()));
            statement.setDate(3,new java.sql.Date(abonnement.getDate_fin().getTime()));
            statement.setInt(5, abonnement.getIdClient());
            int resultSet = statement.executeUpdate();
            GetAbonnements(abonnement.getIdClient());
            return true;

            //conx.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }


    }
    private boolean Annuel(Abonnement dernierAbonnement) {


        java.util.Date dateDebut = dernierAbonnement.getDate_debut();
        java.util.Date dateFin = dernierAbonnement.getDate_fin();

        LocalDate localDateDebut = dateDebut.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate localDateFin = dateFin.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        long differenceEnMois = ChronoUnit.MONTHS.between(localDateDebut, localDateFin);
        return differenceEnMois >= 12;

    }

    private boolean Mensuel(Abonnement dernierAbonnement) {

        java.util.Date dateDebut = dernierAbonnement.getDate_debut();
            java.util.Date dateFin = dernierAbonnement.getDate_fin();

            LocalDate localDateDebut = dateDebut.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate localDateFin = dateFin.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            long differenceEnMois = ChronoUnit.MONTHS.between(localDateDebut, localDateFin);
            return differenceEnMois >= 1;

    }

    private boolean Semestriel(Abonnement dernierAbonnement) {

        java.util.Date dateDebut = dernierAbonnement.getDate_debut();
            java.util.Date dateFin = dernierAbonnement.getDate_fin();

            LocalDate localDateDebut = dateDebut.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate localDateFin = dateFin.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            long differenceEnMois = ChronoUnit.MONTHS.between(localDateDebut, localDateFin);
            return differenceEnMois >= 6;

    }

    public boolean testAbonnement(){
        Abonnement abonnement= ab.getLast();
        Date date = new Date();
        return date.after(abonnement.getDate_fin());
    }
}
