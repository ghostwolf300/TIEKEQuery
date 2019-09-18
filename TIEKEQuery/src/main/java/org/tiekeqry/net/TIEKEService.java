package org.tiekeqry.net;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.tiekeqry.dto.CompanyDTO;
import org.tiekeqry.dto.EAddressDTO;
import org.tiekeqry.dto.OrganizationDTO;
import org.tiekeqry.dto.OrganizationEAddressDTO;
import org.tiekeqry.dto.ResultDTO;

public class TIEKEService implements TIEKEConnector {
	
	//public static final String SEARCH_ADDRESS="https://verkkolaskuosoite.fi/client/index.html#";
	public static final String SEARCH_ADDRESS="https://verkkolaskuosoite.fi/server/Public/organizations";
	public static final String GET_DETAILS="https://verkkolaskuosoite.fi/server/Public/organizations/";
	public static final String SEARCH_TEXT="searchText";
	
	public TIEKEService() {
		
	}
	
	public List<ResultDTO> fetchTIEKEData(List<String> ytjIds) {
		//Helsingin kaupunki : 0201256-6
		//Konehuolto Kaitanen : 2247743-2
		CompanyDTO company=fetchCompanyData("0201256-6");
		System.out.println(company.toString());
		ResultDTO result=getResult(company.getId());
		System.out.println(result.getOrganization().getName());
		for(OrganizationEAddressDTO eAddress : result.geteAddresses()) {
			System.out.println(eAddress.getIdentifier());
		}
		return null;
	}
	
	private CompanyDTO fetchCompanyData(String ytjId) {
		CompanyDTO company=null;
		HttpURLConnection connection=null;
		String param="?searchText="+ytjId;
		StringBuffer response=null;
		JSONArray jsonArray=null;
		JSONObject jsonCompany=null;
		int responseCode=-1;
		try {
			URL url=new URL(SEARCH_ADDRESS+param);
			connection=(HttpURLConnection)url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/json");
			responseCode=connection.getResponseCode();
			//Get response
			if(responseCode==HttpURLConnection.HTTP_OK) {
				InputStream is=connection.getInputStream();
				BufferedReader rd=new BufferedReader(new InputStreamReader(is));
				response=new StringBuffer();
				String line;
				while((line=rd.readLine())!=null) {
					//System.out.println(line);
					response.append(line);
					response.append('\r');
				}
				rd.close();
				JSONParser parser=new JSONParser();
				jsonArray=(JSONArray) parser.parse(response.toString());
			
			}
		} 	
		catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(connection!=null) {
				connection.disconnect();
			}
		}
		
		if(jsonArray!=null) {
			System.out.println("Company count: "+jsonArray.size());
			jsonCompany=(JSONObject) jsonArray.get(0);
			company=createCompanyDTO(jsonCompany);
		}
		
		return company;
	}
	
	private CompanyDTO createCompanyDTO(JSONObject json) {
		CompanyDTO company=new CompanyDTO();
		company.setId((Long)json.get("id"));
		company.setName((String) json.get("name"));
		company.setWebAddress((String)json.get("www"));
		company.setCity((String) json.get("city"));
		company.setCountry((String) json.get("country"));
		company.setPostalCode((String) json.get("postalCode"));
		
		//JSONArray jsonStreetAddresses=(JSONArray) json.get("street");
		JSONArray jsonEAddresses=(JSONArray) json.get("eaddress");
		
		List<EAddressDTO> eAddresses=new ArrayList<EAddressDTO>();
		for(Object o: jsonEAddresses) {
			JSONObject jsonEAddress=(JSONObject) o;
			EAddressDTO eAddress=createEAddressDTO(jsonEAddress);
			eAddresses.add(eAddress);
		}
		company.seteAddresses(eAddresses);
		
		//JSONArray jsonContacts=(JSONArray) json.get("contact");
		//System.out.println("Contacts count: "+jsonContacts.size());
		JSONArray jsonIdentifiers=(JSONArray) (json.get("identifier"));
		company.setIdentifier((String) jsonIdentifiers.get(0));
		
		return company;
	}
	
	private EAddressDTO createEAddressDTO(JSONObject json) {
		EAddressDTO eAddress=new EAddressDTO();
		eAddress.setName((String) json.get("name"));
		eAddress.setIdentifier((String) ((JSONArray)json.get("identifier")).get(0));
		return eAddress;
	}
	
	private ResultDTO getResult(long id) {
		HttpURLConnection connection=null;
		String param=Long.toString(id);
		StringBuffer response=null;
		JSONObject jsonResult=null;
		ResultDTO result=null;
		int responseCode=-1;
		
		try {
			URL url=new URL(GET_DETAILS+param);
			connection=(HttpURLConnection)url.openConnection();
			connection.setRequestMethod("GET");
			
			responseCode=connection.getResponseCode();
			//Get response
			if(responseCode==HttpURLConnection.HTTP_OK) {
				InputStream is=connection.getInputStream();
				BufferedReader rd=new BufferedReader(new InputStreamReader(is));
				response=new StringBuffer();
				String line;
				while((line=rd.readLine())!=null) {
					//System.out.println(line);
					response.append(line);
					response.append('\r');
				}
				rd.close();
				System.out.println(response.toString());
				JSONParser parser=new JSONParser();
				jsonResult=(JSONObject) parser.parse(response.toString());
			}
			
		} 
		catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(connection!=null) {
				connection.disconnect();
			}
		}
		
		if(jsonResult!=null) {
			result=createResultDTO(jsonResult);
		}
		
		
		return result;
	}
	
	private ResultDTO createResultDTO(JSONObject json) {
		ResultDTO result=new ResultDTO();
		JSONObject jsonOrganization=(JSONObject) json.get("organization");
		result.setOrganization(createOrganizationDTO(jsonOrganization));
		JSONArray jsonEAddresses=(JSONArray) json.get("organizationEaddress");
		List<OrganizationEAddressDTO> eAddresses=new ArrayList<OrganizationEAddressDTO>();
		
		for(Object o : jsonEAddresses) {
			JSONObject jsonEAddress=(JSONObject) o;
			eAddresses.add(createOrganizationEAddressDTO(jsonEAddress));
		}
		result.seteAddresses(eAddresses);
		return result;
	}
	
	private OrganizationDTO createOrganizationDTO(JSONObject json) {

		
		OrganizationDTO organization=new OrganizationDTO();
		organization.setName((String) json.get("name"));
		organization.setId((Long) json.get("id"));
		organization.setCountry((String) json.get("country"));
		organization.setIdentifier((String) ((JSONArray)json.get("identifier")).get(0));
		
		organization.setCreateTime((String)json.get("createTime"));
		organization.setDeleteTime((String)json.get("deleteTime"));
		
		organization.setPostalCode((String) json.get("postalCode"));
		organization.setCountry((String) json.get("countryCode"));
		organization.setWww((String) json.get("www"));
		return organization;
	}
	
	private OrganizationEAddressDTO createOrganizationEAddressDTO(JSONObject json) {
		OrganizationEAddressDTO eAddress=new OrganizationEAddressDTO();
		eAddress.setName((String) json.get("name"));
		eAddress.setId((Long) json.get("id"));
		eAddress.setComment((String) json.get("comment"));
		eAddress.setIdentifier((String) ((JSONArray)json.get("identifier")).get(0));
		eAddress.setToken((String) json.get("token"));
		eAddress.setReference((String) json.get("reference"));
		eAddress.setCreateTime((String)json.get("createTime"));
		eAddress.setDeleteTime((String)json.get("deleteTime"));
		eAddress.setUrl((String) json.get("url"));
		eAddress.setServiceId((String) json.get("serviceId"));
		eAddress.setServiceIdType((String) json.get("serviceIdType"));
		eAddress.setAddressOwnerServiceId((String) json.get("addressOwnerServiceId"));
		eAddress.setAddressOwnerServiceIdType((String) json.get("addressOwnerServiceIdType"));
		eAddress.setContextOfAddress((String) json.get("contextOfAddress"));
		eAddress.setDirectionOfAddress((String) json.get("directionOfAddress"));
		eAddress.setPermissionToSend((Boolean) json.get("permissionToSend"));
		eAddress.setOwnerActive((Boolean) json.get("ownerActive"));
		eAddress.setOrganizationId((Long) json.get("organizationId"));
		eAddress.setPermissionToPublish((Boolean) json.get("permissionToPublish"));
		eAddress.setSupportAttachments((Boolean) json.get("supportAttachments"));
		eAddress.setSpecialRequirements((Boolean) json.get("specialRequirements"));
		eAddress.setPrimaryAddress((Boolean) json.get("primaryAddress"));
		
		return eAddress;
	}
	

}
