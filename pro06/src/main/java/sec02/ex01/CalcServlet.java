package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcServlet
 */
@WebServlet("/calc")
public class CalcServlet extends HttpServlet {


	private static final float USD_RATE = 1100.91f;
	private static final float JPY_RATE = 10.62f;
	private static final float CNY_RATE = 168.56f;
	private static final float GBP_RATE = 1493.58f;
	private static final float EUR_RATE = 1343.59f;


	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메소드 실행");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("destroy 메소드 실행");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = response.getWriter();
		String command = request.getParameter("command");
		String won = request.getParameter("won");
		String operator = request.getParameter("operator");
		
		if(command != null && command.equals("calculate")) {
			String result = calculate(Float.parseFloat(won), operator);
			pw.print("<html><font size = 10>변환 결과는요 두구두구둗</font><br>");
			pw.print("<html><font size = 10>" + result + "</font><br>");
			pw.print("<a href='/pro6/calc'>환율계산기임둥</a>");
			return;
		}
		pw.print("<html><title>환율 계산기이시다</title>");
		pw.print("<font size = 5>환율 계산기임</font><br>");
		pw.print("<form name = 'frmCalc' method = 'get' action ='/pro06/calc' />");
		pw.print("원화 : <input type='text' name ='won' size =10 />" );
		pw.print("<select name= 'operator'>");
		pw.print("<option value ='dollor'>미국돈</option>");
		pw.print("<option value ='en'>일본돈</option>");
		pw.print("<option value ='wian'>중국돈</option>");
		pw.print("<option value ='pound'>영국돈</option>");
		pw.print("<option value ='euro'>유럽돈</option>");
		pw.print("</select>");
		pw.print("<input type ='hidden' name = 'command' value='calculate' />");
		pw.println("<input type = 'submit' value='변환' />");
		pw.println("</form>");
		pw.print("</html>");
		pw.close();
		
		
	}
	private static String calculate(float won, String operator) {
		String result = null;
		if(operator.equals("dollor")) {
			result = String.format("%.6f달러", won / USD_RATE);
		} else if(operator.equals("en")) {
			result = String.format("%.6f엔", won / JPY_RATE);		
		} else if(operator.equals("wian")) {
			result = String.format("%.6f위안", won / CNY_RATE);
		} else if(operator.equals("pound")) {
			result = String.format("%.6f파운드", won / GBP_RATE);
		} else if(operator.equals("euro")) {
			result = String.format("%.6f유로", won / EUR_RATE);
		} 
		return result;
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
