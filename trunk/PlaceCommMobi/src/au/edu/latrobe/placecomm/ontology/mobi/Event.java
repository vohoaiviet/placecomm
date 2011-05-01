package au.edu.latrobe.placecomm.ontology.mobi;


import jade.content.abs.*;
import jade.content.onto.*;
import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: Event
* @author ontology bean generator
* @version 2010/12/27, 16:31:17
*/
public class Event implements Concept, Introspectable {

   /**
* Protege name: eventName
   */
   private List eventName = new ArrayList();
   public void addEventName(String elem) { 
     List oldList = this.eventName;
     eventName.add(elem);
   }
   public boolean removeEventName(String elem) {
     List oldList = this.eventName;
     boolean result = eventName.remove(elem);
     return result;
   }
   public void clearAllEventName() {
     List oldList = this.eventName;
     eventName.clear();
   }
   public Iterator getAllEventName() {return eventName.iterator(); }
   public List getEventName() {return eventName; }
   public void setEventName(List l) {eventName = l; }

   /**
* Protege name: happenAt
   */
   private List happenAt = new ArrayList();
   public void addHappenAt(Time elem) { 
     List oldList = this.happenAt;
     happenAt.add(elem);
   }
   public boolean removeHappenAt(Time elem) {
     List oldList = this.happenAt;
     boolean result = happenAt.remove(elem);
     return result;
   }
   public void clearAllHappenAt() {
     List oldList = this.happenAt;
     happenAt.clear();
   }
   public Iterator getAllHappenAt() {return happenAt.iterator(); }
   public List getHappenAt() {return happenAt; }
   public void setHappenAt(List l) {happenAt = l; }

  public void externalise(AbsObject absObj, Ontology onto) throws OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      abs.set(PlacecommOntology.EVENT_EVENTNAME, (AbsTerm) onto.fromObject(getEventName()));
      abs.set(PlacecommOntology.EVENT_HAPPENAT, (AbsTerm) onto.fromObject(getHappenAt()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising Event");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      eventName = (List)onto.toObject(abs.getAbsObject(PlacecommOntology.EVENT_EVENTNAME));
      happenAt = (List)onto.toObject(abs.getAbsObject(PlacecommOntology.EVENT_HAPPENAT));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising Event");
     }
   }

}
