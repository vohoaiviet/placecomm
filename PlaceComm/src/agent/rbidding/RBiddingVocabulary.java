/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package agent.rbidding;

/**
 *
 * @author ATuan
 */
public interface RBiddingVocabulary {
   /* Process the protocol:
    * CommunityAgent: RBID_X_FOR_Y(UserAgentID:ID,ItemX:nameX,PriceY:NumY),
    * Shop agent offer to User Agent: RBID_Y_FOR_X(ShopAgentID, PriceY,ItemX)
    *    Shop agent generate a random price +/- 15% in the range of Y price.
    * User Agent received: Increased Message received 1 and add price into
    * list after 15 minutes, find the smallest.
    *
   */
   public static final String RBIDDINGPROTOCOL= "RBIDDINGPROTOCOL";
   public static final String RBIDDING = "RBIDDING";
   public static final String RBID_X_FOR_Y = "RBID_X_FOR_Y";
   public static final String RBID_OFFER_Y_FOR_X = "RBID_OFFER_Y_FOR_X";
   
   public static final String OPERATIONS = "OPERATIONS";
   
   public static final String USERAGENT = "USERAGENT";
   public static final String USERAGENTID = "USERAGENTID";
   
   public static final String SHOPAGENT = "SHOPAGENT";
   public static final String SHOPAGENTID = "SHOPAGENTID";
   public static final String ITEM_X = "ITEM_X";
   public static final String PRICE_Y = "PRICE_Y";
   public static final String PRICE_Y_OFFER = "PRICE_Y_OFFER";
   public static final String DEAL = "DEAL";

}
