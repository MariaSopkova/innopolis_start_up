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
    private static final String PATH = "errors/error-";
    private boolean isProd;

    @Autowired
    public void setEnvironment(Environment environment) {
        isProd = Arrays.stream(environment.getActiveProfiles()).anyMatch(Predicate.isEqual("prod"));
    }

    @RequestMapping(value = "/401")
    public String error401(Model model) {
        return PATH + "401";
    }

    @RequestMapping(value = "/403")
    public String error403(Model model) {
        return PATH + "403";
    }

    @RequestMapping(value = "/404")
    public String error404(Model model) {
        return PATH + "404";
    }

    @RequestMapping(value = "/410")
    public String error410(Model model) {
        return PATH + "410";
    }

    @RequestMapping(value = "/500")
    public String error500(Model model) {
        model.addAttribute("showError", !isProd);
        return PATH + "500";
    }

    @RequestMapping(value = "/503")
    public String error503(Model model) {
        return PATH + "503";
    }
}
