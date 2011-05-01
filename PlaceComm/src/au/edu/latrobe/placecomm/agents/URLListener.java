/*
 *  Tuan Anh Nguyen.  Email: t.nguyen@latrobe.edu.au
 * Computer Science & Computer Engineering Department
 * La Trobe University, VIC, 3086
 */

package au.edu.latrobe.placecomm.agents;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Tuan Nguyen
 */
class URLListener extends CyclicBehaviour{
    private String myURL="";
    private OpenLinkAgent myAgent;
    public URLListener(OpenLinkAgent ParentAgent) {
        myURL=ParentAgent.strURL;

    }
    
    @Override
    public void action() {
        ACLMessage msg = myAgent.receive();
        if (msg != null) {
            String sContent=msg.getContent();
            System.out.println("Message received: "+sContent);

                String cmdline = "ff.bat "+myURL;
                Runtime rt = Runtime.getRuntime();
                try {
                    Process pr = rt.exec(cmdline);
                } catch (Exception ex) {
                  Logger.getLogger(URLListener.class.getName()).log(Level.SEVERE, null, ex);
                }

        }else {
            block();
        }
    }


}
