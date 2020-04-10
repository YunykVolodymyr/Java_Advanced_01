package ua.yunyk;

import java.util.Optional;
import java.util.Scanner;

public class Main {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		Cinema cinema = new Cinema();
		while (true) {
			menu();
			switch (s.next()) {
			case "1":
				Seance seance = new Seance();
				System.out.println("Write day");
				String day = s.next();
				cinema.addSeance(seance, day);
				break;
			case "2":
				System.out.println("Write title of movie");
				String title = s.next();
				System.out.println("Write time to begin");
				Time time = new Time();
				System.out.println("Write day");
				String day1 = s.next();
				Optional<Seance> findAny = cinema.getSeances().stream().filter(
						t -> t.getMovie().getTitle().equalsIgnoreCase(title) && t.getStartTime().compareTo(time) == 0)
						.findAny();
				if (findAny.isPresent())
					cinema.removeSeance(findAny.get(), day1);
				break;
			case "3":
				cinema.addMovie(new Movie());
				break;
			case "4":
				cinema.removeMovie(new Movie());
				break;
			case "5":
				cinema.printSeanes();
				break;
			case"6":
				cinema.printLibrary();
				break;
			case "7":
				System.exit(0);
				break;
			default:
				System.out.println("Write number 1..7");
				break;
			}
		}

	}

	public static void menu() {
		System.out.println("Write 1 to add seance to particular day");
		System.out.println("Write 2 to remove seance");
		System.out.println("Wtrite 3 to add movie to library");
		System.out.println("Write 4 to remove movie from everywhere");
		System.out.println("Write 5 to print all seances");
		System.out.println("Write 6 to print all movies from library");
		System.out.println("Write 7 to exit");
	}
}
