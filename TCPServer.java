import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server is listening on port 12345...");
            
            while (true) {
                // Accept a client connection
                Socket socket = serverSocket.accept();
                System.out.println("Connected to client");

                // Receive the file name
                InputStream inputStream = socket.getInputStream();
                byte[] fileNameBytes = new byte[1024];
                int fileNameLength = inputStream.read(fileNameBytes);
                String fileName = new String(fileNameBytes, 0, fileNameLength);
                System.out.println("Receiving file: " + fileName);

                // Save the received file
                try (FileOutputStream fileOutputStream = new FileOutputStream("received_" + fileName)) {
                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        fileOutputStream.write(buffer, 0, bytesRead);
                    }
                    System.out.println("File " + fileName + " received successfully.");
                }

                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
