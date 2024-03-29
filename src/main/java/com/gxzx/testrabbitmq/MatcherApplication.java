package com.gxzx.testrabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;



@SpringBootApplication
@Configuration
public class MatcherApplication {
	public final static Logger logger = LoggerFactory.getLogger(MatcherApplication.class);
    public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(MatcherApplication.class);
		springApplication.setBannerMode(Banner.Mode.CONSOLE); 
		springApplication.run(args);
	}
    
}
