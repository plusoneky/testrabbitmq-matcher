package com.gxzx.testrabbitmq.web.service.impl;

import com.gxzx.testrabbitmq.web.entity.Coin;
import com.gxzx.testrabbitmq.web.mapper.CoinMapper;
import com.gxzx.testrabbitmq.web.service.ICoinService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 币种配置表 服务实现类
 * </p>
 *
 * @author administrator
 * @since 2019-08-22
 */
@Service
public class CoinServiceImpl extends ServiceImpl<CoinMapper, Coin> implements ICoinService {

}
