package ua.yunyk;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Cinema {

	Time open;
	Time close;
	private Map<Days, Schedule> schedules = new TreeMap<>();
	private ArrayList<Movie> moviesLibrary = new ArrayList<>();
	Scanner s = new Scanner(System.in);

	public List<Seance> getSeances() {
		List<Seance> seanses = new ArrayList<Seance>();
		for (Schedule schedule : schedules.values()) {
			seanses.addAll(schedule.getSeances());
		}
		return seanses;
	}

	public Cinema() {
		System.out.println("Write time to open cinema");
		setOpen(new Time());
		System.out.println("Write time to close cinema");
		setClose(new Time());
	}
	
	public Time getOpen() {
		return open;
	}

	public void setOpen(Time open) {
		this.open = open;
	}

	public Time getClose() {
		return close;
	}

	public void setClose(Time close) {
		this.close = close;
	}

	public void addMovie(Movie movie) {
		moviesLibrary.add(movie);
	}

	public void addSeance(Seance s, String day) {
		if (schedules.keySet().stream().anyMatch(t -> t.name().equalsIgnoreCase(day))) {
			Schedule shc = schedules
					.get(schedules.keySet().stream().filter(t -> t.name().equalsIgnoreCase(day)).findAny().get());
			shc.addSeance(s);
		} else if (Arrays.stream(Days.values()).anyMatch(t -> t.name().equalsIgnoreCase(day))) {
			schedules.put(Arrays.stream(Days.values()).filter(t -> t.name().equalsIgnoreCase(day)).findAny().get(),
					new Schedule());
			addSeance(s, day);
		} else
			System.out.println("There is no day " + day);
	}

	public void removeMovie(Movie movie) {
		moviesLibrary.remove(moviesLibrary.stream().filter(t -> t.compareTo(movie) == 0).findAny().get());
		schedules.forEach((d, s) -> s.removeSeance(
				s.getSeances().stream().filter(t -> t.getMovie().compareTo(movie) == 0).collect(toList())));
	}

	public void removeSeance(Seance seance, String day) {
		if (schedules.keySet().stream().anyMatch(t -> t.name().equalsIgnoreCase(day))) {
			schedules.get(schedules.keySet().stream().filter(t -> t.name().equalsIgnoreCase(day)).findAny().get())
					.removeSeance(seance);
		} else
			System.out.println("There is no seanses in day " + day);
	}

	public void printSeanes() {
		System.out.println();
		schedules.forEach((d, s) -> System.out.println(d + " \n " + s.getSeances()));
		System.out.println();
	}
	
	public void printLibrary() {
		System.out.println("Movies: \n");
		moviesLibrary.forEach(System.out::println);
		System.out.println();
	}

}
