package com.insurance.Dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class UserInsuranceOptRequestDto {

	@NotNull(message = "please provide account number")
	@Min(value = 0, message = "please provide valid account number")
	@Digits(fraction = 0, integer = 14, message = "account number should be lessthan 4 digits")
	private Long fromAccount;

	@NotNull(message = "please provide valid user Id")
	@Min(value = 0, message = "please provide Valid User Id")
	private int userId;
	private List<InsuranceRequestDto> policyDetails = new ArrayList();

	public Long getFromAccount() {
		return fromAccount;
	}

	public int getUserId() {
		return userId;
	}

	public List<InsuranceRequestDto> getPolicyDetails() {
		return policyDetails;
	}

	public void setFromAccount(Long fromAccount) {
		this.fromAccount = fromAccount;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setPolicyDetails(List<InsuranceRequestDto> policyDetails) {
		this.policyDetails = policyDetails;
	}

}
