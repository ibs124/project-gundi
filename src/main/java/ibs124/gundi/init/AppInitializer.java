package ibs124.gundi.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ibs124.gundi.config.PropertyConfig;

@Component
class AppInitializer implements CommandLineRunner {

    private final PropertyConfig propertyConfig;

    public AppInitializer(PropertyConfig propertyConfig) {
        this.propertyConfig = propertyConfig;
    }

    @Override
    public void run(String... args) throws Exception {

        IO.println(this.propertyConfig);
    }

}
