package com.onlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.onlineshop.obj.UserInfoObj;
import com.onlineshop.obj.UserLoginInfoObj;
import com.onlineshop.service.UserInfoService;
import com.onlineshop.service.UserLoginInfoService;

@Controller
public class AccountController {

	@Autowired
	private UserInfoService userInfoService;

	@Autowired
	private UserLoginInfoService userLoginInfoService;

	/**
	 * ユーザー登録画面を表示
	 * @param LoginPage
	 * @return
	 */
	@GetMapping("/LoginPage")
	public String Login(Model model) {

		model.addAttribute("LoginPage", "LoginPage");

		return "LoginPage";
	}

	/**
	 * ユーザー新規登録画面を表示
	 * @param LoginPage
	 * @return
	 */
	@GetMapping("/userRegister")
	public String userRegister(Model model) {

		model.addAttribute("userRegisterPage", "userRegisterPage");

		return "userRegisterPage";
	}

	/**
	 * ユーザー新規登録処理
	 * @param myPage
	 * @return
	 */
	@PostMapping("/userRegisterProcess")
	public String userRegister(@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("userId") String userId,
			@RequestParam("password") String password) {

		//		System.out.print(666);

		String Name = firstName + " " + lastName;

		UserInfoObj userInfoObj = new UserInfoObj();
		userInfoObj.setUserId(userId);
		userInfoObj.setUserName(Name);

		userInfoService.saveUserInfo(userInfoObj);

		UserLoginInfoObj userLoginInfoObj = new UserLoginInfoObj();
		userLoginInfoObj.setUserId(userId);
		userLoginInfoObj.setPassword(password);

		userLoginInfoService.saveUserLoginInfo(userLoginInfoObj);

		return "redirect:/login";
	}

}
