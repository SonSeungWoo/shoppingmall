package com.ssw.shoppingmall.web;

import com.ssw.shoppingmall.domain.AccountRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

	private final AccountRepository accountRepository;

	public LoginController(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@GetMapping("/login")
	public ModelAndView getLoginPage() {
		ModelAndView mod = new ModelAndView();
		mod.addObject("login");
		return mod;
	}

	@GetMapping("/logout")
	public ModelAndView loginProcess(HttpSession session) {
		ModelAndView mod = new ModelAndView();
		session.invalidate();
		mod.addObject("login");
		return mod;
	}
}
