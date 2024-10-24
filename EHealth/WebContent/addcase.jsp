<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import ="java.sql.*" %>
 <%@ page import ="EHealth.project.Dbconnection" %> 
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <!-- Basic -->
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <!-- Mobile Metas -->
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <!-- Site Metas -->
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta name="author" content="" />
  <link rel="shortcut icon" href="images/favicon.png" type="">

  <title> Dhanvita </title>

  <!-- bootstrap core css -->
  <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />

  <!-- fonts style -->
  <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700;900&display=swap" rel="stylesheet">

  <!--owl slider stylesheet -->
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />

  <!-- font awesome style -->
  <link href="css/font-awesome.min.css" rel="stylesheet" />

  <!-- Custom styles for this template -->
  <link href="css/style.css" rel="stylesheet" />
  <!-- responsive style -->
  <link href="css/responsive.css" rel="stylesheet" />

</head>

<body>
  <div class="hero_area">

    <div class="hero_bg_box">
      <img src="images/hero-bg.png" alt="">
    </div>

    <!-- header section strats -->
    <header class="header_section">
      <div class="container">
        <nav class="navbar navbar-expand-lg custom_nav-container ">
          <a class="navbar-brand" href="index.html">
            <span>
              Dhanvita
            </span>
          </a>
         

          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav">
              <li class="nav-item active">
                <a class="nav-link" href="index.html">Home <span class="sr-only">(current)</span></a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="doctors.html">Doctors</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="contact.html">Contact Us</a>
              </li>
               </button>  
            </ul>
          </div>
        </nav>
      </div>
    </header>   
    
    
    
    
    
   <section class="contact_section layout_padding">
   <center>
    <div class="container">
      <div class="heading_container">
        <h4><b>
Add Case </b>    </h4>
      </div>
      <div class="row">
        <div class="col-md-6">
          <div class="form_container contact-form">
          <form action ="addcase"  method ="post">
              <div class="form-row">
               
                <div class="col-lg-6">
                 
                </div>
              </div>
              <table>
              <div>
<input type="text"  placeholder="Enter name" name="pname">
              </div>
              <div>
<input type="text"  placeholder="Enter age" name="page">
              </div>
              <div>
<input type="text"  placeholder="enter gender" name="pgender">
              </div>
              <div>
<input type="text"  placeholder="Enter address" name="paddress">        
      </div>
              <div>
 <input type="text"  placeholder="Enter mobileNo" name="pmobileNo">             
              </div>            
           
          </div>
        </div>      
      </div>
    </div>
     </center>
 </section> 
    

<%  Connection con=Dbconnection.connect();
							PreparedStatement pstmt=con.prepareStatement("select * from dataset");
								ResultSet rs = pstmt.executeQuery();
								%>
							<tr><td><label><b>symptoms1</b></label>
       						 <select name="symptoms1">
       						 <option>symptoms1</option>
       						 <%  while(rs.next()){ %>
        					    <option><%= rs.getString(2)%></option>
       							 <% } %>
      						  </select><br></td></tr>
  					 	<% 
							PreparedStatement pstmt1=con.prepareStatement("select * from dataset");
								ResultSet rs1 = pstmt1.executeQuery();
								%>
								<tr><td><label><b>symptoms2</b></label>
       						  <select name="symptoms2">
       						 <option>symptoms2</option>
       						 <%  while(rs1.next()){ %>
        					    <option><%= rs1.getString(3)%></option>
       							 <% } %>
      						  </select><br></td></tr>
      						  
  					 	<% 
							PreparedStatement pstmt3=con.prepareStatement("select * from dataset");
								ResultSet rs2 = pstmt3.executeQuery();
								%>
								<tr><td><label><b>symptoms3</b></label>
       						 <select name="symptoms3">
       						 <option>symptoms3</option>
       						 <%  while(rs2.next()){ %>
        					    <option><%= rs2.getString(4)%></option>
       							 <% } %>
      						  </select><br></td></tr>
							
							<% 
							PreparedStatement pstmt4=con.prepareStatement("select * from dataset");
								ResultSet rs3 = pstmt4.executeQuery();
								%>
							<tr><td><label><b>symptoms4</b></label>
       						  <select name="symptoms4">
       						 <option>symptoms4</option>
       						 <%  while(rs3.next()){ %>
        					    <option><%= rs3.getString(5)%></option>
       							 <% } %>
      						  </select><br></td></tr>	
      				 	  			  
                  
                      <div class="btn_box">	
                      <tr><td><button type="submit">submit</button></td>                 
                    <tr><td><br> <button type="submit">
                      <a href="avoption.html">back</a></button>
                       </td></td></tr></tr>
                        </div>
                      
</table> 
</center>          						  
</form>					
</body>
</html>