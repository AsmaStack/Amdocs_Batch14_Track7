package p1;

import org.springframework.stereotype.Component;

@Component("service1")
public class ServiceImpl implements MyService{

	@Override
	public String getInfo() {
		
		return "Service 1-Info";
	}

}
