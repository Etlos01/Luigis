/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ckfol
 */
@Entity
@Table(name = "food_items")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FoodItems.findAll", query = "SELECT f FROM FoodItems f"),
    @NamedQuery(name = "FoodItems.findById", query = "SELECT f FROM FoodItems f WHERE f.id = :id"),
    @NamedQuery(name = "FoodItems.findByName", query = "SELECT f FROM FoodItems f WHERE f.name = :name"),
    @NamedQuery(name = "FoodItems.findByPrice", query = "SELECT f FROM FoodItems f WHERE f.price = :price"),
    @NamedQuery(name = "FoodItems.findByNumber", query = "SELECT f FROM FoodItems f WHERE f.number = :number")})
public class FoodItems implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Integer price;
    @Size(max = 45)
    @Column(name = "number")
    private String number;
    @OneToMany(mappedBy = "fId")
    private List<OrderLine> orderLineList;

    public FoodItems() {
    }

    public FoodItems(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @XmlTransient
    public List<OrderLine> getOrderLineList() {
        return orderLineList;
    }

    public void setOrderLineList(List<OrderLine> orderLineList) {
        this.orderLineList = orderLineList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FoodItems)) {
            return false;
        }
        FoodItems other = (FoodItems) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.FoodItems[ id=" + id + " ]";
    }
    
}
