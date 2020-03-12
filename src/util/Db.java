package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.Integer.parseInt;

public class Db {
	
	
	//Kreira ArrayList za stampanje stranice sa proizvodima pomocu ProductServleta,
    public static String getMenuTree(int nivousera) {
        String upit = "select parent,webime,id,controler,nivokorisnika_id,webind,tabela from  (select * from (select * from glavnimeni where nivokorisnika_id<=" + nivousera + ")as b ) as a order by "
                + "      case when parent = 0 then id else parent end, "
                + "      case when parent = 0 then 0 else id end";

        // String upit = "select parent,webime,id,controler,nivokorisnika_id from  (select * from glavnimeni where nivokorisnika_id<=" + nivousera + ") as a order by "
        //        + "      case when parent = 0 then id else parent end, "
        //       + "      case when parent = 0 then 0 else id end";
        System.out.println("upit" + upit);
        String drvo = "<div class='drvo'>";
        DbUtil instanca = DbUtil.getInstance();
        Connection baza = instanca.getConn();

        try {
            Statement st = baza.createStatement();
            ResultSet rs = st.executeQuery(upit);

            String kraj = "";
            while (rs.next()) {
                // System.out.println("--" + rs.getString(1) + rs.getString(2) + rs.getString(3));
              String  rr=rs.getString(1);
                
              System.out.println("-*-"+rr);
                if (parseInt(rr)==0) {
                    drvo = drvo + kraj + kraj + "<div class='navdropdown'>" + "<button class='navdropbtn'>" + rs.getString(2) + "</button><div class='navdropdown-content'>";
                    kraj = "</div>";
                    System.out.println("--**--"+drvo);
                } else {
                    String ctrlr = rs.getString(4);
                    drvo = drvo + "<a href='" + rs.getString(4) + "?izb=" + rs.getString(7) + "'>" + rs.getString(2) + "</a>";
                    System.out.println("----"+drvo);
                }
            }
            drvo = drvo + "</div>" + "</div>";
               System.out.println("drvo" + drvo);
        } catch (SQLException ex) {
            Logger.getLogger(Db.class.getName()).log(Level.SEVERE, null, ex);
        }

        drvo = drvo + getGlavniMeni(nivousera);
        return drvo;
    }
    public static String getGlavniMeni(int nivousera) {
        String kraj = "";
        String drvo1 = "";
        int red = 0;
        String[] MENU_HEADER1 = new String[]{"Tabele", "Podaci o firmi", "Katalozi", "Izvestaji", "Stampa", "Help"};
        String[] WEBMENU_HEADER1 = new String[]{"AKCIJA DANA ", "Katalozi", "Prodajan mesta"};
        /* prvi SUBMENU sadrzi  tabele pa treba biti prazan ili  dodaje te stavjke na dno*/
        String[][] SUBMENU1 = new String[][]{
            {"aa", "bb"},
            {"Akcijskecene", "Apple Inc. popusti", "Samo sada "},
            {"Vesti iz Srbije", "Vestiiz belogsveta", "Vesti o nama"},
            {"Januar 2019", "Decembar 2018", "Novembar 2018"},
            {"Uslovi", "Garancija"},
            {"a1", "a2", "a3", "a4"},
            {"Prod 1", "Prod 1", "Prod 1", "Prod 1", "Prod 1"},
            {}};
        /* prvi SUBMENU sadrzi  tabele pa treba biti prazan ili  dodaje te stavjke na dno*/

        //  database.Constants.getInstance();
        for (String glmen : WEBMENU_HEADER1) {
            if (SUBMENU1[red].length > 0) {
                drvo1 = drvo1 + "<div class='navdropdown'>" + "<button class='navdropbtn'>" + glmen + "</button><div class='navdropdown-content'>";

                for (String stavka : SUBMENU1[red]) {
                    drvo1 = drvo1 + "<a href='" + "#" + "'>" + stavka + "</a>";

                }
                drvo1 = drvo1 + "</div>" + "</div>";
            } else {
                drvo1 = drvo1 + "<div class='navdropdown'>" + "<button class='navdropbtn'>" + glmen + "</button>";
                drvo1 = drvo1 + "</div>";
            }
            red++;
        }

       
        return drvo1;

    }
}
