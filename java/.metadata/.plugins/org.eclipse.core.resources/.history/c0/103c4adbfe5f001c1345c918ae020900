package com.kfc;

import java.util.Objects;

public class Admin {
	private String mailId;
	private String password;
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
	public Admin(String mailId, String password) {
		super();
		this.mailId = mailId;
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [mailId=" + mailId + ", password=" + password + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(mailId, password);
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
		return Objects.equals(mailId, other.mailId) && Objects.equals(password, other.password);
	}
	
	
}
