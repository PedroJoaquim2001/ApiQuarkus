package org.Jacto.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.Jacto.model.ProductModel;
import org.Jacto.model.UserModel;
import org.Jacto.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class ProductService {
    @Inject
    ProductRepository productRepository;

    public List<ProductModel> findAll(){
        return productRepository.findAll().list();
    }

    public void addProduct(ProductModel productModel){
        productRepository.persist(productModel);
    }

    public Optional<ProductModel> findByName(String name){
        return productRepository.findByName(name);
    }

    public Optional<ProductModel> findById(UUID id){return productRepository.findByIdOptional(id);}

    public void delete(ProductModel productModel){
        productRepository.delete(productModel);
    }
}
