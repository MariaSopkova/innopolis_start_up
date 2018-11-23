package ru.innopolis.stc12.conrtollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
import java.util.function.Predicate;

@Controller
public class ErrorMessageController {
    String path = "errors/error-";
    private Environment environment;
    private boolean isProd;

    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
        isProd = Arrays.stream(environment.getActiveProfiles()).anyMatch(Predicate.isEqual("prod"));
    }

    @RequestMapping(value = "/401", method = RequestMethod.GET)
    public String error401(Model model) {
        return path + "401";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String error403(Model model) {
        return path + "403";
    }

    @RequestMapping(value = "/404", method = RequestMethod.GET)
    public String error404(Model model) {
        return path + "404";
    }

    @RequestMapping(value = "/410", method = RequestMethod.GET)
    public String error410(Model model) {
        return path + "410";
    }

    @RequestMapping(value = "/500", method = RequestMethod.GET)
    public String error500(Model model) {
        model.addAttribute("showError", !isProd);
        return path + "500";
    }

    @RequestMapping(value = "/503", method = RequestMethod.GET)
    public String error503(Model model) {
        return path + "503";
    }
}
