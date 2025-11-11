package ibs124.gundi.constant;

public abstract class Regexes {

    public static final String USERNAME = "^(?:[a-z0-9_]{3,20})$";

    public static final String EMAIL = "^((?!\\.)[\\w\\-_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])$";
}
