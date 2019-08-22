package com.gxzx.testrabbitmq.web.service.impl;

import com.gxzx.testrabbitmq.web.entity.Account;
import com.gxzx.testrabbitmq.web.mapper.AccountMapper;
import com.gxzx.testrabbitmq.web.service.IAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * OTC账户表 服务实现类
 * </p>
 *
 * @author administrator
 * @since 2019-08-22
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {

}
