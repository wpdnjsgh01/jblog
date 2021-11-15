package com.douzone.jblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.douzone.jblog.service.BlogService;
import com.douzone.jblog.service.FileUploadService;
import com.douzone.jblog.vo.BlogVO;

@Controller
@RequestMapping({"/blog"})
public class BlogController {

	@Autowired
	private BlogService blogService;
	
	@Autowired
	private FileUploadService FileUploadService;
	
	@RequestMapping("")
	public String logout() {
		return "blog/blog-main";
	}
	
	@RequestMapping("/basic")
	public String basic() {
		return "blog/blog-admin-basic";
	}
	
	@RequestMapping("/category")
	public String category() {
		return "blog/blog-admin-category";
	}
	
	@RequestMapping("/write")
	public String write() {
		return "blog/blog-admin-write";
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String upload(@RequestParam("file") MultipartFile file, @RequestParam(value="comments", required=true, defaultValue="") String comments) {
		String url = FileUploadService.restoreImage(file);
		
		BlogVO vo = new BlogVO();
		vo.setTitle(url);
		vo.setLogo(comments);
		blogService.saveImage(vo);
		
		return "redirect:/gallery";
	}
	
}
