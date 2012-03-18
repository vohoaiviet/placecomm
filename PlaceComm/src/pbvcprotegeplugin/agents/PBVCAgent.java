/*
 *  Tuan Anh Nguyen.  Email: t.nguyen@latrobe.edu.au
 * Computer Science & Computer Engineering Department
 * La Trobe University, VIC, 3086
 */

package pbvcprotegeplugin.agents;
import jade.core.Agent;
import jade.core.behaviours.*;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import java.util.Enumeration;
import java.util.Iterator;

/**
 *
 * @author Tuan Nguyen
 */
public class PBVCAgent extends Agent {

    private ThreadedBehaviourFactory tbf = new ThreadedBehaviourFactory();
    PBVCAgentGUI localGUIOfPBVCAgent;

    public PBVCAgent(PBVCAgentGUI guiOfPBVCAgent){
    this.localGUIOfPBVCAgent = guiOfPBVCAgent;    
    }
    protected void setup() {
        // Printout a welcome message
        System.out.println("Hello World. I'm an agent!");
        System.out.println("My local-name is "+getAID().getLocalName());
        System.out.println("My GUID is "+getAID().getName());
        System.out.println("My addresses are:");
        Iterator it = getAID().getAllAddresses();

        while (it.hasNext()) {
              System.out.println("- "+it.next());
        }
        // Register the book-selling service in the yellow pages
        DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(getAID());
        ServiceDescription sd = new ServiceDescription();
        sd.setType("PBVC-Inquiries");
        sd.setName(getLocalName()+"-PBVC-Inquiries");
        dfd.addServices(sd);
        try {
            DFService.register(this, dfd);
        }
        catch (Exception fe) {
            fe.printStackTrace();
        }

            Behaviour b = new OneShotBehaviour(this) {
                public void action() {
                    // Do something !
                }
            }; //End Behaviour b

          addBehaviour(tbf.wrap(b));


          // Before take down, un register service
          /*
           try {
           DFService.deregister(this);
           }
           catch (FIPAException fe) {
           fe.printStackTrace();
           }
           */
          // takeDown(); // Take down the agent
    }

}
