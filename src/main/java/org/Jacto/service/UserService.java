package org.Jacto.service;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.Jacto.model.UserModel;
import org.Jacto.repositories.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class UserService {
    @Inject
    UserRepository userRepository;

    public List<UserModel> findAll(){
        return userRepository.findAll().list();
    }

    public void addUser(UserModel userModel){
        userRepository.persist(userModel);
    }

    public Optional<UserModel> findByName(String name){
        return userRepository.findByName(name);
    }

    public Optional<UserModel> findById(UUID id){return userRepository.findByIdOptional(id);}
    public void delete(UserModel userModel){
        userRepository.delete(userModel);
    }

}
