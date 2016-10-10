package Mypackage;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

public class showAction extends ActionSupport {

	/**
	* 
	*/
	private static final long serialVersionUID = -1853838235432536703L;
	private Integer ISBN;
	private Float Price;
	private String PublishDate;
	private String Publisher;
	private String Title;

	public Integer getAuthor() {
		return this.getISBN();
	}

	public void setAuthor(Integer ISBN) {
		this.setISBN(ISBN);
	}

	public String search() {
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

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/authorlist?useUnicode=true&characterEncoding=GBK", "root", "87239107");
			String authortable = "select * from book where ISBN= ? ";
			psmt = con.prepareStatement(authortable);
			psmt.setString(1, this.ISBN.toString());
			rs = psmt.executeQuery();
			while (rs.next()) {

				this.Price = rs.getFloat(1);
				System.out.print("²ÎÊý£º");
				System.out.print(this.getISBN().toString());
				this.PublishDate = rs.getString(2);
				this.Publisher = rs.getString(3);
				this.Title = rs.getString(5);
			}
			rlt = "success";
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
		// System.out.print("Finish datadao!\n");
		return rlt;
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

	public String getPublisher() {
		return Publisher;
	}

	public void setPublisher(String publisher) {
		Publisher = publisher;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public Integer getISBN() {
		return ISBN;
	}

	public void setISBN(Integer iSBN) {
		ISBN = iSBN;
	}
}
