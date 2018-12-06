package ru.innopolis.stc12.conrtollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.innopolis.stc12.security.Actions;
import ru.innopolis.stc12.security.SecurityUtils;
import ru.innopolis.stc12.service.UserService;

@Controller
public class DashboardController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Secured(Actions.USER_DASHBOARD_VIEW)
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashboard(Model model) {
        model.addAttribute("user", userService.getUserByLogin(SecurityUtils.getAuthenticatedUsername()));
        return "dashboard";
    }
}
