package au.edu.latrobe.placecomm.ontology.j2me;


import jade.content.abs.*;
import jade.content.onto.*;
import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: PBVC
* @author ontology bean generator
* @version 2011/04/28, 11:06:23
*/
public class PBVC implements Predicate, Introspectable {

   /**
* Protege name: hasPlace
   */
   private List hasPlace = new ArrayList();
   public void addHasPlace(Place elem) { 
     List oldList = this.hasPlace;
     hasPlace.add(elem);
   }
   public boolean removeHasPlace(Place elem) {
     List oldList = this.hasPlace;
     boolean result = hasPlace.remove(elem);
     return result;
   }
   public void clearAllHasPlace() {
     List oldList = this.hasPlace;
     hasPlace.clear();
   }
   public Iterator getAllHasPlace() {return hasPlace.iterator(); }
   public List getHasPlace() {return hasPlace; }
   public void setHasPlace(List l) {hasPlace = l; }

   /**
* Protege name: hasMember
   */
   private List hasMember = new ArrayList();
   public void addHasMember(Object elem) { 
     List oldList = this.hasMember;
     hasMember.add(elem);
   }
   public boolean removeHasMember(Object elem) {
     List oldList = this.hasMember;
     boolean result = hasMember.remove(elem);
     return result;
   }
   public void clearAllHasMember() {
     List oldList = this.hasMember;
     hasMember.clear();
   }
   public Iterator getAllHasMember() {return hasMember.iterator(); }
   public List getHasMember() {return hasMember; }
   public void setHasMember(List l) {hasMember = l; }

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

  public void externalise(AbsObject absObj, Ontology onto) throws OntologyException {
    try {
      AbsPredicate abs = (AbsPredicate) absObj;
      abs.set(PlaceCommOntology.PBVC_HASPLACE, (AbsTerm) onto.fromObject(getHasPlace()));
      abs.set(PlaceCommOntology.PBVC_HASMEMBER, (AbsTerm) onto.fromObject(getHasMember()));
      abs.set(PlaceCommOntology.PBVC_HASEVENT, (AbsTerm) onto.fromObject(getHasEvent()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising PBVC");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException {
    try {
      AbsPredicate abs = (AbsPredicate) absObj;
      hasPlace = (List)onto.toObject(abs.getAbsObject(PlaceCommOntology.PBVC_HASPLACE));
      hasMember = (List)onto.toObject(abs.getAbsObject(PlaceCommOntology.PBVC_HASMEMBER));
      hasEvent = (List)onto.toObject(abs.getAbsObject(PlaceCommOntology.PBVC_HASEVENT));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising PBVC");
     }
   }

}
