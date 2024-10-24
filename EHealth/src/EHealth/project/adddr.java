package EHealth.project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class adddr
 */
public class adddr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adddr() {
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
		
		String dname=request.getParameter("dname");
		String dmail=request.getParameter("dmail");
		String dmobileNo=request.getParameter("dmobileNo");
		String dpassword=request.getParameter("dpassword");
		String dcity=request.getParameter("dcity");
		String dspecialization=request.getParameter("dspecialization");
		String ddiestreat=request.getParameter("ddiestreat");
		
		try {
		
		PreparedStatement psmt1=con.prepareStatement("insert into doctor values(?,?,?,?,?,?,?,?)");
		psmt1.setInt(1,0);
		psmt1.setString(2, dname);
		psmt1.setString(3, dmail);
		psmt1.setString(4, dmobileNo);
		psmt1.setString(5, dpassword);
		psmt1.setString(6, dcity);
		psmt1.setString(7, dspecialization);
		psmt1.setString(8, ddiestreat);

		
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

