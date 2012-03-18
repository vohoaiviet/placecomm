/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package agent.rbidding;
import agent.RBiddingOperation;
import jade.content.onto.*;
import jade.content.schema.*;


/**
 *
 * @author ATuan
 */
public class RBiddingOntology extends Ontology implements RBiddingVocabulary {
    
 public static final String ONTOLOGY_NAME = "RBidding-Ontology";

   // ----------> The singleton instance of this ontology
   private static Ontology instance = new RBiddingOntology();

   // ----------> Method to access the singleton ontology object
   public static Ontology getInstance() { return instance; }


   // Private constructor
   private RBiddingOntology() {

     super(ONTOLOGY_NAME, BasicOntology.getInstance());
     try{
         // ------- Add Concepts

         // User
         ConceptSchema cs = new ConceptSchema(USERAGENT);
         add(cs, UserAgent.class);
         cs.add(USERAGENTID, (PrimitiveSchema) getSchema(BasicOntology.STRING),
                 ObjectSchema.MANDATORY);
         cs.add(ITEM_X, (PrimitiveSchema) getSchema(BasicOntology.STRING),
                 ObjectSchema.MANDATORY);
         cs.add(PRICE_Y, (PrimitiveSchema) getSchema(BasicOntology.FLOAT),
                 ObjectSchema.MANDATORY);


         // Shop
         add(cs = new ConceptSchema(SHOPAGENT), ShopAgent.class);
         cs.add(PRICE_Y_OFFER, (PrimitiveSchema)getSchema(BasicOntology.FLOAT),ObjectSchema.MANDATORY);

         // Operation
         add(cs = new ConceptSchema(OPERATIONS), RBiddingOfferFromShopAgent.class);
         cs.add(RBID_X_FOR_Y, (PrimitiveSchema) getSchema(BasicOntology.FLOAT), ObjectSchema.MANDATORY);
         cs.add(RBID_OFFER_Y_FOR_X, (PrimitiveSchema) getSchema(BasicOntology.FLOAT), ObjectSchema.MANDATORY);
         //cs.add(OPERATION_ACCOUNTID, (PrimitiveSchema) getSchema(BasicOntology.STRING), ObjectSchema.MANDATORY);
         //cs.add(OPERATION_DATE, (PrimitiveSchema) getSchema(BasicOntology.DATE), ObjectSchema.MANDATORY);

         // ------- Add AgentActions

         // User Agent Ask X for Y, Community Agent ask X for Y 
         AgentActionSchema as = new AgentActionSchema(RBIDDING);
         add(as, RBiddingOperation.class);
         as.add(RBID_X_FOR_Y, (PrimitiveSchema) getSchema(BasicOntology.FLOAT),
                 ObjectSchema.MANDATORY);
         as.add(RBID_OFFER_Y_FOR_X, (PrimitiveSchema) getSchema(BasicOntology.FLOAT),
                 ObjectSchema.MANDATORY);


     }catch(OntologyException oe) {
         oe.printStackTrace();
      }
   }
   
}
