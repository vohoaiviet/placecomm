package agent.perkit;
/*
 * UNPUBLISHED PROPRIETARY INFORMATION
 * Copyright (c) 2007 Sentilla Corporation
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Sentilla Corporation ("Confidential Information"). Disclosure of this
 * Confidential Information is prohibited, and its use shall be in
 * compliance with terms of the license agreement with Sentilla Corporation.
 */

import com.sentilla.net.Sender;
import com.sentilla.net.SenderDriver;
import com.sentilla.host.client.HostClient;

/**
 * ClientSendCount is a sample host side application that works in conjunction
 * with the MoteDisplayRadioCount application running on the mote. It
 * automatically increments a counter from zero to nine and broadcasts a message
 * with a counter through the radio.
 *
 * @author <a href="mailto:info@sentilla.com">Sentilla Corporation</a>
 */
public class ClientSendCount {

	public static void main(String[] args) throws Exception {

		// Create a host environment that virtualizes communication with the mote.
		HostClient host = new HostClient();
		host.connect();

		// Instantiate the messages
		MoteDisplayRadioCount.CountMsg count_msg = new MoteDisplayRadioCount.CountMsg();

		// Create a sender to the local broadcast address (immediate neighbors)
		Sender sender = SenderDriver.create("local");

		// Set the count to 0 when we start
		int cnt = 0;

		// Count to 10 and send a message for each count
		while (cnt < 256) {

			try {
				System.out.println("Sending the count of " + cnt);

				// Apply the current count to the count message.
				count_msg.count = (byte) cnt;

				// Send the message.
				sender.send(count_msg);
			} catch (Exception e) {
				System.err.println("Could not send a CountMsg.");
				e.printStackTrace();
			}

			// Increment the counter
			cnt++;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
		System.out.println("Done");
		System.exit(0);
	}
}
