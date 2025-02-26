package com.uc.address_book_app.controller;




import com.uc.address_book_app.model.Address;
import com.uc.address_book_app.service.AddressService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/addresses")
@CrossOrigin(origins = "*")
public class AddressController {

    private final AddressService service;

    //  Explicit Constructor (Ensures Proper Bean Injection)
    public AddressController(AddressService service) {
        this.service = service;
    }

    @GetMapping
    public List<Address> getAll() {
        return service.getAllAddresses();
    }

    @GetMapping("/{id}")
    public Address getById(@PathVariable Long id) {
        return service.getAddressById(id);
    }

    @PostMapping
    public Address save(@RequestBody Address address) {
        return service.saveAddress(address);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteAddress(id);
    }
}
