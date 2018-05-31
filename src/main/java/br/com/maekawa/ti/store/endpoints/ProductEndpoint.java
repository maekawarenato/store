package br.com.maekawa.ti.store.endpoints;

import br.com.maekawa.ti.store.model.Product;
import br.com.maekawa.ti.store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.MediaTypes.HAL_JSON_VALUE;

import java.util.Optional;

@RestController
@RequestMapping(path = "/rs/product", produces = HAL_JSON_VALUE)
public class ProductEndpoint {

    private ProductRepository productRepository;

    @Autowired
    public ProductEndpoint(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

//    @GetMapping
//    public ResponseEntity<?> findAllProducts(final @RequestParam(name = "page", defaultValue = "0") int page,
//                                             final @RequestParam(name = "size", defaultValue = "10") int size,
//                                             ServerHttpRequest request){
//        return Optional.of(productRepository.findAll(PageRequest.of(page, size)))
//                .map(new ResourceBuilder<Page<Product>>(request)::build)
//                .map(ResponseEntity.ok()::body)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<?> findProduct(final @PathVariable(name = "id") Long id,
//                                             ServerHttpRequest request){
//        return productRepository.findById(id)
//                .map(new ResourceBuilder<Product>(request)::build)
//                .map(ResponseEntity.ok()::body)
//                .orElse(ResponseEntity.notFound().build());
//    }
}
