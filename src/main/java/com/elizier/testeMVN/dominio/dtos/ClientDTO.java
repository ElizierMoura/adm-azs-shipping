package com.elizier.testeMVN.dominio.dtos;

import java.util.UUID;

public class ClientDTO {

    private UUID id;
    private String nameClient;
    private String cnpj;
    public ClientDTO()
    {
    }

    public ClientDTO( String id ) { this.id = UUID.fromString(id); }

    public ClientDTO( UUID id, String nameClient, String cnpj )
    {
        this.id = id;
        this.nameClient = nameClient;
        this.cnpj = cnpj;
    }

    public String getNameClient()
    { return this.nameClient; }

    public String getCnpj()
    { return this.cnpj; }

    public UUID getId()
    { return this.id; }

}
