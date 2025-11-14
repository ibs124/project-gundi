package ibs124.gundi.config.thymeleaf;

import static ibs124.gundi.config.RouteConfig.*;

import java.util.Map;

public abstract class AttributeConfig {

    public static final String EMAIL = "email";

    public static final String USERNAME = "username";

    public static final String SUCCESS = "success";

    public static final String VIEW_MODEL = "viewModel";

    public static final String BINDING_MODEL = "bindingModel";

    public static final String BINDING_RESULT = "org.springframework.validation.BindingResult."
            + BINDING_MODEL;

    public static final String ROUTES = "routes";

    public static final Map<String, String> ROUTES_MAP = Map.of(
            "index", INDEX,
            "register", REGISTER,
            "login", LOGIN,
            "logout", LOGOUT,
            "me", USERS_ME);
}
