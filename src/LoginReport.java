import java.sql.*;
import javax.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;



public class LoginReport extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	try{
		response.setContentType("report/html");
		PrintWriter out= response.getWriter();
	try{
		Class.forName("com.mysql.jdbc.Driver");
		String jdbcUrl="jdbc:mysql://localhost:3306/report";
		Connection con=null;
		
		con= DriverManager.getConnection("jdbcUrl,'root','root'");
		Statement st=con.createStatement();
		
		String z= request.getParameter("dept");
		String sql="select * from emp.emp where dept='"+z+"'";
		out.println("<h1>Employee Details</h1>");
		ResultSet rs= st.executeQuery(sql);
		out.println("<table border ='2'>");
		out.println("<tr>");
		out.println("<th>ENAME</th>");
		out.println("<th>DEPT</th>");
		out.println("</tr>");
		
		while(rs.next())
		{
			String ename=rs.getString("name");
			String dept=rs.getString("dept");
			out.println("<tr>");
			out.println("<td>"+ename+"</td>");
			out.println("<td>"+dept+"</td>");
			out.println("</tr>");
			
		}
		out.println("</table>");
		
		}
	catch(Exception e){
		out.println("class not found");
	}
	}
	catch(Exception SE){
		throw new RuntimeException("cannot connect to database", SE);
	}
}
	
}	
	
	
	
	
	
	
	
	