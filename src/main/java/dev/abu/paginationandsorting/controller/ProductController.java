package dev.abu.paginationandsorting.controller;


import dev.abu.paginationandsorting.model.Product;
import dev.abu.paginationandsorting.service.IProductService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {


    private IProductService iProductService;

    public ProductController(IProductService iProductService) {
        this.iProductService = iProductService;
    }

    @GetMapping("/")
    List<Product> addProducts() {
        return iProductService.addProducts();
    }

    @GetMapping("/products/{pageSize}/{pageNumber}")
    public List<Product> getProductsByPage(@PathVariable("pageSize") Integer pageSize, @PathVariable("pageNumber") Integer pageNumber) {
        Page<Product> productPage = iProductService.getProducts(pageSize, pageNumber, null);
        return productPage.getContent();
    }

    @GetMapping("/productsByPrice/{pageSize}/{pageNumber}")
    public List<Product> getProductsByPageSortedByPrice(@PathVariable("pageSize") Integer pageSize, @PathVariable("pageNumber") Integer pageNumber) {
        Page<Product> productPage = iProductService.getProducts(pageSize, pageNumber, "price");
        return productPage.getContent();
    }
}