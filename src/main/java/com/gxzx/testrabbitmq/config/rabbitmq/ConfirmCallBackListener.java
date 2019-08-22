package com.gxzx.testrabbitmq.config.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * confirmcallback用来确认消息是否有送达消息队列
 * 登录RabbitMQ，下面命令将 eth0 网卡的传输设置为延迟5000毫秒发送，丢包率50%
 * tc qdisc add dev ens33 root netem delay 700ms loss 50%
 * tc qdisc del dev ens33 root netem
 */
public class ConfirmCallBackListener implements ConfirmCallback{

	private static final Logger logger = LoggerFactory.getLogger(ConfirmCallBackListener.class);
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Override
	public void confirm(CorrelationData correlationData, boolean ack, String cause) {
		
		if(ack){
        	logger.info("4. 消息id为: "+correlationData.getId()+"的消息，已经被ack成功");
        }else{
    		//将异常事件登记到预估值账户异常表（订单ID，金额，冷热账户ID，是否扣费，是否完成核对，创建时间，核对时间）。此情况需要进一步检查订单数据库，定时核对订单是否入库，确认没有入库时，执行回滚预估值账户。  
        	logger.info("4. 消息id为: "+correlationData.getId()+"的消息，消息nack，失败原因是："+cause);
        }		
	}


}
