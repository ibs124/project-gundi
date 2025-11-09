package ibs124.gundi.controller;

public abstract class AbstractController {
    private static final String REDIRECT = "redirect:";
    private static final String FORWARD = "forward:";

    protected String redirect(String route) {
        return REDIRECT + route;
    }

    protected String forward(String route) {
        return FORWARD + route;
    }
}
