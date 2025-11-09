package ibs124.gundi.controller;

public abstract class AbstractController {
    private static final String REDIRECT = "redirect:";
    private static final String FORWARD = "forward:";

    protected String getRedirectUrl(String route) {
        return REDIRECT + route;
    }

    protected String getRedirectUrlHere(String route) {
        return route == null || route.length() < 1 ? REDIRECT : REDIRECT + route.substring(1);
    }

    protected String getForwardUrl(String route) {
        return FORWARD + route;
    }
}
