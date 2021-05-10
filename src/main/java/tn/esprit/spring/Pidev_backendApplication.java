package tn.esprit.spring;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootApplication
public class Pidev_backendApplication {

	public static void main(String[] args) {
		SpringApplication.run(Pidev_backendApplication.class, args);
	}
	
	@Bean
    public JavaMailSender javaMailSender() { 
    	JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    	mailSender.setHost("smtp.gmail.com");
    	mailSender.setPort(587);
    	mailSender.setUsername("tarek.messaoudi.1996@gmail.com");
    	mailSender.setPassword("curvanord123kingzoogataga");
    	Properties props = mailSender.getJavaMailProperties();
    	props.put("mail.transport.protocol", "smtp");
    	props.put("mail.smtp.auth", "true");
    	props.put("mail.smtp.starttls.enable", "true");
    	props.put("mail.debug", "true");
    	return mailSender;
    }

}
