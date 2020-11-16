package com.project.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class BoardApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(BoardApplication.class);
	}

	public static void main(String[] args) {
		//SpringApplication.run(BoardApplication.class, args);
		SpringApplication app = new SpringApplication(BoardApplication.class);
		app.run(args);
	}

}
