package com.sutek.reactivefunctionalhello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.sutek.reactivefunctionalhello.hello.GreetingClient;

@SpringBootApplication
public class ReactiveFunctionalHelloApplication {

	public static void main(String[] args) {
		// SpringApplication.run(ReactiveFunctionalHelloApplication.class, args);

		ConfigurableApplicationContext context = SpringApplication.run(ReactiveFunctionalHelloApplication.class, args);
		GreetingClient greetingClient = context.getBean(GreetingClient.class);
		// We need to block for the content here or the JVM might exit before the message is logged
		System.out.println(">> message = " + greetingClient.getMessage().block());
	}

}
