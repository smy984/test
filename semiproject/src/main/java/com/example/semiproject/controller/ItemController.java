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

import com.example.semiproject.entity.ItemDto;
import com.example.semiproject.repository.ItemDao;

@Controller
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemDao itemDao;
	
	@GetMapping("/add")
	public String add() {
		
		return "item/add";
	}
	
	@PostMapping("/add")
	public String add(
			@ModelAttribute ItemDto itemDto, 
			RedirectAttributes attr) {
		int itemNo = itemDao.sequence();
		itemDto.setItemNo(itemNo);
		itemDao.insert(itemDto);
		attr.addAttribute("itemNo", itemNo);
		
		return "redirect:detail";
	}
	
	@GetMapping("/detail")
	public String detail(
			Model model, 
			@RequestParam int itemNo) {
		model.addAttribute("itemDto", itemDao.selectone(itemNo));
		
		return "item/detail";
	}
}
