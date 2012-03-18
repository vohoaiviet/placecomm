//package backend;

import java.util.*;
import javax.swing.*;
import edu.stanford.smi.protege.model.*;
import edu.stanford.smi.protege.storage.clips.*;
import edu.stanford.smi.protegex.storage.rdf.configurable.*;

/*
 * Sample code for programmatically creating, populating, and saving a new
 * project with either the default (CLIPS) or the RDF backend.
 */
public class BackendNewProjectExample {

    public static void main(String[] args) {
        Project p = createNewClipsProject();
        // Project p = createNewRdfProject();
        populateProject(p);
        saveProject(p);
    }

    private static Project createNewClipsProject() {
        Collection errors = new ArrayList();
        ClipsKnowledgeBaseFactory factory = new ClipsKnowledgeBaseFactory();
        Project project = Project.createNewProject(factory, errors);
        handleErrors(errors);

        /* Set the necessary file names. Note that this doesn't really have to
         * be done until we do a save. Nevertheless, it is probably a good
         * idea to do it here unless we just need a temporary project that is
         * never going to get saved.
         */
        project.setProjectFilePath("c:\\temp\\backendtest_clips.pprj");

        return project;
    }

    private static Project createNewRdfProject() {
        Collection errors = new ArrayList();
        RDFCBackend factory = new RDFCBackend();
        Project project = Project.createNewProject(factory, errors);
        handleErrors(errors);

        /* Set the necessary file names. Note that this doesn't really have to
         * be done until we do a save. Nevertheless, it is probably a good
         * idea to do it here unless we just need a temporary project that is
         * never going to get saved. The advantage of doing it here is that we
         * have to know which factory to use in order to call the
         * "setSourceFiles" method. At project creation time we already have
         * the appropriate factory present. More effort is required here than
         * for the clips backend because:
         *
         * (1) the RDF backend doesn't assume the project name as a base path
         *     for its files
         * (2) we need to specify a namespace.
         */
        String baseName = "backendtest_rdf";
		// arbitrary string
        String myNamespace = "http://protege.stanford.edu/backendtest";

        project.setProjectFilePath("c:\\temp\\" + baseName + ".pprj");
        factory.setSourceFiles(project.getSources(), baseName + ".rdfs",
                               baseName + ".rdf", myNamespace);

        return project;
    }

    private static void populateProject(Project p) {
        KnowledgeBase kb = p.getKnowledgeBase();
        // create a subclass of :THING
        Cls clsA = kb.createCls("Foo", kb.getRootClses());
        // create a subclass of clsA
        Cls clsASub = kb.createCls("FooSub", Collections.singleton(clsA));


	Cls clsTuan = kb.createCls("Tuan", kb.getRootClses());
	Cls clsTuanCon = kb.createCls("TuanCon", Collections.singleton(clsTuan));


        // add a multivalued slot to clsA
        Slot multiSlot = kb.createSlot("multiSlot");
        multiSlot.setValueType(ValueType.STRING);
        multiSlot.setAllowsMultipleValues(true);
        clsA.addDirectTemplateSlot(multiSlot);

        // add a singlevalued slot to clsA
        Slot singleSlot = kb.createSlot("singleSlot");
        singleSlot.setValueType(ValueType.STRING);
        singleSlot.setAllowsMultipleValues(false);
        clsA.addDirectTemplateSlot(singleSlot);

        // create instance of clsASub
        Instance instance = kb.createInstance(null, clsASub);

        // set a multi-valued slot value
        Collection values = new ArrayList();
        values.add("value1");
        values.add("value2");
        instance.setOwnSlotValues(multiSlot, values);

        // set a single-values slot value
        instance.setOwnSlotValue(singleSlot, "value3");
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
}
