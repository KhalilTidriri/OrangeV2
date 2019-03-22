/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import bean.Client;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author YOUNES
 */
public class ClientHelper extends AbstractHelper<Client>{
   private static AbstractHelperItem[] titres;

    static {
        titres = new AbstractHelperItem[]{
            new AbstractHelperItem("ID", "id"),
            new AbstractHelperItem("Agence", "agence")};

    }

    public ClientHelper(JTable jTable, List<Client> list) {
        super(titres, jTable, list);
    }

    public ClientHelper(AbstractHelperItem[] abstractHelperItem, JTable jTable) {
        super(titres, jTable);
    }

    public ClientHelper(JTable jTable) {
        super(titres, jTable);
    }
}
