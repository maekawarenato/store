package br.com.maekawa.ti.store.endpoints;

import br.com.maekawa.ti.store.endpoints.resource.ResourceBuilder;
import br.com.maekawa.ti.store.model.Product;
import br.com.maekawa.ti.store.repository.ProductRepository;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@Endpoint(id = "/rs/pruduct")
public class ProductEndpoint {

    private ProductRepository productRepository;

    @ReadOperation
    public ResponseEntity<?> findAllProducts(ServerHttpRequest request){
        return Optional.of(productRepository.findAll())
                .map(new ResourceBuilder<Product>(request)::build)
                .map(ResponseEntity.ok()::body)
                .orElse(ResponseEntity.notFound().build());
    }
}
