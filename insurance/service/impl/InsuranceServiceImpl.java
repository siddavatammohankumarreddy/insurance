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

import com.insurance.Dto.InsuranceResponseDto;
import com.insurance.Repository.InsuranceRepository;
import com.insurance.entity.Insurance;
import com.insurance.exception.InsuranceNotFoundException;
import com.insurance.service.InsuranceService;

@Service
public class InsuranceServiceImpl implements InsuranceService {

	@Autowired
	InsuranceRepository insurancePolicyRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(InsuranceServiceImpl.class);

	@Override
	public List<InsuranceResponseDto> getPolicyList(int pageNumber, int pageSize) throws InsuranceNotFoundException {
		Page<Insurance> insurancePolicy;// List<InsurancePolicy> insurancePolicy=new ArrayList<>();
		List<InsuranceResponseDto> insurancePolicyDtos = new ArrayList<>();
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		insurancePolicy = insurancePolicyRepository.findAll(pageable);
		
		if (insurancePolicy.isEmpty()) {
			 LOGGER.warn("Insurance Policys are not avilable");
			throw new InsuranceNotFoundException(" Insurance Policys are not avilable");
		}
		

//		for(InsurancePolicy policy:insurancePolicy) {
//			InsurancePolicyDto insurancePolicyDto=new InsurancePolicyDto();
//			BeanUtils.copyProperties(policy, insurancePolicyDto);
//			insurancePolicyDtos.add(insurancePolicyDto);
		// }

		insurancePolicy.stream().forEach(policy -> {
			InsuranceResponseDto insurancePolicyDto = new InsuranceResponseDto();
			BeanUtils.copyProperties(policy, insurancePolicyDto);
			insurancePolicyDtos.add(insurancePolicyDto);
		});
		
		LOGGER.info("Getting insurance List");
		
		return insurancePolicyDtos;
	}

}
