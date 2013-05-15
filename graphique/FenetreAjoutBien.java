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
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 * Décrivez votre classe FenetreAjoutBien ici.
 * 
 * @author (votre nom) 
 * @version (un numéro de version ou une date)
 */
public class FenetreAjoutBien extends JFrame implements ActionListener
{

    private DaoBien laDao;
    private JButton btnFermer;
    private JButton btnValiderCommune;
    private JLabel lblLogo;
    private JLabel lblInfo;
    private JRadioButton rdCommuneExistante;
    private JRadioButton rdCommuneCree;
    private JComboBox cbListeCommunes;
    private ButtonGroup bgCommune;
    private JTextField zdtNomCommune;
    private JTextField zdtCodePostalCommune;
    private JComboBox cbListeSecteurs;
    
    /**
     * Constructeur d'objets de classe FenetreAjoutBien
     */
    public FenetreAjoutBien(DaoBien uneDao)
    {
        super("Ajout d'un bien - IdoLogis");
        
        laDao = uneDao;
        
        btnFermer = new JButton("fermer");
        btnFermer.addActionListener(this);
        btnValiderCommune = new JButton("Choisir cette commune");
        btnValiderCommune.addActionListener(this);
        
        JPanel panneauBtn = new JPanel();
        panneauBtn.setLayout(new GridLayout(1,2));
        panneauBtn.add(btnFermer);
        panneauBtn.add(btnValiderCommune);
        
        JPanel panneauCommune = new JPanel();
        panneauCommune.setLayout(new BorderLayout());
        lblInfo = new JLabel("Sélectionnez la commune : Soit une commune existante dans la liste déroulante, soit une saisie d'une nouvelle commune.");
        panneauCommune.add(lblInfo,BorderLayout.PAGE_START);
        rdCommuneExistante = new JRadioButton("Commune existante");
        rdCommuneExistante.setSelected(true);
        rdCommuneCree = new JRadioButton("Créer une commune");
        bgCommune = new ButtonGroup();
        bgCommune.add(rdCommuneExistante);
        bgCommune.add(rdCommuneCree);
        cbListeCommunes = new JComboBox(laDao.getLesCommunes().toArray());
        JPanel panneauExistante = new JPanel();
        panneauExistante.setLayout(new GridLayout(2,1));
        panneauExistante.add(rdCommuneExistante);
        panneauExistante.add(cbListeCommunes);
        JPanel panneauCreation = new JPanel();
        panneauCreation.setLayout(new GridLayout(4,2));
        panneauCreation.add(rdCommuneCree);
        panneauCreation.add(new JLabel(""));
        panneauCreation.add(new JLabel("Nom :"));
        zdtNomCommune = new JTextField();
        panneauCreation.add(zdtNomCommune);
        panneauCreation.add(new JLabel("Code postal :"));
        zdtCodePostalCommune = new JTextField();
        panneauCreation.add(zdtCodePostalCommune);
        panneauCreation.add(new JLabel("Secteur :"));
        cbListeSecteurs = new JComboBox(laDao.getLesSecteurs().toArray());
        panneauCreation.add(cbListeSecteurs);
        panneauCommune.add(panneauExistante,BorderLayout.LINE_START);
        panneauCommune.add(panneauCreation,BorderLayout.LINE_END);        
        
        lblLogo = new JLabel(new ImageIcon("images/logo_accueil.jpg"));      
        
        Container cont = this.getContentPane();
        cont.setLayout(new BorderLayout());
        cont.add(lblLogo,BorderLayout.PAGE_START);
        cont.add(panneauBtn,BorderLayout.PAGE_END);
        cont.add(panneauCommune,BorderLayout.CENTER);

        this.pack();
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if((JButton) e.getSource() == btnFermer){
             this.setVisible(false);
        }else{
            if((JButton) e.getSource() == btnValiderCommune){
                Commune communeDuBien = null;
                if(rdCommuneCree.isSelected()){
                    Secteur secteurDuBien = (Secteur) cbListeSecteurs.getSelectedItem();
                    communeDuBien = new Commune(0,zdtCodePostalCommune.getText(),zdtNomCommune.getText(), secteurDuBien.getId());
                    int idBien = laDao.enregistrerCommune(communeDuBien);
                    communeDuBien.setId(idBien);
                }else{
                    communeDuBien = (Commune) cbListeCommunes.getSelectedItem();
                }                    
                FenetreChampsBien fntChamps = new FenetreChampsBien(laDao,communeDuBien);
                this.setVisible(false);
            }
        }
    }
    
}
