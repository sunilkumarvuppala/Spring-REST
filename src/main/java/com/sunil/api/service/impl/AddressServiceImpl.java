
package com.sunil.api.service.impl;

import com.sunil.api.entity.Address;
import com.sunil.api.exception.NotFoundException;
import com.sunil.api.respository.AddressRepository;
import com.sunil.api.service.AddressService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddressServiceImpl implements AddressService{

    private AddressRepository repository;
    
    public AddressServiceImpl (AddressRepository repository){
        this.repository = repository;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Address findAddress(String id) {
                Address addressExisting = repository.findAddress(id);
        if(addressExisting == null){
            throw new NotFoundException("Address with id: " + id + " does not exist");
        }
        return repository.findAddress(id);
    }

    @Override
    @Transactional
    public Address createAddress(Address address) {
        return repository.createAddress(address);
    }

    @Override
    @Transactional
    public Address updateAddress(String id, Address add) {
        return repository.updateAddress(id, add);
    }

    @Override
    @Transactional
    public void deleteAddress(String id) {
                Address addressExisting = repository.findAddress(id);
        if(addressExisting == null){
            throw new NotFoundException("Address with id: " + id + " does not exist");
        }
        repository.deleteAddress(addressExisting);
    }
    
}
