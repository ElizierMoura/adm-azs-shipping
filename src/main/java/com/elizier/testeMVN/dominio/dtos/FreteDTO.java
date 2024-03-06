package com.elizier.testeMVN.dominio.dtos;

import com.elizier.testeMVN.dominio.Field;

import java.util.List;
import java.util.UUID;

public class FreteDTO {

    private UUID id;
    private ClientDTO client;
    private String addressFrom;
    private String addressTo;
    private List<Field> fields;


    public FreteDTO( UUID id, ClientDTO client, String addressFrom, String addressTo, List<Field> fields )
    {
        this.id = id;
        this.client = client;
        this.addressFrom = addressFrom;
        this.addressTo = addressTo;
        this.fields = fields;
    }

    public String getAddressFrom()
    { return this.addressFrom; }

    public String getAddressTo()
    { return this.addressTo; }

    public ClientDTO getClientDTO()
    { return this.client; }

    public UUID getId()
    { return this.id; }

    public List<Field> getFields()
    { return this.fields; }
}
