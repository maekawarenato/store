package br.com.maekawa.ti.store.endpoints.resource;

import br.com.maekawa.ti.store.model.Product;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class ProductResourceAssembler  extends ResourceAssemblerSupport<Product, ProductResource> {


    public ProductResourceAssembler(Class<?> controllerClass, Class<ProductResource> resourceType) {
        super(controllerClass, resourceType);
    }

    @Override
    public ProductResource toResource(Product product) {
        return null;
    }
}
