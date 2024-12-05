package com.example.elasticsearchtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.fasterxml.jackson.annotation.JacksonInject;
@SpringBootApplication
public class ElasticsearchTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElasticsearchTestApplication.class, args);
	}

}
