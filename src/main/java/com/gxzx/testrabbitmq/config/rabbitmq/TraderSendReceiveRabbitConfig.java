package com.gxzx.testrabbitmq.config.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gxzx.testrabbitmq.config.properties.ProjectProperties;

@Configuration
public class TraderSendReceiveRabbitConfig {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ObjectMapper objectMapper;
	
	
	@Autowired
	ProjectProperties projectProperties;
	
	@Autowired
	public ConnectionFactory connectionFactory;
	
	@Bean
	public SimpleMessageListenerContainer matcherSuccMsgContainer() {
		Long dataCenterId = projectProperties.getSysProperties().getSnowflakeIdWorker().getDataCenterId();
		Long workMachineId = projectProperties.getSysProperties().getSnowflakeIdWorker().getWorkMachineId();
		String mqExchangeName = projectProperties.getSysProperties().getMqExchangeName();
		String queueName = mqExchangeName+"_"+dataCenterId+"_"+workMachineId;
		logger.info("rabbitmq listener queueName="+queueName);
		
		Queue queue= new Queue(queueName, true, true, true);
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
		container.setQueues(queue);
		container.setExposeListenerChannel(true);
		container.setMaxConcurrentConsumers(1);
		container.setConcurrentConsumers(1);
		container.setAcknowledgeMode(AcknowledgeMode.AUTO);            //设置确认模式为自动确认
		container.setMessageListener(new ChannelAwareMessageListener() {
			public void onMessage(Message message, com.rabbitmq.client.Channel channel) throws Exception {
				logger.info("matcherSuccMsgContainer 消费端接收到消息: getDeliveryTag="+message.getMessageProperties().getDeliveryTag()+",Priority="+message.getMessageProperties().getPriority() +", routingKey="+message.getMessageProperties().getReceivedRoutingKey()+",Properties="+message.getMessageProperties() + ", message=" + new String(message.getBody()));
			}
		});
		return container;
	}
	
}
