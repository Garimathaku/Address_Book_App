package com.uc.address_book_app.service;



import com.uc.address_book_app.model.Address;
import com.uc.address_book_app.repository.AddressRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service // Ensures Spring manages this class as a bean
public class AddressService {

    private final AddressRepository repository;

    public AddressService(AddressRepository repository) {
        this.repository = repository;
    }

    public List<Address> getAllAddresses() {
        List<Address> addresses = repository.findAll();
        System.out.println("Fetched Addresses: " + addresses); // Debugging Line
        return addresses;
    }
    public Address saveAddress(Address address) {
        return repository.save(address);
    }

    public Address getAddressById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteAddress(Long id) {
        repository.deleteById(id);
    }
}
