package com.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.Dto.InsuranceResponseDto;
import com.insurance.exception.InsuranceNotFoundException;
import com.insurance.service.InsuranceService;

@RestController
@RequestMapping("/policy")
public class InsuranceController {
	@Autowired
	InsuranceService insurancePolicyService;

	@GetMapping("/policylist")
	public List<InsuranceResponseDto> getPolicyList(@RequestParam int pageNumber, @RequestParam int pageSize)
			throws InsuranceNotFoundException {
		return insurancePolicyService.getPolicyList(pageNumber, pageSize);
	}
}
