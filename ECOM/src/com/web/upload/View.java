package com.web.upload;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public View() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fin = null;
	    HttpSession session = request.getSession(true);
	    String User = (String) session.getAttribute("user");
		String Name = request.getParameter("Name");
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			JSONObject obj  =new JSONObject();
			obj.put("event","view");
			obj.put("entityType","user");
			obj.put("entityId",User);
			obj.put( "targetEntityType","item");
			obj.put("targetEntityId",Name);
			fin = obj.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	String[] command = new String[]{"curl", "http://localhost:7070/events.json?accessKey=jBhRupZa7FK0fKGproNFMiraoa0tx3dYPwnwJavnQdG3quysEhECG1hjIss0cgMk",
   	         "-H", "Content-Type: application/json", "-d",fin
   	         };
     	 Process p = Runtime.getRuntime().exec(command);
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
           return;

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
