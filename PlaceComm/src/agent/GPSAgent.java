/*
 *  Tuan Anh Nguyen.  Email: t.nguyen@latrobe.edu.au
 * Computer Science & Computer Engineering Department
 * La Trobe University, VIC, 3086
 */

package agent;
import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import java.util.Enumeration;
import java.util.Iterator;
import java.io.*;

import java.util.logging.*;

/**
 *
 * @author Tuan Nguyen
 */
public class GPSAgent extends Agent {

    private ThreadedBehaviourFactory tbf = new ThreadedBehaviourFactory();

    protected void setup() {
        // Printout a welcome message
        System.out.println("Hello World. I'm a GPS Agent agent!\n" +
                "I will receive GPS data from my fellows on the road\n" +
                "then pass to KB");
        System.out.println("My local-name is "+getAID().getLocalName());
        System.out.println("My GUID is "+getAID().getName());
        System.out.println("My addresses are:");
        Iterator it = getAID().getAllAddresses();

        // Get agent parameters
            Object[] args = getArguments();
            String s;
            if (args != null) {
                for (int i = 0; i<args.length; i++) {
                    s = (String) args[i];
                    System.out.println("p" + i + ": " + s);
                }
                 // Extracting the integer.
                 //int i = Integer.parseInt( (String) args[0] );
                 //System.out.println("i*i= " + i*i);
            }
        while (it.hasNext()) {
              System.out.println("- "+it.next());
        }
        

            Behaviour b = new OneShotBehaviour(this) {
                public void action() {
                    // Do something !
                }
            }; //End Behaviour b
            addBehaviour(tbf.wrap(b));

            
            addBehaviour(new CyclicBehaviour(this) {
                public void action() {

                    ACLMessage msg = myAgent.receive();
                    if (msg != null) {
                        String sMessage =msg.getContent();
                        //GPS:agentname,timestamp,lat,lon,alt,speed;
                        //GPSProtocol:alibaba,412431234,34.65634345345,145.6545646,110.45,89.991
                        if (sMessage.contains("GPSProtocol:")){
                            FileOutputStream out; // declare a file output object
                            PrintStream p; // declare a print stream object
                            try{
                                out = new FileOutputStream("d:\\temp\\GPSLoggtoFile.csv",true);// true for append, else reset and write
                                //out = new FileOutputStream("//tmp//GPSLoggtoFile.csv",true);

                                // Connect print stream to the output stream
                                p = new PrintStream( out );
                                p.println (sMessage);
                                System.out.println("Message received: "+sMessage);
                                //p.println ("Inet Address: "+socket.getInetAddress().toString());
                                p.close();
                                
                            }catch(Exception e){
                               Logger.getLogger(GPSAgent.class.getName()).log(Level.SEVERE, null, e);
                            }
                        }

                    }else {
                        block();
                    }
                }
            });


          // takeDown(); // Take down the agent
    }

}
