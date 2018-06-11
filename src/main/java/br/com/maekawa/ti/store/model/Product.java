package br.com.maekawa.ti.store.model;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable {

    @JsonProperty("id")
    @Id
    @SequenceGenerator(name = "product-primary", sequenceName = "SQ_PRODUCT_IDT", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product-primary")
    @Column(name = "IDT_PRODUCT", nullable = false)
    private Long id;

    @JsonProperty("code")
    @Column(name = "COD_PRODUCT", nullable = false)
    private String code;

    @JsonProperty("description")
    @Column(name = "DES_PRODUCT", nullable = false)
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product(){}

    private Product(Builder builder){
        this.id = builder.id;
        this.code = builder.code;
        this.description = builder.description;
    }

    public static final class Builder{

        private Long id;
        private String code;
        private String description;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setCode(String code) {
            this.code = code;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Product build(){ return new Product(this);}
    }
}
