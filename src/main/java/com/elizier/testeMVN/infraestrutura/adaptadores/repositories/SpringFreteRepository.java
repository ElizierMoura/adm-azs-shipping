package com.elizier.testeMVN.infraestrutura.adaptadores.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.elizier.testeMVN.infraestrutura.adaptadores.entidades.FreteEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SpringFreteRepository  extends JpaRepository<FreteEntity, UUID> {

    @Query("SELECT f as teste FROM FreteEntity f  WHERE Lower( f.addressFrom ) Like Lower(concat('%', ?1 , '%')) OR Lower(f.addressTo) Like Lower(concat('%', ?1 , '%')) OR Lower(cast( f.fields as text )) Like Lower(concat('%', ?1 , '%')) ")
    List<FreteEntity> findWithSearch( Object param, Pageable pageable);
}
