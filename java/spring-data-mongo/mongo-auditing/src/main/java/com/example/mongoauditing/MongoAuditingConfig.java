package com.example.mongoauditing;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@Configuration
@EnableMongoAuditing
public class MongoAuditingConfig {

  @Bean
  public AuditorAware<String> customAuditorAware() {
    return new CustomAuditorAwareImpl();
  }
}
