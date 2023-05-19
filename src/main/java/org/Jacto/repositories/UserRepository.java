package org.Jacto.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.Jacto.model.UserModel;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class UserRepository implements PanacheRepository<UserModel> {
    public Optional<UserModel> findByName(String name){
        return find("name", name).firstResultOptional();
    }
    public Optional<UserModel> findByIdOptional(UUID id) {
        return find("id", id).firstResultOptional();
    }


}
