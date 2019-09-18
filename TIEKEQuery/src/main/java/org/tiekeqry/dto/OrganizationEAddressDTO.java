package org.tiekeqry.dto;

import java.sql.Timestamp;

public class OrganizationEAddressDTO {
	private String name;
	private long id;
	private String comment;
	private String identifier;
	private String token;
	private String reference;
	private String createTime;
	private String deleteTime;
	private String url;
	private String serviceId;
	private String serviceIdType;
	private String addressOwnerServiceId;
	private String addressOwnerServiceIdType;
	private String contextOfAddress;
	private String directionOfAddress;
	private Boolean permissionToSend;
	private Boolean ownerActive;
	private long organizationId;
	private Boolean organizationActive;
	private Boolean permissionToPublish;
	private Boolean supportAttachments;
	private Boolean specialRequirements;
	private Boolean primaryAddress;
	
	public OrganizationEAddressDTO() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(String deleteTime) {
		this.deleteTime = deleteTime;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceIdType() {
		return serviceIdType;
	}

	public void setServiceIdType(String serviceIdType) {
		this.serviceIdType = serviceIdType;
	}

	public String getAddressOwnerServiceId() {
		return addressOwnerServiceId;
	}

	public void setAddressOwnerServiceId(String addressOwnerServiceId) {
		this.addressOwnerServiceId = addressOwnerServiceId;
	}

	public String getAddressOwnerServiceIdType() {
		return addressOwnerServiceIdType;
	}

	public void setAddressOwnerServiceIdType(String addressOwnerServiceIdType) {
		this.addressOwnerServiceIdType = addressOwnerServiceIdType;
	}

	public String getContextOfAddress() {
		return contextOfAddress;
	}

	public void setContextOfAddress(String contextOfAddress) {
		this.contextOfAddress = contextOfAddress;
	}

	public String getDirectionOfAddress() {
		return directionOfAddress;
	}

	public void setDirectionOfAddress(String directionOfAddress) {
		this.directionOfAddress = directionOfAddress;
	}

	public boolean isPermissionToSend() {
		return permissionToSend;
	}

	public void setPermissionToSend(boolean permissionToSend) {
		this.permissionToSend = permissionToSend;
	}

	public Boolean getOwnerActive() {
		return ownerActive;
	}

	public void setOwnerActive(Boolean ownerActive) {
		this.ownerActive = ownerActive;
	}

	public long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(long organizationId) {
		this.organizationId = organizationId;
	}

	public Boolean getOrganizationActive() {
		return organizationActive;
	}

	public void setOrganizationActive(Boolean organizationActive) {
		this.organizationActive = organizationActive;
	}

	public Boolean isPermissionToPublish() {
		return permissionToPublish;
	}

	public void setPermissionToPublish(Boolean permissionToPublish) {
		this.permissionToPublish = permissionToPublish;
	}

	public Boolean isSupportAttachments() {
		return supportAttachments;
	}

	public void setSupportAttachments(Boolean supportAttachments) {
		this.supportAttachments = supportAttachments;
	}

	public Boolean isSpecialRequirements() {
		return specialRequirements;
	}

	public void setSpecialRequirements(Boolean specialRequirements) {
		this.specialRequirements = specialRequirements;
	}

	public Boolean isPrimaryAddress() {
		return primaryAddress;
	}

	public void setPrimaryAddress(Boolean primaryAddress) {
		this.primaryAddress = primaryAddress;
	}
	
	
	
	
}
