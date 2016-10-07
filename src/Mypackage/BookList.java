package Mypackage;

public class BookList {
	public String BookName;
	public float Price;
	public String PublishDate;
	public String Publisher;
	public int ISBN;
	public int AuthorID;
	public BookList(){
		
	}
	public BookList(float Price,String PublishDate,String Publisher,int AuthorID,String Title,int ISBN){
		this.BookName = Title;
		this.PublishDate = PublishDate;
		this.Price = Price;
		this.Publisher =  Publisher;
		this.ISBN = ISBN;
		this.AuthorID = AuthorID;
	}
	public int AuthorID(){
		return AuthorID;
	}
	public float getPrice(){
		return Price;
	}
	public String getPublishDate(){
		return PublishDate;
	}
	public String getPublisher(){
		return Publisher;
	}
	public int getISBN(){
		return ISBN;
	}
	public String getBookName(){
		return BookName;
	}
}
