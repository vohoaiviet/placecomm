package au.edu.latrobe.placecomm.ontology.j2me;


import jade.content.abs.*;
import jade.content.onto.*;
import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: Context
* @author ontology bean generator
* @version 2011/04/28, 11:06:23
*/
public class Context implements Predicate, Introspectable {

   /**
* Protege name: hasTimeInstance
   */
   private List hasTimeInstance = new ArrayList();
   public void addHasTimeInstance(TimeInstance elem) { 
     List oldList = this.hasTimeInstance;
     hasTimeInstance.add(elem);
   }
   public boolean removeHasTimeInstance(TimeInstance elem) {
     List oldList = this.hasTimeInstance;
     boolean result = hasTimeInstance.remove(elem);
     return result;
   }
   public void clearAllHasTimeInstance() {
     List oldList = this.hasTimeInstance;
     hasTimeInstance.clear();
   }
   public Iterator getAllHasTimeInstance() {return hasTimeInstance.iterator(); }
   public List getHasTimeInstance() {return hasTimeInstance; }
   public void setHasTimeInstance(List l) {hasTimeInstance = l; }

  public void externalise(AbsObject absObj, Ontology onto) throws OntologyException {
    try {
      AbsPredicate abs = (AbsPredicate) absObj;
      abs.set(PlaceCommOntology.CONTEXT_HASTIMEINSTANCE, (AbsTerm) onto.fromObject(getHasTimeInstance()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising Context");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException {
    try {
      AbsPredicate abs = (AbsPredicate) absObj;
      hasTimeInstance = (List)onto.toObject(abs.getAbsObject(PlaceCommOntology.CONTEXT_HASTIMEINSTANCE));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising Context");
     }
   }

}
