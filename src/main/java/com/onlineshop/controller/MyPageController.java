package com.onlineshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onlineshop.obj.UserInfoObj;
import com.onlineshop.service.UserInfoService;

@Controller
@RequestMapping("/user")
public class MyPageController {

	private final UserInfoService userInfoService;

	public MyPageController(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	@GetMapping("/myPage")
	public String normalUserInfo(Model model, @ModelAttribute("userId") String userId) {

		if (userId != null) {

			UserInfoObj userInfoObj = userInfoService.findUserInfoById(userId);

			if (userInfoObj != null) {

				model.addAttribute("userInfoObj", userInfoObj);
				System.out.println(userInfoObj.getUserName() + "00000");
				
			} else {
				model.addAttribute("error", "ユーザーが見つかりません");
			}
		}
		return "myPage";
	}
	
}