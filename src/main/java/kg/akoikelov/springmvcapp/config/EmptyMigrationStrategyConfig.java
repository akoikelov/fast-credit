package kg.akoikelov.springmvcapp.config;

import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class EmptyMigrationStrategyConfig {

    @Bean
    public FlywayMigrationStrategy flywayMigrationStrategy() {
        return flyway -> {
            String RunFlyWay = System.getenv("RUN_FLY_WAY");
            if (RunFlyWay != null && RunFlyWay.equals("1")) {
                flyway.migrate();
            }


        };
    }
}
