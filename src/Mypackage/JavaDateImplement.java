package Mypackage;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class JavaDateImplement extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ID;
	private String Author;
	private String Country;
	private int Age;
	private List<BookList> Books = new ArrayList<BookList>();
	private int BooksNumber;

	public String getCountry() {
		return Country;
	}

	public int getAge() {
		return Age;
	}

	public int getID() {

		return ID;
	}

	public String getAuthor() {
		// TODO Auto-generated method stub
		return Author;
	}

	public List<BookList> getBooks() {
		return Books;
	}

	public void setAuthor(String author) {
		this.Author = author;
	}

	public void setAge(int age) {
		this.Age = age;
	}

	public void setCountry(String country) {
		this.Country = country;
	}

	public void setBooks(List<BookList> books) {
		this.Books = books;
	}

	public void JavaDate(String Country, int Age, String Author, int ID) {
		this.ID = ID;
		this.Author = Author;
		this.Age = Age;
		this.Country = Country;
		BooksNumber = 0;
	}

	public void JavaBookDate(float Price, String PublishDate, String Publisher, int AuthorID, String Title, int ISBN) {
		BookList book = new BookList(Price, PublishDate, Publisher, AuthorID, Title, ISBN);
		System.out.print("init book list");
		System.out.print(book.getBookName());
		BooksNumber++;
		this.Books.add(book);
		System.out.print("finish add book");
	}

}
