package com.ssw.shoppingmall.web;

import javax.servlet.http.HttpSession;

import com.ssw.shoppingmall.domain.AccountRepository;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wisebirds on 2017-05-23.
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    //마찬가지
    private final AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping("/my_account")
    public String my_account(Model model, @AuthenticationPrincipal User user, HttpSession session) {
        session.setAttribute("id", user.getUsername());
        model.addAttribute("account", accountRepository.findByUserName(user.getUsername()));
        return "account/my_account";
    }

}
