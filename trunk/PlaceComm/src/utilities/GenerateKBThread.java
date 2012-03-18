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
 * @author natuan
 */
public class GenerateKBThread extends Thread {



    private Project prj;
    private KnowledgeBase kb;

    private String sPrjFile;
    private boolean bStopThread=false;
    private boolean bPauseThread=false;

    private long lNumberOfWillBeGenerated =0;
    private long lStartFromInstance =0;
    private long lUntilInstance =0;


    private static Logger theLogger =
	 Logger.getLogger(GenerateKBThread.class.getName());
    private static FileHandler fileTxt;
    private static SimpleFormatter formatterTxt;
    private String sURI="http://www.tuannguyen.mobi/ontologies/2010/tinypbvc.owl#";
    private String sLocationURI=sURI+"Location";
    private Collection errors = new ArrayList();

    long lRealInstanceGenerated = 0;

    ///////////////
        String sLatURI = sURI + "lat";
        String sLonURI = sURI + "lon";
        String sAltURI = sURI + "alt";
        String sSpeedURI = sURI + "speed";
        String sTimeURI = sURI + "timestamp";
        String sDateURI = sURI + "date";
        String hasPostalAddressURI = sURI+"hasPostalAddress";
        String sPostalAddressClassURI=sURI+"PostalAddress";
        String sNewInstanceName="";
    ///////////////

    GenerateKB mainThread;
    GenerateKBThread(GenerateKB mainThread, String sPrjFile, long lTotalInstanceTobeGenerated,
            long lStartFromInstance, long lUntilInstance) {

     this.mainThread = mainThread;
     this.sPrjFile = sPrjFile;
     this.lNumberOfWillBeGenerated = lTotalInstanceTobeGenerated;
     this.lStartFromInstance = lStartFromInstance;
     this.lUntilInstance =  lUntilInstance;

      try{
        formatterTxt = new SimpleFormatter();
        fileTxt = new FileHandler("GenerateKBThread.log",true);
        fileTxt.setFormatter(formatterTxt);
        theLogger.addHandler(fileTxt);
        }catch(Exception e){
            theLogger.severe(e.toString());
        }
    }

    

    public void run()
    {
        try
        {
          theLogger.info("Start generate data");
          StartGenerateInstances( sPrjFile, lNumberOfWillBeGenerated,
                  lStartFromInstance, lUntilInstance);
        }
        catch( Exception e)
        {
           theLogger.severe("Start thread error "+e.toString());
        }
        finally
        {
            // Clean up, if necessary
        }
    }

    public Project getProject() {
       return this.prj;
    }


    public void StartGenerateInstances( String sPrjFile, long lNumberOfWillBeGenerated,
            long lStartFromInstance, long lUntilInstance){
        
        Date d1=new Date();
        long l1=d1.getTime();
        prj = Project.loadProjectFromFile(sPrjFile,errors);

        kb  = prj.getKnowledgeBase();
        //URI uri = prj.getActiveRootURI();

        Collection colNumberOfInstance=kb.getInstances();
        long lNumberOfInstance =colNumberOfInstance.size();
        long lDistance = lUntilInstance - lStartFromInstance;

        long xTimes=lNumberOfWillBeGenerated / lDistance;

        
        Date d2=new Date();
        long l2=d2.getTime();

        theLogger.info("Connected to MySQL in "+(l2-l1) +" ms");
        theLogger.info("KB has "+lNumberOfInstance+" instances");
        mainThread.updateLoggingMessage("Connected to MySQL in "+(l2-l1) +" ms");
        mainThread.updateLoggingMessage("KB has "+lNumberOfInstance+" instances");
        /*
         * GENERATE DATA ALGORITHM
         * Step 1: GetAllInstances from KB.
         * Step 2: For each instance in KB, duplicates xTimes of it.
         *      Step 2.1: Get all attirbutes (Slot) and values of that instance
         *                try catch hasPostalAddress instance
         *      Step 2.2: Create new instance named instanceToAddTo
         *                Generate Random number 10000
                          new instance name= old name+random number
         *      Step 2.3: SetOwnValue for new instance
         *
         *
         */
         
         Cls locationCls = kb.getCls(sLocationURI);
         Collection colInstances = kb.getInstances(locationCls);         
         Iterator iter = colInstances.iterator();

         String sTempInstance="", sInstanceName="";
         
         long lIndex=0;
         
         Date dd1 = new Date();
         long lTimeDuration=0;
         long lTimeStart=dd1.getTime();

         while ((iter.hasNext())&&(!bStopThread)){
            sTempInstance = iter.next().toString();
                        
            // Go to Start from Instance: 
            if (lIndex< lStartFromInstance){
                lIndex++;
                //theLogger.info("skip this instance, try the next round ");
            }else if ((lIndex<=lUntilInstance)||(lUntilInstance==0)){
                sInstanceName = sTempInstance.substring(sTempInstance.indexOf("(")+1,
                    sTempInstance.indexOf(" of ["));
                for (int i=0 ; i< xTimes ; i++){
                    try{
                        duplicateInstance(locationCls, sInstanceName);
                        
                    }catch (Exception e){
                        theLogger.severe("duplicateInstance ["+lIndex+"] failed: "+e.toString());
                    }
                }
                lIndex++;
            }else {
                break;
            }
            if (bPauseThread){
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException ex) {
                    theLogger.severe("Cannot sleep "+ex.toString());
                    
                }
            }
           
           lIndex++;
           //if ((lRealInstanceGenerated % 1000)==0){
           //    theLogger.info("New 1000 instances generated successfully ! ");
           //    mainThread.updateLoggingMessage("New 1000 instances generated successfully !");
           //}

           if (lRealInstanceGenerated >= lNumberOfWillBeGenerated) {
               bStopThread=true;
           }
         }// End while
         Date dd2 = new Date();
         long lTimeStop = dd2.getTime();
         lTimeDuration  = lTimeStop - lTimeStart;
         
         theLogger.info("Generated :"+lRealInstanceGenerated+" instances in: "+lTimeDuration);
         mainThread.updateLoggingMessage("Generated :"+lRealInstanceGenerated+
                 " instances in: "+lTimeDuration);

    }
    public boolean PauseThread(boolean bPauseThread){
        this.bPauseThread =bPauseThread ;
        return bPauseThread;
    }

    public boolean StopThread(boolean bStopThread){
        this.bStopThread =bStopThread ;
        return bStopThread;
    }


    // input old instance name
    // Return new instance will all value is set

    public Instance duplicateInstance(Cls clsName, String sInstance){
    //public void duplicateInstance(Cls clsName, String sInstance){

        Instance oldInstance=kb.getInstance(sInstance);
        
        //////////////////////////////////////////////////////////////////////
        Slot lat_slot = kb.getSlot(sLatURI);
        Slot lon_slot = kb.getSlot(sLonURI);
        Slot alt_slot = kb.getSlot(sAltURI);
        Slot speed_slot = kb.getSlot(sSpeedURI);
        Slot date_slot = kb.getSlot(sDateURI);
        Slot timestamp_slot = kb.getSlot(sTimeURI);
        Slot hasPostalAddress_slot = kb.getSlot(hasPostalAddressURI);

        float fLat = Float.parseFloat(oldInstance.getDirectOwnSlotValue(lat_slot).toString());
        //System.out.println("fLat "+fLat);
        float fLon = Float.parseFloat(oldInstance.getDirectOwnSlotValue(lon_slot).toString());
        //System.out.println("fLon "+fLon);
        float fSpeed = Float.parseFloat(oldInstance.getDirectOwnSlotValue(speed_slot).toString());
        //System.out.println("fSpeed "+fSpeed);
        float fAlt = Float.parseFloat(oldInstance.getDirectOwnSlotValue(alt_slot).toString());
        //System.out.println("fAlt "+fAlt);
        String sDate = oldInstance.getDirectOwnSlotValue(date_slot).toString();
        //System.out.println("sDate "+sDate );
        String sTimestamp = oldInstance.getDirectOwnSlotValue(timestamp_slot).toString();
       // System.out.println("sTimestamp "+sTimestamp );

        
        String sPlaceInstanceTemp="";
        String sPlaceInstance="";
        try{
        sPlaceInstanceTemp=oldInstance.getDirectOwnSlotValue(hasPostalAddress_slot).toString().trim();
        //System.out.println("sPlaceInstanceTemp "+sPlaceInstanceTemp);
        
            sPlaceInstance=sPlaceInstanceTemp.substring(sPlaceInstanceTemp.indexOf("(")+1,
                sPlaceInstanceTemp.indexOf(" of ")).trim();
        }catch (Exception e){
            theLogger.severe("Not have place address");

        }

        //System.out.println("sPlaceInstance "+sPlaceInstance);
        Instance PlaceInstance=null;
        if (!sPlaceInstance.isEmpty()) {
            PlaceInstance=kb.getInstance(sPlaceInstance);
        }

        float newfSpeed = 0.0f;
        try{
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        float f = (float) randomInt / 10000.0f;
        
        if ((randomInt % 2) == 0) {
            newfSpeed = fSpeed + fSpeed * f;
        } else {
            newfSpeed = fSpeed - fSpeed * f;
        }
        }catch(Exception ex1){
            theLogger.severe("Generate random speed failed! "+ex1.toString());
        }

        Date d4=new Date();
        long ld4=d4.getTime();
        sNewInstanceName= sInstance + "gen"+ld4;
        //System.out.println("sNewInstanceName:"+sNewInstanceName);
        Instance newInstance=null;
        try{
        newInstance = kb.createInstance(sNewInstanceName, clsName);

        newInstance.setOwnSlotValue(lat_slot, fLat);
        newInstance.setOwnSlotValue(lon_slot, fLon);
        newInstance.setOwnSlotValue(alt_slot, fAlt);
        newInstance.setOwnSlotValue(speed_slot, newfSpeed);
        newInstance.setOwnSlotValue(date_slot, sDate);
        newInstance.setOwnSlotValue(timestamp_slot, sTimestamp);
        newInstance.setOwnSlotValue(hasPostalAddress_slot, PlaceInstance);


        kb.addInstance(newInstance, "Location: " + sNewInstanceName + " added", clsName, true);
        //theLogger.info("Location instance: "+sNewInstanceName+" successfully! ");
        lRealInstanceGenerated++;
        }catch(Exception ex){
            theLogger.severe("Instance already existed. Uniqueness violation:"+ex.toString());
        }
        
        //////////////////////////////////////////////////////////////////////
        return  newInstance;
        //////////////////////////////////////////////////////////////////////
    }
}
