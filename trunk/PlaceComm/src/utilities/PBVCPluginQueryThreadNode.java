/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utilities;

/**
 *
 * @author natuan
 */
public class PBVCPluginQueryThreadNode {

    private String sKey;
    private String sValue;

    PBVCPluginQueryThreadNode(String sKey, String sValue ){
        this.sKey=sKey;
        this.sValue=sValue;
    }

    public String getKey(){
        return sKey;
    }

    public String getValue(){
        return sValue;
    }

    public String setKey(String newKey){
        sKey=newKey;
        return sKey;
    }

    public String setValue(String newValue){
        sValue=newValue;
        return sValue;
    }

}
