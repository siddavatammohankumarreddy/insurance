package com.insurance.Dto;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class UserTransactionRequestDto {
	private Long toAccountNumber;
	private double amount;
	private Long accountNumber;
	private String description;
	private Date date;
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long transactionId;

	public Long getToAccountNumber() {
		return toAccountNumber;
	}

	public double getAmount() {
		return amount;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public String getDescription() {
		return description;
	}

	public Date getDate() {
		return date;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setToAccountNumber(Long toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

}
