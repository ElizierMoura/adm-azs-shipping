package com.elizier.testeMVN.dominio;

import com.elizier.testeMVN.dominio.dtos.ClientDTO;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

public class Client {

    private UUID id;
    private String nameClient;
    private String cnpj;
    public Client()
    {
    }

    public Client( UUID id, String nameClient, String cnpj )
    {
        this.id = id;
        this.nameClient = nameClient;
        this.cnpj = cnpj;
    }

    public Client(ClientDTO clientDTO)
    {
        this.id = clientDTO.getId();
        this.nameClient = clientDTO.getNameClient();
        this.cnpj = clientDTO.getCnpj();
    }

    public UUID getId() { return this.id; }
    public String getNameClient() { return this.nameClient; }
    public String getCnpj() { return this.cnpj; }

    public ClientDTO toClientDTO()
    {
        return new ClientDTO( this.id, this.nameClient, this.cnpj );
    }

}
