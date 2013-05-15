package graphique;

import metier.*;
import donnees.DaoBien;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 * Décrivez votre classe FenetreChampsBien ici.
 * 
 * @author (votre nom) 
 * @version (un numéro de version ou une date)
 */
public class FenetreChampsBien extends JFrame implements ActionListener
{

    private DaoBien laDao;
    private Commune laCommune;
    private Bien leBien;
    private JButton btnFermer;
    private JButton btnCreer;
    private JButton btnModifier;
    private JLabel lblLogo;
    private JTextField zdtIntitule;
    private JTextField zdtNombreChambres;
    private JTextField zdtGarage;
    private JTextField zdtJardin;
    private JTextField zdtPrix;
    private JComboBox cbListeEnergies;

    public FenetreChampsBien(DaoBien uneDao, Commune uneCommune)
    {
        super("Ajout d'un bien - IdoLogis");
        
        laDao = uneDao;
        laCommune = uneCommune;
        
        btnFermer = new JButton("fermer");
        btnFermer.addActionListener(this);
        btnCreer = new JButton("Créer le bien");
        btnCreer.addActionListener(this);
        
        JPanel panneauBtn = new JPanel();
        panneauBtn.setLayout(new GridLayout(1,2));
        panneauBtn.add(btnFermer);
        panneauBtn.add(btnCreer);      
        
        lblLogo = new JLabel(new ImageIcon("images/logo_accueil.jpg"));
        
        JPanel panneauLabels = new JPanel();
        panneauLabels.setLayout(new GridLayout(7,1));
        panneauLabels.add(new JLabel("Intitulé : "));
        panneauLabels.add(new JLabel("Nombre de chambres : "));
        panneauLabels.add(new JLabel("Garage : "));
        panneauLabels.add(new JLabel("Jardin : "));
        panneauLabels.add(new JLabel("Prix : "));
        panneauLabels.add(new JLabel("Energie : "));
        panneauLabels.add(new JLabel("Commune : "));
        
        JPanel panneauChamps = new JPanel();
        panneauChamps.setLayout(new GridLayout(7,1));
        zdtIntitule = new JTextField();
        panneauChamps.add(zdtIntitule);
        zdtNombreChambres = new JTextField();
        panneauChamps.add(zdtNombreChambres);
        zdtGarage = new JTextField();
        panneauChamps.add(zdtGarage);
        zdtJardin = new JTextField();
        panneauChamps.add(zdtJardin);
        zdtPrix = new JTextField();
        panneauChamps.add(zdtPrix);
        String[] classesEnergetiques = {"A","B","C","D","E","F"};
        cbListeEnergies = new JComboBox(classesEnergetiques);
        panneauChamps.add(cbListeEnergies);
        panneauChamps.add(new JLabel(laCommune.toString()));
        
        Container cont = this.getContentPane();
        cont.setLayout(new BorderLayout());
        cont.add(lblLogo,BorderLayout.PAGE_START);
        cont.add(panneauBtn,BorderLayout.PAGE_END);
        cont.add(panneauLabels,BorderLayout.LINE_START);
        cont.add(panneauChamps,BorderLayout.CENTER);

        this.pack();
        this.setVisible(true);
    }

    public FenetreChampsBien(DaoBien uneDao, Bien unBien){
        super("Modification d'un bien - IdoLogis");
        
        laDao = uneDao;
        leBien = unBien;
        
        btnFermer = new JButton("fermer");
        btnFermer.addActionListener(this);
        btnModifier = new JButton("Modifier le bien");
        btnModifier.addActionListener(this);
        
        JPanel panneauBtn = new JPanel();
        panneauBtn.setLayout(new GridLayout(1,2));
        panneauBtn.add(btnFermer);
        panneauBtn.add(btnModifier);      
        
        lblLogo = new JLabel(new ImageIcon("images/logo_accueil.jpg"));
        
        JPanel panneauLabels = new JPanel();
        panneauLabels.setLayout(new GridLayout(7,1));
        panneauLabels.add(new JLabel("Intitulé : "));
        panneauLabels.add(new JLabel("Nombre de chambres : "));
        panneauLabels.add(new JLabel("Garage : "));
        panneauLabels.add(new JLabel("Jardin : "));
        panneauLabels.add(new JLabel("Prix : "));
        panneauLabels.add(new JLabel("Energie : "));
        panneauLabels.add(new JLabel("Commune : "));
        
        JPanel panneauChamps = new JPanel();
        panneauChamps.setLayout(new GridLayout(7,1));
        zdtIntitule = new JTextField(leBien.getIntitule());
        panneauChamps.add(zdtIntitule);
        zdtNombreChambres = new JTextField(String.valueOf(leBien.getNbChambres()));
        panneauChamps.add(zdtNombreChambres);
        zdtGarage = new JTextField(leBien.getGarage());
        panneauChamps.add(zdtGarage);
        zdtJardin = new JTextField(leBien.getJardin());
        panneauChamps.add(zdtJardin);
        zdtPrix = new JTextField(String.valueOf(leBien.getPrix()));
        panneauChamps.add(zdtPrix);
        String[] classesEnergetiques = {"A","B","C","D","E","F"};
        cbListeEnergies = new JComboBox(classesEnergetiques);
        cbListeEnergies.setSelectedItem(leBien.getEnergie());
        panneauChamps.add(cbListeEnergies);
        panneauChamps.add(new JLabel(leBien.getCommune().toString()));    
        
        Container cont = this.getContentPane();
        cont.setLayout(new BorderLayout());
        cont.add(lblLogo,BorderLayout.PAGE_START);
        cont.add(panneauBtn,BorderLayout.PAGE_END);
        cont.add(panneauLabels,BorderLayout.LINE_START);
        cont.add(panneauChamps,BorderLayout.CENTER);

        this.pack();
        this.setVisible(true);        
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if((JButton) e.getSource() == btnFermer){
             this.setVisible(false);
        }else{
            if((JButton) e.getSource() == btnCreer){
                String energieDuBien = (String) cbListeEnergies.getSelectedItem();
                Bien nouveauBien = new Bien(0,zdtIntitule.getText(),(int) Integer.valueOf(zdtNombreChambres.getText()),zdtGarage.getText(),zdtJardin.getText(),(int) Integer.valueOf(zdtPrix.getText()), energieDuBien, laCommune);
                laDao.enregistrerBien(nouveauBien);
                FenetreInfo fntInfo = new FenetreInfo("Le bien intitulé \"" + zdtIntitule.getText() + "\" a bien été créé.");
                this.setVisible(false);
            }else{
                String energieDuBien = (String) cbListeEnergies.getSelectedItem();
                Bien modificationBien = new Bien(leBien.getId(),zdtIntitule.getText(),(int) Integer.valueOf(zdtNombreChambres.getText()),zdtGarage.getText(),zdtJardin.getText(),(int) Integer.valueOf(zdtPrix.getText()), energieDuBien, leBien.getCommune());
                laDao.modifierBien(modificationBien);
                FenetreInfo fntInfo = new FenetreInfo("Le bien intitulé \"" + zdtIntitule.getText() + "\" a bien été modifié.");
                this.setVisible(false);
            }
        }
    }
}
