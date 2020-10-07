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
    private String fName;
    private String lName;
    private int phone;
    private String street;
    private int zip;
    private String city;
    
    public CustomerDTO(Customer c) {
        this.fName = c.getFirstName();
        this.lName = c.getLastName();
        this.phone = c.getPhone();
        this.id = c.getId();
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

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
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
