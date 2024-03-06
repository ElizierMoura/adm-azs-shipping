package com.elizier.testeMVN.dominio;

import com.elizier.testeMVN.dominio.dtos.ClientDTO;
import com.elizier.testeMVN.dominio.dtos.FreteDTO;
import com.elizier.testeMVN.dominio.Client;
import org.json.JSONArray;

import java.util.List;
import java.util.UUID;

public class Frete {

    private UUID id;
    private UUID clientId;
    private Client client;
    private String addressFrom;
    private String addressTo;
    private List<Field> fields;

    public Frete()
    {}

    public Frete(UUID id, Client client, String addressFrom, String addressTo, List<Field> fields )
    {
        this.id = id;
        //this.clientId = clientId;
        this.client = client;
        this.addressFrom = addressFrom;
        this.addressTo = addressTo;
        this.fields = fields;
    }

    public UUID getId()
    {
        return this.id;
    }

    public String getAddressFrom()
    { return this.addressFrom; }

    public String getAddressTo()
    { return this.addressTo; }

    public Client getClient()
    { return this.client; }

    public List<Field> getFields()
    { return this.fields; }

    public Frete(FreteDTO freteDTO)
    {
        this.id = freteDTO.getId();
        this.client = new Client( freteDTO.getClientDTO() );
        this.addressFrom = freteDTO.getAddressFrom();
        this.addressTo = freteDTO.getAddressTo();
        this.fields = freteDTO.getFields();
    }

    public FreteDTO toFreteDTO( )
    {
        return new FreteDTO( this.id, this.client.toClientDTO(), this.addressFrom, this.addressTo, this.fields);
    }

}
