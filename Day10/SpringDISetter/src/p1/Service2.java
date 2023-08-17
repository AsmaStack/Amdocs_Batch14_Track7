package p1;

import org.springframework.stereotype.Component;

@Component("service2")
public class Service2 implements MyService{
	@Override
	public String getInfo() {
	
		return "Service 2-Info";
	}

}
