/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utilities;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

/**
 *
 * @author ATuan
 */
public class SimpleTCPserver {

static final int PORT = 8776;

    public static void main(String[] args) throws IOException {

    ServerSocket s = new ServerSocket(PORT);
    System.out.println("Server Started");
    File file;

    try {
      while(true) {
        // Blocks until a connection occurs:
        Socket socket = s.accept();
        try {
          new ServeOneJabber(socket);
        } catch(IOException e) {
          // If it fails, close the socket,otherwise the thread will close it:
          socket.close();
        }
      }
    } finally {
      s.close();
    }

  }
}
class ServeOneJabber extends Thread {

  private Socket socket;
  private BufferedReader in;
  private PrintWriter out;

  public ServeOneJabber(Socket s) throws IOException {
    socket = s;
    in = new BufferedReader(new InputStreamReader(
                socket.getInputStream()));
    // Enable auto-flush:
    out = new PrintWriter(new BufferedWriter(
            new OutputStreamWriter(
                socket.getOutputStream())), true);


        start(); // Calls run()
  }

  public void run() {
    try {
        Calendar myDatetime=Calendar.getInstance();
        String strHostAddress=socket.getInetAddress().getHostAddress().toString();
         String strFilename="B"+strHostAddress+"_"+
                              myDatetime.get(Calendar.YEAR)+"_"+
                              myDatetime.get(Calendar.MONTH)+"_"+
                              myDatetime.get(Calendar.DAY_OF_MONTH)+"_"+
                              myDatetime.get(Calendar.HOUR_OF_DAY)+"_"+
                              myDatetime.get(Calendar.MINUTE)+".txt";
      while (true) {


        FileOutputStream out; // declare a file output object
        PrintStream p; // declare a print stream object
        
        myDatetime=Calendar.getInstance();
        String str = myDatetime.getTime()+",T:"+
                myDatetime.getTimeInMillis()+","+in.readLine();

       
            out = new FileOutputStream(strFilename,true);
            // Connect print stream to the output stream
            p = new PrintStream( out );
            p.println (str);
            p.close();
            if (str.contains("<over>")) break;
             //System.out.print(myDatetime.getTime()+"  ");
             System.out.println(str);

      }
      System.out.println("closing...");
    } catch(IOException e) {
      System.err.println("IO Exception: "+e);
    } finally {
      try {
        socket.close();
      } catch(IOException e) {
        System.err.println("Socket not closed: "+e );
      }
    }
  }
}