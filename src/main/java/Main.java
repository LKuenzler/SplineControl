import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        SmartControlGateway smartControlGateway = new SmartControlGateway("192.168.201.253", 8888);
        smartControlGateway.connect();
        smartControlGateway.turnOnLight();

    }
}
  