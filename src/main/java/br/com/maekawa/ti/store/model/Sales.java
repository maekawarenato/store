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

    @JsonProperty("discount")
    @Column(name = "SALES_DISCOUNT", nullable = false)
    private Double discount;

    @JsonProperty("datSales")
    @Column(name = "SALES_DATE", nullable = false)
    private Date datSales;

    @OneToMany(cascade = CascadeType.ALL)
//    @Embedded
    private List<SalesProduct> salesProductList;

    public Long getId() {
        return id;
    }

    public Double getDiscount() {
        return discount;
    }

    public Date getDatSales() {
        return datSales;
    }

    public List<SalesProduct> getSalesProductList() {
        return salesProductList;
    }

    public void setSalesProductList(List<SalesProduct> salesProductList) {
        this.salesProductList = salesProductList;
    }

    public Sales() {
    }

    private Sales(Builder builder){
        this.id = builder.id;
        this.discount = builder.discount;
        this.datSales = builder.datSales;
        this.salesProductList = builder.salesProductList;

    }

    public static final class Builder {
        private Long id;
        private Double discount;
        private Date datSales;
        private List<SalesProduct> salesProductList;

        public Builder setId(Long id) {
            this.id = id;
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

        public Builder setSalesProductList(List<SalesProduct> salesProductList) {
            this.salesProductList = salesProductList;
            return this;
        }

        public Sales build(){
            return new Sales(this);
        }

    }
}
