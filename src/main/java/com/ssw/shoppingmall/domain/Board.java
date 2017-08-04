package com.ssw.shoppingmall.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by wisebirds on 2017-05-31.
 */
@Entity
@Data
public class Board {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String description;
    private Timestamp createTime;
    private String createUser;
    private Timestamp updateTime;
    private String updateUser;

    Board(){

    }

    public Board(String title, String description, Timestamp createTime, String createUser, Timestamp updateTime, String updateUser){
        this.title = title;
        this.description = description;
        this.createTime = createTime;
        this.createUser = createUser;
        this.updateTime = updateTime;
        this.updateUser = updateUser;
    }
}
