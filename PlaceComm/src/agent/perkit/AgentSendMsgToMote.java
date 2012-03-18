/*
 *  Tuan Anh Nguyen.  Email: t.nguyen@latrobe.edu.au
 * Computer Science & Computer Engineering Department
 * La Trobe University, VIC, 3086
 */

package agent.perkit;
import jade.core.Agent;
import jade.core.behaviours.*;
import java.util.Iterator;

import com.sentilla.io.*;
import com.sentilla.system.*;
import com.sentilla.net.Sender;
import com.sentilla.net.SenderDriver;
import com.sentilla.host.client.HostClient;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tuan Nguyen
 */
public class AgentSendMsgToMote extends Agent {

    private ThreadedBehaviourFactory tbf = new ThreadedBehaviourFactory();

    public void SendMessageToMote() throws Exception {
        // Create a host environment that virtualizes communication with the mote.
		HostClient host = new HostClient();

		if (host.connect()) {
         System.out.println("Connect to Host Gateway (USB) successful");

		// Instantiate the messages
		MoteDisplayRadioCount.CountMsg count_msg = new MoteDisplayRadioCount.CountMsg();

		// Create a sender to the local broadcast address (immediate neighbors)
		Sender sender = SenderDriver.create("local");

		// Set the count to 0 when we start
		int cnt = 0;

		// Count to 10 and send a message for each count
		while (cnt < 256) {

			try {
				System.out.println("Sending the count of " + cnt);

				// Apply the current count to the count message.
				count_msg.count = (byte) cnt;

				// Send the message.
				sender.send(count_msg);
			} catch (Exception e) {
				System.err.println("Could not send a CountMsg.");
				e.printStackTrace();
			}

			// Increment the counter
			cnt++;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
        }else {
            System.out.println("Connect to Host Gateway (USB) FAILED");
        }
		
		System.exit(0);
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
                try {
                    SendMessageToMote();
                } catch (Exception ex) {
                    Logger.getLogger(AgentSendMsgToMote.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
            }; //End Behaviour b

          addBehaviour(tbf.wrap(b));
          // takeDown(); // Take down the agent
    }

}
