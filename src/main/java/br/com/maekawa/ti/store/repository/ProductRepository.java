package br.com.maekawa.ti.store.repository;

import br.com.maekawa.ti.store.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
