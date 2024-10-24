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
 * Servlet implementation class prescription
 */
public class prescription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public prescription() {
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
	//	int pid=Integer.parseInt(request.getParameter("pid"));
		String image=request.getParameter("filename");
		try{
		Connection con=Dbconnection.connect();
		PreparedStatement pstmt;
		pstmt = con.prepareStatement ( "insert into prescription values(?,?)"); 
		
		pstmt.setInt(1,UserData.getPid());
		pstmt.setString(2,image);
		
		int i=pstmt.executeUpdate();
		if(i>0)
		{
			response.sendRedirect("viewpatient.jsp");
			}
		
		else{
			response.sendRedirect("addcase.jsp");
		}
		}
		catch (SQLException e){
			e.printStackTrace();
			doGet(request, response);
	}	doGet(request, response);
	}

}