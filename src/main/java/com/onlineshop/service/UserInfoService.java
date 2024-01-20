package com.onlineshop.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineshop.model.UserInfo;
import com.onlineshop.obj.UserInfoObj;
import com.onlineshop.repository.UserInfoRepository;

@Service
public class UserInfoService {

	@Autowired
	UserInfoRepository userInfoRepositroy;

	/**
	 * ユーザー情報を更新する
	 * @param userInfo
	 * @return userInfo
	 */
	public UserInfo saveUserInfo(UserInfoObj userInfoObj) {

		LocalDateTime currentTime = LocalDateTime.now();

		UserInfo userInfo = new UserInfo();
		userInfo.setUserId(userInfoObj.getUserId());
		userInfo.setUserName(userInfoObj.getUserName());
		userInfo.setSex(userInfoObj.getSex());
		userInfo.setBirth(userInfoObj.getBirth());
		userInfo.setPostCode(userInfoObj.getPostCode());
		userInfo.setTodoufuken(userInfoObj.getTodoufuken());
		userInfo.setShikucyouson(userInfoObj.getShikucyouson());
		userInfo.setCyoumebanchi(userInfoObj.getCyoumebanchi());
		userInfo.setRoomNumber(userInfoObj.getRoomNumber());
		userInfo.setPhoneNumber(userInfoObj.getPhoneNumber());
		userInfo.setCreateDate(currentTime);
		userInfo.setUpdateDate(currentTime);

		return userInfoRepositroy.save(userInfo);
	}

	/**
	 * ユーザー情報を全件取得する
	 * @return userInfoObjList
	 */
	//	public List<UserInfo> findAllUserInfo() {
	//		return userInfoRepositroy.findAll();
	//	}

	public List<UserInfoObj> findAllUserInfo() {

		List<UserInfoObj> userInfoObjList = new ArrayList<UserInfoObj>();
		List<UserInfo> userInfoList = userInfoRepositroy.findAll();

		for (UserInfo u : userInfoList) {

			UserInfoObj obj = new UserInfoObj();
			obj.setUserId(u.getUserId());
			obj.setSex(u.getSex());
			obj.setBirth(u.getBirth());
			obj.setPostCode(u.getPostCode());
			obj.setTodoufuken(u.getTodoufuken());
			obj.setShikucyouson(u.getShikucyouson());
			obj.setCyoumebanchi(u.getCyoumebanchi());
			obj.setRoomNumber(u.getRoomNumber());
			obj.setPhoneNumber(u.getPhoneNumber());

			userInfoObjList.add(obj);
		}
		return userInfoObjList;
	}

	/**
	 * 指定したidのユーザー情報を取得する
	 * @param id
	 * @return userInfo
	 */
	public UserInfoObj findUserInfoById(String userId) {
		
		UserInfoObj userInfoObj = new UserInfoObj();
		
		Optional<UserInfo> userInfo = userInfoRepositroy.findById(userId);
		
		userInfoObj.setUserName(userInfo.get().getUserName());
		userInfoObj.setUserId(userInfo.get().getUserId());
		userInfoObj.setSex(userInfo.get().getSex());
		userInfoObj.setBirth(userInfo.get().getBirth());
		userInfoObj.setPostCode(userInfo.get().getPostCode());
		userInfoObj.setTodoufuken(userInfo.get().getTodoufuken());
		userInfoObj.setShikucyouson(userInfo.get().getShikucyouson());
		userInfoObj.setCyoumebanchi(userInfo.get().getCyoumebanchi());
		userInfoObj.setRoomNumber(userInfo.get().getRoomNumber());
		userInfoObj.setPhoneNumber(userInfo.get().getPhoneNumber());
		
		return userInfoObj;
	}

	/**
	 * ユーザー情報を削除する
	 * @param userInfo
	 * @return userInfo
	 */
	public void deleteuserInfo(String userInfo) {
		userInfoRepositroy.deleteById(userInfo);
	}

}
