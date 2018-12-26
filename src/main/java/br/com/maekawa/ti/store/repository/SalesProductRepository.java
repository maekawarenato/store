package br.com.maekawa.ti.store.repository;

import br.com.maekawa.ti.store.model.Sales;
import br.com.maekawa.ti.store.model.SalesProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesProductRepository extends JpaRepository<SalesProduct, Long> {
    public List<SalesProduct> findBySales(Sales sales);
}
