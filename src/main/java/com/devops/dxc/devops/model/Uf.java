package com.devops.dxc.devops.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.stream.Collectors;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Uf {

    /**
     * Método que retorna el valor de la UF.  Este método debe ser refactorizado por una integración a un servicio
     * que retorne la UF en tiempo real.  Por ejemplo mindicador.cl
     * @return
     */
    public static int getUf(){
        JSONObject response = null;
    	int ufValue = 31000;
    	try {	
    		JSONParser parser = new JSONParser();
    		JSONArray jsonArray = new JSONArray(); 
    		
    		Date date = Calendar.getInstance().getTime();
    		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            String today = formatter.format(date);
			URL url = new URL("https://mindicador.cl/api/uf/"+today);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("accept", "application/json");
			InputStream responseStream = connection.getInputStream();
			
			String responseString = new BufferedReader(
				      new InputStreamReader(responseStream, StandardCharsets.UTF_8))
				        .lines()
				        .collect(Collectors.joining("\n"));
			
			response = (JSONObject) parser.parse(responseString);
			jsonArray = (JSONArray) response.get("serie");
			response = (JSONObject) jsonArray.get(0);
			double uf = (Double) response.get("valor");
			ufValue = (int)uf;
			
			System.out.println(response.get("valor"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	return ufValue;
    }
    
}
