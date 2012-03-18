/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package knowledgebase;

/**
 *
 * @author tuannguyen
 */
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
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.xerces.parsers.SAXParser;
//import pbvc.ontology.*;

public class CreateLocationInstances {

    
    public static void main(String[] args) {

    try {
        JenaOWLModel owlModel = ProtegeOWL.createJenaOWLModel();


        //OWLModel owlModel = ProtegeOWL.createJenaOWLModel();
        // OWLKnowledgeBase is a old API of OWLModel
        owlModel.getNamespaceManager().setDefaultNamespace("http://www.tuannguyen.mobi/ontologies/pbvc#");
        OWLNamedClass worldClass = owlModel.createOWLNamedClass("World");
        System.out.println("Class URI: " + worldClass.getURI());
        
        
        
        String uri = "http://www.tuannguyen.mobi/ontologies/pbvc/placeNew.owl";
        try {
            // It works !
            //owlModel = ProtegeOWL.createJenaOWLModelFromURI(uri);

            // Now I try with the MySQL repository



            System.out.println("Load Model successful");
            Collection instances = new ArrayList();
            instances = owlModel.getRDFResources();
            //printItems(instances, "insntaces ");       
            
            Collection classes = new ArrayList();
            classes = owlModel.getUserDefinedOWLNamedClasses();
            printItems(classes, "UserDefined Class ");                   

            Collection individual = new ArrayList();
            individual= owlModel.getRDFIndividuals();
            //printItems(individual, "individual ");       
            //InsertNewIndividual(owlModel);    
            
            InsertNewIndividual ( owlModel, "city","cityName","Ulanbato",
                                "Capital of Mongolia");
            InsertNewIndividual ( owlModel, "city","cityName","Paris",
                                "Capital of light");
            
            InsertNewIndividual ( owlModel, "city","cityName","CanTho",
                                "West Capital of Vietnam");
            
            InsertNewIndividual ( owlModel, "country","countryName","France",
                                "Republic of France");
            
            InsertNewIndividual ( owlModel, "country","countryName","Mongolia",
                                "Republic of Mongolia");                                              
            
            String fileName = ".\\NewPlaceNew.owl";
            Collection errors = new ArrayList();
            owlModel.save(new File(fileName).toURI(), FileUtils.langXMLAbbrev, errors);
            System.out.println("File saved with " + errors.size() + " errors.");

        
                        
        } catch (Exception ex) {
            Logger.getLogger(CreateLocationInstances.class.getName()).log(Level.SEVERE, null, ex);
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
