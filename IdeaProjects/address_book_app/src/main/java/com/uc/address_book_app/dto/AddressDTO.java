package com.uc.address_book_app.dto;





public class AddressDTO {
    private Long id;
    private String name;
    private String city;
    private String state;
    private String mobileNumber;

    public AddressDTO() {}

    public AddressDTO(Long id, String name, String city, String state,String mobileNumber) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.state = state;
        this.mobileNumber=mobileNumber;

    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getState() { return state; }
    public void setState(String state) {
        this.state = state; }

    public String getMobileNumber() { return mobileNumber; }
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber; }


}