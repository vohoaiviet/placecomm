/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package example;

/**
 *
 * @author Tuan Nguyen
 */


import jade.core.Agent;
import jade.core.AID;
import jade.core.behaviours.*;

import jade.lang.acl.*;

import jade.util.leap.*;
import jade.util.Logger;




import java.util.*;



/**
 *
 * @author Tuan Nguyen
 */
public class SimpleAgent  extends Agent {


    private SimpleAgentGUI myAgentGUI;
    public String sLocalName;
    public String sAgentFullName;

    // Create constructor

    protected void takeDown() {
        if (myAgentGUI != null) {
            myAgentGUI.dispose();
        }
    }

    protected void setup() {
        // Printout a welcome message
         sLocalName=getAID().getLocalName();
         sAgentFullName=getAID().getName();
        System.out.println("Hello World. I'm an agent!");
        System.out.println("My local-name is "+sLocalName);
        System.out.println("My full Name is "+sAgentFullName);
        Iterator it = getAID().getAllAddresses();


        int i=0;
        while (it.hasNext()){
            System.out.println("Address ["+i+"]="+it.next().toString());
            i++;
        }

        // Activate the GUI
        try{
        myAgentGUI = new SimpleAgentGUI(this);
        }catch (Exception e){
            System.out.println("Start GUI failed!");
        }

        myAgentGUI.getAgentInformation(sAgentFullName, sLocalName);
        // Initials behaviours.
        addBehaviour(new handleActivities(this));

        // takeDown(); // Take down the agent
    }

    void sendMsg(String sAgentName, String sMsgContent) {

        System.out.println("Sender: "+sAgentFullName);
        System.out.println("Receiver: "+sAgentName);
        System.out.println("Message: "+sMsgContent);

        ACLMessage msg = new ACLMessage (ACLMessage.INFORM);
        AID agentID=new AID(sAgentName,AID.ISLOCALNAME);        
        msg.addReceiver(agentID);
        msg.setContent(sMsgContent);
        send(msg);
        
    }


///////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////

    public class handleActivities extends CyclicBehaviour {
        handleActivities(Agent a) {
            super(a);
        }

        public void action() {
        
            ACLMessage msg= receive();
        
            if (msg!=null){
                
                  String sContent= msg.getContent();
                  String sSenderName = msg.getSender().getLocalName();
                  //System.out.println("Received messange: "+sContent+ " from: "+sSenderName);
                  myAgentGUI.updateMessage(sSenderName, sContent);                 
            }else {
                System.out.println("Bloking");
                 block();
            }
               System.out.println("EndAction");

        }// End action()

    }
    ///////////////////////////////////////////////////////////////////////////



}
