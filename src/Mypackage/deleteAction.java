package Mypackage;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class deleteAction extends ActionSupport {
	private JavaDateImplement data = new JavaDateImplement();
	private Integer ISBN;
	private List<JavaDateImplement> list = new ArrayList<JavaDateImplement>();
	private String rlt;

	public List<JavaDateImplement> getlist() {
		return this.list;
	}

	public void setlist(List<JavaDateImplement> list) {
		this.list = list;
	}

	public Integer getAuthor() {
		return this.getISBN();
	}

	public void setAuthor(Integer ISBN) {
		this.setISBN(ISBN);
	}

	public JavaDateImplement getData() {
		return this.data;
	}

	public void setData(JavaDateImplement data) {
		this.data = data;
	}

	public String search() {
		System.out.print("change1");
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
			if (this.ISBN == 0) {
				return rlt = "empty";
			}
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/authorlist?useUnicode=true&characterEncoding=GBK", "root", "87239107");
			String existbook = "select * from book where ISBN =?";
			PreparedStatement psmt3 = con.prepareStatement(existbook);
			psmt3.setString(1, this.ISBN.toString());
			ResultSet rs3 = psmt3.executeQuery();
			System.out.print("Enter rs2.next");
			if (rs3.next()) {
			} else {
				return rlt = "isbnerror";

			}

			String authortable = "delete from book where ISBN= ? ";
			psmt = con.prepareStatement(authortable);
			psmt.setString(1, this.ISBN.toString());
			psmt.executeUpdate();

			rlt = "success";
			System.out.print("²ÎÊý£º");
			System.out.print(this.getISBN().toString());
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

	public Integer getISBN() {
		return ISBN;
	}

	public void setISBN(Integer iSBN) {
		ISBN = iSBN;
	}
}
