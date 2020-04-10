package ua.yunyk;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class TimeTest {

	@Rule
	public TestWatcher watcher = new TestWatcher() {
		
		@Override
		protected void failed(Throwable e, Description d) {
			System.out.println("Failed : <" + d.getMethodName() + ">");
		}
		
		@Override 
		protected void succeeded(Description d) {
			System.out.println("Succeed : <" + d.getMethodName() + ">");
		}
	};
	
	private Time myTime;
	
	@Before
	public void setUp() {
		myTime = new Time(0,0);
	}
	
	@Test
	public void setMinTest() {
		myTime.setMin(15);
		int expected = 15; 
		int actual = myTime.getMin();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void setMinNegativeTest() {
		myTime.setMin(-15);
		int expected = 15;
		int actual = myTime.getMin();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void setMinBiggerTest() {
		myTime.setMin(75);
		int expected = 15;
		int actual = myTime.getMin();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void setHourTest() {
		myTime.setHour(3);
		int expected = 3;
		int actual = myTime.getHour();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void setHourNegativeTest() {
		myTime.setHour(-3);
		int expected = 3;
		int actual = myTime.getHour();
		Assert.assertEquals(expected, actual);
	}
	
	@Test 
	public void setHourBiggerTest() {
		myTime.setHour(27);
		int expected = 3;
		int actual = myTime.getHour();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void compareToTest() {
		Time myTime1 = new Time(3,3);
		Time myTime2 = new Time(3,3);
		Time myTime3 = new Time(4,4);
		Assert.assertEquals(0, myTime1.compareTo(myTime2));
		Assert.assertNotEquals(0, myTime1.compareTo(myTime3));
	}
	
	@After
	public void tearDown() {
		myTime = null;
	}

}
