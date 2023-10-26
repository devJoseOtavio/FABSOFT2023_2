package FABSOFT20232.FABSOFT2023.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
import FABSOFT20232.FABSOFT2023.service.ValidateProductService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    // @Autowired
    // private ValidateProductService validateService;

    @GetMapping
    @ResponseBody
    public ModelAndView index() {
        var productList = service.getAll();
        return new ModelAndView("product/index", "productList", productList);
    }
    
    @GetMapping("/new")
    public ModelAndView register() {
        var newProduct = new Product();
        // validateService.validateSave(newProduct);
        return new ModelAndView("product/form", "product", newProduct);
    }

    @PostMapping
    public ModelAndView save(@Valid Product product, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            HashMap<String,Object> newProduct = new HashMap<>();
            var productList = service.getAll();
            newProduct.put("product", product);
            newProduct.put("productList", productList);
            return new ModelAndView("product/form", "product", newProduct);
        }

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
