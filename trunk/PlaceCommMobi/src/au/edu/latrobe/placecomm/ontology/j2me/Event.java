package au.edu.latrobe.placecomm.ontology.j2me;


import jade.content.abs.*;
import jade.content.onto.*;
import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: Event
* @author ontology bean generator
* @version 2011/04/28, 11:06:23
*/
public class Event implements Predicate, Introspectable {

   /**
* Protege name: hasPersonInvolved
   */
   private List hasPersonInvolved = new ArrayList();
   public void addHasPersonInvolved(Person elem) { 
     List oldList = this.hasPersonInvolved;
     hasPersonInvolved.add(elem);
   }
   public boolean removeHasPersonInvolved(Person elem) {
     List oldList = this.hasPersonInvolved;
     boolean result = hasPersonInvolved.remove(elem);
     return result;
   }
   public void clearAllHasPersonInvolved() {
     List oldList = this.hasPersonInvolved;
     hasPersonInvolved.clear();
   }
   public Iterator getAllHasPersonInvolved() {return hasPersonInvolved.iterator(); }
   public List getHasPersonInvolved() {return hasPersonInvolved; }
   public void setHasPersonInvolved(List l) {hasPersonInvolved = l; }

  public void externalise(AbsObject absObj, Ontology onto) throws OntologyException {
    try {
      AbsPredicate abs = (AbsPredicate) absObj;
      abs.set(PlaceCommOntology.EVENT_HASPERSONINVOLVED, (AbsTerm) onto.fromObject(getHasPersonInvolved()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising Event");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException {
    try {
      AbsPredicate abs = (AbsPredicate) absObj;
      hasPersonInvolved = (List)onto.toObject(abs.getAbsObject(PlaceCommOntology.EVENT_HASPERSONINVOLVED));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising Event");
     }
   }

}
