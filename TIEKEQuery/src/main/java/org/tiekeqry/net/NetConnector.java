package org.tiekeqry.net;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.tiekeqry.dto.ResultDTO;

public class NetConnector implements TIEKEConnector {
	
	//public static final String SEARCH_ADDRESS="https://verkkolaskuosoite.fi/client/index.html#";
	public static final String SEARCH_ADDRESS="https://verkkolaskuosoite.fi/server/Public/organizations";
	public static final String SEARCH_TEXT="searchText";
	
	public NetConnector() {
		
	}
	
	public List<ResultDTO> fetchTIEKEData(List<String> ytjIds) {
		HttpURLConnection connection=null;
		String testParam="?searchText=2247743-2";
		StringBuffer response=null;
		int responseCode=-1;
		try {
			URL url=new URL(SEARCH_ADDRESS+testParam);
			connection=(HttpURLConnection)url.openConnection();
			connection.setRequestMethod("GET");
			responseCode=connection.getResponseCode();
			//Get response
			InputStream is=connection.getInputStream();
			BufferedReader rd=new BufferedReader(new InputStreamReader(is));
			response=new StringBuffer();
			String line;
			while((line=rd.readLine())!=null) {
				response.append(line);
				response.append('\r');
			}
			rd.close();
		} 	
		catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(connection!=null) {
				connection.disconnect();
			}
		}
		
		System.out.print(response.toString());
		
		return null;
	}

}
