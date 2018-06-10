package com.dmanioto.burger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dmanioto.burger.model.OrderItem;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>  {

	@Query("select max(os.id) from OrderItem os")
	Long inc();
	
}
