package FABSOFT20232.FABSOFT2023.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping
    @ResponseBody
    public String index() {
        return "Mãe eu nao acredito";
    }

//    @GetMapping
  //  public ModelAndView index() {
      //  return new ModelAndView("cliente/index");
    //}
}
