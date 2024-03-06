package com.elizier.testeMVN.dominio.adaptadores.services;

import com.elizier.testeMVN.dominio.Client;
import com.elizier.testeMVN.dominio.Frete;
import com.elizier.testeMVN.dominio.dtos.ClientDTO;
import com.elizier.testeMVN.dominio.dtos.FreteDTO;
import com.elizier.testeMVN.dominio.ports.interfaces.FreteServicePort;
import com.elizier.testeMVN.dominio.ports.repositories.FreteRepositoryPort;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class FreteServiceImp implements FreteServicePort {

    private final FreteRepositoryPort freteRepositoryPort;

    public FreteServiceImp( FreteRepositoryPort freteRepositoryport )
    {
        this.freteRepositoryPort = freteRepositoryport;
    }

    @Override
    public List<FreteDTO> buscarFretes( Object param, Integer start, Integer pageSize )
    {
        List<Frete> fretes = this.freteRepositoryPort.buscarTodos( param, start, pageSize );
        List<FreteDTO> freteDtos = fretes.stream().map(Frete::toFreteDTO).collect(Collectors.toList());
        return freteDtos;
    }

    @Override
    public void salvar(FreteDTO freteDTO)
    {
        Frete frete = new Frete(freteDTO);
        this.freteRepositoryPort.salvar( frete );
    }

    @Override
    public void removerFrete(UUID id)
    {
        this.freteRepositoryPort.remover( id );
    }


}
