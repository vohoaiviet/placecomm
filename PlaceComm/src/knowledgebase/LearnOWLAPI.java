/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package knowledgebase;

import com.hp.hpl.jena.util.FileUtils;
import edu.stanford.smi.protege.exception.OntologyLoadException;
import edu.stanford.smi.protegex.owl.ProtegeOWL;
import edu.stanford.smi.protegex.owl.jena.JenaOWLModel;
import edu.stanford.smi.protegex.owl.model.OWLDatatypeProperty;
import edu.stanford.smi.protegex.owl.model.OWLIndividual;
import edu.stanford.smi.protegex.owl.model.OWLModel;
import edu.stanford.smi.protegex.owl.model.OWLNamedClass;
import edu.stanford.smi.protegex.owl.model.OWLObjectProperty;
import edu.stanford.smi.protegex.owl.model.RDFIndividual;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tuannguyen
 */
public class LearnOWLAPI {

   public static void main(String[] args) {
        try {
            JenaOWLModel owlModel = ProtegeOWL.createJenaOWLModel();
            //OWLModel owlModel = ProtegeOWL.createJenaOWLModel();
            OWLNamedClass personClass = owlModel.createOWLNamedClass("Person");
            OWLDatatypeProperty ageProperty = owlModel.createOWLDatatypeProperty("age");
            ageProperty.setRange(owlModel.getXSDint());
            ageProperty.setDomain(personClass);
            OWLObjectProperty childrenProperty = owlModel.createOWLObjectProperty("children");
            childrenProperty.setRange(personClass);
            childrenProperty.setDomain(personClass);
            RDFIndividual darwin = personClass.createRDFIndividual("Darwin");
            darwin.setPropertyValue(ageProperty, new Integer(0));
            RDFIndividual holgi = personClass.createRDFIndividual("Holger");
            holgi.setPropertyValue(childrenProperty, darwin);
            holgi.setPropertyValue(ageProperty, new Integer(33));
            System.out.print("Program runs ok ");
            String fileName = ".\\person.owl";
            Collection errors = new ArrayList();
            owlModel.save(new File(fileName).toURI(), FileUtils.langXMLAbbrev, errors);
            System.out.println("File saved with " + errors.size() + " errors.");
        } catch (OntologyLoadException ex) {
            Logger.getLogger(LearnOWLAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
