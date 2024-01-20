package com.onlineshop.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.onlineshop.obj.UserInfoObj;

public class UserInfoController {

	@PostMapping("/getUserInfo")
	public String getUserInfo(Model model) {

		if (false) {
			return "myPage";
		}

		UserInfoObj userInfo = new UserInfoObj();

		model.addAttribute("userInfo", userInfo);

		return "myPage";
	}

}
