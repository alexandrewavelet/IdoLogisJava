package graphique;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Décrivez votre classe FenetreInfo ici.
 * 
 * @author (votre nom) 
 * @version (un numéro de version ou une date)
 */
public class FenetreInfo extends JFrame implements ActionListener
{
    
    private JLabel lblLogo;
    private JLabel lblInfo;
    private JButton btnFermer;
    
    public FenetreInfo(String info)
    {
        super("Info - IdoLogis");
        
        lblLogo = new JLabel(new ImageIcon("images/logo_accueil.jpg"));
        
        btnFermer = new JButton("Fermer");
        btnFermer.addActionListener(this);
        
        lblInfo = new JLabel(info);
        
        this.setLayout(new BorderLayout());
        this.add(lblLogo,BorderLayout.PAGE_START);
        this.add(btnFermer,BorderLayout.PAGE_END);
        this.add(lblInfo,BorderLayout.CENTER);
        
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        this.setVisible(false);
    }
    
}
