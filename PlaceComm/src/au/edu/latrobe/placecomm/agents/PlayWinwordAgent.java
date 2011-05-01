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
public class PlayWinwordAgent extends Agent {

    private ThreadedBehaviourFactory tbf = new ThreadedBehaviourFactory();

    protected void setup() {
        // Printout a welcome message
        System.out.println("Hello World. I'm an agent!");
        System.out.println("My local-name is "+getAID().getLocalName());
        System.out.println("My GUID is "+getAID().getName());
        System.out.println("My addresses are:");
        Iterator it = getAID().getAllAddresses();

        // Parse param
            Object[] args = getArguments();
            String s;
            if (args != null) {
                for (int i = 0; i<args.length; i++) {
                    s = (String) args[i];
                    System.out.println("p" + i + ": " + s);
                }


            }

       // Add initial behaviours
      

            Behaviour b = new OneShotBehaviour(this) {
                public void action() {
                    // Do something !
                    System.out.println("Do something"); 
                    String sFilename="D:\\MyPhD\\NewNetbeans\\PlaceCommFramework\\resources\\fileword.doc";
                    System.out.println("This is a test, automatic load file:\n"+sFilename);
                        try{
                        PlayThisFile(sFilename);
                        }catch(Exception e){
                            Logger.getLogger(PlayWinwordAgent.class.getName()).log(Level.SEVERE, null, e);
                        }
                }
            }; //End Behaviour b

          addBehaviour(tbf.wrap(b));
          // takeDown(); // Take down the agent
    }
    void PlayThisFile(String sFilename) {

        /*
         "C:\Program Files\Microsoft Office\OFFICE11\winword.exe" %1 %2 %3
         */

        String cmdline = "ww.bat "+sFilename;
        Runtime rt = Runtime.getRuntime();
        try {
            Process pr = rt.exec(cmdline);
        } catch (Exception ex) {
          Logger.getLogger(PlayWinwordAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
