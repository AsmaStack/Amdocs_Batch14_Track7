package junitdemo;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Test2 {

Calculator c1;
	
	@Before
	public void setUp()
	{
		c1= new Calculator();
	}
	@Test
	public void testadd()
	{
		int a=5, b=10;
		int result=c1.add(a, b);
		assertEquals(15,result);
		
	}
	@Test
	public void testsub()
	{
		int a=6, b=10;
		int result=c1.subtract(a, b);
		assertEquals(-4, result);
	}
	@After
	public void tearDown()
	{
		
		//c1=null;
		System.gc();
		System.out.println("Memory is released"+this);
	}
	
}
