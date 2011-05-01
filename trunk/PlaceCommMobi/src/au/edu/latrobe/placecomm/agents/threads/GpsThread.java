/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package au.edu.latrobe.placecomm.agents.threads;

/**
 *
 * @author ATuan
 */


import java.util.Calendar;
import java.util.Date;
import javax.microedition.location.*;
import au.edu.latrobe.placecomm.agents.*;


/**
 *
 * @author tuannguyen
 */
public class GpsThread extends Thread {

    private MobileUserAgentGUIDesign  MIDlet;
    private int _interval = -1;
    private Criteria cr;
    private LocationProvider lp;

    private Coordinates cLastKnownCoordinates=null;
    public  boolean allDone = false;

    public GpsThread(MobileUserAgentGUIDesign  MIDlet)  {
        //super();
        this.MIDlet =MIDlet ;

	}

    private void InitGPS() {

        // Set criteria for selecting a location provider:
        try {
        cr= new Criteria();
        cr.setCostAllowed(true);
        cr.setPreferredResponseTime(60);
        cr.setHorizontalAccuracy(5000);
        cr.setVerticalAccuracy(5000);
        cr.setAltitudeRequired(true);
        cr.isSpeedAndCourseRequired();
        cr.isAddressInfoRequired();

        System.out.println("Init CR done");
            lp = LocationProvider.getInstance(cr);

	}
	catch(LocationException le)
	{
            System.out.println("LocationException");
        }
    }


 public Coordinates GetGPS() throws LocationException, InterruptedException {
        Location l;
        Coordinates c=null;
        try {
            // Request the location, setting a one-minute timeout

            l = lp.getLocation(60);

            c = l.getQualifiedCoordinates();

            if (c != null) {
                  cLastKnownCoordinates = c;
                  double lat = c.getLatitude();
                  double lon = c.getLongitude();
                  double alt = c.getAltitude();
                  float speed =  l.getSpeed(); // m/s

                     speed = speed * 3600/1000; // km/h
                  Date mDate=new Date();
                  ;

                  String strGPS = "Speed:"+speed+",Lat:"+lat+",Lon:"+
                                  lon+",alt:"+alt+",T:"+mDate.toString()+"\n";

                  //MIDlet.LogScreenAppend(strGPS);


                 }else {
                  double lat = cLastKnownCoordinates.getLatitude();
                  double lon = cLastKnownCoordinates.getLongitude();
                  double alt = cLastKnownCoordinates.getAltitude();
                  float speed =  l.getSpeed();
                  String strGPS = "Speed:"+speed+",Lat:"+lat+",Lon:"+
                          lon+",alt:"+alt;

                  //MIDlet.LogScreenAppend("Last known");
                  //MIDlet.LogScreenAppend(strGPS);
                 }
        } catch (LocationException ex) {
            ex.printStackTrace();
        }
        return c;
    }

   public void start()
  {
    Thread thread = new Thread(this);
    try
    {
      //System.out.println("thread.start()");
      thread.start(); // Call run

    }
    catch (Exception error)
    {
    }
  }
   public void run() {
     try {
         InitGPS();
        while (true){
           GetGPS();
           Thread.sleep(1000);
           if (allDone){

               //MIDlet.LogScreenAppend("Stop GPS");
               return;
           }
         }
     }
     catch (Exception error) {
         System.err.println(error.toString());
     }
    }
}