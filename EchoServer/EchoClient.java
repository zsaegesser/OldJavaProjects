import java.net.*;
import java.io.*;

public class EchoClient {
    public static void main(String[] args)  {
      try{


        int port = 8080;
        Socket sock=new Socket("127.0.0.1", port);




        BufferedReader instream = new BufferedReader (new InputStreamReader (sock.getInputStream()));
        BufferedWriter outstream = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));

        String request = "Hello\n";
        String helpmessage = "Type Hello, bye, or exit. \nThe server will respond as shown in the server diagram in the slides.\n";
        System.out.println("Sending Messages to the Server... :"+request);
        System.out.println("Connecting to "+ sock.getInetAddress()+ " and port "+sock.getPort());
        System.out.println("Local Address :"+sock.getLocalAddress()+" Port :"+sock.getLocalPort());

        BufferedReader userstream = new BufferedReader (new InputStreamReader(System.in));
       //write a message
       System.out.println("Enter request for server or help for options: ");
          while((request = userstream.readLine()) != null){
            if(request.equals("exit")){
              outstream.write(request);
              outstream.flush();
              System.out.println("Closing Client Connection...");
              //NEED TO SEND MESSAGE TO CLOSE THREAD on server side
              break;
            }
            else if(request.equals("help")){
              System.out.print(helpmessage);
            }

            else{
              outstream.write(request+"\n");
              outstream.flush();
              String response;
              System.out.println("The server says: ");
              response = instream.readLine();

              System.out.println(response);

            }
            System.out.println("Enter new request for server: ");
          }





        instream.close();
        outstream.close();
        sock.close();
    	System.out.println("Connection Closing...");
        }
      catch (IOException ex){
          System.out.println("Error during I/O");
          ex.getMessage();
          ex.printStackTrace();
        }
    }}
