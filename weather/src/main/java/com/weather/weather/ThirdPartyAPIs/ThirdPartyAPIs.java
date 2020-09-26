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
		String response = getData();
		
		JSONParser jsonParser = new JSONParser();
		Object obj = jsonParser.parse(response);
		JSONObject jsonObject = (JSONObject) obj;
		String name = (String) jsonObject.get("name");
		long timezone = (long) jsonObject.get("timezone");
		JSONObject main = (JSONObject) jsonObject.get("main");
		double temp = (double) main.get("temp");
		double temp_min = (double) main.get("temp_min");
		double temp_max = (double) main.get("temp_max");
		JSONObject sys = (JSONObject) jsonObject.get("sys");
		String country = (String) sys.get("country");
		
		System.out.println("main : " + country);
		
	}
}
