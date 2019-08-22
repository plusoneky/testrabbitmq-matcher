package com.gxzx.testrabbitmq.config.properties;

/**
 * DEMO业务配置参数
 */
public class SysProperties {


	private SnowflakeIdWorker snowflakeIdWorker;

	
	private String mqExchangeName;


	public SnowflakeIdWorker getSnowflakeIdWorker() {
		return snowflakeIdWorker;
	}


	public void setSnowflakeIdWorker(SnowflakeIdWorker snowflakeIdWorker) {
		this.snowflakeIdWorker = snowflakeIdWorker;
	}


	public String getMqExchangeName() {
		return mqExchangeName;
	}


	public void setMqExchangeName(String mqExchangeName) {
		this.mqExchangeName = mqExchangeName;
	}
	
	
}
