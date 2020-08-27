package com.example.kafkademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaDemoApplication {

	private final KafkaTemplate<String, Object> kafkaTemplate;

	KafkaDemoApplication(KafkaTemplate<String, Object> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
		Student student = new Student();
		kafkaTemplate.send("example", student);
	}

	public static void main(String[] args) {
		SpringApplication.run(KafkaDemoApplication.class, args);
	}

	private static class Student {
		public int id = 123;
		public String firstName = "Koren";
		public String lastName = "Gershoni";
	}
}
