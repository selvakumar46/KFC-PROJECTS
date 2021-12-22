package com.model;

import java.util.Objects;

public class Admin {
	private String adminName;
	private String mailId;
	private long mobileNumber;
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(String adminName, String mailId, long mobileNumber) {
		super();
		this.adminName = adminName;
		this.mailId = mailId;
		this.mobileNumber = mobileNumber;
	}
	@Override
	public String toString() {
		return "Admin [adminName=" + adminName + ", mailId=" + mailId + ", mobileNumber=" + mobileNumber + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(adminName, mailId, mobileNumber);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		return Objects.equals(adminName, other.adminName) && Objects.equals(mailId, other.mailId)
				&& mobileNumber == other.mobileNumber;
	}

	
}