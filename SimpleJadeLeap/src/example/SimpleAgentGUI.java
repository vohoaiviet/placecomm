/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package example;

import jade.core.AID;
import jade.core.Agent;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
/**
 *
 * @author Tuan Nguyen
 */

public class SimpleAgentGUI implements SimpleAgentGUIInterface, CommandListener {

    private SimpleAgent myAgent;
    private boolean midletPaused = false;

    
    private Form form;
    private TextField SendingMessage;
    private StringItem ReceivedMessage;
    private TextField Receiver;
    private TextField AgentInfo;
    private Command SendCmd;
    private Command exitCommand;
    
    private Display display ;
    private AID aSender;
    

    SimpleAgentGUI (SimpleAgent mAgent){
        this.myAgent = mAgent;
        
        SendingMessage = new TextField("Sending message", null, 1024, TextField.ANY);
        AgentInfo = new TextField("Agent\'s information", null, 1024, TextField.ANY);
        Receiver = new TextField("Receiver", null, 32, TextField.ANY);
        SendingMessage = new TextField("Sending message", null, 1024, TextField.ANY);
        ReceivedMessage = new StringItem("Received message", null);
        
        form = new Form("Hello Simple Agent", new Item[] { getAgentInfo(), getReceiver(), getSendingMessage(), getReceivedMessage() });
            form.addCommand(getSendCmd());
            form.addCommand(getExitCommand());
            form.setCommandListener(this);
        ///////////////


        display=Display.getDisplay(Agent.midlet);
        System.out.println("From here 3");
        Display.getDisplay(Agent.midlet).setCurrent(form);
        System.out.println("From here 4");
        

    }
    
    public void dispose() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
     


   // private void initialize() { }

    public void startMIDlet() {
        // write pre-action user code here
        switchDisplayable(null, getForm());
        // write post-action user code here
    }

    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {
        // write pre-action user code here

        // write post-action user code here
    }

    /**
     * Switches a current displayable in a display. The <code>display</code> instance is taken from <code>getDisplay</code> method. This method is used by all actions in the design for switching displayable.
     * @param alert the Alert which is temporarily set to the display; if <code>null</code>, then <code>nextDisplayable</code> is set immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {
        // write pre-switch user code here
        Display display = getDisplay();
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }
        // write post-switch user code here
    }

    /**
     * Called by a system to indicated that a command has been invoked on a particular displayable.
     * @param command the Command that was invoked
     * @param displayable the Displayable where the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {
        // write pre-action user code here
        if (displayable == form) {
            if (command == SendCmd) {
                // write pre-action user code here
                System.out.println("Send clicked");
                    //void sendMsg(String sAgentLocalName, String sMsgContent) ;
                String sReceiverAgentName=Receiver.getString();
                myAgent.sendMsg(sReceiverAgentName,
                        SendingMessage.getString());
                // write post-action user code here
            } else if (command == exitCommand) {
                // write pre-action user code here
                exitMIDlet();
                // write post-action user code here
            }
        }
        // write post-action user code here
    }

    /**
     * Returns an initiliazed instance of form component.
     * @return the initialized component instance
     */
    public Form getForm() {
        if (form == null) {
            // write pre-init user code here
            form = new Form("Hello Simple Agent", new Item[] { getAgentInfo(), getReceiver(), getSendingMessage(), getReceivedMessage() });
            form.addCommand(getSendCmd());
            form.addCommand(getExitCommand());            
            form.setCommandListener(this);
            // write post-init user code here
        }
        return form;
    }

    /**
     * Returns an initiliazed instance of SendingMessage component.
     * @return the initialized component instance
     */
    public TextField getSendingMessage() {
        if (SendingMessage == null) {
            // write pre-init user code here
            SendingMessage = new TextField("Sending message", null, 1024, TextField.ANY);
            // write post-init user code here
        }
        return SendingMessage;
    }

    /**
     * Returns an initiliazed instance of ReceivedMessage component.
     * @return the initialized component instance
     */
    public StringItem getReceivedMessage() {
        if (ReceivedMessage == null) {
            // write pre-init user code here
            ReceivedMessage = new StringItem("Received message", null);
            // write post-init user code here
        }
        return ReceivedMessage;
    }

    /**
     * Returns an initiliazed instance of Receiver component.
     * @return the initialized component instance
     */
    public TextField getReceiver() {
        if (Receiver == null) {
            // write pre-init user code here
            Receiver = new TextField("Receiver", null, 32, TextField.ANY);
            // write post-init user code here
        }
        return Receiver;
    }

    /**
     * Returns an initiliazed instance of SendCmd component.
     * @return the initialized component instance
     */
    public Command getSendCmd() {
        if (SendCmd == null) {
            // write pre-init user code here
            SendCmd = new Command("Send", Command.ITEM, 0);
            // write post-init user code here
        }
        return SendCmd;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand ">
    /**
     * Returns an initiliazed instance of exitCommand component.
     * @return the initialized component instance
     */
    public Command getExitCommand() {
        if (exitCommand == null) {
            // write pre-init user code here
            exitCommand = new Command("Exit", Command.EXIT, 0);
            // write post-init user code here
        }
        return exitCommand;
    }


    /**
     * Returns an initiliazed instance of AgentInfo component.
     * @return the initialized component instance
     */
    public TextField getAgentInfo() {
        if (AgentInfo == null) {
            // write pre-init user code here
            AgentInfo = new TextField("Agent\'s information", null, 1024, TextField.ANY);
            // write post-init user code here
        }
        return AgentInfo;
    }
    //</editor-fold>

    /**
     * Returns a display instance.
     * @return the display instance.
     */
    public Display getDisplay () {
        return Display.getDisplay(Agent.midlet);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {
        switchDisplayable (null, null);
        destroyApp(true);
        notifyDestroyed();
    }

    /**
     * Called when MIDlet is started.
     * Checks whether the MIDlet have been already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp() {
        if (midletPaused) {
            resumeMIDlet ();
        } else {
            //initialize ();
            startMIDlet ();
        }
        midletPaused = false;
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
        midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     * @param unconditional if true, then the MIDlet has to be unconditionally terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
    }

    private void notifyDestroyed() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void getAgentInformation(String sAgentFullName, String sAgentLocalName) {
        AgentInfo.setString(sAgentFullName);
    }

    public void sendReply(String sMsgContent) {

    }

    public void updateMessage(String sSenderName, String sMsgContent) {

        Receiver.setString(sSenderName);
        ReceivedMessage.setText(sMsgContent);
        

    }
 

}
