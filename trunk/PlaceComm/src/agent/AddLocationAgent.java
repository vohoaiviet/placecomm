/*
 *  Tuan Anh Nguyen.  Email: t.nguyen@latrobe.edu.au
 * Computer Science & Computer Engineering Department
 * La Trobe University, VIC, 3086
 */

package agent;
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
import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.xerces.parsers.SAXParser;


import jade.core.Agent;
import jade.core.behaviours.*;
import java.util.Enumeration;
import java.util.Iterator;

/**
 *
 * @author Tuan Nguyen
 */
public class AddLocationAgent extends Agent {

    private ThreadedBehaviourFactory tbf = new ThreadedBehaviourFactory();
    JenaOWLModel owlModel = null;
    public String owlModelUri;
    public String datafile ;
    public String outModel ;
    public String sPlaceCI;

    private static void printItems(Collection colllection, String strItemType) {
                Iterator i = colllection.iterator();
                int icount=0;
                while (i.hasNext()) {
                    System.out.println(strItemType+ icount+": " + i.next());
                    icount++;
                }
    }

    protected void setup() {
        // Printout a welcome message
        System.out.println("Hello World. I'm an agent!");
        System.out.println("My local-name is "+getAID().getLocalName());
        System.out.println("My GUID is "+getAID().getName());
        System.out.println("My addresses are:");
        Iterator it = getAID().getAllAddresses();

        Object[] args = getArguments();
        String arg1 = args[0].toString(); // this returns the String "1"
        String arg2 = args[1].toString(); // this returns the String "arg2"
        String arg3 = args[2].toString(); // this returns the String "This is argument 3"
        String arg4 = args[3].toString(); // this returns the String "This is argument 4"
        // java jade.Boot agentName:agent.argumentsAgent(arg1,arg2,arg3)
        // arg1= owlModelUri, datafile, outModel

        owlModelUri=arg1;
        datafile   =arg2;
        outModel   =arg3;
        sPlaceCI   =arg4;

        System.out.println("arg1 "+arg1);
        System.out.println("arg2 "+arg2);
        System.out.println("arg3 "+arg3);
        System.out.println("arg4 "+arg4);

        while (it.hasNext()) {
              System.out.println("- "+it.next());
        }

            Behaviour b = new OneShotBehaviour(this) {
                public void action() {
                    // Do something !
                    try{
                        CreateInstantce ();
                    }catch (Exception e){}
                }
            }; //End Behaviour b

          addBehaviour(tbf.wrap(b));
          // takeDown(); // Take down the agent
    }
          public void CreateInstantce (){
              //String uri = "http://www.tuannguyen.mobi/ontologies/2010/comorea.owl";
              String uri = owlModelUri;

              try {
                  owlModel = ProtegeOWL.createJenaOWLModelFromURI(uri);
                  OWLNamedClass PlaceClass=owlModel.getOWLNamedClass("Place");
                  OWLNamedClass LocationClass=owlModel.getOWLNamedClass("Location");

                  OWLObjectProperty belongToPlace = owlModel.getOWLObjectProperty("belongToPlace");
                  OWLObjectProperty submittedBy = owlModel.getOWLObjectProperty("submittedBy");
                  OWLDatatypeProperty latitudeProperty = owlModel.getOWLDatatypeProperty("latitude");
                  OWLDatatypeProperty longitudeProperty = owlModel.getOWLDatatypeProperty("longitude");
                  OWLDatatypeProperty altitudeProperty = owlModel.getOWLDatatypeProperty("altitude");
                  OWLDatatypeProperty timestampProperty = owlModel.getOWLDatatypeProperty("timestamp");
                  OWLDatatypeProperty previousTimestampProperty = owlModel.getOWLDatatypeProperty("previousTimestamp");
                  OWLDatatypeProperty speedProperty = owlModel.getOWLDatatypeProperty("speed");
                  OWLDatatypeProperty nameProperty = owlModel.getOWLDatatypeProperty("name");
                  RDFIndividual EasternFreewayClass  = PlaceClass.createOWLIndividual(sPlaceCI);

                    //File file= EasternFreeway.csv
                    // line="1246060329265,83.99946594238281,-37.779801666666664,145.08594833333333,41.279998779296875"
                    String tempIndividualName=sPlaceCI+"_";
                    int iCount = 10;
                    //String filename="d:\\temp\\comorea\\comorea0-500.csv";

                    String filename=datafile;

                    //String filename="d:\\temp\\comorea\\comorea0-1000.csv";
                    //String filename="d:\\temp\\comorea\\comorea-5000-10000.csv";
                    //String filename="d:\\temp\\comorea\\comorea-10000-15000.csv";
                    //String filename="d:\\temp\\comorea\\comorea-15000-21000.csv";
                    Calendar cal = Calendar.getInstance();
                    System.out.println("Start reading at: "+cal.getTimeInMillis());
                    long start=cal.getTimeInMillis();

                    try {
                      BufferedReader input =  new BufferedReader(new FileReader(filename));
                      try {
                        String line = null; //not declared within while loop
                        int j=0;
                        while (( line = input.readLine()) != null){
                            String words[]=line.split(",");
                            String timestamp=words[0];
                            String speed=words[1];
                            String lat=words[2];
                            String lon=words[3];
                            String alt=words[4];
                            float fSpeed = Float.valueOf(speed);
                            tempIndividualName=tempIndividualName.concat(String.valueOf(j));
                            System.out.println("Saving item ["+j+"] "+tempIndividualName);
                            RDFIndividual EasternFreewayIndividual = LocationClass.createRDFIndividual(tempIndividualName);
                            EasternFreewayIndividual.setPropertyValue(belongToPlace, EasternFreewayClass);
                            EasternFreewayIndividual.setPropertyValue(latitudeProperty, lat);
                            EasternFreewayIndividual.setPropertyValue(longitudeProperty,lon);
                            EasternFreewayIndividual.setPropertyValue(altitudeProperty,alt);
                            EasternFreewayIndividual.setPropertyValue(timestampProperty,timestamp);
                            EasternFreewayIndividual.setPropertyValue(speedProperty,fSpeed);
                            j++;
                            tempIndividualName=sPlaceCI+"_";
                        }
                      }
                      finally {
                        input.close();
                      }
                    }
                    catch (IOException ex){
                        Calendar cal4 = Calendar.getInstance();
                        System.out.println("Errot at: "+ cal4);
                        ex.printStackTrace();

                    }
                    Calendar cal2 = Calendar.getInstance();
                    long stop=cal2.getTimeInMillis();
                    long dur = stop - start;
                    System.out.println("Finish insert to KB:"+stop);
                    System.out.println("Duration: "+ dur);

                    // Saving model

                    //String fileName = "d:\\temp\\comorea\\NewComorea.owl";
                    String fileName =  outModel ;
                    Collection errors = new ArrayList();
                    owlModel.save(new File(fileName).toURI(), FileUtils.langXMLAbbrev, errors);
                    System.out.println("File saved with " + errors.size() + " errors.");
                    Calendar cal3 = Calendar.getInstance();
                    long saveDone=cal3.getTimeInMillis();
                    long saveTime = saveDone - stop ;
                    System.out.println("Saving Done: "+ saveTime);



                } catch (Exception ex) {
                    Logger.getLogger(LocationAgent.class.getName()).log(Level.SEVERE, null, ex);
                    Calendar saveTime = Calendar.getInstance();
                    System.out.println("Saving Error at: "+ saveTime.getTime());
                }
    }

}
