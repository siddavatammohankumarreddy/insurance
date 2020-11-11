package com.insurance.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.entity.UserRegisterInsurance;

public interface UserInsuranceOptRepository extends JpaRepository<UserRegisterInsurance, Integer> {

	Page<UserRegisterInsurance> findByuserId(int userId, Pageable pageable);

}
