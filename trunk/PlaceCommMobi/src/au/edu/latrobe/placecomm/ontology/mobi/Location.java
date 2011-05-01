package au.edu.latrobe.placecomm.ontology.mobi;


import jade.content.abs.*;
import jade.content.onto.*;
import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
   * A single point in the cordinate. For example: (lat,lon, alt ) 
The speed of moving objects are taken into account
* Protege name: Location
* @author ontology bean generator
* @version 2010/12/27, 16:31:17
*/
public class Location implements Concept, Introspectable {

   /**
* Protege name: longitude
   */
   private String longitude;
   public void setLongitude(String value) { 
    this.longitude=value;
   }
   public String getLongitude() {
     return this.longitude;
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
* Protege name: latitude
   */
   private String latitude;
   public void setLatitude(String value) { 
    this.latitude=value;
   }
   public String getLatitude() {
     return this.latitude;
   }

   /**
* Protege name: hasPostalAddress
   */
   private List hasPostalAddress = new ArrayList();
   public void addHasPostalAddress(PostalAddress elem) { 
     List oldList = this.hasPostalAddress;
     hasPostalAddress.add(elem);
   }
   public boolean removeHasPostalAddress(PostalAddress elem) {
     List oldList = this.hasPostalAddress;
     boolean result = hasPostalAddress.remove(elem);
     return result;
   }
   public void clearAllHasPostalAddress() {
     List oldList = this.hasPostalAddress;
     hasPostalAddress.clear();
   }
   public Iterator getAllHasPostalAddress() {return hasPostalAddress.iterator(); }
   public List getHasPostalAddress() {return hasPostalAddress; }
   public void setHasPostalAddress(List l) {hasPostalAddress = l; }

   /**
* Protege name: belongtoPlace
   */
   private List belongtoPlace = new ArrayList();
   public void addBelongtoPlace(Place elem) { 
     List oldList = this.belongtoPlace;
     belongtoPlace.add(elem);
   }
   public boolean removeBelongtoPlace(Place elem) {
     List oldList = this.belongtoPlace;
     boolean result = belongtoPlace.remove(elem);
     return result;
   }
   public void clearAllBelongtoPlace() {
     List oldList = this.belongtoPlace;
     belongtoPlace.clear();
   }
   public Iterator getAllBelongtoPlace() {return belongtoPlace.iterator(); }
   public List getBelongtoPlace() {return belongtoPlace; }
   public void setBelongtoPlace(List l) {belongtoPlace = l; }

   /**
* Protege name: altitude
   */
   private String altitude;
   public void setAltitude(String value) { 
    this.altitude=value;
   }
   public String getAltitude() {
     return this.altitude;
   }

   /**
* Protege name: hasLocationContext
   */
   private List hasLocationContext = new ArrayList();
   public void addHasLocationContext(LocationContext elem) { 
     List oldList = this.hasLocationContext;
     hasLocationContext.add(elem);
   }
   public boolean removeHasLocationContext(LocationContext elem) {
     List oldList = this.hasLocationContext;
     boolean result = hasLocationContext.remove(elem);
     return result;
   }
   public void clearAllHasLocationContext() {
     List oldList = this.hasLocationContext;
     hasLocationContext.clear();
   }
   public Iterator getAllHasLocationContext() {return hasLocationContext.iterator(); }
   public List getHasLocationContext() {return hasLocationContext; }
   public void setHasLocationContext(List l) {hasLocationContext = l; }

  public void externalise(AbsObject absObj, Ontology onto) throws OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      abs.set(PlacecommOntology.LOCATION_LONGITUDE, (AbsTerm) onto.fromObject(getLongitude()));
      abs.set(PlacecommOntology.LOCATION_SPEED, (AbsTerm) onto.fromObject(getSpeed()));
      abs.set(PlacecommOntology.LOCATION_LATITUDE, (AbsTerm) onto.fromObject(getLatitude()));
      abs.set(PlacecommOntology.LOCATION_HASPOSTALADDRESS, (AbsTerm) onto.fromObject(getHasPostalAddress()));
      abs.set(PlacecommOntology.LOCATION_BELONGTOPLACE, (AbsTerm) onto.fromObject(getBelongtoPlace()));
      abs.set(PlacecommOntology.LOCATION_ALTITUDE, (AbsTerm) onto.fromObject(getAltitude()));
      abs.set(PlacecommOntology.LOCATION_HASLOCATIONCONTEXT, (AbsTerm) onto.fromObject(getHasLocationContext()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising Location");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      longitude = (String)onto.toObject(abs.getAbsObject(PlacecommOntology.LOCATION_LONGITUDE));
      speed = (String)onto.toObject(abs.getAbsObject(PlacecommOntology.LOCATION_SPEED));
      latitude = (String)onto.toObject(abs.getAbsObject(PlacecommOntology.LOCATION_LATITUDE));
      hasPostalAddress = (List)onto.toObject(abs.getAbsObject(PlacecommOntology.LOCATION_HASPOSTALADDRESS));
      belongtoPlace = (List)onto.toObject(abs.getAbsObject(PlacecommOntology.LOCATION_BELONGTOPLACE));
      altitude = (String)onto.toObject(abs.getAbsObject(PlacecommOntology.LOCATION_ALTITUDE));
      hasLocationContext = (List)onto.toObject(abs.getAbsObject(PlacecommOntology.LOCATION_HASLOCATIONCONTEXT));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising Location");
     }
   }

}
