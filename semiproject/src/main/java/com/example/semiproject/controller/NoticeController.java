package com.example.semiproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.semiproject.repository.NoticeDao;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	
	@Autowired
	private NoticeDao noticeDao;
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("noticeList", noticeDao.list());
		
		return "notice/list";
	}
	
	@GetMapping("/detail")
	public String detail(
			Model model, 
			@RequestParam int noticeNo) {
		model.addAttribute("noticeDto", noticeDao.selectOne(noticeNo));
		
		return "notice/detail";
	}

}
