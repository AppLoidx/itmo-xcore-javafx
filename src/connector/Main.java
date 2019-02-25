package connector;

/**
 * @author Arthur Kupriyanov
 */
public class Main {
    public static void main(String[] args) {
        SocketClient socketClient = new SocketClient("MyLogin","MyPassword");
        socketClient.getResponse("command -o options");
    }
}
