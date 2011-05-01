
package au.edu.latrobe.placecomm.agents;

import au.edu.latrobe.placecomm.ontology.j2se.*;


import edu.stanford.smi.protege.event.FrameListener;
import edu.stanford.smi.protege.event.InstanceListener;
import edu.stanford.smi.protege.model.Cls;
import edu.stanford.smi.protege.model.Facet;
import edu.stanford.smi.protege.model.Frame;
import edu.stanford.smi.protege.model.FrameID;
import edu.stanford.smi.protege.model.Instance;
import edu.stanford.smi.protege.model.KnowledgeBase;
import edu.stanford.smi.protege.model.Project;
import edu.stanford.smi.protege.model.Reference;
import edu.stanford.smi.protege.model.Slot;
import edu.stanford.smi.protege.model.ValueType;
import edu.stanford.smi.protegex.owl.model.OWLModel;
import edu.stanford.smi.protegex.owl.model.RDFObject;
import edu.stanford.smi.protegex.owl.model.RDFProperty;
import edu.stanford.smi.protegex.owl.model.RDFResource;
import edu.stanford.smi.protegex.owl.model.RDFSClass;
import edu.stanford.smi.protegex.owl.model.RDFSLiteral;
import edu.stanford.smi.protegex.owl.model.event.PropertyValueListener;
import edu.stanford.smi.protegex.owl.model.event.ResourceListener;
import edu.stanford.smi.protegex.owl.model.visitor.OWLModelVisitor;
import jade.content.onto.OntologyException;
import jade.content.onto.UngroundedException;
import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;

import jade.util.leap.Iterator;
import jade.util.leap.List;



import edu.stanford.smi.protegex.owl.model.query.QueryResults;
import jade.content.ContentElement;
import jade.content.lang.Codec;
import jade.content.lang.Codec.CodecException;

import jade.content.lang.sl.SLCodec;
import jade.content.onto.Ontology;
import jade.core.AID;
import jade.lang.acl.MessageTemplate;
import java.util.*;
import java.util.logging.*;


// PBVC Ontology
import au.edu.latrobe.placecomm.ontology.j2se.*;


/**
 *
 * @author Tuan Nguyen
 */
public class KnowledgeBaseAgent extends Agent {

 private ThreadedBehaviourFactory tbf = new ThreadedBehaviourFactory();
     private Project globalProject  =null;
     private KnowledgeBase globalKnowledgeBase  = null;
     private OWLModel globalOwlModel =null;
     private String sURI="http://www.tuannguyen.mobi/ontologies/2010/tinypbvc.owl#";
     //                   http://www.tuannguyen.mobi/ontologies/2010/tinypbvc.owl#personPresenceAtPlace
     private String sLocationURI=sURI+"Location";
     private String sHasPersonPresence=sURI+"hasPersonPresence";
     private String sPlaceURI=sURI+"Place";
     private String sPlaceIDURI=sURI+"placeID";
     private String sPPPURI=sURI+"personPresenceAtPlace";
     private String sLatURI = sURI + "lat";
     private String sLonURI = sURI + "lon";
     private String sAltURI = sURI + "alt";
     private String sSpeedURI = sURI + "speed";
     private String sTimeURI = sURI + "timestamp";
     private String sDateURI = sURI + "date";
     private String hasPostalAddressURI = sURI+"hasPostalAddress";
     private String sPersonURI = sURI+"Person";

     private Codec codec = new SLCodec();
     private Ontology ontology = PlaceCommOntology.getInstance();


     protected void setup() {
        // Printout a welcome message
        System.out.println("Hello World. I'm an agent!");
        System.out.println("My local-name is "+getAID().getLocalName());
        System.out.println("My GUID is "+getAID().getName());
        System.out.print("My addresses are:");
        Iterator it = getAID().getAllAddresses();
        while (it.hasNext()){
            System.out.println(it.next().toString());
        }
        getContentManager().registerLanguage(codec);
        getContentManager().registerOntology(ontology);
        // Connect to KB
        String sProtegeProjectFile="E:\\1Working\\Video\\Demo\\pbvc\\pbvcData.pprj";
        Collection errors = new ArrayList();
        // LoadKnowledgeBase at the first run
        try{
        globalProject = Project.loadProjectFromFile(sProtegeProjectFile, errors);
        globalKnowledgeBase= globalProject.getKnowledgeBase();
        globalOwlModel = (OWLModel) globalProject.getKnowledgeBase();
        System.out.println("Connect KB successfully");
        }catch (Exception e){
            System.out.println("Connect KB FAILED: "+e.toString());
        }

        //Behaviour bSparqlQueries = new handleSparqlQueries(this) ;
        //Behaviour bCreateNewLocation = new handleCreateNewLocation(this) ;
        //addBehaviour(tbf.wrap(bSparqlQueries));
        //addBehaviour(tbf.wrap(bCreateNewLocation));

        Behaviour bHandleActivities = new handleActivities(this) ;
        addBehaviour(tbf.wrap(bHandleActivities));

        System.out.println("Add Behaviour OK");
          // takeDown(); // Take down the agent
    }// End setup()



/////////////////////////////////////
/// Inner class for behaviours
/////////////////////////////////////
public class handleActivities extends CyclicBehaviour{
    private Project prj  =null;
    private KnowledgeBase kb  = null;
    private OWLModel owlModel =null;

    handleActivities(KnowledgeBaseAgent aThis) {
        this.prj = aThis.globalProject;
        this.kb  = aThis.globalKnowledgeBase;
        this.owlModel = aThis.globalOwlModel;
    }
        public void setup(){

        }
        @Override
        public void action() {

            MessageTemplate mt = MessageTemplate.and(MessageTemplate.MatchLanguage(codec.getName()),
                    MessageTemplate.MatchOntology(ontology.getName()));

            ACLMessage msg = blockingReceive(mt);

            try {

                ContentElement ce = null;
                if (msg.getPerformative() == ACLMessagePBVC.PLACECOMM_SPARQL) {
                    System.out.println("Got ACLMessagePBVC.PLACECOMM_SPARQL");
                    AID sender = msg.getSender();
                    ce = getContentManager().extractContent(msg);
                    System.out.println("ce = getContentManager().extractContent(msg);");
                    if (ce instanceof HasQuery) {
                        System.out.println("Yes it has Query");
                        HasQuery qQuery = (HasQuery) ce;
                        String sQuery = qQuery.getSQuery();

                        try {

                            QueryResults results = owlModel.executeSPARQLQuery(sQuery);
                            System.out.println("Query executed successfully");

                            java.util.List varsList = results.getVariables();
                            while (results.hasNext()){
                                Map map = results.next();
                                for (int i = 0; i < varsList.size(); i++) {
                                    String varName = (String) varsList.get(i);
                                    RDFObject value = (RDFObject) map.get(varName);
                                    String strResult=varName+" = "+value.getBrowserText();
                                    System.out.println("Result is: "+strResult);
                                    HasQuery QResult = new HasQuery();
                                    QResult.setSQuery(varName);
                                    QResult.setSQueryResult(strResult);

                                    sendResultsBack(sender, QResult);
                                }
                            }

                        } catch (Exception ex) {
                            System.out.println("Sparql Error: "+ex.toString());


                        }
                    }
                }// endif ACLMessagePBVC.PLACECOMM_SPARQL
                else if (msg.getPerformative() == ACLMessagePBVC.PLACECOMM_POSITIONING_CREATE_LOCATION){
                    System.out.println("ACLMessagePBVC.PLACECOMM_POSITIONING_CREATE_LOCATION");
                    ce = getContentManager().extractContent(msg);
                    if (ce instanceof Location) {
                        Location lLoc = (Location) ce;
                        String sSpeed = lLoc.getSpeed();
                        String sLat   = lLoc.getLat();
                        String sLon   = lLoc.getLon();
                        String sAlt   = lLoc.getAlt();
                        createNewLocation( sLat, sLon, sAlt,sSpeed);

                    }
                }
                else if (msg.getPerformative() == ACLMessagePBVC.PLACECOMM_PLACESENSE_CASSCADING_INSERTION){
                     System.out.println("ACLMessagePBVC.PLACECOMM_PLACESENSE_CASSCADING_INSERTION");
                    ce = getContentManager().extractContent(msg);
                    if (ce instanceof Device) {
                       Device discoveredDevice= (Device)ce;
                       String sMAC=discoveredDevice.getDeviceID();
                       String sFriendlyName=discoveredDevice.getDeviceName();
                       Person pPerson =discoveredDevice.getHasOwner();


                       Date md=new Date();
                       long l=md.getTime();
                       String sTimestamp=Long.toString(l);

                       // Check owner
                       sMAC="001ADCD98E21";
                       String sPersonURI = checkOwner (sMAC); //TuanNguyen
                       Instance PersonInstance=globalKnowledgeBase.getInstance(sPersonURI);//TuanNguyen
                       System.out.println("Owner="+sPersonURI);
                       Slot slotPersonPresenceAtPlace = globalKnowledgeBase.getSlot(sPPPURI);

                       String sPlaceID="Place_";//+sPlace;
                       String sNewPlaceURI=null;
                       try{
                           sNewPlaceURI = createNewPlace(sPlaceID, sTimestamp,sPersonURI);
                       }catch (Exception e){
                           System.out.println("Create Place Failed");
                       }

                       globalKnowledgeBase.commitTransaction();


                    }
                }//PLACECOMM_PLACESENSE_CASSCADING_INSERTION

                else if (msg.getPerformative() == ACLMessagePBVC.PLACECOMM_PLACESENSE_BLUETOOTH){
                    /* First: We Insert discovered device presence to KB InsertDeviceToPlace()
                     * Then: Check device belong to whom, ownDevice, then Insert Person Presence
                     * Use function: checkOwner(MAC)
                     * if found then insert PersonPresenceAtPlace() InsertPersonPresenceAtPlace(Person, Place)
                     */
                    /*
                    ce = getContentManager().extractContent(msg);
                    if (ce instanceof GotBluetoothDevice) {
                       GotBluetoothDevice discoveredDevice= (GotBluetoothDevice)ce;
                       String sMAC=discoveredDevice.getGotBluetoothDeviceMAC();
                       String sFriendlyName=discoveredDevice.getGotBluetoothDeviceName();
                       String sSpeed=discoveredDevice.getGotBluetoothDeviceSPEED();
                       String sPlace=discoveredDevice.getGotBluetoothDeviceAtPlace();

                       InsertDeviceToPlace(discoveredDevice,sPlace);
                       boolean bOwnBySomeone = checkOwner(sMAC);
                       if (bOwnBySomeone){
                           HasPerson pPerson = new HasPerson;
                           InsertPersonPresenceAtPlace( pPerson, sPlace);

                       }
                    }
                       */




                }//ACLMessagePBVC.

            } catch (UngroundedException e) {
                Logger.getLogger(KnowledgeBaseAgent.class.getName()).log(Level.SEVERE, null, e);
            } catch (OntologyException e1) {
                Logger.getLogger(KnowledgeBaseAgent.class.getName()).log(Level.SEVERE, null, e1);
            }catch(CodecException e2){
                 Logger.getLogger(KnowledgeBaseAgent.class.getName()).log(Level.SEVERE, null, e2);
            }
        }// End action()



        private String checkOwner(String sMAC) {

            String sQuery="SELECT ?person "+
                    " WHERE { ?person rdf:type :Person ; "+
                    " :ownDevice ?dev. "+
                    " ?dev rdf:type :Device ; "+
                    " :deviceID ?devID . "+
                    " FILTER (?devID=\""+sMAC+"\") }";
            String queryResults="";
            System.out.println("sQuery="+sQuery);
            try {
                QueryResults results = owlModel.executeSPARQLQuery(sQuery);
                while (results.hasNext()){
                    queryResults=results.next().toString();
                    break;
                }

            } catch (Exception ex) {
                System.out.println("Sparql Error: "+ex.toString());
            }


            queryResults.trim();
            //queryResults=
            //{person=DefaultOWLIndividual(http://www.tuannguyen.mobi/ontologies/2010/tinypbvc.owl#TuanNguyen
            // of [DefaultOWLNamedClass(http://www.tuannguyen.mobi/ontologies/2010/tinypbvc.owl#Person)])}
            queryResults=queryResults.substring(queryResults.indexOf("(")+1,queryResults.indexOf(" of ")).trim();
            System.out.println("queryResults="+queryResults);

            return queryResults;
        }


        private Person getPerson(String sMAC){

            return null;
        }


        private void notifyOwnerToUserAgent(ACLMessage msg) {
            throw new UnsupportedOperationException("Not yet implemented");
        }

        private String hasPersonPresence(Location location, String sOwner) {
            throw new UnsupportedOperationException("Not yet implemented");
        }

          private void InsertDeviceToPlace(Device discoveredDevice, String sPlace) {
            /*
             * First of all, check whether device is existed in the KB?
             * If not create new device, then insert into KB
             * Else
             *      getDevice, get Place, then update hasDevicePresence;
             *
             */
        }
        private void InsertPersonPresenceAtPlace(Person ps, String sPlace ){

        }



    }


    /////////////////////////////////////
    private String createNewPlace(String sPlaceID, String sTimestamp, String sPersonURI) {
        //sPlaceURI
        Slot placeID_slot = globalKnowledgeBase.getSlot(sPlaceIDURI);
        Slot slot_hasPersonPresence= globalKnowledgeBase.getSlot(sHasPersonPresence);
        Instance newInstance=null;
        Cls clsName = globalKnowledgeBase.getCls(sPlaceURI);
        System.out.println("PlaceURI="+sPlaceURI);
        String sNewInstanceName=sPlaceID+sTimestamp;
        String newPlaceURI=sURI+sNewInstanceName;
        Instance insPerson=globalKnowledgeBase.getInstance(sPersonURI);
        try{
            newInstance = globalKnowledgeBase.createInstance(sNewInstanceName, clsName);
            System.out.println("Create new instance OK!!!");
            newInstance.setOwnSlotValue(placeID_slot, sPlaceID);
            newInstance.setOwnSlotValue(slot_hasPersonPresence,insPerson);

            globalKnowledgeBase.addInstance(newInstance, "Place: " +
                    sNewInstanceName + " added", clsName, true);
            //theLogger.info("Location instance: "+sNewInstanceName+" successfully! ");
            System.out.println("Create New Place SUCCESSFULLY, chek MySQL to see");
        }catch(Exception ex){
            System.out.println("Create Place failed");
        }
        return newPlaceURI;
    }


        private String createNewLocation(String sLat,String sLon, String sAlt,
                String sSpeed) {
                Slot lat_slot = globalKnowledgeBase.getSlot(sLatURI);
                Slot lon_slot = globalKnowledgeBase.getSlot(sLonURI);
                Slot alt_slot = globalKnowledgeBase.getSlot(sAltURI);
                Slot speed_slot = globalKnowledgeBase.getSlot(sSpeedURI);
                Slot date_slot = globalKnowledgeBase.getSlot(sDateURI);
                Slot timestamp_slot = globalKnowledgeBase.getSlot(sTimeURI);
                Slot hasPostalAddress_slot = globalKnowledgeBase.getSlot(hasPostalAddressURI);

                // createNewLocation (str = LOCATION#Lat:10.25,Lon:45.23,Alt:20,Speed:89)
                System.out.println("Inside create Location");

                float fLat = Float.parseFloat(sLat);
                //System.out.println("fLat "+fLat);
                float fLon = Float.parseFloat(sLon);
                //System.out.println("fLon "+fLon);
                float fSpeed = Float.parseFloat(sSpeed);
                //System.out.println("fSpeed "+fSpeed);
                float fAlt = Float.parseFloat(sAlt);
                //System.out.println("fAlt "+fAlt);

                //System.out.println("sDate "+sDate );
                Date mdate=new Date();

                String sTimestamp = Long.toString(mdate.getTime());
                System.out.println("sTimestamp "+sTimestamp );

                String sNewInstanceName= "AgentLeapMobile"+sTimestamp;

                Instance newInstance=null;
                Cls clsName = globalKnowledgeBase.getCls(sLocationURI);
                System.out.println("Inside create Location");
                try{
                newInstance = globalKnowledgeBase.createInstance(sNewInstanceName, clsName);

                newInstance.setOwnSlotValue(lat_slot, fLat);
                newInstance.setOwnSlotValue(lon_slot, fLon);
                newInstance.setOwnSlotValue(alt_slot, fAlt);
                newInstance.setOwnSlotValue(speed_slot, fSpeed);
                newInstance.setOwnSlotValue(timestamp_slot, sTimestamp);

                globalKnowledgeBase.addInstance(newInstance, "Location: " +
                        sNewInstanceName + " added", clsName, true);
                //theLogger.info("Location instance: "+sNewInstanceName+" successfully! ");
                System.out.println("Create Instance SUCCESSFULLY, chek MySQL to see");
                }catch(Exception ex){
                    System.out.println("Create Instance failed");
                }
                return sNewInstanceName;
        }//createNewLocation

        public void sendResultsBack(AID Receiver, HasQuery QResult){

            ACLMessage msgReply=new ACLMessage(ACLMessagePBVC.PLACECOMM_SPARQL_RESULT);
            msgReply.addReceiver(Receiver);
            msgReply.setLanguage(codec.getName());
            msgReply.setOntology(ontology.getName());

            try {
                getContentManager().fillContent(msgReply, QResult);
                send(msgReply);
            } catch (CodecException ex) {
                Logger.getLogger(KnowledgeBaseAgent.class.getName()).log(Level.SEVERE, null, ex);

            } catch (OntologyException ex) {

                Logger.getLogger(KnowledgeBaseAgent.class.getName()).log(Level.SEVERE, null, ex);
            }

        }



}
