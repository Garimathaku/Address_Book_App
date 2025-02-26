package com.uc.address_book_app.service;




import com.uc.address_book_app.model.Address;
import com.uc.address_book_app.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository repository;

    public List<Address> getAllAddresses() {
        return repository.findAll();
    }

    public Optional<Address> getAddressById(Long id) {
        return repository.findById(id);
    }

    public Address saveAddress(Address address) {
        return repository.save(address);
    }

    public Address updateAddress(Long id, Address updatedData) {
        Optional<Address> optionalAddress = repository.findById(id);
        if (optionalAddress.isPresent()) {
            Address existingAddress = optionalAddress.get();
            existingAddress.setName(updatedData.getName());
            existingAddress.setStreet(updatedData.getStreet());
            existingAddress.setCity(updatedData.getCity());
            existingAddress.setState(updatedData.getState());
            existingAddress.setZipCode(updatedData.getZipCode());
            return repository.save(existingAddress);
        }
        return null;
    }

    public boolean deleteAddress(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
