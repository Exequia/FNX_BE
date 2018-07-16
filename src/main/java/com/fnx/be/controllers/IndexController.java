package com.fnx.be.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	final static Logger logger = Logger.getLogger(IndexController.class);
	
	@RequestMapping(value="/")
	public String getIndex() {
		
		logger.info("Solicitada página de inicio.");
		
		return "index";
	}

}
