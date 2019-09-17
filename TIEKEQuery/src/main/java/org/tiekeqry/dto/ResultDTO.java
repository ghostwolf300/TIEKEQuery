package org.tiekeqry.dto;

public class ResultDTO {
	
	private String ytjId;
	private String companyName;
	private String eBillAddress;
	private String operatorId;
	private boolean primaryAddress;
	
	public ResultDTO() {
		super();
	}
	
	public ResultDTO(String ytjId,String companyName,String eBillAddress,String operatorId,boolean primaryAddress) {
		this.ytjId=ytjId;
		this.companyName=companyName;
		this.eBillAddress=eBillAddress;
		this.operatorId=operatorId;
		this.primaryAddress=primaryAddress;
	}
	
	public String getYtjId() {
		return ytjId;
	}
	public void setYtjId(String ytjId) {
		this.ytjId = ytjId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String geteBillAddress() {
		return eBillAddress;
	}
	public void seteBillAddress(String eBillAddress) {
		this.eBillAddress = eBillAddress;
	}
	public String getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}
	public boolean isPrimaryAddress() {
		return primaryAddress;
	}
	public void setPrimaryAddress(boolean primaryAddress) {
		this.primaryAddress = primaryAddress;
	}
	
	
}
