package kg.akoikelov.springmvcapp.config;

import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmptyMigrationStrategyConfig {

    @Bean
    public FlywayMigrationStrategy flywayMigrationStrategy() {
        return flyway -> {
            if (System.getenv("RUN_FLY_WAY").equals("1")){
                  flyway.migrate();}
        };
    }}
