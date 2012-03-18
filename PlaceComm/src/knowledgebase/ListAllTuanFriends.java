/*
 *  Tuan Anh Nguyen.  Email: t.nguyen@latrobe.edu.au
 * Computer Science & Computer Engineering Department
 * La Trobe University, VIC, 3086
 */

package knowledgebase;

import edu.stanford.smi.protegex.owl.*;
import edu.stanford.smi.protegex.owl.model.*;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.*;

/**
 *
 * @author Tuan Nguyen
 */
public class ListAllTuanFriends {

    public static void main(String[] args) throws Exception {

        //String uri = "http://www.tuannguyen.mobi/ontologies/pbvc/2009/4/foaf.owl";
        try{
        //String uri = "file:///d:\\1Working\\OntologyOWLFile\\pbvc.owl";
        String uri = "file:///d:/1Working/OntologyOWLFile/foaf.owl";
        //OWLModel owlModel = ProtegeOWL.createJenaOWLModelFromURI(uri);
            OWLModel owlModel = ProtegeOWL.createJenaOWLModelFromURI(uri);
        OWLNamedClass destinationClass = owlModel.getOWLNamedClass("Person");


        ListPanel listPanel = new ListPanel(destinationClass);
        JFrame frame = new JFrame("Simple List Example");
        Container cont = frame.getContentPane();
        cont.setLayout(new BorderLayout());
        cont.add(BorderLayout.CENTER, listPanel);

        frame.setBounds(100, 100, 300, 300);
        frame.setVisible(true);
        }catch(Exception e){
            System.out.println("Ontology not found");
        }
    }
}
