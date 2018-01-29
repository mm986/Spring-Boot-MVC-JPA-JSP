package com.mm.springbootmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration;

@SpringBootApplication(exclude=ActiveMQAutoConfiguration.class) 
public class SpringbootSpringmvcJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSpringmvcJpaApplication.class, args);
	}
}
