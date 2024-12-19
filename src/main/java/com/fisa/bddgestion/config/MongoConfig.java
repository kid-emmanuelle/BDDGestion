package com.fisa.bddgestion.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.fisa.bddgestion.repository")
public class MongoConfig {
    // La configuration est maintenant gérée par application.properties
}