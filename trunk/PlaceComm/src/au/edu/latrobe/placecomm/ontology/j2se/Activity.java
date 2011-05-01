package au.edu.latrobe.placecomm.ontology.j2se;


import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: Activity
* @author ontology bean generator
* @version 2011/04/28, 11:06:16
*/
public class Activity implements Predicate {

   /**
* Protege name: hasPersonInvolved
   */
   private List hasPersonInvolved = new ArrayList();
   public void addHasPersonInvolved(Person elem) { 
     List oldList = this.hasPersonInvolved;
     hasPersonInvolved.add(elem);
   }
   public boolean removeHasPersonInvolved(Person elem) {
     List oldList = this.hasPersonInvolved;
     boolean result = hasPersonInvolved.remove(elem);
     return result;
   }
   public void clearAllHasPersonInvolved() {
     List oldList = this.hasPersonInvolved;
     hasPersonInvolved.clear();
   }
   public Iterator getAllHasPersonInvolved() {return hasPersonInvolved.iterator(); }
   public List getHasPersonInvolved() {return hasPersonInvolved; }
   public void setHasPersonInvolved(List l) {hasPersonInvolved = l; }

}
