package movies;

import java.util.*;

public class HashFilmArchive extends ArrayList<Movie> implements FilmArchive {
	
	//sort movies using HashSet
	//returns ArrayList of sorted movies
	public ArrayList<Movie> getSorted(){
		HashSet<Movie> sorter = new HashSet<Movie>(this);
		ArrayList<Movie> sortedMovies = new ArrayList<Movie>(sorter);
		return sortedMovies;
	}
	
	/*
	 * reason why you dont need an add() method is because its already in superclass w/ no need to override
	 */
	
	//prints movies in order of addition
	//then prints another list by title, then year
	public static void main(String[] args) {
		HashFilmArchive archive = new HashFilmArchive();
		for(Movie m: Movie.getTestMovies())
			archive.add(m);
		for(Movie m: archive)
			System.out.println(m);
		System.out.println("**************");
		for(Movie m: archive.getSorted())
			System.out.println(m);
	}
}
