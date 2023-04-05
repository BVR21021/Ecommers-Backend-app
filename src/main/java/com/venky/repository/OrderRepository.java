package com.venky.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.venky.model.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order,Integer>{

}