package com.codegym.repository;

import com.codegym.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceRepository extends JpaRepository<Service, Long> {
    Service findServiceByName(String name);
}
