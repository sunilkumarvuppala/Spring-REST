
package com.sunil.api.service.impl;

import com.sunil.api.entity.Address;
import com.sunil.api.entity.Employee;
import com.sunil.api.exception.BadRequestException;
import com.sunil.api.exception.NotFoundException;
import com.sunil.api.respository.EmployeeRepository;
import com.sunil.api.service.AddressService;
import com.sunil.api.service.EmployeeService;
import java.util.List;
import javax.persistence.OneToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    
    private EmployeeRepository repository;
    
    private AddressService addressService;
    
    public EmployeeServiceImpl(EmployeeRepository repository, AddressService addressService){
        this.repository=repository;
        this.addressService=addressService;
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Employee> findAllEmployees() {
        return repository.findAllEmployees();
    }

    @Override
    @Transactional(readOnly = true)
    public Employee findEmployee(String id) {
        Employee employeeExisting = repository.findEmployee(id);
        if(employeeExisting == null){
            throw new NotFoundException("Employee with id: " + id + " does not exist");
        }
        return repository.findEmployee(id);
    }

    @Override
    @Transactional
    public Employee createEmployee(Employee emp) {
        Employee employeeExisting = repository.findByEmail(emp.getEmail());
        if(employeeExisting != null){
            throw new BadRequestException("Employee with email: " + emp.getEmail() + " already exist");
        }
        List<Address> addresses = emp.getAddresses();
        for(Address add : addresses){
            addressService.createAddress(add);
            
        }
        emp.setAddresses(addresses);
        return repository.createEmployee(emp);
    }

    @Override
    @Transactional
    public Employee updateEmployee(String id, Employee emp) {
        Employee employeeExisting = repository.findByEmail(emp.getEmail());
        if(employeeExisting == null){
            throw new NotFoundException("Employee with id: " + id + " does not exist");
        }
        return repository.updateEmployee(id, emp);
    }

    @Override
    @Transactional
    public void deleteEmployee(String id) {
        Employee employeeExisting = repository.findByEmail(id);
        if(employeeExisting == null){
            throw new NotFoundException("Employee with id: " + id + " does not exist");
        }
        repository.deleteEmployee(employeeExisting);
    }

    
}
