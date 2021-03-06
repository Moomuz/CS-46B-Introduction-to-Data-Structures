package movies;

import java.util.*;

public class ListFilmArchive extends ArrayList<Movie> implements FilmArchive{
	
	//adds movie into list
	//returns boolean true if added, false if not
	public boolean add(Movie that) {
		for(Movie m: this) {
			if(m.equals(that))
				return false;
		}
		boolean reallyAdded = super.add(that);
		return reallyAdded;
		
		/*
		 * can also do...
		 * return super.add(that);
		 */
		
		/*
		 * DO NOT WRITE MORE CODE IF YOU DONT UNDERSTAND WHATS GOING ON
		 */
	}

	//sorts movies using TreeSet
	//returns ArrayList of sorted movies
	public ArrayList<Movie> getSorted() {
		TreeSet<Movie> sorter = new TreeSet<Movie>(this);
		ArrayList<Movie> sortedMovies = new ArrayList<Movie>(sorter);
		return sortedMovies;
		
		/*
		 * can also do this
		 * TreeSet<Movie> sorter = new TreeSet<Movie>(this);
		 * return new ArrayList<Movie>(sorter);
		 */
	}
	
	//prints movies in order of addition
	//then prints another list by title, then year
	public static void main(String[] args) {
		ListFilmArchive archive = new ListFilmArchive();
		for(Movie m: Movie.getTestMovies())
			archive.add(m);
		for(Movie m: archive)
			System.out.println(m);
		System.out.println("**************");
		for(Movie m: archive.getSorted())
			System.out.println(m);
	}
}
