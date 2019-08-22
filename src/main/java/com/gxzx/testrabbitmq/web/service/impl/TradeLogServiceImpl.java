package com.gxzx.testrabbitmq.web.service.impl;

import com.gxzx.testrabbitmq.web.entity.TradeLog;
import com.gxzx.testrabbitmq.web.mapper.TradeLogMapper;
import com.gxzx.testrabbitmq.web.service.ITradeLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 交易日志表 服务实现类
 * </p>
 *
 * @author administrator
 * @since 2019-08-22
 */
@Service
public class TradeLogServiceImpl extends ServiceImpl<TradeLogMapper, TradeLog> implements ITradeLogService {

}
