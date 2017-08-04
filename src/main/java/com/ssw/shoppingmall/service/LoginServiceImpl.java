package com.ssw.shoppingmall.service;

import com.ssw.shoppingmall.domain.Account;
import com.ssw.shoppingmall.domain.AccountRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

/**
 * Created by wisebirds on 2017-06-01.
 */
@Service
@Transactional
public class LoginServiceImpl implements UserDetailsService {

    private final AccountRepository accountRepository;

    public LoginServiceImpl(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Account account = accountRepository.findByUserName(userName);
        if(account == null) {
            // 계정이 존재하지 않음
            throw new UsernameNotFoundException("login fail");
        }

        return new User(account.getUserName(), account.getPassword(), Collections.singletonList(() -> "ROLE_ADMIN"));
    }
}
