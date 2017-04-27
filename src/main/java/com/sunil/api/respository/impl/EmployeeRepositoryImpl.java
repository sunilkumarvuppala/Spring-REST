
package com.sunil.api.respository.impl;

import com.sunil.api.entity.Employee;

import com.sunil.api.respository.EmployeeRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public List<Employee> findAllEmployees() {
        TypedQuery<Employee> query = em.createNamedQuery("Employee.findAllEmployees", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee findEmployee(String id) {
        return em.find(Employee.class, id);
    }

    @Override
    public Employee findByEmail(String email) {
        TypedQuery<Employee> query = em.createNamedQuery("Employee.findByEmail", Employee.class);
        query.setParameter("pEmail", email);
        List<Employee> employees = query.getResultList();
        if (!(employees.isEmpty())) {
            return employees.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Employee createEmployee(Employee emp) {
        em.persist(emp);
        return emp;
    }

    @Override
    public Employee updateEmployee(String id, Employee emp) {
        return em.merge(emp);
    }

    @Override
    public void deleteEmployee(Employee emp) {
        em.remove(emp);
    }
    
}
