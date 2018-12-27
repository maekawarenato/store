package br.com.maekawa.ti.store.endpoints;

import br.com.maekawa.ti.store.endpoints.resource.SalesResource;
import br.com.maekawa.ti.store.endpoints.resource.SalesResourceAssembler;
import br.com.maekawa.ti.store.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.MediaTypes.HAL_JSON_VALUE;

@RestController
@RequestMapping(path = "/rs/sales", produces = HAL_JSON_VALUE)
public class SalesEndpoint {

    private SalesService service;
    private SalesResourceAssembler assembler;

    @Autowired
    public SalesEndpoint(SalesService service,
                         SalesResourceAssembler assembler) {
        this.service = service;
        this.assembler = assembler;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalesResource> findSale(final @PathVariable(name = "id") Long id){
        return service.findSales(id)
                .map(assembler::toResource)
                .map(ResponseEntity::ok)
                .orElse(null);
    }
}
