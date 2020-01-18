package com.why.first.mansb.serviceImpl;

import com.why.first.mansb.domain.UserDO;
import com.why.first.mansb.dto.response.CodeMsgEnum;
import com.why.first.mansb.exception.AppRuntimeException;
import com.why.first.mansb.repository.UserDao;
import com.why.first.mansb.service.UserService;
import com.why.first.mansb.utils.JsonUtil;
import com.why.first.mansb.utils.UuidUtil;
import com.why.first.mansb.vo.LogonVO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserDao userDao;

    @Override
    public Boolean isAllowLogin(LogonVO logonVO) {
        UserDO user = this.userDao.findByUsername(logonVO.getUsername());
        LOGGER.info(JsonUtil.toJson(logonVO));
        if (user == null
                || !StringUtils.equals(user.getUsername(), logonVO.getUsername())
                || !StringUtils.equals(user.getCertificate(), logonVO.getPassword())) {
            LOGGER.info("USER_INFO_ERROR");
            throw new AppRuntimeException(CodeMsgEnum.USER_INFO_ERROR);
        }
        LOGGER.info(JsonUtil.toJson(user));
        return true;
    }

    @Override
    public void create(LogonVO logonVO) {
        UserDO userDO = new UserDO();
        userDO.setUsername(logonVO.getUsername());
        userDO.setCertificate(logonVO.getPassword());
        userDO.setUserUUID(UuidUtil.genUuid());
        this.userDao.save(userDO);
    }
}
