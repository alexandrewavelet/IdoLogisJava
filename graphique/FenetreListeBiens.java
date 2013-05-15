package graphique;

import metier.*;
import donnees.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.ListSelectionModel;
import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Décrivez votre classe FenetreListeBiens ici.
 * 
 * @author (votre nom) 
 * @version (un numéro de version ou une date)
 */
public class FenetreListeBiens extends JFrame implements ActionListener
{

    private DaoBien laDao;
    private JButton btnFermer;
    private JButton btnModifier;
    private JButton btnSupprimer;
    private JTable tblBiens;
    private JLabel lblLogo;
    
    /**
     * Constructeur d'objets de classe FenetreListeBiens
     */
    public FenetreListeBiens(DaoBien uneDao)
    {
        super("Liste des biens - IdoLogis");
        
        laDao = uneDao;
        
        btnFermer = new JButton("fermer");
        btnFermer.addActionListener(this);
        btnModifier = new JButton("Modifier le bien sélectionné");
        btnModifier.addActionListener(this);
        btnSupprimer = new JButton("Supprimer le bien sélectionné");
        btnSupprimer.addActionListener(this);
        
        JPanel panneauBtn = new JPanel();
        panneauBtn.setLayout(new GridLayout(1,3));
        panneauBtn.add(btnFermer);
        panneauBtn.add(btnModifier);
        panneauBtn.add(btnSupprimer);
        
        lblLogo = new JLabel(new ImageIcon("images/logo_accueil.jpg"));

        ModeleTableBien structureTable = new ModeleTableBien(laDao);
        tblBiens = new JTable(structureTable); 
        tblBiens.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        Container cont = this.getContentPane();
        cont.setLayout(new BorderLayout());
        cont.add(lblLogo,BorderLayout.PAGE_START);
        cont.add(panneauBtn,BorderLayout.PAGE_END);
        cont.add(tblBiens,BorderLayout.CENTER);

        this.pack();
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if((JButton) e.getSource() == btnFermer){
             this.setVisible(false);
        }else if ((JButton) e.getSource() == btnModifier){
            int ligneSelectionnee = tblBiens.getSelectedRow();
            Bien bienSelectionne = (Bien) tblBiens.getModel().getValueAt(ligneSelectionnee,0);
            FenetreChampsBien fntChamps = new FenetreChampsBien(laDao, bienSelectionne);
            this.setVisible(false);
        }else{
            int ligneSelectionnee = tblBiens.getSelectedRow();
            Bien bienSelectionne = (Bien) tblBiens.getModel().getValueAt(ligneSelectionnee,0);
            laDao.supprimerLeBien(bienSelectionne);
            this.setVisible(false);
        }
    }
    
}
