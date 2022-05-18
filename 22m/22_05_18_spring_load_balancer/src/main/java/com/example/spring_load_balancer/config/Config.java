package com.example.spring_load_balancer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class Config {

    @Bean
    public Executor threadExecutor() {
        return new SimpleAsyncTaskExecutor();
    }
}
