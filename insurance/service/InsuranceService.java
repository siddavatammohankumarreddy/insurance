package com.insurance.service;

import java.util.List;

import com.insurance.Dto.InsuranceResponseDto;
import com.insurance.exception.InsuranceNotFoundException;

public interface InsuranceService {

	List<InsuranceResponseDto> getPolicyList(int pageNumber, int pageSize) throws InsuranceNotFoundException;

}
