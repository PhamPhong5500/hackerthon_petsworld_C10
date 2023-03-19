package com.codegym.repository;

import com.codegym.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

//@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long>  {

    @Query("UPDATE CustomerDto c SET c.status = false WHERE c.id = :id")
    void removeCustomerById(@Param("id") Long id);
    public void deleteCustomersByStatus(Long id);
}
