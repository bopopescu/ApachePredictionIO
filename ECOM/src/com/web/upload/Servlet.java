package com.web.upload;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

 
/**
 * A Java servlet that handles file upload from client.
 * @author www.codejava.net
 */
public class Servlet extends HttpServlet {
    /**
     * handles file upload via HTTP POST method
     */
	String Name; 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	String[] command ;
    	Process p;
        Enumeration paramNames = request.getParameterNames();
        System.out.println("In to the servlet");
        
/*        while(paramNames.hasMoreElements()) {
           String paramName = (String)paramNames.nextElement();
//           String[] paramValues = request.getParameterValues(paramName);
           System.out.println(paramName);
        }*/
  			
           String method = request.getParameter("method");
           PrintWriter out = new PrintWriter(response.getWriter());
//		System.out.println(method);
   
      		if(method != null){
       			if(method.compareTo("usersignup")==0){
            String fin = null ;
			String Password=request.getParameter("Password");  			
			Name = request.getParameter("Name");
    			
    			if(Password.compareTo("123")==0){
        			System.out.println(Name);
    				
//    			System.out.println(Name);
    			HttpSession session=request.getSession(true);  
    	        session.setAttribute("user",Name);  
    	        
    			try {
    				JSONObject obj  =new JSONObject();
    				obj.put("event","$set");
    				obj.put("entityType","user");
    				obj.put("entityId",Name);
    				fin = obj.toString();
    			} catch (Exception e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    			//System.out.println(fin);
    	    	command = new String[]{"curl", "http://localhost:7070/events.json?accessKey=jBhRupZa7FK0fKGproNFMiraoa0tx3dYPwnwJavnQdG3quysEhECG1hjIss0cgMk",
    	    	         "-H", "Content-Type: application/json", "-d",fin
    	    	         };

    /*	    	command = new String[]{"curl", "http://localhost:8000/queries.json",
    	    	         "-H", "Content-Type: application/json", "-d",
    	    	         "{ \"user\": \"u1\", \"num\": 4 }"};*/
    	    	
    /*	    	for(int i=0;i<command.length;i++) 
    	    	System.out.print(command[i]);*/
    	      	 p = Runtime.getRuntime().exec(command);
    	       	 BufferedReader stdInput = new BufferedReader(new 
    	                 InputStreamReader(p.getInputStream()));

    	            BufferedReader stdError = new BufferedReader(new 
    	                 InputStreamReader(p.getErrorStream()));

    	            // read the output from the command
    	            System.out.println("Here is the standard output of the command:\n");
    	            String s = null,S = "";
    	           while ((s = stdInput.readLine()) != null) {
    	                System.out.println(s);
    	                S+=s;
    	            }
    /*	             System.out.println("Here is the standard error of the command (if any):\n");
    	            while ((s = stdError.readLine()) != null) {
    	                System.out.println(s);
    	            }*/
//    	            out.println(Name);
//    	            out.flush();
//    	  		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
//    	         rd.forward(request, response);
    	         response.sendRedirect("login.jsp");
    	         return;
    	            }
    			else{
    				Name = null;
    				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
    				System.out.println("Either user name or password is wrong");
    				out.println("<font color=red>Either user name or password is wrong.</font>");
    				rd.include(request, response);    				
    			}
       		}
      }
           
//			response.setContentType("text/html");
//			response.setStatus(response.SC_MOVED_TEMPORARILY);
//			response.setHeader("Location", "https://google.com");
//  		RequestDispatcher rd = request.getRequestDispatcher("/Products");
//        rd.forward(request, response);
//        response.sendRedirect(request.getContextPath()+"/WebContent/login.jsp");
//      		System.out.println(request.getContextPath());
	}		
    
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    	String[] command ;
    	Process p;
        Enumeration paramNames = request.getParameterNames();
        
        while(paramNames.hasMoreElements()) {
           String paramName = (String)paramNames.nextElement();
//           String[] paramValues = request.getParameterValues(paramName);
           System.out.println(paramName);
        }
  			
//           String method = request.getParameter("method");
//		System.out.println(method);
        PrintWriter out = new PrintWriter(response.getWriter());
        String fin = null ;
			String Name = request.getParameter("Name");
//			System.out.println(Name);
			try {
				JSONObject obj  =new JSONObject();
				obj.put("event","$set");
				obj.put("entityType","user");
				obj.put("entityId",Name);
				fin = obj.toString();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(fin);
	    	command = new String[]{"curl", "http://localhost:7070/events.json?accessKey=Ym4y6Utt1XE91ZABcVQBsBaZJgZoqX6a5p7JF9-3N6r_yKgvpbc_NQN4_BnXZgZH",
	    	         "-H", "Content-Type: application/json", "-d",fin
	    	         };

/*	    	command = new String[]{"curl", "http://localhost:8000/queries.json",
	    	         "-H", "Content-Type: application/json", "-d",
	    	         "{ \"user\": \"u1\", \"num\": 4 }"};*/
	    	
/*	    	for(int i=0;i<command.length;i++) 
	    	System.out.print(command[i]);*/
	      	 p = Runtime.getRuntime().exec(command);
	       	 BufferedReader stdInput = new BufferedReader(new 
	                 InputStreamReader(p.getInputStream()));

	            BufferedReader stdError = new BufferedReader(new 
	                 InputStreamReader(p.getErrorStream()));

	            // read the output from the command
	            System.out.println("Here is the standard output of the command:\n");
	            String s = null,S = "";
	           while ((s = stdInput.readLine()) != null) {
	                System.out.println(s);
	                S+=s;
	            }
/*	             System.out.println("Here is the standard error of the command (if any):\n");
	            while ((s = stdError.readLine()) != null) {
	                System.out.println(s);
	            }*/
	            out.println(S);
	            out.flush();
	            return;
    }
/*
//    	doGet(request,response);

    	
//    	Process p = Runtime.getRuntime().exec("python /home/giri/WebService/ECOM/abc.py");

        
/*        URL obj = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
     
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);
     
        conn.setRequestMethod("PUT");
     
        OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
        out.write(data);
        out.close();
     
        InputStreamReader in = new InputStreamReader(conn.getInputStream());  
     
    	
    	command = new String[]{"curl", "http://localhost:8000/queries.json",
    	         "-H", "Content-Type: application/json", "-d",
    	         "{ \"user\": \"u1\", \"num\": 4 }"};
    	
   	 p = Runtime.getRuntime().exec(command);
   	 BufferedReader stdInput = new BufferedReader(new 
                InputStreamReader(p.getInputStream()));

           BufferedReader stdError = new BufferedReader(new 
                InputStreamReader(p.getErrorStream()));

           // read the output from the command
           System.out.println("Here is the standard output of the command:\n");
           String s = null,S = "";
          while ((s = stdInput.readLine()) != null) {
               System.out.println(s);
               S+=s;
           }
/*            System.out.println("Here is the standard error of the command (if any):\n");
           while ((s = stdError.readLine()) != null) {
               System.out.println(s);
           }
           out.println(S);
           out.flush();
           return;
    }*/

}


