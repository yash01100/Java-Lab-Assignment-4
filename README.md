Chat Client – Java Socket Programming

This project implements a simple console-based chat client using Sockets, Threads, I/O Streams, and Networking in Java.
It connects to a server and enables real-time two-way communication.

📌 Student Details

Name: Yash Raj

Roll No: 2401010008

Program: B.Tech CSE Core

Faculty: Lucky Verma

📡 Project Overview

The ChatClient class connects to a chat server using a TCP socket.
It supports:

✔ Sending messages to server
✔ Receiving messages using a background thread
✔ Graceful exit using "exit" command

This client works together with a separate server program (ChatServer).

🛠️ Technologies Used

Java

Networking (Socket, ServerSocket)

Multithreading

Input/Output Streams

📁 File Structure
ChatClient.java

🚀 How to Run
1️⃣ Compile the Client
javac ChatClient.java

2️⃣ Run the Client
java ChatClient


Make sure the server is running on:

Host: localhost

Port: 12345

You can update these values in main():

new ChatClient("localhost", 12345);

💡 Features

Connects to server instantly

Runs a receiver thread to display incoming messages

Uses PrintWriter and BufferedReader for communication

Supports multiple clients (if server allows)

Clean termination using "exit"

📜 Sample Code Snippet
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

📤 Exiting the Chat

Type:

exit


The client will disconnect automatically.

📌 Notes

Ensure your firewall allows local socket connections.

Use a proper ChatServer program for communication.

Modify port/host according to your network setup.
