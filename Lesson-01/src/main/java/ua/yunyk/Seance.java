package ua.yunyk;

public class Seance implements Comparable<Seance> {

	private Movie movie;
	private Time startTime;
	private Time endTime;

	public Seance() {
		setMovie(new Movie());
		System.out.println("Write time to begin");
		setStartTime(new Time());
		endTime = new Time(movie.getDuration().getMin() + this.startTime.getMin(),
				movie.getDuration().getHour() + this.startTime.getHour());
	}

	public Seance(Movie movie, Time startTime) {
		super();
		this.movie = movie;
		this.startTime = startTime;
		endTime = new Time(movie.getDuration().getHour() + this.startTime.getHour(),
				movie.getDuration().getMin() + this.startTime.getMin());
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "Movies: \n   " + movie + "\n Time to begin: " + startTime + "\n Time to end: " + endTime;
	}

	@Override
	public int compareTo(Seance o) {
		if (movie.compareTo(o.movie) != 0)
			return movie.compareTo(o.movie);
		else if (startTime.compareTo(o.startTime) != 0)
			return startTime.compareTo(o.startTime);
		else
			return endTime.compareTo(o.endTime);
	}

}
