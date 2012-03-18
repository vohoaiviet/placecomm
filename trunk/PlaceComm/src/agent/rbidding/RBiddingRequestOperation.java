/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package agent.rbidding;
import jade.content.*;
/**
 *
 * @author ATuan
 */
public class RBiddingRequestOperation implements AgentAction {
   // From user Get X for Y price
   private String UserAgentID;
   private String sItem;
   private float fPrice_Y;

   public String getUserAgentID() {
     return UserAgentID;
   }
   public String getItemX() {
     return sItem;
   }
   public float getPriceY() {
     return fPrice_Y;
   }

   public void  setUserAgentID(String UserAgentID) {
     this.UserAgentID=UserAgentID;
   }
   public void  setItemX(String sItem) {
     this.sItem = sItem;
   }
   public void setPriceY(float fPrice_Y) {
     this.fPrice_Y=fPrice_Y ;
   }


}
