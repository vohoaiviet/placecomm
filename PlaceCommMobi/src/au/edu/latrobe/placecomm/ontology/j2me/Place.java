package au.edu.latrobe.placecomm.ontology.j2me;


import jade.content.abs.*;
import jade.content.onto.*;
import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: Place
* @author ontology bean generator
* @version 2011/04/28, 11:06:23
*/
public class Place implements Predicate, Introspectable {

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
* Protege name: hasPersonPresence
   */
   private List hasPersonPresence = new ArrayList();
   public void addHasPersonPresence(Person elem) { 
     List oldList = this.hasPersonPresence;
     hasPersonPresence.add(elem);
   }
   public boolean removeHasPersonPresence(Person elem) {
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

  public void externalise(AbsObject absObj, Ontology onto) throws OntologyException {
    try {
      AbsPredicate abs = (AbsPredicate) absObj;
      abs.set(PlaceCommOntology.PLACE_HASLOCATION, (AbsTerm) onto.fromObject(getHasLocation()));
      abs.set(PlaceCommOntology.PLACE_HASPERSONPRESENCE, (AbsTerm) onto.fromObject(getHasPersonPresence()));
      abs.set(PlaceCommOntology.PLACE_HASDEVICEPRESENCE, (AbsTerm) onto.fromObject(getHasDevicePresence()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising Place");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException {
    try {
      AbsPredicate abs = (AbsPredicate) absObj;
      hasLocation = (List)onto.toObject(abs.getAbsObject(PlaceCommOntology.PLACE_HASLOCATION));
      hasPersonPresence = (List)onto.toObject(abs.getAbsObject(PlaceCommOntology.PLACE_HASPERSONPRESENCE));
      hasDevicePresence = (List)onto.toObject(abs.getAbsObject(PlaceCommOntology.PLACE_HASDEVICEPRESENCE));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising Place");
     }
   }

}
