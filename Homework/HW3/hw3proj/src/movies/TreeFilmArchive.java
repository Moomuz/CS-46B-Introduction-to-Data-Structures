package movies;

import java.util.*;

public class TreeFilmArchive extends TreeSet<Movie> implements FilmArchive{
	
	//sorts test movies using TreeSet
	public ArrayList<Movie> getSorted() {
		ArrayList<Movie> sortedMovies = new ArrayList<Movie>(this);
		return sortedMovies;
	}
	
	//prints movies in order of addition
	//then prints another list by title, then year
	public static void main(String[] args) {
		TreeFilmArchive archive = new TreeFilmArchive();
		for(Movie m: Movie.getTestMovies())
			archive.add(m);
		for(Movie m: archive)
			System.out.println(m);
		System.out.println("**************");
		for(Movie m: archive.getSorted())
			System.out.println(m);
	}
}
