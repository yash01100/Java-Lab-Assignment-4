  import java.io.*;
  import java.net.*;
  
  /**
   * ChatClient class for connecting to server and chatting.
   * Student: Yash Raj, Roll No: 2401010008, Program: B.Tech. CSE Core, Faculty: Lucky Verma
   */
  public class ChatClient {
      private Socket socket;
      private PrintWriter out;
      private BufferedReader in;
      
      // Constructor
      public ChatClient(String host, int port) {
          try {
              socket = new Socket(host, port);
              out = new PrintWriter(socket.getOutputStream(), true);
              in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
              
              // Thread for receiving messages
              new Thread(() -> {
                  try {
                      String message;
                      while ((message = in.readLine()) != null) {
                          System.out.println(message);
                      }
                  } catch (IOException e) {
                      System.out.println("Connection lost.");
                  }
              }).start();
              
              // Send messages
              BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
              String message;
              while ((message = userInput.readLine()) != null) {
                  out.println(message);
                  if (message.equals("exit")) break;
              }
          } catch (IOException e) {
              System.out.println("Client error: " + e.getMessage());
          } finally {
              try {
                  socket.close();
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
      }
      
      // Main method
      public static void main(String[] args) {
          new ChatClient("localhost", 12345);
      }
  }
  
