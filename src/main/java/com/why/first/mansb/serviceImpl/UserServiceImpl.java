package com.why.first.mansb.serviceImpl;

import com.why.first.mansb.domain.UserDO;
import com.why.first.mansb.repository.UserDao;
import com.why.first.mansb.service.UserService;
import com.why.first.mansb.vo.LogonVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public Boolean isAllowLogin(LogonVO logonVO) {
        UserDO user = this.userDao.findByName(logonVO.getUserName());
        return logonVO.getUserName().equals(user.getCertificate());
    }

    @Override
    public void create(LogonVO logonVO) {
        UserDO userDO = new UserDO();
        userDO.setName(logonVO.getUserName());
        userDO.setCertificate(logonVO.getPassword());
        userDO.setUserUUID(UUID.randomUUID().toString());
        this.userDao.save(userDO);
    }
}
