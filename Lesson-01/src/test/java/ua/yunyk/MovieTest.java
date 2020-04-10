package ua.yunyk;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class MovieTest {

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

	private Movie movie1;
	private Movie movie2;
	private Movie movie3;

	@Before
	public void setUp() {
		movie1 = new Movie("Movie1", new Time(1, 40));
		movie2 = new Movie("Movie2", new Time(2, 10));
		movie3 = new Movie("Movie1", new Time(1, 40));
	}

	@After
	public void tearDown() {
		movie1 = null;
		movie2 = null;
		movie3 = null;
	}

	@Test
	public void compareToTest() {
		Assert.assertEquals(0, movie1.compareTo(movie3));
		Assert.assertNotEquals(0, movie1.compareTo(movie2));
	}

}
