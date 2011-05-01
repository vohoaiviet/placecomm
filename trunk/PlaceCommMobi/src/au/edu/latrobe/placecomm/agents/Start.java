/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package au.edu.latrobe.placecomm.agents;

import jade.*;
import jade.core.MicroRuntime;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 * @author ATuan
 */

public class Start extends MicroBootLight implements MobileUserAgentGUIInterface, CommandListener {

    private boolean midletPaused = false;

    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Form LoginForm;
    private TextField textField;
    private TextField UserAgentNameTF;
    private Command CreateAgentandJoin;
    private Command exitCommand;
    private Command okCommand;
    private Command backCommand;
    private Command OfflineMode;
    private Command PlaceSense;
    private Command PlaceAware;
    private Command SemanticPlaceBrowser;
    private Command backCommand2;
    private Command backCommand1;
    private Command backCommand3;
    private Command okCommand1;
    private Command CreateContainer;
    //</editor-fold>//GEN-END:|fields|0|

    /**
     * The MobileUserAgentGUI constructor.
     */
    public Start() {
    }

    //<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
    //</editor-fold>//GEN-END:|methods|0|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
    /**
     * Initilizes the application.
     * It is called only once when the MIDlet is started. The method is called before the <code>startMIDlet</code> method.
     */
    private void initialize() {//GEN-END:|0-initialize|0|0-preInitialize
        // write pre-initialize user code here
//GEN-LINE:|0-initialize|1|0-postInitialize
        // write post-initialize user code here
    }//GEN-BEGIN:|0-initialize|2|
    //</editor-fold>//GEN-END:|0-initialize|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here
        switchDisplayable(null, getLoginForm());//GEN-LINE:|3-startMIDlet|1|3-postAction
        // write post-action user code here
    }//GEN-BEGIN:|3-startMIDlet|2|
    //</editor-fold>//GEN-END:|3-startMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
    }//GEN-BEGIN:|4-resumeMIDlet|2|
    //</editor-fold>//GEN-END:|4-resumeMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
    /**
     * Switches a current displayable in a display. The <code>display</code> instance is taken from <code>getDisplay</code> method. This method is used by all actions in the design for switching displayable.
     * @param alert the Alert which is temporarily set to the display; if <code>null</code>, then <code>nextDisplayable</code> is set immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here

        Display display = getDisplay();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }//GEN-END:|5-switchDisplayable|1|5-postSwitch
        // write post-switch user code here
    }//GEN-BEGIN:|5-switchDisplayable|2|
    //</editor-fold>//GEN-END:|5-switchDisplayable|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Displayables ">//GEN-BEGIN:|7-commandAction|0|7-preCommandAction
    /**
     * Called by a system to indicated that a command has been invoked on a particular displayable.
     * @param command the Command that was invoked
     * @param displayable the Displayable where the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {//GEN-END:|7-commandAction|0|7-preCommandAction
        // write pre-action user code here
        if (displayable == LoginForm) {//GEN-BEGIN:|7-commandAction|1|65-preAction
            if (command == CreateAgentandJoin) {//GEN-END:|7-commandAction|1|65-preAction
                // write pre-action user code here
                String name = UserAgentNameTF.getString();
                String strAgentClassName="au.edu.latrobe.placecomm.agents.MobileUserAgent";
                try {
                    MicroRuntime.startAgent(name,strAgentClassName, null);
                    // write post-action user code here
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
//GEN-LINE:|7-commandAction|2|65-postAction
                // write post-action user code here
            } else if (command == CreateContainer) {//GEN-LINE:|7-commandAction|3|63-preAction
                // write pre-action user code here

                Thread t = new Thread() {
                    public void run() {
                        myStartGoOnline();
                    }
                };
                t.start();

//GEN-LINE:|7-commandAction|4|63-postAction
                // write post-action user code here
            } else if (command == OfflineMode) {//GEN-LINE:|7-commandAction|5|28-preAction
                // write pre-action user code here
//GEN-LINE:|7-commandAction|6|28-postAction
                // write post-action user code here
            } else if (command == exitCommand) {//GEN-LINE:|7-commandAction|7|17-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|8|17-postAction
                // write post-action user code here
            } else if (command == okCommand) {//GEN-LINE:|7-commandAction|9|20-preAction
                // write pre-action user code here
//GEN-LINE:|7-commandAction|10|20-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|11|7-postCommandAction
        }//GEN-END:|7-commandAction|11|7-postCommandAction
        // write post-action user code here
    }//GEN-BEGIN:|7-commandAction|12|
    //</editor-fold>//GEN-END:|7-commandAction|12|

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: LoginForm ">//GEN-BEGIN:|14-getter|0|14-preInit
    /**
     * Returns an initiliazed instance of LoginForm component.
     * @return the initialized component instance
     */
    public Form getLoginForm() {
        if (LoginForm == null) {//GEN-END:|14-getter|0|14-preInit
            // write pre-init user code here
            LoginForm = new Form("Login Screen", new Item[] { getUserAgentNameTF(), getTextField() });//GEN-BEGIN:|14-getter|1|14-postInit
            LoginForm.addCommand(getExitCommand());
            LoginForm.addCommand(getOkCommand());
            LoginForm.addCommand(getOfflineMode());
            LoginForm.addCommand(getCreateContainer());
            LoginForm.addCommand(getCreateAgentandJoin());
            LoginForm.setCommandListener(this);//GEN-END:|14-getter|1|14-postInit
            // write post-init user code here
        }//GEN-BEGIN:|14-getter|2|
        return LoginForm;
    }
    //</editor-fold>//GEN-END:|14-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand ">//GEN-BEGIN:|16-getter|0|16-preInit
    /**
     * Returns an initiliazed instance of exitCommand component.
     * @return the initialized component instance
     */
    public Command getExitCommand() {
        if (exitCommand == null) {//GEN-END:|16-getter|0|16-preInit
            // write pre-init user code here
            exitCommand = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|16-getter|1|16-postInit
            // write post-init user code here
        }//GEN-BEGIN:|16-getter|2|
        return exitCommand;
    }
    //</editor-fold>//GEN-END:|16-getter|2|



























    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand ">//GEN-BEGIN:|19-getter|0|19-preInit
    /**
     * Returns an initiliazed instance of okCommand component.
     * @return the initialized component instance
     */
    public Command getOkCommand() {
        if (okCommand == null) {//GEN-END:|19-getter|0|19-preInit
            // write pre-init user code here
            okCommand = new Command("Ok", Command.OK, 0);//GEN-LINE:|19-getter|1|19-postInit
            // write post-init user code here
        }//GEN-BEGIN:|19-getter|2|
        return okCommand;
    }
    //</editor-fold>//GEN-END:|19-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand ">//GEN-BEGIN:|23-getter|0|23-preInit
    /**
     * Returns an initiliazed instance of backCommand component.
     * @return the initialized component instance
     */
    public Command getBackCommand() {
        if (backCommand == null) {//GEN-END:|23-getter|0|23-preInit
            // write pre-init user code here
            backCommand = new Command("Back", Command.BACK, 0);//GEN-LINE:|23-getter|1|23-postInit
            // write post-init user code here
        }//GEN-BEGIN:|23-getter|2|
        return backCommand;
    }
    //</editor-fold>//GEN-END:|23-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: OfflineMode ">//GEN-BEGIN:|27-getter|0|27-preInit
    /**
     * Returns an initiliazed instance of OfflineMode component.
     * @return the initialized component instance
     */
    public Command getOfflineMode() {
        if (OfflineMode == null) {//GEN-END:|27-getter|0|27-preInit
            // write pre-init user code here
            OfflineMode = new Command("Offline Mode", Command.ITEM, 0);//GEN-LINE:|27-getter|1|27-postInit
            // write post-init user code here
        }//GEN-BEGIN:|27-getter|2|
        return OfflineMode;
    }
    //</editor-fold>//GEN-END:|27-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: PlaceAware ">//GEN-BEGIN:|36-getter|0|36-preInit
    /**
     * Returns an initiliazed instance of PlaceAware component.
     * @return the initialized component instance
     */
    public Command getPlaceAware() {
        if (PlaceAware == null) {//GEN-END:|36-getter|0|36-preInit
            // write pre-init user code here
            PlaceAware = new Command("Item", Command.ITEM, 0);//GEN-LINE:|36-getter|1|36-postInit
            // write post-init user code here
        }//GEN-BEGIN:|36-getter|2|
        return PlaceAware;
    }
    //</editor-fold>//GEN-END:|36-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: PlaceSense ">//GEN-BEGIN:|38-getter|0|38-preInit
    /**
     * Returns an initiliazed instance of PlaceSense component.
     * @return the initialized component instance
     */
    public Command getPlaceSense() {
        if (PlaceSense == null) {//GEN-END:|38-getter|0|38-preInit
            // write pre-init user code here
            PlaceSense = new Command("Item", Command.ITEM, 0);//GEN-LINE:|38-getter|1|38-postInit
            // write post-init user code here
        }//GEN-BEGIN:|38-getter|2|
        return PlaceSense;
    }
    //</editor-fold>//GEN-END:|38-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: SemanticPlaceBrowser ">//GEN-BEGIN:|40-getter|0|40-preInit
    /**
     * Returns an initiliazed instance of SemanticPlaceBrowser component.
     * @return the initialized component instance
     */
    public Command getSemanticPlaceBrowser() {
        if (SemanticPlaceBrowser == null) {//GEN-END:|40-getter|0|40-preInit
            // write pre-init user code here
            SemanticPlaceBrowser = new Command("Item", Command.ITEM, 0);//GEN-LINE:|40-getter|1|40-postInit
            // write post-init user code here
        }//GEN-BEGIN:|40-getter|2|
        return SemanticPlaceBrowser;
    }
    //</editor-fold>//GEN-END:|40-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand1 ">//GEN-BEGIN:|45-getter|0|45-preInit
    /**
     * Returns an initiliazed instance of backCommand1 component.
     * @return the initialized component instance
     */
    public Command getBackCommand1() {
        if (backCommand1 == null) {//GEN-END:|45-getter|0|45-preInit
            // write pre-init user code here
            backCommand1 = new Command("Back", Command.BACK, 0);//GEN-LINE:|45-getter|1|45-postInit
            // write post-init user code here
        }//GEN-BEGIN:|45-getter|2|
        return backCommand1;
    }
    //</editor-fold>//GEN-END:|45-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand2 ">//GEN-BEGIN:|47-getter|0|47-preInit
    /**
     * Returns an initiliazed instance of backCommand2 component.
     * @return the initialized component instance
     */
    public Command getBackCommand2() {
        if (backCommand2 == null) {//GEN-END:|47-getter|0|47-preInit
            // write pre-init user code here
            backCommand2 = new Command("Back", Command.BACK, 0);//GEN-LINE:|47-getter|1|47-postInit
            // write post-init user code here
        }//GEN-BEGIN:|47-getter|2|
        return backCommand2;
    }
    //</editor-fold>//GEN-END:|47-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand3 ">//GEN-BEGIN:|49-getter|0|49-preInit
    /**
     * Returns an initiliazed instance of backCommand3 component.
     * @return the initialized component instance
     */
    public Command getBackCommand3() {
        if (backCommand3 == null) {//GEN-END:|49-getter|0|49-preInit
            // write pre-init user code here
            backCommand3 = new Command("Back", Command.BACK, 0);//GEN-LINE:|49-getter|1|49-postInit
            // write post-init user code here
        }//GEN-BEGIN:|49-getter|2|
        return backCommand3;
    }
    //</editor-fold>//GEN-END:|49-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand1 ">//GEN-BEGIN:|58-getter|0|58-preInit
    /**
     * Returns an initiliazed instance of okCommand1 component.
     * @return the initialized component instance
     */
    public Command getOkCommand1() {
        if (okCommand1 == null) {//GEN-END:|58-getter|0|58-preInit
            // write pre-init user code here
            okCommand1 = new Command("Upload to KBAgent", Command.OK, 0);//GEN-LINE:|58-getter|1|58-postInit
            // write post-init user code here
        }//GEN-BEGIN:|58-getter|2|
        return okCommand1;
    }
    //</editor-fold>//GEN-END:|58-getter|2|
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: UserAgentNameTF ">//GEN-BEGIN:|61-getter|0|61-preInit
    /**
     * Returns an initiliazed instance of UserAgentNameTF component.
     * @return the initialized component instance
     */
    public TextField getUserAgentNameTF() {
        if (UserAgentNameTF == null) {//GEN-END:|61-getter|0|61-preInit
            // write pre-init user code here
            UserAgentNameTF = new TextField("User\'s agent name", null, 32, TextField.ANY);//GEN-LINE:|61-getter|1|61-postInit
            // write post-init user code here
        }//GEN-BEGIN:|61-getter|2|
        return UserAgentNameTF;
    }
    //</editor-fold>//GEN-END:|61-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: CreateContainer ">//GEN-BEGIN:|62-getter|0|62-preInit
    /**
     * Returns an initiliazed instance of CreateContainer component.
     * @return the initialized component instance
     */
    public Command getCreateContainer() {
        if (CreateContainer == null) {//GEN-END:|62-getter|0|62-preInit
            // write pre-init user code here
            CreateContainer = new Command("CreateContainer", Command.ITEM, 0);//GEN-LINE:|62-getter|1|62-postInit
            // write post-init user code here
        }//GEN-BEGIN:|62-getter|2|
        return CreateContainer;
    }
    //</editor-fold>//GEN-END:|62-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: CreateAgentandJoin ">//GEN-BEGIN:|64-getter|0|64-preInit
    /**
     * Returns an initiliazed instance of CreateAgentandJoin component.
     * @return the initialized component instance
     */
    public Command getCreateAgentandJoin() {
        if (CreateAgentandJoin == null) {//GEN-END:|64-getter|0|64-preInit
            // write pre-init user code here
            CreateAgentandJoin = new Command("Join Default Community", Command.ITEM, 0);//GEN-LINE:|64-getter|1|64-postInit
            // write post-init user code here
        }//GEN-BEGIN:|64-getter|2|
        return CreateAgentandJoin;
    }
    //</editor-fold>//GEN-END:|64-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField ">//GEN-BEGIN:|66-getter|0|66-preInit
    /**
     * Returns an initiliazed instance of textField component.
     * @return the initialized component instance
     */
    public TextField getTextField() {
        if (textField == null) {//GEN-END:|66-getter|0|66-preInit
            // write pre-init user code here
            textField = new TextField("Password", null, 32, TextField.ANY | TextField.PASSWORD);//GEN-LINE:|66-getter|1|66-postInit
            // write post-init user code here
        }//GEN-BEGIN:|66-getter|2|
        return textField;
    }
    //</editor-fold>//GEN-END:|66-getter|2|

    /**
     * Returns a display instance.
     * @return the display instance.
     */
    public Display getDisplay () {
        return Display.getDisplay(this);
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
            initialize ();
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

    public void myStartGoOnline(){
        try {
            super.startGoOnline("localhost");
        } catch (MIDletStateChangeException ex) {
            ex.printStackTrace();
        }
        System.out.print("Join  Agent Platform Done");
        
    }

    public void UpdateLocation(String sLat, String sLon, String sAlt, String sSpeed, String sTimestamp) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void UpdateBluetoothDiscovered(String sLat, String sLon, String sAlt,
                            String sMAC,String sFriendlyName,String sTimestamp,
                            String sCellBroadcast, String sSpeed,String sUserAgent,
                            boolean bCascadingInsertion){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String QueryKBbySPARQL(String sQuery) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String JoiningProtocol(String sAgentName, String sSend, String sReceive) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String AdvertisingProtocol(String sAgentName, String sSend, String sReceive) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String PositoiningProtocol(String sAgentName, String sSend, String sReceive) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String LeavingProtocol(String sAgentName, String sSend, String sReceive) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void dispose() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void updateStatus(String string) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void updateSparqlResults(String string) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
