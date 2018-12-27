package br.com.maekawa.ti.store.endpoints.resource;

import br.com.maekawa.ti.store.model.Sales;
import br.com.maekawa.ti.store.model.SalesProduct;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

import java.util.Date;
import java.util.List;

@Relation(value = "sale", collectionRelation = "sales")
@JsonPropertyOrder({"salesId",
        "discount",
        "datSales",
        "productList"})
public class SalesResource extends ResourceSupport {

    @JsonProperty("salesId")
    private Long id;
    private List<SalesProduct> productList;
    private Double discount;
    private Date datSales;

    public SalesResource() {}

    public SalesResource(Sales sales) {
        this.id = sales.getId();
        this.discount = sales.getDiscount();
        this.datSales = sales.getDatSales();
        this.productList = sales.getSalesProductList();
    }

    public List<SalesProduct> getProductList() {
        return productList;
    }

    public void setProductList(List<SalesProduct> productList) {
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
