/*
 *  Tuan Anh Nguyen.  Email: t.nguyen@latrobe.edu.au
 * Computer Science & Computer Engineering Department
 * La Trobe University, VIC, 3086
 */

package placecommframework.knowledgebase;

/**
 * @author Tuan Nguyen
 */
public class PredefinedQueries {
    private String queryID;
    private String queryPlaintext;
    private String queryFile;

    PredefinedQueries(String vqueryID, String vqueryPlaintext,String queryFile){
        this.queryFile=vqueryID;
        this.queryID=vqueryPlaintext;
        this.queryPlaintext=queryFile;
    }

    public String getqueryID(){
        return queryID;
    }
    
    public String getQueryPlaintext(){
        return queryPlaintext;
    }

    public  String getqueryFile(){
        return queryFile;
    }

    public void setqueryID(String s){
        this.queryID =s;
    }

    public void setQueryPlaintext(String s){
        this.queryPlaintext=s;
    }

    public  void setQueryFile(String s){
        this.queryFile=s;
    }
}
