package br.com.maekawa.ti.store.repository;

import br.com.maekawa.ti.store.model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {
}
