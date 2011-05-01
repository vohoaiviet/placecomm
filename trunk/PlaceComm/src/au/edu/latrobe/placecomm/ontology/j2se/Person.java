package au.edu.latrobe.placecomm.ontology.j2se;


import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: Person
* @author ontology bean generator
* @version 2011/04/28, 11:06:16
*/
public class Person implements Predicate {

   /**
* Protege name: gotMarried
   */
   private List gotMarried = new ArrayList();
   public void addGotMarried(Person elem) { 
     List oldList = this.gotMarried;
     gotMarried.add(elem);
   }
   public boolean removeGotMarried(Person elem) {
     List oldList = this.gotMarried;
     boolean result = gotMarried.remove(elem);
     return result;
   }
   public void clearAllGotMarried() {
     List oldList = this.gotMarried;
     gotMarried.clear();
   }
   public Iterator getAllGotMarried() {return gotMarried.iterator(); }
   public List getGotMarried() {return gotMarried; }
   public void setGotMarried(List l) {gotMarried = l; }

   /**
* Protege name: emailaddress
   */
   private List emailaddress = new ArrayList();
   public void addEmailaddress(String elem) { 
     List oldList = this.emailaddress;
     emailaddress.add(elem);
   }
   public boolean removeEmailaddress(String elem) {
     List oldList = this.emailaddress;
     boolean result = emailaddress.remove(elem);
     return result;
   }
   public void clearAllEmailaddress() {
     List oldList = this.emailaddress;
     emailaddress.clear();
   }
   public Iterator getAllEmailaddress() {return emailaddress.iterator(); }
   public List getEmailaddress() {return emailaddress; }
   public void setEmailaddress(List l) {emailaddress = l; }

   /**
* Protege name: middleName
   */
   private String middleName;
   public void setMiddleName(String value) { 
    this.middleName=value;
   }
   public String getMiddleName() {
     return this.middleName;
   }

   /**
* Protege name: homepage
   */
   private String homepage;
   public void setHomepage(String value) { 
    this.homepage=value;
   }
   public String getHomepage() {
     return this.homepage;
   }

   /**
* Protege name: hasParent
   */
   private List hasParent = new ArrayList();
   public void addHasParent(Person elem) { 
     List oldList = this.hasParent;
     hasParent.add(elem);
   }
   public boolean removeHasParent(Person elem) {
     List oldList = this.hasParent;
     boolean result = hasParent.remove(elem);
     return result;
   }
   public void clearAllHasParent() {
     List oldList = this.hasParent;
     hasParent.clear();
   }
   public Iterator getAllHasParent() {return hasParent.iterator(); }
   public List getHasParent() {return hasParent; }
   public void setHasParent(List l) {hasParent = l; }

   /**
* Protege name: knows
   */
   private List knows = new ArrayList();
   public void addKnows(Person elem) { 
     List oldList = this.knows;
     knows.add(elem);
   }
   public boolean removeKnows(Person elem) {
     List oldList = this.knows;
     boolean result = knows.remove(elem);
     return result;
   }
   public void clearAllKnows() {
     List oldList = this.knows;
     knows.clear();
   }
   public Iterator getAllKnows() {return knows.iterator(); }
   public List getKnows() {return knows; }
   public void setKnows(List l) {knows = l; }

   /**
* Protege name: personID
   */
   private String personID;
   public void setPersonID(String value) { 
    this.personID=value;
   }
   public String getPersonID() {
     return this.personID;
   }

   /**
* Protege name: personPresenceAtPlace
   */
   private Place personPresenceAtPlace;
   public void setPersonPresenceAtPlace(Place value) { 
    this.personPresenceAtPlace=value;
   }
   public Place getPersonPresenceAtPlace() {
     return this.personPresenceAtPlace;
   }

   /**
* Protege name: friendOf
   */
   private List friendOf = new ArrayList();
   public void addFriendOf(Person elem) { 
     List oldList = this.friendOf;
     friendOf.add(elem);
   }
   public boolean removeFriendOf(Person elem) {
     List oldList = this.friendOf;
     boolean result = friendOf.remove(elem);
     return result;
   }
   public void clearAllFriendOf() {
     List oldList = this.friendOf;
     friendOf.clear();
   }
   public Iterator getAllFriendOf() {return friendOf.iterator(); }
   public List getFriendOf() {return friendOf; }
   public void setFriendOf(List l) {friendOf = l; }

   /**
* Protege name: fullName
   */
   private String fullName;
   public void setFullName(String value) { 
    this.fullName=value;
   }
   public String getFullName() {
     return this.fullName;
   }

   /**
* Protege name: firstName
   */
   private String firstName;
   public void setFirstName(String value) { 
    this.firstName=value;
   }
   public String getFirstName() {
     return this.firstName;
   }

   /**
* Protege name: hasChildren
   */
   private List hasChildren = new ArrayList();
   public void addHasChildren(Person elem) { 
     List oldList = this.hasChildren;
     hasChildren.add(elem);
   }
   public boolean removeHasChildren(Person elem) {
     List oldList = this.hasChildren;
     boolean result = hasChildren.remove(elem);
     return result;
   }
   public void clearAllHasChildren() {
     List oldList = this.hasChildren;
     hasChildren.clear();
   }
   public Iterator getAllHasChildren() {return hasChildren.iterator(); }
   public List getHasChildren() {return hasChildren; }
   public void setHasChildren(List l) {hasChildren = l; }

   /**
* Protege name: lastName
   */
   private String lastName;
   public void setLastName(String value) { 
    this.lastName=value;
   }
   public String getLastName() {
     return this.lastName;
   }

   /**
* Protege name: ownDevice
   */
   private List ownDevice = new ArrayList();
   public void addOwnDevice(Device elem) { 
     List oldList = this.ownDevice;
     ownDevice.add(elem);
   }
   public boolean removeOwnDevice(Device elem) {
     List oldList = this.ownDevice;
     boolean result = ownDevice.remove(elem);
     return result;
   }
   public void clearAllOwnDevice() {
     List oldList = this.ownDevice;
     ownDevice.clear();
   }
   public Iterator getAllOwnDevice() {return ownDevice.iterator(); }
   public List getOwnDevice() {return ownDevice; }
   public void setOwnDevice(List l) {ownDevice = l; }

}
