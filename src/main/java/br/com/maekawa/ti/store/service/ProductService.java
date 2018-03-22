package br.com.maekawa.ti.store.service;


import br.com.maekawa.ti.store.model.Product;
import br.com.maekawa.ti.store.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ProductService {

    private ProductRepository repository;

    public ProductService(ProductRepository repository){
        this.repository = repository;
    }


    @Transactional
    public Product saveProduct(Long id, String code, String description){
        Product product = new Product();
        product.setId(id);
        product.setCode(code);
        product.setDescription(description);
        return repository.save(product);
    }
}
