/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package au.edu.latrobe.placecomm.agents;

/**
 *
 * @author ATuan
 */
public class RBiddingOperation implements java.io.Serializable {
 private String UserAgentId;
 private String ShopAgentId;
 private float price_y;
 private float price_y_offer;

 public String getUserAgentID(){
     return UserAgentId;
 }
 public String getShopAgentID(){
     return ShopAgentId;
 }

 public float getPrice_Y(){
     return  price_y;
 }

 public float getPrice_Y_offer(){
      return price_y_offer;
 }


 public void setUserAgentID(String UserAgentId){
     this.UserAgentId=UserAgentId;
 }
 public void setShopAgentID(String ShopAgentId){
     this.ShopAgentId = ShopAgentId;
 }
 
 public void setPrice_Y(float price_y){
     this.price_y = price_y;
 }

 public void setPrice_Y_offer(float price_y_offer){
      this.price_y_offer=price_y_offer;
 }

}
