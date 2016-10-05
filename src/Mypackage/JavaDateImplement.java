package Mypackage;
import java.util.ArrayList;
import java.sql.Date;
public class JavaDateImplement implements JavaData {
	private int ID;
	private String Author;
	private ArrayList<String> BookName;
	private String Date;

	public void JavaDate(int ID, String Author, String book, String date) {
		this.ID = ID;
		this.Author = Author;
		this.BookName.add(book);
		this.Date = date;
	}
	public void deleteBook(int i) {
		BookName.remove(i);
	}

	@Override
	public int getID() {

		return ID;
	}

	@Override
	public String getAuthor() {
		// TODO Auto-generated method stub
		return Author;
	}

	@Override
	public ArrayList<String> getBook() {
		// TODO Auto-generated method stub
		return BookName;
	}

	@Override
	public String getDate() {
		// TODO Auto-generated method stub
		return Date;
	}

	@Override
	public void setBook(int i, String bookNames) {
		// TODO Auto-generated method stub
		this.BookName.set(i,bookNames) ;
	}

	@Override
	public void setDate(String date) {
		// TODO Auto-generated method stub
		Date = date;
	}

	@Override
	public void addBook(String book) {
		// TODO Auto-generated method stub
		this.BookName.add(book);

	}

}
