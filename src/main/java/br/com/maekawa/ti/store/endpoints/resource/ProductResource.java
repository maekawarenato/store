package br.com.maekawa.ti.store.endpoints.resource;

import br.com.maekawa.ti.store.model.Product;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
@JsonPropertyOrder({
        "id",
        "code",
        "description"
})
@Relation(value = "product", collectionRelation = "products")
public class ProductResource extends ResourceSupport {

    @JsonProperty("id")
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
