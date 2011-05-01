/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package au.edu.latrobe.placecomm.agents;

import au.edu.latrobe.placecomm.agents.threads.*;
import au.edu.latrobe.placecomm.ontology.mobi.*;

import jade.content.ContentElement;
import jade.core.AID;
import jade.core.Agent;
import jade.core.MicroRuntime;
import java.util.*;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 * @author ATuan
 */

public class MobileUserAgentGUI implements MobileUserAgentGUIInterface, CommandListener {

    private MobileUserAgent myAgent;
    private boolean midletPaused = false;
    private boolean bAllDone=false;
    public  BlueDiscoveryThread blueDiscoveryThread ;
    public  BlueGpsThread blueGpsThread=null;
    private boolean blueGpsThreadStarted=false;
    public  String gpsGlobal="";
    public  String gpsGlobalLat="";
    public  String gpsGlobalLon="";
    public  String gpsGlobalAlt="";
    public  String gpsGlobalSpeed="";
    public  String globalCellBroadCast="VINAPhoneDist1";
    public  String sLocalAgentName="";
    public  String sCellBroadcast="";

    private boolean blueDiscoveryThreadStarted=false;
    
    private StringItem CommunityStringItem;
    private StringItem stringItem;
    private StringItem LocalBlueID;
    
    private Form LoginForm;
    private Form PBVCForm;
    private Form OfflineForm;
    private Form PlaceSenseForm;
    private Form SemanticPlaceBrowserForm;
    private Form PlaceAwareForm;
    private Form LogsForm;
    private Form AirportPickupForm;

    private Image MobiphoneImage;

    private TextField LatTxtFld;
    private TextField LonTxtFld;
    private TextField AltTxtFld;
    private TextField SpeedTxtFld;
    private TextField textField;
    private TextField UsernameTxtFld;
    private TextField PasswordTxtFld;
    private TextField DeviceNameTF;
    private TextField DeviceMACTF;


    private TextBox SparqlForm;

    private List SparqlResult;


    private StringItem ReceivedMessageSI;
    private StringItem UserAndCommunitySI;
    private StringItem LogsStringItem;
    private StringItem GSMCellBroadCastSI;

    private TextField MessageToSendTF;
    private ChoiceGroup BasicServicesGrp;
    private ChoiceGroup OptionsGrp;
    private ChoiceGroup AdvancedServicesGrp;
    private ChoiceGroup FindingDeviceGrp;
    private ChoiceGroup DiscoveredDeviceGrp;
    private ChoiceGroup PlaceSenseBlueDevicesGrp;
    private ChoiceGroup CurrentPosGrp;
    private ChoiceGroup Options;

    private Command exitCommand;
    private Command okCommand;
    private Command backCommand;
    private Command OfflineMode;
    private Command PlaceAware;
    private Command PlaceSense;
    private Command SemanticPlaceBrowser;
    private Command backCommand1;
    private Command backCommand2;
    private Command backCommand3;
    private Command backCommand5;
    private Command backCommand6;
    private Command backCommand7;
    private Command backCommand8;
    private Command okCommand1;
    private Command okCommand2;
    private Command AutoUpdateKB;
    private Command ManualUpdateKB;
    private Command SPARQLcmd;
    private Command SubmitSparqlCmd;
    private Command clearLogsScreenCmd;
    private Command AirportPickupCmd;
    private Command AddDeviceCmd;
    private Command ClearAllCmd;
    private Command RemoveItemCmd;
    private Command StartFindingCmd;
    private Command clearLogScreenCmd;
    private Command LogScreenCmd2;
    private Command GpsLoggingCmd;
    private Command CommunityContributeCmd;
    private Command StopSensingCmd;
    private Command StartSensingCmd;
    private Command ClearScreen;
    private Command ClearSPARQLResultCmd;

    private Display display ;

    /**
     * The MobileUserAgentGUI constructor.
     */

    public MobileUserAgentGUI(MobileUserAgent a) {
        myAgent = a; // The myAgent is a global/pre-defined variable that represent
                     // the User Agent.
        sLocalAgentName=myAgent.getLocalName();
        System.out.println("Agent name: "+sLocalAgentName);
        
        // Create command
        exitCommand = new Command("Exit", Command.EXIT, 0);
        OfflineMode = new Command("Item", Command.ITEM, 0);
        okCommand = new Command("Ok", Command.OK, 0);
        okCommand1 = new Command("Upload to KBAgent", Command.OK, 0);
        okCommand2 = new Command("Reply to Sender", Command.OK, 0);

        backCommand = new Command("Back", Command.BACK, 0);
        backCommand1 = new Command("Back", Command.BACK, 0);
        backCommand2 = new Command("Back", Command.BACK, 0);
        backCommand3 = new Command("Back", Command.BACK, 0);
        backCommand5 = new Command("Back", Command.BACK, 0);

        AutoUpdateKB= new Command("AutoUpdateKB", Command.ITEM, 0);
        ManualUpdateKB= new Command("ManualUpdateKB", Command.ITEM, 0);
        SubmitSparqlCmd = new Command("SubmitSparql", Command.OK, 0);
        

        OfflineMode = new Command("Go offline", Command.ITEM, 0);
        PlaceAware = new Command("PlaceAware", Command.ITEM, 0);
        PlaceSense= new Command("PlaceSense", Command.ITEM, 0);
        SemanticPlaceBrowser= new Command("Semantic PlaceBrowser", Command.ITEM, 0);

        BasicServicesGrp = new ChoiceGroup("Basic Services", Choice.POPUP);
        BasicServicesGrp.append("Update Profile", null);
        BasicServicesGrp.append("Ubi Finding", null);
        BasicServicesGrp.append("Leave notes", null);
        BasicServicesGrp.append("Where Am I", null);
        BasicServicesGrp.setSelectedFlags(new boolean[] { false, false, false, false });

        OptionsGrp = new ChoiceGroup("Options", Choice.MULTIPLE);
        OptionsGrp.append("Context-Aware", null);
        OptionsGrp.append("Anonymously Contributed", null);
        OptionsGrp.setSelectedFlags(new boolean[] { true, true });

        AdvancedServicesGrp = new ChoiceGroup("Advanced Services", Choice.POPUP);
        AdvancedServicesGrp.append("Semantic Finding", null);
        AdvancedServicesGrp.setSelectedFlags(new boolean[] { false });

        
        // Create all other forms and components
        //UsernameTxtFld = new TextField("Username", null, 32, TextField.ANY);
        //PasswordTxtFld = new TextField("Password", null, 32, TextField.ANY);
        stringItem = new StringItem("Receiving Message", null);
        String stemp=sLocalAgentName+"@PBVC";
        UserAndCommunitySI = new StringItem(stemp, null);
        ReceivedMessageSI = new StringItem("Receiving Message", null);
        MessageToSendTF = new TextField("Message to Send", null, 32, TextField.ANY);
        
        BasicServicesGrp = new ChoiceGroup("Basic Services", Choice.POPUP);
            BasicServicesGrp.append("Update Profile", null);
            BasicServicesGrp.append("Ubi Finding", null);
            BasicServicesGrp.append("Leave notes", null);
            BasicServicesGrp.append("Where Am I", null);
            BasicServicesGrp.setSelectedFlags(new boolean[] { false, false, false, false });

        OptionsGrp = new ChoiceGroup("Options", Choice.MULTIPLE);
            OptionsGrp.append("Context-Aware", null);
            OptionsGrp.append("Anonymously Contributed", null);
            OptionsGrp.setSelectedFlags(new boolean[] { true, true });
        AdvancedServicesGrp = new ChoiceGroup("Advanced Services", Choice.POPUP);
            AdvancedServicesGrp.append("Semantic Finding", null);
            AdvancedServicesGrp.setSelectedFlags(new boolean[] { false });


        LocalBlueID = new StringItem("BluetoothID", "AABBCCDDEEFF");
        LatTxtFld = new TextField("Latitude", "10.25", 32, TextField.ANY);
        LonTxtFld = new TextField("Longitude", "45.23", 32, TextField.ANY);
        AltTxtFld = new TextField("Altitude", "20", 32, TextField.ANY);
        SpeedTxtFld = new TextField("Speed (km/h)", "89", 32, TextField.ANY);
        System.out.println("Create all other forms and components ! Done");
        
        // Create PBVCForm
        PBVCForm = new Form("Welcome to PBVC");
        PBVCForm.append(UserAndCommunitySI);
        PBVCForm.append(ReceivedMessageSI);
        PBVCForm.append(MessageToSendTF);
        PBVCForm.append(BasicServicesGrp);
        PBVCForm.append(OptionsGrp);
        PBVCForm.append(AdvancedServicesGrp);

        PBVCForm.addCommand(backCommand);
        PBVCForm.addCommand(PlaceAware);
        PBVCForm.addCommand(PlaceSense);
        PBVCForm.addCommand(SemanticPlaceBrowser);
        PBVCForm.addCommand(okCommand2);
        PBVCForm.setCommandListener(this);

        // Create Logs Form
        LogsForm = new Form("Logs Form", new Item[] { getLogsStringItem() });
        LogsForm.addCommand(getBackCommand6());
        LogsForm.addCommand(getClearLogScreenCmd());
        




        display=Display.getDisplay(Agent.midlet);
        System.out.println("From here 3");
        Display.getDisplay(Agent.midlet).setCurrent(PBVCForm);
        System.out.println("From here 4");
    }
    
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }     
    }
    public Command getGpsLoggingCmd() {
        if (GpsLoggingCmd == null) {
            // write pre-init user code here
            GpsLoggingCmd = new Command("GPS Logging", Command.ITEM, 0);
            // write post-init user code here
        }
        return GpsLoggingCmd;
    }
    
    public Command getClearLogScreenCmd() {
        if (clearLogScreenCmd == null) {
            // write pre-init user code here
            clearLogScreenCmd = new Command("Clear log screen", Command.ITEM, 0);
            // write post-init user code here
        }
        return clearLogScreenCmd;
    }
    public StringItem getLogsStringItem() {
        if (LogsStringItem == null) {
            // write pre-init user code here
            LogsStringItem = new StringItem("Logging", null);
            // write post-init user code here
        }
        return LogsStringItem;
    }

      public Image getMobiphoneImage() {
        if (MobiphoneImage == null) {
            // write pre-init user code here
            try {
                MobiphoneImage = Image.createImage("/agents/resources/mobiphone.png");
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
            // write post-init user code here
        }
        return MobiphoneImage;
      }

        public Command getClearAllCmd() {
        if (ClearAllCmd == null) {
            // write pre-init user code here
            ClearAllCmd = new Command("Clear All", Command.ITEM, 0);
            // write post-init user code here
        }
        return ClearAllCmd;
    }
   public Command getRemoveItemCmd() {
        if (RemoveItemCmd == null) {
            // write pre-init user code here
            RemoveItemCmd = new Command("Remove item[s]", Command.ITEM, 0);
            // write post-init user code here
        }
        return RemoveItemCmd;
    }

   public Command getStartFindingCmd() {
        if (StartFindingCmd == null) {
            // write pre-init user code here
            StartFindingCmd = new Command("Start finding", Command.ITEM, 0);
            // write post-init user code here
        }
        return StartFindingCmd;
    }

   public ChoiceGroup getPlaceSenseBlueDevicesGrp() {
        if (PlaceSenseBlueDevicesGrp == null) {
            // write pre-init user code here
            PlaceSenseBlueDevicesGrp = new ChoiceGroup("Bluetooth Devices", Choice.POPUP);
            PlaceSenseBlueDevicesGrp.append("Dev, Person ", null);
            PlaceSenseBlueDevicesGrp.setSelectedFlags(new boolean[] { false });
            // write post-init user code here
        }
        return PlaceSenseBlueDevicesGrp;
    }


    /**
     * Called by a system to indicated that a command has been invoked on a particular displayable.
     * @param command the Command that was invoked
     * @param displayable the Displayable where the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {
        // write pre-action user code here
         if (displayable == AirportPickupForm) {
            if (command == AddDeviceCmd) {
                // write pre-action user code here
                String sFindingDevice=DeviceNameTF.getString()+":"+DeviceMACTF.getString();
                FindingDeviceGrp.append(sFindingDevice, getMobiphoneImage());

                // write post-action user code here
            } else if (command == ClearAllCmd) {
                // write pre-action user code here
                FindingDeviceGrp.deleteAll();
                DiscoveredDeviceGrp.deleteAll();

                // write post-action user code here
            } else if (command == RemoveItemCmd) {
                // write pre-action user code here
                int i=FindingDeviceGrp.getSelectedIndex();
                FindingDeviceGrp.delete(i);

                // write post-action user code here
            } else if (command == StartFindingCmd) {
                // write pre-action user code here
                try{
                    //BlueDiscoveryThread(MobileUserAgentGUI  MIDlet, boolean FileOrWS,
                    // boolean bCascadingInsertion, boolean bPlaceAwareAirportPickp)
                     blueDiscoveryThread = new BlueDiscoveryThread(this);
                     blueDiscoveryThread.start(); // Start  BlueDiscoveryThread
                     blueDiscoveryThreadStarted=true;
                     LogsForm.append("Blue discovery sucess\n");
                    }catch(Exception e){
                        blueDiscoveryThreadStarted=false;
                        LogsForm.append("Blue discovery FAILED:"+e.toString()+"\n");
                    }
                // write post-action user code here
            } else if (command == backCommand7) {
                // write pre-action user code here
                switchDisplayable(null, getPlaceAwareForm());
                // write post-action user code here
            }
        }else
        if (displayable == LoginForm) {
            if (command == OfflineMode) {
                // write pre-action user code here
                switchDisplayable(null, getOfflineForm());
                // write post-action user code here
            } else if (command == exitCommand) {
                // write pre-action user code here
                //exitMIDlet();
                // write post-action user code here
            } else if (command == okCommand) {
                // write pre-action user code here
                String name = UsernameTxtFld.getString();
                String strAgentClassName="agents.MobileUserAgent";
                try {
                    MicroRuntime.startAgent(name, "agents.MobileUserAgent", null);
                    // write post-action user code here
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                switchDisplayable(null, getPBVCForm());
                // write post-action user code here
            }
        } else if (displayable == PBVCForm) {
            if (command == PlaceAware) {
                // write pre-action user code here
                switchDisplayable(null, getPlaceAwareForm());
                // write post-action user code here
            } else if (command == PlaceSense) {
                // write pre-action user code here
                switchDisplayable(null, getPlaceSenseForm());
                // write post-action user code here
            } else if (command == SemanticPlaceBrowser) {
                // write pre-action user code here
                switchDisplayable(null, getSemanticPlaceBrowserForm());
                // write post-action user code here
            } else if (command == backCommand) {
                // write pre-action user code here
                switchDisplayable(null, LoginForm);

                // write post-action user code here
            }
        }else if (displayable == PlaceAwareForm) {
            if (command == AirportPickupCmd) {
                // write pre-action user code here
                switchDisplayable(null, getAirportPickupForm());
                // write post-action user code here
            } else if (command == AutoUpdateKB) {
                // write pre-action user code here

                // write post-action user code here
            } else if (command == ManualUpdateKB) {
                // write pre-action user code here
                                
                AID agentID=new AID("KBAgent",AID.ISLOCALNAME);
                myAgent.updateCurrentLocation(agentID,LatTxtFld.getString(),
                        LonTxtFld.getString(),AltTxtFld.getString(),
                        SpeedTxtFld.getString());
                // write post-action user code here
            }else if (command == GpsLoggingCmd) {
                // write pre-action user code here
                try{
                     blueGpsThread = new BlueGpsThread(this);
                     blueGpsThread.start(); // Start  BlueDiscoveryThread
                     blueGpsThreadStarted=true;
                     LogsForm.append("Blue discovery sucess\n");
                }catch(Exception e){
                        blueGpsThreadStarted=false;
                        LogsForm.append("Blue discovery FAILED:"+e.toString()+"\n");
                }

                // write post-action user code here
            } else if (command == backCommand1) {
                // write pre-action user code here
                switchDisplayable(null, getPBVCForm());
                // write post-action user code here
            } else if (command == okCommand1) {
                // write pre-action user code here

                // write post-action user code here
            }
        } else if (displayable == PlaceSenseForm) {
             if (command == CommunityContributeCmd) {
                // Sensing and cascading insertion
                  try{
                    //BlueDiscoveryThread(MobileUserAgentGUI  MIDlet, boolean FileOrWS,
                    // boolean bCascadingInsertion, boolean bPlaceAwareAirportPickp)
                     blueDiscoveryThread = new BlueDiscoveryThread(this);
                     blueDiscoveryThread.start(); // Start  BlueDiscoveryThread
                     blueDiscoveryThreadStarted=true;
                     LogsForm.append("Community sensing ok\n");
                    }catch(Exception e){
                        blueDiscoveryThreadStarted=false;
                        LogsForm.append("Community sensing FAILED:"+e.toString()+"\n");
                    }
            } else if (command == StartSensingCmd) {
                // write pre-action user code here
                
                // write post-action user code here
            } else if (command == StopSensingCmd) {
                // write pre-action user code here

                // write post-action user code here
            } else if (command == backCommand2) {
                // write pre-action user code here
                switchDisplayable(null, getPBVCForm());
                // write post-action user code here
            }
        } else if (displayable == SemanticPlaceBrowserForm) {
             if (command == SPARQLcmd) {
                // write pre-action user code here
                switchDisplayable(null, getSparqlForm());
                // write post-action user code here
             } else if (command == backCommand3) {
                // write pre-action user code here
                switchDisplayable(null, getPBVCForm());
                // write post-action user code here
            }
        }else if (displayable == SparqlForm) {
            if (command == ClearScreen) {
                // write pre-action user code here
                SparqlForm.setString("");
                SparqlResult.deleteAll();
                // write post-action user code here
            }
            if (command == SubmitSparqlCmd) {
                // write pre-action user code here
                AID agentID=new AID("KBAgent",AID.ISLOCALNAME);
                String sQueries=SparqlForm.getString().trim();
                myAgent.sendSparql(agentID,sQueries);                
                switchDisplayable(null, getSparqlResult());
                // write post-action user code here
            } else if (command == backCommand5) {
                // write pre-action user code here
                switchDisplayable(null, getSemanticPlaceBrowserForm());
                // write post-action user code here
            }
        }else if (displayable == SparqlResult) {
            if (command == ClearSPARQLResultCmd) {
                // write pre-action user code here
                SparqlResult.deleteAll();
                // write post-action user code here
            }if (command == List.SELECT_COMMAND) {
                // write pre-action user code here
                SparqlResultAction();
                // write post-action user code here
            } else if (command == backCommand8) {
                // write pre-action user code here
                switchDisplayable(null, getSparqlForm());
                // write post-action user code here
            }
        }
        // write post-action user code here
    }

    /**
     * Performs an action assigned to the selected list element in the SparqlResult component.
     */
    public void SparqlResultAction() {
        // enter pre-action user code here
        String __selectedString = getSparqlResult().getString(getSparqlResult().getSelectedIndex());
        if (__selectedString != null) {
            if (__selectedString.equals("List Element 1")) {
                // write pre-action user code here

                // write post-action user code here
            } else if (__selectedString.equals("List Element 2")) {
                // write pre-action user code here

                // write post-action user code here
            }
        }
        // enter post-action user code here
    }

    /**
     * Returns an initiliazed instance of ClearSPARQLResultCmd component.
     * @return the initialized component instance
     */
    public Command getClearSPARQLResultCmd() {
        if (ClearSPARQLResultCmd == null) {
            // write pre-init user code here
            ClearSPARQLResultCmd = new Command("Clear screen", Command.ITEM, 0);
            // write post-init user code here
        }
        return ClearSPARQLResultCmd;
    }

    public List getSparqlResult() {
        if (SparqlResult == null) {
            // write pre-init user code here
            SparqlResult = new List("SPARQL Results", Choice.IMPLICIT);            
            SparqlResult.addCommand(getBackCommand8());
            SparqlResult.addCommand(getClearSPARQLResultCmd());
            SparqlResult.setCommandListener(this);
            SparqlResult.setSelectedFlags(new boolean[] { false, false });
            // write post-init user code here
        }
        return SparqlResult;
    }
    
   /**
     * Returns an initiliazed instance of ClearScreen component.
     * @return the initialized component instance
     */
    public Command getClearScreen() {
        if (ClearScreen == null) {
            // write pre-init user code here
            ClearScreen = new Command("Clear Screen", Command.ITEM, 0);
            // write post-init user code here
        }
        return ClearScreen;
    }

   public TextBox getSparqlForm() {
        if (SparqlForm == null) {
            // write pre-init user code here
            SparqlForm = new TextBox("Customize Sparql", " select ?people where {?people rdf:type :Person}",1024, TextField.ANY);
            SparqlForm.addCommand(backCommand5);
            SparqlForm.addCommand(getClearScreen());
            SparqlForm.addCommand(SubmitSparqlCmd);
            SparqlForm.setCommandListener(this);
            // write post-init user code here
        }
        return SparqlForm;
    }

    /**
     * Returns an initiliazed instance of LoginForm component.
     * @return the initialized component instance
     */
    

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
     * Returns an initiliazed instance of PBVCForm component.
     * @return the initialized component instance
     */
    public Form getPBVCForm() {
        if (PBVCForm == null) {
            // write pre-init user code here
            PBVCForm = new Form("Welcome to PBVC", new Item[] { getCommunityStringItem(), getStringItem(), getTextField() });
            PBVCForm.addCommand(backCommand);
            PBVCForm.addCommand(PlaceAware);
            PBVCForm.addCommand(PlaceSense);
            PBVCForm.addCommand(SemanticPlaceBrowser);
            PBVCForm.setCommandListener(this);
            // write post-init user code here
        }
        return PBVCForm;
    }

    /**
     * Returns an initiliazed instance of CommunityStringItem component.
     * @return the initialized component instance
     */
    public StringItem getCommunityStringItem() {
        if (CommunityStringItem == null) {
            // write pre-init user code here
            CommunityStringItem = new StringItem("Current Community", null);
            // write post-init user code here
        }
        return CommunityStringItem;
    }

    /**
     * Returns an initiliazed instance of stringItem component.
     * @return the initialized component instance
     */
    public StringItem getStringItem() {
        if (stringItem == null) {
            // write pre-init user code here
            stringItem = new StringItem("Receiving Message", null);
            // write post-init user code here
        }
        return stringItem;
    }

    public Command getBackCommand8() {
        if (backCommand8 == null) {
            // write pre-init user code here
            backCommand8 = new Command("Back", Command.BACK, 0);
            // write post-init user code here
        }
        return backCommand8;
    }

    /**
     * Returns an initiliazed instance of textField component.
     * @return the initialized component instance
     */
    public TextField getTextField() {
        if (textField == null) {
            // write pre-init user code here
            textField = new TextField("Message to Send", null, 32, TextField.ANY);
            // write post-init user code here
        }
        return textField;
    }

    /**
     * Returns an initiliazed instance of OfflineForm component.
     * @return the initialized component instance
     */
    public Form getOfflineForm() {
        if (OfflineForm == null) {
            // write pre-init user code here
            OfflineForm = new Form("form1");
            // write post-init user code here
        }
        return OfflineForm;
    }


    public StringItem getGSMCellBroadCastSI() {
        if (GSMCellBroadCastSI == null) {
            // write pre-init user code here
            GSMCellBroadCastSI = new StringItem("GSM Tower/Cell", null);
            // write post-init user code here
        }
        return GSMCellBroadCastSI;
    }
    public ChoiceGroup getCurrentPosGrp() {
        if (CurrentPosGrp == null) {
            // write pre-init user code here
            CurrentPosGrp = new ChoiceGroup("Current Position", Choice.POPUP);
            CurrentPosGrp.append("Latitude:", null);
            CurrentPosGrp.append("Longitude:", null);
            CurrentPosGrp.append("Altitude:", null);
            CurrentPosGrp.append("Speed:", null);
            CurrentPosGrp.setSelectedFlags(new boolean[] { false, false, false, false });
            // write post-init user code here
        }
        return CurrentPosGrp;
    }

    public Command getStartSensingCmd() {
        if (StartSensingCmd == null) {
            // write pre-init user code here
            StartSensingCmd = new Command("Start Sensing", Command.ITEM, 0);
            // write post-init user code here
        }
        return StartSensingCmd;
    }
    public Command getStopSensingCmd() {
        if (StopSensingCmd == null) {
            // write pre-init user code here
            StopSensingCmd = new Command("StopSensing", Command.ITEM, 0);
            // write post-init user code here
        }
        return StopSensingCmd;
    }

    public Command getCommunityContributeCmd() {
        if (CommunityContributeCmd == null) {
            // write pre-init user code here
            CommunityContributeCmd = new Command("Community contributing", Command.ITEM, 0);
            // write post-init user code here
        }
        return CommunityContributeCmd;
    }
    
    public ChoiceGroup getOptionsGrp() {
        if (OptionsGrp == null) {
            // write pre-init user code here
            OptionsGrp = new ChoiceGroup("Options", Choice.MULTIPLE);
            OptionsGrp.append("Context-Aware", null);
            OptionsGrp.append("Anonymously Contributed", null);
            OptionsGrp.setSelectedFlags(new boolean[] { true, true });
            // write post-init user code here
        }
        return OptionsGrp;
    }
    public ChoiceGroup getOptions() {
        if (Options == null) {
            // write pre-init user code here
            Options = new ChoiceGroup("Options", Choice.MULTIPLE);
            Options.append("Cascading Insertion", null);
            Options.setSelectedFlags(new boolean[] { true });
            // write post-init user code here
        }
        return Options;
    }
    
    public Form getPlaceSenseForm() {
        if (PlaceSenseForm == null) {
            // write pre-init user code here
            PlaceSenseForm = new Form("PlaceSense", new Item[] { getGSMCellBroadCastSI(),
            getPlaceSenseBlueDevicesGrp(), getCurrentPosGrp(), getOptions() });
            PlaceSenseForm.addCommand(backCommand2);
            PlaceSenseForm.addCommand(getStartSensingCmd());
            PlaceSenseForm.addCommand(getStopSensingCmd());
            PlaceSenseForm.addCommand(getCommunityContributeCmd());
            PlaceSenseForm.setCommandListener(this);
            // write post-init user code here
        }
        return PlaceSenseForm;
    }

      public Command getSPARQLcmd() {
        if (SPARQLcmd == null) {
            // write pre-init user code here
            SPARQLcmd = new Command("Customize Sparql ", Command.ITEM, 0);
            // write post-init user code here
        }
        return SPARQLcmd;
    }

    public Command getBackCommand3() {
        if (backCommand3 == null) {
            // write pre-init user code here
            backCommand3 = new Command("Back", Command.BACK, 0);
            // write post-init user code here
        }
        return backCommand3;
    }


    public Command getBackCommand7() {
        if (backCommand7 == null) {
            // write pre-init user code here
            backCommand7 = new Command("Back", Command.BACK, 0);
            // write post-init user code here
        }
        return backCommand7;
    }

    /**
     * Returns an initiliazed instance of SemanticPlaceBrowserForm component.
     * @return the initialized component instance
     */
     public Form getSemanticPlaceBrowserForm() {
        if (SemanticPlaceBrowserForm == null) {
            // write pre-init user code here
            SemanticPlaceBrowserForm = new Form("Semantic PlaceBrowser", new Item[] { getTextField() });
            SemanticPlaceBrowserForm.addCommand(getBackCommand3());
            SemanticPlaceBrowserForm.addCommand(getSPARQLcmd());
            SemanticPlaceBrowserForm.setCommandListener(this);
            // write post-init user code here
        }
        return SemanticPlaceBrowserForm;
    }

     public Command getLogScreenCmd2() {
        if (LogScreenCmd2 == null) {
            // write pre-init user code here
            LogScreenCmd2 = new Command("Show logs", Command.ITEM, 0);
            // write post-init user code here
        }
        return LogScreenCmd2;
    }
    /**
     * Returns an initiliazed instance of PlaceAwareForm component.
     * @return the initialized component instance
     */
    public Form getPlaceAwareForm() {
        if (PlaceAwareForm == null) {
            // write pre-init user code here

            PlaceAwareForm = new Form("Place Aware", new Item[] { 
                LocalBlueID, LatTxtFld, LonTxtFld,
                AltTxtFld, SpeedTxtFld});
            PlaceAwareForm.addCommand(backCommand1);
            PlaceAwareForm.addCommand(okCommand1);
            PlaceAwareForm.addCommand(AutoUpdateKB);
            PlaceAwareForm.addCommand(ManualUpdateKB);            
            PlaceAwareForm.addCommand(getLogScreenCmd2());
            PlaceAwareForm.addCommand(getAirportPickupCmd());
            PlaceAwareForm.addCommand(getGpsLoggingCmd());
            PlaceAwareForm.setCommandListener(this);
            // write post-init user code here
        }
        return PlaceAwareForm;
    }

    /**
     * Returns an initiliazed instance of LatTxtFld component.
     * @return the initialized component instance
     */
    public TextField getLatTxtFld() {
        if (LatTxtFld == null) {
            // write pre-init user code here
            LatTxtFld = new TextField("Latitude", "10.25", 32, TextField.ANY);
            // write post-init user code here
        }
        return LatTxtFld;
    }

    /**
     * Returns an initiliazed instance of LonTxtFld component.
     * @return the initialized component instance
     */
    public TextField getLonTxtFld() {
        if (LonTxtFld == null) {
            // write pre-init user code here
            LonTxtFld = new TextField("Longitude", "45.23", 32, TextField.ANY);
            // write post-init user code here
        }
        return LonTxtFld;
    }

    /**
     * Returns an initiliazed instance of AltTxtFld component.
     * @return the initialized component instance
     */
    public TextField getAltTxtFld() {
        if (AltTxtFld == null) {
            // write pre-init user code here
            AltTxtFld = new TextField("Altitude", "20", 32, TextField.ANY);
            // write post-init user code here
        }
        return AltTxtFld;
    }

    /**
     * Returns an initiliazed instance of SpeedTxtFld component.
     * @return the initialized component instance
     */
    public TextField getSpeedTxtFld() {
        if (SpeedTxtFld == null) {
            // write pre-init user code here
            SpeedTxtFld = new TextField("Speed (km/h)", "89", 32, TextField.ANY);
            // write post-init user code here
        }
        return SpeedTxtFld;
    }


    /**
     * Returns an initiliazed instance of OfflineMode component.
     * @return the initialized component instance
     */
    public Command getOfflineMode() {
        if (OfflineMode == null) {
            // write pre-init user code here
            OfflineMode = new Command("Item", Command.ITEM, 0);
            // write post-init user code here
        }
        return OfflineMode;
    }

    /**
     * Returns an initiliazed instance of PlaceAware component.
     * @return the initialized component instance
     */
    public Command getPlaceAware() {
        if (PlaceAware == null) {
            // write pre-init user code here
            PlaceAware = new Command("PlaceAware", Command.ITEM, 0);
            // write post-init user code here
        }
        return PlaceAware;
    }

    /**
     * Returns an initiliazed instance of PlaceSense component.
     * @return the initialized component instance
     */
    public Command getPlaceSense() {
        if (PlaceSense == null) {
            // write pre-init user code here
            PlaceSense = new Command("Item", Command.ITEM, 0);
            // write post-init user code here
        }
        return PlaceSense;
    }

    /**
     * Returns an initiliazed instance of SemanticPlaceBrowser component.
     * @return the initialized component instance
     */
    public Command getSemanticPlaceBrowser() {
        if (SemanticPlaceBrowser == null) {
            // write pre-init user code here
            SemanticPlaceBrowser = new Command("Item", Command.ITEM, 0);
            // write post-init user code here
        }
        return SemanticPlaceBrowser;
    }

    /////////////////////////////////////////////////
     public Form getAirportPickupForm() {
        if (AirportPickupForm == null) {
            // write pre-init user code here
            AirportPickupForm = new Form("Airport pickup", new Item[] { getDeviceNameTF(),
            getDeviceMACTF(), getFindingDeviceGrp(), getDiscoveredDeviceGrp() });
            AirportPickupForm.addCommand(getAddDeviceCmd());
            AirportPickupForm.addCommand(getClearAllCmd());
            AirportPickupForm.addCommand(getBackCommand7());
            AirportPickupForm.addCommand(getRemoveItemCmd());
            AirportPickupForm.addCommand(getStartFindingCmd());
            AirportPickupForm.setCommandListener(this);
            // write post-init user code here
        }
        return AirportPickupForm;
    }
     public TextField getDeviceNameTF() {
        if (DeviceNameTF == null) {
            // write pre-init user code here
            DeviceNameTF = new TextField("Device Name", null, 32, TextField.ANY);
            // write post-init user code here
        }
        return DeviceNameTF;
    }

    /**
     * Returns an initiliazed instance of DeviceMACTF component.
     * @return the initialized component instance
     */
    public TextField getDeviceMACTF() {
        if (DeviceMACTF == null) {
            // write pre-init user code here
            DeviceMACTF = new TextField("MAC address", null, 32, TextField.ANY);
            // write post-init user code here
        }
        return DeviceMACTF;
    }


    /**
     * Returns an initiliazed instance of FindingDeviceGrp component.
     * @return the initialized component instance
     */
    public ChoiceGroup getFindingDeviceGrp() {
        if (FindingDeviceGrp == null) {
            // write pre-init user code here
            FindingDeviceGrp = new ChoiceGroup("Finding device list", Choice.POPUP);
            FindingDeviceGrp.setSelectedFlags(new boolean[] {  });
            // write post-init user code here
        }
        return FindingDeviceGrp;
    }




    /**
     * Returns an initiliazed instance of DiscoveredDeviceGrp component.
     * @return the initialized component instance
     */
    public ChoiceGroup getDiscoveredDeviceGrp() {
        if (DiscoveredDeviceGrp == null) {
            // write pre-init user code here
            DiscoveredDeviceGrp = new ChoiceGroup("Discovered device list", Choice.MULTIPLE);
            // write post-init user code here
        }
        return DiscoveredDeviceGrp;
    }

    /**
     * Returns an initiliazed instance of backCommand6 component.
     * @return the initialized component instance
     */
    public Command getBackCommand6() {
        if (backCommand6 == null) {
            // write pre-init user code here
            backCommand6 = new Command("Back", Command.BACK, 0);
            // write post-init user code here
        }
        return backCommand6;
    }




    /**
     * Returns an initiliazed instance of AirportPickupCmd component.
     * @return the initialized component instance
     */
    public Command getAirportPickupCmd() {
        if (AirportPickupCmd == null) {
            // write pre-init user code here
            AirportPickupCmd = new Command("Airport Pickup Service", Command.ITEM, 0);
            // write post-init user code here
        }
        return AirportPickupCmd;
    }

    /**
     * Returns an initiliazed instance of AddDeviceCmd component.
     * @return the initialized component instance
     */
    public Command getAddDeviceCmd() {
        if (AddDeviceCmd == null) {
            // write pre-init user code here
            AddDeviceCmd = new Command("Add device", Command.ITEM, 0);
            // write post-init user code here
        }
        return AddDeviceCmd;
    }





//////////////////////////////////////////////////////////////////////////////
    

    public void UpdateLocation(String sLat, String sLon, String sAlt,
            String sSpeed, String sTimestamp) {
        String sUserAgent=sLocalAgentName;
        LatTxtFld.setString(sLat);
        LonTxtFld.setString(sLon);
        AltTxtFld.setString(sAlt);
        SpeedTxtFld.setString(sSpeed);
        
    }

    public void UpdateBluetoothDiscovered(String sLat, String sLon, String sAlt,
                            String sMAC,String sFriendlyName,String sTimestamp,
                            String sPlace, String sSpeed,String sUserAgent,
                            boolean bCascadingInsertion){     
        /*
         If Cascading insertion is selected, ask the MUA to send person found at place.
         * String sUserAgent is the owner of that Bluetooth device. 
         */

         GotBluetoothDevice discoveredDevice= new GotBluetoothDevice();
         discoveredDevice.setGotBluetoothDeviceMAC(sMAC);
         discoveredDevice.setGotBluetoothDeviceName(sFriendlyName);
         discoveredDevice.setGotBluetoothTimestamp(sTimestamp);
         discoveredDevice.setGotBluetoothDeviceAtPlace(sPlace);



         discoveredDevice.setGotBluetoothDeviceAtLAT(sLat);
         discoveredDevice.setGotBluetoothDeviceAtLON(sLon);
         discoveredDevice.setGotBluetoothDeviceAtAlt(sAlt);
         discoveredDevice.setGotBluetoothDeviceSPEED(sSpeed);

         AID agentID=new AID("KBAgent",AID.ISLOCALNAME);
         //myAgent.cascadingInsertionBluedevice(discoveredDevice,agentID);
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
        LocalBlueID.setText(string);
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

    public void updateCellBroadcast(String msgReceived) {
        GSMCellBroadCastSI.setText(msgReceived);
        globalCellBroadCast=msgReceived;
    }

    public void updateSparqlResults(String string) {
        SparqlResult.append(string, null);
    }



}
