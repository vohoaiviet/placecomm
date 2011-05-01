package au.edu.latrobe.placecomm.ontology.mobi;


import jade.content.abs.*;
import jade.content.onto.*;
import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: gotBluetoothDevice
* @author ontology bean generator
* @version 2010/12/27, 16:31:17
*/
public class GotBluetoothDevice implements Predicate, Introspectable {

   /**
* Protege name: gotBluetoothDeviceAtLON
   */
   private String gotBluetoothDeviceAtLON;
   public void setGotBluetoothDeviceAtLON(String value) { 
    this.gotBluetoothDeviceAtLON=value;
   }
   public String getGotBluetoothDeviceAtLON() {
     return this.gotBluetoothDeviceAtLON;
   }

   /**
* Protege name: gotBluetoothDeviceAtAlt
   */
   private String gotBluetoothDeviceAtAlt;
   public void setGotBluetoothDeviceAtAlt(String value) { 
    this.gotBluetoothDeviceAtAlt=value;
   }
   public String getGotBluetoothDeviceAtAlt() {
     return this.gotBluetoothDeviceAtAlt;
   }

   /**
* Protege name: gotBluetoothTimestamp
   */
   private String gotBluetoothTimestamp;
   public void setGotBluetoothTimestamp(String value) { 
    this.gotBluetoothTimestamp=value;
   }
   public String getGotBluetoothTimestamp() {
     return this.gotBluetoothTimestamp;
   }

   /**
* Protege name: gotBluetoothDeviceSPEED
   */
   private String gotBluetoothDeviceSPEED;
   public void setGotBluetoothDeviceSPEED(String value) { 
    this.gotBluetoothDeviceSPEED=value;
   }
   public String getGotBluetoothDeviceSPEED() {
     return this.gotBluetoothDeviceSPEED;
   }

   /**
* Protege name: gotBluetoothDeviceAtPlace
   */
   private String gotBluetoothDeviceAtPlace;
   public void setGotBluetoothDeviceAtPlace(String value) {
    this.gotBluetoothDeviceAtPlace=value;
   }
   public String getGotBluetoothDeviceAtPlace() {
     return this.gotBluetoothDeviceAtPlace;
   }

   /**
* Protege name: gotBluetoothDeviceName
   */
   private String gotBluetoothDeviceName;
   public void setGotBluetoothDeviceName(String value) { 
    this.gotBluetoothDeviceName=value;
   }
   public String getGotBluetoothDeviceName() {
     return this.gotBluetoothDeviceName;
   }

   /**
* Protege name: gotBluetoothDeviceAtLAT
   */
   private String gotBluetoothDeviceAtLAT;
   public void setGotBluetoothDeviceAtLAT(String value) { 
    this.gotBluetoothDeviceAtLAT=value;
   }
   public String getGotBluetoothDeviceAtLAT() {
     return this.gotBluetoothDeviceAtLAT;
   }

   /**
* Protege name: gotBluetoothDeviceMAC
   */
   private String gotBluetoothDeviceMAC;
   public void setGotBluetoothDeviceMAC(String value) { 
    this.gotBluetoothDeviceMAC=value;
   }
   public String getGotBluetoothDeviceMAC() {
     return this.gotBluetoothDeviceMAC;
   }

  public void externalise(AbsObject absObj, Ontology onto) throws OntologyException {
    try {
      AbsPredicate abs = (AbsPredicate) absObj;
      abs.set(PlacecommOntology.GOTBLUETOOTHDEVICE_GOTBLUETOOTHDEVICEATLON, (AbsTerm) onto.fromObject(getGotBluetoothDeviceAtLON()));
      abs.set(PlacecommOntology.GOTBLUETOOTHDEVICE_GOTBLUETOOTHDEVICEATALT, (AbsTerm) onto.fromObject(getGotBluetoothDeviceAtAlt()));
      abs.set(PlacecommOntology.GOTBLUETOOTHDEVICE_GOTBLUETOOTHTIMESTAMP, (AbsTerm) onto.fromObject(getGotBluetoothTimestamp()));
      abs.set(PlacecommOntology.GOTBLUETOOTHDEVICE_GOTBLUETOOTHDEVICESPEED, (AbsTerm) onto.fromObject(getGotBluetoothDeviceSPEED()));
      abs.set(PlacecommOntology.GOTBLUETOOTHDEVICE_GOTBLUETOOTHDEVICEATCELL, (AbsTerm) onto.fromObject(getGotBluetoothDeviceAtPlace()));
      abs.set(PlacecommOntology.GOTBLUETOOTHDEVICE_GOTBLUETOOTHDEVICENAME, (AbsTerm) onto.fromObject(getGotBluetoothDeviceName()));
      abs.set(PlacecommOntology.GOTBLUETOOTHDEVICE_GOTBLUETOOTHDEVICEATLAT, (AbsTerm) onto.fromObject(getGotBluetoothDeviceAtLAT()));
      abs.set(PlacecommOntology.GOTBLUETOOTHDEVICE_GOTBLUETOOTHDEVICEMAC, (AbsTerm) onto.fromObject(getGotBluetoothDeviceMAC()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising GotBluetoothDevice");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException {
    try {
      AbsPredicate abs = (AbsPredicate) absObj;
      gotBluetoothDeviceAtLON = (String)onto.toObject(abs.getAbsObject(PlacecommOntology.GOTBLUETOOTHDEVICE_GOTBLUETOOTHDEVICEATLON));
      gotBluetoothDeviceAtAlt = (String)onto.toObject(abs.getAbsObject(PlacecommOntology.GOTBLUETOOTHDEVICE_GOTBLUETOOTHDEVICEATALT));
      gotBluetoothTimestamp = (String)onto.toObject(abs.getAbsObject(PlacecommOntology.GOTBLUETOOTHDEVICE_GOTBLUETOOTHTIMESTAMP));
      gotBluetoothDeviceSPEED = (String)onto.toObject(abs.getAbsObject(PlacecommOntology.GOTBLUETOOTHDEVICE_GOTBLUETOOTHDEVICESPEED));
      gotBluetoothDeviceAtPlace = (String)onto.toObject(abs.getAbsObject(PlacecommOntology.GOTBLUETOOTHDEVICE_GOTBLUETOOTHDEVICEATCELL));
      gotBluetoothDeviceName = (String)onto.toObject(abs.getAbsObject(PlacecommOntology.GOTBLUETOOTHDEVICE_GOTBLUETOOTHDEVICENAME));
      gotBluetoothDeviceAtLAT = (String)onto.toObject(abs.getAbsObject(PlacecommOntology.GOTBLUETOOTHDEVICE_GOTBLUETOOTHDEVICEATLAT));
      gotBluetoothDeviceMAC = (String)onto.toObject(abs.getAbsObject(PlacecommOntology.GOTBLUETOOTHDEVICE_GOTBLUETOOTHDEVICEMAC));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising GotBluetoothDevice");
     }
   }

}
