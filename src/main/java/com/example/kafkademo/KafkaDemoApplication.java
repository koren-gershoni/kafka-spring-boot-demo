package com.example.kafkademo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaDemoApplication implements CommandLineRunner {

	private final KafkaTemplate<String, Object> kafkaTemplate;

	KafkaDemoApplication(KafkaTemplate<String, Object> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(KafkaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		kafkaTemplate.send("example", new Student());
	}

	private static class Student {
		public int id = 12345;
		public String firstName = "John";
		public String lastName = "Doe";
	}
}
