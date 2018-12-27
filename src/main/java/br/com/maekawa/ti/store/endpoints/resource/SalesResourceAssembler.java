package br.com.maekawa.ti.store.endpoints.resource;

import br.com.maekawa.ti.store.endpoints.SalesEndpoint;
import br.com.maekawa.ti.store.model.Sales;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class SalesResourceAssembler extends ResourceAssemblerSupport<Sales, SalesResource> {

    public SalesResourceAssembler() {
        super(SalesEndpoint.class, SalesResource.class);
    }

    @Override
    protected SalesResource instantiateResource(Sales entity) {
        SalesResource resource = new SalesResource(entity);
        resource.add(linkTo(methodOn(SalesEndpoint.class).findSale(entity.getId())).withSelfRel());
        return resource;
    }

    @Override
    public SalesResource toResource(Sales sales) {
        return instantiateResource(sales);
    }
}
