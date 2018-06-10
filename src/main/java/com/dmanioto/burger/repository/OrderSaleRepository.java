package com.dmanioto.burger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dmanioto.burger.model.OrderSale;

@Repository
public interface OrderSaleRepository extends JpaRepository<OrderSale, Long> {

	@Query("select max(os.id) from OrderSale os")
	Long inc();
	
}
