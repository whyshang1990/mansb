package com.why.first.mansb.controller;

import com.why.first.mansb.constant.CommonConstant;
import com.why.first.mansb.dto.response.BaseResponse;
import com.why.first.mansb.service.UserService;
import com.why.first.mansb.utils.ResponseUtil;
import com.why.first.mansb.vo.LogonVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    private static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    @PostMapping(value = "/create")
    public BaseResponse<String> createUser(@RequestBody LogonVO logonVO) {
        LOGGER.debug("执行创建接口");
        this.userService.create(logonVO);
        return ResponseUtil.success(CommonConstant.NULL);
    }

    @PostMapping(value = "/login")
    public BaseResponse<Object> loginIn(@RequestBody LogonVO logonVO){
        if (this.userService.isAllowLogin(logonVO)) {
            return ResponseUtil.success();
        } else {
            return ResponseUtil.innerError();
        }
    }

    @GetMapping(value = "/err")
    public BaseResponse<String> err() {
        LOGGER.debug("调用异常接口");
        throw new RuntimeException("异常错误");
    }
}
