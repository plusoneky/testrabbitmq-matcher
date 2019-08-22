package com.gxzx.testrabbitmq.config.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
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
public class RabbitMQReceiverConfig {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	ProjectProperties projectProperties;
	
	@Autowired
	public ConnectionFactory connectionFactory;
	
	@Bean
	public FanoutExchange fanoutExchange() {
		String fanoutExchangeName = projectProperties.getSysProperties().getMqExchangeName();	
		return new FanoutExchange(fanoutExchangeName);
	}	
	
    @Bean
    public Queue queue(){
		Long dataCenterId = projectProperties.getSysProperties().getSnowflakeIdWorker().getDataCenterId();
		Long workMachineId = projectProperties.getSysProperties().getSnowflakeIdWorker().getWorkMachineId();
		String fanoutExchangeName = projectProperties.getSysProperties().getMqExchangeName();
		String queueName = fanoutExchangeName+"_"+dataCenterId+"_"+workMachineId;    	
        return new Queue(queueName, true, false, false);  //exlusive autoDelete含义： 消费者断开，队列自动销毁
    }
    
	@Bean
	public Binding bindingTradeOrderSuccExchange(Queue queue, FanoutExchange fanoutExchange) {
		return BindingBuilder.bind(queue).to(fanoutExchange);
	}
	
	@Bean
	public SimpleMessageListenerContainer matcherSuccMsgContainer() {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
		container.setQueues(queue());
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
