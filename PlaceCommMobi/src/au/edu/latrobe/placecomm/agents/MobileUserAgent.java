/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package au.edu.latrobe.placecomm.agents;

import au.edu.latrobe.placecomm.ontology.j2me.*;
import jade.content.ContentElement;
import jade.core.Agent;
import jade.core.AID;
import jade.core.behaviours.*;

import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import jade.util.leap.*;
import jade.util.Logger;


import jade.content.ContentManager;
import jade.content.lang.Codec;
import jade.content.lang.sl.SLCodec;
import jade.content.onto.Ontology;
import jade.content.onto.BasicOntology;
import jade.content.abs.*;
import jade.content.lang.Codec.CodecException;

import jade.content.onto.OntologyException;
import jade.content.onto.UngroundedException;

import java.util.*;

 

/**
 *
 * @author Tuan Nguyen
 */
public class MobileUserAgent extends Agent {

    private Codec codec = new SLCodec();
    private Ontology ontology = PlaceCommOntology.getInstance();
    private MobileUserAgentGUIInterface myAgentGUI;
    
    // Create constructor

    protected void takeDown() {
		if (myAgentGUI != null) {
			myAgentGUI.dispose();
		}
    }
    
    protected void setup() {
        // Printout a welcome message
        System.out.println("Hello World. I'm an agent!");
        System.out.println("My local-name is "+getAID().getLocalName());
        System.out.println("My GUID is "+getAID().getName());        
        Iterator it = getAID().getAllAddresses();

        // Register language and ontology
        getContentManager().registerLanguage(codec);
        getContentManager().registerOntology(ontology);

        int i=0;
        while (it.hasNext()){
            System.out.println("Address ["+i+"]="+it.next().toString());
            i++;
        }

        // Activate the GUI        
        try{
        myAgentGUI = new MobileUserAgentGUI(this);
        }catch (Exception e){
            System.out.println("Start GUI failed!");
        }
        
        // Initials behaviours.
        addBehaviour(new handleActivities(this));

        // takeDown(); // Take down the agent
    }
    // Public interface

    public void updateCurrentLocation(AID agentID, String sLat, String sLon,
            String sAlt, String sSpeed) {

        String sContent="LOCATION#Lat:"+sLat+",Lon:"+sLon+",Alt:"+sAlt+",Speed:"+sSpeed;
        ACLMessage msg= new ACLMessage(ACLMessagePBVC.PLACECOMM_POSITIONING_CREATE_LOCATION);
        msg.addReceiver(agentID);
        msg.setLanguage(codec.getName());
        msg.setOntology(ontology.getName());
        //msg.setContent(sContent);

        Location loc1 =new Location();
        loc1.setLat(sLat);
        loc1.setLon(sLon);
        loc1.setSpeed(sSpeed);
        
        try {
            getContentManager().fillContent(msg, loc1);
            send(msg);
        } catch (Exception ex) {
            System.out.println("Error:"+ex.toString());
        }        
        System.out.println("Content="+sContent+" was sent");

    }

    void sendSparql(AID agentID, String sQuery) {
        ACLMessage msg= new ACLMessage(ACLMessagePBVC.PLACECOMM_SPARQL);
        System.out.println("sQueries="+sQuery);
        msg.addReceiver(agentID);
        msg.setLanguage(codec.getName());
        msg.setOntology(ontology.getName());

        HasQuery myQuery=new HasQuery();
        myQuery.setSQuery(sQuery);

        myQuery.setSQueryResult("");
        
        
        try {
            getContentManager().fillContent(msg, myQuery);
            send(msg);
            System.out.println("Query="+sQuery+" was sent");
        } catch (Exception ex) {
            System.out.println("Error:"+ex.toString());
        }

    }

    void InsertBlueDeviceToKB(Device discoveredDevice, AID agentID) {

        ACLMessage msg= new ACLMessage(ACLMessagePBVC.PLACECOMM_PLACESENSE_BLUETOOTH);
        msg.addReceiver(agentID);
        msg.setLanguage(codec.getName());
        msg.setOntology(ontology.getName());
        try {
            getContentManager().fillContent(msg, discoveredDevice);
            send(msg);
        } catch (Exception ex) {
            System.out.println("Error:"+ex.toString());
        }
    }

    void cascadingInsertionBluedevice(Device discoveredDevice, AID agentID) {

        ACLMessage msg= new ACLMessage(ACLMessagePBVC.PLACECOMM_PLACESENSE_CASSCADING_INSERTION);
      
        msg.addReceiver(agentID);
        msg.setLanguage(codec.getName());
        msg.setOntology(ontology.getName());
        try {
            getContentManager().fillContent(msg, discoveredDevice);
            send(msg);
        } catch (Exception ex) {
            System.out.println("Error:"+ex.toString());
        }

    }

///////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
// Inner class, handle protocols, communications.
///////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
    public class handleActivities extends CyclicBehaviour {
        handleActivities(Agent a) {
            super(a);
        }

        public void action() {
         MessageTemplate mt = MessageTemplate.and(MessageTemplate.MatchLanguage(codec.getName()),
                    MessageTemplate.MatchOntology(ontology.getName()));

         ACLMessage msg = blockingReceive(mt);

            try {
                ContentElement ce = null;
                if (msg.getPerformative() == ACLMessagePBVC.PLACECOMM_SPARQL_RESULT) {
                    System.out.println("Got ACLMessagePBVC.PLACECOMM_SPARQL_RESULT");
                    ce = getContentManager().extractContent(msg);
                    System.out.println("extractContent OK");
                    try {
                        if (ce instanceof HasQuery) {
                        HasQuery qResult = (HasQuery) ce;
                        String s = qResult.getSQueryResult();
                        myAgentGUI.updateSparqlResults(s);
                        System.out.println("Result= "+s);
                        }
                    }catch (Exception e){
                        System.out.println(e.toString());
                    }
                        

                }else if (msg.getPerformative() == ACLMessagePBVC.PLACECOMM_ADVERTISING) {

                }else if (msg.getPerformative() == ACLMessagePBVC.PLACECOMM_JOINING) {

                }else if (msg.getPerformative() == ACLMessagePBVC.PLACECOMM_LEAVING) {

                }else if (msg.getPerformative() == ACLMessagePBVC.PLACECOMM_POSITIONING) {
                    
                }
            } catch (UngroundedException e) {
                System.out.println("UngroundedException: "+e.toString());
            } catch (OntologyException e1) {
                System.out.println("OntologyException : "+e1.toString());
            }catch(CodecException e2){
                 System.out.println("CodecException: "+e2.toString());
            }

        }// End action()

    }
    ///////////////////////////////////////////////////////////////////////////



}
