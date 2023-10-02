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
import jakarta.transaction.Transactional;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping
    @ResponseBody
    public ModelAndView index() {
        var productList = repository.findAll();
        return new ModelAndView("product/index", "productList", productList);
    }
    
    @GetMapping("/new")
    public ModelAndView register() {
        var newProduct = new Product();
        return new ModelAndView("product/form", "product", newProduct);
    }

    @PostMapping
    public ModelAndView save(Product product) {
        repository.save(product);
        return new ModelAndView("redirect:/products");
    }

    @GetMapping("/update/{id}")
    public ModelAndView alterar(@PathVariable("id") Product product) {
        return new ModelAndView("product/form", "product", product);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
