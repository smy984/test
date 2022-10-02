package com.example.semiproject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.example.semiproject.constant.SessionConstant;
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
		return "redirect:join-success";
	}
	
	@GetMapping("/join-success")
	public String joinSuccess() {
		return "member/joinSuccess";
	}
	
	@GetMapping("/login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("/login")
	public String login(
			@RequestParam String customerId, 
			@RequestParam String customerPw, 
			HttpSession session) {
		CustomerDto findDto = customerDao.selectOne(customerId);
		
		if(findDto == null) {
			return "redirect:login?error";
		}
		
		boolean isLogin = findDto.getCustomerPw().equals(customerPw);
		if(isLogin) {
			session.setAttribute("loginId", customerId);
			session.setAttribute("loginCg", findDto.getCustomerGrade());
			customerDao.updateLogin(customerId);
		}
		else {
			return "redirect:login?error";
		}
		
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginId");
		session.removeAttribute("loginCg");
		return "redirect:login";
	}
	
	@GetMapping("/mypage")
	public String mypage(
			Model model, 
			HttpSession session) {
		String loginId = (String)session.getAttribute(SessionConstant.ID);
		model.addAttribute("dto", customerDao.selectOne(loginId));
		return "member/mypage";
	}
	
	@GetMapping("/delete")
	public String delete(
			@RequestParam String customerId, 
			HttpSession session) {
		session.removeAttribute("loginId");
		session.removeAttribute("loginCg");
		customerDao.delete(customerId);
		
		return "redirect:../";
	}
}
