package graphique;
import donnees.DaoBien;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Décrivez votre classe FenetreAccueil ici.
 * 
 * @author (votre nom) 
 * @version (un numéro de version ou une date)
 */
public class FenetreAccueil extends JFrame implements ActionListener
{

    private DaoBien laDao;
    private JButton btnAjout;
    private JButton btnGestion;
    private JLabel lblLogo;
    private JLabel lblNbBiens;

    /**
     * Constructeur d'objets de classe FenetreAccueil
     */
    public FenetreAccueil()
    {
        super("Application de gestion des biens - IdoLogis");
        
        laDao = new DaoBien();

        lblLogo = new JLabel(new ImageIcon("images/logo_accueil.jpg"));
        
        btnAjout = new JButton("Ajout d'un bien");
        btnAjout.addActionListener(this);
        btnGestion = new JButton("Gestion des biens");
        btnGestion.addActionListener(this);
        
        lblNbBiens = new JLabel(laDao.getNombreBiens() + " biens en vente.");
        
        JPanel panneauBtn = new JPanel();
        panneauBtn.setLayout(new GridLayout(1,2));
        panneauBtn.add(btnAjout);
        panneauBtn.add(btnGestion);
        this.setLayout(new BorderLayout());
        this.add(lblLogo,BorderLayout.PAGE_START);
        this.add(panneauBtn,BorderLayout.PAGE_END);
        this.add(lblNbBiens,BorderLayout.CENTER);
        
        this.pack();
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if((JButton) e.getSource() == btnAjout){
             FenetreAjoutBien fntAjout = new FenetreAjoutBien(laDao);
        }else{
             FenetreListeBiens fntGestion = new FenetreListeBiens(laDao);
        }
    }

}
