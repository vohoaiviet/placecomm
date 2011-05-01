/*
 *  Tuan Anh Nguyen.  Email: t.nguyen@latrobe.edu.au
 * Computer Science & Computer Engineering Department
 * La Trobe University, VIC, 3086
 */

package au.edu.latrobe.placecomm.agents;
import jade.core.Agent;

import jade.core.behaviours.*;

import jade.core.AgentContainer;
import jade.wrapper.AgentController;


import java.util.Enumeration;
import java.util.Iterator;



import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Tuan Nguyen
 */
public class AgentForkAgent extends Agent {

    private ThreadedBehaviourFactory tbf = new ThreadedBehaviourFactory();

    protected void setup() {
        // Printout a welcome message
        System.out.println("Hello World. I'm an agent!");
        System.out.println("My local-name is "+getAID().getLocalName());
        System.out.println("My GUID is "+getAID().getName());
        System.out.println("My addresses are:");
        Iterator it = getAID().getAllAddresses();


        // Parse param
            Object[] args = getArguments();
            String s;
            if (args != null) {
                for (int i = 0; i<args.length; i++) {
                    s = (String) args[i];
                    System.out.println("p" + i + ": " + s);
                }
            }

        System.out.println("Call mp3 agent:-) ");
               String name = "Victor" ;
                jade.wrapper.AgentContainer c = getContainerController();
                try {
                    String[] param={"a","b","c","d"};
                    args=param;
                    
                    AgentController a = c.createNewAgent( name, "agent.PlayMp3Agent", args);


                    a.start();
                }
                catch (Exception e){
                     System.out.println("Create agent failed");
                     Logger.getLogger(AgentForkAgent.class.getName()).log(Level.SEVERE, null, e);
                }


               System.out.println("Open Link Agent ");
               name = "AlibabaVictor" ;
                c = getContainerController();
                try {
                    String[] param={"1","2","3","4"};
                    args=param;

                    AgentController a = c.createNewAgent( name, "agent.OpenLinkAgent", args);


                    a.start();
                }
                catch (Exception e){
                     System.out.println("Create agent failed");
                     Logger.getLogger(AgentForkAgent.class.getName()).log(Level.SEVERE, null, e);
                }


            /*Behaviour b = new OneShotBehaviour(this) {
            public void action() {
               
            }
            }; //End Behaviour b
            
          addBehaviour(tbf.wrap(b));
          */
          // takeDown(); // Take down the agent
    }

}
