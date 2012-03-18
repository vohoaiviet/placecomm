/*
 *  Tuan Anh Nguyen.  Email: t.nguyen@latrobe.edu.au
 * Computer Science & Computer Engineering Department
 * La Trobe University, VIC, 3086
 */

package agent;
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
public class OpenLinkAgent extends Agent {

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
        System.out.println("This is a test, automatic call www.facebook.com ");
        strURL="www.facebook.com";
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
