package ibs124.gundi.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ibs124.gundi.config.RouteConfig;
import ibs124.gundi.config.thymeleaf.TemplateConfig;

@Controller
@RequestMapping(RouteConfig.LOGIN)
class LoginController {

    @GetMapping
    public String getMethodName() {
        return TemplateConfig.LOGIN;
    }

}
