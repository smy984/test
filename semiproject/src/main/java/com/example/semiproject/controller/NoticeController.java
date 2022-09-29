package com.example.semiproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.semiproject.entity.NoticeDto;
import com.example.semiproject.repository.NoticeDao;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	
	@Autowired
	private NoticeDao noticeDao;
	
	@GetMapping("/list")
	public String list(Model model, 
			@RequestParam(required = false) String type, 
			@RequestParam(required = false) String keyword) {
		
		boolean isSearch = type != null && keyword != null;
		List<NoticeDto> noticeList;
		if(isSearch) {
			noticeList = noticeDao.list(type, keyword);
		}
		else {
			noticeList = noticeDao.list();
		}
		model.addAttribute("noticeList", noticeList);
		
		return "notice/list";
	}
	
	@GetMapping("/write")
	public String write() {
		return "notice/write";
	}
	
	@GetMapping("/detail")
	public String detail(Model model, @RequestParam int noticeNo) {
		
		model.addAttribute("noticeDto", noticeDao.selectOne(noticeNo));
		
		return "notice/detail";
	}
	
}
