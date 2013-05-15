package metier;


/**
 * Décrivez votre classe Commercial ici.
 * 
 * @author (votre nom) 
 * @version (un numéro de version ou une date)
 */
public class Commercial
{
    private int idCommercial;
    private String nomCommercial;
    private String prenomCommercial;
    private String telCommercial;
    private String mailCommercial;
    private Secteur secteurCommercial;

    /**
     * Constructeur d'objets de classe Commercial
     */
    public Commercial(int id, String nom, String prenom, String tel, String mail, Secteur secteur)
    {
        idCommercial = id;
        nomCommercial = nom;
        prenomCommercial = prenom;
        telCommercial = tel;
        mailCommercial = mail;
        secteurCommercial = secteur;
    }

    public int getId()
    {
        return idCommercial;
    }
    
    public String getNom(){
        return nomCommercial;
    }
    
    public String getPrenom(){
        return prenomCommercial;
    }
    
    public String getTel(){
        return telCommercial;
    }
    
    public String getMail(){
        return mailCommercial;
    }
    
    public Secteur getSecteur(){
        return secteurCommercial;
    }
    
}
