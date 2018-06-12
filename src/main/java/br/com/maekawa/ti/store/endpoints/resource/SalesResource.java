package br.com.maekawa.ti.store.endpoints.resource;

import br.com.maekawa.ti.store.model.Product;
import br.com.maekawa.ti.store.model.Sales;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

import java.util.Date;
import java.util.List;

@Relation(value = "sale", collectionRelation = "sales")
public class SalesResource extends ResourceSupport {

    @JsonProperty("id")
    private Long id;
    private List<Product> productList;
    private Double discount;
    private Date datSales;

    public SalesResource() {};

    public SalesResource(Sales sales) {
        this.id = sales.getId();
        this.productList = sales.getProductList();
        this.discount = sales.getDiscount();
        this.datSales = sales.getDatSales();
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
}
