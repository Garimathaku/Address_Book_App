package com.uc.address_book_app.model;



import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@Table(name = "address1")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String street;
    private String city;
    private String state;
    private String zipCode;

    // Constructors
    public Address() {}

    public Address(String name, String street, String city, String state, String zipCode) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }


}
