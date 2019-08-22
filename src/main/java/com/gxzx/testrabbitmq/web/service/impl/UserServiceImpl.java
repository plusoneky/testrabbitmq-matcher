package com.gxzx.testrabbitmq.web.service.impl;

import com.gxzx.testrabbitmq.web.entity.User;
import com.gxzx.testrabbitmq.web.mapper.UserMapper;
import com.gxzx.testrabbitmq.web.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author administrator
 * @since 2019-08-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
