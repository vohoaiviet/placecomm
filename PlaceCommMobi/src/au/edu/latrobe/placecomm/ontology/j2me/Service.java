package au.edu.latrobe.placecomm.ontology.j2me;


import jade.content.abs.*;
import jade.content.onto.*;
import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: Service
* @author ontology bean generator
* @version 2011/04/28, 11:06:23
*/
public class Service implements Predicate, Introspectable {

  public void externalise(AbsObject absObj, Ontology onto) throws OntologyException {
    try {
      AbsPredicate abs = (AbsPredicate) absObj;
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising Service");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException {
    try {
      AbsPredicate abs = (AbsPredicate) absObj;
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising Service");
     }
   }

}
