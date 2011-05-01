package au.edu.latrobe.placecomm.ontology.j2se;


import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: Location
* @author ontology bean generator
* @version 2011/04/28, 11:06:16
*/
public class Location implements Predicate {

   /**
* Protege name: lat
   */
   private String lat;
   public void setLat(String value) { 
    this.lat=value;
   }
   public String getLat() {
     return this.lat;
   }

   /**
* Protege name: speed
   */
   private String speed;
   public void setSpeed(String value) { 
    this.speed=value;
   }
   public String getSpeed() {
     return this.speed;
   }

   /**
* Protege name: alt
   */
   private String alt;
   public void setAlt(String value) { 
    this.alt=value;
   }
   public String getAlt() {
     return this.alt;
   }

   /**
* Protege name: lon
   */
   private String lon;
   public void setLon(String value) { 
    this.lon=value;
   }
   public String getLon() {
     return this.lon;
   }

}
