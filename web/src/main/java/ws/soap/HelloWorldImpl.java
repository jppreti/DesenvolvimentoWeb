package ws.soap;

import javax.jws.WebService;

@WebService(endpointInterface="ws.soap.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

	@Override
	public String sayHello(String msg) {
		return "Olá " + msg;
	}
	
}
