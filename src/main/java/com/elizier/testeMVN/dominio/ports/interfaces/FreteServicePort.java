package com.elizier.testeMVN.dominio.ports.interfaces;

import com.elizier.testeMVN.dominio.dtos.ClientDTO;
import com.elizier.testeMVN.dominio.dtos.FreteDTO;
import java.util.List;
import java.util.UUID;

public interface FreteServicePort {
    List<FreteDTO> buscarFretes( Object param, Integer start, Integer pageSize );

    void salvar( FreteDTO freteDTO );

    void removerFrete( UUID id );

}
