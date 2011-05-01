package au.edu.latrobe.placecomm.ontology.mobi;


import jade.content.abs.*;
import jade.content.onto.*;
import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: Agent
* @author ontology bean generator
* @version 2010/12/27, 16:31:17
*/
public class Agent implements Concept, Introspectable {

   /**
* Protege name: agentID
   */
   private List agentID = new ArrayList();
   public void addAgentID(String elem) { 
     List oldList = this.agentID;
     agentID.add(elem);
   }
   public boolean removeAgentID(String elem) {
     List oldList = this.agentID;
     boolean result = agentID.remove(elem);
     return result;
   }
   public void clearAllAgentID() {
     List oldList = this.agentID;
     agentID.clear();
   }
   public Iterator getAllAgentID() {return agentID.iterator(); }
   public List getAgentID() {return agentID; }
   public void setAgentID(List l) {agentID = l; }

  public void externalise(AbsObject absObj, Ontology onto) throws OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      abs.set(PlacecommOntology.AGENT_AGENTID, (AbsTerm) onto.fromObject(getAgentID()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising Agent");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      agentID = (List)onto.toObject(abs.getAbsObject(PlacecommOntology.AGENT_AGENTID));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising Agent");
     }
   }

}
