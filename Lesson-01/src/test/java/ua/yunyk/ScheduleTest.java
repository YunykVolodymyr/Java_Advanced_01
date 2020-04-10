package ua.yunyk;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;


public class ScheduleTest {

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
	
	private static Schedule schedule;
	private static Movie movie1;
	private static Movie movie2;
	private static Time startTime1;
	private static Time startTime2;
	private static Seance seance1;
	private static Seance seance2;
	
	
	@BeforeClass
	public static void setUp() throws Exception {
		schedule = new Schedule();
		movie1 = new Movie("movie1",new Time(1,40));
		movie2 = new Movie("movie2", new Time(2,10));
		startTime1 = new Time(14,20);
		startTime2 = new Time(20,20);
		seance1 = new Seance(movie1, startTime1);
		seance2 = new Seance(movie2, startTime2);
	}

	@AfterClass
	public static void tearDown() throws Exception {
		schedule = null;
	}

	@Test
	public void addSeanceTest() {
		schedule.addSeance(seance1);
		schedule.addSeance(seance2);
		List<Seance> expected = new ArrayList<Seance>();
		expected.add(seance1);
		expected.add(seance2);
		List<Seance> actual = schedule.getSeances();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void removeSeancesTest() {
		schedule.removeSeance(schedule.getSeances());
		List<Seance> actual = schedule.getSeances();
		List<Seance> expected = new ArrayList<Seance>();
		Assert.assertEquals(expected, actual);
	}

}
