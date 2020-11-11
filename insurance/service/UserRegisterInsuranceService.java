package com.insurance.service;

import java.util.List;

import com.insurance.Dto.UserRegistrationInsuranceResponseDto;
import com.insurance.exception.UserNotFoundException;

public interface UserRegisterInsuranceService {

	List<UserRegistrationInsuranceResponseDto> getUserListofInsurance(int userId, int pageNumber, int pageSize)
			throws UserNotFoundException;

}
