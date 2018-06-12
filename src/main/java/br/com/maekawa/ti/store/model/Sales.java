package br.com.maekawa.ti.store.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "SALES")
public class Sales implements Serializable {

    @JsonProperty("id")
    @Id
    @SequenceGenerator(name = "sales-primary", sequenceName = "SQ_SALES_IDT", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sales-primary")
    @Column(name = "IDT_SALES", nullable = false)
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "SALES_PRODUCT",
                joinColumns = { @JoinColumn(name = "IDT_PRODUCT")},
                inverseJoinColumns = { @JoinColumn(name = "IDT_SALES") })
    private List<Product> productList;

    @JsonProperty("discount")
    @Column(name = "SALES_DISCOUNT", nullable = false)
    private Double discount;

    @JsonProperty("datSales")
    @Column(name = "SALES_DATE", nullable = false)
    private Date datSales;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Date getDatSales() {
        return datSales;
    }

    public void setDatSales(Date datSales) {
        this.datSales = datSales;
    }

        public Double getSalesValue(){
        return productList.stream()
                .map(product -> product.getPrice())
                .mapToDouble(Double::doubleValue).sum() - discount;
    }

    public Sales() {
    }

    private Sales(Builder builder){
        this.id = builder.id;
        this.productList = builder.productList;
        this.discount = builder.discount;
        this.datSales = builder.datSales;

    }

    public static final class Builder {
        private Long id;
        private List<Product> productList;
        private Double discount;
        private Date datSales;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setProductList(List<Product> productList) {
            this.productList = productList;
            return this;
        }

        public Builder setDiscount(Double discount) {
            this.discount = discount;
            return this;
        }

        public Builder setDatSales(Date datSales) {
            this.datSales = datSales;
            return this;
        }
    }
}
