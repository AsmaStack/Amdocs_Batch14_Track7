package p1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestDISetter {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext appcontext=new AnnotationConfigApplicationContext();
		appcontext.scan("p1");
		appcontext.refresh();
		
		MyClient client1= (MyClient) appcontext.getBean("client1");
		client1.doSomething();
		

	}

}
