package com.jw.service.impl;

import com.alibaba.druid.sql.ast.statement.SQLIfStatement;
import com.auth0.jwt.interfaces.Claim;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jw.config.JwtConfig;
import com.jw.entity.User;
import com.jw.exception.MyServiceException;
import com.jw.mapper.UserMapper;
import com.jw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.annotation.ElementType;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private JwtConfig jwtConfig;

    @Override
    public Map<String, String> login(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<User>();

        wrapper.eq("USERNAME", user.getUsername() ).eq("PASSWORD", user.getPassword());

        User one = this.getOne(wrapper);

        if(one == null){
            throw new MyServiceException("A0000", "用户名或密码错误");
        }

        if (one.getRoot().equals("1")){
            one.setRoot("STUDENT");
        } else {
            one.setRoot("ADMIN");
        }
        Map<String, String> authToken = new HashMap<>();
        String token = jwtConfig.createJWT(one);
        authToken.put("token", token);

        return authToken;
    }

    @Override
    public User auth(String token) {
        Map<String, Claim> claims = jwtConfig.parseJwt(token);
        User user = User.builder()
                .username(claims.get("accountName").as(String.class))
                .root(claims.get("RANK").as(String.class))
                .build();

        return user;
    }

}
