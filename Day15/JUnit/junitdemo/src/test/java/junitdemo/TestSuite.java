package junitdemo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	CalculatorTest.class,
	Test2.class
})
public class TestSuite {

}
