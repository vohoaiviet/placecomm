/*
 *  Tuan Anh Nguyen.  Email: t.nguyen@latrobe.edu.au
 * Computer Science & Computer Engineering Department
 * La Trobe University, VIC, 3086
 */

package utilities;

import org.w3c.dom.NodeList;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import org.apache.xerces.parsers.*;
import org.w3c.dom.Document;


/**
 *
 * @author Tuan Nguyen
 */
public class ibuttonUsername {
  
    
    public ibuttonUsername(){

    }

    /** This method logs the timestamp of userID and userName when he/she
     * docks the button to the reader.
     * @param strUserID String
     * @param strUsername  String
     * @param strHostName The host that database is running
     * @param strHostAddress The host that database is running
     * @param strDate A date string
     * @param iHour Hour
     * @param iMinute Minute
     * @param iSecond Second
     */
  public String IDtoUserXMLParser(String strID) {
    String strUserName="";
     try {
            DOMParser parser = new DOMParser();
            parser.parse("D:\\MyPhD\\Netbeans\\ContextJade\\src\\localusers.xml");
            Document doc = parser.getDocument();
            NodeList nodes = doc.getElementsByTagName("user");
            System.out.println("User ID is: " +doc.getElementById(strID));

            //System.out.println("Nodes: "+nodes.toString());

            System.out.println("There are " + nodes.getLength() + "  elements.");
            for (int i=0;  i < nodes.getLength(); i++  ){
                if (nodes.item(i).getAttributes().
                        getNamedItem("identification").
                         getTextContent().equals(strID)){
                 strUserName= nodes.item(i).getAttributes().
                                   getNamedItem("username").getTextContent() ;
                 System.out.println("username:"+strUserName);
                 break;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
       return strUserName;
   }
}
