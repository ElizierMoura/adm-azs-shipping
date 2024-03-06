package com.elizier.testeMVN.dominio.ports.repositories;

import com.elizier.testeMVN.dominio.Client;
import com.elizier.testeMVN.dominio.Frete;
import com.elizier.testeMVN.dominio.dtos.ClientDTO;

import java.util.List;
import java.util.UUID;

public interface FreteRepositoryPort {

    List<Frete> buscarTodos(Object param, Integer start, Integer pageSize);

    void salvar( Frete frete );

    void remover( UUID id );

}
