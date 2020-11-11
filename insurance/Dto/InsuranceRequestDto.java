package com.insurance.Dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class InsuranceRequestDto {

	@NotNull(message = "Enter valid PolicyId")
	@Min(value = 0, message = "please Enter Valid PolicyId")
	@Max(value = 100, message = "please Enter Valid PolicyId")
	@NotBlank(message = "Policy Id can not be blank")
	private int policyId;
	private boolean monthlyEmi;
	private boolean yearlyEmi;

	public int getPolicyId() {
		return policyId;
	}

	public boolean isMonthlyEmi() {
		return monthlyEmi;
	}

	public boolean isYearlyEmi() {
		return yearlyEmi;
	}

	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}

	public void setMonthlyEmi(boolean monthlyEmi) {
		this.monthlyEmi = monthlyEmi;
	}

	public void setYearlyEmi(boolean yearlyEmi) {
		this.yearlyEmi = yearlyEmi;
	}

}
