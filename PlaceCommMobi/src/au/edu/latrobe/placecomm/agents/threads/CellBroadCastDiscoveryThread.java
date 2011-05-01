/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package au.edu.latrobe.placecomm.agents.threads;
import javax.wireless.messaging.*;

import java.io.*;
import javax.microedition.io.*;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import au.edu.latrobe.placecomm.agents.*;
/**
 *
 * @author ATuan
 */
public class CellBroadCastDiscoveryThread  implements  Runnable, MessageListener{

 private MessageConnection conn;
 private MobileUserAgentGUI myMidlet;
 private String url = "sms://:" ;

 private String msgReceived=null;

 CellBroadCastDiscoveryThread(MobileUserAgentGUI MIDlet, String port){
     this.myMidlet=MIDlet;
     this.url = "sms://:" + port;
 }

 public void run(){
   try {
    conn = (MessageConnection)Connector.open("cbs://:050");
    Message msg = conn.receive();
    if (msg instanceof TextMessage){
    String data = "You are in:"+((TextMessage)msg).getPayloadText();
    }
   } catch (Exception ioExc){}
 }


public void start() {
    Thread thread = new Thread(this);
    try {
      thread.start(); // Call run()
    } catch (Exception error) {
    }
}

    public void notifyIncomingMessage(MessageConnection mc) {
        Message msg = null;
	try {
	msg = conn.receive();
	}
	catch (Exception e) {
	e.printStackTrace();
	}
	if (msg instanceof TextMessage) {
            try{
                TextMessage tmsg = (TextMessage)msg;
                msgReceived = tmsg.getPayloadText();
                myMidlet.updateCellBroadcast(msgReceived);
                myMidlet.sCellBroadcast=msgReceived;
            }catch(Exception e){
             ;;
            }
	}
	else if (msg instanceof BinaryMessage) {
            try{
                BinaryMessage bmsg = (BinaryMessage)msg;
                byte[] data = bmsg.getPayloadData();
                msgReceived = data.toString();
                myMidlet.updateCellBroadcast(msgReceived);
                myMidlet.sCellBroadcast=msgReceived;
            }catch(Exception e){
                e.printStackTrace();
            }
	}
    }
}
