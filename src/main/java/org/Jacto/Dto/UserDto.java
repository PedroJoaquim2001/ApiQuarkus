package org.Jacto.Dto;

import jakarta.validation.constraints.NotBlank;
import org.Jacto.model.UserModel;
import org.hibernate.validator.constraints.Length;

public class UserDto {
    @NotBlank(message="Name may not be blank")
    @Length(min = 1,max = 35, message ="name must have a min of 1 and max 35 characters")
    private String name;
    @NotBlank(message="E-Mail may not be blank")
    @Length(min = 1,max = 35, message ="E-mail must have a min of 1 and max 50 characters")
    private String eMail;
    @NotBlank(message="Sector may not be blank")
    private double sector;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public double getSector() {
        return sector;
    }

    public void setSector(double sector) {
        this.sector = sector;
    }

    public UserModel convert(){
        return new UserModel(name, eMail, sector);
    }
}
