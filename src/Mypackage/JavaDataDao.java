package Mypackage;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class JavaDataDao extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JavaDateImplement data = new JavaDateImplement();
	private List<BookList> Books = new ArrayList<BookList>();
	private String Author;
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
		String rlt;

		java.sql.Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.print("loading success!\n");
		} catch (ClassNotFoundException e) {
			System.out.print("loading Error!\n");
			e.printStackTrace();
		}
		try {

			System.out.print("²ÎÊý£º");
			System.out.print(this.Author);

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/authorlist?useUnicode=true&characterEncoding=GBK", "root", "87239107");
			String authortable = "select * from Author where Name= ? ";
			psmt = con.prepareStatement(authortable);
			psmt.setString(1, this.Author);
			rs = psmt.executeQuery();
			if (rs.next()) {
				rs.previous();
				while (rs.next()) {
					Integer authorID = rs.getInt(4);
					// System.out.print("Finish first found!");
					String booktable = "select * from Book where AuthorID=?";
					PreparedStatement psmt2 = con.prepareStatement(booktable);
					psmt2.setString(1, authorID.toString());
					rs2 = psmt2.executeQuery();
					if (rs2.next()) {
						rs2.previous();
					} else {
						return rlt = "notfound";
					}
					// System.out.print("Into while");

					String Country = rs.getString(1);
					int Age = rs.getInt(2);
					String Name = rs.getString(3);
					int AuthorID = rs.getInt(4);
					this.data.JavaDate(Country, Age, Name, AuthorID);

					while (rs2.next()) {
						float Price = rs2.getFloat(1);
						String PublishDate = rs2.getString(2);
						String Publisher = rs2.getString(3);
						Integer AuthorIDIn = rs2.getInt(4);
						String Title = rs2.getString(5);
						Integer ISBN = rs2.getInt(6);
						this.data.JavaBookDate(Price, PublishDate, Publisher, AuthorIDIn, Title, ISBN);
						// System.out.print("finish book init");
					}
					System.out.print(this.data.getAuthor());
					this.Books = data.getBooks();
					list.add(this.data);
				}

				System.out.print("Connect success!\n");
				rlt = "found";
			} else {
				rs.previous();
				rlt = "notfound";
				System.out.print("rlt=");
				System.out.print(rlt);
				return rlt;
			}

		} catch (SQLException e) {
			System.out.print("Connect Error!\n");
			rlt = "notfound";
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
				rlt = "notfound";
				e.printStackTrace();
			}
		}
		// System.out.print("Finish datadao!\n");
		return rlt;

	}

	public List<BookList> getBooks() {
		return Books;
	}

	public void setBooks(List<BookList> books) {
		Books = books;
	}

}
