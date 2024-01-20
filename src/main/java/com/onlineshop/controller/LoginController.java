package com.onlineshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.onlineshop.obj.UserLoginInfoObj;
import com.onlineshop.service.UserLoginInfoService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

	private final UserLoginInfoService userLoginInfoService;

	public LoginController(UserLoginInfoService userLoginInfoService) {
		this.userLoginInfoService = userLoginInfoService;
	}

	@GetMapping("/login")
	public String normalUserInfo(Model model) {

		model.addAttribute("homePage", "normalUserInfo");

		return "/loginPage";
	}

	@PostMapping("/login")
	public String login(@RequestParam("searchId") String userId,
			@RequestParam("customer[password]") String password,
			RedirectAttributes redirectAttributes, HttpServletRequest request) {

		HttpSession session = request.getSession();
		
		//データベースからユーザー情報を検索する
		UserLoginInfoObj user = userLoginInfoService.getUserByUserId(userId);

		if (user != null && password.equals(user.getPassword()) &&  userId.equals(user.getUserId())) {
			//ログイン成功した場合、MyPage にリダイレクトされます。
			System.out.println(userId);
			 redirectAttributes.addFlashAttribute("userId", userId);
			return "redirect:/user/myPage";
			
		} else {
			//ログイン失敗した場合、ログインページに戻ります
			return "redirect:/login";
		}
	}
}
