package au.edu.latrobe.placecomm.ontology.j2se;


import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: HasQuery
* @author ontology bean generator
* @version 2011/04/28, 11:06:16
*/
public class HasQuery implements Predicate {

   /**
* Protege name: sQueryResult
   */
   private String sQueryResult;
   public void setSQueryResult(String value) { 
    this.sQueryResult=value;
   }
   public String getSQueryResult() {
     return this.sQueryResult;
   }

   /**
* Protege name: sQuery
   */
   private String sQuery;
   public void setSQuery(String value) { 
    this.sQuery=value;
   }
   public String getSQuery() {
     return this.sQuery;
   }

}
