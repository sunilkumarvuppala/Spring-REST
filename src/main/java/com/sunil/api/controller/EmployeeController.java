
package com.sunil.api.controller;

import com.sunil.api.constants.URI;
import com.sunil.api.entity.Employee;
import com.sunil.api.service.AddressService;
import com.sunil.api.service.EmployeeService;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = URI.EMPLOYEES)
public class EmployeeController {
    
    private EmployeeService employeeService;

    
    public EmployeeController(EmployeeService service){
        this.employeeService = service;
            }
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Employee> findAllEmployees(){
        return employeeService.findAllEmployees();
    }
    
    @RequestMapping(method = RequestMethod.GET, value = URI.ID)
    public Employee findEmployee(@PathVariable("id") String id){
        return employeeService.findEmployee(id);
    }
    
     @RequestMapping(method = RequestMethod.POST)
    public Employee createEmployee(@RequestBody Employee emp){
        return employeeService.createEmployee(emp);
    }
    @RequestMapping(method = RequestMethod.POST, value = URI.ID)
    public Employee updateEmployee(@PathVariable("id") String id,@RequestBody Employee emp){
        return employeeService.updateEmployee(id, emp);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = URI.ID)
    public void deleteEmployee(@PathVariable("id") String id){
        employeeService.deleteEmployee(id);
    }
}
