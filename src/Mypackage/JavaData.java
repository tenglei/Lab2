package Mypackage;
import java.util.ArrayList;

interface JavaData {
public void JavaDate(int ID,String Author,String book,String date);
public int getID();
public String getAuthor();
public ArrayList<String> getBook();
public String getDate(); 
public void setBook(int i,String bookNames);
public void setDate(String date);
public void deleteBook(int i);
public void addBook(String book);
}

