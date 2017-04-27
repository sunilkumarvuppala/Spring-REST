
package com.sunil.api.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
@NamedQueries({
    @NamedQuery(name = "Employee.findAllEmployees", query = "SELECT e FROM Employee e"),    
    @NamedQuery(name = "Employee.findByEmail", query = "SELECT u FROM Employee u where u.email=:pEmail")
})
public class Employee implements Serializable{
    @Id
    private String id;
    private String name;
     @LazyCollection(LazyCollectionOption.FALSE)
     @OneToMany(cascade = CascadeType.ALL)
    private List<Address> addresses;
    
    @Column(unique = true)
    private String email;
    

    public Employee() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

     public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

 
    
}
