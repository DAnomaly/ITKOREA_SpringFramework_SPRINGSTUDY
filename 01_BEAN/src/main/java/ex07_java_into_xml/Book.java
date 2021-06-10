package ex07_java_into_xml;

public class Book {

	// field
	private String title;
	private int price;
	private Publisher publisher;
	
	// constructor
	public Book() {}
	public Book(String title, int price, Publisher publisher) {
		super();
		this.title = title;
		this.price = price;
		this.publisher = publisher;
	}
	
	public void info() {
		System.out.println("책제목: " + title);
		System.out.println("가격: " + price);
		System.out.println("출판사명: " + publisher.getName());
		System.out.println("출판사위치: " + publisher.getLocation());
	}
	
	// getter
	public String getTitle() {
		return title;
	}
	public int getPrice() {
		return price;
	}
	public Publisher getPublisher() {
		return publisher;
	}
	// setter
	public void setTitle(String title) {
		this.title = title;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	
}
