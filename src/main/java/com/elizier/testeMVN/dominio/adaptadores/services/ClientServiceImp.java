package com.elizier.testeMVN.dominio.adaptadores.services;

import com.elizier.testeMVN.dominio.Client;
import com.elizier.testeMVN.dominio.dtos.ClientDTO;
import com.elizier.testeMVN.dominio.ports.interfaces.ClientServicePort;
import com.elizier.testeMVN.dominio.ports.repositories.ClientRepositoryPort;
import com.elizier.testeMVN.dominio.ports.repositories.FreteRepositoryPort;

import java.util.List;
import java.util.stream.Collectors;

public class ClientServiceImp implements ClientServicePort {

    private final ClientRepositoryPort clientRepositoryPort;

    public ClientServiceImp(ClientRepositoryPort clientRepositoryPort )
    {
        this.clientRepositoryPort = clientRepositoryPort;
    }

    @Override
    public void criarClient(ClientDTO c) {
        this.clientRepositoryPort.criarCliente( new Client( c ));
    }

    @Override
    public List<ClientDTO> buscarClientes() {
        List<Client> c = this.clientRepositoryPort.buscarClientes( );
        return c.stream().map(Client::toClientDTO).collect(Collectors.toList());
    }
}
