package au.edu.latrobe.placecomm.ontology.j2me;


import jade.content.abs.*;
import jade.content.onto.*;
import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: Location
* @author ontology bean generator
* @version 2011/04/28, 11:06:23
*/
public class Location implements Predicate, Introspectable {

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

  public void externalise(AbsObject absObj, Ontology onto) throws OntologyException {
    try {
      AbsPredicate abs = (AbsPredicate) absObj;
      abs.set(PlaceCommOntology.LOCATION_LAT, (AbsTerm) onto.fromObject(getLat()));
      abs.set(PlaceCommOntology.LOCATION_SPEED, (AbsTerm) onto.fromObject(getSpeed()));
      abs.set(PlaceCommOntology.LOCATION_ALT, (AbsTerm) onto.fromObject(getAlt()));
      abs.set(PlaceCommOntology.LOCATION_LON, (AbsTerm) onto.fromObject(getLon()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising Location");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException {
    try {
      AbsPredicate abs = (AbsPredicate) absObj;
      lat = (String)onto.toObject(abs.getAbsObject(PlaceCommOntology.LOCATION_LAT));
      speed = (String)onto.toObject(abs.getAbsObject(PlaceCommOntology.LOCATION_SPEED));
      alt = (String)onto.toObject(abs.getAbsObject(PlaceCommOntology.LOCATION_ALT));
      lon = (String)onto.toObject(abs.getAbsObject(PlaceCommOntology.LOCATION_LON));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising Location");
     }
   }

}
