/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ontology;




import com.hp.hpl.jena.db.*;
import com.hp.hpl.jena.iri.IRI;
import com.hp.hpl.jena.ontology.*;
import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.util.*;
import edu.stanford.smi.protege.exception.OntologyLoadException;
import edu.stanford.smi.protege.model.Project;
import edu.stanford.smi.protegex.owl.ProtegeOWL;
import edu.stanford.smi.protegex.owl.database.creator.OwlDatabaseCreator;
import edu.stanford.smi.protegex.owl.jena.JenaKnowledgeBaseFactory;
import edu.stanford.smi.protegex.owl.jena.JenaOWLModel;
import edu.stanford.smi.protegex.owl.model.OWLModel;
import edu.stanford.smi.protegex.owl.model.OWLOntology;
import edu.stanford.smi.protegex.owl.model.query.QueryResults;

import java.util.*;
import java.util.logging.*;
import org.semanticweb.owl.model.OWLOntologyCreationException;
import org.semanticweb.owl.model.OWLOntologyManager;
import org.semanticweb.owl.model.OWLOntologyStorageException;
import uk.ac.manchester.cs.owl.OWLDataFactoryImpl;


/**
 *
 * @author ATuan
 */
public class WorkingWithMySQL {

    /**
     * @param args the command line arguments
     */
    public static void listClasses( ModelMaker maker, String modelID ) {
        try {
            // use the model maker to get the base model as a persistent model
            // strict=false, so we get an existing model by that name if it exists
            // or create a new one
            Model base = maker.createModel(modelID, false);
            // create an ontology model using the persistent model as base
            OntModel m = ModelFactory.createOntologyModel(getModelSpec(maker), base);

            JenaOWLModel owlModel = ProtegeOWL.createJenaOWLModel();
            
            for (Iterator i = m.listClasses(); i.hasNext();) {
                OntClass c = (OntClass) i.next();
                System.out.println("Class " + c.getURI());
            }
        } catch (OntologyLoadException ex) {
            Logger.getLogger(WorkingWithMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static OntModelSpec getModelSpec( ModelMaker maker ) {
        // create a spec for the new ont model that will use no inference over models
        // made by the given maker (which is where we get the persistent models from)
        OntModelSpec spec = new OntModelSpec( OntModelSpec.OWL_MEM );
        spec.setImportModelMaker( maker );

        return spec;
    }

public static void main(String[] args)throws OWLOntologyCreationException, OWLOntologyStorageException  {

        try {
            String className = "com.mysql.jdbc.Driver";
            Class.forName(className);
            String DB_URL = "jdbc:mysql://localhost/ESWC"; // URL of database
            String DB_USER = "pbvc"; // database user id

            String DB_PASSWD = "merdecitd"; // database password
            String DB = "MySQL"; // database type
          
            Collection errors = new ArrayList();

            Project prj = Project.loadProjectFromFile("D://1Working//Ontology-MySQL//eswc.pprj",errors);
            OWLModel owlModel = (OWLModel) prj.getKnowledgeBase();
            System.out.println(errors.toString());

            try {
                  //String sQuery="SELECT ?subject ?object WHERE { ?subject rdfs:subClassOf ?object }";
                  String sQuery="SELECT ?subject  WHERE { ?subject rdf:type :OrganizedEvent}";
                  QueryResults results = owlModel.executeSPARQLQuery(sQuery);
                  String sResult="";

                  while (results.hasNext()) {
                    sResult=results.next().toString();
                    
                    System.out.println(sResult);
                    //Logger.getLogger(WorkingWithMySQL.class.getName()).log(Level.INFO, sResult, "Who knows?");
                    
                  }
            
             } catch (OntologyLoadException e) {
                  e.printStackTrace();
             } catch (Exception ex) {
                    Logger.getLogger(WorkingWithMySQL.class.getName()).log(Level.SEVERE, null, ex);
             }
 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WorkingWithMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
