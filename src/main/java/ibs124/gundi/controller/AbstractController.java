package ibs124.gundi.controller;

import static ibs124.gundi.config.RouteConfig.CONTEXT_URL_FORMAT;
import static ibs124.gundi.config.RouteConfig.FORWARD_FORMAT;
import static ibs124.gundi.config.RouteConfig.REDIRECT_FORMAT;

import jakarta.servlet.http.HttpServletRequest;

public abstract class AbstractController {

    protected final String getContextUrl(HttpServletRequest request) {
        return String.format(CONTEXT_URL_FORMAT,
                request.getScheme(),
                request.getServerName(),
                request.getServerPort(),
                request.getContextPath());
    }

    protected String getRedirectUrl(String route) {
        return REDIRECT_FORMAT + route;
    }

    protected String getRedirectUrlHere(String route) {
        return route == null || route.length() < 1 ? REDIRECT_FORMAT : REDIRECT_FORMAT + route.substring(1);
    }

    protected String getForwardUrl(String route) {
        return FORWARD_FORMAT + route;
    }
}
