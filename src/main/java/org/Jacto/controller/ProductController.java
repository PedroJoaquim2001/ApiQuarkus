package org.Jacto.controller;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.Jacto.Dto.ProductDto;
import org.Jacto.Dto.UserDto;
import org.Jacto.model.ProductModel;
import org.Jacto.model.UserModel;
import org.Jacto.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Path("product")
public class ProductController {
    @Inject
    ProductService productService;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductModel> getUser(){
        List<ProductModel> productModelList = new ArrayList<>();
        try{
            productModelList = productService.findAll();

        }catch(Exception e){
            e.printStackTrace();
        }
        return productModelList;
    }

    @POST
    @Transactional
    public void addUser(ProductDto productDto){
        ProductModel productModel = productDto.convert();
        productService.addProduct(productModel);
    }
    @PUT
    @Path("{id}")
    @Transactional
    public Response update(@PathParam("id") UUID id, ProductDto productDto) {
        Optional<ProductModel> productModelOptional = productService.findById(id);

        if (!productModelOptional.isPresent()) {
            return Response.ok("Product not find").type(MediaType.APPLICATION_JSON_TYPE).build();
        }

        productService.delete(productModelOptional.get());

        ProductModel productModel = productDto.convert();

        productService.addProduct(productModel);

        return Response.ok(productModel).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response deleteUser(@PathParam("id") UUID id){
        Optional<ProductModel> productModelOptional = productService.findById(id);

        if (!productModelOptional.isPresent()) {
            return Response.ok("Product not find").type(MediaType.APPLICATION_JSON_TYPE).build();
        }

        productService.delete(productModelOptional.get());

        return Response.ok("Product Deleted").type(MediaType.APPLICATION_JSON_TYPE).build();
    }
}
