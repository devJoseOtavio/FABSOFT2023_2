package FABSOFT20232.FABSOFT2023.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import FABSOFT20232.FABSOFT2023.model.Product;
import FABSOFT20232.FABSOFT2023.repository.ProductRepository;
import FABSOFT20232.FABSOFT2023.service.ProductService;
import jakarta.transaction.Transactional;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    @ResponseBody
    public ModelAndView index() {
        var productList = service.getAll();
        return new ModelAndView("product/index", "productList", productList);
    }
    
    @GetMapping("/new")
    public ModelAndView register() {
        var newProduct = new Product();
        return new ModelAndView("product/form", "product", newProduct);
    }

    @PostMapping
    public ModelAndView save(Product product) {
        service.save(product);
        return new ModelAndView("redirect:/products");
    }

    @GetMapping("/update/{id}")
    public ModelAndView alterar(@PathVariable("id") Product product) {
        return new ModelAndView("product/form", "product", product);
    }

    @GetMapping("/delete/{id}")
    @Transactional
    public ModelAndView delete(@PathVariable("id") Product product) {
        service.delete(product);
        return new ModelAndView("redirect:/products");
    }
}
