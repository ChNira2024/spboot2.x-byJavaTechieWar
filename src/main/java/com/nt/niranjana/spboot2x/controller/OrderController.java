package com.nt.niranjana.spboot2x.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nt.niranjana.spboot2x.model.Product;
import com.nt.niranjana.spboot2x.model.Product2;
import com.nt.niranjana.spboot2x.model.ProductList;
import com.nt.niranjana.spboot2x.service.IFlipKartOrderService;
import com.nt.niranjana.spboot2x.service.IPurchase;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;



@RestController
@Slf4j
public class OrderController {
	
	@Autowired
	private IPurchase orderServiceCont;
	@Autowired
	private IFlipKartOrderService flpKartOrderServ;
	
	
	
	@PostMapping(value="/listOfOrder",consumes = {"application/json","application/xml"},produces = {"application/json","application/xml"})
	@ApiOperation(value="getlistOfOrder",notes = "get list of order")
	public List<Product> getlistOfOrder(@RequestBody Product product) {
		List<Product> listOfProduct = null;
		try {
			listOfProduct = orderServiceCont.purchaseList(product.getItems(), product.getPrice(),product.getEmails());
			System.out.println("List of Order Details after: "+listOfProduct);
		} catch (Exception e) {
			log.info("Problems with order sending");
			e.printStackTrace();
		}
		return listOfProduct;		
	}
	
	@PostMapping(value="/listOfOrderAs",consumes = {"application/json","application/xml"},produces = {"application/json","application/xml"})
	@ApiOperation(value="getlistOfOrderAs",notes = "get list of orderAs")
	public String getlistOfOrderAs(@RequestBody Product2 product2) 
	{
		String listOfProduct = null;
		try {
			listOfProduct = orderServiceCont.purchageProduct(product2.getItems(),product2.getPrice(),product2.getEmails());
			System.out.println("List of Order Details after: "+listOfProduct);
		} catch (Exception e) {
			log.info("Problems with order sending");
			e.printStackTrace();
		}
		return listOfProduct;		
	}
	
	
	@PostMapping(value="/sendOrder",consumes = {"application/json","application/xml"},produces = {"application/json","application/xml"})
	@ApiOperation(value="orderSend",notes = "sending order")
	public String orderSend(@RequestBody ProductList productList) {
		String listOfProduct = null;
		try {
			listOfProduct = flpKartOrderServ.orderService(productList.getItems(), productList.getPrices(), productList.getEmails());
		} catch (Exception e) {
			log.info("Problems with order sending");
			e.printStackTrace();
		}
		System.out.println("List of Order Details: "+listOfProduct);
		return listOfProduct;		
	}
	
}
