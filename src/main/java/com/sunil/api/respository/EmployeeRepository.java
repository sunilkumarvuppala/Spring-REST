/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sunil.api.respository;

import com.sunil.api.entity.Employee;
import java.util.List;

/**
 *
 * @author SUNIL VUPPALA
 */
public interface EmployeeRepository {
    public List<Employee> findAllEmployees();
    
    public Employee findEmployee(String id);
    
    public Employee findByEmail(String email);
    
    public Employee createEmployee(Employee emp);
    
    public Employee updateEmployee(String id, Employee emp);
    
    public void deleteEmployee(Employee emp);
}
