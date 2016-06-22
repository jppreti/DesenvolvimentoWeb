package ws.rest;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class HelloWorldClient {
	public static void main(String[] args) {
		String baseURI = "http://localhost:8080/web";
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(baseURI);

		System.out.println(service.path("rest").path("hello").path("Joao Paulo").accept(MediaType.TEXT_PLAIN).get(String.class));
	}
}
