/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package au.edu.latrobe.placecomm.agents;

/**
 *
 * @author ATuan
 */
public interface MobileUserAgentGUIInterface {
    public void UpdateLocation(String sLat, String sLon, String sAlt, String sSpeed,
                                String sTimestamp);
    public void UpdateBluetoothDiscovered(String sLat, String sLon, String sAlt,
                            String sMAC,String sFriendlyName,String sTimestamp,
                            String sCellBroadcast, String sSpeed,String sUserAgent,
                            boolean bCascadingInsertion);
    public String QueryKBbySPARQL(String sQuery);
    public String JoiningProtocol(String sAgentName,String sSend, String sReceive);
    public String AdvertisingProtocol(String sAgentName,String sSend, String sReceive);
    public String PositoiningProtocol(String sAgentName,String sSend, String sReceive);
    public String LeavingProtocol(String sAgentName,String sSend, String sReceive);

    public void dispose();

    public void updateStatus(String string);
    public void updateSparqlResults(String string);

    
    
}
