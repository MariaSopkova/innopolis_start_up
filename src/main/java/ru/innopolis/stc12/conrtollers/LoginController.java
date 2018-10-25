package ru.innopolis.stc12.conrtollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String showLoginForm(
      @RequestParam(value = "error", required = false) String error,
      Model model) {
    model.addAttribute("loginError", error);
    return "login";
  }

  @RequestMapping(value = "/registration", method = RequestMethod.GET)
  public String showRegistrationForm(
      @RequestParam(value = "error", required = false) String error,
      Model model) {
    model.addAttribute("registrationError", error);
    return "registration";
  }
}
