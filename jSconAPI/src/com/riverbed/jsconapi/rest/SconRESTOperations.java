package com.riverbed.jsconapi.rest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Authenticator;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.net.ssl.HttpsURLConnection;

import org.apache.commons.io.IOUtils;
;

public class SconRESTOperations {
	
	 
	 static class MyAuthenticator extends Authenticator {
	        public PasswordAuthentication getPasswordAuthentication() {
	        	String kuser = System.getenv("username");
	        	String kpass = System.getenv("password");
	            return (new PasswordAuthentication(kuser, kpass.toCharArray()));
	        }
	    }
	 
	 /**
	  * 
	  * @param link
	  * @param json
	  * @return
	  * @throws IOException
	  */
	 public static final JsonObject PostData (String link, JsonObject json) throws IOException{
	    	URL url = null;
	    	System.out.println(json);
	    	HttpsURLConnection conn = null;
			Authenticator.setDefault(new MyAuthenticator());
			try {
			url = new URL(link);
			
				conn = (HttpsURLConnection) url.openConnection();
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Accept", "application/json");
				conn.setRequestProperty("Content-Type", "application/json");
				conn.setDoOutput(true);
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				//System.out.println("json "+json+"\n");
				System.out.println(e1.toString());
				
			}
			
			JsonWriter writer = Json.createWriter(conn.getOutputStream());
			writer.writeObject(json);
			writer.close();
			JsonObject returnJson = Json.createReader(conn.getInputStream()).readObject();
	    	conn.disconnect();
	    	return returnJson;
	    }
	 
	   /**
	    *  
	    * @param link
	    * @return
	    * @throws IOException
	    */
	 public static final JsonObject GetData(String link) throws IOException{
	    	JsonObject json = null;
	    	URL url = null;
	    	int status;
	    	HttpsURLConnection conn = null;
			Authenticator.setDefault(new MyAuthenticator());
			try {
			url = new URL(link);
			
				conn = (HttpsURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");
				status = conn.getResponseCode();
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				status = conn.getResponseCode();
				if (status==401) System.out.println("Authentication error");
				else System.out.println("HTTP Status code:"+status);
			}
			try {
			json = Json.createReader(conn.getInputStream()).readObject();
			} catch (FileNotFoundException fnfe) {
				//most likely status code = 400
				json = null;
			}
	    	conn.disconnect();
	    	return json;
	    }
	 
	 /**
	  * 
	  * @param link
	  * @return
	  * @throws IOException
	  */
	 static final JsonObject DeleteData(String link) throws IOException{
	    	JsonObject json = null;
	    	URL url = null;
	    	int status;
	    	HttpsURLConnection conn = null;
			Authenticator.setDefault(new MyAuthenticator());
			try {
			url = new URL(link);
			
				conn = (HttpsURLConnection) url.openConnection();
				conn.setRequestMethod("DELETE");
				conn.setRequestProperty("Content-Type", "application/json");
				conn.setDoOutput(true);
				status = conn.getResponseCode();
				
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				status = conn.getResponseCode();
				if (status==401) System.out.println("Authentication error");
				else System.out.println("HTTP Status code:"+status);
			}
			json = Json.createReader(conn.getInputStream()).readObject();
	    	conn.disconnect();
	    	return json;
	    }
	 
	 /**
	  * 
	  * @param link
	  * @param json
	  * @return
	  * @throws IOException
	  */
	 public static final JsonObject PutData (String link, JsonObject json) throws IOException{
	    	URL url = null;
	    	JsonObject returnJson = null;
	    	HttpsURLConnection conn = null;
			Authenticator.setDefault(new MyAuthenticator());
			try {
			url = new URL(link);
			
				conn = (HttpsURLConnection) url.openConnection();
				conn.setRequestMethod("PUT");
				//conn.setRequestProperty("Accept", "application/json");
				conn.setRequestProperty("Content-Type", "application/json");
				conn.setDoOutput(true);
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.toString());
			}
			
			//write!!!!!!!!!!
			if(json!=null) {
				JsonWriter writer = Json.createWriter(conn.getOutputStream());
				writer.writeObject(json);
				writer.close();
				returnJson = Json.createReader(conn.getInputStream()).readObject();
			}
			
			
	    	conn.disconnect();
	    	return returnJson;
	    }
	 
	 /**
	  * Downloads a file from SteelConnect Manager on a local directory. It can be a VM appliance image or support package
	  * @param link The link to download the file from. 
	  * @param parameters HTTP Parameters for the GET operation
	  * @param filepath filename + path where to save the file
	  * @return boolean true if the operation was successful
	  * @throws IOException
	  */
	 public static final boolean DownloadFile(String link,HashMap<String, String> parameters, String filepath) throws IOException{
		int buffer_size = 4096;
	    	URL url = null;
	    	int status;
	    	boolean first = true;
	    	
	    Iterator<String> iterator = parameters.keySet().iterator();
	    while(iterator.hasNext()) {
	           String key = iterator.next();
	           if(first) {
	        	   	link = link+"?";
	        	   	first = false;
	           }
	           else {
	        	   	link = link+"&";
	           }
	           link = link + key+"="+parameters.get(key);
	     }
	    	
	    	HttpsURLConnection conn = null;
		Authenticator.setDefault(new MyAuthenticator());
		try {
		url = new URL(link);
		
			conn = (HttpsURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/zip");
			status = conn.getResponseCode();
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			status = conn.getResponseCode();
			if (status==401) System.out.println("Authentication error");
			else System.out.println("HTTP Status code:"+status);
		}
		InputStream inputStream = conn.getInputStream();
         
        // opens an output stream to save into file
            FileOutputStream outputStream = new FileOutputStream(filepath);
 
            int bytesRead = -1;
            byte[] buffer = new byte[buffer_size];
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
 
            outputStream.close();
            inputStream.close();
            conn.disconnect();
            return true;
	    }
	 
	 /**
	  * 
	  * @param 
	  * @return String
	  * @param link
	  * @param parameters
	  * @return
	  * @throws IOException
	  */
	 public static final String DownloadEC2Data(String link,HashMap<String, String> parameters) throws IOException{
		    	URL url = null;
		    	int status;
		    	boolean first = true;
		    	String result = null;
		   
		    Iterator<String> iterator = parameters.keySet().iterator();
		    while(iterator.hasNext()) {
		           String key = iterator.next();
		           if(first) {
		        	   	link = link+"?";
		        	   	first = false;
		           }
		           else {
		        	   	link = link+"&";
		           }
		           link = link + key+"="+parameters.get(key);
		     }
		    	
		    	HttpsURLConnection conn = null;
			Authenticator.setDefault(new MyAuthenticator());
			try {
				url = new URL(link);
			
				conn = (HttpsURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/text");
				status = conn.getResponseCode();
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				status = conn.getResponseCode();
				if (status==401) System.out.println("Authentication error");
				else System.out.println("HTTP Status code:"+status);
			}
			InputStream inputStream = conn.getInputStream();
			result = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
	    
	        inputStream.close();
	        conn.disconnect();
	            
	        return result;
	  }
	 
	/**
	 * 
	 * @param 
	 * @return JsonError
	 * @param json
	 * @return
	 */
	 public static JsonError jsonErrorHandler (JsonObject json) {
		if(json==null) return null;
			
		JsonObject error = json.getJsonObject("error");
		JsonError errorToReturn = null;
		
		if(error!=null) {
			errorToReturn = new JsonError();
			errorToReturn.setCode(error.getInt("code"));
			errorToReturn.setMessage(error.getString("message"));
		}
			
		 return errorToReturn;
	 }
	    
}
