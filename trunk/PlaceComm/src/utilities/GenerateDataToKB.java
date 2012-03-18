/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utilities;
import com.hp.hpl.jena.ontology.OntModel;
import edu.stanford.smi.protege.model.KnowledgeBase;
import edu.stanford.smi.protege.model.Project;
import edu.stanford.smi.protegex.owl.model.OWLModel;
import java.net.URI;
import java.util.*;
import java.util.logging.*;
import java.io.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;



import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;
import org.dom4j.*;
import org.dom4j.io.*;


import com.hp.hpl.jena.query.*;
import com.hp.hpl.jena.rdf.arp.impl.Location;

import com.hp.hpl.jena.util.FileUtils;
import edu.stanford.smi.protege.model.*;
import edu.stanford.smi.protege.widget.*;
import edu.stanford.smi.protege.resource.*;

import edu.stanford.smi.protege.exception.OntologyLoadException;
import edu.stanford.smi.protege.model.KnowledgeBaseFactory;
import edu.stanford.smi.protegex.owl.model.OWLModel;
import edu.stanford.smi.protegex.owl.model.OWLNamedClass;
import edu.stanford.smi.protegex.owl.ProtegeOWL;
import edu.stanford.smi.protegex.owl.jena.JenaOWLModel;
import edu.stanford.smi.protegex.owl.model.OWLDatatypeProperty;
import edu.stanford.smi.protegex.owl.model.OWLObjectProperty;
import edu.stanford.smi.protegex.owl.model.RDFIndividual;
import edu.stanford.smi.protegex.owl.model.query.QueryResults;
import javax.swing.table.DefaultTableModel;
import jess.*;


/**
 *
 * @author ATuan
 */
public class GenerateDataToKB extends Thread{

    public Project getProject() {
       return this.prj;
    }

    private Project prj;
    private KnowledgeBase kb;
    private String sLine;
    private String sPrjBase;
    private String sPrjFile;
    private String sProjectFullPath;

    private String sDataSetFilename;
    private long lNumberOfWillBeGenerated=0;
    private long lStep=0;
    private long lNumOfLines=0;
    private static Logger theLogger =
	 Logger.getLogger(GenerateDataToKB.class.getName());
    private static FileHandler fileTxt;
    private static SimpleFormatter formatterTxt;
    private String sURI="http://www.tuannguyen.mobi/ontologies/2010/tinypbvc.owl#";
    private List list1=new ArrayList();

    
    public GenerateDataToKB(String sPrjBase, String sPrjFile,String sURI,
            String sDataSetFilename, long lNumberOfWillBeGenerated)
    {
        this.sURI=sURI;        
        this.sDataSetFilename=sDataSetFilename;
        this.sPrjBase= sPrjBase;
        this.sPrjFile=  sPrjFile;
        sProjectFullPath=sPrjBase+sPrjFile;

        this.lNumberOfWillBeGenerated=lNumberOfWillBeGenerated;
         try{
        formatterTxt = new SimpleFormatter();
        fileTxt = new FileHandler("KB"+sPrjFile+".log",true);
        fileTxt.setFormatter(formatterTxt);
        theLogger.addHandler(fileTxt);
        }catch(Exception e){
            theLogger.severe(e.toString());
        }

        this.lNumOfLines = LoadInstancesFromFile(sDataSetFilename);
        if (lNumberOfWillBeGenerated > 0){
        lStep=lNumberOfWillBeGenerated / lNumOfLines ;
        }else {
          lStep=0;
        }
        theLogger.info("Thread information: lStep="+lStep);
        theLogger.info("Project full path: "+sProjectFullPath);

        Collection errors = new ArrayList();
        try{
            Date d1=new Date();
            this.prj = Project.loadProjectFromFile(sProjectFullPath,errors);
            this.kb=this.prj.getKnowledgeBase();
            Date d2=new Date();
            theLogger.info("Load project in "+(d2.getTime()-d1.getTime())+" ms");
        }catch (Exception e){
            theLogger.severe("Load project:"+sProjectFullPath+" failed: "+e.toString());
        }

    }
    
    public void run()
    {
        try
        {
          theLogger.info("Start load dataset");
           ImportToKB(sDataSetFilename);
          theLogger.info("Loaded DataSet successfully");
        }
        catch( Exception e)
        {
           theLogger.severe("Load dataset :"+sDataSetFilename+" failed: "+e.toString());
        }
        finally
        {
            // Clean up, if necessary
            
        }
    }

    public long LoadInstancesFromFile(String sFilename){

    try{
        FileInputStream fstream = new FileInputStream(sFilename);
        // Get the object of DataInputStream
        DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String strLine;
        //Read File Line By Line
        while ((strLine = br.readLine()) != null)   {
        // Print the content on the console
            lNumOfLines++;
            list1.add(strLine.trim());
        }
        //Close the input stream
        
    }catch (Exception e){//Catch exception if any
        System.err.println("Error reading file: " +sFilename+" exception: "+ e.getMessage());
    }
    return lNumOfLines;
    }

  public void ImportToKB(String sDataSetFilename){
        FileInputStream fstream = null;
        try {
            fstream = new FileInputStream(sDataSetFilename);
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            //Read File Line By Line
            // Pattern
            //A:001ADCD54B7C,N:www.tuannguyen.mobi,T:Sat Oct 03 15:03:08 GMT+10:00 2009,
            //D:1254546188143,S:2.8888700008392334,Lat:-37.751601666666666,Lon:145.049495,
            //Alt:59.15999984741211
            String sNextLine = "";
            long lCount = 0;

            String sBTAddress = "", sBTName ="",sDate ="",sTimestamp ="",
                    sSpeed ="",sLat ="", sLon ="",sAlt ="";
            String sLatNext ="",sLonNext ="";

            while ((strLine = br.readLine().trim()) != null) {
                //lCount++;
                System.out.println(strLine );
                String[] s = strLine.split(",");
                try{
                    sBTAddress = s[0].substring(2);
                    sBTName = s[1].substring(2);
                    sDate = s[2].substring(2);
                    sTimestamp = s[3].substring(2);
                    sSpeed = s[4].substring(2);
                    sLat = s[5].substring(4);
                    sLon = s[6].substring(4);
                    sAlt = s[7].substring(4);
                }catch(Exception e){
                    theLogger.severe("Parsing values error:"+e.toString());
                }
                try {
                    sNextLine = br.readLine().trim();
                } catch (Exception e) {
                    theLogger.severe("End of input");
                    sNextLine = null;
                }
                if (sNextLine != null) {
                    // System.out.println("Read next line ");
                    String[] sNext = sNextLine.split(",");
                    sLatNext = sNext[5].substring(4);
                    sLonNext = sNext[6].substring(4);
                    // skip if location has not change
                    if ((sLat.equals(sLatNext)) && (sLon.equals(sLonNext))) {
                        System.out.println("Skip this line because the same value");
                    } else {
                        float fLat = Float.valueOf(sLat);
                        float fLon = Float.valueOf(sLon);
                        float fAlt = Float.valueOf(sAlt);
                        float fSpeed = Float.valueOf(sSpeed);
                        // Create new Location;
                        InsertInstance(fLat, fLon, fAlt, fSpeed, sDate, sTimestamp, sBTAddress, sBTName, sURI);
                        
                        //theLogger.info(fLat+fLon+fAlt+fSpeed+sDate+sTimestamp+sBTAddress+sBTName+sURI);
                        //theLogger.info("Origin speed:"+fSpeed);
                        // Generated
                        if (lStep > 2) {
                            for (int iNum = 0; iNum < lStep - 1; iNum++) {
                                Random randomGenerator = new Random();
                                int randomInt = randomGenerator.nextInt(1000);
                                float f = (float) randomInt / 10000.0f;
                                float newfSpeed = 0;
                                if ((randomInt % 2) == 0) {
                                    newfSpeed = fSpeed + fSpeed * f;
                                } else {
                                    newfSpeed = fSpeed - fSpeed * f;
                                }
                                InsertInstance(fLat, fLon, fAlt, newfSpeed, sDate, sTimestamp, sBTAddress, sBTName, sURI);
                                theLogger.info("Timestamp:" + sTimestamp + " generated speed:" + newfSpeed );
                             
                            } // End for
                            // End for
                        }
                        theLogger.info("Instance created success0fully");
                    }
                }

            }// End while
            //Close the input stream
            //in.close();

       // } catch (InterruptedException ex) {
       //     theLogger.severe("InterruptedException "+ex.toString());        }
        } catch (IOException ex) {
            theLogger.severe("IOException 123: "+ex.toString());
        } catch (Exception ex) {
            theLogger.severe("Exception here: "+ ex.toString());
        } finally {
            try {
                fstream.close();
            } catch (IOException ex) {
                Logger.getLogger(GenerateDataToKB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


  }

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
            Random randomSleepGenerator = new Random();
            int randomSleepInt = randomSleepGenerator.nextInt(100);
            try {
                Thread.sleep(randomSleepInt);
            } catch (InterruptedException ex) {
                Logger.getLogger(GenerateDataToKB.class.getName()).log(Level.SEVERE, null, ex);
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
            
        } catch (IOException ex) {
            
        }
        return results;
    }

   public Instance CreatePlaceByReverseGeocoding (String sURI, String lat, String lon, String sTimestamp){
        Instance instanceResult=null;
        String [] results=new String[5];
        theLogger.info("Inside CreatePlaceByReverseGeocoding using Google, lat:"+lat+", lon:"+lon);
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
            /*List list=document.selectNodes("//result");
            Iterator iter=list.iterator();
            while(iter.hasNext()){
                Element element=(Element)iter.next();
                Iterator iterator=element.elementIterator("formatted_address");
                while (iterator.hasNext()){
                    Element formattedAddressElement=(Element)iterator.next();
                }
            }*/
            List list = document.selectNodes("//result/address_component" );
            Iterator iter=list.iterator();
            String street_number="",route="", suburb="", postcode="", country="";
             while(iter.hasNext()){
             Element element=(Element)iter.next();

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

             theLogger.info("Number:"+street_number+", route:"+route+
                    ", suburb:"+suburb+", postcode:"+postcode+", country:"+country);
             instanceResult=CreatePlaceByAddress(sURI, street_number, route,
                     suburb,postcode,country, sTimestamp);

        } catch (DocumentException ex) {
            theLogger.severe(ex.toString());
        } catch (IOException ex) {
            theLogger.severe(ex.toString());
        } catch (Exception ex) {
            theLogger.severe(ex.toString());
        }
        return instanceResult;
    }

    public Instance CreatePlaceByAddress(String sURI, String street_number,
            String route, String suburb, String postcode, String country, String sTimestamp){
        Instance instanceToAddTo=null;
        // Create Instance for PostalAddress
        //http://www.tuannguyen.mobi/ontologies/2010/tinypbvc.owl#PostalAddress

        theLogger.info("Inside CreatePlaceByAddress");


            String ssURI=sURI+"PostalAddress";
            Cls cPostalAddress =kb.getCls(ssURI);

            String streetNumberURI= sURI+"streetNumber";
            String streetNameURI= sURI+"streetName";
            String suburbURI= sURI+"suburb";
            String CountryURI= sURI+"Country";
            String postCodeURI= sURI+"postCode";
            String timestampURI= sURI+"timestamp";
            String streetNumberVal= street_number;

            String streetNameVal= route;
            String suburbVal=  suburb;
            String CountryVal= country;
            String postCodeVal= postcode;
            String timestampVal=sTimestamp;


                 Date mdate=new Date();
                 String sTemp=streetNameVal.replace(" ","_");
                 String sInstanceName=sURI+sTemp+postCodeVal;
                 theLogger.info("Instance name:"+sInstanceName);

                 // Check wether Place is existed?
                  Instance myInstance=null;
                  boolean bInstanceExisted=false;
                    try {
                     myInstance= kb.getInstance(sInstanceName);
                        if (myInstance.isValid()){
                           theLogger.info("Instance is existed");
                           bInstanceExisted=true;
                        }
                     theLogger.info(myInstance.getName());
                    }catch(Exception e){
                        bInstanceExisted=false;
                        theLogger.severe("Instance Does NOT Valid");
                    }

                 if (bInstanceExisted) {
                     return myInstance;
                 }else {
                 // Create new instance
                 instanceToAddTo = cPostalAddress.createDirectInstance(sInstanceName);
                 Slot streetNumber_slot  = kb.getSlot(streetNumberURI);
                 Slot streetName_slot  = kb.getSlot(streetNameURI);
                 Slot suburb_slot  = kb.getSlot(suburbURI);
                 Slot postCode_slot= kb.getSlot(postCodeURI);
                 Slot Country_slot = kb.getSlot(CountryURI);
                 Slot timestamp_slot = kb.getSlot(timestampURI);

                 instanceToAddTo.setOwnSlotValue(streetNumber_slot, streetNumberVal);
                 instanceToAddTo.setOwnSlotValue(streetName_slot,streetNameVal);
                 instanceToAddTo.setOwnSlotValue(suburb_slot,suburbVal);
                 instanceToAddTo.setOwnSlotValue(postCode_slot, postCodeVal);
                 instanceToAddTo.setOwnSlotValue(Country_slot,CountryVal);
                 instanceToAddTo.setOwnSlotValue(timestamp_slot, timestampVal);
                 kb.addInstance(instanceToAddTo, "Place: "+sInstanceName+" added", cPostalAddress, true);
                 }

        return instanceToAddTo;
    }

      public boolean InsertInstance(float fLat, float  fLon, float  fAlt,
                                float  fSpeed, String sDate, String sTimestamp,
                                String sAddress, String sName, String sURI){
        boolean result = false;
            theLogger.info("Inside InsertInstance");
            
            String ssURI = sURI + "Location";
            Cls cLocation = kb.getCls(ssURI);
            String sLatURI = sURI + "lat";
            String sLonURI = sURI + "lon";
            String sAltURI = sURI + "alt";
            String sSpeedURI = sURI + "speed";
            String sTimeURI = sURI + "timestamp";
            String sDateURI = sURI + "date";
            String sBtAddressURI = sURI + "btAddress";
            String sBtNameURI = sURI + "btName";
            String hasPostalAddressURI = sURI+"hasPostalAddress";


            theLogger.info("Insert instance, creating new Postal Address for geocoding ");
            Instance placeInstance = CreatePlaceByReverseGeocoding (sURI,
                    Float.toString(fLat),Float.toString(fLon), sTimestamp);
            theLogger.info("Postal Address instance created");

            try {
                Date mdate = new Date();
                long lRandomNumber = mdate.getTime();
                String sInstanceName = ssURI + lRandomNumber;
                // Create new instance
                Instance instanceToAddTo = cLocation.createDirectInstance(sInstanceName);
                //instanceToAddTo.s
                //Thread.sleep(10);
                // Set relationship
                //Slot sFriendOfSlot= kb.getSlot("http://xmlns.com/foaf/0.1/friendOf");
                Slot lat_slot = kb.getSlot(sLatURI);
                Slot lon_slot = kb.getSlot(sLonURI);
                Slot alt_slot = kb.getSlot(sAltURI);
                Slot speed_slot = kb.getSlot(sSpeedURI);
                Slot date_slot = kb.getSlot(sDateURI);
                Slot timestamp_slot = kb.getSlot(sTimeURI);
                Slot hasPostalAddress_slot = kb.getSlot(hasPostalAddressURI);

                instanceToAddTo.setOwnSlotValue(lat_slot, fLat);
                instanceToAddTo.setOwnSlotValue(lon_slot, fLon);
                instanceToAddTo.setOwnSlotValue(alt_slot, fAlt);
                instanceToAddTo.setOwnSlotValue(speed_slot, fSpeed);
                instanceToAddTo.setOwnSlotValue(date_slot, sDate);
                instanceToAddTo.setOwnSlotValue(timestamp_slot, sTimestamp);

                instanceToAddTo.setOwnSlotValue(hasPostalAddress_slot, placeInstance);

                kb.addInstance(instanceToAddTo, "Location: " + sInstanceName + " added", cLocation, true);
                theLogger.info("Location instance created");

            } catch (Exception ex) {
                Logger.getLogger(BrowseKB.class.getName()).log(Level.SEVERE, null, ex);
            }


        return result;
    }



}
