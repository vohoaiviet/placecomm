/*
 *  Tuan Anh Nguyen.  Email: t.nguyen@latrobe.edu.au
 * Computer Science & Computer Engineering Department
 * La Trobe University, VIC, 3086
 */

package au.edu.latrobe.placecomm.agents;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tuan Nguyen
 */
public class GPSsimulatorAgent extends Agent {

    private ThreadedBehaviourFactory tbf = new ThreadedBehaviourFactory();
    private String destAgentName="gps";
    private String strToSend="GPSProtocol:asdf,adfasdf,asdfasdfasdf,asdfasdf";
    private int    iDelayTime=100;

    protected void setup() {
        // Printout a welcome message
        System.out.println("Hello World. I'm an agent!");
        System.out.println("My local-name is "+getAID().getLocalName());
        System.out.println("My GUID is "+getAID().getName());
        System.out.println("My addresses are:");
        Iterator it = getAID().getAllAddresses();


            // Parse param
            // This agent will receive 3 params: destinationAgentName, FileText to Send, delay_SleepTime
            Object[] args = getArguments();

            if (args != null) {
            try {
                int iNumparams = args.length;
                for (int i = 0; i < iNumparams; i++) {
                    System.out.println("Agrs[" + i + "]: " + args[i].toString());
                }
                Thread.sleep(6000);
            } catch (InterruptedException ex) {
                Logger.getLogger(GPSsimulatorAgent.class.getName()).log(Level.SEVERE, null, ex);
            }
            }


        Behaviour b = new CyclicBehaviour(this) {
                public void action() {
                    System.out.println("Action!");
                try {
                    ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
                    //AID dest = new AID(destAgentName, AID.ISLOCALNAME);
                    String destAgentNameGlobalID="gps@cs-at6nguyen:1099/JADE";

                    //AID aid = new AID("da0", AID.ISLOCALNAME)
                    //AID aid = new AID("da0@sharon.cselt.it:1099/JADE", AID.ISGUID).


                    //AID dest = new AID("gps@131.172.40.173:1099/JADE", AID.ISGUID); // not work!
                    //AID dest = new AID("gps@cs-at6nguyen.cs.latrobe.edu.au:1099/JADE", AID.ISGUID); // not work!
                    //AID dest = new AID("gps@localhost:1099/JADE", AID.ISGUID); // not work!
                    AID dest = new AID("gps@cs-at6nguyen:1099/JADE", AID.ISGUID); // WORKS !!!


                    msg.addReceiver(dest);

                       Date d = new Date();

                    String strtemp="";
                    for (int i = 0; i < 100; i++) {
                        strtemp=strToSend + ","+d.getTime()+","+d.toString();
                        msg.setContent(strtemp);
                        System.out.println("Sending: "+strtemp);
                        send(msg);
                        Thread.sleep(iDelayTime);
                    }
                    
                } catch (InterruptedException ex) {
                    Logger.getLogger(GPSsimulatorAgent.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
            }; //End Behaviour b
          addBehaviour(tbf.wrap(b));
       
    }

}
