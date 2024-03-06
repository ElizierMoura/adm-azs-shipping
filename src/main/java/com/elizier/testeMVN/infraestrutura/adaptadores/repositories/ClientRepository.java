package com.elizier.testeMVN.infraestrutura.adaptadores.repositories;

import com.elizier.testeMVN.dominio.Client;
import com.elizier.testeMVN.dominio.Frete;
import com.elizier.testeMVN.dominio.ports.repositories.ClientRepositoryPort;
import com.elizier.testeMVN.dominio.ports.repositories.FreteRepositoryPort;
import com.elizier.testeMVN.infraestrutura.adaptadores.entidades.ClientEntity;
import com.elizier.testeMVN.infraestrutura.adaptadores.entidades.FreteEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class ClientRepository implements ClientRepositoryPort {


    private final SpringClientRepository scp;

    public ClientRepository( SpringClientRepository scp)
    {
        this.scp = scp;
    }

    @Override
    public void criarCliente(Client client) {
        ClientEntity c = new ClientEntity( client );

        this.scp.save(c);
    }

    @Override
    public List<Client> buscarClientes() {
        List<ClientEntity
                > clientes = this.scp.findAll();
        return clientes.stream().map(ClientEntity::toClient).collect(Collectors.toList());
    }
}
