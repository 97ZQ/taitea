package com.htht.business.thirty.equip.utils;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class LoginInfo {

    @JsonAlias("Id")
    private Long id;

    @JsonAlias("Account")
    private String account;

    @JsonAlias("Phone")
    private String phone;

    @JsonAlias("NickName")
    private String nickName;

    @JsonAlias("Password")
    private String password;

    @JsonAlias("PlainCode")
    private String plainCode;

    @JsonAlias("RoleID")
    private String roleID;

    @JsonAlias("WeChatOpenID")
    private String weChatOpenID;

    @JsonAlias("AuthCode")
    private String authCode;

    @JsonAlias("HeadPath")
    private String headPath;

    @JsonAlias("CreateTime")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private Date createTime;

    @JsonAlias("Status")
    private Integer status;

}
