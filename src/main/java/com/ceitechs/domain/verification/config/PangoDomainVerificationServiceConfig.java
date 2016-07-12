package com.ceitechs.domain.verification.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author iddymagohe
 * @since 0.1
 *
 */
@Configuration
@Import({MongoConfiguration.class})
//@ComponentScan(basePackages = {"com.ceitechs.domain.verification"})
// @PropertySource(value = { "classpath:application.properties" })
public class PangoDomainVerificationServiceConfig {

    /**
     * Property placeholder configurer needed to process @Value annotations
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
