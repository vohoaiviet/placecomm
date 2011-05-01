package au.edu.latrobe.placecomm.ontology.j2me;


import jade.content.abs.*;
import jade.content.onto.*;
import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: HasQuery
* @author ontology bean generator
* @version 2011/04/28, 11:06:23
*/
public class HasQuery implements Predicate, Introspectable {

   /**
* Protege name: sQueryResult
   */
   private String sQueryResult;
   public void setSQueryResult(String value) { 
    this.sQueryResult=value;
   }
   public String getSQueryResult() {
     return this.sQueryResult;
   }

   /**
* Protege name: sQuery
   */
   private String sQuery;
   public void setSQuery(String value) { 
    this.sQuery=value;
   }
   public String getSQuery() {
     return this.sQuery;
   }

  public void externalise(AbsObject absObj, Ontology onto) throws OntologyException {
    try {
      AbsPredicate abs = (AbsPredicate) absObj;
      abs.set(PlaceCommOntology.HASQUERY_SQUERYRESULT, (AbsTerm) onto.fromObject(getSQueryResult()));
      abs.set(PlaceCommOntology.HASQUERY_SQUERY, (AbsTerm) onto.fromObject(getSQuery()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising HasQuery");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException {
    try {
      AbsPredicate abs = (AbsPredicate) absObj;
      sQueryResult = (String)onto.toObject(abs.getAbsObject(PlaceCommOntology.HASQUERY_SQUERYRESULT));
      sQuery = (String)onto.toObject(abs.getAbsObject(PlaceCommOntology.HASQUERY_SQUERY));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising HasQuery");
     }
   }

}
