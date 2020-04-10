package ua.yunyk;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;


public class SeanceTest {

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
	
	private Movie movie;
	private Time startTime;
	private Seance seance;

	@Before
	public void setUp() {
		movie = new Movie("Movie", new Time(1, 45));
		startTime = new Time(16, 0);
		seance = new Seance(movie, startTime);
	}

	@After
	public void tearDown() {
		movie = null;
		startTime = null;
	}

	@Test
	public void constructorTest() {
		int expectedHour = 17;
		int actualHour = seance.getEndTime().getHour();
		int expectedMin = 45;
		int actualMin = seance.getEndTime().getMin();
		Assert.assertEquals(expectedHour, actualHour);
		Assert.assertEquals(expectedMin, actualMin);
	}

}
