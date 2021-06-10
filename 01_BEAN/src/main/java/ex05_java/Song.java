package ex05_java;

public class Song {

	// field
	private String title;
	private String genre;
	
	// constructor
	public Song() {
		// default
	}
	public Song(String title, String genre) {
		super();
		this.title = title;
		this.genre = genre;
	}
	
	// method
	// getter/setter
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
}
