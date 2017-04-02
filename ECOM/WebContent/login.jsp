<%@ page import ="java.sql.*" %>
<%
	if(session!=null){
	if(session.getAttribute("user")!=null)	{
    String user = (String) session.getAttribute("user");    
//    out.println("hello there ");
    System.out.println("hello, Welcome there "+user);

    /*    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbname",
            "root", "dbpass");
    Statement st = con.createStatement();
    //ResultSet rs;
    int i = st.executeUpdate("insert into members(first_name, last_name, email, uname, pass, regdate) values ('" + fname + "','" + lname + "','" + email + "','" + user + "','" + pwd + "', CURDATE())");
    if (i > 0) {*/
        //session.setAttribute("userid", user);
//    	response.sendRedirect("products.jsp");
//    	  		RequestDispatcher rd = request.getRequestDispatcher("products.jsp");
//    	         rd.forward(request, response);
  } 

    } else {
        response.sendRedirect("index.jsp");
    }
	
%>