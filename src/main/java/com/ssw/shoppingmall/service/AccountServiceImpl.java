package com.ssw.shoppingmall.service;

import com.ssw.shoppingmall.domain.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by wisebirds on 2017-05-23.
 */
@Service
@Transactional(readOnly = true)
public class AccountServiceImpl implements AccountService{

    public int y;
    //final 상수
    // spring 4.3 생성자에 오토 와이어가 없어도 자동으로 해줌
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


}
