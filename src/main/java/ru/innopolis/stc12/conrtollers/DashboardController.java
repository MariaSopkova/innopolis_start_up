package ru.innopolis.stc12.conrtollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DashboardController {
  @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
  public String showLoginForm(
      @RequestParam(value = "error", required = false) String error,
      Model model) {
    model.addAttribute("loginError", error);
    return "dashboard";
  }
}
