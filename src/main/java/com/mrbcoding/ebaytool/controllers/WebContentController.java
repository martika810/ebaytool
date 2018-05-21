package com.mrbcoding.ebaytool.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebContentController {

	@RequestMapping("/ini")
	public String page() {
		return "html/homepage";
	}

}
