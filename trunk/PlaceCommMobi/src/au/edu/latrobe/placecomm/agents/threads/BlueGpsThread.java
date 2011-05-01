/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package au.edu.latrobe.placecomm.agents.threads;
 
import javax.microedition.location.*;
import au.edu.latrobe.placecomm.agents.*;
import java.util.Date;


/**
 *
 * @author tuannguyen
 */
public class BlueGpsThread extends Thread {

    private MobileUserAgentGUI  MIDlet;
    private int _interval = -1; // default as document
    
    private Criteria cr;
    private LocationProvider lp;
    private boolean bGPSOnly=false;
    
    public BlueGpsThread(MobileUserAgentGUI MIDlet)  {
       
        this.MIDlet =MIDlet ;
        
        
	}


    private void InitGPS() {
        
        // Set criteria for selecting a location provider:
        try {
        cr= new Criteria();
        //cr.setCostAllowed(true);
        cr.setPreferredResponseTime(60);
        cr.setHorizontalAccuracy(500);
        cr.setVerticalAccuracy(500);
        cr.setAltitudeRequired(true);
        cr.isSpeedAndCourseRequired();
        cr.isAddressInfoRequired();        
        
        //MIDlet.LogScreenAppend("Init CR done\n");

            lp = LocationProvider.getInstance(cr);
        //MIDlet.LogScreenAppend("lp = LocationProvider.getInstance(cr) done\n");
            if( lp!=null ){
              lp.setLocationListener(new LocationListenerImpl(),_interval,1,1);
          //    MIDlet.LogScreenAppend("lp.setLocationListener done\n");
            }                          
	}
	catch(LocationException le)
	{
            //MIDlet.LogScreenAppend("LocationException\n");
        }
    }

    void logGPSOnly(boolean b) {
        this.bGPSOnly=b;
    }
    
    private class LocationListenerImpl implements LocationListener { 
        
        public void locationUpdated(LocationProvider provider, Location location) {
	
            if(location.isValid()) {
                // These needed to be declared.  Don't have to be declared right here,
                // but they need to be declared *somewhere* that's visible from here.
                double longitude = location.getQualifiedCoordinates().getLongitude();
                double latitude = location.getQualifiedCoordinates().getLatitude();
                double altitude = location.getQualifiedCoordinates().getAltitude();
                float speed = location.getSpeed()*3600/1000;
                //the current ground speed in m/s for the terminal
                // or Float.NaN if the speed is not known
                // the speed is m/s
                //   1s    --> X m
                //   3600s --> y m (/1000 -> km) 

                 Date myDate=new Date();
                 long lTimestamp= myDate.getTime();

                String strGPS = "S:"+speed+",Lat:"+latitude+",Lon:"+ longitude+",alt:"+altitude;
                String sLat=Double.toString(latitude) ;
                String sLon=Double.toString(longitude);
                String sAlt=Double.toString(altitude);
                String sSpeed=Double.toString(speed);
                String sTimestamp=Double.toString(lTimestamp);

                try{
                MIDlet.gpsGlobal= strGPS;
                MIDlet.UpdateLocation(sLat,sLon,sAlt,sSpeed,sTimestamp);
                MIDlet.gpsGlobalLat=sLat;
                MIDlet.gpsGlobalLon=sLon;
                MIDlet.gpsGlobalAlt=sAlt;
                MIDlet.gpsGlobalSpeed=sSpeed;
               // MIDlet.LogScreenAppend(strGPS);
                if (bGPSOnly) {
                  //  MIDlet.mainListAppend(strGPS);
                }

                }catch(Exception e){
                    //MIDlet.LogScreenAppend(e.toString());
                }
            }else {
              //  MIDlet.LogScreenAppend("Location is not valid\n");
            }
        }
        
        public void providerStateChanged(LocationProvider provider, int newState) {
	// MUST implement this.  Should probably do something useful with it as well.
	}
    }
         
   


   public void stopThread(){
       this.interrupt();
       //MIDlet.LogScreenAppend("GPS logging Stopped\n");
       MIDlet.gpsGlobal="";
   }

  public void start()
  {
    Thread thread = new Thread(this);
    try
    {
        thread.start(); // Call run
    }
    catch (Exception error)
    {
        //MIDlet.LogScreenAppend("Thread start FAILED\n");
    }
  }
   public void run() {
     try {
         //MIDlet.LogScreenAppend("Before call run123\n");
         InitGPS(); 
         //MIDlet.LogScreenAppend("InitGPS started456\n");
     }
     catch (Exception error) {
         //MIDlet.LogScreenAppend(error.toString());
     }
    }    
}

/*
 Proximity
 try {

 	Criteria cr = new Criteria();
 	// Required Accuracy is set to 100 Meters
	provider = LocationProvider.getInstance(cr);
	// coordinates around which proximity has to be found
	Coordinates myCoordinates = new Coordinates(14.389796709, 50.099850027, 310);
	// Listener registration for above coordinates for proximity of 1000 meters.
	LocationProvider.addProximityListener(this, myCoordinate, 1000.0f);

	} catch (LocationException e) {

		e.printStackTrace();
	}

Code segment for proximityEvent()

public void proximityEvent(Coordinates arg0, Location arg1) {
	// Display results on form
	resultsForm = new Form("Proximity Result");
	String displayString = "You are presently within 1000 meters radius from Location
	\n\nLat: 14.389796709\nLong: 50.099850027" ;
	resultsForm.append(displayString);
	cmdExit = new Command("Exit", Command.SCREEN, 0);
	resultsForm.addCommand(cmdExit);
	display.setCurrent(resultsForm);
	resultsForm.setCommandListener(this);

}


 */