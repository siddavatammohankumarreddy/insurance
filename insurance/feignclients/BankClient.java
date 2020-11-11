package com.insurance.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.insurance.Dto.TransationResponseDto;
import com.insurance.Dto.UserTransactionRequestDto;

//@FeignClient(value = "Banking-Service", url = "http://localhost:7076/demo")
@FeignClient(name = "http://MYBANKAPP-SERVICE/demo")
public interface BankClient {

	

	@PostMapping(value = "/user/fundtransfer")
	public TransationResponseDto fundTransfer(@RequestBody UserTransactionRequestDto userTransactionRequestDto);

}
