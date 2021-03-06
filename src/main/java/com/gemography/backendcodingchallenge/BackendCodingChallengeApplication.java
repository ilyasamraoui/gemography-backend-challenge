package com.gemography.backendcodingchallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BackendCodingChallengeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendCodingChallengeApplication.class, args);
    }

}
