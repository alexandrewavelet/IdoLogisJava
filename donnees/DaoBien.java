package donnees;

import metier.*;
import java.util.ArrayList;
import java.sql.*;

/**
 * Décrivez votre classe daoBien ici.
 * 
 * @author (votre nom) 
 * @version (un numéro de version ou une date)
 */
public class DaoBien
{
    private ConnexionBDD laConnexion;

    /**
     * Constructeur d'objets de classe daoBien
     */
    public DaoBien()
    {
        laConnexion = new ConnexionBDD();
    }

    public void enregistrerBien(Bien leBien)
    {
        try{
            Statement req = laConnexion.getLaConnexion().createStatement();
            int insertion = req.executeUpdate("INSERT INTO bien VALUES (0,\"" + leBien.getIntitule() + "\"," + leBien.getNbChambres() + ", \"" + leBien.getGarage() + "\", \"" + leBien.getJardin() + "\"," + leBien.getPrix() + ",\"" + leBien.getEnergie() + "\", \"defaut.jpg\"," + leBien.getCommune().getId() + ");");
            req.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public ArrayList<Bien> getLesBiens(){
        ArrayList<Bien> listeBiens = new ArrayList<Bien>();
        try{
            Statement req = laConnexion.getLaConnexion().createStatement();
            ResultSet res = req.executeQuery("SELECT IdBien FROM bien ORDER BY IdBien;");
            while(res.next()){
                listeBiens.add(this.getLeBien(res.getInt(1)));
            }
            res.close();
            req.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return listeBiens;
    }
    
    public Bien getLeBien(int id){
        Bien leBien = null;
        try{
            Statement req = laConnexion.getLaConnexion().createStatement();
            ResultSet res = req.executeQuery("SELECT * FROM bien, commune WHERE bien.CommuneBien = commune.IdCommune AND IdBien =" + id +";");
            res.next();
            Commune laCommune = new Commune(res.getInt("IdCommune"),res.getString("CodePostalCommune"),res.getString("NomCommune"),res.getInt("SecteurCommune"));
            leBien = new Bien(res.getInt("IdBien"),res.getString("IntituleBien"),res.getInt("NbChambresBien"),res.getString("GarageBien"),res.getString("JardinBien"),res.getInt("PrixBien"),res.getString("EnergieBien"),laCommune);
            res.close();
            req.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return leBien;
    }
    
    public int getNombreBiens(){
        int nbBiens = 0;
        try{
            Statement req = laConnexion.getLaConnexion().createStatement();
            ResultSet res = req.executeQuery("SELECT COUNT(*) AS nbBiens FROM bien");
            res.next();
            nbBiens = res.getInt("nbBiens");
            res.close();
            req.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return nbBiens;
    }
    
    public void modifierBien(Bien leBien){
        try{
            Statement req = laConnexion.getLaConnexion().createStatement();
            int insertion = req.executeUpdate("UPDATE bien SET IntituleBien = \"" + leBien.getIntitule() + "\", NbChambresBien = " + leBien.getNbChambres() + ", GarageBien = \"" + leBien.getGarage() + "\", JardinBien = \"" + leBien.getJardin() + "\", PrixBien = " + leBien.getPrix() + ", EnergieBien = \"" + leBien.getEnergie() + "\" WHERE IdBien = " + leBien.getId() + ";");
            req.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void supprimerLeBien(Bien leBien){
        try{
            Statement req = laConnexion.getLaConnexion().createStatement();
            int insertion = req.executeUpdate("DELETE FROM bien WHERE IdBien = " + leBien.getId() + ";");
            req.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public int enregistrerCommune(Commune laCommune){
        int idInsere = 0;
        try{
            Statement req = laConnexion.getLaConnexion().createStatement();
            int insertion = req.executeUpdate("INSERT INTO commune VALUES (0,\"" + laCommune.getCodePostal() + "\",\"" + laCommune.getNom() + "\", " + laCommune.getSecteur() + ");");
            ResultSet res = req.executeQuery("SELECT IdCommune FROM commune WHERE CodePostalCommune = \"" + laCommune.getCodePostal() + "\" AND NomCommune = \"" + laCommune.getNom() + "\" AND SecteurCommune = " + laCommune.getSecteur() + " ;");
            res.next();
            idInsere = res.getInt("IdCommune");
            req.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return idInsere;
    }
    
    public Commune getLaCommuneDuBien(Bien leBien){
        Commune laCommune = null;
        try{
            Statement req = laConnexion.getLaConnexion().createStatement();
            ResultSet res = req.executeQuery("SELECT * FROM commune, bien WHERE bien.CommuneBien = commune.IdCommune AND IdBien =" + leBien.getId() + ";");
            res.next();
            laCommune = new Commune(res.getInt("IdCommune"),res.getString("CodePostalCommune"),res.getString("NomCommune"),res.getInt("SecteurCommune"));
            res.close();
            req.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return laCommune;
    }
    
    public Commune getLaCommune(int id){
        Commune laCommune = null;
        try{
            Statement req = laConnexion.getLaConnexion().createStatement();
            ResultSet res = req.executeQuery("SELECT * FROM commune WHERE IdCommune = " + id + ";");
            res.next();
            laCommune = new Commune(id,res.getString("CodePostalCommune"),res.getString("NomCommune"),res.getInt("SecteurCommune"));
            res.close();
            req.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return laCommune;
    }
    
    public ArrayList<Commune> getLesCommunes(){
        ArrayList<Commune> listeCommunes = new ArrayList<Commune>();
        try{
            Statement req = laConnexion.getLaConnexion().createStatement();
            ResultSet res = req.executeQuery("SELECT IdCommune FROM commune");
            while(res.next()){
                listeCommunes.add(this.getLaCommune(res.getInt(1)));
            }
            res.close();
            req.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return listeCommunes;
    }
    
    public ArrayList<Secteur> getLesSecteurs(){
        ArrayList<Secteur> listeSecteurs = new ArrayList<Secteur>();
        try{
            Statement req = laConnexion.getLaConnexion().createStatement();
            ResultSet res = req.executeQuery("SELECT * FROM secteur");
            while(res.next()){
                listeSecteurs.add(new Secteur(res.getInt("IdSecteur"),res.getString("NomSecteur")));
            }
            res.close();
            req.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return listeSecteurs;
    }
}
