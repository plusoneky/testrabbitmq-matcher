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
		//exlusive autoDelete含义： 消费者断开，队列自动销毁。从机重启后，重新同步买卖深度时，在订阅队列时，可以有两种细节方案：
		//1、MQ队列永久方式，那么从机按照主机当前的最新委托单ID是否相等为准，加载主机的深度，抛弃掉主机ID之前的委托
		//2、MQ队列自动销毁方式，从机启动与MQ重新建立队列后，接受委托，如果是未同步状态则返回NACK，重新入队，并记录下委托时间和ID。
		//向主机发送同步深度请求，如果主机返回的ID和委托时间小于从机队列消费的委托ID时间，则隔一段时间后，继续发送同步请求，直到委托时间大于从机的委托时间3分钟后，开始同步。按照主机当前的最新委托单ID的时间戳，如果时间戳小于当前时间，则从机
        //综合考虑，方案1更适合
		return new Queue(queueName, true, false, false);  
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
		container.setAcknowledgeMode(AcknowledgeMode.NONE);            //设置确认模式为自动确认
		container.setMessageListener(new ChannelAwareMessageListener() {
			public void onMessage(Message message, com.rabbitmq.client.Channel channel) throws Exception {
				logger.info("matcherSuccMsgContainer 消费端接收到消息: getDeliveryTag="+message.getMessageProperties().getDeliveryTag()+",Priority="+message.getMessageProperties().getPriority() +", routingKey="+message.getMessageProperties().getReceivedRoutingKey()+",Properties="+message.getMessageProperties() + ", message=" + new String(message.getBody()));
			}
		});
		return container;
	}
	
}
