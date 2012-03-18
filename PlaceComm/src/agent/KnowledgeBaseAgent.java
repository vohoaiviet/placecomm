/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package agent;
import jade.core.*;
import jade.core.behaviours.*;
import jade.wrapper.*;

import jade.lang.acl.ACLMessage;
import jade.MicroBoot;
import jade.util.leap.Properties;


import java.net.URI;

import java.util.Enumeration;
import java.util.Iterator;


import com.hp.hpl.jena.query.*;
import com.hp.hpl.jena.rdf.arp.impl.Location;

import com.hp.hpl.jena.util.FileUtils;
import edu.stanford.smi.protege.model.*;
import edu.stanford.smi.protege.widget.*;
import edu.stanford.smi.protege.resource.*;

import edu.stanford.smi.protege.exception.OntologyLoadException;
import edu.stanford.smi.protege.model.KnowledgeBaseFactory;
import edu.stanford.smi.protegex.owl.model.OWLModel;
import edu.stanford.smi.protegex.owl.model.OWLNamedClass;
import edu.stanford.smi.protegex.owl.ProtegeOWL;
import edu.stanford.smi.protegex.owl.jena.JenaOWLModel;
import edu.stanford.smi.protegex.owl.model.OWLDatatypeProperty;
import edu.stanford.smi.protegex.owl.model.OWLObjectProperty;
import edu.stanford.smi.protegex.owl.model.RDFIndividual;
import edu.stanford.smi.protegex.owl.model.query.QueryResults;
//import com.hp.hpl.jena.graph.query.Query;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import javax.xml.parsers.*;
import org.w3c.dom.*;


import java.io.*;
import java.util.logging.*;
import java.net.*;

/**
 *
 * @author Tuan Nguyen
 */
public class KnowledgeBaseAgent extends Agent {

 private ThreadedBehaviourFactory tbf = new ThreadedBehaviourFactory();
 private OWLModel owlModel=null;
 private KnowledgeBase kb=null;
 private Project prj=null;

    protected void setup() {
        // Printout a welcome message
        System.out.println("Hello World. I'm an agent!");
        System.out.println("My local-name is "+getAID().getLocalName());
        System.out.println("My GUID is "+getAID().getName());
        
        Iterator it = getAID().getAllAddresses();

        Behaviour loadKBBehaviour = new OneShotBehaviour(this) {

        public void CreateRandomConference(Project myProject, int number){

            kb  = myProject.getKnowledgeBase();
            Collection cClses = kb.getClses();
            Cls cOrganizedEvent =kb.getCls("http://www.tuannguyen.mobi/ontologies/eswc.owl#OrganizedEvent");
            String sPercomProceeding="http://www.tuannguyen.mobi/ontologies/eswc.owl#PerCom2008";
            String sHasProceeding= "http://www.tuannguyen.mobi/ontologies/eswc.owl#hasProceeding";
            try {
                
                for (int i=0; i<number;i++){
                 Date mdate=new Date();
                 long lRandomNumber=mdate.getTime();
                 String sInstanceName="Conference"+lRandomNumber ;

                 // Create new instance
                 Instance instanceToAddTo = cOrganizedEvent.createDirectInstance(sInstanceName);
                 //instanceToAddTo.s
                 //Thread.sleep(10);
                 // Set relationship
                 //Slot sFriendOfSlot= kb.getSlot("http://xmlns.com/foaf/0.1/friendOf");
                 Slot hasProceeding= kb.getSlot(sHasProceeding);
                 Instance iPercom2008= kb.getInstance(sPercomProceeding);
                 instanceToAddTo.setOwnSlotValue(hasProceeding, iPercom2008);

                 kb.addInstance(instanceToAddTo, "OrganizedEvent added", cOrganizedEvent, true);
                }
            } catch (Exception ex) {
                Logger.getLogger(KnowledgeBaseAgent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

            public void action() {

            try {
            String className = "com.mysql.jdbc.Driver";
            Class.forName(className);
            String DB_URL = "jdbc:mysql://localhost/ESWC"; // URL of database
            String DB_USER = "pbvc"; // database user id

            String DB_PASSWD = "merdecitd"; // database password
            String DB = "MySQL"; // database type

            Collection errors = new ArrayList();

            prj = Project.loadProjectFromFile("D://1Working//Ontology-MySQL//eswc.pprj",errors);
            owlModel = (OWLModel) prj.getKnowledgeBase();

            System.out.println(errors.toString());

            String nayme="";  // Declare & initialize a String to hold input.
            Scanner input=new Scanner(System.in); // Decl. & init. a Scanner.

            System.out.print("Whut yur nayme? >");  // Troll asks for name.
            nayme=input.next(); // Get what the user types.
            System.out.println();  // Move down to a fresh line.
            // Then say something trollish and use their name.
            System.out.println("Hur, hur! Dat's a phunny nayme, " + nayme + "!");

            try {
                Date mdate=new Date();
                long lRandomNumber=mdate.getTime();
                CreateRandomConference(prj,1);
                Date mdate2=new Date();
                long lRandomNumber2=mdate2.getTime();
                long duration=lRandomNumber2-lRandomNumber ;
                System.out.println("Duration for creating 1 instance:"+duration);

                  //String sQuery="SELECT ?subject ?object WHERE { ?subject rdfs:subClassOf ?object }";
                  String sQuery="SELECT ?subject  WHERE { ?subject rdf:type :OrganizedEvent}";
                  QueryResults results = owlModel.executeSPARQLQuery(sQuery);
                  String sResult="";

                  /*(
                  while (results.hasNext()) {
                    sResult=results.next().toString();
                    System.out.println(sResult);
                  }
                  */
                for (int i=0; i<10000; i++)  {
                CreateRandomConference(prj,10000);
                
                }
                    //  Query again
                    results = owlModel.executeSPARQLQuery(sQuery);
                    while (results.hasNext()) {
                    sResult=results.next().toString();
                    System.out.println(sResult);
                    Logger.getLogger(KnowledgeBaseAgent.class.getName()).log(Level.INFO,
                            sResult, "ok");
                    }
             } catch (OntologyLoadException e) {
                  e.printStackTrace();
             } catch (Exception ex) {
                    Logger.getLogger(KnowledgeBaseAgent.class.getName()).log(Level.SEVERE, null, ex);
             }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KnowledgeBaseAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
            }
                //block();

                
        }; //End Behaviour b
        addBehaviour(tbf.wrap(loadKBBehaviour));


    }

 
}
