/*
 * SensorIbuttonAgent.java
 *
 * Created on 3 September 2007, 10:38
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package agent;
import com.dalsemi.onewire.OneWireAccessProvider;
import com.dalsemi.onewire.adapter.DSPortAdapter;
import com.dalsemi.onewire.container.OneWireContainer;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.*;

import jade.lang.acl.ACLMessage;
import java.util.Enumeration;
import java.util.Iterator;
import utilities.ibuttonUsername;

/**
 *
 * @author at6nguyen
 */
public class SensorIbuttonAgent extends Agent {
    private ThreadedBehaviourFactory tbf = new ThreadedBehaviourFactory();
    public static final int DEFAULT_PORT = 5555;
    public static boolean DEBUG = true;

    private ACLMessage spokenMsg;

    public static final String CLASSNAME = "SensorIbuttonAgent";
    
    
    /** Creates a new instance of SensorIbuttonAgent */
    public SensorIbuttonAgent() {

    }

   /** This method is for getting username according to their
    * iButtons ID. The users database is stored in the localusers.xml file.
    * @param strID is an ibutton ID read by sensor.
    *
    */

    public void ListeningForButtons() {

      OneWireContainer owd;
      String strExitButton="80000002FE639D14";
      String strButtonIDAddress="";
      
      boolean stop = false;
    
      try
      {
         // get the default adapter  
         DSPortAdapter adapter = OneWireAccessProvider.getDefaultAdapter();
         System.out.println();
         System.out.println("Adapter: " + adapter.getAdapterName()
                            + " Port: " + adapter.getPortName());
         
         // get exclusive use of adapter
         adapter.beginExclusive(true);
         String strAddress1="";
         
       while (! stop ){
        try{
         // clear any previous search restrictions
         adapter.setSearchAllDevices();
         adapter.targetAllFamilies();
         //adapter.setSpeed(adapter.SPEED_REGULAR);
         adapter.setSpeed(DSPortAdapter.SPEED_REGULAR);
         // enumerate through all the 1-Wire devices found
         for (Enumeration owd_enum = adapter.getAllDeviceContainers();
                 owd_enum.hasMoreElements(); )
         { 
            owd = ( OneWireContainer ) owd_enum.nextElement();
            strButtonIDAddress=owd.getAddressAsString();            
            if (strAddress1.equals(strButtonIDAddress)) {
                // means that this is the second time so DO NOTHING
            } else {
                System.out.println("Button is Docked, ID:" + strButtonIDAddress);
                strAddress1=strButtonIDAddress;
                String strUsername="";
                try{
                    ibuttonUsername parseUsername = new ibuttonUsername();

                strUsername= parseUsername.IDtoUserXMLParser(strButtonIDAddress);
                        
                        //uButtonUsername.IDtoUserXMLParser(strButtonIDAddress);
                }catch (Exception e) {
                    System.out.println("Error parsing username: "+e);
                }
                String messagePasstoMobileAgent="IBUTTON:"+ strUsername;
                System.out.println(messagePasstoMobileAgent);
                // Send message to agent na
                
                String strTestAgent= "terminator@192.168.192.1:1099/JADE";
                spokenMsg = new ACLMessage(ACLMessage.INFORM);
                spokenMsg.setConversationId("PBVC");
                spokenMsg.clearAllReceiver();
                spokenMsg.addReceiver(new AID(strTestAgent,AID.ISGUID));
                spokenMsg.setContent(messagePasstoMobileAgent);
                send(spokenMsg);
                
                System.out.write(7); System.out.flush(); // Play a beep sound 
            }
            // If the black iButton is docked, exit program
            if (strButtonIDAddress.equals(strExitButton)){                
                stop=true;
                System.out.println("Agent will be terminated !");
                
                break;                
            }         
         }// end for
        }catch(Exception e){
            System.out.println(e);
        }
        }// end while 
         // end exclusive use of adapter
         adapter.endExclusive();
 
         // free port used by adapter
         adapter.freePort();
      }
      catch (Exception e)
      {
         System.out.println(e);
      }
    }
    
    protected void setup() {
    // Printout a welcome message
    System.out.println("Hello World. I'm an agent!");
    System.out.println("My local-name is "+getAID().getLocalName());
    System.out.println("My GUID is "+getAID().getName());
    System.out.println("My addresses are:");
      Iterator it = getAID().getAllAddresses();
        while (it.hasNext()) {
          System.out.println("- "+it.next());
        }
      
        Behaviour b = new OneShotBehaviour(this) {
        public void action() {
            // Do something !
            ListeningForButtons();
        }
      };
      addBehaviour(tbf.wrap(b)); 
    }
 
}
