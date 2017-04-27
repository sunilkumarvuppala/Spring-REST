
package com.sunil.api.service;

import com.sunil.api.entity.Address;
import java.util.List;

public interface AddressService {
    
      public Address findAddress(String id);
    
    public Address createAddress(Address address);
    
    public Address updateAddress(String id, Address add);
    
    public void deleteAddress(String id);
}
