package com.elizier.testeMVN.infraestrutura.configuracao;

import com.elizier.testeMVN.dominio.adaptadores.services.ClientServiceImp;
import com.elizier.testeMVN.dominio.adaptadores.services.FreteServiceImp;
import com.elizier.testeMVN.dominio.ports.interfaces.ClientServicePort;
import com.elizier.testeMVN.dominio.ports.interfaces.FreteServicePort;
import com.elizier.testeMVN.dominio.ports.repositories.ClientRepositoryPort;
import com.elizier.testeMVN.dominio.ports.repositories.FreteRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    FreteServicePort freteService(FreteRepositoryPort freteRepositoryPort)
    {
        return new FreteServiceImp(freteRepositoryPort);
    }

    @Bean
    ClientServicePort clientService(ClientRepositoryPort clientRepositoryPort )
    {
        return new ClientServiceImp( clientRepositoryPort);
    }

}
