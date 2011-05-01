package au.edu.latrobe.placecomm.ontology.j2se;


import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: Context
* @author ontology bean generator
* @version 2011/04/28, 11:06:16
*/
public class Context implements Predicate {

   /**
* Protege name: hasTimeInstance
   */
   private List hasTimeInstance = new ArrayList();
   public void addHasTimeInstance(TimeInstance elem) { 
     List oldList = this.hasTimeInstance;
     hasTimeInstance.add(elem);
   }
   public boolean removeHasTimeInstance(TimeInstance elem) {
     List oldList = this.hasTimeInstance;
     boolean result = hasTimeInstance.remove(elem);
     return result;
   }
   public void clearAllHasTimeInstance() {
     List oldList = this.hasTimeInstance;
     hasTimeInstance.clear();
   }
   public Iterator getAllHasTimeInstance() {return hasTimeInstance.iterator(); }
   public List getHasTimeInstance() {return hasTimeInstance; }
   public void setHasTimeInstance(List l) {hasTimeInstance = l; }

}
