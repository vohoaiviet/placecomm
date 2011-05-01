package au.edu.latrobe.placecomm.ontology.mobi;


import jade.content.abs.*;
import jade.content.onto.*;
import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: Place
* @author ontology bean generator
* @version 2010/12/27, 16:31:17
*/
public class Place implements Concept, Introspectable {

   /**
* Protege name: hasPlaceContext
   */
   private List hasPlaceContext = new ArrayList();
   public void addHasPlaceContext(PlaceContext elem) { 
     List oldList = this.hasPlaceContext;
     hasPlaceContext.add(elem);
   }
   public boolean removeHasPlaceContext(PlaceContext elem) {
     List oldList = this.hasPlaceContext;
     boolean result = hasPlaceContext.remove(elem);
     return result;
   }
   public void clearAllHasPlaceContext() {
     List oldList = this.hasPlaceContext;
     hasPlaceContext.clear();
   }
   public Iterator getAllHasPlaceContext() {return hasPlaceContext.iterator(); }
   public List getHasPlaceContext() {return hasPlaceContext; }
   public void setHasPlaceContext(List l) {hasPlaceContext = l; }

   /**
* Protege name: hasPersonPresence
   */
   private List hasPersonPresence = new ArrayList();
   public void addHasPersonPresence(Object elem) { 
     List oldList = this.hasPersonPresence;
     hasPersonPresence.add(elem);
   }
   public boolean removeHasPersonPresence(Object elem) {
     List oldList = this.hasPersonPresence;
     boolean result = hasPersonPresence.remove(elem);
     return result;
   }
   public void clearAllHasPersonPresence() {
     List oldList = this.hasPersonPresence;
     hasPersonPresence.clear();
   }
   public Iterator getAllHasPersonPresence() {return hasPersonPresence.iterator(); }
   public List getHasPersonPresence() {return hasPersonPresence; }
   public void setHasPersonPresence(List l) {hasPersonPresence = l; }

   /**
* Protege name: hasDevicePresence
   */
   private List hasDevicePresence = new ArrayList();
   public void addHasDevicePresence(Device elem) { 
     List oldList = this.hasDevicePresence;
     hasDevicePresence.add(elem);
   }
   public boolean removeHasDevicePresence(Device elem) {
     List oldList = this.hasDevicePresence;
     boolean result = hasDevicePresence.remove(elem);
     return result;
   }
   public void clearAllHasDevicePresence() {
     List oldList = this.hasDevicePresence;
     hasDevicePresence.clear();
   }
   public Iterator getAllHasDevicePresence() {return hasDevicePresence.iterator(); }
   public List getHasDevicePresence() {return hasDevicePresence; }
   public void setHasDevicePresence(List l) {hasDevicePresence = l; }

   /**
* Protege name: hasEvent
   */
   private List hasEvent = new ArrayList();
   public void addHasEvent(Event elem) { 
     List oldList = this.hasEvent;
     hasEvent.add(elem);
   }
   public boolean removeHasEvent(Event elem) {
     List oldList = this.hasEvent;
     boolean result = hasEvent.remove(elem);
     return result;
   }
   public void clearAllHasEvent() {
     List oldList = this.hasEvent;
     hasEvent.clear();
   }
   public Iterator getAllHasEvent() {return hasEvent.iterator(); }
   public List getHasEvent() {return hasEvent; }
   public void setHasEvent(List l) {hasEvent = l; }

   /**
* Protege name: belongTo
   */
   private List belongTo = new ArrayList();
   public void addBelongTo(PBVC elem) { 
     List oldList = this.belongTo;
     belongTo.add(elem);
   }
   public boolean removeBelongTo(PBVC elem) {
     List oldList = this.belongTo;
     boolean result = belongTo.remove(elem);
     return result;
   }
   public void clearAllBelongTo() {
     List oldList = this.belongTo;
     belongTo.clear();
   }
   public Iterator getAllBelongTo() {return belongTo.iterator(); }
   public List getBelongTo() {return belongTo; }
   public void setBelongTo(List l) {belongTo = l; }

   /**
* Protege name: hasLocation
   */
   private List hasLocation = new ArrayList();
   public void addHasLocation(Location elem) { 
     List oldList = this.hasLocation;
     hasLocation.add(elem);
   }
   public boolean removeHasLocation(Location elem) {
     List oldList = this.hasLocation;
     boolean result = hasLocation.remove(elem);
     return result;
   }
   public void clearAllHasLocation() {
     List oldList = this.hasLocation;
     hasLocation.clear();
   }
   public Iterator getAllHasLocation() {return hasLocation.iterator(); }
   public List getHasLocation() {return hasLocation; }
   public void setHasLocation(List l) {hasLocation = l; }

   /**
* Protege name: createdByAgent
   */
   private List createdByAgent = new ArrayList();
   public void addCreatedByAgent(Agent elem) { 
     List oldList = this.createdByAgent;
     createdByAgent.add(elem);
   }
   public boolean removeCreatedByAgent(Agent elem) {
     List oldList = this.createdByAgent;
     boolean result = createdByAgent.remove(elem);
     return result;
   }
   public void clearAllCreatedByAgent() {
     List oldList = this.createdByAgent;
     createdByAgent.clear();
   }
   public Iterator getAllCreatedByAgent() {return createdByAgent.iterator(); }
   public List getCreatedByAgent() {return createdByAgent; }
   public void setCreatedByAgent(List l) {createdByAgent = l; }

  public void externalise(AbsObject absObj, Ontology onto) throws OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      abs.set(PlacecommOntology.PLACE_HASPLACECONTEXT, (AbsTerm) onto.fromObject(getHasPlaceContext()));
      abs.set(PlacecommOntology.PLACE_HASPERSONPRESENCE, (AbsTerm) onto.fromObject(getHasPersonPresence()));
      abs.set(PlacecommOntology.PLACE_HASDEVICEPRESENCE, (AbsTerm) onto.fromObject(getHasDevicePresence()));
      abs.set(PlacecommOntology.PLACE_HASEVENT, (AbsTerm) onto.fromObject(getHasEvent()));
      abs.set(PlacecommOntology.PLACE_BELONGTO, (AbsTerm) onto.fromObject(getBelongTo()));
      abs.set(PlacecommOntology.PLACE_HASLOCATION, (AbsTerm) onto.fromObject(getHasLocation()));
      abs.set(PlacecommOntology.PLACE_CREATEDBYAGENT, (AbsTerm) onto.fromObject(getCreatedByAgent()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising Place");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      hasPlaceContext = (List)onto.toObject(abs.getAbsObject(PlacecommOntology.PLACE_HASPLACECONTEXT));
      hasPersonPresence = (List)onto.toObject(abs.getAbsObject(PlacecommOntology.PLACE_HASPERSONPRESENCE));
      hasDevicePresence = (List)onto.toObject(abs.getAbsObject(PlacecommOntology.PLACE_HASDEVICEPRESENCE));
      hasEvent = (List)onto.toObject(abs.getAbsObject(PlacecommOntology.PLACE_HASEVENT));
      belongTo = (List)onto.toObject(abs.getAbsObject(PlacecommOntology.PLACE_BELONGTO));
      hasLocation = (List)onto.toObject(abs.getAbsObject(PlacecommOntology.PLACE_HASLOCATION));
      createdByAgent = (List)onto.toObject(abs.getAbsObject(PlacecommOntology.PLACE_CREATEDBYAGENT));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising Place");
     }
   }

}
