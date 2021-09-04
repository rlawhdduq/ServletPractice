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
		System.out.println("init �޼ҵ� ����");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("destroy �޼ҵ� ����");
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
			pw.print("<html><font size = 10>��ȯ ����¿� �α��α��P</font><br>");
			pw.print("<html><font size = 10>" + result + "</font><br>");
			pw.print("<a href='/pro6/calc'>ȯ�������ӵ�</a>");
			return;
		}
		pw.print("<html><title>ȯ�� �����̽ô�</title>");
		pw.print("<font size = 5>ȯ�� ������</font><br>");
		pw.print("<form name = 'frmCalc' method = 'get' action ='/pro06/calc' />");
		pw.print("��ȭ : <input type='text' name ='won' size =10 />" );
		pw.print("<select name= 'operator'>");
		pw.print("<option value ='dollor'>�̱���</option>");
		pw.print("<option value ='en'>�Ϻ���</option>");
		pw.print("<option value ='wian'>�߱���</option>");
		pw.print("<option value ='pound'>������</option>");
		pw.print("<option value ='euro'>������</option>");
		pw.print("</select>");
		pw.print("<input type ='hidden' name = 'command' value='calculate' />");
		pw.println("<input type = 'submit' value='��ȯ' />");
		pw.println("</form>");
		pw.print("</html>");
		pw.close();
		
		
	}
	private static String calculate(float won, String operator) {
		String result = null;
		if(operator.equals("dollor")) {
			result = String.format("%.6f�޷�", won / USD_RATE);
		} else if(operator.equals("en")) {
			result = String.format("%.6f��", won / JPY_RATE);		
		} else if(operator.equals("wian")) {
			result = String.format("%.6f����", won / CNY_RATE);
		} else if(operator.equals("pound")) {
			result = String.format("%.6f�Ŀ��", won / GBP_RATE);
		} else if(operator.equals("euro")) {
			result = String.format("%.6f����", won / EUR_RATE);
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
