package EHealth.project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class addaar
 */
public class addaar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addaar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		

		Connection con=Dbconnection.connect();
		String avname=request.getParameter("avname");
		String avmail=request.getParameter("avmail");
		String avpassword=request.getParameter("avpassword");
		String avmobileNo=request.getParameter("avmobileNo");
		String avvillage=request.getParameter("avvillage");
		String avdistrict=request.getParameter("avdistrict");
		
		try {
		
		PreparedStatement psmt1=con.prepareStatement("insert into aarogyavibhag values(?,?,?,?,?,?,?)");
		psmt1.setInt(1,0);
		psmt1.setString(2, avname);
		psmt1.setString(3, avmail);
		psmt1.setString(4, avpassword);
		psmt1.setString(5, avmobileNo);
		psmt1.setString(6, avvillage);
		psmt1.setString(7, avdistrict);
		System.out.println("yes");
		int i=psmt1.executeUpdate();
		if(i>0)
		{
				response.sendRedirect("check.html");
		}
		
		

		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}

}
