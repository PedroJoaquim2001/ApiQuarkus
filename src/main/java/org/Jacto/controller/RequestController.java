package org.Jacto.controller;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.Jacto.Dto.RequestDto;
import org.Jacto.model.RequestModel;
import org.Jacto.service.RequestService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Path("request")
public class RequestController {
    @Inject
    RequestService requestService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<RequestModel> getUser(){
        List<RequestModel> requestModelList = new ArrayList<>();
        try{
            requestModelList = requestService.findAll();

        }catch(Exception e){
            e.printStackTrace();
        }
        return requestModelList;
    }

    @POST
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void addUser(RequestDto requestDto){
        RequestModel requestModel = requestDto.convert();
        requestService.addRequest(requestModel);
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Response update(@PathParam("id") UUID id, RequestDto requestDto) {
        Optional<RequestModel> requestModelOptional = requestService.findById(id);

        if (!requestModelOptional.isPresent()) {
            return Response.ok("Request not find").type(MediaType.APPLICATION_JSON_TYPE).build();
        }

        requestService.delete(requestModelOptional.get());

        RequestModel requestModel = requestDto.convert();

        requestService.addRequest(requestModel);

        return Response.ok(requestDto).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response deleteUser(@PathParam("id") UUID id){
        Optional<RequestModel> requestModelOptional = requestService.findById(id);

        if (!requestModelOptional.isPresent()) {
            return Response.ok("Request not find").type(MediaType.APPLICATION_JSON_TYPE).build();
        }

        requestService.delete(requestModelOptional.get());

        return Response.ok("Request Deleted").type(MediaType.APPLICATION_JSON_TYPE).build();
    }
}
