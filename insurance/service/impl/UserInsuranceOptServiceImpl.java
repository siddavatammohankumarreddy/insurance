package com.insurance.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.Dto.InsuranceRequestDto;
import com.insurance.Dto.TransationResponseDto;
import com.insurance.Dto.UserInsuranceOptRequestDto;
import com.insurance.Dto.UserTransactionRequestDto;
import com.insurance.Repository.InsuranceRepository;
import com.insurance.Repository.UserInsuranceOptRepository;
import com.insurance.Repository.UserRepository;
import com.insurance.entity.Insurance;
import com.insurance.entity.UserDetails;
import com.insurance.entity.UserRegisterInsurance;
import com.insurance.exception.UserNotFoundException;
import com.insurance.exception.UserPolicyNotFoundException;
import com.insurance.feignclients.BankClient;
import com.insurance.service.UserInsuranceOptService;

@Service
public class UserInsuranceOptServiceImpl implements UserInsuranceOptService {

	@Autowired
	InsuranceRepository displayPolicyRepository;

	@Autowired
	UserInsuranceOptRepository userPolicyOptRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	BankClient bankClient;
	private static final Logger LOGGER = LoggerFactory.getLogger(UserInsuranceOptServiceImpl.class);

	@Override
	@Transactional
	public void registerUserPolicy(UserInsuranceOptRequestDto userPolicyOptDto) throws UserPolicyNotFoundException {

		Date date = new Date();
		Long fromAccount = userPolicyOptDto.getFromAccount();
		int userId = userPolicyOptDto.getUserId();

		List<InsuranceRequestDto> userlistpolicy = new ArrayList<>();

		// for (PolicyRequestDto policy : userPolicyOptDto.getPolicyDetails()) {
		// userlistpolicy.add(policy);
		// }

		userPolicyOptDto.getPolicyDetails().forEach(userlistpolicy::add);

		boolean validuser = this.checkValidUser(userId);
		long totalFundTransfer = 0;

		if (!validuser) {
			LOGGER.warn("Invalid User");
			throw new UserNotFoundException("InValid User");
		}
		if (validuser) {
			for (InsuranceRequestDto policyList : userlistpolicy) {
				// userlistpolicy.forEach(policyList->{
				Optional<Insurance> insurancePolicy;
				insurancePolicy = displayPolicyRepository.findById(policyList.getPolicyId());

				if (!insurancePolicy.isPresent()) {
					throw new UserPolicyNotFoundException("Invalid policyId");
				}

				Insurance insurance = insurancePolicy.get();

				boolean monthlypay = policyList.isMonthlyEmi();
				boolean yearpay = policyList.isYearlyEmi();
				long toAccount = insurance.getInsuranceAccount();
				long transferfund;

				UserTransactionRequestDto userTransactionRequestDto = new UserTransactionRequestDto();
				if (yearpay) {
					transferfund = insurance.getInsuranceEmiYearly();
					totalFundTransfer = (totalFundTransfer + transferfund);
					userTransactionRequestDto.setToAccountNumber(insurance.getInsuranceAccount());
					userTransactionRequestDto.setAccountNumber(fromAccount);
					userTransactionRequestDto.setAmount(totalFundTransfer);
					userTransactionRequestDto.getTransactionId();
					userTransactionRequestDto.setDescription("InsurancePolicy");
					userTransactionRequestDto.setDate(date);

				} else {
					transferfund = insurance.getInsuranceEmiMonthly();
					totalFundTransfer = (totalFundTransfer + transferfund);
					userTransactionRequestDto.setToAccountNumber(insurance.getInsuranceAccount());
					userTransactionRequestDto.setAccountNumber(fromAccount);
					userTransactionRequestDto.setAmount(totalFundTransfer);
					userTransactionRequestDto.setDescription("InsurencePolicy");
					userTransactionRequestDto.setDate(date);

				}

				TransationResponseDto status = new TransationResponseDto();
				status = bankClient.fundTransfer(userTransactionRequestDto);

				if (!status.getMessage().equalsIgnoreCase("sucesss")) {

					throw new UserNotFoundException("payment failed");

				}

				UserRegisterInsurance userRegisterpolicy = new UserRegisterInsurance();
				userRegisterpolicy.setSelectedPolicyId(insurance.getInsuranceId());
				userRegisterpolicy.setSelectedPolicyName(insurance.getInsuranceName());
				userRegisterpolicy.setSelectedPolicySumAssured(insurance.getInsuranceSumAssured());
				userRegisterpolicy.setStatus("success");
				userRegisterpolicy.setUserId(userId);

				userPolicyOptRepository.save(userRegisterpolicy);
				// });
			}
		}
	}

	public boolean checkValidUser(int userId) {
		Optional<UserDetails> optionalUser = userRepository.findById(userId);
		if (optionalUser.isPresent()) {
			return true;
		}
		return false;
	}

}
