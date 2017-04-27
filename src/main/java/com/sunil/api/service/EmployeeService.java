
package com.sunil.api.service;

import com.sunil.api.entity.Address;
import com.sunil.api.entity.Employee;
import java.util.List;


public interface EmployeeService {
   
    public List<Employee> findAllEmployees();
    
    public Employee findEmployee(String id);
    
    public Employee createEmployee(Employee emp);
    
    public Employee updateEmployee(String id, Employee emp);
    
    public void deleteEmployee(String id);
}
