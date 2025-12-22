package com.timposulabs.mvc.crud.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PersonDTO {

    private Long id;

    @NotBlank
    @Size(min = 3, max = 30)
    private String firstName;
    
    @NotBlank
    @Size(min = 3, max = 30)
    private String lastName;

    @NotBlank
    @Email
    private String email;

    public PersonDTO() {
    }

    public PersonDTO(Long id, @NotBlank @Size(min = 3, max = 30) String firstName,
            @NotBlank @Size(min = 3, max = 30) String lastName, @NotBlank @Email String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }    

    @Override
    public String toString() {
        return "Id: " + getId() + ", firstName: " + getFirstName() + ", lastName: " + getLastName() + ", email: " + getEmail(); 
    }
}
