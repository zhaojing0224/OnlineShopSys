package com.onlineshop.controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.onlineshop.model.ProductInfo;
import com.onlineshop.obj.ProductInfoObj;
import com.onlineshop.service.ProductInfoService;

@Controller
public class ProductInfoController {

	@Autowired
	ProductInfoService productInfoService;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@GetMapping("/productRegisterPage")
	public String productRegister(Model model) {

		model.addAttribute("productRegisterPage", "productRegisterPage");

		return "productRegisterPage";
	}

	/**
	 * 商品情報新規登録処理
	 * @param productListInfo
	 * @return
	 */
	@PostMapping("/productRegisterPage")
	public String addProductInfo(@RequestParam("productId") Integer productId,
			@RequestParam("productName") String productName,
			@RequestParam("productPrice") Integer productPrice,
			@RequestParam("productImg") MultipartFile productImg,
			@RequestParam("productCategory") String productCategory,
			@RequestParam("productContents") String productContents,
			@RequestParam("stock") Integer stock,
			RedirectAttributes redirectAttributes) {

		String filePath = null;

		try {
			// 获取文件名
			String fileName = productImg.getOriginalFilename();
			// 拼接保存文件的路径（使用服务器文件系统的绝对路径）
			filePath = "D:\\web\\OnlineShopSystem\\src\\main\\resources\\static\\images\\productImg\\" + fileName;

			// 创建文件对象
			File dest = new File(filePath);

			// 如果文件的目录不存在，创建目录
			if (!dest.getParentFile().exists()) {
				dest.getParentFile().mkdirs();
			}

			// 将上传的文件保存到目标文件
			productImg.transferTo(dest);

			// 其他逻辑，如将文件路径存储到数据库

		} catch (IOException e) {
			e.printStackTrace();
			// 处理文件保存时的异常，可以向用户提供更多信息
			redirectAttributes.addFlashAttribute("error", "ファイルのアップロードに失敗しました: " + e.getMessage());
			return "redirect:/productRegisterPage";
		}

		ProductInfo productInfo = new ProductInfo();

		productInfo.setProductId(productId);
		productInfo.setProductName(productName);
		productInfo.setProductPrice(productPrice);
		productInfo.setProductImg(filePath);
		productInfo.setProductCategory(productCategory);
		productInfo.setProductContents(productContents);
		productInfo.setStock(stock);

		LocalDateTime currentTime = LocalDateTime.now();

		productInfo.setCreateDate(currentTime);
		productInfo.setUpdateDate(currentTime);

		productInfoService.saveProductInfo(productInfo);

		redirectAttributes.addFlashAttribute("message", "商品が正常に登録されました。");
		return "redirect:/productListInfoPage";

	}
	
	@GetMapping("/productListInfoPage")
	public String productListInfo(Model model) {
		
		model.addAttribute("productListInfoPage", "productListInfoPage");
		
		List<ProductInfoObj> productInfoList = productInfoService.findAllProductInfo();
	    model.addAttribute("productInfoList", productInfoList);
	    return "productListInfoPage";
	}
}
