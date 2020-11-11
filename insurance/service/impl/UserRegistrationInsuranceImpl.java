package com.insurance.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.insurance.Dto.UserRegistrationInsuranceResponseDto;
import com.insurance.Repository.UserInsuranceOptRepository;
import com.insurance.entity.UserRegisterInsurance;
import com.insurance.exception.UserNotFoundException;
import com.insurance.service.UserRegisterInsuranceService;

@Service
public class UserRegistrationInsuranceImpl implements UserRegisterInsuranceService {
	@Autowired
	UserInsuranceOptRepository userPolicyOptRepository;
	private static final Logger LOGGER = LoggerFactory.getLogger(UserRegistrationInsuranceImpl.class);

	@Override
	public List<UserRegistrationInsuranceResponseDto> getUserListofInsurance(int userId, int pageNumber, int pageSize)
			throws UserNotFoundException {
		Page<UserRegisterInsurance> userRegisterpolicy;
		List<UserRegistrationInsuranceResponseDto> userRegistrationpolicyDto = new ArrayList<UserRegistrationInsuranceResponseDto>();
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		userRegisterpolicy = userPolicyOptRepository.findByuserId(userId, pageable);

		if (userRegisterpolicy.isEmpty()) {
			LOGGER.warn("Invalid user");
			throw new UserNotFoundException("Invalid user");
		}
//		for(UserRegisterpolicy userrequest:userRegisterpolicy) {
//			UserRegistrationpolicyDto userRegistrationpolicyDtos=new UserRegistrationpolicyDto();
//			BeanUtils.copyProperties(userrequest, userRegistrationpolicyDtos);
//			 userRegistrationpolicyDto.add(userRegistrationpolicyDtos);
//			}

		userRegisterpolicy.stream().forEach(userrequest -> {
			UserRegistrationInsuranceResponseDto userRegistrationpolicyDtos = new UserRegistrationInsuranceResponseDto();
			BeanUtils.copyProperties(userrequest, userRegistrationpolicyDtos);
			userRegistrationpolicyDto.add(userRegistrationpolicyDtos);
		});
		LOGGER.info("Getting user selected insurance list");
		return userRegistrationpolicyDto;
	}

}
