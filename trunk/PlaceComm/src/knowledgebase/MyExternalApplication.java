/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package knowledgebase;

/**
 *
 * @author tuannguyen
 */
import java.util.*;
import javax.swing.*;
import edu.stanford.smi.protege.model.*;

public class MyExternalApplication {

    private static String projectFileName = "c:\\temp\\newspaper.pprj";
    private static String instanceName = "in";

    public static void main(String[] args) {
        Collection errors = new ArrayList();
	Project project = new Project(projectFileName, errors);
        

	if (errors.isEmpty()) {

	    // show an instance in a top level frame
	    project.show(instanceName);

            // create a panel that contains and instance form and display it in my top level frame
	    Instance instance = project.getKnowledgeBase().getInstance(instanceName);
	    JComponent panel = (JComponent) project.createRuntimeClsWidget(instance);
	    JFrame frame = new JFrame("My Application Frame");
	    frame.getContentPane().add(panel);
	    frame.pack();
	    frame.show();

	} else {
	    System.out.println("There were load errors");
	}
    }
}
