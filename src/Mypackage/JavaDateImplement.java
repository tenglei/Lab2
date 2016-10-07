package Mypackage;

import java.util.ArrayList;
import java.util.List;

public class JavaDateImplement {
	private int ID;
	private String Author;
	private String Country;
	private int Age;
	private List<BookList> Books;
	private int BooksNumber;
	public String getCountry(){
		return Country;
	}
	public int getAge(){
		return Age; 
	}
	public int getID() {

		return ID;
	}
	public String getAuthor() {
		// TODO Auto-generated method stub
		return Author;
	}
	public List<BookList> getBooks(){
		return Books;
	}
	public void JavaDate(String Country,int Age,String Author,int ID) {
		this.ID = ID;
		this.Author = Author;
		this.Age = Age;
		this.Country = Country;
		this.Books = new ArrayList<BookList>();
		BooksNumber = 0;
	}
	public void JavaBookDate(float Price,String PublishDate,String Publisher,int AuthorID,String Title,int ISBN){
		BookList book = new BookList(Price,PublishDate,Publisher,AuthorID,Title,ISBN);
		System.out.print("init book list");
		System.out.print(book.getBookName());
		BooksNumber++;
		this.Books.add(book);
		System.out.print("finish add book");
	}


}
