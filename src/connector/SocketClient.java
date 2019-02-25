package connector;

import java.io.*;
import java.net.Socket;

/**
 * @author Arthur Kupriyanov
 */
public class SocketClient  {
    private final String login;
    private final String password;

    public SocketClient(String login, String password){
        this.login = login;
        this.password = password;
    }

    private static Socket clientSocket;

    private static BufferedReader in;
    private static BufferedWriter out;

    private final String META_DATA_IDENTIFICATION = "--#";

    public String getResponse(String request) {
        String additionalData = metaData("program") +
                metaData("login", login) +
                metaData("password", password);
        request += " " + additionalData;

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            try {
                clientSocket = new Socket("localhost", 4004);

                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                out.write(request.replace("\n","^") + " \n");
                out.flush();
                String responsePart;
                StringBuilder sb = new StringBuilder();
                while((responsePart = in.readLine())!=null){
                    sb.append(responsePart).append("\n");
                }

                return sb.toString();
            } finally {
                clientSocket.close();
                in.close();
                out.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
        return null;
    }

    private String metaData(String data, String value){
        return META_DATA_IDENTIFICATION + data + " " + value + " ";
    }
    private String metaData(String data){
        return META_DATA_IDENTIFICATION + data + " ";
    }

}

