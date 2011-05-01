package au.edu.latrobe.placecomm.ontology.mobi;

import jade.content.abs.*;
import jade.content.onto.*;
import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: Leaving
* @author ontology bean generator
* @version 2010/12/27, 16:31:17
*/
public class Leaving extends Protocol{ 

   /**
* Protege name: leavingGOODBYE
   */
   private String leavingGOODBYE;
   public void setLeavingGOODBYE(String value) { 
    this.leavingGOODBYE=value;
   }
   public String getLeavingGOODBYE() {
     return this.leavingGOODBYE;
   }

  public void externalise(AbsObject absObj, Ontology onto) throws OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      abs.set(PlacecommOntology.LEAVING_LEAVINGGOODBYE, (AbsTerm) onto.fromObject(getLeavingGOODBYE()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising Leaving");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      leavingGOODBYE = (String)onto.toObject(abs.getAbsObject(PlacecommOntology.LEAVING_LEAVINGGOODBYE));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising Leaving");
     }
   }

}
