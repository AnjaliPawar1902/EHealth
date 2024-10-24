package EHealth.project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class addcase
 */
public class addcase extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		Connection con=Dbconnection.connect();
		int pid=0;
		String pname=request.getParameter("pname");
		String page=request.getParameter("page");
		String pgender=request.getParameter("pgender");
		String paddress=request.getParameter("paddress");
		String pmobileNo=request.getParameter("pmobileNo");
		String symptoms1=request.getParameter("symptoms1");
		String symptoms2=request.getParameter("symptoms2");
		String symptoms3=request.getParameter("symptoms3");	
		System.out.println("registered1");
		
		PreparedStatement psmt7;
		try {
			psmt7 = con.prepareStatement("select * from dataset2 where Symptom_1=? and Symptom_2=? and Symptom_3=?");
		
		psmt7.setString(1, symptoms1);
		psmt7.setString(2, symptoms2);
		psmt7.setString(3, symptoms3);
		ResultSet rs = psmt7.executeQuery();
		System.out.println("1");
		System.out.println("2");
		System.out.println("3");
			if(rs.next()){
					
		while (rs.next()) 			
		{  
			System.out.println("registered2");	
			
			String Dis=rs.getString("Disease");
			
			System.out.println("disease");
			
			PreparedStatement pst5=con.prepareStatement("select * from doctor where ddiestreat=? order by rand() limit 1");
		    pst5.setString(1, Dis);	    
		   ResultSet rs9 = pst5.executeQuery();
		   
		    while (rs9.next())
		    {	
		    	int did=rs9.getInt("did");
		    	System.out.println("registered3");
		    	String dise=rs9.getString("ddiestreat");
		    	System.out.println("completed1");	
			PreparedStatement psmt5=con.prepareStatement("insert into patient values(?,?,?,?,?,?,?,?,?,?)");
			psmt5.setInt(1,0);
			psmt5.setString(2,pname);
			psmt5.setString(3,page);
			psmt5.setString(4, pgender);
			psmt5.setString(5, paddress);
			psmt5.setString(6, pmobileNo);
			psmt5.setString(7, symptoms1);
			psmt5.setString(8, symptoms2);
			psmt5.setString(9, symptoms3);
			psmt5.setInt(10,did);
			int i=psmt5.executeUpdate();
			if(i>0)
			{			
			System.out.println("completed2");			
			response.sendRedirect("aoption.html");  
			}
			
		   }
		}
		}else
		{
			response.sendRedirect("not found.html");  	
		}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

	
}
}