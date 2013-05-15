package metier;


/**
 * Décrivez votre classe Bien ici.
 * 
 * @author (votre nom) 
 * @version (un numéro de version ou une date)
 */
public class Bien
{
    private int idBien;
    private String intituleBien;
    private int nombreChambresBien;
    private String garageBien;
    private String jardinBien;
    private int prixBien;
    private String energieBien;
    private Commune communeBien;

    /**
     * Constructeur d'objets de classe Bien
     */
    public Bien(int id, String intitule, int nbChambres, String garage, String jardin, int prix, String energie, Commune commune)
    {
        idBien = id;
        intituleBien = intitule;
        nombreChambresBien = nbChambres;
        garageBien = garage;
        jardinBien = jardin;
        prixBien = prix;
        energieBien = energie;
        communeBien = commune;
    }

    public int getId()
    {
        return idBien;
    }
    
    public String getIntitule(){
        return intituleBien;
    }
    
    public int getNbChambres(){
        return nombreChambresBien;
    }
    
    public String getGarage(){
        return garageBien;
    }
    
    public String getJardin(){
        return jardinBien;
    }
    
    public Integer getPrix(){
        return prixBien;
    }
    
    public String getEnergie(){
        return energieBien;
    }
    
    public Commune getCommune(){
        return communeBien;
    }
    
    @Override
    public String toString(){
        String laChaine = String.valueOf(idBien);
        return laChaine;
    }
}
