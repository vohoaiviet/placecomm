package au.edu.latrobe.placecomm.ontology.j2me;


import jade.content.abs.*;
import jade.content.onto.*;
import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: Device
* @author ontology bean generator
* @version 2011/04/28, 11:06:23
*/
public class Device implements Predicate, Introspectable {

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

  public void externalise(AbsObject absObj, Ontology onto) throws OntologyException {
    try {
      AbsPredicate abs = (AbsPredicate) absObj;
      abs.set(PlaceCommOntology.DEVICE_DEVICENAME, (AbsTerm) onto.fromObject(getDeviceName()));
      abs.set(PlaceCommOntology.DEVICE_HASOWNER, (AbsTerm) onto.fromObject(getHasOwner()));
      abs.set(PlaceCommOntology.DEVICE_DEVICEID, (AbsTerm) onto.fromObject(getDeviceID()));
      abs.set(PlaceCommOntology.DEVICE_MACADDRESS, (AbsTerm) onto.fromObject(getMACAddress()));
      abs.set(PlaceCommOntology.DEVICE_MANUFACTURER, (AbsTerm) onto.fromObject(getManufacturer()));
      abs.set(PlaceCommOntology.DEVICE_DEVICEPRESENCE, (AbsTerm) onto.fromObject(getDevicePresence()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising Device");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException {
    try {
      AbsPredicate abs = (AbsPredicate) absObj;
      deviceName = (String)onto.toObject(abs.getAbsObject(PlaceCommOntology.DEVICE_DEVICENAME));
      hasOwner = (Person)onto.toObject(abs.getAbsObject(PlaceCommOntology.DEVICE_HASOWNER));
      deviceID = (String)onto.toObject(abs.getAbsObject(PlaceCommOntology.DEVICE_DEVICEID));
      macAddress = (String)onto.toObject(abs.getAbsObject(PlaceCommOntology.DEVICE_MACADDRESS));
      manufacturer = (String)onto.toObject(abs.getAbsObject(PlaceCommOntology.DEVICE_MANUFACTURER));
      devicePresence = (Place)onto.toObject(abs.getAbsObject(PlaceCommOntology.DEVICE_DEVICEPRESENCE));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising Device");
     }
   }

}
