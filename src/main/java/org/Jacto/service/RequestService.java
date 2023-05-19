package org.Jacto.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.Jacto.model.RequestModel;
import org.Jacto.model.UserModel;
import org.Jacto.repositories.RequestRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@ApplicationScoped
public class RequestService {
    @Inject
    RequestRepository requestRepository;

    public List<RequestModel> findAll(){
        return requestRepository.findAll().list();
    }

    public void addRequest(RequestModel requestModel){requestRepository.persist(requestModel);}

    public Optional<RequestModel> findById(UUID id) {
        return requestRepository.findByIdOptional(id);
    }

    public void delete(RequestModel requestModel){
        requestRepository.delete(requestModel);
    }
}
