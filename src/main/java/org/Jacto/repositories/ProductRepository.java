package org.Jacto.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.Jacto.model.ProductModel;

import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class ProductRepository implements PanacheRepository<ProductModel> {
    public Optional<ProductModel> findByName(String name){
        return find("name", name).firstResultOptional();}


    public Optional<ProductModel> findByIdOptional(UUID id) {
        return find("id", id).firstResultOptional();
    }
}
