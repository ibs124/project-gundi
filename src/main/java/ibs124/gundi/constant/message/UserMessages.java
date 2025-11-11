package ibs124.gundi.constant.message;

public abstract class UserMessages {

    private static final String BLANK = "must not be blank!";

    private static final String USERNAME = "Username ";
    public static final String USERNAME_BLANK = USERNAME + BLANK;
    public static final String USERNAME_ERROR = USERNAME + """
            must be between 3 and 20 characters long.
            Only lowercased letters (a- z), numbers (0 - 9) and underscores (_) allowed.
            """;
}
