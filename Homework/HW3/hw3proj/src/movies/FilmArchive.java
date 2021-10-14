package movies;

import java.util.*;

public interface FilmArchive {
	
	//sorts test movies
	//returns ArrayList of sorted movies
	public ArrayList<Movie> getSorted();
	
	//adds movie into list
	//returns boolean true if added, false if not
	public boolean add(Movie m);
}
