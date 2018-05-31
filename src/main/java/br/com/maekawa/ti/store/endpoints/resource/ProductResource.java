package br.com.maekawa.ti.store.endpoints.resource;

import br.com.maekawa.ti.store.model.Product;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

@Relation(value = "product", collectionRelation = "products")
public class ProductResource extends ResourceSupport {

    private Long id;
    private String code;
    private String description;

    public ProductResource(){}

    public ProductResource(Product product) {
        this.id = product.getId();
        this.code = product.getCode();
        this.description = product.getDescription();
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
}
