package com.jwt.model;
 
import java.io.Serializable;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.jboss.logging.annotations.Message;
 
@Entity
@Table(name = "EMP_TBL")
public class Employee implements Serializable {
 
    private static final long serialVersionUID = -3465813074586302847L;
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
 
    @Column
    @NotEmpty
    private String name;
 
    @Column
    @Email
    private String email;
 
    @Column
    private String address;
 
    @Column
    @Size(min=5,max=10)
    private String telephone;
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
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
 
    public String getAddress() {
        return address;
    }
 
    public void setAddress(String address) {
        this.address = address;
    }
 
    public String getTelephone() {
        return telephone;
    }
 
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
 
}