package com.lenir.helloSpring;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloSpringMain {

	public static void main(String[] args){
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:applicationCTX.xml");
		ctx.refresh();

		Spam s = ctx.getBean("s1", Spam.class);

		ctx.close();
	}
}
