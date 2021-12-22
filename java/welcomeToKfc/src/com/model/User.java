package com.model;

import java.util.Objects;

public class User {
	private int userId;
	private String userName;
	private long mobileNumber;
	private String mailId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public User(int userId, String userName, long mobileNumber, String mailId) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.mobileNumber = mobileNumber;
		this.mailId = mailId;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "\n userName=" + userName + "\n mailId=" + mailId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(mailId, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(mailId, other.mailId) && Objects.equals(userName, other.userName);
	}

}
