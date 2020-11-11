package com.insurance.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.entity.Insurance;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Integer> {

}
