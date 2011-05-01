package au.edu.latrobe.placecomm.ontology.j2se;


import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: Device
* @author ontology bean generator
* @version 2011/04/28, 11:06:16
*/
public class Device implements Predicate {

   /**
* Protege name: deviceName
   */
   private String deviceName;
   public void setDeviceName(String value) { 
    this.deviceName=value;
   }
   public String getDeviceName() {
     return this.deviceName;
   }

   /**
* Protege name: hasOwner
   */
   private Person hasOwner;
   public void setHasOwner(Person value) { 
    this.hasOwner=value;
   }
   public Person getHasOwner() {
     return this.hasOwner;
   }

   /**
* Protege name: deviceID
   */
   private String deviceID;
   public void setDeviceID(String value) { 
    this.deviceID=value;
   }
   public String getDeviceID() {
     return this.deviceID;
   }

   /**
* Protege name: MACAddress
   */
   private String macAddress;
   public void setMACAddress(String value) { 
    this.macAddress=value;
   }
   public String getMACAddress() {
     return this.macAddress;
   }

   /**
* Protege name: manufacturer
   */
   private String manufacturer;
   public void setManufacturer(String value) { 
    this.manufacturer=value;
   }
   public String getManufacturer() {
     return this.manufacturer;
   }

   /**
* Protege name: devicePresence
   */
   private Place devicePresence;
   public void setDevicePresence(Place value) { 
    this.devicePresence=value;
   }
   public Place getDevicePresence() {
     return this.devicePresence;
   }

}
