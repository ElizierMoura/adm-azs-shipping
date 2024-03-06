package com.elizier.testeMVN.infraestrutura.adaptadores.repositories;

import com.elizier.testeMVN.infraestrutura.adaptadores.entidades.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpringClientRepository extends JpaRepository<ClientEntity, UUID> {
}
