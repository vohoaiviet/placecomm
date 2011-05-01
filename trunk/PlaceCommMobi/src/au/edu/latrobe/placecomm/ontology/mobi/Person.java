package au.edu.latrobe.placecomm.ontology.mobi;

import jade.content.abs.*;
import jade.content.onto.*;
import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: Person
* @author ontology bean generator
* @version 2010/12/27, 16:31:17
*/
public class Person extends Agent{ 

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
* Protege name: fullName
   */
   private List fullName = new ArrayList();
   public void addFullName(String elem) { 
     List oldList = this.fullName;
     fullName.add(elem);
   }
   public boolean removeFullName(String elem) {
     List oldList = this.fullName;
     boolean result = fullName.remove(elem);
     return result;
   }
   public void clearAllFullName() {
     List oldList = this.fullName;
     fullName.clear();
   }
   public Iterator getAllFullName() {return fullName.iterator(); }
   public List getFullName() {return fullName; }
   public void setFullName(List l) {fullName = l; }

   /**
* Protege name: mobilephone
   */
   private List mobilephone = new ArrayList();
   public void addMobilephone(String elem) { 
     List oldList = this.mobilephone;
     mobilephone.add(elem);
   }
   public boolean removeMobilephone(String elem) {
     List oldList = this.mobilephone;
     boolean result = mobilephone.remove(elem);
     return result;
   }
   public void clearAllMobilephone() {
     List oldList = this.mobilephone;
     mobilephone.clear();
   }
   public Iterator getAllMobilephone() {return mobilephone.iterator(); }
   public List getMobilephone() {return mobilephone; }
   public void setMobilephone(List l) {mobilephone = l; }

   /**
* Protege name: hasChild
   */
   private List hasChild = new ArrayList();
   public void addHasChild(Object elem) { 
     List oldList = this.hasChild;
     hasChild.add(elem);
   }
   public boolean removeHasChild(Object elem) {
     List oldList = this.hasChild;
     boolean result = hasChild.remove(elem);
     return result;
   }
   public void clearAllHasChild() {
     List oldList = this.hasChild;
     hasChild.clear();
   }
   public Iterator getAllHasChild() {return hasChild.iterator(); }
   public List getHasChild() {return hasChild; }
   public void setHasChild(List l) {hasChild = l; }

   /**
* Protege name: hasParents
   */
   private List hasParents = new ArrayList();
   public void addHasParents(Object elem) { 
     List oldList = this.hasParents;
     hasParents.add(elem);
   }
   public boolean removeHasParents(Object elem) {
     List oldList = this.hasParents;
     boolean result = hasParents.remove(elem);
     return result;
   }
   public void clearAllHasParents() {
     List oldList = this.hasParents;
     hasParents.clear();
   }
   public Iterator getAllHasParents() {return hasParents.iterator(); }
   public List getHasParents() {return hasParents; }
   public void setHasParents(List l) {hasParents = l; }

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
* Protege name: email
   */
   private List email = new ArrayList();
   public void addEmail(String elem) { 
     List oldList = this.email;
     email.add(elem);
   }
   public boolean removeEmail(String elem) {
     List oldList = this.email;
     boolean result = email.remove(elem);
     return result;
   }
   public void clearAllEmail() {
     List oldList = this.email;
     email.clear();
   }
   public Iterator getAllEmail() {return email.iterator(); }
   public List getEmail() {return email; }
   public void setEmail(List l) {email = l; }

   /**
* Protege name: friendOf
   */
   private List friendOf = new ArrayList();
   public void addFriendOf(Object elem) { 
     List oldList = this.friendOf;
     friendOf.add(elem);
   }
   public boolean removeFriendOf(Object elem) {
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
* Protege name: DOB
   */
   private String doB;
   public void setDOB(String value) { 
    this.doB=value;
   }
   public String getDOB() {
     return this.doB;
   }

   /**
* Protege name: personPresenceAtPlace
   */
   private List personPresenceAtPlace = new ArrayList();
   public void addPersonPresenceAtPlace(Place elem) { 
     List oldList = this.personPresenceAtPlace;
     personPresenceAtPlace.add(elem);
   }
   public boolean removePersonPresenceAtPlace(Place elem) {
     List oldList = this.personPresenceAtPlace;
     boolean result = personPresenceAtPlace.remove(elem);
     return result;
   }
   public void clearAllPersonPresenceAtPlace() {
     List oldList = this.personPresenceAtPlace;
     personPresenceAtPlace.clear();
   }
   public Iterator getAllPersonPresenceAtPlace() {return personPresenceAtPlace.iterator(); }
   public List getPersonPresenceAtPlace() {return personPresenceAtPlace; }
   public void setPersonPresenceAtPlace(List l) {personPresenceAtPlace = l; }

   /**
* Protege name: getMarriedTo
   */
   private List getMarriedTo = new ArrayList();
   public void addGetMarriedTo(Object elem) { 
     List oldList = this.getMarriedTo;
     getMarriedTo.add(elem);
   }
   public boolean removeGetMarriedTo(Object elem) {
     List oldList = this.getMarriedTo;
     boolean result = getMarriedTo.remove(elem);
     return result;
   }
   public void clearAllGetMarriedTo() {
     List oldList = this.getMarriedTo;
     getMarriedTo.clear();
   }
   public Iterator getAllGetMarriedTo() {return getMarriedTo.iterator(); }
   public List getGetMarriedTo() {return getMarriedTo; }
   public void setGetMarriedTo(List l) {getMarriedTo = l; }

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

   /**
* Protege name: age
   */
   private int age;
   public void setAge(int value) { 
    this.age=value;
   }
   public int getAge() {
     return this.age;
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
* Protege name: hasPersonalContext
   */
   private List hasPersonalContext = new ArrayList();
   public void addHasPersonalContext(PersonalContext elem) { 
     List oldList = this.hasPersonalContext;
     hasPersonalContext.add(elem);
   }
   public boolean removeHasPersonalContext(PersonalContext elem) {
     List oldList = this.hasPersonalContext;
     boolean result = hasPersonalContext.remove(elem);
     return result;
   }
   public void clearAllHasPersonalContext() {
     List oldList = this.hasPersonalContext;
     hasPersonalContext.clear();
   }
   public Iterator getAllHasPersonalContext() {return hasPersonalContext.iterator(); }
   public List getHasPersonalContext() {return hasPersonalContext; }
   public void setHasPersonalContext(List l) {hasPersonalContext = l; }

   /**
* Protege name: hasCurrentLocation
   */
   private List hasCurrentLocation = new ArrayList();
   public void addHasCurrentLocation(Location elem) { 
     List oldList = this.hasCurrentLocation;
     hasCurrentLocation.add(elem);
   }
   public boolean removeHasCurrentLocation(Location elem) {
     List oldList = this.hasCurrentLocation;
     boolean result = hasCurrentLocation.remove(elem);
     return result;
   }
   public void clearAllHasCurrentLocation() {
     List oldList = this.hasCurrentLocation;
     hasCurrentLocation.clear();
   }
   public Iterator getAllHasCurrentLocation() {return hasCurrentLocation.iterator(); }
   public List getHasCurrentLocation() {return hasCurrentLocation; }
   public void setHasCurrentLocation(List l) {hasCurrentLocation = l; }

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

  public void externalise(AbsObject absObj, Ontology onto) throws OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      abs.set(PlacecommOntology.PERSON_LASTNAME, (AbsTerm) onto.fromObject(getLastName()));
      abs.set(PlacecommOntology.PERSON_FULLNAME, (AbsTerm) onto.fromObject(getFullName()));
      abs.set(PlacecommOntology.PERSON_MOBILEPHONE, (AbsTerm) onto.fromObject(getMobilephone()));
      abs.set(PlacecommOntology.PERSON_HASCHILD, (AbsTerm) onto.fromObject(getHasChild()));
      abs.set(PlacecommOntology.PERSON_HASPARENTS, (AbsTerm) onto.fromObject(getHasParents()));
      abs.set(PlacecommOntology.PERSON_MIDDLENAME, (AbsTerm) onto.fromObject(getMiddleName()));
      abs.set(PlacecommOntology.PERSON_EMAIL, (AbsTerm) onto.fromObject(getEmail()));
      abs.set(PlacecommOntology.PERSON_FRIENDOF, (AbsTerm) onto.fromObject(getFriendOf()));
      abs.set(PlacecommOntology.PERSON_DOB, (AbsTerm) onto.fromObject(getDOB()));
      abs.set(PlacecommOntology.PERSON_PERSONPRESENCEATPLACE, (AbsTerm) onto.fromObject(getPersonPresenceAtPlace()));
      abs.set(PlacecommOntology.PERSON_GETMARRIEDTO, (AbsTerm) onto.fromObject(getGetMarriedTo()));
      abs.set(PlacecommOntology.PERSON_OWNDEVICE, (AbsTerm) onto.fromObject(getOwnDevice()));
      abs.set(PlacecommOntology.PERSON_AGE, age);
      abs.set(PlacecommOntology.PERSON_FIRSTNAME, (AbsTerm) onto.fromObject(getFirstName()));
      abs.set(PlacecommOntology.PERSON_HASPERSONALCONTEXT, (AbsTerm) onto.fromObject(getHasPersonalContext()));
      abs.set(PlacecommOntology.PERSON_HASCURRENTLOCATION, (AbsTerm) onto.fromObject(getHasCurrentLocation()));
      abs.set(PlacecommOntology.PERSON_KNOWS, (AbsTerm) onto.fromObject(getKnows()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising Person");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      lastName = (String)onto.toObject(abs.getAbsObject(PlacecommOntology.PERSON_LASTNAME));
      fullName = (List)onto.toObject(abs.getAbsObject(PlacecommOntology.PERSON_FULLNAME));
      mobilephone = (List)onto.toObject(abs.getAbsObject(PlacecommOntology.PERSON_MOBILEPHONE));
      hasChild = (List)onto.toObject(abs.getAbsObject(PlacecommOntology.PERSON_HASCHILD));
      hasParents = (List)onto.toObject(abs.getAbsObject(PlacecommOntology.PERSON_HASPARENTS));
      middleName = (String)onto.toObject(abs.getAbsObject(PlacecommOntology.PERSON_MIDDLENAME));
      email = (List)onto.toObject(abs.getAbsObject(PlacecommOntology.PERSON_EMAIL));
      friendOf = (List)onto.toObject(abs.getAbsObject(PlacecommOntology.PERSON_FRIENDOF));
      doB = (String)onto.toObject(abs.getAbsObject(PlacecommOntology.PERSON_DOB));
      personPresenceAtPlace = (List)onto.toObject(abs.getAbsObject(PlacecommOntology.PERSON_PERSONPRESENCEATPLACE));
      getMarriedTo = (List)onto.toObject(abs.getAbsObject(PlacecommOntology.PERSON_GETMARRIEDTO));
      ownDevice = (List)onto.toObject(abs.getAbsObject(PlacecommOntology.PERSON_OWNDEVICE));
      age = abs.getInteger(PlacecommOntology.PERSON_AGE);
      firstName = (String)onto.toObject(abs.getAbsObject(PlacecommOntology.PERSON_FIRSTNAME));
      hasPersonalContext = (List)onto.toObject(abs.getAbsObject(PlacecommOntology.PERSON_HASPERSONALCONTEXT));
      hasCurrentLocation = (List)onto.toObject(abs.getAbsObject(PlacecommOntology.PERSON_HASCURRENTLOCATION));
      knows = (List)onto.toObject(abs.getAbsObject(PlacecommOntology.PERSON_KNOWS));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising Person");
     }
   }

}
