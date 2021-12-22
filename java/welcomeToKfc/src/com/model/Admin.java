package com.model;

import java.util.Objects;

public class Admin {
	private String adminName;
	private String mailId;
	private String password;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Admin(String adminName, String mailId, String password) {
		super();
		this.adminName = adminName;
		this.mailId = mailId;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [adminName=" + adminName + ", mailId=" + mailId + ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(adminName, mailId, password);
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
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
				&& Objects.equals(password, other.password);
	}

}
