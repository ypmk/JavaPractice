package org.example;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class Config {
    @Bean
    Hasher getHasher() {
        return new Hasher();
    }
}