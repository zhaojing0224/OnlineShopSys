package com.onlineshop.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineshop.model.UserLoginInfo;
import com.onlineshop.obj.UserLoginInfoObj;
import com.onlineshop.repository.UserLoginInfoRepository;

@Service
public class UserLoginInfoService {

	@Autowired
	UserLoginInfoRepository userLoginfoInfoRepositroy;

	/**
	 * ユーザー情報を更新する
	 * @param userLoginInfo
	 * @return userLoginInfo
	 */
	public void saveUserLoginInfo(UserLoginInfoObj userLoginInfoObj) {

		LocalDateTime currentTime = LocalDateTime.now();

		UserLoginInfo userLoginInfo = new UserLoginInfo();
		userLoginInfo.setUserId(userLoginInfoObj.getUserId());
		userLoginInfo.setPassword(userLoginInfoObj.getPassword());
		userLoginInfo.setCreateDate(currentTime);
		userLoginInfo.setUpdateDate(currentTime);

		userLoginfoInfoRepositroy.save(userLoginInfo);
	}

	public UserLoginInfoObj getUserByUserId(String userId) {

		Optional<UserLoginInfo> userOptional = userLoginfoInfoRepositroy.findById(userId);

		if (userOptional.isPresent()) {
			
			UserLoginInfo userLoginInfo = userOptional.get();
			
			UserLoginInfoObj userLoginInfoObj = new UserLoginInfoObj();
			userLoginInfoObj.setUserId(userLoginInfo.getUserId());
			userLoginInfoObj.setPassword(userLoginInfo.getPassword());
			
			return userLoginInfoObj;
			
		} else {
			return null;
		}
	}

}

