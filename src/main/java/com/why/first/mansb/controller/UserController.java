package com.why.first.mansb.controller;

import com.why.first.mansb.dto.response.BaseResponse;
import com.why.first.mansb.dto.response.CodeMsg;
import com.why.first.mansb.service.UserService;
import com.why.first.mansb.vo.LogonVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping(value = "/create")
    public String createUser() {
        LogonVO logonVO = new LogonVO();
        logonVO.setUsername("username");
        return "create user";
    }

    @PostMapping(value = "/login")
    public BaseResponse<Boolean> loginIn(@RequestBody LogonVO logonVO) {
        Boolean isAllow = this.userService.isAllowLogin(logonVO);
        return new BaseResponse<>(CodeMsg.SUCCESS, isAllow);
    }

    @GetMapping(value = "/err")
    public BaseResponse<String> err() {
        throw new RuntimeException("异常错误");
    }
}
