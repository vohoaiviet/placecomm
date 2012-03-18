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
public class RBiddingOfferFromShopAgent implements AgentAction{

    private float fPrice_Y;
    private String sShopAgentID;
    private String sItem;
    private String UserAgentID;


    public String getShopAgentID() {
     return sShopAgentID;
    }

   public String getUserAgentID() {
     return UserAgentID;
   }
   public String getItemX() {
     return sItem;
   }
   public float getPriceY() {
     return fPrice_Y;
   }

   public void setUserAgentName(String UserAgentID) {
     this.UserAgentID =UserAgentID;
   }

    public void setShopAgentName(String sShopAgentID) {
     this.sShopAgentID =sShopAgentID;
   }
   public void setItemX(String sItem) {
     this.sItem=sItem;
   }
   public void setPriceY(float sItem) {
     this.fPrice_Y=sItem;
   }


}
