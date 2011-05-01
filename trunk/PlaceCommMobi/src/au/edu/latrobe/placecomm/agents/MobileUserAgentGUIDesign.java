/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package au.edu.latrobe.placecomm.agents;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

import org.netbeans.microedition.util.SimpleCancellableTask;
import au.edu.latrobe.placecomm.agents.threads.*;
import java.util.Vector;
import javax.microedition.io.*;
import javax.wireless.messaging.*;
/**
 * @author ATuan
 */

public class MobileUserAgentGUIDesign extends MIDlet implements MobileUserAgentGUIInterface, CommandListener,MessageListener {

    private boolean midletPaused = false;
    private boolean bAllDone=false;
    public  BlueDiscoveryThread blueDiscoveryThread;
    public  BlueGpsThread blueGpsThread=null;
    public  String gpsGlobal="";
    private boolean bThreadStarted=false;
    private MessageConnection serverConn;
    private String msgReceived=null;
    private Vector vBlueDeviceFound;
    private boolean stopBlueDiscoveryThread=false;

    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Form LoginForm;
    private TextField PasswordTxtFld;
    private TextField UsernameTxtFld;
    private Form PBVCForm;
    private StringItem ReceivedMessageSI;
    private StringItem UserAndCommunitySI;
    private TextField MessageToSendTF;
    private ChoiceGroup BasicServicesGrp;
    private ChoiceGroup AdvancedServicesGrp;
    private ChoiceGroup OptionsGrp;
    private Form OfflineForm;
    private Form SemanticPlaceBrowserForm;
    private TextField textField;
    private StringItem stringItem;
    private Form PlaceAwareForm;
    private TextField LonTxtFld;
    private TextField LatTxtFld;
    private TextField SpeedTxtFld;
    private TextField AltTxtFld;
    private StringItem LocalBlueID;
    private Form PlaceSenseForm;
    private StringItem GSMCellBroadCastSI;
    private ChoiceGroup PlaceSenseBlueDevicesGrp;
    private ChoiceGroup CurrentPosGrp;
    private ChoiceGroup Options;
    private Form LogsForm;
    private StringItem LogsStringItem;
    private TextBox SparqlForm;
    private Form AirportPickupForm;
    private TextField DeviceMACTF;
    private TextField DeviceNameTF;
    private ChoiceGroup FindingDeviceGrp;
    private ChoiceGroup DiscoveredDeviceGrp;
    private List SparqlResult;
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
    private Command ManualUpdate;
    private Command AutoUpdateKB;
    private Command okCommand2;
    private Command backCommand4;
    private Command LogScreenCmd;
    private Command LogScreenCmd2;
    private Command LogScreenCmd1;
    private Command SPARQLcmd;
    private Command SubmitSparqlCmd;
    private Command backCommand5;
    private Command itemCommand1;
    private Command StartSensingCmd;
    private Command backCommand6;
    private Command AddDeviceCmd;
    private Command AirportPickupCmd;
    private Command ClearAllCmd;
    private Command backCommand7;
    private Command RemoveItemCmd;
    private Command GpsLoggingCmd;
    private Command StartFindingCmd;
    private Command clearLogScreenCmd;
    private Command ShowLogs;
    private Command StopSensingCmd;
    private Command CommunityContributeCmd;
    private Command ClearSPARQLResultCmd;
    private Command backCommand8;
    private Command SPARQLResult;
    private Command ClearScreen;
    private SimpleCancellableTask task;
    private Image MobiphoneImage;
    private Image SplashScreenImage;
    //</editor-fold>//GEN-END:|fields|0|

    /**
     * The MobileUserAgentGUI constructor.
     */
    public MobileUserAgentGUIDesign() {
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
        if (displayable == AirportPickupForm) {//GEN-BEGIN:|7-commandAction|1|128-preAction
            if (command == AddDeviceCmd) {//GEN-END:|7-commandAction|1|128-preAction
                // write pre-action user code here
                String sFindingDevice=DeviceNameTF.getString()+":"+DeviceMACTF.getString();
                FindingDeviceGrp.append(sFindingDevice, getMobiphoneImage());
//GEN-LINE:|7-commandAction|2|128-postAction
                // write post-action user code here
            } else if (command == ClearAllCmd) {//GEN-LINE:|7-commandAction|3|130-preAction
                // write pre-action user code here
                FindingDeviceGrp.deleteAll();
                DiscoveredDeviceGrp.deleteAll();
//GEN-LINE:|7-commandAction|4|130-postAction
                // write post-action user code here
            } else if (command == RemoveItemCmd) {//GEN-LINE:|7-commandAction|5|135-preAction
                // write pre-action user code here
                int i=FindingDeviceGrp.getSelectedIndex();
                FindingDeviceGrp.delete(i);
//GEN-LINE:|7-commandAction|6|135-postAction
                // write post-action user code here
            } else if (command == ShowLogs) {//GEN-LINE:|7-commandAction|7|151-preAction
                // write pre-action user code here
                switchDisplayable(null, getLogsForm());//GEN-LINE:|7-commandAction|8|151-postAction
                // write post-action user code here
            } else if (command == StartFindingCmd) {//GEN-LINE:|7-commandAction|9|146-preAction
                // write pre-action user code here
                /*
                 try{
                     blueDiscoveryThread = new BlueDiscoveryThread(this, true);
                     blueDiscoveryThread.start(); // Start  BlueDiscoveryThread
                     bThreadStarted=true;
                     LogsForm.append("Blue discovery sucess\n");
                    }catch(Exception e){
                        bThreadStarted=false;
                        LogsForm.append("Blue discovery FAILED:"+e.toString()+"\n");
                    }
                 *
                 */
//GEN-LINE:|7-commandAction|10|146-postAction
                // write post-action user code here
            } else if (command == backCommand7) {//GEN-LINE:|7-commandAction|11|132-preAction
                // write pre-action user code here
                switchDisplayable(null, getPlaceAwareForm());//GEN-LINE:|7-commandAction|12|132-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|13|84-preAction
        } else if (displayable == LoginForm) {
            if (command == LogScreenCmd) {//GEN-END:|7-commandAction|13|84-preAction
                // write pre-action user code here
//GEN-LINE:|7-commandAction|14|84-postAction
                // write post-action user code here
            } else if (command == OfflineMode) {//GEN-LINE:|7-commandAction|15|28-preAction
                // write pre-action user code here
                switchDisplayable(null, getOfflineForm());//GEN-LINE:|7-commandAction|16|28-postAction
                // write post-action user code here
            } else if (command == exitCommand) {//GEN-LINE:|7-commandAction|17|17-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|18|17-postAction
                // write post-action user code here
            } else if (command == okCommand) {//GEN-LINE:|7-commandAction|19|20-preAction
                // write pre-action user code here
                switchDisplayable(null, getPBVCForm());//GEN-LINE:|7-commandAction|20|20-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|21|113-preAction
        } else if (displayable == LogsForm) {
            if (command == backCommand6) {//GEN-END:|7-commandAction|21|113-preAction
                // write pre-action user code here
                switchDisplayable(null, getPBVCForm());//GEN-LINE:|7-commandAction|22|113-postAction
                // write post-action user code here
            } else if (command == clearLogScreenCmd) {//GEN-LINE:|7-commandAction|23|148-preAction
                // write pre-action user code here
//GEN-LINE:|7-commandAction|24|148-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|25|90-preAction
        } else if (displayable == PBVCForm) {
            if (command == LogScreenCmd1) {//GEN-END:|7-commandAction|25|90-preAction
                // write pre-action user code here
                switchDisplayable(null, getLogsForm());//GEN-LINE:|7-commandAction|26|90-postAction
                // write post-action user code here
            } else if (command == PlaceAware) {//GEN-LINE:|7-commandAction|27|37-preAction
                // write pre-action user code here
                switchDisplayable(null, getPlaceAwareForm());//GEN-LINE:|7-commandAction|28|37-postAction
                // write post-action user code here
            } else if (command == PlaceSense) {//GEN-LINE:|7-commandAction|29|39-preAction
                // write pre-action user code here
                switchDisplayable(null, getPlaceSenseForm());//GEN-LINE:|7-commandAction|30|39-postAction
                // write post-action user code here
            } else if (command == SemanticPlaceBrowser) {//GEN-LINE:|7-commandAction|31|41-preAction
                // write pre-action user code here
                switchDisplayable(null, getSemanticPlaceBrowserForm());//GEN-LINE:|7-commandAction|32|41-postAction
                // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|33|24-preAction
                // write pre-action user code here
                switchDisplayable(null, getLoginForm());//GEN-LINE:|7-commandAction|34|24-postAction
                // write post-action user code here
            } else if (command == okCommand2) {//GEN-LINE:|7-commandAction|35|76-preAction
                // write pre-action user code here
//GEN-LINE:|7-commandAction|36|76-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|37|124-preAction
        } else if (displayable == PlaceAwareForm) {
            if (command == AirportPickupCmd) {//GEN-END:|7-commandAction|37|124-preAction
                // write pre-action user code here
                switchDisplayable(null, getAirportPickupForm());//GEN-LINE:|7-commandAction|38|124-postAction
                // write post-action user code here
            } else if (command == AutoUpdateKB) {//GEN-LINE:|7-commandAction|39|80-preAction
                // write pre-action user code here
//GEN-LINE:|7-commandAction|40|80-postAction
                // write post-action user code here
            } else if (command == GpsLoggingCmd) {//GEN-LINE:|7-commandAction|41|154-preAction
                // write pre-action user code here
//GEN-LINE:|7-commandAction|42|154-postAction
                // write post-action user code here
            } else if (command == LogScreenCmd2) {//GEN-LINE:|7-commandAction|43|93-preAction
                // write pre-action user code here
                switchDisplayable(null, getLogsForm());//GEN-LINE:|7-commandAction|44|93-postAction
                // write post-action user code here
            } else if (command == ManualUpdate) {//GEN-LINE:|7-commandAction|45|78-preAction
                // write pre-action user code here

//GEN-LINE:|7-commandAction|46|78-postAction
                // write post-action user code here
            } else if (command == backCommand1) {//GEN-LINE:|7-commandAction|47|46-preAction
                // write pre-action user code here
                switchDisplayable(null, getPBVCForm());//GEN-LINE:|7-commandAction|48|46-postAction
                // write post-action user code here
            } else if (command == okCommand1) {//GEN-LINE:|7-commandAction|49|59-preAction
                // write pre-action user code here
//GEN-LINE:|7-commandAction|50|59-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|51|165-preAction
        } else if (displayable == PlaceSenseForm) {
            if (command == CommunityContributeCmd) {//GEN-END:|7-commandAction|51|165-preAction
                // write pre-action user code here

                // Cell Broadcast
                try
                {
                        serverConn = (MessageConnection)Connector.open("cbs://:050");
                        //Message msg = serverConn.receive();
                        Message msg = serverConn.receive();
                        if (msg instanceof TextMessage){
                        String data = "You are in: "+((TextMessage)msg).getPayloadText()+"\n";


                        }
                }
                catch (Exception ioExc)
                {
                        System.out.println("Server connection could not be obtained");
                        ioExc.printStackTrace();
                }


//GEN-LINE:|7-commandAction|52|165-postAction
                // write post-action user code here
            } else if (command == StartSensingCmd) {//GEN-LINE:|7-commandAction|53|117-preAction
                // write pre-action user code here
                //blueDiscoveryThread = new BlueDiscoveryThread(this);
                //blueDiscoveryThread.start();
//GEN-LINE:|7-commandAction|54|117-postAction
                // write post-action user code here
            } else if (command == StopSensingCmd) {//GEN-LINE:|7-commandAction|55|163-preAction
                // write pre-action user code here
                //blueDiscoveryThread.stopThread();
//GEN-LINE:|7-commandAction|56|163-postAction
                // write post-action user code here
            } else if (command == backCommand2) {//GEN-LINE:|7-commandAction|57|48-preAction
                // write pre-action user code here
                switchDisplayable(null, getPBVCForm());//GEN-LINE:|7-commandAction|58|48-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|59|103-preAction
        } else if (displayable == SemanticPlaceBrowserForm) {
            if (command == SPARQLcmd) {//GEN-END:|7-commandAction|59|103-preAction
                // write pre-action user code here
                switchDisplayable(null, getSparqlForm());//GEN-LINE:|7-commandAction|60|103-postAction
                // write post-action user code here
            } else if (command == backCommand3) {//GEN-LINE:|7-commandAction|61|50-preAction
                // write pre-action user code here
                switchDisplayable(null, getPBVCForm());//GEN-LINE:|7-commandAction|62|50-postAction
                // write post-action user code here
            } else if (command == itemCommand1) {//GEN-LINE:|7-commandAction|63|119-preAction
                // write pre-action user code here
                switchDisplayable(null, getLogsForm());//GEN-LINE:|7-commandAction|64|119-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|65|182-preAction
        } else if (displayable == SparqlForm) {
            if (command == ClearScreen) {//GEN-END:|7-commandAction|65|182-preAction
                // write pre-action user code here
//GEN-LINE:|7-commandAction|66|182-postAction
                // write post-action user code here
            } else if (command == SPARQLResult) {//GEN-LINE:|7-commandAction|67|184-preAction
                // write pre-action user code here
                switchDisplayable(null, getSparqlResult());//GEN-LINE:|7-commandAction|68|184-postAction
                // write post-action user code here
            } else if (command == SubmitSparqlCmd) {//GEN-LINE:|7-commandAction|69|110-preAction
                // write pre-action user code here
                switchDisplayable(null, getSparqlResult());//GEN-LINE:|7-commandAction|70|110-postAction
                // write post-action user code here
            } else if (command == backCommand5) {//GEN-LINE:|7-commandAction|71|107-preAction
                // write pre-action user code here
                switchDisplayable(null, getSemanticPlaceBrowserForm());//GEN-LINE:|7-commandAction|72|107-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|73|187-preAction
        } else if (displayable == SparqlResult) {
            if (command == ClearSPARQLResultCmd) {//GEN-END:|7-commandAction|73|187-preAction
                // write pre-action user code here
//GEN-LINE:|7-commandAction|74|187-postAction
                // write post-action user code here
            } else if (command == List.SELECT_COMMAND) {//GEN-LINE:|7-commandAction|75|172-preAction
                // write pre-action user code here
                SparqlResultAction();//GEN-LINE:|7-commandAction|76|172-postAction
                // write post-action user code here
            } else if (command == backCommand8) {//GEN-LINE:|7-commandAction|77|179-preAction
                // write pre-action user code here
                switchDisplayable(null, getSparqlForm());//GEN-LINE:|7-commandAction|78|179-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|79|7-postCommandAction
        }//GEN-END:|7-commandAction|79|7-postCommandAction
        // write post-action user code here
    }//GEN-BEGIN:|7-commandAction|80|
    //</editor-fold>//GEN-END:|7-commandAction|80|
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: LoginForm ">//GEN-BEGIN:|14-getter|0|14-preInit
    /**
     * Returns an initiliazed instance of LoginForm component.
     * @return the initialized component instance
     */
    public Form getLoginForm() {
        if (LoginForm == null) {//GEN-END:|14-getter|0|14-preInit
            // write pre-init user code here
            LoginForm = new Form("Login Screen", new Item[] { getUsernameTxtFld(), getPasswordTxtFld() });//GEN-BEGIN:|14-getter|1|14-postInit
            LoginForm.addCommand(getExitCommand());
            LoginForm.addCommand(getOkCommand());
            LoginForm.addCommand(getOfflineMode());
            LoginForm.addCommand(getLogScreenCmd());
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

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: PBVCForm ">//GEN-BEGIN:|21-getter|0|21-preInit
    /**
     * Returns an initiliazed instance of PBVCForm component.
     * @return the initialized component instance
     */
    public Form getPBVCForm() {
        if (PBVCForm == null) {//GEN-END:|21-getter|0|21-preInit
            // write pre-init user code here
            PBVCForm = new Form("Welcome to PBVC", new Item[] { getUserAndCommunitySI(), getReceivedMessageSI(), getMessageToSendTF(), getBasicServicesGrp(), getOptionsGrp(), getAdvancedServicesGrp() });//GEN-BEGIN:|21-getter|1|21-postInit
            PBVCForm.addCommand(getBackCommand());
            PBVCForm.addCommand(getPlaceAware());
            PBVCForm.addCommand(getPlaceSense());
            PBVCForm.addCommand(getSemanticPlaceBrowser());
            PBVCForm.addCommand(getOkCommand2());
            PBVCForm.addCommand(getLogScreenCmd1());
            PBVCForm.setCommandListener(this);//GEN-END:|21-getter|1|21-postInit
            // write post-init user code here
        }//GEN-BEGIN:|21-getter|2|
        return PBVCForm;
    }
    //</editor-fold>//GEN-END:|21-getter|2|
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: UserAndCommunitySI ">//GEN-BEGIN:|30-getter|0|30-preInit
    /**
     * Returns an initiliazed instance of UserAndCommunitySI component.
     * @return the initialized component instance
     */
    public StringItem getUserAndCommunitySI() {
        if (UserAndCommunitySI == null) {//GEN-END:|30-getter|0|30-preInit
            // write pre-init user code here
            UserAndCommunitySI = new StringItem("User@PBVC", null);//GEN-LINE:|30-getter|1|30-postInit
            // write post-init user code here
        }//GEN-BEGIN:|30-getter|2|
        return UserAndCommunitySI;
    }
    //</editor-fold>//GEN-END:|30-getter|2|
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ReceivedMessageSI ">//GEN-BEGIN:|31-getter|0|31-preInit
    /**
     * Returns an initiliazed instance of ReceivedMessageSI component.
     * @return the initialized component instance
     */
    public StringItem getReceivedMessageSI() {
        if (ReceivedMessageSI == null) {//GEN-END:|31-getter|0|31-preInit
            // write pre-init user code here
            ReceivedMessageSI = new StringItem("Receiving Message", null);//GEN-LINE:|31-getter|1|31-postInit
            // write post-init user code here
        }//GEN-BEGIN:|31-getter|2|
        return ReceivedMessageSI;
    }
    //</editor-fold>//GEN-END:|31-getter|2|
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: MessageToSendTF ">//GEN-BEGIN:|32-getter|0|32-preInit
    /**
     * Returns an initiliazed instance of MessageToSendTF component.
     * @return the initialized component instance
     */
    public TextField getMessageToSendTF() {
        if (MessageToSendTF == null) {//GEN-END:|32-getter|0|32-preInit
            // write pre-init user code here
            MessageToSendTF = new TextField("Message to Send", null, 32, TextField.ANY);//GEN-LINE:|32-getter|1|32-postInit
            // write post-init user code here
        }//GEN-BEGIN:|32-getter|2|
        return MessageToSendTF;
    }
    //</editor-fold>//GEN-END:|32-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: OfflineForm ">//GEN-BEGIN:|26-getter|0|26-preInit
    /**
     * Returns an initiliazed instance of OfflineForm component.
     * @return the initialized component instance
     */
    public Form getOfflineForm() {
        if (OfflineForm == null) {//GEN-END:|26-getter|0|26-preInit
            // write pre-init user code here
            OfflineForm = new Form("form1");//GEN-LINE:|26-getter|1|26-postInit
            // write post-init user code here
        }//GEN-BEGIN:|26-getter|2|
        return OfflineForm;
    }
    //</editor-fold>//GEN-END:|26-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: PlaceSenseForm ">//GEN-BEGIN:|33-getter|0|33-preInit
    /**
     * Returns an initiliazed instance of PlaceSenseForm component.
     * @return the initialized component instance
     */
    public Form getPlaceSenseForm() {
        if (PlaceSenseForm == null) {//GEN-END:|33-getter|0|33-preInit
            // write pre-init user code here
            PlaceSenseForm = new Form("PlaceSense", new Item[] { getGSMCellBroadCastSI(), getPlaceSenseBlueDevicesGrp(), getCurrentPosGrp(), getOptions() });//GEN-BEGIN:|33-getter|1|33-postInit
            PlaceSenseForm.addCommand(getBackCommand2());
            PlaceSenseForm.addCommand(getStartSensingCmd());
            PlaceSenseForm.addCommand(getStopSensingCmd());
            PlaceSenseForm.addCommand(getCommunityContributeCmd());
            PlaceSenseForm.setCommandListener(this);//GEN-END:|33-getter|1|33-postInit
            // write post-init user code here
        }//GEN-BEGIN:|33-getter|2|
        return PlaceSenseForm;
    }
    //</editor-fold>//GEN-END:|33-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: SemanticPlaceBrowserForm ">//GEN-BEGIN:|34-getter|0|34-preInit
    /**
     * Returns an initiliazed instance of SemanticPlaceBrowserForm component.
     * @return the initialized component instance
     */
    public Form getSemanticPlaceBrowserForm() {
        if (SemanticPlaceBrowserForm == null) {//GEN-END:|34-getter|0|34-preInit
            // write pre-init user code here
            SemanticPlaceBrowserForm = new Form("Semantic PlaceBrowser", new Item[] { getTextField(), getStringItem() });//GEN-BEGIN:|34-getter|1|34-postInit
            SemanticPlaceBrowserForm.addCommand(getBackCommand3());
            SemanticPlaceBrowserForm.addCommand(getSPARQLcmd());
            SemanticPlaceBrowserForm.addCommand(getItemCommand1());
            SemanticPlaceBrowserForm.setCommandListener(this);//GEN-END:|34-getter|1|34-postInit
            // write post-init user code here
        }//GEN-BEGIN:|34-getter|2|
        return SemanticPlaceBrowserForm;
    }
    //</editor-fold>//GEN-END:|34-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: PlaceAwareForm ">//GEN-BEGIN:|35-getter|0|35-preInit
    /**
     * Returns an initiliazed instance of PlaceAwareForm component.
     * @return the initialized component instance
     */
    public Form getPlaceAwareForm() {
        if (PlaceAwareForm == null) {//GEN-END:|35-getter|0|35-preInit
            // write pre-init user code here
            PlaceAwareForm = new Form("Place Aware", new Item[] { getLocalBlueID(), getLatTxtFld(), getLonTxtFld(), getAltTxtFld(), getSpeedTxtFld() });//GEN-BEGIN:|35-getter|1|35-postInit
            PlaceAwareForm.addCommand(getBackCommand1());
            PlaceAwareForm.addCommand(getOkCommand1());
            PlaceAwareForm.addCommand(getManualUpdate());
            PlaceAwareForm.addCommand(getAutoUpdateKB());
            PlaceAwareForm.addCommand(getLogScreenCmd2());
            PlaceAwareForm.addCommand(getAirportPickupCmd());
            PlaceAwareForm.addCommand(getGpsLoggingCmd());
            PlaceAwareForm.setCommandListener(this);//GEN-END:|35-getter|1|35-postInit
            // write post-init user code here
        }//GEN-BEGIN:|35-getter|2|
        return PlaceAwareForm;
    }
    //</editor-fold>//GEN-END:|35-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: LatTxtFld ">//GEN-BEGIN:|54-getter|0|54-preInit
    /**
     * Returns an initiliazed instance of LatTxtFld component.
     * @return the initialized component instance
     */
    public TextField getLatTxtFld() {
        if (LatTxtFld == null) {//GEN-END:|54-getter|0|54-preInit
            // write pre-init user code here
            LatTxtFld = new TextField("Latitude", "10.25", 32, TextField.ANY);//GEN-LINE:|54-getter|1|54-postInit
            // write post-init user code here
        }//GEN-BEGIN:|54-getter|2|
        return LatTxtFld;
    }
    //</editor-fold>//GEN-END:|54-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: LonTxtFld ">//GEN-BEGIN:|55-getter|0|55-preInit
    /**
     * Returns an initiliazed instance of LonTxtFld component.
     * @return the initialized component instance
     */
    public TextField getLonTxtFld() {
        if (LonTxtFld == null) {//GEN-END:|55-getter|0|55-preInit
            // write pre-init user code here
            LonTxtFld = new TextField("Longitude", "45.23", 32, TextField.ANY);//GEN-LINE:|55-getter|1|55-postInit
            // write post-init user code here
        }//GEN-BEGIN:|55-getter|2|
        return LonTxtFld;
    }
    //</editor-fold>//GEN-END:|55-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: AltTxtFld ">//GEN-BEGIN:|56-getter|0|56-preInit
    /**
     * Returns an initiliazed instance of AltTxtFld component.
     * @return the initialized component instance
     */
    public TextField getAltTxtFld() {
        if (AltTxtFld == null) {//GEN-END:|56-getter|0|56-preInit
            // write pre-init user code here
            AltTxtFld = new TextField("Altitude", "20", 32, TextField.ANY);//GEN-LINE:|56-getter|1|56-postInit
            // write post-init user code here
        }//GEN-BEGIN:|56-getter|2|
        return AltTxtFld;
    }
    //</editor-fold>//GEN-END:|56-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: SpeedTxtFld ">//GEN-BEGIN:|57-getter|0|57-preInit
    /**
     * Returns an initiliazed instance of SpeedTxtFld component.
     * @return the initialized component instance
     */
    public TextField getSpeedTxtFld() {
        if (SpeedTxtFld == null) {//GEN-END:|57-getter|0|57-preInit
            // write pre-init user code here
            SpeedTxtFld = new TextField("Speed (km/h)", "89", 32, TextField.ANY);//GEN-LINE:|57-getter|1|57-postInit
            // write post-init user code here
        }//GEN-BEGIN:|57-getter|2|
        return SpeedTxtFld;
    }
    //</editor-fold>//GEN-END:|57-getter|2|
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: LocalBlueID ">//GEN-BEGIN:|60-getter|0|60-preInit
    /**
     * Returns an initiliazed instance of LocalBlueID component.
     * @return the initialized component instance
     */
    public StringItem getLocalBlueID() {
        if (LocalBlueID == null) {//GEN-END:|60-getter|0|60-preInit
            // write pre-init user code here
            LocalBlueID = new StringItem("BluetoothID", "AABBCCDDEEFF");//GEN-LINE:|60-getter|1|60-postInit
            // write post-init user code here
        }//GEN-BEGIN:|60-getter|2|
        return LocalBlueID;
    }
    //</editor-fold>//GEN-END:|60-getter|2|

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
            OfflineMode = new Command("Item", Command.ITEM, 0);//GEN-LINE:|27-getter|1|27-postInit
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

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: UsernameTxtFld ">//GEN-BEGIN:|61-getter|0|61-preInit
    /**
     * Returns an initiliazed instance of UsernameTxtFld component.
     * @return the initialized component instance
     */
    public TextField getUsernameTxtFld() {
        if (UsernameTxtFld == null) {//GEN-END:|61-getter|0|61-preInit
            // write pre-init user code here
            UsernameTxtFld = new TextField("Username", null, 32, TextField.ANY);//GEN-LINE:|61-getter|1|61-postInit
            // write post-init user code here
        }//GEN-BEGIN:|61-getter|2|
        return UsernameTxtFld;
    }
    //</editor-fold>//GEN-END:|61-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: PasswordTxtFld ">//GEN-BEGIN:|62-getter|0|62-preInit
    /**
     * Returns an initiliazed instance of PasswordTxtFld component.
     * @return the initialized component instance
     */
    public TextField getPasswordTxtFld() {
        if (PasswordTxtFld == null) {//GEN-END:|62-getter|0|62-preInit
            // write pre-init user code here
            PasswordTxtFld = new TextField("Password", null, 32, TextField.ANY);//GEN-LINE:|62-getter|1|62-postInit
            // write post-init user code here
        }//GEN-BEGIN:|62-getter|2|
        return PasswordTxtFld;
    }
    //</editor-fold>//GEN-END:|62-getter|2|
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: BasicServicesGrp ">//GEN-BEGIN:|63-getter|0|63-preInit
    /**
     * Returns an initiliazed instance of BasicServicesGrp component.
     * @return the initialized component instance
     */
    public ChoiceGroup getBasicServicesGrp() {
        if (BasicServicesGrp == null) {//GEN-END:|63-getter|0|63-preInit
            // write pre-init user code here
            BasicServicesGrp = new ChoiceGroup("Basic Services", Choice.POPUP);//GEN-BEGIN:|63-getter|1|63-postInit
            BasicServicesGrp.append("Update Profile", null);
            BasicServicesGrp.append("Ubi Finding", null);
            BasicServicesGrp.append("Leave notes", null);
            BasicServicesGrp.append("Where Am I", null);
            BasicServicesGrp.setSelectedFlags(new boolean[] { false, false, false, false });//GEN-END:|63-getter|1|63-postInit
            // write post-init user code here
        }//GEN-BEGIN:|63-getter|2|
        return BasicServicesGrp;
    }
    //</editor-fold>//GEN-END:|63-getter|2|
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: OptionsGrp ">//GEN-BEGIN:|65-getter|0|65-preInit
    /**
     * Returns an initiliazed instance of OptionsGrp component.
     * @return the initialized component instance
     */
    public ChoiceGroup getOptionsGrp() {
        if (OptionsGrp == null) {//GEN-END:|65-getter|0|65-preInit
            // write pre-init user code here
            OptionsGrp = new ChoiceGroup("Options", Choice.MULTIPLE);//GEN-BEGIN:|65-getter|1|65-postInit
            OptionsGrp.append("Context-Aware", null);
            OptionsGrp.append("Anonymously Contributed", null);
            OptionsGrp.setSelectedFlags(new boolean[] { true, true });//GEN-END:|65-getter|1|65-postInit
            // write post-init user code here
        }//GEN-BEGIN:|65-getter|2|
        return OptionsGrp;
    }
    //</editor-fold>//GEN-END:|65-getter|2|
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: AdvancedServicesGrp ">//GEN-BEGIN:|69-getter|0|69-preInit
    /**
     * Returns an initiliazed instance of AdvancedServicesGrp component.
     * @return the initialized component instance
     */
    public ChoiceGroup getAdvancedServicesGrp() {
        if (AdvancedServicesGrp == null) {//GEN-END:|69-getter|0|69-preInit
            // write pre-init user code here
            AdvancedServicesGrp = new ChoiceGroup("Advanced Services", Choice.POPUP);//GEN-BEGIN:|69-getter|1|69-postInit
            AdvancedServicesGrp.append("Semantic Finding", null);
            AdvancedServicesGrp.setSelectedFlags(new boolean[] { false });//GEN-END:|69-getter|1|69-postInit
            // write post-init user code here
        }//GEN-BEGIN:|69-getter|2|
        return AdvancedServicesGrp;
    }
    //</editor-fold>//GEN-END:|69-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand2 ">//GEN-BEGIN:|75-getter|0|75-preInit
    /**
     * Returns an initiliazed instance of okCommand2 component.
     * @return the initialized component instance
     */
    public Command getOkCommand2() {
        if (okCommand2 == null) {//GEN-END:|75-getter|0|75-preInit
            // write pre-init user code here
            okCommand2 = new Command("Reply to Sender", Command.OK, 0);//GEN-LINE:|75-getter|1|75-postInit
            // write post-init user code here
        }//GEN-BEGIN:|75-getter|2|
        return okCommand2;
    }
    //</editor-fold>//GEN-END:|75-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ManualUpdate ">//GEN-BEGIN:|77-getter|0|77-preInit
    /**
     * Returns an initiliazed instance of ManualUpdate component.
     * @return the initialized component instance
     */
    public Command getManualUpdate() {
        if (ManualUpdate == null) {//GEN-END:|77-getter|0|77-preInit
            // write pre-init user code here
            ManualUpdate = new Command("ManualUpdate", Command.ITEM, 0);//GEN-LINE:|77-getter|1|77-postInit
            // write post-init user code here
        }//GEN-BEGIN:|77-getter|2|
        return ManualUpdate;
    }
    //</editor-fold>//GEN-END:|77-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: AutoUpdateKB ">//GEN-BEGIN:|79-getter|0|79-preInit
    /**
     * Returns an initiliazed instance of AutoUpdateKB component.
     * @return the initialized component instance
     */
    public Command getAutoUpdateKB() {
        if (AutoUpdateKB == null) {//GEN-END:|79-getter|0|79-preInit
            // write pre-init user code here
            AutoUpdateKB = new Command("AutoUpdateKB", Command.ITEM, 0);//GEN-LINE:|79-getter|1|79-postInit
            // write post-init user code here
        }//GEN-BEGIN:|79-getter|2|
        return AutoUpdateKB;
    }
    //</editor-fold>//GEN-END:|79-getter|2|



    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: LogScreenCmd ">//GEN-BEGIN:|83-getter|0|83-preInit
    /**
     * Returns an initiliazed instance of LogScreenCmd component.
     * @return the initialized component instance
     */
    public Command getLogScreenCmd() {
        if (LogScreenCmd == null) {//GEN-END:|83-getter|0|83-preInit
            // write pre-init user code here
            LogScreenCmd = new Command("Item", Command.ITEM, 0);//GEN-LINE:|83-getter|1|83-postInit
            // write post-init user code here
        }//GEN-BEGIN:|83-getter|2|
        return LogScreenCmd;
    }
    //</editor-fold>//GEN-END:|83-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand4 ">//GEN-BEGIN:|86-getter|0|86-preInit
    /**
     * Returns an initiliazed instance of backCommand4 component.
     * @return the initialized component instance
     */
    public Command getBackCommand4() {
        if (backCommand4 == null) {//GEN-END:|86-getter|0|86-preInit
            // write pre-init user code here
            backCommand4 = new Command("Back", Command.BACK, 0);//GEN-LINE:|86-getter|1|86-postInit
            // write post-init user code here
        }//GEN-BEGIN:|86-getter|2|
        return backCommand4;
    }
    //</editor-fold>//GEN-END:|86-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: LogScreenCmd1 ">//GEN-BEGIN:|89-getter|0|89-preInit
    /**
     * Returns an initiliazed instance of LogScreenCmd1 component.
     * @return the initialized component instance
     */
    public Command getLogScreenCmd1() {
        if (LogScreenCmd1 == null) {//GEN-END:|89-getter|0|89-preInit
            // write pre-init user code here
            LogScreenCmd1 = new Command("Item", Command.ITEM, 0);//GEN-LINE:|89-getter|1|89-postInit
            // write post-init user code here
        }//GEN-BEGIN:|89-getter|2|
        return LogScreenCmd1;
    }
    //</editor-fold>//GEN-END:|89-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: LogScreenCmd2 ">//GEN-BEGIN:|92-getter|0|92-preInit
    /**
     * Returns an initiliazed instance of LogScreenCmd2 component.
     * @return the initialized component instance
     */
    public Command getLogScreenCmd2() {
        if (LogScreenCmd2 == null) {//GEN-END:|92-getter|0|92-preInit
            // write pre-init user code here
            LogScreenCmd2 = new Command("Item", Command.ITEM, 0);//GEN-LINE:|92-getter|1|92-postInit
            // write post-init user code here
        }//GEN-BEGIN:|92-getter|2|
        return LogScreenCmd2;
    }
    //</editor-fold>//GEN-END:|92-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: task ">//GEN-BEGIN:|100-getter|0|100-preInit
    /**
     * Returns an initiliazed instance of task component.
     * @return the initialized component instance
     */
    public SimpleCancellableTask getTask() {
        if (task == null) {//GEN-END:|100-getter|0|100-preInit
            // write pre-init user code here
            task = new SimpleCancellableTask();//GEN-BEGIN:|100-getter|1|100-execute
            task.setExecutable(new org.netbeans.microedition.util.Executable() {
                public void execute() throws Exception {//GEN-END:|100-getter|1|100-execute
                    // write task-execution user code here
                }//GEN-BEGIN:|100-getter|2|100-postInit
            });//GEN-END:|100-getter|2|100-postInit
            // write post-init user code here
        }//GEN-BEGIN:|100-getter|3|
        return task;
    }
    //</editor-fold>//GEN-END:|100-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField ">//GEN-BEGIN:|101-getter|0|101-preInit
    /**
     * Returns an initiliazed instance of textField component.
     * @return the initialized component instance
     */
    public TextField getTextField() {
        if (textField == null) {//GEN-END:|101-getter|0|101-preInit
            // write pre-init user code here
            textField = new TextField("textField", null, 32, TextField.ANY);//GEN-LINE:|101-getter|1|101-postInit
            // write post-init user code here
        }//GEN-BEGIN:|101-getter|2|
        return textField;
    }
    //</editor-fold>//GEN-END:|101-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: SPARQLcmd ">//GEN-BEGIN:|102-getter|0|102-preInit
    /**
     * Returns an initiliazed instance of SPARQLcmd component.
     * @return the initialized component instance
     */
    public Command getSPARQLcmd() {
        if (SPARQLcmd == null) {//GEN-END:|102-getter|0|102-preInit
            // write pre-init user code here
            SPARQLcmd = new Command("Customize Sparql ", Command.ITEM, 0);//GEN-LINE:|102-getter|1|102-postInit
            // write post-init user code here
        }//GEN-BEGIN:|102-getter|2|
        return SPARQLcmd;
    }
    //</editor-fold>//GEN-END:|102-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: SparqlForm ">//GEN-BEGIN:|104-getter|0|104-preInit
    /**
     * Returns an initiliazed instance of SparqlForm component.
     * @return the initialized component instance
     */
    public TextBox getSparqlForm() {
        if (SparqlForm == null) {//GEN-END:|104-getter|0|104-preInit
            // write pre-init user code here
            SparqlForm = new TextBox("Customize Sparql ", "SELECT ?person\nWHERE { ?person rdf:type :Person ;\n                  :friendOf ?mine.\nFILTER (?mine=:TuanNguyen)\n}\n", 197, TextField.ANY);//GEN-BEGIN:|104-getter|1|104-postInit
            SparqlForm.addCommand(getBackCommand5());
            SparqlForm.addCommand(getSubmitSparqlCmd());
            SparqlForm.addCommand(getClearScreen());
            SparqlForm.addCommand(getSPARQLResult());
            SparqlForm.setCommandListener(this);//GEN-END:|104-getter|1|104-postInit
            // write post-init user code here
        }//GEN-BEGIN:|104-getter|2|
        return SparqlForm;
    }
    //</editor-fold>//GEN-END:|104-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand5 ">//GEN-BEGIN:|106-getter|0|106-preInit
    /**
     * Returns an initiliazed instance of backCommand5 component.
     * @return the initialized component instance
     */
    public Command getBackCommand5() {
        if (backCommand5 == null) {//GEN-END:|106-getter|0|106-preInit
            // write pre-init user code here
            backCommand5 = new Command("Back", Command.BACK, 0);//GEN-LINE:|106-getter|1|106-postInit
            // write post-init user code here
        }//GEN-BEGIN:|106-getter|2|
        return backCommand5;
    }
    //</editor-fold>//GEN-END:|106-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: SubmitSparqlCmd ">//GEN-BEGIN:|109-getter|0|109-preInit
    /**
     * Returns an initiliazed instance of SubmitSparqlCmd component.
     * @return the initialized component instance
     */
    public Command getSubmitSparqlCmd() {
        if (SubmitSparqlCmd == null) {//GEN-END:|109-getter|0|109-preInit
            // write pre-init user code here
            SubmitSparqlCmd = new Command("SubmitSparql", Command.OK, 0);//GEN-LINE:|109-getter|1|109-postInit
            // write post-init user code here
        }//GEN-BEGIN:|109-getter|2|
        return SubmitSparqlCmd;
    }
    //</editor-fold>//GEN-END:|109-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: LogsForm ">//GEN-BEGIN:|111-getter|0|111-preInit
    /**
     * Returns an initiliazed instance of LogsForm component.
     * @return the initialized component instance
     */
    public Form getLogsForm() {
        if (LogsForm == null) {//GEN-END:|111-getter|0|111-preInit
            // write pre-init user code here
            LogsForm = new Form("Logs Form", new Item[] { getLogsStringItem() });//GEN-BEGIN:|111-getter|1|111-postInit
            LogsForm.addCommand(getBackCommand6());
            LogsForm.addCommand(getClearLogScreenCmd());
            LogsForm.setCommandListener(this);//GEN-END:|111-getter|1|111-postInit
            // write post-init user code here
        }//GEN-BEGIN:|111-getter|2|
        return LogsForm;
    }
    //</editor-fold>//GEN-END:|111-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: AirportPickupForm ">//GEN-BEGIN:|125-getter|0|125-preInit
    /**
     * Returns an initiliazed instance of AirportPickupForm component.
     * @return the initialized component instance
     */
    public Form getAirportPickupForm() {
        if (AirportPickupForm == null) {//GEN-END:|125-getter|0|125-preInit
            // write pre-init user code here
            AirportPickupForm = new Form("Airport pickup", new Item[] { getDeviceNameTF(), getDeviceMACTF(), getFindingDeviceGrp(), getDiscoveredDeviceGrp() });//GEN-BEGIN:|125-getter|1|125-postInit
            AirportPickupForm.addCommand(getAddDeviceCmd());
            AirportPickupForm.addCommand(getClearAllCmd());
            AirportPickupForm.addCommand(getBackCommand7());
            AirportPickupForm.addCommand(getRemoveItemCmd());
            AirportPickupForm.addCommand(getStartFindingCmd());
            AirportPickupForm.addCommand(getShowLogs());
            AirportPickupForm.setCommandListener(this);//GEN-END:|125-getter|1|125-postInit
            // write post-init user code here
        }//GEN-BEGIN:|125-getter|2|
        return AirportPickupForm;
    }
    //</editor-fold>//GEN-END:|125-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: DeviceNameTF ">//GEN-BEGIN:|136-getter|0|136-preInit
    /**
     * Returns an initiliazed instance of DeviceNameTF component.
     * @return the initialized component instance
     */
    public TextField getDeviceNameTF() {
        if (DeviceNameTF == null) {//GEN-END:|136-getter|0|136-preInit
            // write pre-init user code here
            DeviceNameTF = new TextField("Device Name", null, 32, TextField.ANY);//GEN-LINE:|136-getter|1|136-postInit
            // write post-init user code here
        }//GEN-BEGIN:|136-getter|2|
        return DeviceNameTF;
    }
    //</editor-fold>//GEN-END:|136-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: DeviceMACTF ">//GEN-BEGIN:|137-getter|0|137-preInit
    /**
     * Returns an initiliazed instance of DeviceMACTF component.
     * @return the initialized component instance
     */
    public TextField getDeviceMACTF() {
        if (DeviceMACTF == null) {//GEN-END:|137-getter|0|137-preInit
            // write pre-init user code here
            DeviceMACTF = new TextField("MAC address", null, 32, TextField.ANY);//GEN-LINE:|137-getter|1|137-postInit
            // write post-init user code here
        }//GEN-BEGIN:|137-getter|2|
        return DeviceMACTF;
    }
    //</editor-fold>//GEN-END:|137-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: FindingDeviceGrp ">//GEN-BEGIN:|138-getter|0|138-preInit
    /**
     * Returns an initiliazed instance of FindingDeviceGrp component.
     * @return the initialized component instance
     */
    public ChoiceGroup getFindingDeviceGrp() {
        if (FindingDeviceGrp == null) {//GEN-END:|138-getter|0|138-preInit
            // write pre-init user code here
            FindingDeviceGrp = new ChoiceGroup("Finding device list", Choice.POPUP);//GEN-BEGIN:|138-getter|1|138-postInit
            FindingDeviceGrp.setSelectedFlags(new boolean[] {  });//GEN-END:|138-getter|1|138-postInit
            // write post-init user code here
        }//GEN-BEGIN:|138-getter|2|
        return FindingDeviceGrp;
    }
    //</editor-fold>//GEN-END:|138-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: DiscoveredDeviceGrp ">//GEN-BEGIN:|141-getter|0|141-preInit
    /**
     * Returns an initiliazed instance of DiscoveredDeviceGrp component.
     * @return the initialized component instance
     */
    public ChoiceGroup getDiscoveredDeviceGrp() {
        if (DiscoveredDeviceGrp == null) {//GEN-END:|141-getter|0|141-preInit
            // write pre-init user code here
            DiscoveredDeviceGrp = new ChoiceGroup("Discovered device list", Choice.MULTIPLE);//GEN-LINE:|141-getter|1|141-postInit
            // write post-init user code here
        }//GEN-BEGIN:|141-getter|2|
        return DiscoveredDeviceGrp;
    }
    //</editor-fold>//GEN-END:|141-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand6 ">//GEN-BEGIN:|112-getter|0|112-preInit
    /**
     * Returns an initiliazed instance of backCommand6 component.
     * @return the initialized component instance
     */
    public Command getBackCommand6() {
        if (backCommand6 == null) {//GEN-END:|112-getter|0|112-preInit
            // write pre-init user code here
            backCommand6 = new Command("Back", Command.BACK, 0);//GEN-LINE:|112-getter|1|112-postInit
            // write post-init user code here
        }//GEN-BEGIN:|112-getter|2|
        return backCommand6;
    }
    //</editor-fold>//GEN-END:|112-getter|2|
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: StartSensingCmd ">//GEN-BEGIN:|116-getter|0|116-preInit
    /**
     * Returns an initiliazed instance of StartSensingCmd component.
     * @return the initialized component instance
     */
    public Command getStartSensingCmd() {
        if (StartSensingCmd == null) {//GEN-END:|116-getter|0|116-preInit
            // write pre-init user code here
            StartSensingCmd = new Command("Start Sensing", Command.ITEM, 0);//GEN-LINE:|116-getter|1|116-postInit
            // write post-init user code here
        }//GEN-BEGIN:|116-getter|2|
        return StartSensingCmd;
    }
    //</editor-fold>//GEN-END:|116-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemCommand1 ">//GEN-BEGIN:|118-getter|0|118-preInit
    /**
     * Returns an initiliazed instance of itemCommand1 component.
     * @return the initialized component instance
     */
    public Command getItemCommand1() {
        if (itemCommand1 == null) {//GEN-END:|118-getter|0|118-preInit
            // write pre-init user code here
            itemCommand1 = new Command("Item", Command.ITEM, 0);//GEN-LINE:|118-getter|1|118-postInit
            // write post-init user code here
        }//GEN-BEGIN:|118-getter|2|
        return itemCommand1;
    }
    //</editor-fold>//GEN-END:|118-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: AirportPickupCmd ">//GEN-BEGIN:|123-getter|0|123-preInit
    /**
     * Returns an initiliazed instance of AirportPickupCmd component.
     * @return the initialized component instance
     */
    public Command getAirportPickupCmd() {
        if (AirportPickupCmd == null) {//GEN-END:|123-getter|0|123-preInit
            // write pre-init user code here
            AirportPickupCmd = new Command("Item", Command.ITEM, 0);//GEN-LINE:|123-getter|1|123-postInit
            // write post-init user code here
        }//GEN-BEGIN:|123-getter|2|
        return AirportPickupCmd;
    }
    //</editor-fold>//GEN-END:|123-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: AddDeviceCmd ">//GEN-BEGIN:|127-getter|0|127-preInit
    /**
     * Returns an initiliazed instance of AddDeviceCmd component.
     * @return the initialized component instance
     */
    public Command getAddDeviceCmd() {
        if (AddDeviceCmd == null) {//GEN-END:|127-getter|0|127-preInit
            // write pre-init user code here
            AddDeviceCmd = new Command("Add device", Command.ITEM, 0);//GEN-LINE:|127-getter|1|127-postInit
            // write post-init user code here
        }//GEN-BEGIN:|127-getter|2|
        return AddDeviceCmd;
    }
    //</editor-fold>//GEN-END:|127-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ClearAllCmd ">//GEN-BEGIN:|129-getter|0|129-preInit
    /**
     * Returns an initiliazed instance of ClearAllCmd component.
     * @return the initialized component instance
     */
    public Command getClearAllCmd() {
        if (ClearAllCmd == null) {//GEN-END:|129-getter|0|129-preInit
            // write pre-init user code here
            ClearAllCmd = new Command("Clear All", Command.ITEM, 0);//GEN-LINE:|129-getter|1|129-postInit
            // write post-init user code here
        }//GEN-BEGIN:|129-getter|2|
        return ClearAllCmd;
    }
    //</editor-fold>//GEN-END:|129-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand7 ">//GEN-BEGIN:|131-getter|0|131-preInit
    /**
     * Returns an initiliazed instance of backCommand7 component.
     * @return the initialized component instance
     */
    public Command getBackCommand7() {
        if (backCommand7 == null) {//GEN-END:|131-getter|0|131-preInit
            // write pre-init user code here
            backCommand7 = new Command("Back", Command.BACK, 0);//GEN-LINE:|131-getter|1|131-postInit
            // write post-init user code here
        }//GEN-BEGIN:|131-getter|2|
        return backCommand7;
    }
    //</editor-fold>//GEN-END:|131-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: RemoveItemCmd ">//GEN-BEGIN:|134-getter|0|134-preInit
    /**
     * Returns an initiliazed instance of RemoveItemCmd component.
     * @return the initialized component instance
     */
    public Command getRemoveItemCmd() {
        if (RemoveItemCmd == null) {//GEN-END:|134-getter|0|134-preInit
            // write pre-init user code here
            RemoveItemCmd = new Command("Remove item[s]", Command.ITEM, 0);//GEN-LINE:|134-getter|1|134-postInit
            // write post-init user code here
        }//GEN-BEGIN:|134-getter|2|
        return RemoveItemCmd;
    }
    //</editor-fold>//GEN-END:|134-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: MobiphoneImage ">//GEN-BEGIN:|143-getter|0|143-preInit
    /**
     * Returns an initiliazed instance of MobiphoneImage component.
     * @return the initialized component instance
     */
    public Image getMobiphoneImage() {
        if (MobiphoneImage == null) {//GEN-END:|143-getter|0|143-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|143-getter|1|143-@java.io.IOException
                MobiphoneImage = Image.createImage("/agents/resources/mobiphone.png");
            } catch (java.io.IOException e) {//GEN-END:|143-getter|1|143-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|143-getter|2|143-postInit
            // write post-init user code here
        }//GEN-BEGIN:|143-getter|3|
        return MobiphoneImage;
    }
    //</editor-fold>//GEN-END:|143-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: SplashScreenImage ">//GEN-BEGIN:|144-getter|0|144-preInit
    /**
     * Returns an initiliazed instance of SplashScreenImage component.
     * @return the initialized component instance
     */
    public Image getSplashScreenImage() {
        if (SplashScreenImage == null) {//GEN-END:|144-getter|0|144-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|144-getter|1|144-@java.io.IOException
                SplashScreenImage = Image.createImage("/agents/resources/splash.jpg");
            } catch (java.io.IOException e) {//GEN-END:|144-getter|1|144-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|144-getter|2|144-postInit
            // write post-init user code here
        }//GEN-BEGIN:|144-getter|3|
        return SplashScreenImage;
    }
    //</editor-fold>//GEN-END:|144-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: StartFindingCmd ">//GEN-BEGIN:|145-getter|0|145-preInit
    /**
     * Returns an initiliazed instance of StartFindingCmd component.
     * @return the initialized component instance
     */
    public Command getStartFindingCmd() {
        if (StartFindingCmd == null) {//GEN-END:|145-getter|0|145-preInit
            // write pre-init user code here
            StartFindingCmd = new Command("Start finding", Command.ITEM, 0);//GEN-LINE:|145-getter|1|145-postInit
            // write post-init user code here
        }//GEN-BEGIN:|145-getter|2|
        return StartFindingCmd;
    }
    //</editor-fold>//GEN-END:|145-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: LogsStringItem ">//GEN-BEGIN:|149-getter|0|149-preInit
    /**
     * Returns an initiliazed instance of LogsStringItem component.
     * @return the initialized component instance
     */
    public StringItem getLogsStringItem() {
        if (LogsStringItem == null) {//GEN-END:|149-getter|0|149-preInit
            // write pre-init user code here
            LogsStringItem = new StringItem("Logging", null);//GEN-LINE:|149-getter|1|149-postInit
            // write post-init user code here
        }//GEN-BEGIN:|149-getter|2|
        return LogsStringItem;
    }
    //</editor-fold>//GEN-END:|149-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: clearLogScreenCmd ">//GEN-BEGIN:|147-getter|0|147-preInit
    /**
     * Returns an initiliazed instance of clearLogScreenCmd component.
     * @return the initialized component instance
     */
    public Command getClearLogScreenCmd() {
        if (clearLogScreenCmd == null) {//GEN-END:|147-getter|0|147-preInit
            // write pre-init user code here
            clearLogScreenCmd = new Command("Item", Command.ITEM, 0);//GEN-LINE:|147-getter|1|147-postInit
            // write post-init user code here
        }//GEN-BEGIN:|147-getter|2|
        return clearLogScreenCmd;
    }
    //</editor-fold>//GEN-END:|147-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ShowLogs ">//GEN-BEGIN:|150-getter|0|150-preInit
    /**
     * Returns an initiliazed instance of ShowLogs component.
     * @return the initialized component instance
     */
    public Command getShowLogs() {
        if (ShowLogs == null) {//GEN-END:|150-getter|0|150-preInit
            // write pre-init user code here
            ShowLogs = new Command("Show Logs", Command.ITEM, 0);//GEN-LINE:|150-getter|1|150-postInit
            // write post-init user code here
        }//GEN-BEGIN:|150-getter|2|
        return ShowLogs;
    }
    //</editor-fold>//GEN-END:|150-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: GpsLoggingCmd ">//GEN-BEGIN:|153-getter|0|153-preInit
    /**
     * Returns an initiliazed instance of GpsLoggingCmd component.
     * @return the initialized component instance
     */
    public Command getGpsLoggingCmd() {
        if (GpsLoggingCmd == null) {//GEN-END:|153-getter|0|153-preInit
            // write pre-init user code here
            GpsLoggingCmd = new Command("GPS Logging", Command.ITEM, 0);//GEN-LINE:|153-getter|1|153-postInit
            // write post-init user code here
        }//GEN-BEGIN:|153-getter|2|
        return GpsLoggingCmd;
    }
    //</editor-fold>//GEN-END:|153-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: GSMCellBroadCastSI ">//GEN-BEGIN:|155-getter|0|155-preInit
    /**
     * Returns an initiliazed instance of GSMCellBroadCastSI component.
     * @return the initialized component instance
     */
    public StringItem getGSMCellBroadCastSI() {
        if (GSMCellBroadCastSI == null) {//GEN-END:|155-getter|0|155-preInit
            // write pre-init user code here
            GSMCellBroadCastSI = new StringItem("GSM Tower/Cell", null);//GEN-LINE:|155-getter|1|155-postInit
            // write post-init user code here
        }//GEN-BEGIN:|155-getter|2|
        return GSMCellBroadCastSI;
    }
    //</editor-fold>//GEN-END:|155-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: PlaceSenseBlueDevicesGrp ">//GEN-BEGIN:|156-getter|0|156-preInit
    /**
     * Returns an initiliazed instance of PlaceSenseBlueDevicesGrp component.
     * @return the initialized component instance
     */
    public ChoiceGroup getPlaceSenseBlueDevicesGrp() {
        if (PlaceSenseBlueDevicesGrp == null) {//GEN-END:|156-getter|0|156-preInit
            // write pre-init user code here
            PlaceSenseBlueDevicesGrp = new ChoiceGroup("Bluetooth Devices", Choice.POPUP);//GEN-BEGIN:|156-getter|1|156-postInit
            PlaceSenseBlueDevicesGrp.append("Dev, Person ", null);
            PlaceSenseBlueDevicesGrp.setSelectedFlags(new boolean[] { false });//GEN-END:|156-getter|1|156-postInit
            // write post-init user code here
        }//GEN-BEGIN:|156-getter|2|
        return PlaceSenseBlueDevicesGrp;
    }
    //</editor-fold>//GEN-END:|156-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: CurrentPosGrp ">//GEN-BEGIN:|157-getter|0|157-preInit
    /**
     * Returns an initiliazed instance of CurrentPosGrp component.
     * @return the initialized component instance
     */
    public ChoiceGroup getCurrentPosGrp() {
        if (CurrentPosGrp == null) {//GEN-END:|157-getter|0|157-preInit
            // write pre-init user code here
            CurrentPosGrp = new ChoiceGroup("Current Position", Choice.POPUP);//GEN-BEGIN:|157-getter|1|157-postInit
            CurrentPosGrp.append("Latitude:", null);
            CurrentPosGrp.append("Longitude:", null);
            CurrentPosGrp.append("Altitude:", null);
            CurrentPosGrp.append("Speed:", null);
            CurrentPosGrp.setSelectedFlags(new boolean[] { false, false, false, false });//GEN-END:|157-getter|1|157-postInit
            // write post-init user code here
        }//GEN-BEGIN:|157-getter|2|
        return CurrentPosGrp;
    }
    //</editor-fold>//GEN-END:|157-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: StopSensingCmd ">//GEN-BEGIN:|162-getter|0|162-preInit
    /**
     * Returns an initiliazed instance of StopSensingCmd component.
     * @return the initialized component instance
     */
    public Command getStopSensingCmd() {
        if (StopSensingCmd == null) {//GEN-END:|162-getter|0|162-preInit
            // write pre-init user code here
            StopSensingCmd = new Command("StopSensing", Command.ITEM, 0);//GEN-LINE:|162-getter|1|162-postInit
            // write post-init user code here
        }//GEN-BEGIN:|162-getter|2|
        return StopSensingCmd;
    }
    //</editor-fold>//GEN-END:|162-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: CommunityContributeCmd ">//GEN-BEGIN:|164-getter|0|164-preInit
    /**
     * Returns an initiliazed instance of CommunityContributeCmd component.
     * @return the initialized component instance
     */
    public Command getCommunityContributeCmd() {
        if (CommunityContributeCmd == null) {//GEN-END:|164-getter|0|164-preInit
            // write pre-init user code here
            CommunityContributeCmd = new Command("Community contributing", Command.ITEM, 0);//GEN-LINE:|164-getter|1|164-postInit
            // write post-init user code here
        }//GEN-BEGIN:|164-getter|2|
        return CommunityContributeCmd;
    }
    //</editor-fold>//GEN-END:|164-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Options ">//GEN-BEGIN:|166-getter|0|166-preInit
    /**
     * Returns an initiliazed instance of Options component.
     * @return the initialized component instance
     */
    public ChoiceGroup getOptions() {
        if (Options == null) {//GEN-END:|166-getter|0|166-preInit
            // write pre-init user code here
            Options = new ChoiceGroup("Options", Choice.MULTIPLE);//GEN-BEGIN:|166-getter|1|166-postInit
            Options.append("Cascading Insertion", null);
            Options.setSelectedFlags(new boolean[] { true });//GEN-END:|166-getter|1|166-postInit
            // write post-init user code here
        }//GEN-BEGIN:|166-getter|2|
        return Options;
    }
    //</editor-fold>//GEN-END:|166-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem ">//GEN-BEGIN:|169-getter|0|169-preInit
    /**
     * Returns an initiliazed instance of stringItem component.
     * @return the initialized component instance
     */
    public StringItem getStringItem() {
        if (stringItem == null) {//GEN-END:|169-getter|0|169-preInit
            // write pre-init user code here
            stringItem = new StringItem("stringItem", null);//GEN-LINE:|169-getter|1|169-postInit
            // write post-init user code here
        }//GEN-BEGIN:|169-getter|2|
        return stringItem;
    }
    //</editor-fold>//GEN-END:|169-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: SparqlResult ">//GEN-BEGIN:|170-getter|0|170-preInit
    /**
     * Returns an initiliazed instance of SparqlResult component.
     * @return the initialized component instance
     */
    public List getSparqlResult() {
        if (SparqlResult == null) {//GEN-END:|170-getter|0|170-preInit
            // write pre-init user code here
            SparqlResult = new List("SPARQL Results", Choice.IMPLICIT);//GEN-BEGIN:|170-getter|1|170-postInit
            SparqlResult.append("List Element 1", null);
            SparqlResult.append("List Element 2", null);
            SparqlResult.addCommand(getBackCommand8());
            SparqlResult.addCommand(getClearSPARQLResultCmd());
            SparqlResult.setCommandListener(this);
            SparqlResult.setSelectedFlags(new boolean[] { false, false });//GEN-END:|170-getter|1|170-postInit
            // write post-init user code here
        }//GEN-BEGIN:|170-getter|2|
        return SparqlResult;
    }
    //</editor-fold>//GEN-END:|170-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: SparqlResultAction ">//GEN-BEGIN:|170-action|0|170-preAction
    /**
     * Performs an action assigned to the selected list element in the SparqlResult component.
     */
    public void SparqlResultAction() {//GEN-END:|170-action|0|170-preAction
        // enter pre-action user code here
        String __selectedString = getSparqlResult().getString(getSparqlResult().getSelectedIndex());//GEN-BEGIN:|170-action|1|176-preAction
        if (__selectedString != null) {
            if (__selectedString.equals("List Element 1")) {//GEN-END:|170-action|1|176-preAction
                // write pre-action user code here
//GEN-LINE:|170-action|2|176-postAction
                // write post-action user code here
            } else if (__selectedString.equals("List Element 2")) {//GEN-LINE:|170-action|3|177-preAction
                // write pre-action user code here
//GEN-LINE:|170-action|4|177-postAction
                // write post-action user code here
            }//GEN-BEGIN:|170-action|5|170-postAction
        }//GEN-END:|170-action|5|170-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|170-action|6|
    //</editor-fold>//GEN-END:|170-action|6|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand8 ">//GEN-BEGIN:|178-getter|0|178-preInit
    /**
     * Returns an initiliazed instance of backCommand8 component.
     * @return the initialized component instance
     */
    public Command getBackCommand8() {
        if (backCommand8 == null) {//GEN-END:|178-getter|0|178-preInit
            // write pre-init user code here
            backCommand8 = new Command("Back", Command.BACK, 0);//GEN-LINE:|178-getter|1|178-postInit
            // write post-init user code here
        }//GEN-BEGIN:|178-getter|2|
        return backCommand8;
    }
    //</editor-fold>//GEN-END:|178-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ClearScreen ">//GEN-BEGIN:|181-getter|0|181-preInit
    /**
     * Returns an initiliazed instance of ClearScreen component.
     * @return the initialized component instance
     */
    public Command getClearScreen() {
        if (ClearScreen == null) {//GEN-END:|181-getter|0|181-preInit
            // write pre-init user code here
            ClearScreen = new Command("Item", Command.ITEM, 0);//GEN-LINE:|181-getter|1|181-postInit
            // write post-init user code here
        }//GEN-BEGIN:|181-getter|2|
        return ClearScreen;
    }
    //</editor-fold>//GEN-END:|181-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: SPARQLResult ">//GEN-BEGIN:|183-getter|0|183-preInit
    /**
     * Returns an initiliazed instance of SPARQLResult component.
     * @return the initialized component instance
     */
    public Command getSPARQLResult() {
        if (SPARQLResult == null) {//GEN-END:|183-getter|0|183-preInit
            // write pre-init user code here
            SPARQLResult = new Command("Item", Command.ITEM, 0);//GEN-LINE:|183-getter|1|183-postInit
            // write post-init user code here
        }//GEN-BEGIN:|183-getter|2|
        return SPARQLResult;
    }
    //</editor-fold>//GEN-END:|183-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ClearSPARQLResultCmd ">//GEN-BEGIN:|186-getter|0|186-preInit
    /**
     * Returns an initiliazed instance of ClearSPARQLResultCmd component.
     * @return the initialized component instance
     */
    public Command getClearSPARQLResultCmd() {
        if (ClearSPARQLResultCmd == null) {//GEN-END:|186-getter|0|186-preInit
            // write pre-init user code here
            ClearSPARQLResultCmd = new Command("Clear screen", Command.ITEM, 0);//GEN-LINE:|186-getter|1|186-postInit
            // write post-init user code here
        }//GEN-BEGIN:|186-getter|2|
        return ClearSPARQLResultCmd;
    }
    //</editor-fold>//GEN-END:|186-getter|2|

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

    public void updateStatus(String s) {
        String stemp=LogsStringItem.getText()+"\n"+ s;
        
        LogsStringItem.setText(stemp);
    }

    public boolean checkDevice(String sDeviceName, String strDeviceMacAddress) {
        
        int iFindingSize=FindingDeviceGrp.size();
        int iDiscoveredSize = DiscoveredDeviceGrp.size();
        int i=0;
        boolean stop=false;
        while (!stop){
            if (FindingDeviceGrp.getString(i).indexOf(strDeviceMacAddress)>0){
                String stemp=sDeviceName+","+strDeviceMacAddress;
                DiscoveredDeviceGrp.append(stemp, MobiphoneImage);
                stop=true;
            }
            i++;
        }
        if (iFindingSize==iDiscoveredSize){
            return true;
        }else {return false;}

    }

    public void notifyIncomingMessage(MessageConnection conn) {

       Message msg = null;
	try {
	msg = conn.receive();
	}
	catch (Exception e) {
	e.printStackTrace();
	System.out.println("processMessage.receive " + e);
}
	if (msg instanceof TextMessage) {
	try{
		TextMessage tmsg = (TextMessage)msg;
		msgReceived = tmsg.getPayloadText();
		//form.append(msgReceived);
		//display.setCurrent(form);
		}catch(Exception e){
		e.printStackTrace();
		System.out.println("msgReceived "+msgReceived);
		}
	}
	else if (msg instanceof BinaryMessage) {
	try{
	BinaryMessage bmsg = (BinaryMessage)msg;
	byte[] data = bmsg.getPayloadData();
	msgReceived = data.toString();
	//form.append(msgReceived);
	//display.setCurrent(form);
	}catch(Exception e){
		e.printStackTrace();
		System.out.println("msgReceived "+msgReceived);
	}
	}
    }

    public void updateSparqlResults(String string) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
