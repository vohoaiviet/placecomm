package au.edu.latrobe.placecomm.ontology.mobi;

import jade.content.abs.*;
import jade.content.onto.*;
import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: AmbientService
* @author ontology bean generator
* @version 2010/12/27, 16:31:17
*/
public class AmbientService extends Service{ 

   /**
* Protege name: providedAtPlace
   */
   private List providedAtPlace = new ArrayList();
   public void addProvidedAtPlace(Place elem) { 
     List oldList = this.providedAtPlace;
     providedAtPlace.add(elem);
   }
   public boolean removeProvidedAtPlace(Place elem) {
     List oldList = this.providedAtPlace;
     boolean result = providedAtPlace.remove(elem);
     return result;
   }
   public void clearAllProvidedAtPlace() {
     List oldList = this.providedAtPlace;
     providedAtPlace.clear();
   }
   public Iterator getAllProvidedAtPlace() {return providedAtPlace.iterator(); }
   public List getProvidedAtPlace() {return providedAtPlace; }
   public void setProvidedAtPlace(List l) {providedAtPlace = l; }

  public void externalise(AbsObject absObj, Ontology onto) throws OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      abs.set(PlacecommOntology.AMBIENTSERVICE_PROVIDEDATPLACE, (AbsTerm) onto.fromObject(getProvidedAtPlace()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising AmbientService");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      providedAtPlace = (List)onto.toObject(abs.getAbsObject(PlacecommOntology.AMBIENTSERVICE_PROVIDEDATPLACE));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising AmbientService");
     }
   }

}
