package com.kevin.adminbackend.model.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户注册请求体
 *
 * @author kevin
 */
@Data
public class UserRegisterRequest implements Serializable {

    private static final long serialVersionUID = -3844588053773292807L;

    private String userAccount;

    private String userPassword;

    private String checkPassword;
}
