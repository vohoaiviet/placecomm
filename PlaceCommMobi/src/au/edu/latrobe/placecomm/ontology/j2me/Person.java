package au.edu.latrobe.placecomm.ontology.j2me;


import jade.content.abs.*;
import jade.content.onto.*;
import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: Person
* @author ontology bean generator
* @version 2011/04/28, 11:06:23
*/
public class Person implements Predicate, Introspectable {

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

  public void externalise(AbsObject absObj, Ontology onto) throws OntologyException {
    try {
      AbsPredicate abs = (AbsPredicate) absObj;
      abs.set(PlaceCommOntology.PERSON_GOTMARRIED, (AbsTerm) onto.fromObject(getGotMarried()));
      abs.set(PlaceCommOntology.PERSON_EMAILADDRESS, (AbsTerm) onto.fromObject(getEmailaddress()));
      abs.set(PlaceCommOntology.PERSON_MIDDLENAME, (AbsTerm) onto.fromObject(getMiddleName()));
      abs.set(PlaceCommOntology.PERSON_HOMEPAGE, (AbsTerm) onto.fromObject(getHomepage()));
      abs.set(PlaceCommOntology.PERSON_HASPARENT, (AbsTerm) onto.fromObject(getHasParent()));
      abs.set(PlaceCommOntology.PERSON_KNOWS, (AbsTerm) onto.fromObject(getKnows()));
      abs.set(PlaceCommOntology.PERSON_PERSONID, (AbsTerm) onto.fromObject(getPersonID()));
      abs.set(PlaceCommOntology.PERSON_PERSONPRESENCEATPLACE, (AbsTerm) onto.fromObject(getPersonPresenceAtPlace()));
      abs.set(PlaceCommOntology.PERSON_FRIENDOF, (AbsTerm) onto.fromObject(getFriendOf()));
      abs.set(PlaceCommOntology.PERSON_FULLNAME, (AbsTerm) onto.fromObject(getFullName()));
      abs.set(PlaceCommOntology.PERSON_FIRSTNAME, (AbsTerm) onto.fromObject(getFirstName()));
      abs.set(PlaceCommOntology.PERSON_HASCHILDREN, (AbsTerm) onto.fromObject(getHasChildren()));
      abs.set(PlaceCommOntology.PERSON_LASTNAME, (AbsTerm) onto.fromObject(getLastName()));
      abs.set(PlaceCommOntology.PERSON_OWNDEVICE, (AbsTerm) onto.fromObject(getOwnDevice()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising Person");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException {
    try {
      AbsPredicate abs = (AbsPredicate) absObj;
      gotMarried = (List)onto.toObject(abs.getAbsObject(PlaceCommOntology.PERSON_GOTMARRIED));
      emailaddress = (List)onto.toObject(abs.getAbsObject(PlaceCommOntology.PERSON_EMAILADDRESS));
      middleName = (String)onto.toObject(abs.getAbsObject(PlaceCommOntology.PERSON_MIDDLENAME));
      homepage = (String)onto.toObject(abs.getAbsObject(PlaceCommOntology.PERSON_HOMEPAGE));
      hasParent = (List)onto.toObject(abs.getAbsObject(PlaceCommOntology.PERSON_HASPARENT));
      knows = (List)onto.toObject(abs.getAbsObject(PlaceCommOntology.PERSON_KNOWS));
      personID = (String)onto.toObject(abs.getAbsObject(PlaceCommOntology.PERSON_PERSONID));
      personPresenceAtPlace = (Place)onto.toObject(abs.getAbsObject(PlaceCommOntology.PERSON_PERSONPRESENCEATPLACE));
      friendOf = (List)onto.toObject(abs.getAbsObject(PlaceCommOntology.PERSON_FRIENDOF));
      fullName = (String)onto.toObject(abs.getAbsObject(PlaceCommOntology.PERSON_FULLNAME));
      firstName = (String)onto.toObject(abs.getAbsObject(PlaceCommOntology.PERSON_FIRSTNAME));
      hasChildren = (List)onto.toObject(abs.getAbsObject(PlaceCommOntology.PERSON_HASCHILDREN));
      lastName = (String)onto.toObject(abs.getAbsObject(PlaceCommOntology.PERSON_LASTNAME));
      ownDevice = (List)onto.toObject(abs.getAbsObject(PlaceCommOntology.PERSON_OWNDEVICE));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising Person");
     }
   }

}
