package org.Jacto.Dto;

import jakarta.inject.Inject;
import jakarta.validation.constraints.NotBlank;
import org.Jacto.model.ProductModel;
import org.Jacto.model.RequestModel;
import org.Jacto.model.UserModel;
import org.Jacto.repositories.ProductRepository;
import org.Jacto.service.ProductService;
import org.Jacto.service.UserService;
import org.hibernate.validator.constraints.Length;

import java.util.Optional;
import java.util.UUID;

public class RequestDto {
    @Inject
    UserService userService;
    @Inject
    ProductService productService;
    private UUID userId;
    @NotBlank(message="E-Mail may not be blank")
    @Length(min = 1,max = 50, message ="E-mail must have a min of 1 and max 50 characters")
    private String eMail;
    @NotBlank(message="Phone may not be blank")
    private Long phone;
    private UUID productId;



    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }
    public RequestModel convert(){
        Optional<UserModel> userModel = userService.findById(userId);
        Optional<ProductModel> productModel = productService.findById(productId);

        return new RequestModel(userModel.get(), eMail, phone, productModel.get());
    }
}
