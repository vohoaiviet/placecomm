/*
 *  Tuan Anh Nguyen.  Email: t.nguyen@latrobe.edu.au
 * Computer Science & Computer Engineering Department
 * La Trobe University, VIC, 3086
 */

package utilities;

/**
 *
 * @author Tuan Nguyen
 */
import com.dalsemi.onewire.OneWireAccessProvider;
import com.dalsemi.onewire.adapter.DSPortAdapter;
import com.dalsemi.onewire.container.OneWireContainer;

 
import java.util.Calendar;
import java.util.Enumeration;
import java.net.*;
import java.util.GregorianCalendar;
import java.util.Iterator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.sound.sampled.*;
import java.sql.*;

import org.w3c.dom.NodeList;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import org.apache.xerces.parsers.*;
import org.w3c.dom.Document;

import jade.core.Agent;
import jade.core.AID;
import jade.core.behaviours.*;

 

/**
 *
 * @author at6nguyen
 */
public class SensorIbuttonAgent extends Agent {
    private ThreadedBehaviourFactory tbf = new ThreadedBehaviourFactory();
   
    private String discovererSubId, widgetSubId;
    public static final int DEFAULT_PORT = 5555;
    public static boolean DEBUG = true;

    // Audio processing
    AudioFormat audioFormat;
    AudioInputStream audioInputStream;
    SourceDataLine sourceDataLine;
    boolean stopPlayback = false;


    public static final String CLASSNAME = "SensorIbuttonAgent";

    /** Creates a new instance of SensorIbuttonAgent */
    public SensorIbuttonAgent() {
        // context.arch.widget.OffsetThread to a local NTP server.
        // Currently, the server is set to ntp1.gatech.edu. You'll get a faster response, i
    }


   /** This method is for getting username according to their
    * iButtons ID. The users database is stored in the localusers.xml file.
    * @param strID is an ibutton ID read by sensor.
    *
    */

   public static String IDtoUserXMLParser(String strID) {
    String strUserName="";
     try {
            DOMParser parser = new DOMParser();
            parser.parse("D:\\MyPhD\\Netbeans\\ContextJade\\src\\localusers.xml");
            Document doc = parser.getDocument();
            NodeList nodes = doc.getElementsByTagName("user");
            System.out.println("User ID is: " +doc.getElementById(strID));

            //System.out.println("Nodes: "+nodes.toString());

            System.out.println("There are " + nodes.getLength() + "  elements.");
            for (int i=0;  i < nodes.getLength(); i++  ){
                if (nodes.item(i).getAttributes().
                        getNamedItem("identification").
                         getTextContent().equals(strID)){
                 strUserName= nodes.item(i).getAttributes().
                                   getNamedItem("username").getTextContent() ;
                 System.out.println("username:"+strUserName);
                 break;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
       return strUserName;
   }

    /** This method logs the timestamp of userID and userName when he/she
     * docks the button to the reader.
     * @param strUserID String
     * @param strUsername  String
     * @param strHostName The host that database is running
     * @param strHostAddress The host that database is running
     * @param strDate A date string
     * @param iHour Hour
     * @param iMinute Minute
     * @param iSecond Second
     */
    private static void InsertToDatabase(String strUserID,String strUsername,
                                         String strHostName, String strHostAddress, String strDate,
                                         int iHour,int iMinute,int iSecond)

    {
        //String connectionURL = "jdbc:mysql://131.172.40.175:3306/Loca?user=loca;password=merdecitd2k2k";
        String strGetMaxTrackID="select TrackID from UserTrack where TrackID = (select max(TrackID) from UserTrack)";
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        String strQuery="";
        int iTrackID=0,iMaxTrackID=0;

        try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
        }
        catch(Exception ce){
            System.out.println(ce);
        }

        try{
            connection = DriverManager.getConnection(
                "jdbc:mysql://131.172.40.175/Loca","loca", "merdecitd2k2k");
            statement = connection.createStatement();
            rs = statement.executeQuery(strGetMaxTrackID);
            while (rs.next()){
                iMaxTrackID = rs.getInt("TrackID");
            }
            iTrackID= iMaxTrackID + 1;
/*
 insert into UserTrack (UserID, Username, HostName, HostAddress, Date, Hour, Minute,Second,TrackID)
 VALUES ('80000002FE639D14','Terminator','CS-AT6NGUYEN','131.172.40.173','2007-8-31','16','25','0','2')
 */
            strQuery = "insert into UserTrack (UserID, Username, HostName, HostAddress, Date, Hour, Minute,Second,TrackID) VALUES " +
                                               "('"+strUserID+"','"+strUsername+"','"+strHostName +"','"+
                                                    strHostAddress +"','"+ strDate +"','"+
                                                    iHour +"','"+ iMinute +"','"+iSecond +"','"+iTrackID+"' )";
             System.out.println("Query is: "+strQuery);
             statement.executeUpdate(strQuery);

             statement.close();
        }catch (Exception e){
            System.out.println("MySQL Connection Error");
        }

    }

    /** This is a thread of playAudio method. This is for playing an audio file
     * when some event happend
     *
     */
   class PlayThread extends Thread{
        byte tempBuffer[] = new byte[10000];

    public void run(){
    try{
      sourceDataLine.open(audioFormat);
      sourceDataLine.start();

      int cnt;
         while((cnt = audioInputStream.read(
           tempBuffer,0,tempBuffer.length)) != -1
                       && stopPlayback == false){
        if(cnt > 0){
          sourceDataLine.write(
                             tempBuffer, 0, cnt);
        }//end if
      }//end while
      //Block and wait for internal buffer of the
      // data line to empty.
      sourceDataLine.drain();
      sourceDataLine.close();


      stopPlayback = false;
    }catch (Exception e) {
      e.printStackTrace();
      System.exit(0);
    }//end catch
  }//end run
}//end inner class PlayThread
//===================================//

private void playAudio(String strFilename) {

    try{
      File soundFile = new File(strFilename);
      audioInputStream = AudioSystem.getAudioInputStream(soundFile);
      audioFormat = audioInputStream.getFormat();
      System.out.println(audioFormat);

      DataLine.Info dataLineInfo =
                          new DataLine.Info(
                            SourceDataLine.class,
                                    audioFormat);

      sourceDataLine =
             (SourceDataLine)AudioSystem.getLine(
                                   dataLineInfo);

      //Create a thread to play back the data and
      // start it running.  It will run until the
      // end of file, or the Stop button is
      // clicked, whichever occurs first.
      // Because of the data buffers involved,
      // there will normally be a delay between
      // the click on the Stop button and the
      // actual termination of playback.
      new PlayThread().start();
    }catch (Exception e) {
      e.printStackTrace();
      System.exit(0);
    }//end catch
  }//end playAudio

    public void DoSomethingStrange() {
        OneWireContainer owd;
      String strExitButton="80000002FE639D14";
      String strButtonIDAddress="";
      String strLastAddress="";

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
         boolean bUndocked=false;
         String strAddress1="";
         String strHostAddress, strHostName, strDate, strTime, strTemp="";
         int    iHour, iMinute, iSecond, iDay, iMonth, iYear;
         while (! stop ){
         // clear any previous search restrictions
         adapter.setSearchAllDevices();
         adapter.targetAllFamilies();
         adapter.setSpeed(adapter.SPEED_REGULAR);
         // enumerate through all the 1-Wire devices found
         for (Enumeration owd_enum = adapter.getAllDeviceContainers();
                 owd_enum.hasMoreElements(); )
         {
            owd = ( OneWireContainer ) owd_enum.nextElement();
            strButtonIDAddress=owd.getAddressAsString();
            if (strAddress1.equals(strButtonIDAddress)) {
                // means that this is the second time so DO NOTHING
            } else {
                System.out.println("Button is Docked, address:" + strButtonIDAddress);
                strAddress1=strButtonIDAddress;
                /*
                 * Insert into MySQL database
                 * Data= ButtonID, HostName, HostAddress, Date, Time
                 */
                //strHostAddress=
                InetAddress localHost = InetAddress.getLocalHost();
                strHostName=localHost.getHostName();
                strHostAddress=localHost.getHostAddress();

                Calendar myDate = GregorianCalendar.getInstance();

                /*
                 Calendar calendar = GregorianCalendar.getInstance();
                System.out.println("year: " + calendar.get( Calendar.YEAR ) );

                 */

                iDay   = myDate.get(Calendar.DAY_OF_MONTH);
                iMonth = myDate.get(Calendar.MONTH)+1;
                iYear  = myDate.get(Calendar.YEAR);


                strDate= Integer.toString(iYear) +"-" +Integer.toString(iMonth) +"-" +Integer.toString(iDay);

                iHour   = myDate.get(Calendar.HOUR_OF_DAY);
                iMinute = myDate.get(Calendar.MINUTE);
                iSecond = myDate.get(Calendar.SECOND);

                strTime= Integer.toString(iHour)+":" +
                         Integer.toString(iMinute )+":" +
                         Integer.toString(iSecond );


                /* Insert Into Database  */
                String strUsername=IDtoUserXMLParser(strButtonIDAddress);
                //InsertToDatabase(strButtonIDAddress,strUsername, strHostName, strHostAddress,strDate,iHour,iMinute,iSecond);

                strTemp = strButtonIDAddress +"," +
                          strHostName +"," +
                          strHostAddress+"," +
                          strDate +"," +
                          strTime;
                System.out.println("Data to be inserted: " + strTemp);

                System.out.println("User "+ strUsername + " at door !");
                System.out.write(7);
                System.out.flush();
                try{
                    String strFilename="D:\\MyPhD\\Netbeans\\ContextJade\\build\\classes\\media\\sengloke.wav";
                    playAudio(strFilename);
                }catch (Exception e){
                    System.out.println("Exception "+e);
                }

            }
            // If the black iButton is docked, exit program
            if (strButtonIDAddress.equals(strExitButton)){
                stop=true;
                break;
            }
         }// end for
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
            DoSomethingStrange();
        }
      };
      addBehaviour(tbf.wrap(b));
    }


}
