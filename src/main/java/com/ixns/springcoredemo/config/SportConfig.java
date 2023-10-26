package com.ixns.springcoredemo.config;

import com.ixns.springcoredemo.domain.Coach;
import com.ixns.springcoredemo.domain.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
