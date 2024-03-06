package com.elizier.testeMVN.infraestrutura.adaptadores.entidades;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table( name = "client" )
public class ClientEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private UUID id;
        private String nameClient;
        private String cnpj;
        public ClientEntity()
        {
        }

        public ClientEntity(com.elizier.testeMVN.dominio.Client client)
        {
                this.id = client.getId();
                this.nameClient = client.getNameClient();
                this.cnpj = client.getCnpj();
        }

        public com.elizier.testeMVN.dominio.Client toClient()
        {
                return new com.elizier.testeMVN.dominio.Client(this.id, this.nameClient, this.cnpj );
        }

}
