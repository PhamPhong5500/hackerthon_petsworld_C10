package com.codegym.repository;

import com.codegym.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IPartnerRepository extends JpaRepository<Partner, Long> {
    @Query("UPDATE PartnerDto c SET c.status = false WHERE c.id = :id")
    void removePartnerById(@Param("id") Long id);

    public void deletePartnersByStatus(Long id);
}
