package com.lenir.helloSpring;

import javax.annotation.*;
import org.springframework.beans.factory.*;

public class Spam implements InitializingBean, DisposableBean {
	private String productName;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@PostConstruct
	public void first() {
		System.out.println("first, before generating first bean");
	}

	@PreDestroy
	public void last() {
		System.out.println("last, deleting last bean.");
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("destroy bean.");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("init bean.");
	}
}
