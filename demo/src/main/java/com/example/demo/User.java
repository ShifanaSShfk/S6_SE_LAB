package com.example.demo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

    @Entity
    @Table(name="`user`")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Email is mandatory")
    private String email;

    // // phone
    // @NotBlank(message = "Phone Number is Mandatory")
    // private String phone;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    // // phone
    // public String getphone() {
    //     return phone;
    // }

    // public void setphone(String phone) {
    //     this.phone = phone;
    // }
    

    // standard constructors / setters / getters / toString

    public User() {
    }

    // phone
    public User(long id, @NotBlank(message = "Name is mandatory") String name,
            @NotBlank(message = "Email is mandatory") String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        //this.phone = phone;
    }

    

    // phone
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
    }
}

