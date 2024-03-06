package com.elizier.testeMVN.dominio;

public class Field {

    private String key;
    private Object value;

    void Field()
    {}

    void Field ( String key, Object value )
    {
        this.key = key;
        this.value = value;
    }

    public String getKey( )
    { return this.key; }

    public Object getValue( )
    { return this.value; }


}
