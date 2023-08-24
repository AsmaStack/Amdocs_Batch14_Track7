package junitdemo;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
@RunWith(Parameterized.class)
public class CalculatorTest {
	Calculator c1;
	
    @Parameterized.Parameter(0)
    public int a;
    @Parameterized.Parameter(1)
    public int b;
    @Parameterized.Parameter(2)
    public int expectedresult;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 1, 1, 2 },
                { 2, 3, 5 },
                { 5, 5, 10 },
                {10,10,20},
                { 1, 1, 0 },
                { 2, 3, -1 },
                { 5, 5, 0 },
                {20,10,10}
   
        });
    }
    
   
	@Before
	public void setUp()
	{
		c1= new Calculator();
	}
	@Test
	public void testadd()
	{
		
		int result=c1.add(a, b);
		assertEquals(expectedresult,result);
		
	}
	@Test
	public void testsub()
	{
		
		int result=c1.subtract(a, b);
		assertEquals(expectedresult, result);
	}
	@After
	public void tearDown()
	{
		
		//c1=null;
		System.gc();
		System.out.println("Memory is released"+this);
	}
	
}
