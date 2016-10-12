package Mypackage;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class addAction extends ActionSupport {

	private JavaDateImplement data = new JavaDateImplement();
	private String Author;
	private String nAuthor;
	private String Publisher;
	private String PublishDate;
	private Float Price;
	private Integer ISBN;
	private String Country;
	private Integer Age;
	private String Title;
	private List<JavaDateImplement> list = new ArrayList<JavaDateImplement>();
	private String rlt;

	public List<JavaDateImplement> getlist() {
		return this.list;
	}

	public void setlist(List<JavaDateImplement> list) {
		this.list = list;
	}

	public String getAuthor() {
		return this.Author;
	}

	public void setAuthor(String Author) {
		this.Author = Author;
	}

	public JavaDateImplement getData() {
		return this.data;
	}

	public void setData(JavaDateImplement data) {
		this.data = data;
	}

	public String search() {
		System.out.print("change3");
		String rlt;
		java.sql.Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.print("loading success!\n");
		} catch (ClassNotFoundException e) {
			System.out.print("loading Error!\n");
			rlt = "fail";
			e.printStackTrace();
		}
		try {
			if (this.Author == null || this.Age == null || this.Country == null || this.Price == 0.0d
					|| this.PublishDate == null || this.Publisher == null) {
				return rlt = "empty";
			}
			System.out.print("PublishDate:\n");
			System.out.print(this.PublishDate);
			System.out.print("Publisher:\n");
			System.out.print(this.Publisher);
			System.out.print("Price:\n");
			System.out.print(this.Price);
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/authorlist?useUnicode=true&characterEncoding=GBK", "root", "87239107");
			String gtauthor = "select * from author where Name =?";
			psmt = con.prepareStatement(gtauthor);
			psmt.setString(1, this.Author);
			rs = psmt.executeQuery();
			if (rs.next()) {

				System.out.print("²ÎÊý£º");
				System.out.print(this.Author);

				Integer authorID = rs.getInt(4);
				String setbook = "INSERT INTO book(Price,PublishDate,Publisher,Title,AuthorID) VALUES (?,?,?,?,?)";
				PreparedStatement psmt3 = con.prepareStatement(setbook);
				psmt3.setString(1, this.Price.toString());
				psmt3.setString(2, this.PublishDate);
				psmt3.setString(3, this.Publisher);
				psmt3.setString(4, this.Title);
				psmt3.setString(5, authorID.toString());
				psmt3.executeUpdate();
				System.out.print("Connect success!\n");

			} else {
				String setauthor = "INSERT INTO author(Country,Age,Name) VALUES(?,?,?)";
				PreparedStatement psmt2 = con.prepareStatement(setauthor);
				psmt2.setString(1, this.Country);
				psmt2.setString(2, this.Age.toString());
				psmt2.setString(3, this.Author);
				psmt2.executeUpdate();

				if (this.Author == null) {
					return rlt = "empty";
				}
				System.out.print("select from author :");
				System.out.print(this.Author);
				String linkbook = "select * from author where Name =?";
				PreparedStatement psmt4 = con.prepareStatement(linkbook);
				psmt4.setString(1, this.Author);
				ResultSet rs1 = psmt4.executeQuery();
				rs1.next();
				Integer authorid = rs1.getInt(4);
				System.out.print("print authorid");
				System.out.print(authorid);

				String setbook = "INSERT INTO book(Price,PublishDate,Publisher,Title,AuthorID) VALUES (?,?,?,?,?)";
				PreparedStatement psmt3 = con.prepareStatement(setbook);
				psmt3.setString(1, this.Price.toString());
				psmt3.setString(2, this.PublishDate);
				psmt3.setString(3, this.Publisher);
				psmt3.setString(4, this.Title);
				psmt3.setString(5, authorid.toString());
				psmt3.executeUpdate();

			}
			rlt = "success";
			System.out.print("rlt=");
			System.out.print(rlt);
		} catch (SQLException e) {
			System.out.print("Connect Error!\n");
			rlt = "fail";
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (psmt != null) {
					psmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				rlt = "fail";
				e.printStackTrace();
			}
		}
		System.out.print("Finish addaction!\n");
		return rlt;
	}

	public String getPublisher() {
		return Publisher;
	}

	public void setPublisher(String publisher) {
		Publisher = publisher;
	}

	public String getPublishDate() {
		return PublishDate;
	}

	public void setPublishDate(String publishDate) {
		PublishDate = publishDate;
	}

	public Float getPrice() {
		return Price;
	}

	public void setPrice(Float price) {
		Price = price;
	}

	public Integer getISBN() {
		return ISBN;
	}

	public void setISBN(Integer iSBN) {
		ISBN = iSBN;
	}

	public String getnAuthor() {
		return nAuthor;
	}

	public void setnAuthor(String nAuthor) {
		this.nAuthor = nAuthor;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public Integer getAge() {
		return Age;
	}

	public void setAge(Integer age) {
		Age = age;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}
}
