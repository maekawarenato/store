package br.com.maekawa.ti.store.endpoints.resource;

import br.com.maekawa.ti.store.endpoints.ProductEndpoint;
import br.com.maekawa.ti.store.model.Product;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class ProductResourceAssembler  extends ResourceAssemblerSupport<Product, ProductResource> {

    public ProductResourceAssembler() {
        super(ProductEndpoint.class, ProductResource.class);
    }

    @Override
    protected ProductResource instantiateResource(Product entity) {
        ProductResource resource = new ProductResource(entity);
        resource.add(linkTo(methodOn(ProductEndpoint.class).findProduct(entity.getId())).withSelfRel());
        return resource;
    }

    @Override
    public ProductResource toResource(Product product) {
        return instantiateResource(product);
    }
}
