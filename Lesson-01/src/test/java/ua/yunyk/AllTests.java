package ua.yunyk;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	TimeTest.class,
	MovieTest.class,
	ScheduleTest.class,
	SeanceTest.class,
	CinemaTest.class
})
public class AllTests {

}
