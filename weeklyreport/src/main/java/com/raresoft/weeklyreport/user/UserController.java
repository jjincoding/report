package com.raresoft.weeklyreport.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	  
	  @GetMapping("/") public String home(Model model) throws Exception { // 인증된 사용자의 정보를 보여줌
		  try {
			  Long id = (Long) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			  // token에 저장되어 있는 인증된 사용자의 id 값
			  
			  UserVo userVo = userService.getUserById(id);
			  model.addAttribute("user", userVo);
			  return "home";
		  } catch (Exception e) {
			  e.printStackTrace();
		  }
		return null;
	  }

	@GetMapping("/login")
	public String loginPage() throws Exception { // 로그인 되지 않은 상태면 login 페이지를, 로그인 된 상태면 home 페이지
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication instanceof AnonymousAuthenticationToken) {
			return "loginPage";
		} return "redirect:/";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;    
	}
	
	@GetMapping("/signup")
	public String signupPage() throws Exception { // 회원가입 페이지
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication instanceof AnonymousAuthenticationToken) {
			return "signupPage";
		} return "redirect:/";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PostMapping("/signup")
	public String signup(UserVo userVo) throws Exception { // 회원가입
		try {
			userService.signup(userVo);
		} catch (DuplicateKeyException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/login";
	}
	
	@GetMapping("/listPage")
	public String listPage() throws Exception {
		return "listPage";
	}
}