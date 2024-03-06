package com.elizier.testeMVN.application.adaptadores.controllers;

import com.elizier.testeMVN.dominio.dtos.ClientDTO;
import com.elizier.testeMVN.dominio.ports.interfaces.ClientServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("client")
public class ClientController {

    private final ClientServicePort clientServicePort;

    public ClientController(ClientServicePort clientServicePort )
    {
        this.clientServicePort = clientServicePort;
    }

    @PostMapping("")
    void criarCliente(@RequestBody ClientDTO c)
    {
        clientServicePort.criarClient(c);
    }

    @GetMapping("")
    public ResponseEntity<List<ClientDTO>> buscarClientes( )
    {
        return ResponseEntity.ok(clientServicePort.buscarClientes( ));
    }


}
