package donnees;

import java.sql.*;
import java.util.ArrayList;
/**
 * Classe qui établit la connexion à la base de données
 * 
 * @author (votre nom) 
 * @version (un numéro de version ou une date)
 */
public class ConnexionBDD
{
    private Connection laConnexion;
    
    /**
     * Constructeur d'objets de classe ConnexionBDD
     */
    public ConnexionBDD()
    {
        String nomClassePilote = new String("com.mysql.jdbc.Driver");
        try{
            Class.forName(nomClassePilote);
            try{
                this.laConnexion = DriverManager.getConnection("jdbc:mysql://localhost/idologis","root","");
            }
            catch(SQLException es){
                System.out.println(es.getMessage());
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public Connection getLaConnexion(){
        return laConnexion;
    }
}
