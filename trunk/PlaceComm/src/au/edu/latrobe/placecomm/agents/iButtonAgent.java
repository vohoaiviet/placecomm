/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package au.edu.latrobe.placecomm.agents;
import jade.core.Agent;
import jade.core.behaviours.*;
import java.util.Enumeration;
import java.util.Iterator;

/**
 *
 * @author Tuan Nguyen
 */
public class iButtonAgent extends Agent {

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

            Behaviour b = new OneShotBehaviour(this) {
                public void action() {
                    // Do something !
                }
            }; //End Behaviour b

          addBehaviour(tbf.wrap(b));
          // takeDown(); // Take down the agent
    }
}
