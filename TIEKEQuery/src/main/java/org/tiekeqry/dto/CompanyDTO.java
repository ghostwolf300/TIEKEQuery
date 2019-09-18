package org.tiekeqry.dto;

import java.util.List;

public class CompanyDTO {
	
	private long id;
	private String webAddress;
	private String city;
	private String name;
	private List<String> addresses;
	private List<String> contacts;
	private String country;
	private List<EAddressDTO> eAddresses;
	private String identifier;
	private String postalCode;
	
	public CompanyDTO() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getWebAddress() {
		return webAddress;
	}

	public void setWebAddress(String webAddress) {
		this.webAddress = webAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<String> addresses) {
		this.addresses = addresses;
	}

	public List<String> getContacts() {
		return contacts;
	}

	public void setContacts(List<String> contacts) {
		this.contacts = contacts;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<EAddressDTO> geteAddresses() {
		return eAddresses;
	}

	public void seteAddresses(List<EAddressDTO> eAddresses) {
		this.eAddresses = eAddresses;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@Override
	public String toString() {
		return "CompanyDTO [id=" + id + ", webAddress=" + webAddress + ", city=" + city + ", name=" + name
				+ ", country=" + country + ", identifier=" + identifier + ", postalCode=" + postalCode + "]";
	}
	
	
	
}
