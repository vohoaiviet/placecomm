package agent.perkit;
/*
 * UNPUBLISHED PROPRIETARY INFORMATION
 * Copyright (c) 2007-2008 Sentilla Corporation
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Sentilla Corporation ("Confidential Information"). Disclosure of this
 * Confidential Information is prohibited, and its use shall be in
 * compliance with terms of the license agreement with Sentilla Corporation.
 */

import java.io.Serializable;

import com.sentilla.system.Leds;
import com.sentilla.system.LedsDriver;
import com.sentilla.net.Receiver;
import com.sentilla.net.ReceiverDriver;

/**
 * MoteDisplayRadioCount listens for CountMsg and renders the CountMsg.count
 * onto the LEDs. This sample works in conjunction with ClientSendCount, which
 * sends CountMsg messages.
 *
 * @author <a href="mailto:info@sentilla.com">Sentilla Corporation</a>
 */
public class MoteDisplayRadioCount {

    /**
     * The MoteDisplayRadioCount Message class contains the count to be
     * displayed on the leds.
     */
    public static class CountMsg implements Serializable {
        public int count;
    }

    
    /**
     * motemain is the entry point that is executed when the application is
     * installed onto a mote.
     * @throws InterruptedException 
     */
    public static void motemain() throws InterruptedException {

        // Use the LedsDriver factory to create an instance of the LEDs device
        // that can set or toggle the default LEDs.
        Leds leds = LedsDriver.create();

        // Create a protocol receiver object that receives objects that are of
        // the same type as the count_msg class.
        Receiver recv = ReceiverDriver.create(CountMsg.class);

        // Declare a count message object to reference the received data.
        CountMsg count_msg;

	// Set the LEDs to know when the app is installed
	leds.set(255);

        // We are done initializing drivers and variables. Now, repeat this task
        // until the application is removed.
        while (true) {

            // Wait until the a count message is received. Because recv was
            // created for CountMsg.class, it guarantees to only return CountMsg
            // objects.
            count_msg = (CountMsg) recv.receive();

            // The count message has been received.
            // Render lower bits of the count to the LEDs.
            leds.set(count_msg.count);
            //Thread.sleep(200);
        }
    }
}
