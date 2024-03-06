package com.elizier.testeMVN.application.adaptadores.controllers;

import com.elizier.testeMVN.dominio.dtos.ClientDTO;
import com.elizier.testeMVN.dominio.dtos.FreteDTO;
import com.elizier.testeMVN.dominio.ports.interfaces.FreteServicePort;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("frete")
public class FreteController {

    private final FreteServicePort freteServicePort;

    public FreteController( FreteServicePort freteServicePort )
    {
        this.freteServicePort = freteServicePort;
    }

    @GetMapping
    public ResponseEntity<List<FreteDTO>> buscarFrete( @RequestParam(defaultValue = "") Object param, @RequestParam(defaultValue = "0") Integer start, @RequestParam(defaultValue = "10") Integer pageSize)
    {
        return ResponseEntity.ok(freteServicePort.buscarFretes( param, start, pageSize));
    }

    @PostMapping
    void cadastrarFrete( @RequestBody FreteDTO freteDTO )
    {
        freteServicePort.salvar(freteDTO);
    }

    @PutMapping
    void atualizarFrete(  @RequestBody FreteDTO freteDTO )
    { freteServicePort.salvar(freteDTO);}

    @DeleteMapping("/{id}")
    void apagarFrete(@PathVariable UUID id)
    {
        freteServicePort.removerFrete( id );
    }

}
