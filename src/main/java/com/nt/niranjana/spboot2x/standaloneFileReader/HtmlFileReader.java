package com.nt.niranjana.spboot2x.standaloneFileReader; 

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.URL;

public class HtmlFileReader {
   public static void main(String[] args) throws FileNotFoundException{
    //================================Using StrtingBuilder class: (No jar required)==========================================
      StringBuilder sb = new StringBuilder();
      FileReader fr = new FileReader("C:\\Users\\Sreenivas Bandaru\\Downloads\\Sisu\\Sample files\\htmlExample2.html");
      try {
    	  BufferedReader br = new BufferedReader(fr);
    	  String val;
    	  while((val=br.readLine())!=null)
    	  {
    		  sb.append(val);
    	  }
    	  br.close();
    	  String result = sb.toString();
    	  System.out.println("Xml content :"+result);
      }
      catch(Exception e)
      {
    	  System.out.println(e.getMessage());
      }
      System.out.println("......................................");
     //================Best approach: using URL class(No jar required)=======================================================================
   		// Try block to check exceptions
   		try {
   			String val;

   			// Constructing the URL connection
   			// by defining the URL constructors
   			URL URL = new URL("file:///C:\\Users\\Sreenivas Bandaru\\Downloads\\Sisu\\Sample files\\htmlExample2.html");

   			// Reading the HTML content from the .HTML File
   			BufferedReader br = new BufferedReader(new InputStreamReader(URL.openStream()));

   			/* Catching the string and if found any null character break the String */
   			while ((val = br.readLine()) != null) {
   				System.out.println(val);
   			}

   			// Closing the file
   			br.close();
   		}

   		// Catch block to handle exceptions
   		catch (Exception ex) {

   			// No file found
   			System.out.println(ex.getMessage());
   		}
   	}
}