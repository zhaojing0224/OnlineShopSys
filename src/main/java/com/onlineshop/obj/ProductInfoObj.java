package com.onlineshop.obj;

import lombok.Data;

@Data
public class ProductInfoObj {

	private Integer productId;

	private String productName;

	private Integer productPrice;

	// 画像のパスなどを保存
	private String productImg;

	private String productCategory;

	private String productContents;

	private Integer stock;

}
