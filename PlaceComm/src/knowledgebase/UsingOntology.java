/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package knowledgebase.usingOntology;
import edu.stanford.smi.protege.model.KnowledgeBaseSourcesEditor;
import edu.stanford.smi.protegex.owl.ProtegeOWL;
import edu.stanford.smi.protegex.owl.ProtegeOWL;
import edu.stanford.smi.protegex.owl.jena.JenaOWLModel;
import edu.stanford.smi.protegex.owl.model.OWLModel;
import edu.stanford.smi.protegex.owl.model.OWLNamedClass;
import edu.stanford.smi.protegex.owl.repository.*;
import java.util.logging.Level;
import java.util.logging.Logger;

//import knowledgebase.ontologies.place.OWLPlaceFactory;


/**
 *
 * @author tuannguyen
 */
public class UsingOntology {

    public static void OWLAPIDemo() {
    try{
        OWLModel owlModel = ProtegeOWL.createJenaOWLModel();
        owlModel.getNamespaceManager().setDefaultNamespace("http://hello.com#");
        OWLNamedClass worldClass = owlModel.createOWLNamedClass("World");
        System.out.println("Class URI: " + worldClass.getURI());
        } catch (Exception ex) {
            Logger.getLogger(UsingOntology.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void OWLAPIDemoFromURI() {
        String uri = "http://www.tuannguyen.mobi/ontologies/pbvc/placeNew.owl";
         JenaOWLModel owlModel;                  
        try {
            owlModel = ProtegeOWL.createJenaOWLModelFromURI(uri);            
            
            
        } catch (Exception ex) {
            Logger.getLogger(UsingOntology.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
     public static void main(String[] args) {
         
         OWLAPIDemo();
         
         OWLAPIDemoFromURI();
         
         
         
     }
}
