/*
 *  Tuan Anh Nguyen.  Email: t.nguyen@latrobe.edu.au
 * Computer Science & Computer Engineering Department
 * La Trobe University, VIC, 3086
 */

package agent.rbidding;
import jade.content.AgentAction;

import jade.core.*;
import jade.core.behaviours.*;
import jade.domain.*;
import jade.domain.FIPAAgentManagement.*;
import jade.lang.acl.*;
import jade.content.*;
import jade.content.lang.*;
import jade.content.lang.sl.*;
import jade.content.onto.*;
import jade.content.onto.basic.*;
import jade.util.leap.*;


import jade.content.onto.basic.Action;
import jade.domain.JADEAgentManagement.CreateAgent;
import jade.domain.JADEAgentManagement.JADEManagementOntology;

import jade.proto.AchieveREInitiator;
import java.util.Enumeration;
import java.util.Iterator;
/**
 *
 * @author Tuan Nguyen
 */
public class UserAgent extends Agent {

    private ThreadedBehaviourFactory tbf = new ThreadedBehaviourFactory();
    private AMSAgentDescription [] agents = null;
    private RBiddingRequestOperation myRequest =null;


    private Codec codec = new SLCodec();
    private Ontology ontology = RBiddingOntology.getInstance();


    protected void setup() {
        // Printout a welcome message
        String sUserAgentID=getAID().getLocalName();
        System.out.println("Hello World. I'm an agent!");
        System.out.println("My local-name is "+sUserAgentID );
        System.out.println("My GUID is "+getAID().getName());
        System.out.println("My addresses are:");

        System.out.println("Argument1: ItemX, Argument2: Price Y");

        //Iterator it = getAID().getAllAddresses();

        // Register language and ontology
        getContentManager().registerLanguage(codec);
        getContentManager().registerOntology(ontology);


            Object[] args = getArguments();
            String s;
            if (args != null) {
                for (int i = 0; i<args.length; i++) {
                    s = (String) args[i];
                    System.out.println("p" + i + ": " + s);
                }
            }
            String sItem=args[0].toString();

            float fPriceY=Float.parseFloat(args[1].toString());
            ACLMessage msg = new ACLMessage( ACLMessage.INFORM );
            msg.setLanguage(codec.getName());
            msg.setOntology(ontology.getName());

            try {
                 SearchConstraints c = new SearchConstraints();
                 c.setMaxResults ( new Long(-1) );
                 agents = AMSService.search( this, new AMSAgentDescription (), c );
                 int iLength = agents.length;

                 RBiddingRequestOperation action =new RBiddingRequestOperation();
                 action.setItemX(sItem);
                 action.setUserAgentID(sUserAgentID);
                 action.setPriceY(fPriceY);
                 for (int i=0; i< iLength ; i++){
                   AID agentName = agents[i].getName();
                   try {
                       getContentManager().fillContent(msg, new Action(agentName, action));
                       msg.addReceiver(agentName);
                   }catch (Exception ex) { 
                       ex.printStackTrace();
                   }
                   System.out.println("Agent ["+i+"]: "+ agentName.getLocalName());
                 }
             }
             catch (Exception e) {
                 System.out.println("Error");
             }
            send(msg);

            Behaviour b = new ReceiveMessages(this);
            addBehaviour(tbf.wrap(b));

    }


class ReceiveMessages extends CyclicBehaviour {
// Receive Messages from shops and put best offer to list

      public ReceiveMessages(Agent a) {
         super(a);
      }

      public void action() {

         ACLMessage msg = receive();
         if (msg == null) { block(); return; }
         try {
            ContentElement content = getContentManager().extractContent(msg);
            Concept action = ((Action)content).getAction();

            switch (msg.getPerformative()) {

               case (ACLMessage.REQUEST):
                  System.out.println("Request from " + msg.getSender().getLocalName());
                  if (action instanceof RBiddingOfferFromShopAgent)
                     addBehaviour(new HandleOfferFromShopAgent(myAgent, msg));
                  break;

               case (ACLMessage.QUERY_REF):
                  System.out.println("Query from " + msg.getSender().getLocalName());                  
                  break;
               default:
                   System.out.println("Message from " + msg.getSender().getLocalName());
            }
         }
         catch(Exception ex) { ex.printStackTrace(); }
      }
   }
class HandleOfferFromShopAgent extends OneShotBehaviour{

        private HandleOfferFromShopAgent(Agent myAgent, ACLMessage msg) {
            System.out.println("Handle Offer constructor");
        }

        public void action() {
         System.out.println("Handle Offer Actions");
        }
    
}

}
