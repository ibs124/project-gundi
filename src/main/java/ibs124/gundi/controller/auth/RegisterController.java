package ibs124.gundi.controller.auth;

import static ibs124.gundi.config.RouteConfig.REGISTER;
import static ibs124.gundi.config.RouteConfig.SUCCESS;
import static ibs124.gundi.config.thymeleaf.AttributeConfig.BINDING_MODEL;
import static ibs124.gundi.config.thymeleaf.AttributeConfig.BINDING_RESULT;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import ibs124.gundi.config.thymeleaf.TemplateConfig;
import ibs124.gundi.controller.AbstractController;
import ibs124.gundi.event.UserVerificationEvent;
import ibs124.gundi.mapper.UserMapper;
import ibs124.gundi.model.api.RegisterRequest;
import ibs124.gundi.model.service.RegisterResponseDto;
import ibs124.gundi.service.auth.RegisterService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(REGISTER)
public class RegisterController extends AbstractController {

    private final RegisterService registerService;
    private final UserMapper userMapper;
    private final ApplicationEventPublisher eventPublisher;

    public RegisterController(
            RegisterService registerService,
            UserMapper userMapper,
            ApplicationEventPublisher eventPublisher) {
        this.registerService = registerService;
        this.userMapper = userMapper;
        this.eventPublisher = eventPublisher;
    }

    @GetMapping
    public String registerGet(Model model) {
        if (!model.containsAttribute(BINDING_MODEL)) {
            model.addAttribute(BINDING_MODEL,
                    new RegisterRequest(null, null, null, null));
        }

        return TemplateConfig.REGISTER;
    }

    @PostMapping
    public String registerPost(
            @Valid RegisterRequest bindingModel,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes,
            HttpServletRequest httpServletRequest) {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute(BINDING_MODEL, bindingModel)
                    .addFlashAttribute(BINDING_RESULT, bindingResult);
            return super.getRedirectUrl(REGISTER);
        }

        RegisterResponseDto result = this.registerService
                .register(this.userMapper.toServiceModel(bindingModel));

        UserVerificationEvent event = new UserVerificationEvent(
                result.verificationToken(),
                result.email(),
                super.getContextUrl(httpServletRequest));

        this.eventPublisher.publishEvent(event);

        return super.getRedirectUrl(REGISTER + SUCCESS);
    }

    @GetMapping(SUCCESS)
    public String registerSuccess() {
        return TemplateConfig.REGISTER_SUCCESS;
    }
}
