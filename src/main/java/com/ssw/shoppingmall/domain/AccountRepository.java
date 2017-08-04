package com.ssw.shoppingmall.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wisebirds on 2017-05-23.
 */
public interface AccountRepository extends JpaRepository<Account, Long> {

    public Account findByUserName(String userName);
}
