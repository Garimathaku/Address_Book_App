package com.uc.address_book_app.service;


import com.uc.address_book_app.dto.AddressDTO;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class AddressService {

    private final Map<Long, AddressDTO> addressBook = new ConcurrentHashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    // Get All Addresses
    public List<AddressDTO> getAllAddresses() {
        return new ArrayList<>(addressBook.values());
    }

    // Get Address By ID
    public Optional<AddressDTO> getAddressById(Long id) {
        return Optional.ofNullable(addressBook.get(id));
    }

    // Save New Address
    public AddressDTO saveAddress(AddressDTO dto) {
        long id = idCounter.getAndIncrement();
        dto.setId(id);
        addressBook.put(id, dto);
        return dto;
    }

    // Update Address
    public AddressDTO updateAddress(Long id, AddressDTO updatedData) {
        if (addressBook.containsKey(id)) {
            updatedData.setId(id);
            addressBook.put(id, updatedData);
            return updatedData;
        }
        return null;
    }

    // Delete Address
    public boolean deleteAddress(Long id) {
        return addressBook.remove(id) != null;
    }
}
