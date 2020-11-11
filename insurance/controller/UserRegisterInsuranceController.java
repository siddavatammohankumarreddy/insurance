package com.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.Dto.UserRegistrationInsuranceResponseDto;
import com.insurance.exception.UserNotFoundException;
import com.insurance.service.UserRegisterInsuranceService;

@RestController
@RequestMapping("/user")
public class UserRegisterInsuranceController {

	@Autowired
	UserRegisterInsuranceService userRegisterInsuranceService;

	@GetMapping("/selectedpolicy")
	public List<UserRegistrationInsuranceResponseDto> getAllInsurance(@RequestParam int userId, @RequestParam int pageNumber,@RequestParam int pageSize) throws UserNotFoundException {
		return userRegisterInsuranceService.getUserListofInsurance(userId, pageNumber, pageSize);
	}
}
