 <%@ page import ="java.sql.*" %>
 <%@ page import ="EHealth.project.*" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
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
  <form action ="addcase"  method ="post">
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
                              
              </form>
            </ul>
          </div>
        </nav>
      </div>
    </header>
<%
Connection con=Dbconnection.connect();
PreparedStatement pstmt=con.prepareStatement("select * from patient where did=?");
pstmt.setInt(1,UserData.getDid());
ResultSet rs=pstmt.executeQuery();
%>
<TABLE BORDER="1">
<TR>
 <TH>pid</TH>
  <TH>pname</TH>
  <TH>page</TH>
  <TH>pgender</TH>
  <TH>paddress</TH>
  <TH>pmobileNo</TH>
  <TH>symptoms1</TH>
  <TH>symptoms2</TH>
  <TH>symptoms3</TH>
 
  
</TR>
<% while(rs.next()){ %>
<TR>
	<TD><%=rs.getInt(1) %></TD>
	<TD><%=rs.getString(2) %></TD>
	<TD><%=rs.getString(3) %></TD>
	<TD><%=rs.getString(4) %></TD>
	<TD><%=rs.getString(5) %></TD>
	<TD><%=rs.getString(6) %></TD>
	<TD><%=rs.getString(7) %></TD>
	<TD><%=rs.getString(8) %></TD>
	<TD><%=rs.getString(9) %></TD>
	  	<TD><a href="comment.jsp?pid=<%=rs.getInt(1)%>">Add Comment</a></TD>
	
    	<TD><a href="viewcomment2.jsp?pid=<%=rs.getInt(1)%>">view comment</a></TD>
	<TD><a href="addprescrip.jsp?pid=<%=rs.getInt(1)%>">Add Prescription</a></TD>
	
	
</TR>
<%} %>

</body>
</html>