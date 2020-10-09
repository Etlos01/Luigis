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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ckfol
 */
@Entity
@Table(name = "order_line")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderLine.findAll", query = "SELECT o FROM OrderLine o"),
    @NamedQuery(name = "OrderLine.findById", query = "SELECT o FROM OrderLine o WHERE o.id = :id"),
    @NamedQuery(name = "OrderLine.findByQuantity", query = "SELECT o FROM OrderLine o WHERE o.quantity = :quantity")})
public class OrderLine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "quantity")
    private Integer quantity;
    @JoinTable(name = "xtras_on_item", joinColumns = {
        @JoinColumn(name = "ol_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "x_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Xtras> xtrasList;
    @JoinColumn(name = "f_id", referencedColumnName = "id")
    @ManyToOne
    private FoodItems fId;
    @JoinColumn(name = "o_id", referencedColumnName = "id")
    @ManyToOne
    private Orders oId;

    public OrderLine() {
    }

    public OrderLine(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @XmlTransient
    public List<Xtras> getXtrasList() {
        return xtrasList;
    }

    public void setXtrasList(List<Xtras> xtrasList) {
        this.xtrasList = xtrasList;
    }

    public FoodItems getFId() {
        return fId;
    }

    public void setFId(FoodItems fId) {
        this.fId = fId;
    }

    public Orders getOId() {
        return oId;
    }

    public void setOId(Orders oId) {
        this.oId = oId;
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
        if (!(object instanceof OrderLine)) {
            return false;
        }
        OrderLine other = (OrderLine) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.OrderLine[ id=" + id + " ]";
    }
    
}
