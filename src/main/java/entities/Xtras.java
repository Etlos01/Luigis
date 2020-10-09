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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ckfol
 */
@Entity
@Table(name = "xtras")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Xtras.findAll", query = "SELECT x FROM Xtras x"),
    @NamedQuery(name = "Xtras.findById", query = "SELECT x FROM Xtras x WHERE x.id = :id"),
    @NamedQuery(name = "Xtras.findByName", query = "SELECT x FROM Xtras x WHERE x.name = :name"),
    @NamedQuery(name = "Xtras.findByPrice", query = "SELECT x FROM Xtras x WHERE x.price = :price"),
    @NamedQuery(name = "Xtras.findByCategory", query = "SELECT x FROM Xtras x WHERE x.category = :category")})
public class Xtras implements Serializable {

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
    @Column(name = "category")
    private String category;
    @ManyToMany(mappedBy = "xtrasList")
    private List<OrderLine> orderLineList;

    public Xtras() {
    }

    public Xtras(Integer id) {
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
        if (!(object instanceof Xtras)) {
            return false;
        }
        Xtras other = (Xtras) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Xtras[ id=" + id + " ]";
    }
    
}
