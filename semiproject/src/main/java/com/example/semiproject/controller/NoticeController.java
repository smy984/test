package com.example.semiproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.semiproject.entity.NoticeDto;
import com.example.semiproject.repository.NoticeDao;
import com.example.semiproject.vo.NoticeListVO;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	
	@Autowired
	private NoticeDao noticeDao;
	
	@GetMapping("/list")
	public String list(Model model, 
			@ModelAttribute NoticeListVO noticeListvo) {
		model.addAttribute("noticeList", noticeDao.noticeBoard(noticeListvo));
		
		return "notice/list";
	}
	
	@GetMapping("/write")
	public String write() {
		return "notice/write";
	}
	
	@PostMapping("/write")
	public String write(
			@ModelAttribute NoticeDto noticeDto, 
			RedirectAttributes attr) {
		int noticeNo = noticeDao.sequence();
		noticeDto.setNoticeNo(noticeNo);
		noticeDao.insert(noticeDto);
		attr.addAttribute("noticeNo", noticeNo);
		return "redirect:detail";
	}
	
	@GetMapping("/detail")
	public String detail(Model model, @RequestParam int noticeNo) {
		
		model.addAttribute("noticeDto", noticeDao.selectOne(noticeNo));
		
		return "notice/detail";
	}
	
	@GetMapping("/edit")
	public String edit(
			Model model, 
			@RequestParam int noticeNo) {
		model.addAttribute("noticeDto", noticeDao.selectOne(noticeNo));
		
		return "notice/edit";
	}
	
	@PostMapping("/edit")
	public String edit(
			RedirectAttributes attr, 
			@ModelAttribute NoticeDto noticeDto) {
		
		return "return:detail";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam int noticeNo) {
		noticeDao.delete(noticeNo);
		
		return "redirect:list";
	}
}
