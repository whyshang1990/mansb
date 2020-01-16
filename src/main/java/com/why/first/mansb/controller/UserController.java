package com.why.first.mansb.controller;

import com.why.first.mansb.constant.CommonConstant;
import com.why.first.mansb.dto.response.BaseResponse;
import com.why.first.mansb.service.UserService;
import com.why.first.mansb.utils.ResponseUtil;
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
    public BaseResponse<String> createUser(@RequestBody LogonVO logonVO) {
        this.userService.create(logonVO);
        return ResponseUtil.success(CommonConstant.NULL);
    }

    @PostMapping(value = "/login")
    public BaseResponse<Boolean> loginIn(@RequestBody LogonVO logonVO) {
        Boolean isAllow = this.userService.isAllowLogin(logonVO);
        return ResponseUtil.success(isAllow);
    }

    @GetMapping(value = "/err")
    public BaseResponse<String> err() {
        throw new RuntimeException("异常错误");
    }
}
