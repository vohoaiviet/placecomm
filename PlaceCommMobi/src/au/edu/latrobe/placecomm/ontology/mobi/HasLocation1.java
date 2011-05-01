package au.edu.latrobe.placecomm.ontology.mobi;


import jade.content.abs.*;
import jade.content.onto.*;
import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: hasLocation1
* @author ontology bean generator
* @version 2010/12/27, 16:31:17
*/
public class HasLocation1 implements Predicate, Introspectable {

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
* Protege name: fspeed
   */
   private String fspeed;
   public void setFspeed(String value) { 
    this.fspeed=value;
   }
   public String getFspeed() {
     return this.fspeed;
   }

  public void externalise(AbsObject absObj, Ontology onto) throws OntologyException {
    try {
      AbsPredicate abs = (AbsPredicate) absObj;
      abs.set(PlacecommOntology.HASLOCATION1_LON, (AbsTerm) onto.fromObject(getLon()));
      abs.set(PlacecommOntology.HASLOCATION1_LAT, (AbsTerm) onto.fromObject(getLat()));
      abs.set(PlacecommOntology.HASLOCATION1_FSPEED, (AbsTerm) onto.fromObject(getFspeed()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising HasLocation1");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException {
    try {
      AbsPredicate abs = (AbsPredicate) absObj;
      lon = (String)onto.toObject(abs.getAbsObject(PlacecommOntology.HASLOCATION1_LON));
      lat = (String)onto.toObject(abs.getAbsObject(PlacecommOntology.HASLOCATION1_LAT));
      fspeed = (String)onto.toObject(abs.getAbsObject(PlacecommOntology.HASLOCATION1_FSPEED));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising HasLocation1");
     }
   }

}
