package com.insurance.Dto;

public class InsuranceResponseDto {
	private int insuranceId;
	private String insuranceName;
	private String insuranceDesc;
	private String insuranceTenure;
	private Long insuranceSumAssured;
	private Long insuranceEmiMonthly;
	private Long insuranceEmiYearly;
	private Long insuranceBenfitAmount;
	private Long insuranceAccount;

	public int getInsuranceId() {
		return insuranceId;
	}

	public String getInsuranceName() {
		return insuranceName;
	}

	public String getInsuranceDesc() {
		return insuranceDesc;
	}

	public String getInsuranceTenure() {
		return insuranceTenure;
	}

	public Long getInsuranceSumAssured() {
		return insuranceSumAssured;
	}

	public Long getInsuranceEmiMonthly() {
		return insuranceEmiMonthly;
	}

	public Long getInsuranceEmiYearly() {
		return insuranceEmiYearly;
	}

	public Long getInsuranceBenfitAmount() {
		return insuranceBenfitAmount;
	}

	public Long getInsuranceAccount() {
		return insuranceAccount;
	}

	public void setInsuranceId(int insuranceId) {
		this.insuranceId = insuranceId;
	}

	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}

	public void setInsuranceDesc(String insuranceDesc) {
		this.insuranceDesc = insuranceDesc;
	}

	public void setInsuranceTenure(String insuranceTenure) {
		this.insuranceTenure = insuranceTenure;
	}

	public void setInsuranceSumAssured(Long insuranceSumAssured) {
		this.insuranceSumAssured = insuranceSumAssured;
	}

	public void setInsuranceEmiMonthly(Long insuranceEmiMonthly) {
		this.insuranceEmiMonthly = insuranceEmiMonthly;
	}

	public void setInsuranceEmiYearly(Long insuranceEmiYearly) {
		this.insuranceEmiYearly = insuranceEmiYearly;
	}

	public void setInsuranceBenfitAmount(Long insuranceBenfitAmount) {
		this.insuranceBenfitAmount = insuranceBenfitAmount;
	}

	public void setInsuranceAccount(Long insuranceAccount) {
		this.insuranceAccount = insuranceAccount;
	}

}
