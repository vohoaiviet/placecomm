package au.edu.latrobe.placecomm.ontology.mobi;


import jade.content.abs.*;
import jade.content.onto.*;
import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: Activity
* @author ontology bean generator
* @version 2010/12/27, 16:31:17
*/
public class Activity implements Concept, Introspectable {

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

   /**
* Protege name: activityName
   */
   private List activityName = new ArrayList();
   public void addActivityName(String elem) { 
     List oldList = this.activityName;
     activityName.add(elem);
   }
   public boolean removeActivityName(String elem) {
     List oldList = this.activityName;
     boolean result = activityName.remove(elem);
     return result;
   }
   public void clearAllActivityName() {
     List oldList = this.activityName;
     activityName.clear();
   }
   public Iterator getAllActivityName() {return activityName.iterator(); }
   public List getActivityName() {return activityName; }
   public void setActivityName(List l) {activityName = l; }

  public void externalise(AbsObject absObj, Ontology onto) throws OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      abs.set(PlacecommOntology.ACTIVITY_HASPERSONINVOLVED, (AbsTerm) onto.fromObject(getHasPersonInvolved()));
      abs.set(PlacecommOntology.ACTIVITY_ACTIVITYNAME, (AbsTerm) onto.fromObject(getActivityName()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising Activity");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      hasPersonInvolved = (List)onto.toObject(abs.getAbsObject(PlacecommOntology.ACTIVITY_HASPERSONINVOLVED));
      activityName = (List)onto.toObject(abs.getAbsObject(PlacecommOntology.ACTIVITY_ACTIVITYNAME));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising Activity");
     }
   }

}
