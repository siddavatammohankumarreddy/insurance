package com.insurance.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user_details")
public class UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int userId;
	private String userEmail;
	private String userFirstName;
	private String userLastName;
	private String userLoginName;
	private String userLoginPassword;
	private String userPhoneNo;
	private String userAddress;
	private String userAge;
	private String userGender;
	private String userDob;
	private String userPanNo;

	public int getUserId() {
		return userId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public String getUserLoginName() {
		return userLoginName;
	}

	public String getUserLoginPassword() {
		return userLoginPassword;
	}

	public String getUserPhoneNo() {
		return userPhoneNo;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public String getUserAge() {
		return userAge;
	}

	public String getUserGender() {
		return userGender;
	}

	public String getUserDob() {
		return userDob;
	}

	public String getUserPanNo() {
		return userPanNo;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public void setUserLoginName(String userLoginName) {
		this.userLoginName = userLoginName;
	}

	public void setUserLoginPassword(String userLoginPassword) {
		this.userLoginPassword = userLoginPassword;
	}

	public void setUserPhoneNo(String userPhoneNo) {
		this.userPhoneNo = userPhoneNo;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public void setUserDob(String userDob) {
		this.userDob = userDob;
	}

	public void setUserPanNo(String userPanNo) {
		this.userPanNo = userPanNo;
	}

}
