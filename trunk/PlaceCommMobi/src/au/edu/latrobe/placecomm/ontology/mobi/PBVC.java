package au.edu.latrobe.placecomm.ontology.mobi;


import jade.content.abs.*;
import jade.content.onto.*;
import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: PBVC
* @author ontology bean generator
* @version 2010/12/27, 16:31:17
*/
public class PBVC implements Concept, Introspectable {

   /**
* Protege name: hasService
   */
   private List hasService = new ArrayList();
   public void addHasService(Service elem) { 
     List oldList = this.hasService;
     hasService.add(elem);
   }
   public boolean removeHasService(Service elem) {
     List oldList = this.hasService;
     boolean result = hasService.remove(elem);
     return result;
   }
   public void clearAllHasService() {
     List oldList = this.hasService;
     hasService.clear();
   }
   public Iterator getAllHasService() {return hasService.iterator(); }
   public List getHasService() {return hasService; }
   public void setHasService(List l) {hasService = l; }

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
* Protege name: hasActivity
   */
   private List hasActivity = new ArrayList();
   public void addHasActivity(Activity elem) { 
     List oldList = this.hasActivity;
     hasActivity.add(elem);
   }
   public boolean removeHasActivity(Activity elem) {
     List oldList = this.hasActivity;
     boolean result = hasActivity.remove(elem);
     return result;
   }
   public void clearAllHasActivity() {
     List oldList = this.hasActivity;
     hasActivity.clear();
   }
   public Iterator getAllHasActivity() {return hasActivity.iterator(); }
   public List getHasActivity() {return hasActivity; }
   public void setHasActivity(List l) {hasActivity = l; }

   /**
* Protege name: hasMember
   */
   private List hasMember = new ArrayList();
   public void addHasMember(Agent elem) { 
     List oldList = this.hasMember;
     hasMember.add(elem);
   }
   public boolean removeHasMember(Agent elem) {
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

  public void externalise(AbsObject absObj, Ontology onto) throws OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      abs.set(PlacecommOntology.PBVC_HASSERVICE, (AbsTerm) onto.fromObject(getHasService()));
      abs.set(PlacecommOntology.PBVC_HASPLACE, (AbsTerm) onto.fromObject(getHasPlace()));
      abs.set(PlacecommOntology.PBVC_HASACTIVITY, (AbsTerm) onto.fromObject(getHasActivity()));
      abs.set(PlacecommOntology.PBVC_HASMEMBER, (AbsTerm) onto.fromObject(getHasMember()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising PBVC");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      hasService = (List)onto.toObject(abs.getAbsObject(PlacecommOntology.PBVC_HASSERVICE));
      hasPlace = (List)onto.toObject(abs.getAbsObject(PlacecommOntology.PBVC_HASPLACE));
      hasActivity = (List)onto.toObject(abs.getAbsObject(PlacecommOntology.PBVC_HASACTIVITY));
      hasMember = (List)onto.toObject(abs.getAbsObject(PlacecommOntology.PBVC_HASMEMBER));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising PBVC");
     }
   }

}
