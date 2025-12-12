package ibs124.gundi.config;

public abstract class MessageConfig {

    public static final String BLANK_FIELD = "This field is required.";

    public static final String USER_NOT_FOUND = "User not found";

    public static final String USER_EMAIL_ERROR = "Invalid email address.";

    public static final String USER_EMAIL_TAKEN = "Email already taken.";

    public static final String USER_PASSWORD_ERROR = "Password must be at least 6 characters long.";

    public static final String USER_USERNAME_ERROR = """
            Username must be between 3 and 20 characters long,
            it can only use letters, numbers and underscores.
            """;

    public static final String USER_USERNAME_TAKEN = "Username already taken.";

    public static final String USER_FULL_NAME_ERROR = "Invalid full name.";
}
