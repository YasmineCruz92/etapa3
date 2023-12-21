package com.senacead.ProjetoIntegrador.controller;

import com.senacead.ProjetoIntegrador.model.Clientes;
import com.senacead.ProjetoIntegrador.model.Produtos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")

public class ClientesAPIController {
    @Autowired
    ClientesService clienteService;

    //cadastrar(C)
    @PostMapping("/adicionar")
    public ResponseEntity<Clientes> addLivro(@RequestBody Clientes cli) {
        var novoClientes = clienteService.criar(cli);
        return new ResponseEntity<>(novoClientes, HttpStatus.CREATED);
    }

    //listar(R)
    @GetMapping("/listar")
    public ResponseEntity<List> listar() {
        List<Clientes> clientes = clientesService.listarTodos();
        return new ResponseEntity<>(Clientes, HttpStatus.OK);
    }

    //buscar(R)
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Clientes> pesquisar(@PathVariable Integer id) {
        Clientes clienteEncontrado = clienteService.buscarPorId(id);
        return new ResponseEntity<>(clienteEncontrado, HttpStatus.OK);
    }

    //alterar(U)
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Clientes> editLivro(@PathVariable Integer id, @RequestBody Clientes cli) {
        var editarClientes = clienteService.atualizar(id, cli);
        return new ResponseEntity<>(editarClientes, HttpStatus.OK);
    }

    //excluir(D)
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        clienteService.excluir(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
