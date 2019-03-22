 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import bean.Facture;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author YOUNES
 */
public class FactureHelper extends AbstractHelper<Facture> {

    private static AbstractHelperItem[] titres;

    static {
        titres = new AbstractHelperItem[]{
            new AbstractHelperItem("ID", "id"),
            new AbstractHelperItem("Montant", "montant"),
            new AbstractHelperItem("DatePaiement", "datePaiement")};
    }

    public FactureHelper(JTable jTable, List<Facture> list) {
        super(titres, jTable, list);
    }

    public FactureHelper(AbstractHelperItem[] abstractHelperItem, JTable jTable) {
        super(titres, jTable);
    }

    public FactureHelper(JTable jTable) {
        super(titres, jTable);
    }
}
