package ibs124.gundi.config.thymeleaf;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ibs124.gundi.config.RouteConfig;

public abstract class AttributeConfig {

    public static final String EMAIL = "email";

    public static final String USERNAME = "username";

    public static final String SUCCESS = "success";

    public static final String VIEW_MODEL = "viewModel";

    public static final String BINDING_MODEL = "bindingModel";

    public static final String BINDING_RESULT = "org.springframework.validation.BindingResult."
            + BINDING_MODEL;

    public static final String ROUTES = "routes";

    public static final Map<String, String> ROUTES_MAP;

    static {
        ROUTES_MAP = Stream
                .of(RouteConfig.class.getDeclaredFields())
                .filter(f -> Modifier.isPublic(f.getModifiers()))
                .filter(f -> Modifier.isStatic(f.getModifiers()))
                .filter(f -> Modifier.isFinal(f.getModifiers()))
                .filter(f -> f.getType().equals(String.class))
                .collect(Collectors.toUnmodifiableMap(
                        Field::getName,
                        field -> {
                            try {
                                return (String) field.get(null);
                            } catch (IllegalAccessException e) {
                                throw new RuntimeException(e);
                            }
                        }));
    }
}
