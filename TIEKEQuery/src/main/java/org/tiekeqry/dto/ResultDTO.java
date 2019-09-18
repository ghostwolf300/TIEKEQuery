package org.tiekeqry.dto;

import java.util.List;

public class ResultDTO {
	
	private OrganizationDTO organization;
	private List<OrganizationEAddressDTO> eAddresses;
	
	public ResultDTO() {
		super();
	}
	
	public ResultDTO(OrganizationDTO organization,List<OrganizationEAddressDTO> eAddresses) {
		super();
		this.organization=organization;
		this.eAddresses=eAddresses;
	}

	public OrganizationDTO getOrganization() {
		return organization;
	}

	public void setOrganization(OrganizationDTO organization) {
		this.organization = organization;
	}

	public List<OrganizationEAddressDTO> geteAddresses() {
		return eAddresses;
	}

	public void seteAddresses(List<OrganizationEAddressDTO> eAddresses) {
		this.eAddresses = eAddresses;
	}
	
}
