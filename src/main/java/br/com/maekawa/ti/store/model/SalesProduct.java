package br.com.maekawa.ti.store.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SALES_PRODUCT")
public class SalesProduct implements Serializable {

    @JsonProperty("id")
    @Id
    @SequenceGenerator(name = "sales-product-primary", sequenceName = "SQ_SALES_PRODUCT_IDT", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sales-product-primary")
    @Column(name = "IDT_SALES_PRODUCT", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "IDT_PRODUCT")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "IDT_SALES")
    private Sales sales;

    @Column(name = "AMOUNT", nullable = false)
    private Long amount;

    public SalesProduct(Builder builder) {
        this.id = builder.id;
        this.product = builder.product;
        this.sales = builder.sales;
        this.amount = builder.amount;
    }

    public SalesProduct(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Sales getSales() {
        return sales;
    }

    public void setSales(Sales sales) {
        this.sales = sales;
    }

    public static final class Builder{
        private Long id;
        private Product product;
        private Sales sales;
        private Long amount;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setProduct(Product product) {
            this.product = product;
            return this;
        }

        public Builder setSales(Sales sales) {
            this.sales = sales;
            return this;
        }

        public Builder setAmaunt(Long amount) {
            this.amount = amount;
            return this;
        }

        public SalesProduct build(){
            return new SalesProduct(this);
        }
    }
}
