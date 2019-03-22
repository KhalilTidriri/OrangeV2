/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import bean.Agence;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author YOUNES
 */
public class AgenceHelper extends AbstractHelper<Agence>{
   private static AbstractHelperItem[] titres;

    static {
        titres = new AbstractHelperItem[]{
            new AbstractHelperItem("NOM", "nom"),
            new AbstractHelperItem("ADRESSE", "adresse")};

    }

    public AgenceHelper(JTable jTable, List<Agence> list) {
        super(titres, jTable, list);
    }

    public AgenceHelper(AbstractHelperItem[] abstractHelperItem, JTable jTable) {
        super(titres, jTable);
    }

    public AgenceHelper(JTable jTable) {
        super(titres, jTable);
    }
}
