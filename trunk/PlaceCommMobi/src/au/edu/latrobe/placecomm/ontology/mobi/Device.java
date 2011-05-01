package au.edu.latrobe.placecomm.ontology.mobi;


import jade.content.abs.*;
import jade.content.onto.*;
import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: Device
* @author ontology bean generator
* @version 2010/12/27, 16:31:17
*/
public class Device implements Concept, Introspectable {

   /**
* Protege name: DeviceID
   */
   private String deviceID;
   public void setDeviceID(String value) { 
    this.deviceID=value;
   }
   public String getDeviceID() {
     return this.deviceID;
   }

   /**
* Protege name: hasOwner
   */
   private List hasOwner = new ArrayList();
   public void addHasOwner(Object elem) { 
     List oldList = this.hasOwner;
     hasOwner.add(elem);
   }
   public boolean removeHasOwner(Object elem) {
     List oldList = this.hasOwner;
     boolean result = hasOwner.remove(elem);
     return result;
   }
   public void clearAllHasOwner() {
     List oldList = this.hasOwner;
     hasOwner.clear();
   }
   public Iterator getAllHasOwner() {return hasOwner.iterator(); }
   public List getHasOwner() {return hasOwner; }
   public void setHasOwner(List l) {hasOwner = l; }

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
* Protege name: devicePresenceAtPlace
   */
   private List devicePresenceAtPlace = new ArrayList();
   public void addDevicePresenceAtPlace(Place elem) { 
     List oldList = this.devicePresenceAtPlace;
     devicePresenceAtPlace.add(elem);
   }
   public boolean removeDevicePresenceAtPlace(Place elem) {
     List oldList = this.devicePresenceAtPlace;
     boolean result = devicePresenceAtPlace.remove(elem);
     return result;
   }
   public void clearAllDevicePresenceAtPlace() {
     List oldList = this.devicePresenceAtPlace;
     devicePresenceAtPlace.clear();
   }
   public Iterator getAllDevicePresenceAtPlace() {return devicePresenceAtPlace.iterator(); }
   public List getDevicePresenceAtPlace() {return devicePresenceAtPlace; }
   public void setDevicePresenceAtPlace(List l) {devicePresenceAtPlace = l; }

   /**
* Protege name: hasDeviceContext
   */
   private List hasDeviceContext = new ArrayList();
   public void addHasDeviceContext(DeviceContext elem) { 
     List oldList = this.hasDeviceContext;
     hasDeviceContext.add(elem);
   }
   public boolean removeHasDeviceContext(DeviceContext elem) {
     List oldList = this.hasDeviceContext;
     boolean result = hasDeviceContext.remove(elem);
     return result;
   }
   public void clearAllHasDeviceContext() {
     List oldList = this.hasDeviceContext;
     hasDeviceContext.clear();
   }
   public Iterator getAllHasDeviceContext() {return hasDeviceContext.iterator(); }
   public List getHasDeviceContext() {return hasDeviceContext; }
   public void setHasDeviceContext(List l) {hasDeviceContext = l; }

   /**
* Protege name: hostsAgent
   */
   private List hostsAgent = new ArrayList();
   public void addHostsAgent(Agent elem) { 
     List oldList = this.hostsAgent;
     hostsAgent.add(elem);
   }
   public boolean removeHostsAgent(Agent elem) {
     List oldList = this.hostsAgent;
     boolean result = hostsAgent.remove(elem);
     return result;
   }
   public void clearAllHostsAgent() {
     List oldList = this.hostsAgent;
     hostsAgent.clear();
   }
   public Iterator getAllHostsAgent() {return hostsAgent.iterator(); }
   public List getHostsAgent() {return hostsAgent; }
   public void setHostsAgent(List l) {hostsAgent = l; }

  public void externalise(AbsObject absObj, Ontology onto) throws OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      abs.set(PlacecommOntology.DEVICE_DEVICEID, (AbsTerm) onto.fromObject(getDeviceID()));
      abs.set(PlacecommOntology.DEVICE_HASOWNER, (AbsTerm) onto.fromObject(getHasOwner()));
      abs.set(PlacecommOntology.DEVICE_MACADDRESS, (AbsTerm) onto.fromObject(getMACAddress()));
      abs.set(PlacecommOntology.DEVICE_DEVICEPRESENCEATPLACE, (AbsTerm) onto.fromObject(getDevicePresenceAtPlace()));
      abs.set(PlacecommOntology.DEVICE_HASDEVICECONTEXT, (AbsTerm) onto.fromObject(getHasDeviceContext()));
      abs.set(PlacecommOntology.DEVICE_HOSTSAGENT, (AbsTerm) onto.fromObject(getHostsAgent()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising Device");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      deviceID = (String)onto.toObject(abs.getAbsObject(PlacecommOntology.DEVICE_DEVICEID));
      hasOwner = (List)onto.toObject(abs.getAbsObject(PlacecommOntology.DEVICE_HASOWNER));
      macAddress = (String)onto.toObject(abs.getAbsObject(PlacecommOntology.DEVICE_MACADDRESS));
      devicePresenceAtPlace = (List)onto.toObject(abs.getAbsObject(PlacecommOntology.DEVICE_DEVICEPRESENCEATPLACE));
      hasDeviceContext = (List)onto.toObject(abs.getAbsObject(PlacecommOntology.DEVICE_HASDEVICECONTEXT));
      hostsAgent = (List)onto.toObject(abs.getAbsObject(PlacecommOntology.DEVICE_HOSTSAGENT));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising Device");
     }
   }

}
