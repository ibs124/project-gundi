package ibs124.gundi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app")
public record PropertyConfig(
        String mailFrom,
        String mailDisplayName,
        boolean mailHtml,
        int tokenExpirationMinutes) {
}
