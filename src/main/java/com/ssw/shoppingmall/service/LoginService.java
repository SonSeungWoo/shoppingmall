package com.ssw.shoppingmall.service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wisebirds on 2017-06-01.
 */
public interface LoginService {
    boolean loginCheck(HttpServletRequest request);
}
