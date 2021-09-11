//package sec01.ex01;
//
//import java.sql.Connection;
//import java.sql.Date;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//import java.sql.SQLException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//
///**
// * Servlet implementation class MemberDAO
// */
//@WebServlet("/MemberDAO") 
//public class MemberDAO extends HttpServlet {
//
//	private static final String driver = "oracle.jdbc.driver.OracleDriver";
//	private static final String url = "jdbc:oracle:thin:@localhost:1521:orcl";
//	private static final String user = "c##scott";
//	private static final String pwd = "tiger";
//	private Statement stmt = null;
//	private Connection con;
//	public List<MemberVO> listMembers(){
//		List<MemberVO> list = new ArrayList<MemberVO>();
//		try {
//			connDB();
//			String query = "select * from t_member ";
//			System.out.println(query);
//			ResultSet rs = stmt.executeQuery(query);
//			
//			while(rs.next()) {
//				String id = rs.getString("id");
//				String pwd = rs.getString("pwd");
//				String name = rs.getString("name");
//				String email = rs.getString("email");
//				Date joinDate = rs.getDate("joinDate");
//				
//				MemberVO vo = new MemberVO();
//				vo.setId(id);
//				vo.setPwd(pwd);
//				vo.setName(name);
//				vo.setEmail(email);
//				vo.setJoinDate(joinDate);
//				list.add(vo);
//			}
//			rs.close();
//			stmt.close();
//			con.close();
//		} catch (Exception e) {
//		e.printStackTrace();
//		} return list;
//	}
//
//	private void connDB() {
//		try {
//			Class.forName(driver);
//			System.out.println("Oracle 드라이버 로딩 성공");
//			con = DriverManager.getConnection(url, user, pwd);
//			System.out.println("Connection 생성 성공");
//			stmt = con.createStatement();
//			stmt.executeUpdate("use serXDB");
//			System.out.println("Statement 생성 성공");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//}
