import java.io.*;
import java.net.Socket;

public class SmartControlGateway {
    private String ip;
    private int port;

    private Socket socket;
    private BufferedReader bufferedReader;
    private PrintWriter printWriter;

    public SmartControlGateway(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public void connect() throws IOException {
        socket = new Socket(ip, port);
        try {
            Thread.sleep(1000);
            if(!socket.isConnected()) {
                throw new IOException("Socket cannot connect");
            }

            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            System.out.println("Connected");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void turnOnLight() {
        sendPushCommand("Test", "1");
    }

    public void turnOffLight() {
        sendPushCommand("Test", "2");
    }

    public void sendPushCommand(String id, String channel) {
        printWriter.print("<PUSH;" + id + ";" + channel + ">");
        printWriter.flush();
    }

}
 