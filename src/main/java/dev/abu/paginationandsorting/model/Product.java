package dev.abu.paginationandsorting.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Product_table")
@Getter
@Setter

public class Product {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private  Long productId;
     private String productName;
     private double price;

    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }
    public Product(){

    }
}
