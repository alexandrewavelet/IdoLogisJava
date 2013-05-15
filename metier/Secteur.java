package metier;

import java.util.ArrayList;
/**
 * Décrivez votre classe Secteur ici.
 * 
 * @author (votre nom) 
 * @version (un numéro de version ou une date)
 */
public class Secteur
{
    private int idSecteur;
    private String nomSecteur;
    
    private ArrayList<Commercial> lesCommerciaux;
    private ArrayList<Commune> lesCommunes;

    /**
     * Constructeur d'objets de classe Secteur
     */
    public Secteur(int id, String nom)
    {
        idSecteur = id;
        nomSecteur = nom;
        
        lesCommerciaux = new ArrayList<Commercial>();
        lesCommunes = new ArrayList<Commune>();
    }

    public int getId()
    {
        return idSecteur;
    }
    
    public String getNom(){
        return nomSecteur;
    }
    
    @Override
    public String toString(){
        return nomSecteur;
    }
}
