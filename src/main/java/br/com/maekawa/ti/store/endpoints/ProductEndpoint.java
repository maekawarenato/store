package br.com.maekawa.ti.store.endpoints;

import br.com.maekawa.ti.store.endpoints.resource.ProductResource;
import br.com.maekawa.ti.store.endpoints.resource.ProductResourceAssembler;
import br.com.maekawa.ti.store.model.Product;
import br.com.maekawa.ti.store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.MediaTypes.HAL_JSON_VALUE;

@RestController
@RequestMapping(path = "/rs/products", produces = HAL_JSON_VALUE)
public class ProductEndpoint {

    private ProductRepository productRepository;
    private ProductResourceAssembler productResourceAssembler;

    @Autowired
    public ProductEndpoint(ProductRepository productRepository,
                           ProductResourceAssembler productResourceAssembler){
        this.productRepository = productRepository;
        this.productResourceAssembler = productResourceAssembler;
    }

    @GetMapping
    public ResponseEntity<List<ProductResource>> findAllProducts(){

        return Optional.ofNullable(productRepository.findAll())
                .map(productResourceAssembler::toResources)
                .map(ResponseEntity.ok()::body)
                .orElse(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResource> findProduct(final @PathVariable(name = "id") Long id){
        return productRepository.findById(id)
                .map(productResourceAssembler::toResource)
                .map(ResponseEntity::ok)
                .orElse(null);
    }

    @PostMapping
    public ResponseEntity<ProductResource> saveProduct(final @RequestBody ProductResource productResource){

        Product product = new Product.Builder()
                                .setDescription(productResource.getDescription())
                                .setPrice(productResource.getPrice())
                                .setCode(productResource.getCode())
                                .build();

        return Optional.of(productRepository.save(product))
                .map(productResourceAssembler::toResource)
                .map(ResponseEntity::ok)
                .orElseThrow(RuntimeException::new);


    }
}
