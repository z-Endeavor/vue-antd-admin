package com.kevin.adminbackend.model.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户登录请求体
 *
 * @author kevin
 */
@Data
public class UserLoginRequest implements Serializable {

    private static final long serialVersionUID = -3844588053773292807L;

    private String userAccount;

    private String userPassword;
}
