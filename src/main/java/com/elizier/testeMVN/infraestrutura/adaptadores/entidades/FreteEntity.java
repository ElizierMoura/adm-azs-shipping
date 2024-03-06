package com.elizier.testeMVN.infraestrutura.adaptadores.entidades;

import com.elizier.testeMVN.dominio.Field;
import com.elizier.testeMVN.dominio.Frete;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.UUID;

@Entity
@Table( name = "freteTeste" )
public class FreteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "clientId")
    private ClientEntity clientEntity;
    private String addressFrom;
    private String addressTo;
    @JdbcTypeCode(SqlTypes.JSON)
    private List<Field> fields;

    public FreteEntity()
    {

    }

    public FreteEntity( Frete frete )
    {
        this.clientEntity = new ClientEntity(frete.getClient());
        this.addressFrom = frete.getAddressFrom();
        this.addressTo = frete.getAddressTo();
        this.fields = frete.getFields();
    }

    public void atualizar ( Frete frete )
    {
        this.addressFrom = frete.getAddressFrom();
        this.addressTo = frete.getAddressTo();
        this.fields = frete.getFields();
    }

    public Frete toFrete()
    {
        return new Frete(this.id, this.clientEntity.toClient(), this.addressFrom, this.addressTo, this.fields);
    }

}
