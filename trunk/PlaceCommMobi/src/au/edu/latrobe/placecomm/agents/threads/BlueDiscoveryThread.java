/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package au.edu.latrobe.placecomm.agents.threads;

import au.edu.latrobe.placecomm.agents.*;
import java.io.IOException;
import java.util.*;

import javax.bluetooth.*;

/**
 *
 * @author tuannguyen
 */
//class BlueDiscoveryThread extends Thread implements Runnable,DiscoveryListener
public class BlueDiscoveryThread extends Thread implements DiscoveryListener
{
  private MobileUserAgentGUI  MIDlet;
  private LocalDevice local = null;
  private DiscoveryAgent agent = null;
  private Vector devicesFound = null;
  private boolean allDone = false;
  
  /* Using allDone variable for stopping thread from main 
   * program. Thread.suspend() and Thread.stop() provide 
   * asynchronous methods of stopping a thread. However, 
   * these methods have been deprecated because they are 
   * very unsafe. Using them often results in deadlocks and 
   * incorrect resource cleanup. 
   * http://www.exampledepot.com/egs/java.lang/StopThread.html
   * 
  */
  
  public BlueDiscoveryThread(MobileUserAgentGUI  MIDlet )
  { 
   this.MIDlet = MIDlet;
  
   
  }
  public void run() 
  {
        while (true){
            try {
                doDeviceDiscovery();
                Thread.sleep(10000);
                
                if (allDone) {

                    //MIDlet.devicesList.append("Scan Stopped",null);
                    return;
                }                
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }         
        }        
    
  }
  public void start()
  {
    Thread thread = new Thread(this);
    try
    {
      //System.out.println("thread.start()");  
      thread.start();
    }
    catch (Exception error)
    {
    }
  }
  private void doDeviceDiscovery() {
        
        try {            
            local = LocalDevice.getLocalDevice();           
            
        }catch (BluetoothStateException bse) {
            System.out.println("BluetoothStateException: "+bse);
        }
        
        agent = local.getDiscoveryAgent();
        devicesFound = new Vector();
        try {
            if(!agent.startInquiry(DiscoveryAgent.GIAC,this)) {
                
            }
        }catch(BluetoothStateException bse) {
           //System.out.println("BluetoothStateException : "+bse);
        }
    }
  public void deviceDiscovered(RemoteDevice remoteDevice,
                            DeviceClass deviceClass) {
       
        devicesFound.addElement(remoteDevice);  
        
        try {
            String strDeviceDetail="", sDeviceName="";
            String strDeviceMacAddress="";
            boolean alwaysAsk=false;
            /*
             alwaysAsk - if true then the device will be contacted for its name, 
             otherwise, if there exists a known name for this device, the name 
             will be returned without contacting the remote device
             */        
            sDeviceName = remoteDevice.getFriendlyName(alwaysAsk);
            Date myDate=new Date();                
            long lTimestamp= myDate.getTime();
            String sTimestamp=Long.toString(lTimestamp);

            strDeviceMacAddress= remoteDevice.getBluetoothAddress();
            strDeviceDetail="N:"+sDeviceName+",M:"+ strDeviceMacAddress +",T:"+sTimestamp;
                        
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
  public void inquiryCompleted(int param) {
        
        switch (param) {
            case DiscoveryListener.INQUIRY_COMPLETED:
                 
                 System.out.println("INQUIRY_COMPLETED ");
                 

            break;
            case DiscoveryListener.INQUIRY_ERROR:
                 //Error during inquiry, add appropriate code here.
               
                 System.out.println("INQUIRY_ERROR");
            break;
            case DiscoveryListener.INQUIRY_TERMINATED:
                           
                 System.out.println("INQUIRY_TERMINATED");
            break;
        }
    }
    
    public void servicesDiscovered(int transID,
                                ServiceRecord[] serviceRecord) {        
        
    }
    
    public void serviceSearchCompleted(int transID, int respCode) {

    }

    public void stopThread() {
        this.interrupt();         
    }

  
    
} 
