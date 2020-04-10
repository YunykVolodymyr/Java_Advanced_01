package ua.yunyk;

import java.util.Scanner;

public class Time implements Comparable<Time> {

	private int min;
	private int hour;
	Scanner s = new Scanner(System.in);

	public Time() {
		System.out.println("Wrimte houres 0..24");
		setHour(s.nextInt());
		System.out.println("Write minutes 0..60");
		setMin(s.nextInt());
	}

	public Time(int hour, int min) {
		super();
		setMin(min);
		setHour(hour);
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		if (min > 0 && min < 60)
			this.min = min;
		else if (min > 60)
			this.min = min - 60;
		else if (min < 0)
			this.min = min * -1;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		if (hour > 0 && hour < 24)
			this.hour = hour;
		if (hour >= 24)
			this.hour = hour - 24;
		if (hour < 0)
			this.hour = hour * -1;
	}

	@Override
	public String toString() {
		return hour + "h " + min + "min ";
	}

	@Override
	public int compareTo(Time o) {
		if (Integer.compare(hour, o.hour) != 0)
			return Integer.compare(hour, o.hour);
		else
			return Integer.compare(min, o.min);
	}

}
