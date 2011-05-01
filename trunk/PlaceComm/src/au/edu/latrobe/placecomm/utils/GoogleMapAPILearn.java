/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package au.edu.latrobe.placecomm.utils;
import com.google.gdata.client.*;
import com.google.gdata.client.maps.*;
import com.google.gdata.data.*;
import com.google.gdata.data.maps.*;
import com.google.gdata.util.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.util.*;


import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.*;


/**
 *
 * @author ATuan
 */
public class GoogleMapAPILearn {

    public static String [] ReverseGeocoding (String lat, String lon){
        String [] results=new String[5];
        try {
            //http://maps.google.com/maps/api/geocode/xml?latlng=-37.781094,145.02954&sensor=false
            String url = "http://maps.google.com/maps/api/geocode/xml?latlng=" + lat + "," + lon + "&sensor=false";
            HttpClient client = new HttpClient();
            GetMethod get = new GetMethod(url);
            int statusCode = client.executeMethod(get);
            if (statusCode != HttpStatus.SC_OK) {
                throw new RuntimeException(" Could not make HTTP  request properly: " + get.getStatusLine());
            }
            InputStream response = get.getResponseBodyAsStream();
            SAXReader reader = new SAXReader();
            Document document = reader.read(response);
            List list=document.selectNodes("//result");
            Iterator iter=list.iterator();
            while(iter.hasNext()){
                Element element=(Element)iter.next();
                Iterator iterator=element.elementIterator("formatted_address");
                while (iterator.hasNext()){
                    Element formattedAddressElement=(Element)iterator.next();
                    //System.out.println(formattedAddressElement.getText().trim());
                }
            }

            list = document.selectNodes("//result/address_component" );
            iter=list.iterator();
            String street_number="",route="", suburb="", postcode="", country="";
             while(iter.hasNext()){
             Element element=(Element)iter.next();
             
             //System.out.println("lAtributes:"+lAtributes+" lAtributes1: "+lAtributes1+" lAtributes2: "+lAtributes2);
             //System.out.println("Atribute Count:"+element.attributeCount());
             //Iterator iterator=element.elementIterator("long_name");
             String sLongname=element.elementText("long_name");
             String sType=element.elementText("type");
             
             if (sType.equals("street_number")){
                 if (sLongname.length()>0) street_number=sLongname;
                //System.out.println("Route name:"+route);
             }else if (sType.equals("route")){
                 if (sLongname.length()>0) route=sLongname;
                //System.out.println("Route name:"+route);
             }else if (sType.equals("postal_code")){
                 if (sLongname.length()>0) postcode=sLongname;
                 //System.out.println("post code:"+postcode);
             }else if (sType.equals("locality")){
                 if (sLongname.length()>0) suburb=sLongname;
                 //System.out.println("locality:"+suburb);
             }else if (sType.equals("country")){
                 if (sLongname.length()>0) country=sLongname;
                 //System.out.println("locality:"+suburb);
             }
              //while(iterator.hasNext()){
              //Element longElement=(Element)iterator.next();
              //System.out.println(longElement.getText().trim());
              //}
             }
             results[0]=street_number;
             results[1]=route;
             results[2]=suburb;
             results[3]=postcode;
             results[4]=country;
            //System.out.println("Number:"+street_number+", route:"+route+
                    //", suburb:"+suburb+", postcode:"+postcode+", country:"+country);

        } catch (DocumentException ex) {
            Logger.getLogger(GoogleMapAPILearn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GoogleMapAPILearn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return results;
    }
    /**
     * @param args the command line arguments
     */
    public String key="ABQIAAAAcVSovcPouThV7nSvSNGePhQ9RpF6vUBIQE_o79nuWHuoIcxFDBSDA2XHHNK8qngxH6yP3ESDj-vDOg";
    public static void main(String[] args) {
        // TODO code application logic here
        // Name your service
        String lat="-37.781094"; String lon="145.02954";
        String [] result=ReverseGeocoding(lat,  lon);
        int isize=result.length; 
        for (int i=0; i<isize; i++){
            System.out.print(" "+result[i]);
        }


      /*
    MapsService myService = new MapsService("applicationName");
    try {
      
      myService.setUserCredentials("anhtuan98","Merdecitd2k!!!");
    } catch(AuthenticationException e) {
    }
    try {
      printUserMaps(myService);
    } catch(ServiceException e) {
    } catch(IOException e) {
    }
*/
    }
    public static void printUserMaps(MapsService myService)
    throws ServiceException, IOException {

    // Request the default metafeed
    final URL feedUrl = new URL("http://maps.google.com/maps/feeds/maps/default/public");
    MapFeed resultFeed = myService.getFeed(feedUrl, MapFeed.class);

    // Print the title of the feed itself.
    System.out.println(resultFeed.getTitle().getPlainText());

    // Iterate through the feed entries (maps) and print out info
    // for each map
    for (int i = 0; i < resultFeed.getEntries().size(); i++) {
      MapEntry entry = resultFeed.getEntries().get(i);
      System.out.println(entry.getTitle().getPlainText());
      System.out.println("  Summary: " + entry.getSummary().getPlainText());
      System.out.println("  Self Link: " + entry.getSelfLink().getHref() +"\n");
    }
  }

}
