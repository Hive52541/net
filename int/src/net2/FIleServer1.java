package net2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FIleServer1 {

  public static void main(String[] args) throws IOException {
    System.out.println("### 파일 서버가 기동됨.....");

    ServerSocket server = new ServerSocket(30000);
    while (true) {
      System.out.println("### 파일 클라이언트의 연결요청을 대기중.....");

      Socket socket = server.accept();
      System.out.println("### 파일클라이언트의 연결요청을 수락함.....");

      //업로드할 파일을 표현하는 File 객체를 생성한다.
      File file = new File("src/net2/img.png");
     // File file = new File("C:/Users/jhta/eclipse-workspace/api/int/src/net2/img.png");
      //업로드할 파일을 읽어오는 FileInputStream객체를 생성한다.
      FileInputStream fis = new FileInputStream(file);

      //업로드할 파일명과 파일사이즈를 조회한다.
      String filename = file.getName();
      long size = file.length();

      //파일명과 파일사이즈를 파일서버로 보낸다.
      System.out.println("### 파일명과 사이즈를 파일서버로 전송함...");

      Object out;
      out.writeUTF(filename);
      out.writeLong(size);

      //파일데이터를 파일서버로 보내기
      System.out.println("### 파일데이터를 파일서버로 전송하기 시작함...");
      int len = 0;
      byte[] buf = new byte[1024];


      while ((len = fis.read(buf)) != -1) {
        out.write(buf, 0, len);
      }
      fis.close();
      System.out.println("### 파일데이터를 파일서버로 전송 완료함...");

 
    }
  }
}
