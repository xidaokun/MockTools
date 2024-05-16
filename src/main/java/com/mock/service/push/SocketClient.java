package com.mock.service.push;

import java.io.*;
import java.net.Socket;

public class SocketClient {

    private Socket socket;
    private static final int LOCAL_PORT = 9000;
    private static final int REMOTE_PORT = 5000;

    public SocketClient() {
        try {
            socket = new Socket("localhost", LOCAL_PORT);
            String cmd = "adb forward tcp:" + LOCAL_PORT + " tcp:"+REMOTE_PORT;
            ProcessBuilder pb = new ProcessBuilder("/bin/bash", "-c", cmd);
            pb.environment().putAll(System.getenv());
            Process process = pb.start();
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        try {
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            writer.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}