package com.cts.pm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.pm.entities.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
