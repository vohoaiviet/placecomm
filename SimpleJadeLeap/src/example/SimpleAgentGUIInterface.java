/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package example;

/**
 *
 * @author Tuan Nguyen
 */
public interface SimpleAgentGUIInterface {

    public void dispose();
    public void getAgentInformation(String sAgentName, String sAgentLocalName);
    public void sendReply(String sMsgContent);
           void updateMessage(String sSenderName,String sMsgContent);


}
