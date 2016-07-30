package itat.zttc.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestHttp {
	public static void main(String[] args) {
		try {
			System.out.println("hello");
//			Socket s = new Socket("www.qidian.com", 80);
			Socket s = new Socket("localhost", 8080);
			PrintWriter out = new PrintWriter(s.getOutputStream(), true);
			BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
			//Http header
			out.println("GET /servlet01/reg.html HTTP/1.1");//空格1个，不能错
//			out.println("GET / HTTP/1.1");//空格1个，不能错
//			out.println("Host:www.qidian.com");
			out.println("Host:localhost");
			out.println("contentType:text/html");
			//must send new line http header has send complete
			out.println();
			String str = null;
			while((str = reader.readLine())!=null){
				System.out.println(str);
			}
			System.out.println("end");
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
