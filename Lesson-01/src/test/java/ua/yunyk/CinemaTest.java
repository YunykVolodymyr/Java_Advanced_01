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


public class CinemaTest {

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
	
	private static Cinema cinema;
	private static Seance seance1;
	private static Seance seance2;
	private static String day;
	
	@BeforeClass
	public static void setUp() {
		cinema = new Cinema();
		day = "Monday";
		seance1 = new Seance(new Movie("Movie1", new Time(1,40)),new Time(15,30));
		seance2 = new Seance(new Movie("Movie2", new Time(2,10)), new Time(20,20));
	}

	@AfterClass
	public static void tearDown() {
		cinema = null;
		seance1 = null;
		seance2 = null;
		day = null;
	}

	@Test
	public void addSeanceTest() {
		cinema.addSeance(seance1, day);
		cinema.addSeance(seance2, day);
		List<Seance> expected =  new ArrayList<Seance>();
		expected.add(seance1);
		expected.add(seance2);
		List<Seance> actual = cinema.getSeances();
		Assert.assertEquals(expected, actual);
	}

}
