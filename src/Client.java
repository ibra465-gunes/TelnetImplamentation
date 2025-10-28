import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Client {
    public static String baseUser = "mail_adresiniz@gmail.com";
    public static String basePassword = "uygulama_sifresi_giriniz";
    public static void main(String[] args){
        try{
            String base64Mail = Base64.getEncoder().encodeToString(baseUser.getBytes(StandardCharsets.UTF_8));
            String base64Password = Base64.getEncoder().encodeToString(basePassword.getBytes(StandardCharsets.UTF_8));
            SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket("smtp.gmail.com", 465);
            System.out.println("Connected!");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
            PrintWriter dataOutputStream = new PrintWriter(sslSocket.getOutputStream(),true);
            dataOutputStream.println("EHLO localhost");
            Thread.sleep(100);
            System.out.println(bufferedReader.readLine());
            System.out.println(bufferedReader.readLine());
            System.out.println(bufferedReader.readLine());
            System.out.println(bufferedReader.readLine());
            System.out.println(bufferedReader.readLine());
            System.out.println(bufferedReader.readLine());
            System.out.println(bufferedReader.readLine());
            System.out.println(bufferedReader.readLine());
            System.out.println(bufferedReader.readLine());
            dataOutputStream.println("AUTH LOGIN");
            Thread.sleep(100);
            System.out.println(bufferedReader.readLine());
            dataOutputStream.println(base64Mail);
            Thread.sleep(100);
            System.out.println(bufferedReader.readLine());
            dataOutputStream.println(base64Password);
            Thread.sleep(100);
            System.out.println(bufferedReader.readLine());
            dataOutputStream.println("MAIL FROM: <mail_adresiniz@gmail.com>");
            Thread.sleep(100);
            System.out.println(bufferedReader.readLine());
            dataOutputStream.println("rcpt to: <alıcı_mail_adresiniz@gmail.com>");
            Thread.sleep(100);
            System.out.println(bufferedReader.readLine());
            dataOutputStream.println("DATA");
            Thread.sleep(100);
            System.out.println(bufferedReader.readLine());
            dataOutputStream.println("Subject: System Prog. Third Week");
            dataOutputStream.println("Burada mailin gövde mesajı gönderilmektedir.");
            dataOutputStream.println(".");
            dataOutputStream.println("QUIT");
            Thread.sleep(100);
            System.out.println(bufferedReader.readLine());
            sslSocket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
