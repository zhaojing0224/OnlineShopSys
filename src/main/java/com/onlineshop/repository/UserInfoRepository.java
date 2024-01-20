package com.onlineshop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineshop.model.UserInfo;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, String> {

	void deleteById(String userInfo);
	
	Optional<UserInfo> findById(String userInfo);

}
