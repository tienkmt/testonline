package com.web.service.impl;

import com.web.model.Product;
import com.web.repository.ProductRepository;
import com.web.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;

    @Override
	public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
	public void updateProduct(Product product) {
        productRepository.save(product);
    }

    @Override
	public void removeProductById(long id) {
        productRepository.deleteById(id);
    }

    @Override
	public Optional<Product> getProductById(long id) {
        return productRepository.findById(id);
    }

    @Override
	public List<Product> getAllProductByCategoryId(int id) {
        return productRepository.findAllByCategory_Id(id);
    }

}
