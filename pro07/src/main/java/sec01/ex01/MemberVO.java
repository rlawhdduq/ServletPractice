package sec01.ex01;

import java.sql.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class MemberVO
 */
@WebServlet("/MemberVO")
public class MemberVO extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private String id;
       private String pwd;
       private String name;
       private String email;
       private Date joinDate;
       
       public String getId() {
		return id;
	}
    
       
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberVO() {
    	System.out.println("MemberVO ������ ȣ��");
    }

}
