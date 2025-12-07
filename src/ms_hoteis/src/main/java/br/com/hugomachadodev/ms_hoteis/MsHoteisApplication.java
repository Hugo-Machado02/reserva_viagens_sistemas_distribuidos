package br.com.hugomachadodev.ms_hoteis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsHoteisApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsHoteisApplication.class, args);
    }
}
