package ws.soap;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class HelloWorldClient {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://localhost:8080/helloworld?wsdl");
			QName qName = new QName("http://soap.ws/", "HelloWorldImplService");
			Service service = Service.create(url, qName);
			HelloWorld helloWorld = service.getPort(HelloWorld.class);
			System.out.println("Web Service Message " + helloWorld.sayHello("Joao Paulo"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
