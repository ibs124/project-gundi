package ibs124.gundi.controller.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ibs124.gundi.config.RouteConfig;
import ibs124.gundi.config.thymeleaf.TemplateConfig;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping(RouteConfig.USERS_ME)
class UserMeController {
    
    @GetMapping
    public String meGet() {
        return TemplateConfig.USERS_ME;
    }
    
}
