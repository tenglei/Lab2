package Mypackage;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class editAction extends ActionSupport {
	private String rlt = null;
	private JavaDateImplement data = new JavaDateImplement();
	private String Author;
	private String nAuthor;
	private String Publisher;
	private String PublishDate;
	private Float Price;
	private Integer ISBN;
	private List<JavaDateImplement> list = new ArrayList<JavaDateImplement>();

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
		System.out.print("change1");
		String rlt = null;
		java.sql.Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.print("loading success!\n");
		} catch (ClassNotFoundException e) {
			rlt = "fail";
			System.out.print("loading Error!\n");
			e.printStackTrace();
		}
		try {
			System.out.print("Price:\n");
			System.out.print(this.Price);
			System.out.print("PublishDate:\n");
			System.out.print(this.PublishDate);
			System.out.print("Publisher:\n");
			System.out.print(this.Publisher);
			System.out.print("Price:\n");
			System.out.print(this.Price);
			if (this.Author == null || this.ISBN == 0 || this.Price == 0.0d || this.PublishDate == null
					|| this.Publisher == null) {
				return rlt = "empty";
			}
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/authorlist?useUnicode=true&characterEncoding=GBK", "root", "87239107");
			String setauthor = "select * from author where Name =?";
			psmt = con.prepareStatement(setauthor);
			psmt.setString(1, this.Author);
			System.out.print("编辑图书ID：");
			System.out.print(this.ISBN);
			System.out.print("编辑作者：");
			System.out.print(this.Author);
			System.out.print("Finish first found!");
			rs = psmt.executeQuery();
			if (rs.next()) {
				Integer author = rs.getInt(4);
				System.out.print("未插入作者");
				System.out.print(author);

				String setbook = "update book set PublishDate =? ,Publisher = ?,Price = ?,AuthorID=? where ISBN =?";
				PreparedStatement psmt2 = con.prepareStatement(setbook);
				psmt2.setString(1, this.PublishDate);
				psmt2.setString(2, this.Publisher);
				psmt2.setString(3, this.Price.toString());
				psmt2.setString(4, author.toString());
				psmt2.setString(5, this.ISBN.toString());
				psmt2.executeUpdate();

				String existbook = "select * from book where ISBN =?";
				PreparedStatement psmt3 = con.prepareStatement(existbook);
				psmt3.setString(1, this.ISBN.toString());
				ResultSet rs3 = psmt3.executeQuery();
				System.out.print("Enter rs2.next");
				if (rs3.next()) {
				} else {
					return rlt = "isbnerror";

				}

				System.out.print("Connect success!\n");
				rlt = "success";
				System.out.print("rlt=");
				System.out.print(rlt);
			} else {
				System.out.print("插入新作者");
				String newauthor = "insert into author(Name)  values(?)";
				PreparedStatement ps = con.prepareStatement(newauthor);
				ps.setString(1, Author);
				ps.executeUpdate();

				String linkbook = "select * from author where Name =?";
				PreparedStatement psmt4 = con.prepareStatement(linkbook);
				psmt4.setString(1, this.Author);
				ResultSet rs1 = psmt4.executeQuery();
				rs1.next();
				Integer authorid = rs1.getInt(4);
				System.out.print("print authorid");
				System.out.print(authorid);

				String existbook = "select * from book where ISBN =?";
				PreparedStatement psmt3 = con.prepareStatement(existbook);
				psmt3.setString(1, this.ISBN.toString());
				ResultSet rs3 = psmt3.executeQuery();
				System.out.print("Enter rs2.next");
				if (rs3.next()) {
				} else {
					return rlt = "isbnerror";
				}
				String setbook = "update book set PublishDate=? ,Publisher=?,Price=?,AuthorID=? where ISBN=?";
				PreparedStatement psmt2 = con.prepareStatement(setbook);
				psmt2.setString(1, this.PublishDate);
				psmt2.setString(2, this.Publisher);
				psmt2.setString(3, this.Price.toString());
				psmt2.setString(4, authorid.toString());
				psmt2.setString(5, this.ISBN.toString());
				psmt2.executeUpdate();

				rlt = "success";
			}
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
		System.out.print("Finish editaction!\n");
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
}
