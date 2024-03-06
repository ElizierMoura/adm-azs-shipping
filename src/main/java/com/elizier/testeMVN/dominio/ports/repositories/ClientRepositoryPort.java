package com.elizier.testeMVN.dominio.ports.repositories;

import com.elizier.testeMVN.dominio.Client;
import com.elizier.testeMVN.dominio.Frete;

import java.util.List;
import java.util.UUID;

public interface ClientRepositoryPort {

    void criarCliente(Client client);

    List<Client> buscarClientes();
}
