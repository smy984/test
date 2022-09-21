package com.example.semiproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.semiproject.entity.CustomerDto;
import com.example.semiproject.repository.CustomerDao;

@Controller
@RequestMapping("/member")
public class CustomerController {

	@Autowired
	private CustomerDao customerDao;
	
	@GetMapping("/join")
	public String join() {
		return "member/join";
	}
	
	@PostMapping("/join")
	public String join(@ModelAttribute CustomerDto customerDto) {
		customerDao.insert(customerDto);
		return "redirect:login";
	}
	
	@GetMapping("/login")
	public String login() {
		return "member/login";
	}
}
