package movies;

import java.util.*;

public class Movie implements Comparable<Movie> {
	private String title;
	private int year;

	//constructor
	public Movie(String t, int y) {
		title = t;
		year = y;
	}
	
	//compares movies by title then year
	//returns -1 if THIS is before THAT
	//returns 0 if movies are deep equal
	//returns 1 is THIS is after THAT
	public int compareTo(Movie that) {
		int titleCmp = this.title.compareTo(that.title);
		if(titleCmp != 0) 
			return titleCmp;
		else
			return this.year - that.year;	//now compares by year, since knonw title is same
	}										//titleCmp cannot be float because you can convert int to float but not float to int (parse)

	//returns title
	public String getTitle() {
		return title;
	}

	//returns year
	public int getYear() {
		return year;
	}

	//checks if movies are deep equal
	//returns true if movies are deep equal, false if not
	public boolean equals(Object x) {
		Movie that = (Movie)x;
		if (!this.title.equals(that.title))
			return false;
		if (this.year != that.year)
			return false;
		else
			return true;
		/*
		 * can also do...
		 * Movie that = (Movie)x;	//change object to movie
		 * return this.compareTo(that) == 0;	//if compareTo return 0, return true; if not return false
		 */
	}

	//returns string of movie title and year
	public String toString() {
		return "Movie " + title + " (" + year + ")";
	}

	//returns array of test movies
	 public static Movie[] getTestMovies() { 
		 Movie movies[] = new Movie[10];
		 movies[0] = new Movie("Ghost In The Shell", 1995); //same title, different year
		 movies[1] = new Movie("Ghost In The Shell", 2017); 
		 movies[2] = new Movie("Sword Art Online: Ordinal Scale", 2017); //different title, same year
		 movies[3] = new Movie("Emoji Movie", 2017); 
		 movies[4] = new Movie("White Chicks", 2004); //same movie
		 movies[5] = new Movie("White Chicks", 2004); 
		 movies[6] = new Movie("Battle Royale", 2000); //4 other movies
		 movies[7] = new Movie("Princess Mononoke", 1999); 
		 movies[8] = new Movie("Legally Blonde", 2001); 
		 movies[9] = new Movie("Mean Girls", 2004); 
		 return movies; 
		 
		 /*
		  * can also do...
		  * int n = 0;
		  * movies[n++] = new Movie(...);	//so no need to go back and change the number for each pos
		  * movies[n++] = new Movie(...);
		  * movies[n++] = new Movie(...);
		  */
	}

	//overrides hashCode() in Object class
	//returns int of "address" of movie object
	public int hashCode() {
		return title.hashCode() + year;		//takes characteristics of object, and uses it in address
											//used for deep equal objects, to return same hashCode
	}

}
