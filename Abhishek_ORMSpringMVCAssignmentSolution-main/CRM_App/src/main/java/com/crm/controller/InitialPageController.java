package com.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This Controller is indented to bring the customer list as initial page 
 * while application starts. 
 * Initially, the base url will be caught by this controller and 
 * diverted to appropriate request handler.  
 * 
 */

@Controller
@RequestMapping("")
public class InitialPageController {

	@RequestMapping("")
	public String initPage() {
		return "redirect:/operations/list";
	}
}
