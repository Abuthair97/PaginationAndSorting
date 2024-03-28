package dev.abu.paginationandsorting.repository;

import dev.abu.paginationandsorting.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepo extends JpaRepository<Product,Long> {

}
