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
 * Servlet implementation class avlogin
 */
public class dlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dlogin() {
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
		String dmail=request.getParameter("dmail");
		String dpassword=request.getParameter("dpassword");
		
		
		try {

			PreparedStatement psmt6 = con.prepareStatement("select * from  doctor where dmail =? and dpassword =?");
			psmt6.setString(1, dmail);
			psmt6.setString(2, dpassword);
			ResultSet rs6 = psmt6.executeQuery();
			if (rs6.next()) 
			{
				UserData.setDid(rs6.getInt(1));
				System.out.println("login successful");
				response.sendRedirect("viewpatient.jsp");
			}
		   
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}


