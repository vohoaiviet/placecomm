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

/**
 *
 * @author Tuan Nguyen
 */
public class argumentsAgent extends Agent {

    private ThreadedBehaviourFactory tbf = new ThreadedBehaviourFactory();

    protected void setup() {
        // Printout a welcome message
        System.out.println("Hello World. I'm an agent!");
        System.out.println("My local-name is "+getAID().getLocalName());
        System.out.println("My GUID is "+getAID().getName());
        

        Object[] args = getArguments();
        int len=args.length;
        System.out.println("Number of args: "+ len );
        for (int i=0; i<len; i++){
        System.out.println("arg3["+i+"] "+args[i].toString());
        }

        //System.out.println("My addresses are:");
        //Iterator it = getAID().getAllAddresses();
        //while (it.hasNext()) {
          //    System.out.println("- "+it.next());
        //}

            Behaviour b = new OneShotBehaviour(this) {
                public void action() {
                    // Do something !
                }
            }; //End Behaviour b

          addBehaviour(tbf.wrap(b));
          // takeDown(); // Take down the agent
    }

}
