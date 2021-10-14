package movies;

public class ListAnalyzer {

	//used to test time it takes to add movies using HashSet
	//print time gets exponentially slower
	public static void main(String[] args) {
		ListFilmArchive archive = new ListFilmArchive();
		for(int i = 0; i < 100000; i++) {
			archive.add(new Movie("Movie" + i, 2017));
			if(i%1000 == 0) 
				System.out.println(i);
			}
		System.out.println("DONE");
	}
}
