package au.edu.latrobe.placecomm.ontology.j2se;


import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: PostalAddress
* @author ontology bean generator
* @version 2011/04/28, 11:06:16
*/
public class PostalAddress implements Predicate {

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

}
