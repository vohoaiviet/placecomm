/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package agent.rbidding;

import jade.lang.acl.ACLMessage;
import java.util.Enumeration;
import java.util.Iterator;

import java.io.*;
import java.util.Date;

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
import java.util.Random;

/**
 *
 * @author Tuan Nguyen
 */
public class ShopAgent extends Agent implements RBiddingVocabulary {

 private ThreadedBehaviourFactory tbf = new ThreadedBehaviourFactory();
 private Codec codec = new SLCodec();
 private Ontology ontology = RBiddingOntology.getInstance();

    protected void setup() {
        // Printout a welcome message
        System.out.println("Hello World. I'm an agent!");
        System.out.println("My local-name is "+getAID().getLocalName());
        System.out.println("My GUID is "+getAID().getName());
        System.out.println("My addresses are:");

        getContentManager().registerLanguage(codec);
        getContentManager().registerOntology(ontology);
        System.out.println("Ontology registered");

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
            
             // Set this agent main behaviour
            SequentialBehaviour sb = new SequentialBehaviour();
            sb.addSubBehaviour(new RegisterInDF(this));
            sb.addSubBehaviour(new ReceiveMessages(this));
            addBehaviour(sb);

    }
    // End setup

    ////////////////////////////////////////////////////////
    // Behaviors
    ////////////////////////////////////////////////////////
       class RegisterInDF extends OneShotBehaviour {
// ---------------------------------------------  Register in the DF for the client agent
//                                                be able to retrieve its AID
      RegisterInDF(Agent a) {
         super(a);
      }

      public void action() {

         ServiceDescription sd = new ServiceDescription();
         sd.setType(SHOPAGENT);
         sd.setName(getName());
         sd.setOwnership("Rbidding8776");
         DFAgentDescription dfd = new DFAgentDescription();
         dfd.setName(getAID());
         dfd.addServices(sd);
         try {
            DFAgentDescription[] dfds = DFService.search(myAgent, dfd);
            if (dfds.length > 0 ) {
               DFService.deregister(myAgent, dfd);
            }
            DFService.register(myAgent, dfd);
            System.out.println(getLocalName() + " is ready.");
         }
         catch (Exception ex) {
            System.out.println("Failed registering with DF! Shutting down...");
            ex.printStackTrace();
            doDelete();
         }
      }
   }

   class ReceiveMessages extends CyclicBehaviour {
// -----------------------------------------------  Receive requests and queries from client
//                                                  agent and launch appropriate handlers

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

                  if (action instanceof RBiddingRequestOperation)
                     addBehaviour(new RBiddingHandleRequestOperation(myAgent, msg));

                  break;

               case (ACLMessage.QUERY_REF):

                  System.out.println("Query from " + msg.getSender().getLocalName());
                  break;

               default:
                   System.out.println("Not understand query");
            }
         }
         catch(Exception ex) { ex.printStackTrace(); }
      }
   }

    class RBiddingProtocolBehavior extends  CyclicBehaviour
    {
        public RBiddingProtocolBehavior(Agent a){
            super(a);
        }
        @Override
        public void action() {
            ACLMessage msg= receive();
            if (msg!=null) {
                System.out.println( " - " + myAgent.getLocalName() +
                        " <- " + msg.getContent());
                String sMsgContent=msg.getContent();

                /* Process the protocol:
                 * CommunityAgent: RBID_X_FOR_Y(UID:ID,ItemX:nameX,PriceY:NumY),
                 * Shop agent offer to User Agent: RBID_Y_FOR_X(ShopAgentID, PriceY,ItemX)
                 *    Shop agent generate a random price +/- 15% in the range of Y price.
                 * User Agent received: Increased Message received 1 and add price into
                 * list after 15 minutes, find the smallest.
                 *
                 */
               // This is the old way.
               if (sMsgContent.startsWith("RBID_X_FOR_Y")){
                   //Parse parameter // Use ontology here

               }
            }
        }
        private boolean finished = false;

        
        public boolean xong() {
            return finished;
        }

    }//RBiddingProtocolBehavior


   class RBiddingHandleRequestOperation extends OneShotBehaviour {


      private ACLMessage request;

      RBiddingHandleRequestOperation(Agent a, ACLMessage request) {
         super(a);
         this.request = request;
      }

      public void action() {

         try {
            System.out.println("RBiddingHandleRequestOperation ");
         }
         catch(Exception ex) { ex.printStackTrace(); }
      }
   }


}
