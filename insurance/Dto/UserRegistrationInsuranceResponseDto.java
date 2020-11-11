package com.insurance.Dto;

public class UserRegistrationInsuranceResponseDto {
	private int userPolicyNumber;
	private int userId;
	private int selectedPolicyId;
	private String selectedPolicyName;
	private Long selectedPolicySumAssured;
	private String status;

	public int getUserPolicyNumber() {
		return userPolicyNumber;
	}

	public int getUserId() {
		return userId;
	}

	public int getSelectedPolicyId() {
		return selectedPolicyId;
	}

	public String getSelectedPolicyName() {
		return selectedPolicyName;
	}

	public Long getSelectedPolicySumAssured() {
		return selectedPolicySumAssured;
	}

	public String getStatus() {
		return status;
	}

	public void setUserPolicyNumber(int userPolicyNumber) {
		this.userPolicyNumber = userPolicyNumber;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setSelectedPolicyId(int selectedPolicyId) {
		this.selectedPolicyId = selectedPolicyId;
	}

	public void setSelectedPolicyName(String selectedPolicyName) {
		this.selectedPolicyName = selectedPolicyName;
	}

	public void setSelectedPolicySumAssured(Long selectedPolicySumAssured) {
		this.selectedPolicySumAssured = selectedPolicySumAssured;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
