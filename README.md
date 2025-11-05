# ⚡ Real-Time TCP Communication System

A Java-based client–server application that enables **real-time, bidirectional communication** using **TCP sockets**.  
This project demonstrates the fundamentals of **Java networking, socket programming, and stream-based data exchange** between distributed systems.

---

## 🚀 Features

- Real-time text-based communication between client and server  
- Reliable **TCP connection** ensuring ordered and lossless message delivery  
- Multi-message exchange using input/output streams  
- Graceful connection handling and termination  
- Lightweight console-based interface for demonstration

---

## 🛠️ Tech Stack

- **Language:** Core Java  
- **Concepts:** Socket Programming, TCP/IP Networking, I/O Streams, Threads  
- **Tools:** JDK 17+, Command Line (or any IDE like IntelliJ / VS Code)

---

│
├── TCPServer.java # Server program that listens for client connections and exchanges data
├── TCPClient.java # Client program that connects to the server and sends/receives messages
└── README.md # Project documentation


---

## ⚙️ How to Run

1. **Compile both files:**
   ```bash
   javac TCPServer.java
   javac TCPClient.java


Run the Server:

java TCPServer


Run the Client (in another terminal):

java TCPClient


Once connected, type messages in the client terminal to exchange data with the server in real-time.

📚 How It Works

The server creates a ServerSocket that listens on a specific port (e.g., 5000).

The client initiates a connection using a Socket to the server’s IP and port.

Both use InputStream and OutputStream to send and receive messages.

The connection remains active until either side terminates it gracefully.

🧠 Learning Highlights

Understanding of Java’s socket API and the TCP/IP model

Working with I/O streams and threaded communication

Handling connection lifecycle and network exceptions

Real-world foundation for chat servers, multiplayer systems, and backend message services

📸 Example Output

Server Console

Server started. Waiting for client...
Client connected.
Client: Hello Server!
Server: Hi Client, connection successful!


Client Console

Connected to server.
Server: Welcome to the TCP Communication System!
Client: Hello Server!

## 🧩 Project Structure

