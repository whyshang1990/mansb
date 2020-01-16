package com.why.first.mansb.serviceImpl;

import com.why.first.mansb.domain.UserDO;
import com.why.first.mansb.repository.UserDao;
import com.why.first.mansb.service.UserService;
import com.why.first.mansb.vo.LogonVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public Boolean isAllowLogin(LogonVO logonVO) {
        UserDO user = this.userDao.findByName(logonVO.getUsername());
        return logonVO.getUsername().equals(user.getCertificate());
    }

    @Override
    public void create(LogonVO logonVO) {
        UserDO userDO = new UserDO();
        userDO.setName(logonVO.getUsername());
        userDO.setCertificate(logonVO.getPassword());
        this.userDao.save(userDO);
    }
}
