package org.Jacto.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.Jacto.model.enums.CropStatus;

import java.util.UUID;

@Entity
public class ProductModel extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String description;
    private CropStatus crop;
    private double sizeArea;

    public ProductModel(){}

    public ProductModel(String name, String description, CropStatus crop, double sizeArea) {
        this.name = name;
        this.description = description;
        this.crop = crop;
        this.sizeArea = sizeArea;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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
}
