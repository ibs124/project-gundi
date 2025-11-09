package ibs124.gundi.controller.auth;

import static ibs124.gundi.constant.thymeleaf.Attributes.BINDING_MODEL;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ibs124.gundi.constant.Routes;
import ibs124.gundi.constant.Templates;
import ibs124.gundi.model.api.RegisterBindingModel;

@Controller
public class RegisterController {

    @GetMapping(Routes.REGISTER)
    public String registerGet(Model model) {
        if (!model.containsAttribute(BINDING_MODEL)) {
            model.addAttribute(BINDING_MODEL,
                    new RegisterBindingModel(null, null, null, null));
        }

        return Templates.REGISTER;
    }

}
