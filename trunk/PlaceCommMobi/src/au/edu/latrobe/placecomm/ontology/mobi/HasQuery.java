package au.edu.latrobe.placecomm.ontology.mobi;


import jade.content.abs.*;
import jade.content.onto.*;
import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: hasQuery
* @author ontology bean generator
* @version 2010/12/27, 16:31:17
*/
public class HasQuery implements Predicate, Introspectable {

   /**
* Protege name: SPARQLQuery
   */
   private String sparqlQuery;
   public void setSPARQLQuery(String value) { 
    this.sparqlQuery=value;
   }
   public String getSPARQLQuery() {
     return this.sparqlQuery;
   }

   /**
* Protege name: SparqlResults
   */
   private List sparqlResults = new ArrayList();
   public void addSparqlResults(String elem) { 
     List oldList = this.sparqlResults;
     sparqlResults.add(elem);
   }
   public boolean removeSparqlResults(String elem) {
     List oldList = this.sparqlResults;
     boolean result = sparqlResults.remove(elem);
     return result;
   }
   public void clearAllSparqlResults() {
     List oldList = this.sparqlResults;
     sparqlResults.clear();
   }
   public Iterator getAllSparqlResults() {return sparqlResults.iterator(); }
   public List getSparqlResults() {return sparqlResults; }
   public void setSparqlResults(List l) {sparqlResults = l; }

  public void externalise(AbsObject absObj, Ontology onto) throws OntologyException {
    try {
      AbsPredicate abs = (AbsPredicate) absObj;
      abs.set(PlacecommOntology.HASQUERY_SPARQLQUERY, (AbsTerm) onto.fromObject(getSPARQLQuery()));
      abs.set(PlacecommOntology.HASQUERY_SPARQLRESULTS, (AbsTerm) onto.fromObject(getSparqlResults()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising HasQuery");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException {
    try {
      AbsPredicate abs = (AbsPredicate) absObj;
      sparqlQuery = (String)onto.toObject(abs.getAbsObject(PlacecommOntology.HASQUERY_SPARQLQUERY));
      sparqlResults = (List)onto.toObject(abs.getAbsObject(PlacecommOntology.HASQUERY_SPARQLRESULTS));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising HasQuery");
     }
   }

}
