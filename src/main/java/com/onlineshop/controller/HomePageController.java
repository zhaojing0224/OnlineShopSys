package com.onlineshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.onlineshop.obj.ProductInfoObj;
import com.onlineshop.service.ProductInfoService;

@Controller
public class HomePageController {
	
	@Autowired
	ProductInfoService productInfoService;

	@GetMapping("/homePage")
	public String normalUserInfo(Model model) {


		model.addAttribute("homePage", "homePage");
		
		List<ProductInfoObj> productInfoList = productInfoService.findAllProductInfo();
		
		model.addAttribute("productInfoList", productInfoList);

		return "homePage";
	}

	@GetMapping("/collectionsPage")
	public String collectionPage(Model model) {

		model.addAttribute("collectionsPage", "collectionPage");

		return "collectionsPage";
	}

}