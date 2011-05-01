/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package au.edu.latrobe.placecomm.agents;

import jade.lang.acl.ACLMessage;
import jade.util.leap.Serializable;

import java.util.Date;

import jade.util.leap.Serializable;
import jade.util.leap.ArrayList;
import jade.util.leap.Iterator;
import jade.util.leap.Properties;
import jade.util.leap.EmptyIterator;

import jade.util.leap.EnumIterator;
import java.util.Vector;

import jade.core.AID;
import jade.domain.FIPAAgentManagement.Envelope;

/**
 *
 * @author ATuan
 */
public class ACLMessagePBVC extends ACLMessage {


        /** PlaceComm framework**/
        public static final int PLACECOMM_JOINING = 30;
        public static final int PLACECOMM_JOINING_PROPOSE = 31;
        public static final int PLACECOMM_JOINING_ACCEPT = 32;
        public static final int PLACECOMM_JOINING_REJECT = 33;

        public static final int PLACECOMM_LEAVING = 40;
        public static final int PLACECOMM_LEAVING_GOODBYE = 41;

        public static final int PLACECOMM_POSITIONING = 50;
        public static final int PLACECOMM_POSITIONING_WHEREAMI = 51;
        public static final int PLACECOMM_POSITIONING_WHEREAMI_GPS = 52;
        public static final int PLACECOMM_POSITIONING_WHEREAMI_CBS = 53;
        public static final int PLACECOMM_POSITIONING_WHEREAMI_MAC = 54;
        public static final int PLACECOMM_POSITIONING_YOUAREIN= 55;
        public static final int PLACECOMM_POSITIONING_UPDATE_GPS= 56;
        public static final int PLACECOMM_POSITIONING_CREATE_LOCATION= 57;



        public static final int PLACECOMM_ADVERTISING = 60;
        public static final int PLACECOMM_ADVERTISING_NOTTHISTIME = 61;
        public static final int PLACECOMM_ADVERTISING_NEVER = 62;

        public static final int PLACECOMM_SPARQL = 70;
        public static final int PLACECOMM_SPARQL_QUERY = 71;
        public static final int PLACECOMM_SPARQL_RESULT = 72;

        public static final int PLACECOMM_SEMANTIC_PLACEBROWSER = 73;
        public static final int PLACECOMM_SEMANTIC_PLACEBROWSER_SPARQL = 74;
        public static final int PLACECOMM_SEMANTIC_PLACEBROWSER_SPARQL_RESULT = 75;
        public static final int PLACECOMM_SEMANTIC_PLACEBROWSER_CASCADING_INSERTION = 76;

        public static final int PLACECOMM_PLACESENSE_BLUETOOTH = 80;
        public static final int PLACECOMM_PLACESENSE_RFID = 81;
        public static final int PLACECOMM_PLACESENSE_CELLBROADCAST = 82;
        public static final int PLACECOMM_PLACESENSE_WIFI = 83;
        public static final int PLACECOMM_PLACESENSE_BARCODE = 84;
        public static final int PLACECOMM_PLACESENSE_CASSCADING_INSERTION = 85;



}
