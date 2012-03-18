/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package agent.rbidding;
import jade.content.onto.basic.Action;
import jade.core.AID;
import jade.core.Agent;
import jade.core.ContainerID;
import jade.core.behaviours.*;
import jade.domain.FIPANames;
import jade.domain.AMSService;
import jade.domain.FIPAAgentManagement.*;
import jade.domain.JADEAgentManagement.CreateAgent;
import jade.domain.JADEAgentManagement.JADEManagementOntology;
import jade.lang.acl.ACLMessage;
import jade.proto.AchieveREInitiator;
import java.util.Enumeration;
import java.util.Iterator;

/**
 *
 * @author Tuan Nguyen
 */
public class ListAllAgentsInAMS extends Agent {

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

            AMSAgentDescription [] agents = null;
            try {
                 SearchConstraints c = new SearchConstraints();
                 c.setMaxResults ( new Long(-1) );
                 agents = AMSService.search( this, new AMSAgentDescription (), c );
                 int iLength = agents.length;
                 for (int i=0; i< iLength ; i++){
                   AID agentName = agents[i].getName();
                   System.out.println("Agent ["+i+"]: "+ agentName.getLocalName());
                 }
             }
             catch (Exception e) {
                 System.out.println("Error");
             }


            Behaviour b = new OneShotBehaviour(this) {
                public void action() {
                    System.out.print("Hello World Agent");
                    

                }
            }; //End Behaviour b

          addBehaviour(tbf.wrap(b));
          // takeDown(); // Take down the agent
    }
}
