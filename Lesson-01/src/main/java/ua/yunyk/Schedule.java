package ua.yunyk;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Schedule {

	private Set<Seance> seances = new TreeSet<>();

	public List<Seance> getSeances() {
		 List<Seance> s =  new ArrayList<Seance>();
		 s.addAll(seances);
		 return s;
	}

	public void addSeance(Seance s) {
		seances.add(s);
	}

	public void removeSeance(Seance s) {
		seances.remove(s);
	}

public void removeSeance(List<Seance> l) {
		for(int i = 0; i < l.size(); i++) {
			removeSeance(l.get(i));
		}
	}

@Override
public String toString() {
	String result = "";
	for (Seance seance : seances) {
		result += seance + " \n";
	}
	return result;
}
}
