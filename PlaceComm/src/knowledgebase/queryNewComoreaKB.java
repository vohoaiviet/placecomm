/*
 *  Tuan Anh Nguyen.  Email: t.nguyen@latrobe.edu.au
 * Computer Science & Computer Engineering Department
 * La Trobe University, VIC, 3086
 */

package knowledgebase;
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
import edu.stanford.smi.protegex.owl.model.query.QueryResults;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.xerces.parsers.SAXParser;

/**
 *
 * @author Tuan Nguyen
 */
public class queryNewComoreaKB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     try {
        
        String sURI   = args[0].toString(); // this returns the KnoledgeBase URI
        String keyword = args[1].toString(); // this returns the Keyword to find
        
        /*String arg3 = args[2].toString(); // this returns the String "This is argument 3"
        String arg4 = args[3].toString(); // this returns the String "This is argument 3"
         */
        System.out.println("Hello World");
        

        
        
        try {
            

            String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";

            Calendar cal = Calendar.getInstance();
            //SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
            //System.out.println(sdf.format(cal.getTime()));
            System.out.println(cal.getTimeInMillis());
            long start=cal.getTimeInMillis();


            //FileReader owlFile = new FileReader("d:\\temp\\comorea\\newcomorea.owl");
            FileReader owlFile = new FileReader(sURI);
            JenaOWLModel owlModel  = ProtegeOWL.createJenaOWLModelFromReader(owlFile);
                   
                     String query=
                            "prefix sam:<http://www.tuannguyen.mobi/ontologies/2010/comorea.owl#> " +
                            "select ?speed " +
                            "where { " +
                            "  ?subject rdf:type sam:Location; " +
                            "              sam:belongToPlace ?place; " +
                            "              sam:speed  ?speed; " +
                            "              sam:timestamp ?timestamp. " +
                            " FILTER   " +
                            "               (regex(str(?place),\""+keyword+"\")) }";
                   
                    //String query=" select * where { ?a ?b ?c}";
                    
                    QueryResults results = owlModel.executeSPARQLQuery(query);

                   

            while (results.hasNext()) {
                System.out.println(results.next().toString());
            }
             //sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
             //System.out.println(sdf.format(cal.getTime()));
                    Calendar cal2 = Calendar.getInstance();
                    long stop=cal2.getTimeInMillis();
                    long dur = stop - start;
                    System.out.println("Stop:"+cal.getTimeInMillis());
                    System.out.println("Duration: "+ dur);

            

        } catch (Exception ex) {
            Logger.getLogger(OWLAPIDemoApplication.class.getName()).log(Level.SEVERE, null, ex);
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




}
