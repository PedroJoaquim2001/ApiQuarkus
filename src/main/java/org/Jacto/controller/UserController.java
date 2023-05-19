package org.Jacto.controller;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.Jacto.Dto.UserDto;
import org.Jacto.model.UserModel;
import org.Jacto.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Path("user")
public class UserController {
    @Inject
    UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserModel> getUser(){
        List<UserModel> userModelList = new ArrayList<>();
        try{
            userModelList = userService.findAll();

        }catch(Exception e){
            e.printStackTrace();
        }
        return userModelList;
    }

    @POST
    @Transactional
    public void addUser(UserDto userDto){
        UserModel userModel = userDto.convert();
        userService.addUser(userModel);
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Response update(@PathParam("id") UUID id, UserDto userDto) {
        Optional<UserModel> userModelOptional = userService.findById(id);

        if (!userModelOptional.isPresent()) {
            return Response.ok("User not find").type(MediaType.APPLICATION_JSON_TYPE).build();
        }

        userService.delete(userModelOptional.get());

        UserModel userModel = userDto.convert();

        userService.addUser(userModel);

        return Response.ok(userModel).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response deleteUser(@PathParam("id") UUID id){
        Optional<UserModel> userModelOptional = userService.findById(id);

        if (!userModelOptional.isPresent()) {
            return Response.ok("User not find").type(MediaType.APPLICATION_JSON_TYPE).build();
        }

        userService.delete(userModelOptional.get());

        return Response.ok("User Deleted").type(MediaType.APPLICATION_JSON_TYPE).build();
    }
    
}
