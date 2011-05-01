package au.edu.latrobe.placecomm.ontology.mobi;


import jade.content.abs.*;
import jade.content.onto.*;
import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: PostalAddress
* @author ontology bean generator
* @version 2010/12/27, 16:31:17
*/
public class PostalAddress implements Concept, Introspectable {

   /**
* Protege name: date
   */
   private List date = new ArrayList();
   public void addDate(String elem) { 
     List oldList = this.date;
     date.add(elem);
   }
   public boolean removeDate(String elem) {
     List oldList = this.date;
     boolean result = date.remove(elem);
     return result;
   }
   public void clearAllDate() {
     List oldList = this.date;
     date.clear();
   }
   public Iterator getAllDate() {return date.iterator(); }
   public List getDate() {return date; }
   public void setDate(List l) {date = l; }

   /**
* Protege name: suburb
   */
   private List suburb = new ArrayList();
   public void addSuburb(String elem) { 
     List oldList = this.suburb;
     suburb.add(elem);
   }
   public boolean removeSuburb(String elem) {
     List oldList = this.suburb;
     boolean result = suburb.remove(elem);
     return result;
   }
   public void clearAllSuburb() {
     List oldList = this.suburb;
     suburb.clear();
   }
   public Iterator getAllSuburb() {return suburb.iterator(); }
   public List getSuburb() {return suburb; }
   public void setSuburb(List l) {suburb = l; }

   /**
* Protege name: postalAddressName
   */
   private List postalAddressName = new ArrayList();
   public void addPostalAddressName(String elem) { 
     List oldList = this.postalAddressName;
     postalAddressName.add(elem);
   }
   public boolean removePostalAddressName(String elem) {
     List oldList = this.postalAddressName;
     boolean result = postalAddressName.remove(elem);
     return result;
   }
   public void clearAllPostalAddressName() {
     List oldList = this.postalAddressName;
     postalAddressName.clear();
   }
   public Iterator getAllPostalAddressName() {return postalAddressName.iterator(); }
   public List getPostalAddressName() {return postalAddressName; }
   public void setPostalAddressName(List l) {postalAddressName = l; }

   /**
* Protege name: Country
   */
   private List country = new ArrayList();
   public void addCountry(String elem) { 
     List oldList = this.country;
     country.add(elem);
   }
   public boolean removeCountry(String elem) {
     List oldList = this.country;
     boolean result = country.remove(elem);
     return result;
   }
   public void clearAllCountry() {
     List oldList = this.country;
     country.clear();
   }
   public Iterator getAllCountry() {return country.iterator(); }
   public List getCountry() {return country; }
   public void setCountry(List l) {country = l; }

   /**
* Protege name: postCode
   */
   private List postCode = new ArrayList();
   public void addPostCode(String elem) { 
     List oldList = this.postCode;
     postCode.add(elem);
   }
   public boolean removePostCode(String elem) {
     List oldList = this.postCode;
     boolean result = postCode.remove(elem);
     return result;
   }
   public void clearAllPostCode() {
     List oldList = this.postCode;
     postCode.clear();
   }
   public Iterator getAllPostCode() {return postCode.iterator(); }
   public List getPostCode() {return postCode; }
   public void setPostCode(List l) {postCode = l; }

   /**
* Protege name: streetName
   */
   private List streetName = new ArrayList();
   public void addStreetName(String elem) { 
     List oldList = this.streetName;
     streetName.add(elem);
   }
   public boolean removeStreetName(String elem) {
     List oldList = this.streetName;
     boolean result = streetName.remove(elem);
     return result;
   }
   public void clearAllStreetName() {
     List oldList = this.streetName;
     streetName.clear();
   }
   public Iterator getAllStreetName() {return streetName.iterator(); }
   public List getStreetName() {return streetName; }
   public void setStreetName(List l) {streetName = l; }

   /**
* Protege name: streetNumber
   */
   private List streetNumber = new ArrayList();
   public void addStreetNumber(String elem) { 
     List oldList = this.streetNumber;
     streetNumber.add(elem);
   }
   public boolean removeStreetNumber(String elem) {
     List oldList = this.streetNumber;
     boolean result = streetNumber.remove(elem);
     return result;
   }
   public void clearAllStreetNumber() {
     List oldList = this.streetNumber;
     streetNumber.clear();
   }
   public Iterator getAllStreetNumber() {return streetNumber.iterator(); }
   public List getStreetNumber() {return streetNumber; }
   public void setStreetNumber(List l) {streetNumber = l; }

  public void externalise(AbsObject absObj, Ontology onto) throws OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      abs.set(PlacecommOntology.POSTALADDRESS_DATE, (AbsTerm) onto.fromObject(getDate()));
      abs.set(PlacecommOntology.POSTALADDRESS_SUBURB, (AbsTerm) onto.fromObject(getSuburb()));
      abs.set(PlacecommOntology.POSTALADDRESS_POSTALADDRESSNAME, (AbsTerm) onto.fromObject(getPostalAddressName()));
      abs.set(PlacecommOntology.POSTALADDRESS_COUNTRY, (AbsTerm) onto.fromObject(getCountry()));
      abs.set(PlacecommOntology.POSTALADDRESS_POSTCODE, (AbsTerm) onto.fromObject(getPostCode()));
      abs.set(PlacecommOntology.POSTALADDRESS_STREETNAME, (AbsTerm) onto.fromObject(getStreetName()));
      abs.set(PlacecommOntology.POSTALADDRESS_STREETNUMBER, (AbsTerm) onto.fromObject(getStreetNumber()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising PostalAddress");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      date = (List)onto.toObject(abs.getAbsObject(PlacecommOntology.POSTALADDRESS_DATE));
      suburb = (List)onto.toObject(abs.getAbsObject(PlacecommOntology.POSTALADDRESS_SUBURB));
      postalAddressName = (List)onto.toObject(abs.getAbsObject(PlacecommOntology.POSTALADDRESS_POSTALADDRESSNAME));
      country = (List)onto.toObject(abs.getAbsObject(PlacecommOntology.POSTALADDRESS_COUNTRY));
      postCode = (List)onto.toObject(abs.getAbsObject(PlacecommOntology.POSTALADDRESS_POSTCODE));
      streetName = (List)onto.toObject(abs.getAbsObject(PlacecommOntology.POSTALADDRESS_STREETNAME));
      streetNumber = (List)onto.toObject(abs.getAbsObject(PlacecommOntology.POSTALADDRESS_STREETNUMBER));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising PostalAddress");
     }
   }

}
