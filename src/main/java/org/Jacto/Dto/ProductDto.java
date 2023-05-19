package org.Jacto.Dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import org.Jacto.model.ProductModel;
import org.Jacto.model.enums.CropStatus;
import org.hibernate.validator.constraints.Length;

public class ProductDto {
    @NotBlank(message="Name may not be blank")
    @Length(min = 1,max = 50, message ="name must have a min of 1 and max 50 characters")
    private String name;
    @NotBlank(message="Description may not be blank")
    private String description;
    @NotBlank(message="Crop may not be blank ")
    private CropStatus crop;
    @NotBlank(message="Size Area may not be blank")
    @Digits(integer = 12,fraction = 2, message ="numbers must be like like this 1230.00")
    private double sizeArea;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CropStatus getCrop() {
        return crop;
    }

    public void setCrop(CropStatus crop) {
        this.crop = crop;
    }

    public double getSizeArea() {
        return sizeArea;
    }

    public void setSizeArea(double sizeArea) {
        this.sizeArea = sizeArea;
    }

    public ProductModel convert(){
        return new ProductModel(name, description, crop, sizeArea);
    }
}
