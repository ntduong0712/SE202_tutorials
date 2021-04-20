package Exercise2;

public class Book {
	// 1. Add the Fields
	private String author;
	private String title;
	private double price;
	// 2. Add the Constructor
	public Book(String author, String title, double price) {
		this.setAuthor(author); 
		this.setTitle(title);
		this.setPrice(price);
	}
	// 3. Add the Properties
	public String getAuthor() {
		return author;
	}
	protected void setAuthor(String author) { 
		//TODO: condition if!!!
		if (author.contains(" ")) {
			String authorLastName = author.split(" ")[1];
			if(authorLastName.matches("^[0-9].*")) {
				throw new IllegalArgumentException("Author not valid");
			}
		}
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	protected void setTitle(String title) {
		if(title.length() < 3) {
			throw new IllegalArgumentException("Title not valid!");
		}
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	protected void setPrice(double price) {
		if (price < 1) {
			throw new IllegalArgumentException("Price not valid!");
		}
		this.price = price;
	}
	// 4. Add the Methods
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Type: ")
			.append(this.getClass().getSimpleName())
			.append(System.lineSeparator())
			.append("Title: ").append(this.getTitle())
			.append(System.lineSeparator())
			.append("Author: ").append(this.getAuthor())
			.append(System.lineSeparator())
			.append("Price: ").append(this.getPrice())
			.append(System.lineSeparator());
		return sb.toString();
	}
}
