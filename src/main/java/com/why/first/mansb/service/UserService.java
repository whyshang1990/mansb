package com.why.first.mansb.service;

import com.why.first.mansb.vo.LogonVO;

public interface UserService {
    Boolean isAllowLogin(LogonVO logonVO);
    void create(LogonVO logonVO);
}
