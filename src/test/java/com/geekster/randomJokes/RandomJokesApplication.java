package com.geekster.randomJokes;



import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class RandomJokesApplication {

	public static void main(String[] args) throws Exception {

			// create URL object
			URL url = new URL("https://api.chucknorris.io/jokes/random");

			// create HttpURLConnection object
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
		int responseCode = conn.getResponseCode();

		if (responseCode == 200) {

			// read response from the API
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuilder response = new StringBuilder();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			// print the JSON response
			JSONObject json = new JSONObject(response.toString());
			System.out.println(json.toString());
//
		} else {
			System.out.println("This is not valid URL- " + responseCode);
		}
	}
}