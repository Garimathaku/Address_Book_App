package com.uc.address_book_app.model;



import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@Table(name = "address2")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String mobileNumber;


    // Constructors
    public Address() {}

    public Address(String name, String address, String city, String state, String zipCode,String mobileNumber) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.mobileNumber=mobileNumber;
    }


}