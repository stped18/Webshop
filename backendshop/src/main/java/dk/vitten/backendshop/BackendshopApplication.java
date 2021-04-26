package dk.vitten.backendshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
public class BackendshopApplication {

  public static void main(String[] args) {
    try {
      InetAddress ip = InetAddress.getLocalHost();
      String hostname = ip.getHostName();
      System.out.println("Your current IP address : " + ip);
      System.out.println("Your current Hostname : " + hostname);

    } catch (UnknownHostException e) {

      e.printStackTrace();
    }
    SpringApplication.run(BackendshopApplication.class, args);

  }

}
