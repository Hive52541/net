package net4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server {

  private Map<Integer, Handler> map = new HashMap<>();

  public Server() {
    map.put(Cmd.REQ_FILE_LIST, new ServerFileListHandler());
    map.put(Cmd.REQ_DOWNLOAD, new ServerFileDownloadHandler());
    map.put(Cmd.REQ_UPLOAD, new ServerFileUploadHandler());
  }

  public void startup() throws IOException {
    ServerSocket serverSocket = new ServerSocket(30000);

    while (true) {
      Socket socket = serverSocket.accept();
    }
  }

  public static void main(String[] args) throws IOException {
    Server server = new Server();
    server.startup();
  }
}
