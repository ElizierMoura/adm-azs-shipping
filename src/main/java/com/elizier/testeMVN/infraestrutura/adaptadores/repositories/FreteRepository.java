package com.elizier.testeMVN.infraestrutura.adaptadores.repositories;

import com.elizier.testeMVN.dominio.Client;
import com.elizier.testeMVN.dominio.Frete;
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
public class FreteRepository  implements FreteRepositoryPort {

    private final SpringFreteRepository springFreteRepository;

    private final SpringClientRepository scp;

    public FreteRepository( SpringFreteRepository springFreteRepository , SpringClientRepository scp)
    {
        this.scp = scp;
        this.springFreteRepository = springFreteRepository;
    }

    @Override
    public List<Frete> buscarTodos(Object param, Integer start, Integer pageSize) {
        List<FreteEntity> freteEntities = this.springFreteRepository.findWithSearch( param, PageRequest.of(start, pageSize));
        return freteEntities.stream().map(FreteEntity::toFrete).collect(Collectors.toList());
    }

    @Override
    public void salvar(Frete frete) {
        FreteEntity freteEntity;
        if(Objects.isNull(frete.getId()))
            freteEntity = new FreteEntity( frete );
        else {
            freteEntity = this.springFreteRepository.findById( frete.getId()).get();
            freteEntity.atualizar(frete);
        }

        this.springFreteRepository.save(freteEntity);
    }

    @Override
    public void remover(UUID id)
    {
        FreteEntity entity = this.springFreteRepository.findById( id ).get();
        this.springFreteRepository.delete( entity );
    }
}
