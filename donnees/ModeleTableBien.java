package donnees;

import metier.*;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import javax.swing.event.TableModelListener;

/**
 * Décrivez votre classe ModeleTableBien ici.
 * 
 * @author (votre nom) 
 * @version (un numéro de version ou une date)
 */
public class ModeleTableBien implements TableModel
{
    
    private DaoBien laDao;
    private String[] enTete = {"N°","Intitulé","Lieu","Prix"};
    private ArrayList<Bien> listeBiens;
    
    /**
     * Constructeur d'objets de classe ModeleTableBien
     */
    public ModeleTableBien(DaoBien uneDao)
    {
        laDao = uneDao;
        listeBiens = laDao.getLesBiens();
    }

    public int getColumnCount() {
        return enTete.length;
    }

    public int getRowCount() {
        return listeBiens.size();
    }

    public String getColumnName(int col) {
        return enTete[col];
    }

    public Object getValueAt(int row, int col) {
        Object temp;
        Bien leBien = listeBiens.get(row);
        switch (col) {
            
            case 3 :
            temp = leBien.getPrix();
            break;
            
            case 2 :
            temp = leBien.getCommune().getCodePostal() + " - " + leBien.getCommune().getNom();
            break;

            case 1 :
            temp = leBien.getIntitule();
            break;

            default :
            temp = leBien;
            break;
        }
        return temp;
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    public boolean isCellEditable(int row, int col) {

        return false;
    }

    public void setValueAt(Object value, int row, int col) {
    }

    public void addTableModelListener(TableModelListener l){}

    public void removeTableModelListener(TableModelListener l) {}

}
