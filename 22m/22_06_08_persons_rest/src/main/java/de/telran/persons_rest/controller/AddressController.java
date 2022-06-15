package de.telran.persons_rest.controller;

import de.telran.persons_rest.dto.AddressDto;
import de.telran.persons_rest.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    /**
     * Get the Address by id
     */
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public AddressDto get(@PathVariable Integer id) {
        return addressService.get(id);
    }

    /**
     * Greate a new Address
     */
    @PostMapping
    public AddressDto create(@RequestBody AddressDto addressDto) {
        return addressService.create(addressDto);
    }

    @PutMapping
    public void edit(@RequestBody AddressDto addressDto) {
        addressService.edit(addressDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        addressService.remove(id);
    }

    @GetMapping
    public List<AddressDto> getAll(@RequestParam(required = false) Optional<Integer> personId) {
        return addressService.getAllByPersonId(personId);
    }

}
