package ws.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class RestHelloWorld {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{param}")
	public String sayHello(@PathParam("param") String msg){
		return "Olá " + msg;
	}
	
}
