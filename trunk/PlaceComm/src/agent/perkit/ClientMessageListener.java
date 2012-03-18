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

import java.io.EOFException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

import com.sentilla.host.client.HostClient;
import com.sentilla.io.ByteBuffer;
import com.sentilla.net.Receiver;
import com.sentilla.net.ReceiverDriver;

/**
 * Prints the contents of received objects.
 *
 * Receives all objects and uses introspection to print the contents
 * of the received object.
 *
 * @author  Sentilla Corporation
 */
public class ClientMessageListener {

    public void snoopAndPrintAll() {

        /* Intatiate the desired message and create a matching receiver */
        Object obj = new Object();
        Receiver receiver = ReceiverDriver.create(obj.getClass());

        long time;
        long firstTime = 0;
        int n = 0;
        while (true) {
            obj = receiver.receive(); //block till receive
            time = System.currentTimeMillis();
            if (firstTime == 0)
                firstTime = time;

            if (obj instanceof EOFException) {
                System.out.println("Server went away. Exiting.");
                System.exit(0);
            }

            StringWriter outbuf = new StringWriter();
            PrintWriter out = new PrintWriter(outbuf);

            try {
                Class c = obj.getClass();

                out.println();
                out.println("Message number: " + n++);
                out.println("Time offset: " + (time - firstTime) + " ms");
                out.println("Class: " + c.getName() + "@"
                        + Integer.toHexString(obj.hashCode()));

                if ((obj instanceof com.sentilla.io.ByteBuffer))
                    printByteBuffer(out, (ByteBuffer) obj);
                else if (obj instanceof java.lang.Number)
                    out.println("Value = " + obj);
                else if (obj instanceof java.lang.String)
                    out.println("String = " + obj);
                else if (obj instanceof java.lang.Character)
                    out.println("Character = " + obj);
                else {
                    printedSet.clear();
                    printedSet.add(obj);
                    printClass(out, c, obj, 24);
                }
                String pad = "    ";
                System.out.print(pad
                        + outbuf.getBuffer().toString().replace("\n",
                                "\n" + pad).replaceFirst(" +$", ""));
            } catch (IllegalAccessException e) {
                System.out.print(outbuf.getBuffer());
                e.printStackTrace();
            }
        }
    }

    private Set<Object> printedSet = new HashSet<Object>();

    private boolean shouldPrint(Object o) {
        return (o != null) && !(o instanceof String)
        && !(o instanceof ByteBuffer) && printedSet.add(o);
    }

    /**
     * Prints contents of any object.
     */
    public void printClass(PrintWriter out, Class c, Object obj, int indent)
    throws IllegalAccessException {

        Object o;
        String fmt = "%" + indent + "s = %s%n";
        if (c.isArray()) {
            if (c.getComponentType().isPrimitive()) {
                out.format("%"+indent+"s ", "[");
                for (int i = 0; i< Array.getLength(obj); i++) {
                    out.format("%d ", Array.get(obj, i));
                }
                out.format("]%n");
                return;
            }
        }
        while (!java.lang.Object.class.equals(c)) {
            Field[] fields = c.getDeclaredFields();
            for (Field f : fields) {
                try {
                    o = f.get(obj);
                    Object name = "???";
                    Object value = "???";
                    try {
                        name = f.getName();
                        value = f.get(obj);
                    }
                    catch (IllegalAccessException e) { }
                    out.format(fmt, name, value);
                    if ((!(f.getType().isPrimitive())) && shouldPrint(o)) {
                        printClass(out, o.getClass(), o, indent + 8);
                    }
                } catch (IllegalAccessException iae) {
                }
            }
            c = c.getSuperclass();
        }
    }

    /**
     * Prints contents of a ByteBuffer.
     */
    public void printByteBuffer(PrintWriter out, ByteBuffer body) {
        String s = String.format("Length = " + body.available() + "\n");
        s += String.format("Data = ");
        int n = 1;
        for (int i = body.start; i < body.end; i++) {
            s += String.format(" %02x", 255 & (int) body.data[i]);
            if (n % 25 == 0)
                s += "\n       ";
            n++;
        }
        s += "\n";
        out.print(s);
    }

    public static void main(String[] args) throws Exception {
        /* create the host server connection */
        HostClient host = new HostClient();
        host.connect();
        new ClientMessageListener().snoopAndPrintAll();
    }
}
