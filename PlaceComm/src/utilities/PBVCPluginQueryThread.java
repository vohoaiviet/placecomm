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
public class PBVCPluginQueryThread extends Thread{
    

    
    private OWLModel owlModel;
    private String sQuery;

    private static Logger theLogger =
	 Logger.getLogger(PBVCPluginQueryThread.class.getName());
    private static FileHandler fileTxt;
    private static SimpleFormatter formatterTxt;

    private static Logger theLogger1 =
	 Logger.getLogger(PBVCPluginQueryThread.class.getName());
    private static FileHandler fileTxt1;
    private static SimpleFormatter formatterTxt1;

    private static Logger theQueryLogger =
	 Logger.getLogger(PBVCPlugin.class.getName());

    private String sURI="http://www.tuannguyen.mobi/ontologies/2010/tinypbvc.owl#";
    private List list1=new ArrayList();
    public PBVCPlugin pplugin;
    private List sQueryList;
    private boolean bSingleQuery=true;
    private int iNumberOfQueries = 0;

    Rete engine = new Rete();

    PBVCPluginQueryThread(PBVCPlugin pplugin,String sQueryName, List sQueryList, OWLModel owlModel){
        this.owlModel   = owlModel;
        this.sQueryList = sQueryList;
        this.pplugin = pplugin;
        this.iNumberOfQueries = sQueryList.size();
        if (iNumberOfQueries>1) bSingleQuery=false;

        try{
        formatterTxt = new SimpleFormatter();
        fileTxt = new FileHandler("PBVCPluginQueryThread.log",true);
        fileTxt.setFormatter(formatterTxt);
        theLogger.addHandler(fileTxt);
        }catch(Exception e){
            theLogger.severe(e.toString());
        }


        try{
        formatterTxt = new SimpleFormatter();
        fileTxt = new FileHandler("QueryLogger.log",true);
        fileTxt.setFormatter(formatterTxt);
        theQueryLogger.addHandler(fileTxt);
        }catch(Exception e){
            theQueryLogger.severe(e.toString());
        }

        try{
        formatterTxt1 = new SimpleFormatter();
        fileTxt1 = new FileHandler("PBVCQueryThreadResult.log",true);
        fileTxt1.setFormatter(formatterTxt1);
        theLogger1.addHandler(fileTxt1);
        }catch(Exception e){
            theLogger1.severe(e.toString());
        }
    }

    PBVCPluginQueryThread(PBVCPlugin pplugin,String sQueryName, String sQuery, OWLModel owlModel){

        this.owlModel=owlModel;
        this.sQuery=sQuery;
        this.pplugin = pplugin;
        try{
        formatterTxt = new SimpleFormatter();
        fileTxt = new FileHandler("PBVCPluginQueryThread.log",true);
        fileTxt.setFormatter(formatterTxt);
        theLogger.addHandler(fileTxt);
        }catch(Exception e){
            theLogger.severe(e.toString());
        }


        try{
        formatterTxt = new SimpleFormatter();
        fileTxt = new FileHandler("QueryLogger.log",true);
        fileTxt.setFormatter(formatterTxt);
        theQueryLogger.addHandler(fileTxt);
        }catch(Exception e){
            theQueryLogger.severe(e.toString());
        }

        try{
        formatterTxt1 = new SimpleFormatter();
        fileTxt1 = new FileHandler("PBVCQueryThreadResult.log",true);
        fileTxt1.setFormatter(formatterTxt1);
        theLogger1.addHandler(fileTxt1);
        }catch(Exception e){
            theLogger1.severe(e.toString());
        }
    }


    public void run()
    {
        try
        {
          if (bSingleQuery)  {
          CheckAndExecuteSparql();
          }else {
            RunAllQueriesExecuteSparql();
          }
        }
        catch( Exception e)
        {

        }
        finally
        {
            // Clean up, if necessary
        }
    }



    public void SPARQL2JessFacts(QueryResults results){

        /*
         * SPARQL2JessFacts Algorithm
         *
         * Step 1: Create Jess Template form variables of SPARQL query
         * Step 2: Travel one by one of SPARQL result, picking up the information
         * based on the variables then add fact's values
         * Return jess engine. 
         *
         */
         Date d1=new Date();
         long ld1=d1.getTime();
         long lCounttt=0;

         try {
            // TODO add your handling code here:
            

            /*
             * Example: SELECT ?A ?B ?C
             *          WHERE {
                               ?A ?B ?C .
             *          }
             * Result[i]=  {ts=1246059891212, speed=0.0,
             loc=DefaultOWLIndividual(http://www.tuannguyen.mobi/ontologies/2010/tinypbvc.owl#Location1280203228671gen1282093986879
             of [DefaultOWLNamedClass(http://www.tuannguyen.mobi/ontologies/2010/tinypbvc.owl#Location)])
             }
             * if lVariables.
             *
             */
            List lVariables = results.getVariables();
            List lVariableValue=null;

            String sDeftemplateInJess = generateDefTemplate(lVariables );
            String sDeftemplateName = sDeftemplateInJess.substring(0,sDeftemplateInJess.indexOf(":"));
            String sDeftemplate  =sDeftemplateInJess.substring(sDeftemplateInJess.indexOf(":")+1,sDeftemplateInJess.length());

            theLogger.info("sDeftemplateName:"+sDeftemplateName+
                    "sDeftemplate:"+sDeftemplate);
             engine.eval(sDeftemplate);

            while (results.hasNext()){
                lCounttt++;
             String sResult =results.next().toString();
             //lVariableValue = ParseMySPARQLResult(sResult, lVariables);
             String sAssertInJess = assertValueforDefTemplate(sDeftemplateName, lVariables.size(), sResult);
             engine.eval(sAssertInJess);
             //System.out.println("sAssertInJess:"+sAssertInJess);
            }// End while
            //pplugin.loggingMessagesUpdate("SPARQL to Jess Fact is OK");
            //pplugin.loggingMessagesUpdate("Try to enter jess rules in the box to evaluate");

        } catch (Exception ex) {
            Logger.getLogger(BrowseKB.class.getName()).log(Level.SEVERE, null, ex);
        }
        Date d2=new Date();
        long ld2=d2.getTime();
        long lDuration = ld2 - ld1 ;

        pplugin.loggingMessagesUpdate("SPARQL Converting SPARQL "+Long.toString(lCounttt) +
                " results to Jessfact sucessfully in "+lDuration +" ms");

        pplugin.enableRunThisSPARQLButton();

    }

    /*
    public List ParseMySPARQLResult(String sResult, List lVariables) {

        
        List lReturn = null;
        long lLength=lVariables.size();
        String sKey="";
        String sValueTemp="";

        PBVCPluginQueryThreadNode myNode = new PBVCPluginQueryThreadNode(sKey,sValueTemp);

        if (lLength==1) {
            sKey=lVariables.get(0).toString();
            lReturn.add(sKey);
            sValueTemp=sResult.substring(sResult.indexOf("=")+1,sResult.length()-1);
            myNode.setKey(sKey);
            myNode.setValue(sValueTemp);
            lReturn.add(myNode);
            System.out.println("Key="+sKey+" Value="+sValueTemp);

        }else {
            for (int i=0; i<lLength; i++){
                sResult.replace("{","");
                sResult.replace("}","");
                String [] sValues = sResult.split(",");
                for (int j=0; j<sValues.length ; j++){
                    sKey = sValues[j].substring(0,sValues[j].indexOf("=")-1);
                    sValueTemp = sValues[j].substring(sValues[j].indexOf("=")+1,sValues[j].length());
                    myNode.setKey(sKey);
                    myNode.setValue(sValueTemp);
                    lReturn.add(myNode);
                    System.out.println("Key="+sKey+" Value="+sValueTemp);
                }
            }
        }

        return lReturn;
    }
     *
     */


    public void CheckAndExecuteSparql(){
         try {
            
            Date d1=new Date();
            long ld1=d1.getTime();
            QueryResults results = owlModel.executeSPARQLQuery(sQuery);
            Date d2=new Date();
            long ld2=d2.getTime();
            List l=results.getVariables();

            long lTimeExecutingQuery=ld2 -ld1;
            theLogger.info("Time for SPARQL:"+lTimeExecutingQuery+" ms");
            pplugin.loggingMessagesUpdate("Sparql's duration: "+lTimeExecutingQuery+" ms");

            try{
                SPARQL2JessFacts(results);
            } catch(Exception e){
                theLogger.severe("SPARQL2JessFacts Failed: "+e.toString());
            }

            // Process query result
            /*
            long lNumberOfResult=0;
            while (results.hasNext()){
              lNumberOfResult++;
              String sResult=results.next().toString();
              theLogger1.info(sResult);
            }// End while
            Date d3=new Date();
            long ld3=d3.getTime();
            long lDurationParsingResults=ld3-ld2;
            pplugin.loggingMessagesUpdate("Sparql's has : "+lNumberOfResult+" results. Parse through costs "+
                    lDurationParsingResults+" ms");
            theLogger.info("Sparql's has : "+lNumberOfResult+" results. Parse through costs "+
                    lDurationParsingResults+" ms");
             *
             */

        }
        catch (Exception e) {
            theLogger.severe("SPARQL error: "+e.toString());
        }

             
        
    }

    private String generateDefTemplate(List lVariables) {
        String sResult="(deftemplate ";

        int iLength=lVariables.size();
        Date d=new Date();
        long l=d.getTime();
        String sDefTemplateName="tmpl"+l;
        sResult = sResult +" "+ sDefTemplateName+ " \""+sDefTemplateName+"\" ";
        /*
         (deftemplate course
            “A college course”
            (slot course_name)
            (slot course_number)
         )
         */
        String sTemp="";
        String str2="";
        for (int i=0; i<iLength; i++ ){
            sTemp = "(slot "+lVariables.get(i).toString()+")";
            str2=str2+sTemp;
        }
        sResult=sResult+str2+")";

        sResult=sDefTemplateName+":"+sResult;
        return sResult;
    }

    private String assertValueforDefTemplate(String sDeftemplateName, int iNumberOfVal,
            String sSparqlResult) {
        String sResult="(assert ("+ sDeftemplateName ;
        

        //System.out.println("sResult:"+sResult);

        String sKey="", sValueTemp="";
        PBVCPluginQueryThreadNode myNode = new PBVCPluginQueryThreadNode(sKey,sValueTemp);
        String sSparqlResultLocal =  sSparqlResult.replace("{","");
        sSparqlResultLocal=sSparqlResultLocal.replace("}","");
        //System.out.println("sSparqlResult:"+sSparqlResultLocal);

        if (iNumberOfVal==1) {
            // sSparqlResult = {speed=112.12}
          
            // sSparqlResult = speed=112.12
            //System.out.println("Only one var");

            sKey=sSparqlResultLocal.substring(0,sSparqlResultLocal.indexOf("="));
            sValueTemp=sSparqlResultLocal.substring(sSparqlResultLocal.indexOf("=")+1,
                    sSparqlResultLocal.length());

            if (sValueTemp.contains("(")) {
                        String s2=sValueTemp;
                        sValueTemp=s2.substring(s2.indexOf("(")+1,s2.indexOf(" of [")-1);
            }

            sResult=sResult+"("+sKey+" "+sValueTemp+")";
            sResult=sResult+"))";
            //System.out.println("Assert: "+sResult);

        }else {
                //System.out.println("sSparqlResult:"+sSparqlResultLocal);
                String [] sValues = sSparqlResultLocal.split(",");
                String sValuesIndividual ="";
                for (int j=0; j<sValues.length ; j++){
                    try{
                        sValuesIndividual = sValues[j].trim();
                    //System.out.println("sValues["+j+"]:"+sValuesIndividual);
                    sKey = sValuesIndividual.substring(0,sValuesIndividual.indexOf("="));
                    sValueTemp = sValuesIndividual.trim().substring(sValuesIndividual.indexOf("=")+1,
                            sValuesIndividual.length());

//(loc DefaultOWLIndividual(http://www.tuannguyen.mobi/ontologies/2010/tinypbvc.owl#Location1281749633859
//          of [DefaultOWLNamedClass(http://www.tuannguyen.mobi/ontologies/2010/tinypbvc.owl#Location)]))
                    if (sValueTemp.contains("(")) {
                        String s2=sValueTemp;
                        sValueTemp=s2.substring(s2.indexOf("(")+1,s2.indexOf(" of [")-1);
                    }

                    sResult=sResult+"("+sKey+" "+sValueTemp+")";
                    }catch(Exception e){
                        theLogger.severe("Error in here:"+e.toString());
                    }
                }

            //throw new UnsupportedOperationException("Not yet implemented");
                //System.out.println("Assert: "+sResult);
        }
        return sResult;
    }

    public String EvaluateJessRule(String sRule) {
        Value val=null;
        
        try {
          val=engine.eval(sRule);
        }catch (Exception e){
            theLogger.severe("Jess error:"+e.toString());
        }
        return val.toString();
    }

    private void RunAllQueriesExecuteSparql() {
        System.out.println("Run all queries");
        for (int i=0; i< iNumberOfQueries; i++ ){
            System.out.println("---------------");
            System.out.println("Query ["+i+"]="+sQueryList.get(i).toString());
            System.out.println("---------------");
            String sSingQuery=sQueryList.get(i).toString().trim();

            try {

                Date d1=new Date();
                long ld1=d1.getTime();
                QueryResults results = owlModel.executeSPARQLQuery(sSingQuery);
                Date d2=new Date();
                long ld2=d2.getTime();

                long lTimeExecutingQuery=ld2 -ld1;
                theQueryLogger.info("Query ["+i+"] takes "+lTimeExecutingQuery+" ms");
                pplugin.loggingMessagesUpdate("Query ["+i+"] takes "+lTimeExecutingQuery+" ms");

                
                // Parse results
                long lNumberOfResult=0;
                try{                   
                    while (results.hasNext()){
                      lNumberOfResult++;
                      String sResult=results.next().toString();
                    }// End while
                    Date d3=new Date();
                    long ld3=d3.getTime();
                    long lDurationParsingResults=ld3-ld2;
                    theQueryLogger.info("Q["+i+"] has "+ lNumberOfResult+" results and takes "+lDurationParsingResults +"ms to be parsed");
                    pplugin.loggingMessagesUpdate("Q["+i+"] has "+ lNumberOfResult+" results and takes "+lDurationParsingResults +"ms to be parsed");

                }catch(Exception e){
                    theLogger.severe("Parse result error: "+e.toString());
                }

                if (lNumberOfResult > 0)
                try{
                    SPARQL2JessFacts(results);
                    Date d3=new Date();
                    long ld3=d3.getTime();
                    long lDurationParsingResults=ld3-ld2;
                    theQueryLogger.info("Query ["+i+"] SPARQL2JessFacts takes "+lDurationParsingResults+" ms");
                pplugin.loggingMessagesUpdate("Query ["+i+"] SPARQL2JessFacts takes "+lDurationParsingResults+" ms");

                } catch(Exception e){
                  theLogger.severe("SPARQL2JessFacts Failed: "+e.toString());
                }
                else {
                    theQueryLogger.info("No SPARQL results, not convert to Jess facts");
                    pplugin.loggingMessagesUpdate("No SPARQL results, not convert to Jess facts");
                }

              
            }
            catch (Exception e) {
                theLogger.severe("SPARQL error: "+e.toString());
            }

        }// End for (int i=0; i< iNumberOfQueries; i++ )
    }
}
