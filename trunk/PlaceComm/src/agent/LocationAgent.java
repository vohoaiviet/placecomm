/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package agent;

/**
 *
 * @author tuannguyen
 */
import knowledgebase.*;
import com.hp.hpl.jena.rdf.arp.impl.Location;
import com.hp.hpl.jena.util.FileUtils;
import edu.stanford.smi.protege.model.KnowledgeBase;
import edu.stanford.smi.protege.exception.OntologyLoadException;
import edu.stanford.smi.protege.model.KnowledgeBaseFactory;
import edu.stanford.smi.protegex.owl.model.OWLModel;
import edu.stanford.smi.protegex.owl.model.OWLNamedClass;
import edu.stanford.smi.protegex.owl.ProtegeOWL;
import edu.stanford.smi.protegex.owl.jena.JenaOWLModel;
import edu.stanford.smi.protegex.owl.model.OWLDatatypeProperty;
import edu.stanford.smi.protegex.owl.model.OWLObjectProperty;
import edu.stanford.smi.protegex.owl.model.RDFIndividual;
import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.xerces.parsers.SAXParser;
//import pbvc.ontology.*;

public class LocationAgent {

    
    public static void main(String[] args) {

    try {
        JenaOWLModel owlModel = ProtegeOWL.createJenaOWLModel();


        //OWLModel owlModel = ProtegeOWL.createJenaOWLModel();
        // OWLKnowledgeBase is a old API of OWLModel
        owlModel.getNamespaceManager().setDefaultNamespace(
                "http://www.tuannguyen.mobi/ontologies/2010/comorea.owl#");
        OWLNamedClass locationClass = owlModel.createOWLNamedClass("Location");
        System.out.println("Class URI: " + locationClass.getURI());
        
        
        
        //String uri = "http://www.tuannguyen.mobi/ontologies/2010/comorea.owl";
        //String uri = "d:\\temp\\comorea\\Comorea.owl";
        String uri = "http://www.tuannguyen.mobi/ontologies/2010/comorea.owl";
        try {
            // It works !
            owlModel = ProtegeOWL.createJenaOWLModelFromURI(uri);
            System.out.println("Load Model successful");

            // GPS data from GPS Agent
            // 1246060329265,83.99946594238281,-37.779801666666664,145.08594833333333,41.279998779296875
            // T, Speed, Lat, Lon, Alt.
            Collection instances = new ArrayList();
            instances = owlModel.getRDFResources();
            printItems(instances, "insntace ");       
            
            Collection classes = new ArrayList();
            classes = owlModel.getUserDefinedOWLNamedClasses();
            printItems(classes, "UserDefined Class ");                   

            Collection individual = new ArrayList();
            individual= owlModel.getRDFIndividuals();
            printItems(individual, "individual ");
            OWLNamedClass PlaceClass=owlModel.getOWLNamedClass("Place");
            OWLNamedClass LocationClass=owlModel.getOWLNamedClass("Location");
            Collection InstancesOfPlace =PlaceClass.getInstances();
            //printItems(InstancesOfPlace , "Place");
            // These block of code below does the same meaning with printItems();

            Iterator i = InstancesOfPlace.iterator();
            int icount=0;
            while (i.hasNext()) {
                System.out.println("Place "+ icount+" : " + i.next());         
                icount++;
            }

            OWLObjectProperty belongToPlace = owlModel.getOWLObjectProperty("belongToPlace");
            OWLObjectProperty submittedBy = owlModel.getOWLObjectProperty("submittedBy");
            OWLDatatypeProperty latitudeProperty = owlModel.getOWLDatatypeProperty("latitude");
            OWLDatatypeProperty longitudeProperty = owlModel.getOWLDatatypeProperty("longitude");
            OWLDatatypeProperty altitudeProperty = owlModel.getOWLDatatypeProperty("altitude");
            OWLDatatypeProperty timestampProperty = owlModel.getOWLDatatypeProperty("timestamp");
            OWLDatatypeProperty previousTimestampProperty = owlModel.getOWLDatatypeProperty("previousTimestamp");
            OWLDatatypeProperty speedProperty = owlModel.getOWLDatatypeProperty("speed");
            OWLDatatypeProperty nameProperty = owlModel.getOWLDatatypeProperty("name");

            


    //LocationClass;
    //
    RDFIndividual EasternFreewayClass  = PlaceClass.createOWLIndividual("EasternFreewayPlace");        
    
    //1246060329|265,83.99946594238281,-37.779801666666664,145.08594833333333,41.279998779296875
    
  
    //File file= EasternFreeway.csv
   // line="1246060329265,83.99946594238281,-37.779801666666664,145.08594833333333,41.279998779296875"
    String tempIndividualName="EasternFreeWayContext_";
    int iCount = 10;

    String filename="d:\\temp\\comorea\\EasternFreeway.csv";

     try {

      BufferedReader input =  new BufferedReader(new FileReader(filename));
      try {
        String line = null; //not declared within while loop
        int j=0;
        while (( line = input.readLine()) != null){

        String words[]=line.split(",");

        String timestamp=words[0];
        String speed=words[1];
        String lat=words[2];
        String lon=words[3];
        String alt=words[4];    
        float fSpeed = Float.valueOf(speed);

        tempIndividualName=tempIndividualName.concat(String.valueOf(j));
        RDFIndividual EasternFreewayIndividual = LocationClass.createRDFIndividual(tempIndividualName);

        EasternFreewayIndividual.setPropertyValue(belongToPlace, EasternFreewayClass);
        EasternFreewayIndividual.setPropertyValue(latitudeProperty, lat);
        EasternFreewayIndividual.setPropertyValue(longitudeProperty,lon);
        EasternFreewayIndividual.setPropertyValue(altitudeProperty,alt);
        EasternFreewayIndividual.setPropertyValue(timestampProperty,timestamp);
        EasternFreewayIndividual.setPropertyValue(speedProperty,fSpeed);
        
        j++;

        System.out.println("\n");
        tempIndividualName="EasternFreeWayContext_";
        }
        }
          finally {
        input.close();
      }
    }
    catch (IOException ex){
      ex.printStackTrace();
    }


    

            //InsertNewIndividual(owlModel);    
            
            //InsertNewIndividual ( owlModel, "city","cityName","Ulanbato","Capital of Mongolia");
            //InsertNewIndividual ( owlModel, "city","cityName","Paris","Capital of light");
            
            //InsertNewIndividual ( owlModel, "city","cityName","CanTho","West Capital of Vietnam");
            
            //InsertNewIndividual ( owlModel, "country","countryName","France","Republic of France");
            
            //InsertNewIndividual ( owlModel, "country","countryName","Mongolia","Republic of Mongolia");


            String fileName = "d:\\temp\\comorea\\NewComorea.owl";
            Collection errors = new ArrayList();
            owlModel.save(new File(fileName).toURI(), FileUtils.langXMLAbbrev, errors);
            System.out.println("File saved with " + errors.size() + " errors.");
    
        
                        
        } catch (Exception ex) {
            Logger.getLogger(LocationAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       }catch(Exception e){
       }
        
    }
    private static void printItems(Collection colllection, String strItemType) {
        Iterator i = colllection.iterator();
        int icount=0;
        while (i.hasNext()) {
            System.out.println(strItemType+ icount+": " + i.next());
            icount++;
        }
        
    }


    private static void InsertNewLocationIndividual (JenaOWLModel owlModel,
                                             String className, //Location
                                             long   timestamp,
                                             
                                             String strName,
                                             String strBelongToPlace,
                                             String strLat,
                                             String strLon,
                                             String strAlt,
                                             float strSpeed
                                             )
     //1246060329|265,83.99946594238281,-37.779801666666664,145.08594833333333,41.279998779296875
    {
        
    }
    private static void InsertNewIndividual (JenaOWLModel owlModel, 
                                             String className,
                                             String strPropertyName,
                                             String strIndividualName,
                                             String strComment
                                             ) 
    {
         
    OWLNamedClass classNamedClass = owlModel.getOWLNamedClass(className);
    
    Collection classList = new ArrayList();     
    classList = owlModel.getInstances(classNamedClass);
    //printItems(classList, "City ");    
    OWLDatatypeProperty cityNameProperty = 
                        owlModel.getOWLDatatypeProperty(strPropertyName);    
    RDFIndividual newIndividual = classNamedClass.createRDFIndividual(strIndividualName); 
    newIndividual.setComment(strComment);
     
    }

}
