/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package placecommframework.demosuite;
import jade.core.Agent;
import jade.core.behaviours.*;
import java.util.Enumeration;
import java.util.Iterator;

/**
 *
 * @author Tuan Nguyen
 */
public class KnowledgeBaseAgent extends Agent {

 private ThreadedBehaviourFactory tbf = new ThreadedBehaviourFactory();
 public KnowledgeBaseAgentGui myAgentGUI;

 // Constructor
    KnowledgeBaseAgent(KnowledgeBaseAgentGui gui){
        this.myAgentGUI = gui;
        
    }

    protected void setup() {
        // Printout a welcome message
        System.out.println("Hello World. I'm an agent!");
        System.out.println("My local-name is "+getAID().getLocalName());
        System.out.println("My GUID is "+getAID().getName());
        System.out.println("My addresses are:");
        Iterator it = getAID().getAllAddresses();

        myAgentGUI = new KnowledgeBaseAgentGui(this);
        myAgentGUI.setVisible(true);

            Behaviour b = new OneShotBehaviour(this) {
                public void action() {
                    // Do something !
                }
            }; //End Behaviour b

          addBehaviour(tbf.wrap(b));
          // takeDown(); // Take down the agent
    }
}
