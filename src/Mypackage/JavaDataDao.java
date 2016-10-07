package Mypackage;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import com.mysql.jdbc.Connection;

public class JavaDataDao {
	public List<JavaDateImplement> search(String author) {
		List<JavaDateImplement> list = new ArrayList<JavaDateImplement>();
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
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/authorlist?useUnicode=true&characterEncoding=GBK", "root", "87239107");
			String authortable = "select * from Author where Name= ? ";
			psmt = con.prepareStatement(authortable);
			psmt.setString(1, author);
			System.out.print("²ÎÊý£º");
			System.out.print(author);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Integer authorID = rs.getInt(4);
				System.out.print("Finish first found!");
				String booktable = "select * from Book where AuthorID=?";
				PreparedStatement psmt2 = con.prepareStatement(booktable);
				psmt2.setString(1, authorID.toString());
				rs2 = psmt2.executeQuery();
				System.out.print("Into while");
				
				JavaDateImplement tmp = new JavaDateImplement();
				String Country = rs.getString(1);
				int Age = rs.getInt(2);
				String Name = rs.getString(3);
				int AuthorID = rs.getInt(4);
				tmp.JavaDate(Country, Age, Name, AuthorID);
				while (rs2.next()) {					
					float Price = rs2.getFloat(1);
					String PublishDate = rs2.getString(2);
					String Publisher = rs2.getString(3);
					Integer AuthorIDIn = rs2.getInt(4);
					String Title = rs2.getString(5);
					Integer ISBN = rs2.getInt(6);
					tmp.JavaBookDate(Price, PublishDate, Publisher, AuthorIDIn, Title, ISBN);
					System.out.print("finish book init");
				}
				System.out.print(tmp.getAuthor());
				list.add(tmp);
			}
			System.out.print("Connect success!\n");
		} catch (SQLException e) {
			System.out.print("Connect Error!\n");
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
				e.printStackTrace();
			}
		}
		// System.out.print("Finish datadao!\n");
		return list;

	}

}
