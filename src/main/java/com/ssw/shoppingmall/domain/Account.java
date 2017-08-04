package com.ssw.shoppingmall.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by wisebirds on 2017-05-23.
 */
@Entity
@Data
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    private String userName;

    @Column
    @NotNull
    String password;

    @Column
    @NotNull
    String role;

    public Account() {
    }

    public Account(String userName, String password, String role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }
}
