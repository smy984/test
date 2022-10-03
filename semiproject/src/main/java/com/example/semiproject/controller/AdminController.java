package com.example.semiproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.semiproject.repository.ItemDao;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ItemDao itemDao;
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("itemList", itemDao.recentList());
		return "admin/home";
	}
}
