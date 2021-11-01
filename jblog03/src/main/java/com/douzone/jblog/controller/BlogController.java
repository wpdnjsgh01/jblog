package com.douzone.jblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/blog"})
public class BlogController {

	@RequestMapping("")
	public String logout() {
		return "blog/blog-main";
	}
	
}
