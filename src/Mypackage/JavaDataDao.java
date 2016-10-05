package Mypackage;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

public class JavaDataDao {
	public List readFirstTitle() {
		List<JavaDateImplement> list = new ArrayList<JavaDateImplement>();
		java.sql.Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		try{
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/news", "root", "87239107");
			String sql="select * from title";
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()){
				int ID = rs.getInt("ID");
				String Author = rs.getString("Author");
				String BookName = rs.getString("BookName");
				String Date = rs.getString("Date");
				JavaDateImplement JDI = new JavaDateImplement();
				JDI.JavaDate(ID, Author, BookName, Date);
				list.add(JDI);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{
				if(rs!=null){
					rs.close();
				}
				if(psmt!=null){
					psmt.close();
				}
				if(con!=null){
					con.close();
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		return list;
		
	}
}
