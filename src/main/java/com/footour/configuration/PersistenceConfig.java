package com.footour.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "com.footour.persistence.entities")
@EnableJpaRepositories(basePackages = {"com.footour.persistence.repositories"})
public class PersistenceConfig {
}
