package com.kevin.adminbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kevin.adminbackend.model.domain.User;
import com.kevin.adminbackend.service.UserService;
import com.kevin.adminbackend.mapper.UserMapper;

import org.springframework.stereotype.Service;

/**
 * 用户服务实现类
 *
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

}
