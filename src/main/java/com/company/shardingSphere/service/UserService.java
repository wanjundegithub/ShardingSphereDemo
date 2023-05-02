package com.company.shardingSphere.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.company.shardingSphere.mapper.UserMapper;
import com.company.shardingSphere.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService extends ServiceImpl<UserMapper, User> {


}
