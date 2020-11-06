package com.sam.rodiumsale.repos;

import com.sam.rodiumsale.models.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepo extends CrudRepository<Product, Long> {

}
