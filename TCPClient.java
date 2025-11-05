import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file path to send: ");
        String filePath = scanner.nextLine();
        
        File file = new File(filePath);
        
        if (!file.exists()) {
            System.out.println("File does not exist.");
            return;
        }
        
        try (Socket socket = new Socket("localhost", 12345)) {
            System.out.println("Connected to server");

            // Send file name to the server
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(file.getName().getBytes());

            // Send file content to the server
            try (FileInputStream fileInputStream = new FileInputStream(file)) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                System.out.println("File " + file.getName() + " sent successfully.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
