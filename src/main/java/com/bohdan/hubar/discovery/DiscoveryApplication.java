package com.bohdan.hubar.discovery;

import com.bohdan.hubar.discovery.client.Client;
import com.bohdan.hubar.discovery.client.ClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ClientService clientService){
		return args -> {
			Client client = new Client();
			client.setFirstName("Bohdan");
			client.setLastName("Hubar");
			client.setEmail("gubarbohdan@gmail.com");
			client.setPhone("+380936612126");
			clientService.createClient(client);
			System.out.println("CommandLineRunner running in the DiscoveryApplication class...");
		};
	}
}
