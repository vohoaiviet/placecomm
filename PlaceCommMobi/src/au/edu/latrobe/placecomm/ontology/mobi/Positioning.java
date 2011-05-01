package au.edu.latrobe.placecomm.ontology.mobi;

import jade.content.abs.*;
import jade.content.onto.*;
import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: Positioning
* @author ontology bean generator
* @version 2010/12/27, 16:31:17
*/
public class Positioning extends Protocol{ 

   /**
* Protege name: positioningWHEREAMI
   */
   private String positioningWHEREAMI;
   public void setPositioningWHEREAMI(String value) { 
    this.positioningWHEREAMI=value;
   }
   public String getPositioningWHEREAMI() {
     return this.positioningWHEREAMI;
   }

   /**
* Protege name: positioningYOUAREIN
   */
   private String positioningYOUAREIN;
   public void setPositioningYOUAREIN(String value) { 
    this.positioningYOUAREIN=value;
   }
   public String getPositioningYOUAREIN() {
     return this.positioningYOUAREIN;
   }

  public void externalise(AbsObject absObj, Ontology onto) throws OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      abs.set(PlacecommOntology.POSITIONING_POSITIONINGWHEREAMI, (AbsTerm) onto.fromObject(getPositioningWHEREAMI()));
      abs.set(PlacecommOntology.POSITIONING_POSITIONINGYOUAREIN, (AbsTerm) onto.fromObject(getPositioningYOUAREIN()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising Positioning");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      positioningWHEREAMI = (String)onto.toObject(abs.getAbsObject(PlacecommOntology.POSITIONING_POSITIONINGWHEREAMI));
      positioningYOUAREIN = (String)onto.toObject(abs.getAbsObject(PlacecommOntology.POSITIONING_POSITIONINGYOUAREIN));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising Positioning");
     }
   }

}
