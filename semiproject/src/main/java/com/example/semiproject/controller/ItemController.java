package com.example.semiproject.controller;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
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

import com.example.semiproject.constant.SessionConstant;
import com.example.semiproject.entity.CustomerLikeDto;
import com.example.semiproject.entity.ItemDto;
import com.example.semiproject.error.TargetNotFoundException;
import com.example.semiproject.repository.CustomerLikeDao;
import com.example.semiproject.repository.ItemDao;

@Controller
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemDao itemDao;
	
	@Autowired
	private CustomerLikeDao likeDao;
	
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
			File dir = new File("D:/upload/item");
//			File dir = new File(System.getProperty("user.home")+"/upload/item");
			dir.mkdirs();
			File target = new File(dir, String.valueOf(itemNo));
			itemImage.transferTo(target);
		}
		
		attr.addAttribute("itemNo", itemNo);
		
		return "redirect:detail";
	}
	
	@GetMapping("/detail")
	public String detail(
			Model model, 
			HttpSession session, 
			@RequestParam int itemNo) {
		model.addAttribute("itemDto", itemDao.selectone(itemNo));
		
		String loginId = (String)session.getAttribute(SessionConstant.ID);
		if(loginId != null) {
			CustomerLikeDto likeDto = new CustomerLikeDto();
			likeDto.setCustomerId(loginId);
			likeDto.setItemNo(itemNo);
			model.addAttribute("isLike", likeDao.check(likeDto));
		}
		
		return "item/detail";
	}
	
	@GetMapping("/download")
	@ResponseBody
	public ResponseEntity<ByteArrayResource> download(
			@RequestParam int itemNo) throws IOException {
		File dir = new File("D:/upload/item");
//		File dir = new File(System.getProperty("user.home")+"/upload/item");
		File target = new File(dir, String.valueOf(itemNo));
		
		if(target.exists()) {
			byte[] data = FileUtils.readFileToByteArray(target);
			ByteArrayResource resource = new ByteArrayResource(data);
			
			return ResponseEntity.ok()
						.header(HttpHeaders.CONTENT_ENCODING, StandardCharsets.UTF_8.name())
						.header("Content-Length", String.valueOf(data.length))
						.header("Content-Type", "application/octet-stream")
						.header("Content-Disposition", "attachment; filename="+itemNo)
						.body(resource);
		}
		else {
			throw new TargetNotFoundException("첨부파일 없음");
		}
	}
	
	@GetMapping("/like")
	public String like(
			@RequestParam int itemNo, 
			HttpSession session, 
			RedirectAttributes attr) {
		String loginId = (String)session.getAttribute(SessionConstant.ID);
		
		CustomerLikeDto likeDto = new CustomerLikeDto();
		likeDto.setCustomerId(loginId);
		likeDto.setItemNo(itemNo);
		
		if(likeDao.check(likeDto)) {
			likeDao.delete(likeDto);
		}
		else {
			likeDao.insert(likeDto);
		}
		
		likeDao.update(itemNo);
		
		attr.addAttribute("itemNo", itemNo);
		
		return "redirect:detail";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("itemList", itemDao.bestList());
		return "item/list";
	}
}
