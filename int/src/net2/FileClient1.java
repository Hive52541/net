package net2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

public class FileClient1 {

  public static void main(String[] args) throws IOException {
    System.out.println("### 파일클라이언트가 기동됨.....");
    System.out.println("### 파일서버에 연결요청을 보냄...");

    try {
      Socket socket = new Socket("192.168.0.7", 30000);
      System.out.println("### 파일서버와 연결이 완료됨...");

      DataOutputStream out = new DataOutputStream(socket.getOutputStream());
      DataInputStream in = new DataInputStream(socket.getInputStream());

      System.out.println("### 파일클라이언트가 첨부파일 업로드를 시작함...");
      String filename = in.readUTF();
      long size = in.readLong();
      System.out.println("### 첨부파일이름 : " + filename);
      System.out.println("### 첨부파일크기: " + size);

      FileOutputStream fos = new FileOutputStream("C:/repo/" + filename);
      long readBytes = 0;
      int len = 0;
      byte[] buf = new byte[1024];
      while ((len = in.read(buf)) != -1) {
        fos.write(buf, 0, len);
        readBytes += len;

        if (size == readBytes) {
          break;
        }
      }

      fos.close();
    } catch (IOException ex) {}
  }
}
