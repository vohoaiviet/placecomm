package au.edu.latrobe.placecomm.ontology.mobi;

import jade.content.abs.*;
import jade.content.onto.*;
import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: Advertising
* @author ontology bean generator
* @version 2010/12/27, 16:31:17
*/
public class Advertising extends Protocol{ 

   /**
* Protege name: advertisingADVERTISING
   */
   private String advertisingADVERTISING;
   public void setAdvertisingADVERTISING(String value) { 
    this.advertisingADVERTISING=value;
   }
   public String getAdvertisingADVERTISING() {
     return this.advertisingADVERTISING;
   }

   /**
* Protege name: advertisingINFORM
   */
   private String advertisingINFORM;
   public void setAdvertisingINFORM(String value) { 
    this.advertisingINFORM=value;
   }
   public String getAdvertisingINFORM() {
     return this.advertisingINFORM;
   }

   /**
* Protege name: advertisingNOTTHISTIME
   */
   private String advertisingNOTTHISTIME;
   public void setAdvertisingNOTTHISTIME(String value) { 
    this.advertisingNOTTHISTIME=value;
   }
   public String getAdvertisingNOTTHISTIME() {
     return this.advertisingNOTTHISTIME;
   }

   /**
* Protege name: advertisingNEVER
   */
   private String advertisingNEVER;
   public void setAdvertisingNEVER(String value) { 
    this.advertisingNEVER=value;
   }
   public String getAdvertisingNEVER() {
     return this.advertisingNEVER;
   }

   /**
* Protege name: advertisingDATA
   */
   private List advertisingDATA = new ArrayList();
   public void addAdvertisingDATA(String elem) { 
     List oldList = this.advertisingDATA;
     advertisingDATA.add(elem);
   }
   public boolean removeAdvertisingDATA(String elem) {
     List oldList = this.advertisingDATA;
     boolean result = advertisingDATA.remove(elem);
     return result;
   }
   public void clearAllAdvertisingDATA() {
     List oldList = this.advertisingDATA;
     advertisingDATA.clear();
   }
   public Iterator getAllAdvertisingDATA() {return advertisingDATA.iterator(); }
   public List getAdvertisingDATA() {return advertisingDATA; }
   public void setAdvertisingDATA(List l) {advertisingDATA = l; }

  public void externalise(AbsObject absObj, Ontology onto) throws OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      abs.set(PlacecommOntology.ADVERTISING_ADVERTISINGADVERTISING, (AbsTerm) onto.fromObject(getAdvertisingADVERTISING()));
      abs.set(PlacecommOntology.ADVERTISING_ADVERTISINGINFORM, (AbsTerm) onto.fromObject(getAdvertisingINFORM()));
      abs.set(PlacecommOntology.ADVERTISING_ADVERTISINGNOTTHISTIME, (AbsTerm) onto.fromObject(getAdvertisingNOTTHISTIME()));
      abs.set(PlacecommOntology.ADVERTISING_ADVERTISINGNEVER, (AbsTerm) onto.fromObject(getAdvertisingNEVER()));
      abs.set(PlacecommOntology.ADVERTISING_ADVERTISINGDATA, (AbsTerm) onto.fromObject(getAdvertisingDATA()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising Advertising");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      advertisingADVERTISING = (String)onto.toObject(abs.getAbsObject(PlacecommOntology.ADVERTISING_ADVERTISINGADVERTISING));
      advertisingINFORM = (String)onto.toObject(abs.getAbsObject(PlacecommOntology.ADVERTISING_ADVERTISINGINFORM));
      advertisingNOTTHISTIME = (String)onto.toObject(abs.getAbsObject(PlacecommOntology.ADVERTISING_ADVERTISINGNOTTHISTIME));
      advertisingNEVER = (String)onto.toObject(abs.getAbsObject(PlacecommOntology.ADVERTISING_ADVERTISINGNEVER));
      advertisingDATA = (List)onto.toObject(abs.getAbsObject(PlacecommOntology.ADVERTISING_ADVERTISINGDATA));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising Advertising");
     }
   }

}
