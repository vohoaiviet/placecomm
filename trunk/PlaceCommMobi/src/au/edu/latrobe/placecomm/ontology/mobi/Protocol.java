package au.edu.latrobe.placecomm.ontology.mobi;


import jade.content.abs.*;
import jade.content.onto.*;
import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: Protocol
* @author ontology bean generator
* @version 2010/12/27, 16:31:17
*/
public class Protocol implements Concept, Introspectable {

  public void externalise(AbsObject absObj, Ontology onto) throws OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising Protocol");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising Protocol");
     }
   }

}
