import java.io.*;
import java.net.*;
import java.util.Date;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadServer implements Runnable {
   Socket csocket;
   MultiThreadServer(Socket csocket) {
      this.csocket = csocket;
   }

   public static void main(String args[])
		   throws Exception {
		      ServerSocket ssock = new ServerSocket(8080);
		      System.out.println("Listening");
		      while (true) {
		         Socket sock = ssock.accept();
		         System.out.println("Connected");
		         new Thread(new MultiThreadServer(sock)).start();
		      }
		   }
   public void run() {
      try {
          Boolean state = true;
          BufferedReader instream = new BufferedReader (new InputStreamReader(csocket.getInputStream()));
          BufferedWriter outstream = new BufferedWriter(new OutputStreamWriter(csocket.getOutputStream()));

          //String strin = instream.readLine();
          String strin;
          while ((strin = instream.readLine()) != null) {
            if(state){
        	     if(strin.equals("Hello")){
        		       outstream.write("Welcome\n");
                   outstream.flush();
                   state = false;
        	        }
              else if(strin.equals("exit")){
                System.out.println("Closing connection...");
                System.out.println("Listening...");
                break;
              }
               else{
                 outstream.write("Not Welcome\n");
                 outstream.flush();
               }
            }
            else{
              if(strin.equals("bye")){
                state = true;
                outstream.write("bye\n");
                outstream.flush();
              }
              else if(strin.equals("exit")){
                outstream.write("Server Closing...\n");
                outstream.flush();
                break;
              }
              else{
                outstream.write(strin+"\n");
                outstream.flush();
              }
            }


      }
      this.csocket.close();
    }
      catch (IOException e) {
         System.out.println(e);
      }
   }

}
