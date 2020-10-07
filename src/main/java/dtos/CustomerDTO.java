/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;
import entities.Customer;

/**
 *
 * @author Nyxis
 */
public class CustomerDTO {
    private int id;
    private String name;
    private int phone;
    private String street;
    private int zip;
    private String city;
    private String email;
    
    
    public CustomerDTO(Customer c) {
        this.name = c.getName();
        this.phone = c.getPhone();
        this.id = c.getId();
        this.email = c.getEmail();
        this.street = c.getAddress().getStreet();
        this.zip = c.getAddress().getZip();
        this.city = c.getAddress().getCity();
    }
    
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
}
