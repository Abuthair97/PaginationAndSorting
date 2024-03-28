package dev.abu.paginationandsorting.service;

import dev.abu.paginationandsorting.model.Product;
import dev.abu.paginationandsorting.repository.IProductRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService
{

    private IProductRepo productRepo ;
    public ProductServiceImpl(IProductRepo productRepo){
        this.productRepo = productRepo;
    }
    @Override
    public Page<Product> getProducts(Integer pageSize ,Integer pageNumber,String sort) {
        Pageable pageable  = null;
        if ( sort != null){
            pageable = PageRequest.of(pageNumber,pageSize, Sort.Direction.ASC,sort);
        }
        else{
            pageable = PageRequest.of(pageNumber,pageSize);
        }
        return productRepo.findAll(pageable);
    }

    @Override
    public List<Product> addProducts() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("mac", 200));
        productList.add(new Product("iphone", 700));
        productList.add(new Product("ipad", 500));
        productList.add(new Product("apple watch", 400));
        productList.add(new Product("airpods", 150));
        productList.add(new Product("macbook air", 900));
        productList.add(new Product("macbook pro", 1300));
        productList.add(new Product("imac", 1500));
        productList.add(new Product("apple tv", 200));
        productList.add(new Product("magic mouse", 80));
        productList.add(new Product("magic keyboard", 100));
        productList.add(new Product("ipod touch", 200));
        productList.add(new Product("homepod", 300));
        productList.add(new Product("beats headphones", 250));
        productList.add(new Product("apple pencil", 100));
        productList.add(new Product("thunderbolt display", 1000));
        productList.add(new Product("mac mini", 700));
        productList.add(new Product("airport express", 100));
        productList.add(new Product("airport extreme", 200));
        productList.add(new Product("time capsule", 300));

        productRepo.saveAll(productList);

        return productList;
    }
}
