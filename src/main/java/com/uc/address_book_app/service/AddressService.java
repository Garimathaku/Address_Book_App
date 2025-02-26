package com.uc.address_book_app.service;

import com.uc.address_book_app.dto.AddressDTO;
import com.uc.address_book_app.model.Address;
import com.uc.address_book_app.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressService {

    @Autowired
    private AddressRepository repository; // Inject Repository

    // Convert Model to DTO
    private AddressDTO convertToDTO(Address address) {
        return new AddressDTO(address.getId(), address.getName(), address.getCity(), address.getState());
    }

    // Convert DTO to Model
    private Address convertToModel(AddressDTO dto) {
        Address address = new Address();
        address.setId(dto.getId());
        address.setName(dto.getName());
        address.setCity(dto.getCity());
        address.setState(dto.getState());
        return address;
    }

    // Get All Addresses
    public List<AddressDTO> getAllAddresses() {
        return repository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // Get Address By ID
    public Optional<AddressDTO> getAddressById(Long id) {
        return repository.findById(id).map(this::convertToDTO);
    }

    // Save New Address
    public AddressDTO saveAddress(AddressDTO dto) {
        Address savedAddress = repository.save(convertToModel(dto));
        return convertToDTO(savedAddress);
    }

    // Update Address
    public AddressDTO updateAddress(Long id, AddressDTO updatedData) {
        Optional<Address> optionalAddress = repository.findById(id);
        if (optionalAddress.isPresent()) {
            Address existingAddress = optionalAddress.get();
            existingAddress.setName(updatedData.getName());
            existingAddress.setCity(updatedData.getCity());
            existingAddress.setState(updatedData.getState());
            Address updatedAddress = repository.save(existingAddress);
            return convertToDTO(updatedAddress);
        }
        return null;
    }

    // Delete Address
    public boolean deleteAddress(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
