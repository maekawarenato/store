package br.com.maekawa.ti.store.service;

import br.com.maekawa.ti.store.model.Sales;
import br.com.maekawa.ti.store.repository.SalesProductRepository;
import br.com.maekawa.ti.store.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SalesService {

    private SalesRepository salesRepository;
    private SalesProductRepository salesProductRepository;

    @Autowired
    public SalesService(final SalesRepository salesRepository,
                        final SalesProductRepository salesProductRepository) {
        this.salesRepository = salesRepository;
        this.salesProductRepository = salesProductRepository;
    }

    public Optional<Sales> findSales(Long idSales){
        return salesRepository.findById(idSales)
                .map(sales -> {
                    sales.setSalesProductList(salesProductRepository.findBySales(sales));
                    return sales;
                });

    }
}
