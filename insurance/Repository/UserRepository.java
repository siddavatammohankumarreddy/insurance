package com.insurance.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.entity.UserDetails;

public interface UserRepository extends JpaRepository<UserDetails, Integer> {

}
