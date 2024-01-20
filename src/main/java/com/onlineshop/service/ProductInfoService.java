package com.onlineshop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineshop.model.ProductInfo;
import com.onlineshop.obj.ProductInfoObj;
import com.onlineshop.repository.ProductInfoRepository;

@Service
public class ProductInfoService {

	@Autowired
	ProductInfoRepository productInfoRepositroy;

	/**
	 * 商品情報を更新する
	 * @param productInfo
	 * @return productInfo
	 */
	public ProductInfo saveProductInfo(ProductInfo productInfo) {
		return productInfoRepositroy.save(productInfo);
	}

	/**
	 * 商品情報を全件取得する
	 * @return productInfoObjList
	 */
	public List<ProductInfoObj> findAllProductInfo() {
		
		List<ProductInfoObj> productInfoObjList = new ArrayList<ProductInfoObj>();
		List<ProductInfo> productInfoList = productInfoRepositroy.findAll();
		
		for(ProductInfo p : productInfoList ) {
			
			ProductInfoObj obj = new ProductInfoObj();
			obj.setProductId(p.getProductId());
			obj.setProductName(p.getProductName());
			obj.setProductPrice(p.getProductPrice());
			obj.setProductImg(p.getProductImg());
			obj.setProductCategory(p.getProductCategory());
			obj.setProductImg(p.getProductContents());
			obj.setStock(p.getStock());
			
			productInfoObjList.add(obj);
		}
		
		return productInfoObjList;
	}

	/**
	 * 指定したidの商品情報を取得する
	 * @param id
	 * @return productInfo
	 */
	public Optional<ProductInfo> findProductInfoById(Integer productId) {
		return productInfoRepositroy.findById(productId);
	}

	/**
	 * 商品情報を削除する
	 * @param productInfo
	 * @return productInfo
	 */
	public void deleteProductInfo(Integer productId) {
		productInfoRepositroy.deleteById(productId);
	}

}