package org.Jacto.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.Jacto.model.RequestModel;

import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class RequestRepository implements PanacheRepository<RequestModel> {
    public Optional<RequestModel> findByIdOptional(UUID id) {
        return find("id", id).firstResultOptional();
    }
}
