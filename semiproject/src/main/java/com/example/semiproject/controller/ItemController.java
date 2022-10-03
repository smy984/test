package com.example.semiproject.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;	
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
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
			RedirectAttributes attr, 
			@RequestParam MultipartFile itemImage) throws IllegalStateException, IOException {
		int itemNo = itemDao.sequence();
		itemDto.setItemNo(itemNo);
		itemDao.insert(itemDto);
		
		if(!itemImage.isEmpty()) {
			File dir = new File(System.getProperty("user.home")+"/upload/item");
			dir.mkdirs();
			File target = new File(dir, String.valueOf(itemNo));
			itemImage.transferTo(target);
		}
		
		attr.addAttribute("itemNo", itemNo);
		
		return "redirect:detail";
	}
	
//	@GetMapping("/detail")
//	public String detail(
//			Model model, 
//			@RequestParam int itemNo) {
//		model.addAttribute("itemDto", itemDao.selectone(itemNo));
//		
//		return "item/detail";
//	}
//	
//	@GetMapping("/download")
//	@ResponseBody
//	public ResponseEntity<ByteArrayResource> douwnload(
//			@RequestParam int itemNo) {
//		File dir = new File(("user.home")+"/upload/item");
//		File target = new File(dir, String.valueOf(itemNo));
//		
//		if(target.exists()) {
//			byte[] data = FileUtils.
//		}
//	}
}
