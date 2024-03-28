package dev.abu.paginationandsorting.service;

import dev.abu.paginationandsorting.model.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IProductService {

    Page<Product> getProducts(Integer pageSize ,Integer pageNumber,String sort);

    List<Product> addProducts();
}
