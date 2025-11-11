package ibs124.gundi.controller;

public abstract class AbstractController {

    private final String redirect = "redirect:";
    private final String forward = "forward:";

    protected String getRedirectUrl(String route) {
        return redirect + route;
    }

    protected String getRedirectUrlHere(String route) {
        return route == null || route.length() < 1 ? redirect : redirect + route.substring(1);
    }

    protected String getForwardUrl(String route) {
        return forward + route;
    }
}
