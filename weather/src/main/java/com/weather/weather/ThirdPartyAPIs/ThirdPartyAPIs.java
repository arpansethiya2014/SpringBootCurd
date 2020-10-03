package com.weather.weather.ThirdPartyAPIs;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
public class ThirdPartyAPIs {

	
	public static String getData() throws Exception {
		
		String urlString = "http://api.openweathermap.org/data/2.5/weather?q=ujjain&appid=0910675fd7f2519ba199a5f9847abe35";
		URL url = new URL(urlString);
		String finalResponse = null;
		String responseFinal = null;
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.setRequestMethod("GET");
		int responseCode = connection.getResponseCode();
		if(responseCode == 200 || responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuffer response = new StringBuffer();
			while ((finalResponse = in.readLine()) != null) {
				response.append(finalResponse);
			}
			in.close();
			System.out.println("Response : " + response.toString());
			responseFinal = response.toString();
		}else {
			responseFinal = "Response Not Found";
		}
		return responseFinal;
	}
	
	public static void main(String[] args) throws Exception{
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "Arpan");
		jsonObject.put("mobile", "7869920537");
		jsonObject.put("email", "arpan@gmail.com");
		jsonObject.put("address", "Indore");
		System.out.println(jsonObject);
		
	}
}
