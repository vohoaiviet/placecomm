package au.edu.latrobe.placecomm.ontology.j2me;


import jade.content.abs.*;
import jade.content.onto.*;
import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: PostalAddress
* @author ontology bean generator
* @version 2011/04/28, 11:06:23
*/
public class PostalAddress implements Predicate, Introspectable {

   /**
* Protege name: suburb
   */
   private String suburb;
   public void setSuburb(String value) { 
    this.suburb=value;
   }
   public String getSuburb() {
     return this.suburb;
   }

   /**
* Protege name: Country
   */
   private String country;
   public void setCountry(String value) { 
    this.country=value;
   }
   public String getCountry() {
     return this.country;
   }

   /**
* Protege name: postalAddressName
   */
   private String postalAddressName;
   public void setPostalAddressName(String value) { 
    this.postalAddressName=value;
   }
   public String getPostalAddressName() {
     return this.postalAddressName;
   }

   /**
* Protege name: streetName
   */
   private String streetName;
   public void setStreetName(String value) { 
    this.streetName=value;
   }
   public String getStreetName() {
     return this.streetName;
   }

   /**
* Protege name: date
   */
   private String date;
   public void setDate(String value) { 
    this.date=value;
   }
   public String getDate() {
     return this.date;
   }

   /**
* Protege name: streetNumber
   */
   private String streetNumber;
   public void setStreetNumber(String value) { 
    this.streetNumber=value;
   }
   public String getStreetNumber() {
     return this.streetNumber;
   }

   /**
* Protege name: postCode
   */
   private String postCode;
   public void setPostCode(String value) { 
    this.postCode=value;
   }
   public String getPostCode() {
     return this.postCode;
   }

  public void externalise(AbsObject absObj, Ontology onto) throws OntologyException {
    try {
      AbsPredicate abs = (AbsPredicate) absObj;
      abs.set(PlaceCommOntology.POSTALADDRESS_SUBURB, (AbsTerm) onto.fromObject(getSuburb()));
      abs.set(PlaceCommOntology.POSTALADDRESS_COUNTRY, (AbsTerm) onto.fromObject(getCountry()));
      abs.set(PlaceCommOntology.POSTALADDRESS_POSTALADDRESSNAME, (AbsTerm) onto.fromObject(getPostalAddressName()));
      abs.set(PlaceCommOntology.POSTALADDRESS_STREETNAME, (AbsTerm) onto.fromObject(getStreetName()));
      abs.set(PlaceCommOntology.POSTALADDRESS_DATE, (AbsTerm) onto.fromObject(getDate()));
      abs.set(PlaceCommOntology.POSTALADDRESS_STREETNUMBER, (AbsTerm) onto.fromObject(getStreetNumber()));
      abs.set(PlaceCommOntology.POSTALADDRESS_POSTCODE, (AbsTerm) onto.fromObject(getPostCode()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising PostalAddress");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException {
    try {
      AbsPredicate abs = (AbsPredicate) absObj;
      suburb = (String)onto.toObject(abs.getAbsObject(PlaceCommOntology.POSTALADDRESS_SUBURB));
      country = (String)onto.toObject(abs.getAbsObject(PlaceCommOntology.POSTALADDRESS_COUNTRY));
      postalAddressName = (String)onto.toObject(abs.getAbsObject(PlaceCommOntology.POSTALADDRESS_POSTALADDRESSNAME));
      streetName = (String)onto.toObject(abs.getAbsObject(PlaceCommOntology.POSTALADDRESS_STREETNAME));
      date = (String)onto.toObject(abs.getAbsObject(PlaceCommOntology.POSTALADDRESS_DATE));
      streetNumber = (String)onto.toObject(abs.getAbsObject(PlaceCommOntology.POSTALADDRESS_STREETNUMBER));
      postCode = (String)onto.toObject(abs.getAbsObject(PlaceCommOntology.POSTALADDRESS_POSTCODE));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising PostalAddress");
     }
   }

}
