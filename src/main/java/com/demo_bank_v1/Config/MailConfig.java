package com.demo_bank_v1.Config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class MailConfig {
	
	 @Bean
	    public static JavaMailSenderImpl getMailConfig(){
	        JavaMailSenderImpl emailConfig = new JavaMailSenderImpl();

	        // Set Properties:
	        Properties props = emailConfig.getJavaMailProperties();
	        props.put("mail.transport.protocol", "smtp");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.debug", "true");

	        // Set Mail Credentials:
	        emailConfig.setHost("localhost");
	        emailConfig.setPort(587);
	        emailConfig.setUsername("manju@gutkajatka.com");
	        emailConfig.setPassword("manju@123");

	        return emailConfig;
	    }
	

}
