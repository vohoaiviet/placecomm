package au.edu.latrobe.placecomm.ontology.mobi;

import jade.content.abs.*;
import jade.content.onto.*;
import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: Joining
* @author ontology bean generator
* @version 2010/12/27, 16:31:17
*/
public class Joining extends Protocol{ 

   /**
* Protege name: joiningREJECT
   */
   private String joiningREJECT;
   public void setJoiningREJECT(String value) { 
    this.joiningREJECT=value;
   }
   public String getJoiningREJECT() {
     return this.joiningREJECT;
   }

   /**
* Protege name: joiningINTRODUCE
   */
   private String joiningINTRODUCE;
   public void setJoiningINTRODUCE(String value) { 
    this.joiningINTRODUCE=value;
   }
   public String getJoiningINTRODUCE() {
     return this.joiningINTRODUCE;
   }

   /**
* Protege name: joiningJOINPROPOSE
   */
   private String joiningJOINPROPOSE;
   public void setJoiningJOINPROPOSE(String value) { 
    this.joiningJOINPROPOSE=value;
   }
   public String getJoiningJOINPROPOSE() {
     return this.joiningJOINPROPOSE;
   }

   /**
* Protege name: joiningHELLO
   */
   private String joiningHELLO;
   public void setJoiningHELLO(String value) { 
    this.joiningHELLO=value;
   }
   public String getJoiningHELLO() {
     return this.joiningHELLO;
   }

   /**
* Protege name: joiningACCEPT
   */
   private String joiningACCEPT;
   public void setJoiningACCEPT(String value) { 
    this.joiningACCEPT=value;
   }
   public String getJoiningACCEPT() {
     return this.joiningACCEPT;
   }

  public void externalise(AbsObject absObj, Ontology onto) throws OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      abs.set(PlacecommOntology.JOINING_JOININGREJECT, (AbsTerm) onto.fromObject(getJoiningREJECT()));
      abs.set(PlacecommOntology.JOINING_JOININGINTRODUCE, (AbsTerm) onto.fromObject(getJoiningINTRODUCE()));
      abs.set(PlacecommOntology.JOINING_JOININGJOINPROPOSE, (AbsTerm) onto.fromObject(getJoiningJOINPROPOSE()));
      abs.set(PlacecommOntology.JOINING_JOININGHELLO, (AbsTerm) onto.fromObject(getJoiningHELLO()));
      abs.set(PlacecommOntology.JOINING_JOININGACCEPT, (AbsTerm) onto.fromObject(getJoiningACCEPT()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising Joining");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      joiningREJECT = (String)onto.toObject(abs.getAbsObject(PlacecommOntology.JOINING_JOININGREJECT));
      joiningINTRODUCE = (String)onto.toObject(abs.getAbsObject(PlacecommOntology.JOINING_JOININGINTRODUCE));
      joiningJOINPROPOSE = (String)onto.toObject(abs.getAbsObject(PlacecommOntology.JOINING_JOININGJOINPROPOSE));
      joiningHELLO = (String)onto.toObject(abs.getAbsObject(PlacecommOntology.JOINING_JOININGHELLO));
      joiningACCEPT = (String)onto.toObject(abs.getAbsObject(PlacecommOntology.JOINING_JOININGACCEPT));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising Joining");
     }
   }

}
