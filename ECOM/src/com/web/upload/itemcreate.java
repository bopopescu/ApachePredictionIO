package com.web.upload;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class itemcreate {
	public static void create_item(String Name,String Category) throws IOException{
		Process p;
		String fin = null;
		try {
			JSONObject obj  =new JSONObject();
			obj.put("event","$set");
			obj.put("entityType","item");
			obj.put("entityId",Name);
			JSONObject obj1 = new JSONObject();
			obj1.put("categories",Category);
			obj.put("properties", obj1);
			fin = obj.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String command[];
		command = new String[]{"curl", "http://localhost:7070/events.json?accessKey=Ym4y6Utt1XE91ZABcVQBsBaZJgZoqX6a5p7JF9-3N6r_yKgvpbc_NQN4_BnXZgZH",
		         "-H", "Content-Type: application/json", "-d",fin
		         };
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
		
	}

	public static void main(String args[]) throws IOException{
	      HashMap<String, String> hmap = new HashMap<String, String>();
		hmap.put("Mobile Phone1","mobile");
		hmap.put("Mobile Phone2","mobile");
		hmap.put("Mobile Phone3","mobile");
		hmap.put("Smart Phone","mobile");
		hmap.put("Wireless Phone","mobile");
		hmap.put("Speakers","audio");
		hmap.put("Headphone","audio");
		hmap.put("Audio Player","audio");
		hmap.put("Audio-speaker","audio");
		hmap.put("Laptop","computer");
		hmap.put("Notebook","computer");
		hmap.put("Kids Toy","computer");
		hmap.put("Refrigerator","household");
		hmap.put("LED Tv","household");
		hmap.put("Washing Machine","household");
		hmap.put("Grinder","kitchen");
		hmap.put("Water Purifier","kitchen");
		hmap.put("Coffee Maker","kitchen");
		hmap.put("Wireless Speaker","audio");
		hmap.put("Red Mobile","mobile");
		hmap.put("Golden Tablet","computer");
		hmap.put("Asus Tablet","computer");
		
	    Iterator it = hmap.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();		
	        create_item(pair.getKey().toString(),pair.getValue().toString());
	    }
	}

}
