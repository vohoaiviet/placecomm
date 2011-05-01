/*
 *  Tuan Anh Nguyen.  Email: t.nguyen@latrobe.edu.au
 * Computer Science & Computer Engineering Department
 * La Trobe University, VIC, 3086
 */

package au.edu.latrobe.placecomm.agents;
import jade.core.Agent;
import jade.core.behaviours.*;
import java.util.Enumeration;
import java.util.Iterator;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tuan Nguyen
 */
public class iPhoneInfoAgent extends Agent {

    private ThreadedBehaviourFactory tbf = new ThreadedBehaviourFactory();
    public  String strURL="";

    private OpenLinkAgentGUI myGui;

    protected void setup() {
        // Printout a welcome message
        System.out.println("Hello World. I'm an agent!");
        System.out.println("My local-name is "+getAID().getLocalName());
        System.out.println("My GUID is "+getAID().getName());
        System.out.println("My addresses are:");
// Parse param
            Object[] args = getArguments();
            String s;
            if (args != null) {
                for (int i = 0; i<args.length; i++) {
                    s = (String) args[i];
                    System.out.println("p" + i + ": " + s);
                }

            }
        /*
        try{
        myGui = new OpenLinkAgentGUI(this);
        
        }catch(Exception e){
            System.out.println("Start GUI error");
        }
        */
        
        // Add initial behaviours
        System.out.println("Go to optus page to get the iphone");
        strURL="http://personal.optus.com.au/web/ocaportal.portal?_nfpb=true&_pageLabel=Template_woRHS&FP=/personal/mobile/iphone3G&site=personal";
        try{
        OpenthisLink(strURL);
        }catch(Exception e){
            
        }
       // addBehaviour(new URLListener(this));
        
        // Call the GUI:

        // takeDown(); // Take down the agent
    }

     void OpenthisLink(String myURL) {

        // ff.bat
        // "C:\Program Files\Mozilla Firefox\firefox.exe" %1 %2 %3

        String cmdline = "ff.bat "+myURL;
        
        Runtime rt = Runtime.getRuntime();
        try {
            Process pr = rt.exec(cmdline);
        } catch (Exception ex) {
          Logger.getLogger(URLListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
