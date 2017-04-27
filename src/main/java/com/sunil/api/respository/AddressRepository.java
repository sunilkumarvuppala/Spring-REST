/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sunil.api.respository;

import com.sunil.api.entity.Address;
import java.util.List;

/**
 *
 * @author SUNIL VUPPALA
 */
public interface AddressRepository {

    public Address findAddress(String id);
    
    public  Address createAddress(Address address);
    
    public Address updateAddress(String id,Address add);
    
    public void deleteAddress(Address add);
}
