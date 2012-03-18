/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package agent.smartroute;

/**
 *
 * @author ATuan
 */
public class RBiddingRequestFromUserAgent {
   private String UserAgentName;
   private String sItem;
   private float fPrice_Y;

   public String getUserAgentName() {
     return UserAgentName;
   }
   public String getItemX() {
     return sItem;
   }
   public float getPriceY() {
     return fPrice_Y;
   }

   public void setUserAgentName(String UserAgentName) {
     this.UserAgentName =UserAgentName;
   }
   public void setItemX(String sItem) {
     this.sItem=sItem;
   }
   public void setPriceY(float sItem) {
     this.fPrice_Y=sItem;
   }

}
