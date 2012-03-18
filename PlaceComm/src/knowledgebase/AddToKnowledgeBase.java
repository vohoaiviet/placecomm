package knowledgebase; 

import java.util.*;
import javax.swing.*;
import edu.stanford.smi.protege.model.*;

import edu.stanford.smi.protege.storage.clips.*;
import edu.stanford.smi.protegex.storage.rdf.configurable.*;

/*
 * Sample code for programmatically creating, populating, and saving a new
 * project with either the default (CLIPS) or the RDF backend.
 */
public class AddToKnowledgeBase {

    public static void main(String[] args) {
        
        Project p = loadMyProject();
        //AddKnowledgeToProject(p);
        saveProject(p);
    }

    private static Project loadMyProject() {
        Collection errors = new ArrayList();
        RDFCBackend factory = new RDFCBackend();
        Project project = Project.loadProjectFromFile("c:\\temp\\myfoaf.pprj", errors);                
        //Project project = Project.loadProjectFromFile(fileName, errors);                
        
        KnowledgeBase knowledgeBase=project.getKnowledgeBase();
         
        /*
        Collection instances = new ArrayList();        
        instances =  knowledgeBase.getInstances();
        printItems(instances, "Instance ");
        */ 
        
        Collection classes = new ArrayList();
        classes = knowledgeBase.getClses();         
        printItems(classes, "Class ");              
        
        System.out.println("Number of Classes: "+knowledgeBase.getClsCount()); 
        
        Cls clsPerson = knowledgeBase.getCls("Person");
        Collection listPeople = new ArrayList();
        //insPerson = knowledgeBase.getInstances(clsPerson);
        //knowledgeBase.getInstance(fileName)
        
        String strName="xyz_Nguyen";
        System.out.println("Prepare to add "+strName+" as an instance");
        try{
        Instance ins_Person = knowledgeBase.getInstance("person");
        knowledgeBase.addInstance(ins_Person,strName,clsPerson,true);
        //knowledgeBase.addInstance(Instance ins,String str,Cls clsPerson,boolean isNew);        
        System.out.println("Add "+strName+" success");
        }catch (Exception e){
            System.out.println("Add "+ strName+" failed: "+e);
        }        
                
        listPeople = knowledgeBase.getInstances(clsPerson);
        printItems(listPeople, "Person : ");              
        
        handleErrors(errors);
        return project;
    }

    private static void AddKnowledgeToProject(Project p) {
        
        //KnowledgeBase loadProjectKB(URI uri,KnowledgeBaseFactory factory,Collection errors)
        
    }

    private static void saveProject(Project p) {
        Collection errors = new ArrayList();
        p.save(errors);
        handleErrors(errors);
    }

    private static void handleErrors(Collection errors) {
        Iterator i = errors.iterator();
        while (i.hasNext()) {
            System.out.println("Error: " + i.next());
        }
        if (!errors.isEmpty()) {
            System.exit(-1);
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
