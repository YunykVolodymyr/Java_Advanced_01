package ua.yunyk;

import java.util.Scanner;

public class Movie implements Comparable<Movie> {
	Scanner s = new Scanner(System.in);
	private String title;
	private Time duration;

	public Movie() {
		System.out.println("Write title for movie");
		setTitle(s.next());
		System.out.println("Write duration");
		setDuration(new Time());
	}

	public Movie(String title, Time duration) {
		super();
		this.title = title;
		this.duration = duration;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Time getDuration() {
		return duration;
	}

	public void setDuration(Time duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Title: " + "\"" + title + "\" " + "duration: " + duration;
	}

	@Override
	public int compareTo(Movie o) {
		if (title.compareTo(o.getTitle()) != 0)
			return title.compareTo(o.getTitle());
		else
			return duration.compareTo(o.duration);
	}

}
