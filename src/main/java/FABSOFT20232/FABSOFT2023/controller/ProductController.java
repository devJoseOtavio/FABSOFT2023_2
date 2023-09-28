package FABSOFT20232.FABSOFT2023.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import FABSOFT20232.FABSOFT2023.repository.ProductRepository;

@Controller
@RequestMapping
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping
    @ResponseBody
    public ModelAndView index() {
        var productList = repository.findAll();
        return new ModelAndView("produto/index", "productList", productList);
    }
    
}
