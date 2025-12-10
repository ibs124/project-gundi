package ibs124.gundi.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ibs124.gundi.config.PropertyConfig;
import ibs124.gundi.config.thymeleaf.AttributeConfig;

@Component
class AppInitializer implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(AppInitializer.class);

    private final PropertyConfig propertyConfig;

    public AppInitializer(PropertyConfig propertyConfig) {
        this.propertyConfig = propertyConfig;
    }

    @Override
    public void run(String... args) {

        log.info("{}", propertyConfig);

        log.info("{}", AttributeConfig.ROUTES_MAP);
    }

}
