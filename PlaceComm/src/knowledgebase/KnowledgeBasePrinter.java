/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package knowledgebase;
import java.io.*;
import java.util.*;
import edu.stanford.smi.protege.model.*;

/**
 *
 * @author tuannguyen
 */
public class KnowledgeBasePrinter {

     private static final String PROJECT_FILE_NAME = "c:\\temp\\myfoaf.pprj";

	public static void main(String[] args ){
    	Collection errors = new ArrayList();
	System.out.println("Hello World");
        Project project = new Project(PROJECT_FILE_NAME, errors);
        if (errors.size() == 0) {
        	KnowledgeBase kb = project.getKnowledgeBase();
            Iterator i = kb.getClses().iterator();
            while (i.hasNext()) {
            	Cls cls = (Cls) i.next();
                System.out.println("Class: " + cls.getName());
                Iterator j = cls.getDirectInstances().iterator();
                while (j.hasNext()) {
                	Instance instance = (Instance) j.next();
                    System.out.println("  Instance: " + instance.getName());
                }
            }
        } else {
			System.out.println("Error somewhere");
        	displayErrors(errors);
        }
        waitForContinue();
    }

    private static void displayErrors(Collection errors) {
    	Iterator i = errors.iterator();
        while (i.hasNext()) {
        	System.out.println("Error: " + i.next());
        }
    }

    private static void waitForContinue() {
		System.out.println("Press <Enter> to continue");
        try {
        	System.in.read();
       	} catch (Exception e) {}
    }
    
    
}
