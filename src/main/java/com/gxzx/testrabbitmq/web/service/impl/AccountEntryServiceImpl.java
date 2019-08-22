package com.gxzx.testrabbitmq.web.service.impl;

import com.gxzx.testrabbitmq.web.entity.AccountEntry;
import com.gxzx.testrabbitmq.web.mapper.AccountEntryMapper;
import com.gxzx.testrabbitmq.web.service.IAccountEntryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 资金流水表 服务实现类
 * </p>
 *
 * @author administrator
 * @since 2019-08-22
 */
@Service
public class AccountEntryServiceImpl extends ServiceImpl<AccountEntryMapper, AccountEntry> implements IAccountEntryService {

}
