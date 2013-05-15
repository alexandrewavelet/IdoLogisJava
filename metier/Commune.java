package metier;

import java.util.ArrayList;
/**
 * Décrivez votre classe Commune ici.
 * 
 * @author (votre nom) 
 * @version (un numéro de version ou une date)
 */
public class Commune
{
    private int idCommune;
    private String codePostalCommune;
    private String nomCommune;
    private int secteurCommune;
    
    private ArrayList<Bien> listeBiens;

    public Commune(int id, String cp, String nom, int idSecteur)
    {
        idCommune = id;
        codePostalCommune = cp;
        nomCommune = nom;
        secteurCommune = idSecteur;
        
        listeBiens = new ArrayList<Bien>();
    }

    public int getId()
    {
        return idCommune;
    }
    
    public void setId(int nouvelId){
        idCommune = nouvelId;
    }
    
    public String getCodePostal(){
        return codePostalCommune;
    }
    
    public String getNom(){
        return nomCommune;
    }
    
    public int getSecteur(){
        return secteurCommune;
    }
    
    @Override
    public String toString(){
        String laChaine = codePostalCommune + " - " + nomCommune;
        return laChaine;
    }
}
