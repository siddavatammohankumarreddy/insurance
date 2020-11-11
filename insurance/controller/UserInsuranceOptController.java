package com.insurance.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.Dto.UserInsuranceOptRequestDto;
import com.insurance.exception.UserPolicyNotFoundException;
import com.insurance.service.UserInsuranceOptService;

@RestController
@RequestMapping("/user")
public class UserInsuranceOptController {
	
	@Autowired
	UserInsuranceOptService userPolicyOptService;




	@PostMapping("/registerpolicy")
	public String savePolicy(@Valid @RequestBody UserInsuranceOptRequestDto userPolicyOptDto) throws UserPolicyNotFoundException {
		userPolicyOptService.registerUserPolicy(userPolicyOptDto);
		return "Policy Register Sucessfull";
	}

}
