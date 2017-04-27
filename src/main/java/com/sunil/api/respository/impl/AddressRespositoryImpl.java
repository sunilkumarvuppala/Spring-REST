
package com.sunil.api.respository.impl;

import com.sunil.api.entity.Address;
import com.sunil.api.respository.AddressRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class AddressRespositoryImpl implements AddressRepository{

    
        @PersistenceContext
    private EntityManager em;

    @Override
    public Address findAddress(String id) {
        return em.find(Address.class, id);
    }

    @Override
    public Address createAddress(Address address) {
        em.persist(address);
        return address;
    }

    @Override
    public Address updateAddress(String id, Address add) {
        return em.merge(add);
    }

    @Override
    public void deleteAddress(Address add) {
        em.remove(add);
    }

     
}
