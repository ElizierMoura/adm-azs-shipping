# adm-azs-shipping

E aí, para facilitar o uso vou deixar aqui os Curls que realizam inserção e busca dos dados necessários:

1 - Criação do cliente: 
- Foi criado um endpoint para criar "cliente", bem simples só pra poder usar um FK vinculando alguém no frete:
Método **POST**
```bash
curl --location 'localhost:8080/client' \
--header 'Content-Type: application/json' \
--data '{
    "nameClient": "nome da empresa",
    "cnpj":"000.000.000/0000-12"
}'
```

- Além de criar ( **POST** ) também foi feito o método de buscar ( **GET** ):

```bash
curl --location 'localhost:8080/client'
```

Com isto, se tem os dados dos clientes e o ID dele para poder criar um registro de "frete".

<H1>Frete</H1>
1 - Cadastrar frete, aqui podemos realizar o cadatro de um frete: **POST**

```bash

curl --location 'localhost:8080/frete' \
--header 'Content-Type: application/json' \
--data '{
    "client": "ca82f874-a3dc-4f49-b817-705d218cba9f",
    "addressFrom": "Camargo, Rio Grande do Sul",
    "addressTo": "Passo Fundo, Rio Grande do Sul",
    "fields": [
        {
            "key": "peso",
            "value": "132Kg"
        }
    ]
}'

```

Neste caso utilizei um campo que consiga armazenar de forma dinâmica os campos de cada frete, pois pelo que entendi cada cliente teria uma cadeia de propriedade em sua "configuração de conta" e a tabela frete deveria ser genérica. Por tanto defendi que o serviço de gerenciamento da configuração de conta teria responsábilidade sobre os campos obrigatórios ou não para cada cliente, já o serviço de gerenciamento de dados dos fretes apenas cumpriria o seu papel.

2 - Buscar fretes com paginação e busca em todos campos menos ( ID = "neste caso seria como usar um getById e não seria um search ) e também não inclui o client, mesmo sendo simples a inclusão. Optei por não colocar, após ter me confundido se isso seria o client que usaria ou o gerenciador. Porém é extremamente simples adicionar esse search ( nameClient e cnpj ), não acho interessante a inclusão do ID no search.
**GET**

```bash
curl --location 'localhost:8080/frete?param=Passo%20Fundo&start=1&pageSize=3'
```

3 - Para remover é muito simples: **DELETE**

```bash
curl --location --request DELETE 'localhost:8080/frete/{IDFRETE}' \
--data ''
```

4 - Para atualizar os dados ( sem ser ID e ClienteId ): **PUT** e desta vez enviar o ID junto com o body.

```bash
curl --location --request PUT 'localhost:8080/frete' \
--header 'Content-Type: application/json' \
--data '{
    "id": "33ad839a-83b5-4265-92fa-d82e3958d330",
    "client": "4574a0a0-5795-4052-88c5-c01688d979ba",
    "addressFrom": "Cidade do Lado",
    "addressTo": "Cidade do Outro Lado",
    "fields": [
        {
            "key": "peso",
            "value": "132Kg"
        }
    ]
}'
```


<h2>Docker</h2>
Utulizei de forma simples o Docker-Composer:
